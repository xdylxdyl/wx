package com.gemantic.dal.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.FriendDao;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.DalAssert;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.datasource.ContextHolder;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;

public class FriendDaoImpl implements FriendDao {

	public List getMappings(List accountIdList, String mapname,List<Object[]> paramsList) throws DaoException {
		   DalAssert.assertObjectNotNull(accountIdList);
		   DalAssert.assertObjectNotNull(paramsList);
		   DalAssert.assertObjectNotNull(mapname);
		   List resList = new ArrayList();
		   try{
				Cache cache = CacheHelper.getListCache(mapname);
				// 缓存不存在情况下处理逻辑
				if(null == cache){
					Map<String ,List<Object[]>> dbParamsMap = new HashMap<String,List<Object[]>>();
					Map<String, Object> dbAccountMap = new HashMap<String,Object>();
					for(int index = 0;index <accountIdList.size();index ++){
						Object accountId = accountIdList.get(index);
						RoutingService.getInstance().setRoutingStrategyForMap(mapname,accountId, IStrategy.STRATEGY_R);
						String dbName = ContextHolder.getDataSource();
						if(null == (dbAccountMap.get(dbName))){
							Object[] params = paramsList.get(index);
							//@todo 此处需要一个新的处理逻辑
							if(null == params){
								continue;
							}
							else{
								dbAccountMap.put(dbName, accountId);
								List<Object[]> newParamList = new ArrayList<Object[]>();
								newParamList.add(params);
								dbParamsMap.put(dbName, newParamList);
							}
						}
						else{
							Object[] params = paramsList.get(index);
							//@todo 此处需要一个新的处理逻辑
							if(null == params){
								continue;
							}
							else{
								dbParamsMap.get(dbName).add(params);	
							}
						}
					}//for
					Iterator<String> dbIter = dbAccountMap.keySet().iterator();
					while(dbIter.hasNext()){
						String dbName = dbIter.next();
						List<Object[]> bufList = new ArrayList<Object[]>();
						List<SqlInfo> sqlInfoLs = SqlUtil.getMapAggreSqlInfos(mapname, dbParamsMap.get(dbName));
						RoutingService.getInstance().setRoutingStrategyForMap(mapname, dbAccountMap.get(dbName), IStrategy.STRATEGY_R);
						for(SqlInfo sqlInfo :sqlInfoLs){
						  bufList = DBAgentHibernateImpl.getInstance().getObjectList(null,null, sqlInfo, 0l, 0l,IStrategy.STRATEGY_R, false, true);
						  resList.addAll(bufList);
						}
					}
				}
		   }
		   catch(Exception e){
			   processException(e);
		   }
		   return resList;
	}
	private void processException(Exception e) throws DaoException {
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
