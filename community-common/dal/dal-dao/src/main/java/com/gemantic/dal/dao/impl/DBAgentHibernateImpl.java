package com.gemantic.dal.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.dao.DBAgent;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.ListOrderHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.model.ScalarInfo;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.DalAssert;
import com.gemantic.dal.dao.util.DalLRUMap;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.datasource.ContextHolder;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;

public class DBAgentHibernateImpl implements DBAgent {

	private static final int singleUsedTime = 8;

	private static final Log log = LogFactory.getLog(DBAgentHibernateImpl.class);
	private Log permLog = LogFactory.getLog("DBPerformance");

	private static DBAgent dbAgent;
	public static final int DEFAULT_SIZE = 5000;
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	private Map nonDatas = new DalLRUMap(DEFAULT_SIZE);

	private DBAgentHibernateImpl() {
		sessionFactory = DaoHelper.getSessionFactory();
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public static DBAgent getInstance() {
		if (null == dbAgent) {
			dbAgent = new DBAgentHibernateImpl();
		}
		return dbAgent;
	}

	public Serializable save(Object account_id, Object object) throws DaoException {
		Serializable id = null;
		DalAssert.assertObjectNotNull(object);
		DalAssert.assertObjectIllegal(account_id, object);
		try {
			long t1 = System.currentTimeMillis();

			RoutingService.getInstance().setRoutingStrategyForObject(object.getClass(), account_id,
					IStrategy.STRATEGY_W);
			// TODO:此处暂时做成与数据同步的，加上了flush,当将来用到事物的时候，需要去掉
			hibernateTemplate.setFlushMode(HibernateAccessor.FLUSH_EAGER);
			id = hibernateTemplate.save(object);

			if (null == id) {
				LogHelper.savedError(log, object);
			}
			String getKey = object.getClass().getName() + id;
			nonDatas.remove(getKey);

			// 用于记录该方法的超时情况
			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					if (null != object) {
						permLog.warn("method: save region: " + object.getClass().getName() + " params: " + id
								+ " time: " + usedTime);
					}
				}
			}

		} catch (Exception e) {
			processException(e);
		}
		return id;
	}

	public Map save(Object account_id, final List obs) throws DaoException {
		DalAssert.assertObjectNotNull(obs);
		Map map = new HashMap();
		try {
			long t1 = System.currentTimeMillis();
			RoutingService.getInstance().setRoutingStrategyForObject(obs.get(0).getClass(), account_id,
					IStrategy.STRATEGY_W);
			map = (Map) hibernateTemplate.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.connection().setAutoCommit(false);
					Map idObjMap = new HashMap();
					Transaction trans = session.beginTransaction();
					Serializable id = null;
					for (Object obj : obs) {
						id = session.save(obj);
						idObjMap.put(id, obj);
					}
					session.flush();
					session.clear();
					trans.commit();
					return idObjMap;
				}

			});

			// 用于记录该方法的超时情况
			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					Object obj = obs.get(0);
					if (null != obj && null != obj.getClass()) {
						permLog.warn("method: BatchSave region: " + obs.get(0).getClass().getName() + " size: "
								+ obs.size() + " time: " + usedTime);
					}
				}
			}
		} catch (Exception e) {
			map = new HashMap();
			processException(e);
		}
		if (null == map) {
			map = new HashMap();
		}
		return map;
	}

	public boolean updateObjs(Object account_id, final List obs) throws DaoException {
		DalAssert.assertObjectNotNull(obs);
		boolean bRes = true;
		try {
			long t1 = System.currentTimeMillis();
			RoutingService.getInstance().setRoutingStrategyForObject(obs.get(0).getClass(), account_id,
					IStrategy.STRATEGY_W);
			bRes = (Boolean) hibernateTemplate.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws SQLException {
					session.connection().setAutoCommit(false);
					Transaction trans = session.beginTransaction();
					for (Object obj : obs) {
						session.update(obj);
					}
					session.flush();
					session.clear();
					trans.commit();
					return true;
				}
			});

			// 用于记录该方法的超时情况
			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					Object obj = obs.get(0);
					if (null != obj && null != obj.getClass()) {
						permLog.warn("method: update region: " + obs.get(0).getClass().getName() + " size: "
								+ obs.size() + " time: " + usedTime);
					}
				}
			}
		} catch (Exception e) {
			processException(e);
			bRes = false;
		}
		return bRes;
	}

	public boolean delete(Object account_id, Object obj) throws DaoException {
		boolean res = true;
		DalAssert.assertObjectNotNull(obj);
		try {
			long t1 = System.currentTimeMillis();
			Serializable id = ObjectUtil.getObjectId(obj);
			// TODO 防止NonUniqueObjectException
			hibernateTemplate.clear();
			RoutingService.getInstance().setRoutingStrategyForObject(obj.getClass(), account_id, IStrategy.STRATEGY_W);
			// TODO:此处暂时做成与数据同步的，，加上了flush,当将来用到事物的时候，需要去掉
			hibernateTemplate.setFlushMode(HibernateAccessor.FLUSH_EAGER);
			hibernateTemplate.delete(obj);

			// 用于记录该方法的超时情况
			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					permLog.warn("method: delete region: " + obj.getClass().getName() + " params: " + id + " time: "
							+ usedTime);
				}
			}
		} catch (Exception e) {
			res = false;
			processException(e);
		}

		return res;
	}

	public boolean fakeDelete(Object account_id, Object obj) throws DaoException {
		boolean res = true;
		DalAssert.assertObjectNotNull(obj);
		try {
			long t1 = System.currentTimeMillis();
			Serializable id = ObjectUtil.getObjectId(obj);

			RoutingService.getInstance().setRoutingStrategyForObject(obj.getClass(), account_id, IStrategy.STRATEGY_W);
			Method method = DaoHelper.getDelPropertyMethod(obj.getClass().getName());
			Object delTag = DaoHelper.getDelValue(obj.getClass().getName());
			DalAssert.assertObjectNotNull(method);
			DalAssert.assertObjectNotNull(delTag);
			method.invoke(obj, delTag);
			// TODO:此处暂时做成与数据同步的，，加上了flush,当将来用到事物的时候，需要去掉
			hibernateTemplate.setFlushMode(HibernateAccessor.FLUSH_EAGER);
			hibernateTemplate.update(obj);

			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					permLog.warn("method: fakeDelete region: " + obj.getClass().getName() + " params: " + id
							+ " time: " + usedTime);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			processException(e);
			res = false;
		}

		return res;
	}

	public boolean update(Object account_id, Object object) throws DaoException {
		DalAssert.assertObjectNotNull(object);
		try {
			long t1 = System.currentTimeMillis();
			Serializable id = ObjectUtil.getObjectId(object);

			RoutingService.getInstance().setRoutingStrategyForObject(object.getClass(), account_id,
					IStrategy.STRATEGY_W);
			// TODO:此处暂时做成与数据同步的，，加上了flush,当将来用到事物的时候，需要去掉
			hibernateTemplate.setFlushMode(HibernateAccessor.FLUSH_EAGER);
			hibernateTemplate.update(object);

			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					permLog.warn("method: update region: " + object.getClass().getName() + " params: " + id + " time: "
							+ usedTime);
				}
			}

		} catch (Exception e) {
			processException(e);
		}
		return true;
	}

	public Object get(Object account_id, Class clazz, Serializable id) throws DaoException {
		Object obj = null;
		DalAssert.assertObjectNotNull(clazz);
		try {
			long t1 = System.currentTimeMillis();

			RoutingService.getInstance().setRoutingStrategyForObject(clazz, account_id, IStrategy.STRATEGY_R);
			String getKey = clazz.getName() + id;
			obj = hibernateTemplate.get(clazz, id);
			if (obj == null)
				nonDatas.put(getKey, id);

			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					permLog.warn("method: get region: " + clazz.getName() + " params: " + id + " time: " + usedTime);
				}
			}

		} catch (Exception e) {
			processException(e);
		}
		return obj;
	}

	public List getObjectList(Object account_id, String listName, final SqlInfo sqlInfo, final Long start,
			final Long count, int strategy, boolean setDS, final boolean getAll) throws DaoException {
		List list = null;
		DalAssert.assertObjectNotNull(sqlInfo);
		try {
			long t1 = System.currentTimeMillis();

			if (setDS) {
				RoutingService.getInstance().setRoutingStrategyForList(listName, account_id, strategy);
			}
			list = (List) hibernateTemplate.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					SQLQuery query = session.createSQLQuery(sqlInfo.getSql());
					if (null != sqlInfo.getScalarList() && sqlInfo.getScalarList().size() > 0) {
						for (ScalarInfo scaInfo : sqlInfo.getScalarList()) {
							if (null == scaInfo.getColumnType()) {
								query.addScalar(scaInfo.getColumnName());
							} else {
								query.addScalar(scaInfo.getColumnName(), scaInfo.getColumnType());
							}
						}
					}
					if (null != sqlInfo.getParams() && sqlInfo.getParams().length > 0) {
						int i = 0;
						for (Object id : sqlInfo.getParams()) {
							if (null != id) {
								query.setParameter(i++, id);
							}
						}
					}
					if (!getAll) {
						LogHelper.runningStartAndCount(log);
						query.setFirstResult(start.intValue());
						if (0 != count.intValue()) {
							query.setMaxResults(count.intValue());
						}
					}
					return query.list();
				}
			});
			if (null == list) {
				list = new ArrayList();
			}

			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					if (null != sqlInfo.getParams()) {
						permLog.warn("method: getObjectList region: " + listName + " params: " + sqlInfo.getParamKey()
								+ " time: " + usedTime + " start :" + start + " count :" + count + "\r\n" + " sql: "
								+ sqlInfo.getSql());
					}
				}
			}

		} catch (Exception e) {
			processException(e);
		}
		return list;
	}

	/**
	 * 根据对象的id list，得到对象List
	 * 
	 * @param account_id
	 * @param cls
	 * @param sqlInfo
	 * @param strategy
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public List getEntityList(Object account_id, final Class cls, final SqlInfo sqlInfo, int strategy)
			throws DaoException {
		List list = null;
		DalAssert.assertObjectNotNull(cls);
		DalAssert.assertObjectNotNull(sqlInfo);
		try {
			long t1 = System.currentTimeMillis();

			RoutingService.getInstance().setRoutingStrategyForObject(cls, account_id, strategy);
			list = (List) hibernateTemplate.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					SQLQuery query = session.createSQLQuery(sqlInfo.getSql()).addEntity(cls);
					if (null != sqlInfo.getParams() && sqlInfo.getParams().length > 0) {
						int i = 0;
						for (Object id : sqlInfo.getParams()) {
							if (null != id) {
								query.setParameter(i++, id);
							}
						}
					}
					return query.list();
				}
			});
			if (null == list) {
				list = new ArrayList();
			}

			long usedTime = System.currentTimeMillis() - t1;
			if (usedTime >= singleUsedTime) {
				if (permLog.isWarnEnabled()) {
					permLog.warn("method: getEntityList region: " + cls.getName() + " params: " + sqlInfo.getParamKey()
							+ " time: " + usedTime);
				}
			}

		} catch (Exception e) {
			processException(e);
		}
		return list;
	}

	/**
	 * 用于跨库查询的方法
	 */
	public List<List> crossDBList(Object account_id, String listName, final SqlInfo sqlInfo, final Integer start,
			final Integer count, int strategy) throws DaoException {
		List<List> allList = new ArrayList<List>();
		DBAgent dbAgent = DBAgentHibernateImpl.getInstance();
		try {
			while (RoutingService.getInstance().nextRoutingStrategyForList(listName, strategy)) {
				List objList = dbAgent.getObjectList(null, listName, sqlInfo, new Long("" + start),
						new Long("" + count), strategy, false, false);
				allList.add(objList);
			}
		} catch (Exception e) {
			processException(e);
		}
		return allList;
	}

	/**
	 * 用于将跨库查询得到的结果排序
	 */
	public List getOrderedCrossList(Object account_id, String listName, final SqlInfo sqlInfo, final Long start,
			final Long count, int strategy, boolean forward) throws DaoException {
		int realStart = start.intValue();
		if (realStart < 0) {
			realStart = 0;
		}
		List resList = new ArrayList();
		List<List> allList = crossDBList(account_id, listName, sqlInfo, 0, new Integer("" + realStart + count),
				strategy);
		resList = ListOrderHelper.getOrderedList(allList, forward);
		if (realStart > (resList.size() - 1)) {
			return resList;
		}
		if (realStart + count > resList.size()) {
			return resList.subList(realStart, resList.size());
		} else {
			return resList.subList(realStart, (realStart + count.intValue()));
		}

	}

	/**
	 * 基本类型的Map查询，针对只返回一个Column的情况
	 */
	public List getMaps(Object accountId, String mapName, List<Object[]> paramsList) throws StrategyException,
			DaoException {
		List resList = new ArrayList();
		for (Object[] params : paramsList) {
			SqlInfo sqlInfo = SqlUtil.getMappingSqlInfo(mapName, params, false);
			RoutingService.getInstance().setRoutingStrategyForMap(mapName, accountId, IStrategy.STRATEGY_R);
			List objList = getObjectList(null, null, sqlInfo, 0l, 0l, IStrategy.STRATEGY_R, false, true);
			if (null == objList || objList.size() < 1) {
				LogHelper.failedExecuteQueryFromDB(log, sqlInfo);
				resList.add(null);
			} else {
				resList.add(objList.get(0));
			}
		}
		return resList;
	}

	private void processException(Exception e) throws DaoException {
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

	@Override
	public Object excuteSimpleSql(final String sql, final Class clazz) throws DaoException {
		//log.info("enter into method ExcuteSimpleSql ,the sql is " + sql);
		Long enter = System.nanoTime();
		Object obj = null;
		List<String> dsNames;
		if (null != clazz) {
			try {
				clazz.newInstance();
				dsNames = RoutingService.getInstance().getReadDsFromEachGroupForObject(clazz);
				if (null != dsNames && dsNames.size() > 0) {
					ContextHolder.setDataSource(dsNames.get(0));
				} else {
					log.error("can't find ds for " + clazz.getName());
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e + " excuteSimpleSql: clazz not exist");
				return null;
			}
		} else {
			log.info("clazz is null");
		}
		try {
			obj = hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					List list = session.createSQLQuery(sql).list();
					if (list.size() < 0) {
						return null;
					}
					if (list.size() == 1) {
						return list.get(0);
					} else {
						return list;
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());			
			log.error(sql);
			processException(e);
			
		}
		//Long out = System.nanoTime();
		//log.info("out of method ExcuteSimpleSql , use " + (out - enter) + " nanosecond");
		return obj;
	}

}
