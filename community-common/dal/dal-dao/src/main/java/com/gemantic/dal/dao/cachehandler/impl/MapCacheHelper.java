package com.gemantic.dal.dao.cachehandler.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.model.MapInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.ObjectUtil;

public class MapCacheHelper {

	private static Log log = LogFactory.getLog(MapCacheHelper.class);
	
	public static void removeFromCache(Object object) throws Exception{	
		List<MapInfo> oldMaps = ObjectUtil.getMapInfoList(object);
		for (MapInfo info : oldMaps) {
			Cache cache = CacheHelper.getListCache(info.getRegion());
			if (null == cache) {
	            LogHelper.cacheDontConfigured(log,info.getRegion());
				continue;
			}
			//
			// 重要逻辑：此处是delete,而非remove,这样在get的时候就不会装载出已删除的数据
			cache.remove(info.getKey());
		}
	}

	public static void updateToCache(Object object) throws Exception {
		List<MapInfo> newMaps = ObjectUtil.getMapInfoList(object);
		for (MapInfo info : newMaps) {
			Cache cache = CacheHelper.getListCache(info.getRegion());
			if(null == cache){
	          LogHelper.cacheDontConfigured(log, info.getRegion());
			  continue;
			}
			cache.put(info.getKey(), info.getValue());
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
