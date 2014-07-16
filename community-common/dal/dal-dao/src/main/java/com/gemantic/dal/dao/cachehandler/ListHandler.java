package com.gemantic.dal.dao.cachehandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.route.strategy.IStrategy;

public interface ListHandler {
	/**
	 * 和对象保存相关的两个方法
	 */
	public List<SectionInfo> getSavedInfos(Object account_id,Object obj,List<LsCacheInfoHelper> infoList) throws Exception;
	
	public void processSave(Object account_id,Object obj,List<SectionInfo> saveInfos ) throws Exception;
	
	/**
	 * 和对象删除相关的两个方法
	 */
	public List<SectionInfo> getDeleteInfos(Object account_id,Object obj,List<LsCacheInfoHelper> infoList) throws Exception;
	
	public void processDelete(Object account_id, Class clazz,Object obj,List<SectionInfo> delInfos) throws Exception;
	
	/**
	 * 和对象更新相关的两个方法
	 */
	public UpdateInfo getUpdateInfos(Object account_id,Object obj,Object oldObj,Map<String, LsCacheInfoHelper> newObjLsMap,Map<String, LsCacheInfoHelper> oldObjLsMap) throws Exception;
	
	public void processUpdate(Object account_id,Class clazz,Object oldObj,Object obj,UpdateInfo updateInfo) throws Exception;	
	
	/**
	 * 批量保存相关的方法
	 */
	public void processBatchedSave(Map<String,List<LsCacheInfoHelper>> lsMap) throws Exception;
}
