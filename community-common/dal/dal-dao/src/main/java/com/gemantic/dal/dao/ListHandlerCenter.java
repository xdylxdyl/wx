package com.gemantic.dal.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.cachehandler.ListHandler;
import com.gemantic.dal.dao.cachehandler.impl.CommonListHandler;
import com.gemantic.dal.dao.cachehandler.impl.CrossListHandler;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.listloader.impl.CommonListLoader;
import com.gemantic.dal.dao.listloader.impl.CrossAggrListLoader;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;

/**
 * save/update/delete 下对缓存的更新 -------------- 特点：天下大事，合久必分，分久必合，分分合合，蕴含着多少的思考
 * @author arthurkang
 *
 */

public class ListHandlerCenter  {

	private Map<Integer, ListHandler> listHandlers ;
	
	private static Log log = LogFactory.getLog(ListHandlerCenter.class);

	private static ListHandlerCenter center;
	
	//很简单的单例模式，向外提供因为对象的Save/Update/Delete 操作，导致其所对应的各种List发生变更的解决方案
	private ListHandlerCenter(){
		listHandlers = new HashMap<Integer, ListHandler>();
		listHandlers.put(Constants.COMMON_TYPE, new CommonListHandler());
		listHandlers.put(Constants.CROSSDB_TYPE,new CrossListHandler());
	}
	
	public static  ListHandlerCenter getInstance(){
		if(null == center){
			synchronized ( ListHandlerCenter.class) {
				if(null ==center){
					center = new  ListHandlerCenter();
				}
			}
		}
		return center;
	}
	/**
	 * 保存 对象在save之前，缓存中的状况，因此仅处理某个 Object 配置了缓存的 List 
	 * @param account_id
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Map<Integer,List<SectionInfo>> getSavedInfos(Object account_id, Object obj) throws Exception {
		List<LsCacheInfoHelper> allInfolist = ObjectUtil.getLsInfoList(obj);
		List<LsCacheInfoHelper> commonInfoList = new ArrayList<LsCacheInfoHelper>();
		List<LsCacheInfoHelper> crossInfoList =  new ArrayList<LsCacheInfoHelper>();
		
		for(LsCacheInfoHelper lsHelper :allInfolist){
			Integer type = lsHelper.getType();
			String  region = lsHelper.getRegion();
			Cache cache = CacheHelper.getListCache(region);
			if(null != cache){
		    	if(null == type || 1 == type){
			 	   commonInfoList.add(lsHelper);
			     }
		     	else if( 2 == type){
			    	crossInfoList.add(lsHelper);
			    }
			}
		}
		List<SectionInfo> commonSecs  = null;
		List<SectionInfo> crossSecs   = null;
		
		if(commonInfoList.size() > 0){
			commonSecs = listHandlers.get(Constants.COMMON_TYPE).getSavedInfos(account_id, obj, commonInfoList);
		}
        if(crossInfoList.size() > 0){
        	crossSecs = listHandlers.get(Constants.CROSSDB_TYPE).getSavedInfos(account_id, obj, crossInfoList);
        }

        Map<Integer,List<SectionInfo>> allSecInfos = new HashMap<Integer,List<SectionInfo>>();
		if(null != commonSecs && commonSecs.size() >0){
			allSecInfos.put(Constants.COMMON_TYPE, commonSecs);
		}
		if(null != crossSecs && crossSecs.size() >0){
			allSecInfos.put(Constants.CROSSDB_TYPE, crossSecs);
		}
		return allSecInfos;
	}


	/**
	 * 保存 对象在save之前，缓存中的状况，因此仅处理某个 Object 配置了缓存的 List 
	 * @param account_id
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void processBatchSavedInfos(Object account_id, List objs) throws Exception {
		Map<String,List<LsCacheInfoHelper>> commonInfoMap = new HashMap<String,List<LsCacheInfoHelper>>();
		for(Object obj : objs){
			List<LsCacheInfoHelper> singleObjLs = ObjectUtil.getLsInfoList(obj);
			for(LsCacheInfoHelper lsHelper : singleObjLs){
				Integer type = lsHelper.getType();
				String  region = lsHelper.getRegion();
				//注意:目前仅处理Common 类型的List
				if(null == type || 1 == type){
					Cache cache = CacheHelper.getListCache(region);
					if(null != cache){
					   List  objList = commonInfoMap.get(region);
					   if(null == objList){
						   objList = new ArrayList();
						   commonInfoMap.put(region, objList);
					   }
					   
					   objList.add(lsHelper);
					}				
				}
			}
		}
       if(commonInfoMap.size() > 0){
    	   listHandlers.get(Constants.COMMON_TYPE).processBatchedSave(commonInfoMap);
       }
	}
	
	public void processSave(Object account_id, Object obj, Map<Integer,List<SectionInfo>> saveInfos) throws Exception {// TODO Auto-generated method stub
		Iterator<Integer> iter = saveInfos.keySet().iterator();
		while(iter.hasNext()){
			Integer type = iter.next();
			List<SectionInfo> secInfos = saveInfos.get(type);
			listHandlers.get(type).processSave(account_id, obj,secInfos);
		}
	}	
	public Map<Integer, List<SectionInfo>> getDeleteInfos(Object account_id,Object obj)throws Exception {
		List<LsCacheInfoHelper> allInfolist = ObjectUtil.getLsInfoList(obj);
		List<LsCacheInfoHelper> commonInfoList = new ArrayList<LsCacheInfoHelper>();
		List<LsCacheInfoHelper> crossInfoList =  new ArrayList<LsCacheInfoHelper>();
		
		for(LsCacheInfoHelper lsHelper :allInfolist){
			Integer type = lsHelper.getType();
			String  region = lsHelper.getRegion();
			Cache cache = CacheHelper.getListCache(region);
			if(null != cache){
			   if(null == type || 1 == type){
				commonInfoList.add(lsHelper);
			   }
			  else if( 2 == type){
				crossInfoList.add(lsHelper);
			  }
			}
		}
		
		List<SectionInfo> commonSecs  = null;
		List<SectionInfo> crossSecs   = null;
		if(commonInfoList.size() > 0){
			commonSecs     =  listHandlers.get(Constants.COMMON_TYPE).getDeleteInfos(account_id, obj, commonInfoList);
		}
		if(crossInfoList.size() >0 ){
			crossSecs      =  listHandlers.get(Constants.CROSSDB_TYPE).getDeleteInfos(account_id, obj, crossInfoList);
		}
		
		Map<Integer,List<SectionInfo>> allSecInfos = new HashMap<Integer,List<SectionInfo>>();
		if(null != commonSecs && commonSecs.size() >0){
			allSecInfos.put(Constants.COMMON_TYPE, commonSecs);
		}
		if(null != crossSecs && crossSecs.size() >0){
			allSecInfos.put(Constants.CROSSDB_TYPE, crossSecs);
		}
		return allSecInfos;
	}

	public void processDelete(Object account_id, Class clazz, Object obj,Map<Integer, List<SectionInfo>> delInfos) throws Exception {
		Iterator<Integer> iter = delInfos.keySet().iterator();
		while(iter.hasNext()){
			Integer type = iter.next();
			List<SectionInfo> secInfos = delInfos.get(type);
			listHandlers.get(type).processDelete(account_id, clazz, obj,secInfos);
		}
		
	}

	public Map<Integer,UpdateInfo> getUpdateInfos(Object account_id, Object obj,Object oldObj) throws Exception {
         Map<Integer,UpdateInfo> allUpdateInfo = new HashMap<Integer,UpdateInfo>();
         
 		List<LsCacheInfoHelper> allInfolist = ObjectUtil.getLsInfoList(obj);
 		//用户在dao.xml中配置的  《基本类型》的List集合
 		Map<String, LsCacheInfoHelper> commonInfoMap = new HashMap<String, LsCacheInfoHelper>();
		//用户在dao.xml中配置的，《跨库查询类型》的List集合
 		Map<String, LsCacheInfoHelper> crossInfoMap =  new HashMap<String, LsCacheInfoHelper>();
		
		//====================== 将 <更新后的新对象> 所对应的各种List分类存储   ==================================
		for(LsCacheInfoHelper lsHelper :allInfolist){
			Integer type = lsHelper.getType();
			String  region = lsHelper.getRegion();
			Cache cache = CacheHelper.getListCache(region);
			if(null != cache){
			   if(null == type || Constants.COMMON_TYPE == type){
				commonInfoMap.put(region, lsHelper);
	    		}
		    	else if( Constants.CROSSDB_TYPE == type){
				crossInfoMap.put(region, lsHelper);
		    	}
			}
		}
		
 		List<LsCacheInfoHelper> oldAllInfolist = ObjectUtil.getLsInfoList(oldObj);
 		Map<String, LsCacheInfoHelper> oldCommonInfoMap = new HashMap<String, LsCacheInfoHelper>();
 		Map<String, LsCacheInfoHelper> oldCrossInfoMap =  new HashMap<String, LsCacheInfoHelper>();
		
		//===================== 将 <更新前的旧对象> 所对应的各种List分类存储
		for(LsCacheInfoHelper lsHelper :oldAllInfolist){
			Integer type = lsHelper.getType();
			String  region = lsHelper.getRegion();
			Cache cache = CacheHelper.getListCache(region);
			if(null != cache){
		    	if(null == type || 1 == type){
				 oldCommonInfoMap.put(region, lsHelper);
			    }
			    else if( 2 == type){
				  oldCommonInfoMap.put(region, lsHelper);
			    }
			}
		}
         
         UpdateInfo commonUpdateInfo  =  null;
         UpdateInfo crossUpdateInfo   =  null;
         
         if(oldCommonInfoMap.size() > 0){
        	 commonUpdateInfo = listHandlers.get(Constants.COMMON_TYPE).getUpdateInfos(account_id, obj, oldObj,commonInfoMap,oldCommonInfoMap);
         }
         if(oldCrossInfoMap.size() > 0){
        	 crossUpdateInfo =  listHandlers.get(Constants.CROSSDB_TYPE).getUpdateInfos(account_id, obj, oldObj,crossInfoMap, oldCrossInfoMap);
         }	 

         if(null != commonUpdateInfo){
        	 allUpdateInfo.put(Constants.COMMON_TYPE, commonUpdateInfo);
         }
         if(null != crossUpdateInfo){
        	 allUpdateInfo.put(Constants.CROSSDB_TYPE, crossUpdateInfo);
         }
         return allUpdateInfo;
	}

	public void processUpdate(Object account_id, Class clazz, Object oldObj,Object obj,Map<Integer,UpdateInfo> updateInfos) throws Exception {
		Iterator<Integer> iter = updateInfos.keySet().iterator();
		while(iter.hasNext()){
			Integer type = iter.next();
			UpdateInfo updateInfo = updateInfos.get(type);
			listHandlers.get(type).processUpdate(account_id, clazz, oldObj, obj,updateInfo);
		}
		
	}


	
}
