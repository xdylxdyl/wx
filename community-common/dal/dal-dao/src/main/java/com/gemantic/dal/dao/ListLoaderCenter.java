package com.gemantic.dal.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.listloader.impl.CommonListLoader;
import com.gemantic.dal.dao.listloader.impl.CrossAggrListLoader;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;

/**
 * 
 * @author arthurkang
 *
 */
public class ListLoaderCenter implements ListLoader{

	private Map<Integer, ListLoader> listLoaders ;

	private static ListLoaderCenter center;
	
	private ListLoaderCenter(){
		listLoaders = new HashMap<Integer, ListLoader>();
		listLoaders.put(Constants.COMMON_TYPE, new CommonListLoader());
		listLoaders.put(Constants.CROSSDB_TYPE,new CrossAggrListLoader());
	}
	
	public static ListLoaderCenter getInstance(){
		if(null == center){
			synchronized (ListLoaderCenter.class) {
				if(null ==center){
					center = new ListLoaderCenter();
				}
			}
		}
		return center;
	}

	public ListInfoHelper getListInfo(Object account_id, LsCacheInfoHelper lsHelper,int strategy,boolean needLock) throws DaoException {
		ListLoader loader = listLoaders.get(ObjectUtil.getListType(lsHelper.getRegion()));
		ListInfoHelper infoHelper = null;
		if(null != loader){
			infoHelper =loader.getListInfo(account_id, lsHelper, strategy,needLock);
		}
		return infoHelper;
	}

	public List getSectionIdList(LsCacheInfoHelper lsHelper, ListInfoHelper infoHelper,Object account_id, Long sectionNo, int strategy,boolean needLock)	throws DaoException {
		ListLoader loader = listLoaders.get(ObjectUtil.getListType(lsHelper.getRegion()));
		List list = new ArrayList();
		if(null != loader){
			list =loader.getSectionIdList(lsHelper, infoHelper, account_id, sectionNo, strategy,needLock);
		}
		return list;
	}

	public SectionInfo getUpdatedSection( Object account_id, Object obj,LsCacheInfoHelper lsHelper) throws Exception{
		ListLoader loader = listLoaders.get(ObjectUtil.getListType(lsHelper.getRegion()));
		SectionInfo sectionInfo= null;
		if(null != loader){
		    sectionInfo = loader.getUpdatedSection(account_id, obj, lsHelper);
		}
		return sectionInfo;
	}

	public void removeIdFromList(Object account_id, Object obj,SectionInfo secInfo, boolean reload) throws Exception {
	   if(null != secInfo && null != secInfo.getLsHelper() && null != secInfo.getLsHelper().getRegion()){
		  ListLoader loader = listLoaders.get(ObjectUtil.getListType(secInfo.getLsHelper().getRegion()));
		 if(null != loader){
           loader.removeIdFromList(account_id, obj, secInfo, reload);
	   	 }
	  }
	}

}
