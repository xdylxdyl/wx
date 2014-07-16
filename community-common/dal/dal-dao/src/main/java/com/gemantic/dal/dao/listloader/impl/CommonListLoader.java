package com.gemantic.dal.dao.listloader.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.DBAgent;
import com.gemantic.dal.dao.ListLoader;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.helper.VisitHelper;
import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.route.strategy.IStrategy;

public class CommonListLoader implements ListLoader {
	
	private static Log log = LogFactory.getLog(CommonListLoader.class);
	
	public ListInfoHelper getListInfo(Object account_id,LsCacheInfoHelper lsHelper, int strategy,boolean needLock) throws DaoException {
		ListInfoHelper infoHelper = null;
		Long lock = null;
		try{
	    ListInfo info = CacheHelper.getListInfo(lsHelper);
		if (null == info) {
			if(needLock){
				//判断该List，是否在被 save/update/delete,或被其他用户加载
				lock = VisitHelper.getInstance().checkLsInLoading(lsHelper);
			    //重要逻辑 :加锁失败，则直接返回 
				if(null == lock){
					return infoHelper;
				}
			}
			List objList =DBAgentHibernateImpl.getInstance().getObjectList(account_id, lsHelper.getRegion(),SqlUtil.getListCountSql(lsHelper),0l, 1l, strategy, true, false);
			info = new ListInfo(new Long(""+objList.get(0)));
			CacheHelper.putListInfo(lsHelper,info.getSize());
		}
		infoHelper = new ListInfoHelper(info);
		}
		catch(Exception e){
			processException(e);
		}
		finally{
			if(null != lock){
				VisitHelper.getInstance().endLsLoading(lsHelper, lock);
			}
			
		}
		return infoHelper;
	}
	
	/**
	 * 心得 ：该方法目前在 4个地方 被调用，分别是
	 *      1,2 removeIdFromList，getUpdatedSection        --->对应update/delete的操作
 	 *      3.AbstractListHandler.getSavedInfos(.....)     --->对应save的操作
	 *      4.CompositeDaoImpl.getIdList(.....)
	 *      
	 *      在第 4 个调用地方，已判定此时是否有人同时在加载，以防止重复加载
	 * 
	 * 重要结论： 不需要在这个方法中，判定是否有人正在调用该方法，判定的逻辑，是在调用该方法的方法中 实现的。 
	 *       
	 */
	
	public List getSectionIdList(LsCacheInfoHelper lsHelper,ListInfoHelper infoHelper, Object account_id, Long sectionNo,int strategy,boolean needLock) throws DaoException{	
		List idList = new ArrayList();
		Long     listInfoLock = null;
		Long     sectionLock = null;
        try{
        	boolean bLoading = false;
        	if(null == infoHelper){
			   infoHelper = getListInfo(account_id, lsHelper, strategy,needLock);
			   if(null == infoHelper){
				   return idList;
			   }
		    }
        	if(sectionNo > infoHelper.getMaxSectionNo()){
              LogHelper.failedLoadListSection(log, lsHelper, infoHelper, sectionNo);
		      return idList;
		    }
		  
        	if (infoHelper.isVisited(sectionNo)) {
			  idList = (List) CacheHelper.get(lsHelper.getRegion(),lsHelper.getIdListKey(new Long(sectionNo)));
			  if (null == idList || idList.size() < 1) {
				  bLoading = true;
			   }
		    } 
		    else
		    {
			  //重要逻辑： 因为此时要对缓存中的ListInfo对象进行变更，所以需要首先判定是否有其他用户，在对该ListInfo对象进行变更
			  if(needLock){
				//判断该List，是否在被 save/update/delete,或被其他用户加载
				listInfoLock = VisitHelper.getInstance().checkLsInLoading(lsHelper);
				//加锁失败，则返回空List
				if(null == listInfoLock){
					return idList;
				}			
			   }
			   infoHelper.addSection(new Long(sectionNo));
			   CacheHelper.put(lsHelper.getRegion(), lsHelper.getListVisitInfoKey(), infoHelper.getVisitedSections());
			   // 非常关键
			   CacheHelper.remove(lsHelper.getRegion(), lsHelper.getIdListKey(sectionNo));
			   bLoading = true;  
		    }
		    
		    if (bLoading) {
			//重要逻辑： 因为此时要对缓存中某个List的某一段 section 进行加载，所以需要首先判定是否有其他用户，在对该section进行变更
			//非常重要 ：*****对缓存中ListInfo加载动作的加锁，与加载该ListInfo 的某一段 section，是没有关系的
			    if(needLock){
			    	sectionLock = VisitHelper.getInstance().checkIdLsLoad(lsHelper);
			    	if(null == sectionLock){
			    		return idList;
			    	}
			    }
			    Long startIndex = infoHelper.getSectionIndex(sectionNo);
			    Long secSize = infoHelper.getSectionSize(sectionNo);
			    idList = DBAgentHibernateImpl.getInstance().getObjectList(account_id, lsHelper.getRegion(),SqlUtil.getListSql(lsHelper, true), startIndex,secSize, strategy, true, false);
			    if (null != idList && idList.size() > 0) {
			    	List rvList = new ArrayList();
			    	for(int i=idList.size()-1;i>=0;i-- ){
			    		rvList.add(idList.get(i));
			    	}
			    	idList = rvList;
			        CacheHelper.put(lsHelper.getRegion(), lsHelper.getIdListKey(sectionNo),rvList);
			    }
			    else {
			    	CacheHelper.removeListInfo(lsHelper);
				    LogHelper.failedLoadOneListSection(log, lsHelper, sectionNo);
			    }
		   }
		}
		catch(Exception e){
			processException(e);
		}
		finally{
			if(needLock){
				if(null != listInfoLock){
					VisitHelper.getInstance().endLsLoading(lsHelper, listInfoLock);
				}
				if(null != sectionLock){
					VisitHelper.getInstance().endIdLsLoading(lsHelper, sectionLock);
				}
			}
		}
		return idList;
	}
	
	public SectionInfo getUpdatedSection( Object account_id, Object obj,LsCacheInfoHelper lsHelper) throws Exception{
		SectionInfo sectionInfo = null;
		ListInfoHelper infoHelper = getListInfo(account_id, lsHelper, IStrategy.STRATEGY_W,Constants.NoLock);
		Object objValueOfLs = ObjectUtil.getObjectValueOfList(obj, lsHelper);

		for (long sectionNo = infoHelper.getMaxSectionNo(); sectionNo >= 0; sectionNo--) {
			List idList = getSectionIdList(lsHelper, infoHelper, account_id,sectionNo, IStrategy.STRATEGY_W,Constants.NoLock );
			if (null == idList || idList.size() < 1) {
				break;
			}
			long index = idList.indexOf(objValueOfLs);
			if (index >= 0) {
				sectionInfo = new SectionInfo(sectionNo, infoHelper, idList,lsHelper, null);
				break;
			}
		}
		if (null == sectionInfo) {
			LogHelper.failedFindIdFromList(log, lsHelper, objValueOfLs);
		}
		return sectionInfo;
	}
	
	public void removeIdFromList(Object account_id, Object obj,SectionInfo secInfo, boolean bReload) throws Exception{	
		ListInfoHelper infoHelper = secInfo.getInfoHelper();
		LsCacheInfoHelper lsHelper= secInfo.getLsHelper();
    	infoHelper.removeId(secInfo.getSectionNo());

		if (infoHelper.isSectionsReBuild()) {
			CacheHelper.removeListInfo(lsHelper);
			if (bReload) {
				long oldSectionNo = secInfo.getSectionNo();
				if(oldSectionNo > 0){
					oldSectionNo = oldSectionNo -1;
				}
				infoHelper = getListInfo(account_id, lsHelper, IStrategy.STRATEGY_W,Constants.NoLock);
				for (long i = oldSectionNo; i <= infoHelper.getMaxSectionNo(); i++) {
					List idList = getSectionIdList(secInfo.getLsHelper(),null,account_id, i, IStrategy.STRATEGY_W,Constants.NoLock);
					if(null == idList || idList.size() <1){
						break;
					}
				}
			}
		}
		else{
		  //重要提示:删除一个Id时，未采用Memcached的递减机制
		  CacheHelper.putListInfo(lsHelper, infoHelper.getListInfo());
		  List idList = secInfo.getIdList();
		  idList.remove(ObjectUtil.getObjectValueOfList(obj, lsHelper)); 
		  CacheHelper.put(lsHelper.getRegion(), secInfo.getLsHelper().getIdListKey(secInfo.getSectionNo()), idList);
		}
	}
	
	private static void processException(Exception e) throws DaoException {
		e.printStackTrace(System.out);
		if (e instanceof MappingException) {
			throw new DaoException(DaoException.POJO_NOTFOUND_EXCEPTION, e);
		} else if (e instanceof NullPointerException) {
			throw new DaoException(DaoException.NULLPOINTER_EXCEPTION, e);
		} else if (e instanceof SQLException) {
			throw new DaoException(DaoException.SQL_EXCEPTION, e);
		} else if (e instanceof HibernateException) {
			throw new DaoException(DaoException.Hibernate_Exception, e);
		} else if (e instanceof StrategyException) {
			throw new DaoException(DaoException.Strategy_Exception, e);
		} else if (e instanceof DaoException) {
			throw (DaoException) e;
		} else {
			throw new DaoException(e);
		}
	}
}
