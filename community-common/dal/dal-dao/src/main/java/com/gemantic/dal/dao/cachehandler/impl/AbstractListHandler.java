package com.gemantic.dal.dao.cachehandler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gemantic.dal.dao.ListLoaderCenter;
import com.gemantic.dal.dao.cachehandler.ListHandler;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;

public abstract class AbstractListHandler implements ListHandler {

	private static Log log = LogFactory.getLog(AbstractListHandler.class);

	/**
	 * 批量保存时的处理逻辑：
	 * 设计理念： 判断对应的List是否在缓存中，发现即删除   ^_^ 简单粗暴，但略显复杂
	 */
	public void processBatchedSave(Map<String, List<LsCacheInfoHelper>> lsMap) throws Exception {
		Iterator<String> regionIter = lsMap.keySet().iterator();
		while(regionIter.hasNext()){
			String region = regionIter.next();
			List<LsCacheInfoHelper> lsHelperList= lsMap.get(region);
			if(null != lsHelperList && lsHelperList.size() >0){
				List  cntKeyList = new ArrayList();
				for(LsCacheInfoHelper lsHelper : lsHelperList){
					cntKeyList.add(lsHelper.getListCountKey());
				}
				if(cntKeyList.size() > 0){
				  Object[]  cntLs = (Object[])CacheHelper.gets(region,cntKeyList);
				   if(null != cntLs){
				      for(int i=0; i<cntLs.length ;i++){
					    if(null != cntLs[i]){
					      //重要逻辑:从Memcached中批量取数据时，如果某个数据在缓存中不存在会返回 null
					      CacheHelper.increaseListSize(lsHelperList.get(i));	
					      CacheHelper.removeListVisitedInfo(lsHelperList.get(i));
					    }
				      }//for
				   }//if
				}//if
			}
		}//while		
	}
	
	public List<SectionInfo> getSavedInfos(Object account_id,Object obj,List<LsCacheInfoHelper> infoHelperList) throws Exception{	
		List<SectionInfo> saveInfos = new ArrayList<SectionInfo>();
		if(null == infoHelperList || infoHelperList.size() <1){
			return saveInfos;
		}
        // 判断被保存的对象是否   读/写 分离 			
		boolean bRAndW = RoutingService.getInstance().isReadWrite(obj.getClass(),account_id);	
		
		for (LsCacheInfoHelper lsHelper : infoHelperList) {
			if(lsHelper.isInvalidOnSave()){
				CacheHelper.removeListInfo(lsHelper);
				continue;
			}
			ListInfoHelper infoHelper = null;
			ListInfo info =  CacheHelper.getListInfo(lsHelper);	
			//处理逻辑一 :判断List是否曾经被访问过
			if(null == info){
				if(bRAndW){
					List objList =DBAgentHibernateImpl.getInstance().getObjectList(account_id, lsHelper.getRegion(),SqlUtil.getListCountSql(lsHelper),0l, 1l,IStrategy.STRATEGY_W, true, false);
					info = new ListInfo(new Long(""+objList.get(0)));	
					infoHelper = new ListInfoHelper(info);
				}
				else{
					 continue;
				}
			}
			else{
				infoHelper = new ListInfoHelper(info);
			}

			//处理逻辑二:List曾经被访问过的处理逻辑
			//当前List的最大section no
			long currentMaxSecNo = infoHelper.getMaxSectionNo();
			//当新增对象成功后，List的最大section no
			long newMaxSecNo     = infoHelper.getNewMaxSectionNo(); 
			
			//情况一：非读写分离情况  --- 仅将List的size加1,并将List的最新一段section清空
			if(!bRAndW){
				//异常重要: 特殊情况下的处理逻辑,当保存一个对象向最新一段加id,但最新一段已经满了的情况
				if(infoHelper.getLatestSecSize().intValue() >= Constants.SecCapacity &&
						                             currentMaxSecNo == newMaxSecNo  && 
						                                     infoHelper.getSize() >=1){
					CacheHelper.removeListInfo(lsHelper);
					LogHelper.errorAddObjectToListSection(log, lsHelper, currentMaxSecNo);
					continue;
				}
				SectionInfo saveInfo = new SectionInfo(null,infoHelper,null,lsHelper,null);	
				saveInfos.add(saveInfo);
				continue;
			}
			//情况二: 读写分离情况      ---
			else{		
				//当前List，最新Section 的 IdList      ^_^
				List currentLatestSecList = null;
				//新增对象成功后，最新Section 的 IdList ^_^ ---> Two different smile
				List latestSecIdList = null;	
				boolean bReload = false;
				
				// 重要逻辑一 ： 新增的对象ID  会   导致ListInfo新增一个Section分段缓存
				if (currentMaxSecNo != newMaxSecNo || infoHelper.getSize() < 1) {
					   latestSecIdList = new ArrayList();
				}
				// 重要逻辑二 ： 新增的对象ID 不会 导致ListInfo新增一个Section分段缓存,大多数为这种情况
				else{
					//特殊情况: 这是Dal的特殊情况
				   if (infoHelper.getLatestSecSize().intValue() >= Constants.SecCapacity) {
						CacheHelper.removeListInfo(lsHelper);
						LogHelper.errorAddObjectToListSection(log, lsHelper, currentMaxSecNo);
						continue;
					}
					if (!infoHelper.isLatestSecVisited()) {
						bReload = true;
//						  infoHelper.addSectionInfo(currentMaxSecNo, infoHelper.getLatestSecSize());
//						  CacheHelper.put(lsHelper.getRegion(),lsHelper.getKey(), infoHelper.getListInfo());
						   // 重要逻辑：此处是为了防止脏数据的产生，如果listInfo中未标记某一段，则该段所对应的IDList也不应存在在缓存中
//	                      CacheHelper.remove(lsHelper.getRegion(), lsHelper.getIdListKey(currentMaxSecNo));
					}
					if(!bReload){
					    currentLatestSecList = (List)CacheHelper.get(lsHelper.getRegion(), lsHelper.getIdListKey(currentMaxSecNo));
					}
					if (null == currentLatestSecList || currentLatestSecList.size() < 1) {
						currentLatestSecList =
						ListLoaderCenter.getInstance().getSectionIdList(lsHelper, infoHelper, account_id, currentMaxSecNo, IStrategy.STRATEGY_W,Constants.NoLock);
						if (null == currentLatestSecList || currentLatestSecList.size() < 1) {
							continue;
						}
					}
					latestSecIdList=currentLatestSecList;
				}	
				SectionInfo saveInfo = new SectionInfo(newMaxSecNo,infoHelper,latestSecIdList,lsHelper,null);
				//这步操作，是为了配合CrossListHanlder
				if(null != latestSecIdList && latestSecIdList.size() >0){
				    saveInfo.setLatestId(latestSecIdList.get(latestSecIdList.size()-1));
				}
				saveInfos.add(saveInfo);
			}
		}//for
		return saveInfos;
	}
	
	public List<SectionInfo> getDeleteInfos(Object account_id,Object obj,List<LsCacheInfoHelper> infoList) throws Exception{
		List<SectionInfo> delInfos = new ArrayList<SectionInfo>();
    	boolean bRAndW = RoutingService.getInstance().isReadWrite(obj.getClass(),account_id);
	    for (LsCacheInfoHelper lsHelper : infoList) {
			ListInfoHelper infoHelper = null;
			ListInfo info = CacheHelper.getListInfo(lsHelper);
			if(null == info){
				if(bRAndW){
					List objList =DBAgentHibernateImpl.getInstance().getObjectList(account_id, lsHelper.getRegion(),SqlUtil.getListCountSql(lsHelper),0l, 1l,IStrategy.STRATEGY_W, true, false);
					info = new ListInfo(new Long(""+objList.get(0)));	
					infoHelper = new ListInfoHelper(info);
				}
				else{
					 continue;
				}
			}
			else{
				infoHelper = new ListInfoHelper(info);
			}
			//重要逻辑：如果用户从未访问过该List, 且是 非读写分离，则直接从缓存中删除该 List的数据
			if((!infoHelper.isSectionsVistied()) && (!bRAndW)){
			    CacheHelper.removeListInfo(lsHelper);
				LogHelper.listHasNotVisited(log, lsHelper.getRegion(),lsHelper.getKey());
				continue;
			}
			if(infoHelper.isSectionsReBuild()){
				CacheHelper.removeListInfo(lsHelper);
			    if(!bRAndW){
				   continue;
				}
			}
			SectionInfo delSec = ListLoaderCenter.getInstance().getUpdatedSection(account_id, obj, lsHelper);
		    if (null != delSec) {
				delInfos.add(delSec);
			}
	    }
       return delInfos;
	}
	
	public void processDelete(Object account_id, Class clazz,Object obj,List<SectionInfo> delInfos) throws Exception{
		if(null != delInfos && delInfos.size() >0){
			boolean bRW = RoutingService.getInstance().isReadWrite(clazz, account_id);
			if(null != delInfos){
			for(SectionInfo delInfo :delInfos){				
			   ListLoaderCenter.getInstance().removeIdFromList(account_id, obj,delInfo, bRW);
		     }
			}
		}
	}

	/**
	 * 参考 CommonListHandler --->getUpdateInfos 的说明,仅适合于非 主/从数据库分离的情况
	 * 
	 * 查找因对象更新，导致的数据将发生变化的与对象相关的List,此处仅考虑对象的KeyProperty 和 orderByProperty 两个属性
	 * 
	 * 场景一. 对象的更新，导致其KeyProperty发生了变化，此时会涉及到 2 个 List的变更
	 * 场景二. 对象的更新，不会导致其KeyProperty 发生变化，但会引起OrderByProperty的变化，此时仅涉及到 1个 List的变更,因为对象在该List中的位置发生了变化
	 * 场景三. 对象的更新，导致其存放在List中的值发生了变化,此时会涉及 1 个 List的变更 
	 * 
	 * Attention : 如果对象的变更，不会导致其对应某List的 KeyProperty和 orderByProperty 及其存放在该List中的 id 值发生变更，则不做任何处理
	 */
	public UpdateInfo getUpdateInfos(Object account_id,Object obj,Object oldObj,Map<String, LsCacheInfoHelper> newObjLsMap,Map<String, LsCacheInfoHelper> oldObjLsMap) throws Exception{
		   Map<String,LsCacheInfoHelper[]> changedLsHelpers = new HashMap<String,LsCacheInfoHelper[]>();
		   
    	   Iterator<String> iter = oldObjLsMap.keySet().iterator();	   
		   while (iter.hasNext()) {
			 String region = iter.next();
			 
			 LsCacheInfoHelper oldLsHelper = oldObjLsMap.get(region);
			 LsCacheInfoHelper newLsHelper = newObjLsMap.get(region);
			 
			 //Key 
			 String oldKey = oldLsHelper.getKey();
			 String newKey = newLsHelper.getKey();
			 
			 //Order by Property
			 String oldOrderByKey = oldLsHelper.getOrderByKey();
             String newOrderByKey = newLsHelper.getOrderByKey();
			 //Id 
			 Object  oldValueOfLs = ObjectUtil.getObjectValueOfList(oldObj, oldLsHelper);
			 Object  newValueOfLs = ObjectUtil.getObjectValueOfList(obj,newLsHelper);
			 
			 
			 // 场景 一 ：Object所对应的List的Key值发生变化的情况,此处涉及 2 个 List
			 if (!oldKey.equalsIgnoreCase(newKey)) {
					changedLsHelpers.put(region, new LsCacheInfoHelper[]{oldLsHelper,newLsHelper});
		     }
			// 场景 二　：Object 存放在 List中的值发生了变化           
			 else if(!oldValueOfLs.equals(newValueOfLs)){
				 changedLsHelpers.put(region, new LsCacheInfoHelper[]{newLsHelper});
			 }
			// 场景 三　：Object所对应的List 的Key值未发生变化，但用于排序的属性 发生了变化，此时List做失效处理,此处涉及 1 个List
			 else{
				 if(null != oldOrderByKey && oldOrderByKey.length() >0
						                  && !oldOrderByKey.equalsIgnoreCase(newOrderByKey)){
				 changedLsHelpers.put(region, new LsCacheInfoHelper[]{newLsHelper});
			    }
			 }
		   }
		return new UpdateInfo(changedLsHelpers,null,null);
	}
	
	/**
	 * 参考 CommonListHandler --->getUpdateInfos 的说明,仅适合于非 主/从数据库分离的情况
	 * 
	 * 简单粗暴的更新方式，直接从缓存中删除相应的List--- 我喜欢 ^_^
	 * 场景一 ： 会从缓存中删除 2 个List
	 * 场景二 ： 会从缓存中删除 1 个List
	 */
	public void processUpdate(Object account_id,Class clazz,Object oldObj,Object obj,UpdateInfo updateInfo) throws Exception{
		if(null != updateInfo && null != updateInfo.getChangedLsHelpers() && updateInfo.getChangedLsHelpers().size() > 0){
			Iterator<String> regionIter = updateInfo.getChangedLsHelpers().keySet().iterator();
			while(regionIter.hasNext()){
				String region = regionIter.next();
				LsCacheInfoHelper[] lsHelpers = updateInfo.getChangedLsHelpers().get(region);
				CacheHelper.removeListInfos(lsHelpers);
			}
		}
	}
}
