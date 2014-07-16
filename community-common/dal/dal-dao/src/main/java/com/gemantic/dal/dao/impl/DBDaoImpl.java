package com.gemantic.dal.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ObjectItem;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.MultiDBGet;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.AnnotationUtil;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.DalAssert;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.datasource.ContextHolder;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;
import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;

/**
 * @author cctv
 */
public class DBDaoImpl implements Dao {
    private Log log = LogFactory.getLog(DBDaoImpl.class);
    private Log permLog = LogFactory.getLog("DalPerformance");

    private static final int singleUsedTime = 15;
    private static final int lotsUsedTime = 50;

    @Override
    public Serializable save(Object accountId, Object object)
            throws DaoException {
        DalAssert.assertObjectNotNull(object);
        DalAssert.assertObjectIllegal(accountId, object);
        long t1 = System.currentTimeMillis();
        Serializable id = null;
        try {
            id = DBAgentHibernateImpl.getInstance().save(accountId, object);
            if (null == id) {
                LogHelper.savedError(log, object);
            }
        } catch (Exception e) {
            processException(e);
        }
        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: save region: "
                        + object.getClass().getName() + " params: " + id
                        + " time: " + usedTime);
            }
        }
        return id;
    }

    @Override
    public Serializable save(Object object) throws DaoException {
        return save(null, object);
    }

    @Override
    public List save(Object accountId, List objects) throws DaoException {
        DalAssert.assertObjectNotNull(objects);
        DalAssert.assertListIllegal(accountId, objects);
        List objList = new ArrayList();
        for (Object obj : objects) {
            if (obj != null) {
                save(accountId, obj);
                objList.add(obj);
            }
        }
        return objList;
    }

    @Override
    public List save(List objects) throws DaoException {
        return save(null, objects);
    }

    @Override
    public List batchSave(Object accountId, List objList) throws DaoException {
        DalAssert.assertObjectNotNull(objList);
        long t1 = System.currentTimeMillis();
        Map resMap = null;
        List resList = new ArrayList();

        try {
            resMap = DBAgentHibernateImpl.getInstance()
                    .save(accountId, objList);
            Iterator iter = resMap.keySet().iterator();
            while (iter.hasNext()) {
                Serializable id = (Serializable) iter.next();
                Object obj = resMap.get(id);
                resList.add(obj);
            }

            long usedTime = System.currentTimeMillis() - t1;
            if (usedTime >= lotsUsedTime) {
                if (permLog.isWarnEnabled()) {
                    Object obj = objList.get(0);
                    if (null != obj && null != obj.getClass()) {
                        permLog.warn("method: batchSave region: "
                                + obj.getClass().getName() + " size: "
                                + objList.size() + " time: " + usedTime);
                    }
                }
            }
        } catch (Exception e) {
            resList = new ArrayList();
            processException(e);
        }

        return resList;
    }

    @Override
    public List batchSave(List objList) throws DaoException {
        return batchSave(null, objList);
    }

    @Override
    public boolean updateObjs(List objList) throws DaoException {
        long t1 = System.currentTimeMillis();
        boolean bUpdated = true;
        bUpdated = DBAgentHibernateImpl.getInstance().updateObjs(null, objList);
        if (!bUpdated) {
            return bUpdated;
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: updateObjects region: " + +usedTime);
            }
        }
        return bUpdated;
    }

    @Override
    public boolean update(Object object) throws DaoException {
        return update(null, object);
    }

    @Override
    public boolean update(Object accountId, Object object) throws DaoException {
        DalAssert.assertObjectNotNull(object);
        DalAssert.assertObjectIllegal(accountId, object);
        long t1 = System.currentTimeMillis();
        boolean bUpdated = true;
        Serializable objectId = null;
        try {
            objectId = ObjectUtil.getObjectId(object);
        } catch (Exception e) {
            processException(e);
        }

        if (null == objectId) {
            LogHelper.failedGetObjectId(log, object);
            return bUpdated;
        }
        bUpdated = DBAgentHibernateImpl.getInstance().update(accountId, object);
        if (!bUpdated) {
            LogHelper.updateError(log, object);
            return bUpdated;
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: update region: "
                        + object.getClass().getName() + " params: " + objectId
                        + " time: " + usedTime);
            }
        }
        return bUpdated;
    }

    @Override
    public boolean batchUpdate(Object accountId, List objects)
            throws DaoException {
        DalAssert.assertObjectNotNull(objects);
        DalAssert.assertListIllegal(accountId, objects);
        boolean bUpdated = true;
        try {
            for (Object obj : objects) {
                update(accountId, obj);
            }
        } catch (Exception e) {
            processException(e);
        }
        return bUpdated;
    }

    @Override
    public boolean batchUpdate(List objects) throws DaoException {
        return batchUpdate(null, objects);
    }

    @Override
    public boolean delete(Object accountId, Class clazz, Serializable id)
            throws DaoException {
        DalAssert.assertObjectNotNull(clazz);
        DalAssert.assertObjectNotNull(id);
        long t1 = System.currentTimeMillis();

        boolean bDeleted = true;
        Object obj = null;
        obj = get(accountId, clazz, id);
        boolean delFlag = bDeleted = DBAgentHibernateImpl.getInstance().delete(
                accountId, obj);
        if (!bDeleted) {
            LogHelper.deleteError(log, clazz, accountId, id, false);
            return delFlag;
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: realDelete region: " + clazz.getName()
                        + " params: " + id + " time: " + usedTime);
            }
        }
        return bDeleted;
    }

    @Override
    public boolean delete(Class clazz, Serializable id) throws DaoException {
        return delete(null, clazz, id);
    }

    @Override
    public boolean deleteList(Object accountId, Class clazz, List ids)
            throws DaoException {
        DalAssert.assertObjectNotNull(clazz);
        DalAssert.assertObjectNotNull(ids);
        boolean bDeleted = true;
        try {
            for (Object id : ids) {
                delete(accountId, clazz, (Serializable) id);
            }
        } catch (Exception e) {
            bDeleted = false;
            processException(e);
        }
        return bDeleted;
    }

    @Override
    public boolean deleteList(Class clazz, List ids) throws DaoException {
        return deleteList(null, clazz, ids);
    }

    @Override
    public boolean deleteList(Object accountId, String listName, Object[] params)
            throws DaoException {
        DalAssert.assertObjectNotNull(listName);
        DalAssert.assertObjectNotNull(params);
        boolean res = true;
        try {
            List idList = getIdList(accountId, listName, params, true);
            if (null != idList && idList.size() > 0) {
                String clsName = DaoHelper.getObjectNameByListName(listName);
                if (StringUtils.isBlank(clsName)) {
                    LogHelper.failedGetClassNameByListName(log, listName);
                    return true;
                }
                res = deleteList(accountId, Class.forName(clsName), idList);
            }
        } catch (Exception e) {
            processException(e);
        }
        return res;
    }

    @Override
    public boolean deleteList(String listName, Object[] params)
            throws DaoException {
        return deleteList(null, listName, params);
    }

    @Override
    public boolean deleteList(Object accountId, String listName, Object param)
            throws DaoException {
        if (null == param) {
            return deleteList(accountId, listName, new Object[]{});
        } else {
            return deleteList(accountId, listName, new Object[]{param});
        }
    }

    @Override
    public boolean deleteList(String listName, Object param)
            throws DaoException {
        return deleteList(null, listName, param);
    }

    @Override
    public boolean fakeDelete(Object accountId, Class clazz, Serializable id)
            throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDelete(Class clazz, Serializable id) throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(Object accountId, Class clazz, List ids)
            throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(Class clazz, List ids) throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(Object accountId, String listName,
                                  Object[] params) throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(String listName, Object[] params)
            throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(Object accountId, String listName,
                                  Object param) throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fakeDeleteList(String listName, Object param)
            throws DaoException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object get(Object accountId, Class clazz, Serializable id) throws DaoException {
        DalAssert.assertClassTypeNotNull(clazz);
        DalAssert.assertObjectNotNull(id);

        long t1 = System.currentTimeMillis();
        Object obj = null;
        obj = DBAgentHibernateImpl.getInstance().get(accountId, clazz, id);

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: get region: " + clazz.getName()
                        + " params: " + id + " time: " + usedTime);
            }
        }

        return obj;
    }

    @Override
    public Object get(Class clazz, Serializable id) throws DaoException {
        return get(null, clazz, id);
    }

    @Override
    public List getIdList(Object accountId, String listName, Object param,
                          Integer start, Integer count, boolean forward) throws DaoException {
        if (null == param) {
            return getIdList(accountId, listName, new Object[]{}, start,
                    count, forward);
        } else {
            return getIdList(accountId, listName, new Object[]{param},
                    start, count, forward);
        }
    }

    @Override
    public List getIdList(String listSqlName, Object param, Integer start,
                          Integer count, boolean forward) throws DaoException {
        return getIdList(null, listSqlName, param, start, count, forward);
    }

    @Override
    public List getIdList(Object accountId, String listName, Object param,
                          boolean forward) throws DaoException {
        if (null == param) {
            return getIdList(accountId, listName, new Object[]{}, forward);
        } else {
            return getIdList(accountId, listName, new Object[]{param},
                    forward);
        }
    }

    @Override
    public List getIdList(String listName, Object param, boolean forward)
            throws DaoException {

        return getIdList(null, listName, param, forward);
    }

    @Override
    public List getIdList(Object accountId, String listName, Object[] params,
                          Integer start, Integer count, boolean forward) throws DaoException {

        DalAssert.assertObjectNotNull(listName);
        DalAssert.assertObjectNotNull(params);
        DalAssert.assertObjectNotNull(start);
        DalAssert.assertObjectNotNull(count);

        SqlInfo sqlInfo = SqlUtil.getListSql(listName, params, forward);
        long lsType = ObjectUtil.getListType(listName);
        if (lsType == Constants.CROSSDB_TYPE) {
            return DBAgentHibernateImpl.getInstance().getOrderedCrossList(accountId, listName, sqlInfo, new Long(start.intValue()), new Long(count.intValue()), IStrategy.STRATEGY_R, forward);
        } else {
            return DBAgentHibernateImpl.getInstance().getObjectList(accountId, listName, sqlInfo, new Long(start.intValue()), new Long(count.intValue()), IStrategy.STRATEGY_R, true, false);
        }
    }

    @Override
    public List getIdList(String listName, Object[] params, Integer start,
                          Integer count, boolean forward) throws DaoException {
        return getIdList(null, listName, params, start, count, forward);
    }

    @Override
    public List getIdList(Object accountId, String listName, Object[] params,
                          boolean forward) throws DaoException {
        int totalCount = count(accountId, listName, params);
        if (totalCount <= 0) {
            return new ArrayList();
        }
        return getIdList(accountId, listName, params, 0, totalCount, forward);
    }

    @Override
    public List getIdList(String listName, Object[] params, boolean forward)
            throws DaoException {
        return getIdList(null, listName, params, forward);
    }

    @Override
    public List getList(Object accountId, Class clazz, List ids)
            throws DaoException {
        DalAssert.assertClassTypeNotNull(clazz);
        DalAssert.assertObjectNotNull(ids);

        List objList = new ArrayList();
        if (null == ids || ids.size() < 1) {
            log.warn(" id list is empty");
            return objList;
        }
        objList = getObjectList(accountId, clazz, ids);

        return objList;
    }

    private List getObjectList(Object account_id, Class clazz, List ids) throws DaoException {
        List objList = new ArrayList();
        ObjectItem objItem = DaoHelper.getObjectItemByObjectName(clazz.getName());
        String baseSql = objItem.getEntitySql();
        if (null == baseSql || StringUtils.isBlank(baseSql)) {
            return objList;
        }
        List<SqlInfo> sqlInfoLs = SqlUtil.getEntityUnionSql(ids, baseSql);
        if (null == sqlInfoLs) {
            return objList;
        }
        try {
            objList = MultiDBGet.get(account_id, clazz, sqlInfoLs);
        } catch (CacheException e) {
            e.printStackTrace(System.out);
            e.printStackTrace(System.err);
        }
        for (SqlInfo sqlInfo : sqlInfoLs) {
            List entityLs = DBAgentHibernateImpl.getInstance().getEntityList(account_id, clazz, sqlInfo, IStrategy.STRATEGY_R);
            objList.addAll(entityLs);
        }
        return objList;
    }


    @Override
    public List getList(Class clazz, List ids) throws DaoException {
        return getList(null, clazz, ids);
    }

    @Override
    public List getListWithNULLOBJ(Object account_id, Class clazz, List ids) throws DaoException {
        return getList(account_id, clazz, ids);
    }

    @Override
    public List getListWithNULLOBJ(Class clazz, List ids) throws DaoException {
        return getListWithNULLOBJ(null, clazz, ids);
    }

    @Override
    public List getMapList(List accountIdList, String mapname,
                           List<Object[]> paramsList) throws DaoException {
        DalAssert.assertObjectNotNull(accountIdList);
        DalAssert.assertObjectNotNull(mapname);
        DalAssert.assertObjectNotNull(paramsList);
        List resList = new ArrayList();

        try {
            Map<String, List<Object[]>> dbParamsMap = new HashMap<String, List<Object[]>>();
            Map<String, Object> dbAccountMap = new HashMap<String, Object>();
            for (int index = 0; index < accountIdList.size(); index++) {
                Object accountId = accountIdList.get(index);
                RoutingService.getInstance().setRoutingStrategyForMap(mapname, accountId, IStrategy.STRATEGY_R);
                String dbName = ContextHolder.getDataSource();
                if (null == (dbAccountMap.get(dbName))) {
                    Object[] params = paramsList.get(index);
                    //@todo 此处需要一个新的处理逻辑
                    if (null == params) {
                        continue;
                    } else {
                        dbAccountMap.put(dbName, accountId);
                        List<Object[]> newParamList = new ArrayList<Object[]>();
                        newParamList.add(params);
                        dbParamsMap.put(dbName, newParamList);
                    }
                } else {
                    Object[] params = paramsList.get(index);
                    //@todo 此处需要一个新的处理逻辑
                    if (null == params) {
                        continue;
                    } else {
                        dbParamsMap.get(dbName).add(params);
                    }
                }
            }//for
            Iterator<String> dbIter = dbAccountMap.keySet().iterator();
            while (dbIter.hasNext()) {
                String dbName = dbIter.next();
                List<Object[]> bufList = new ArrayList<Object[]>();
                List<SqlInfo> sqlInfoLs = SqlUtil.getMapAggreSqlInfos(mapname, dbParamsMap.get(dbName));
                RoutingService.getInstance().setRoutingStrategyForMap(mapname, dbAccountMap.get(dbName), IStrategy.STRATEGY_R);
                for (SqlInfo sqlInfo : sqlInfoLs) {
                    bufList = DBAgentHibernateImpl.getInstance().getObjectList(null, null, sqlInfo, 0l, 0l, IStrategy.STRATEGY_R, false, true);
                    resList.addAll(bufList);
                }
            }
        } catch (StrategyException e) {
            processException(e);
        }
        return resList;
    }

    @Override
    public Object getMapping(Object accountId, String mappingName, Object[] keys)
            throws DaoException {
        return this.getRealMapping(accountId, mappingName, keys, false);
    }

    public Object getRealMapping(Object account_id, String mappingName, Object[] params, boolean bExtend) throws DaoException {
        DalAssert.assertObjectNotNull(mappingName);
        DalAssert.assertObjectNotNull(params);

        long t1 = System.currentTimeMillis();
        Object obj = null;
        try {
            SqlInfo sqlInfo = SqlUtil.getMappingSqlInfo(mappingName, params, bExtend);
            LogHelper.usingMappingWithDB(log);
            RoutingService.getInstance().setRoutingStrategyForMap(mappingName, account_id, IStrategy.STRATEGY_R);
            List objList = DBAgentHibernateImpl.getInstance().getObjectList(account_id, mappingName, sqlInfo, 0l, 0l, IStrategy.STRATEGY_R, false, false);
            if (null == objList || objList.size() < 1) {
                LogHelper.failedExecuteQueryFromDB(log, sqlInfo);
                return null;
            }
            long usedTime = System.currentTimeMillis() - t1;
            if (usedTime >= singleUsedTime) {
                if (permLog.isWarnEnabled()) {
                    permLog.warn("method: getRealMapping region: " + mappingName + " size: " + params.length + " time: " + usedTime);
                }
            }
            return objList.get(0);

        } catch (StrategyException e) {
            e.printStackTrace(System.out);
            processException(e);
        }
        return obj;
    }

    @Override
    public Object getMapping(String mappingName, Object[] keys)
            throws DaoException {
        return getMapping(null, mappingName, keys);
    }

    @Override
    public Object getMapping(Object accountId, String mappingName, Object key)
            throws DaoException {
        if (null == key) {
            return getMapping(accountId, mappingName, new Object[]{});
        } else {
            return getMapping(accountId, mappingName, new Object[]{key});
        }
    }

    @Override
    public Object getMapping(String mappingName, Object key)
            throws DaoException {
        return getMapping(null, mappingName, key);
    }

    @Override
    public List getMappings(Object accountId, String mapName,
                            List<Object[]> paramsList) throws DaoException {
        DalAssert.assertObjectNotNull(accountId);
        DalAssert.assertObjectNotNull(mapName);
        DalAssert.assertObjectNotNull(paramsList);

        long t1 = System.currentTimeMillis();

        try {
            return DBAgentHibernateImpl.getInstance().getMaps(accountId, mapName, paramsList);
        } catch (StrategyException e) {
            processException(e);
            return null;
        }
    }

    @Override
    public Map getMappingsMap(Object accountId, String mapName, List<Object[]> paramsList) throws DaoException {
        Map resultMap = new HashMap();
        List resultList = getMappings(accountId, mapName, paramsList);
        if (CollectionUtils.isNotEmpty(paramsList) && CollectionUtils.isNotEmpty(resultList)) {
            int size = paramsList.size();
            for (int i = 0; i < size; i++) {
                Object[] objects = paramsList.get(i);
                Object obj = resultList.get(i);
                resultMap.put(objects, obj);
            }
        }
        return resultMap;
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

    @Override
    public int count(Object accountId, String listName, Object param)
            throws DaoException {
        if (null == param) {
            return count(accountId, listName, new Object[]{});
        } else {
            return count(accountId, listName, new Object[]{param});
        }
    }

    @Override
    public int count(String listName, Object param) throws DaoException {
        return count(null, listName, param);
    }

    @Override
    public int count(Object accountId, String listName, Object[] params)
            throws DaoException {
        DalAssert.assertObjectNotNull(listName);
        DalAssert.assertObjectNotNull(params);

        Long count = 0l;
        SqlInfo sqlInfo = SqlUtil.getListCountSql(listName, params);
        int lsType = ObjectUtil.getListType(listName);
        //跨库查询的情况，是把每个List的总数，加起来
        if (lsType == Constants.CROSSDB_TYPE) {
            List<List> list = DBAgentHibernateImpl.getInstance().crossDBList(accountId, listName, sqlInfo, 0, 1, IStrategy.STRATEGY_R);
            if (null != list) {
                for (List ls : list) {
                    count += ((Number) ls.get(0)).intValue();
                }
            }
            return count.intValue();
        } else {
            List list = DBAgentHibernateImpl.getInstance().getObjectList(accountId, listName, sqlInfo, 0l, 1l, IStrategy.STRATEGY_R, true, true);
            return ((Number) list.get(0)).intValue();
        }

    }

    @Override
    public int count(String listName, Object[] params) throws DaoException {
        return count(null, listName, params);
    }


    @Override
    public Long getMaxIdOfClass(Class clazz) throws DaoException {
        try {
            log.info("enter into method getMaxIdOfClass ");
            //根据类的配置获取对应的数据库的id列和表名字，并拼出sql
            String id = AnnotationUtil.getIdClumnFromEntity(clazz);
            if (StringUtils.isBlank(id)) {
                log.error("can't find the id clomun for entity " + clazz.getName());
                return 0L;
            }
            String tableName = AnnotationUtil.getTableNameFromEntity(clazz);
            if (StringUtils.isBlank(tableName)) {
                log.error("can't find the tableName for entity " + clazz.getName());
                return 0L;
            }
            String sql = "select max(" + id + ") from " + tableName;

            //获取此类的各个数据库集群的一些读库的资源
            List<Long> idList = Collections.synchronizedList(new ArrayList<Long>());
            List<String> dsNames = RoutingService.getInstance().getReadDsFromEachGroupForObject(clazz);

            //开启多线程取得各个库中的最大的id值
            if (CollectionUtils.isEmpty(dsNames)) {
                log.error("can't find any db for the entity " + clazz.getName());
                return 0L;
            }
            for (String dsName : dsNames) {
                Thread thread = new CallDSThread(dsName, idList, sql);
                if (null != thread) {
                    thread.start();
                }
            }

            //如果线程都没结束，就睡眠1毫秒
            while (idList.size() != dsNames.size()) {
                Thread.sleep(1L);
            }

            //排序并返回最大值
            if (CollectionUtils.isEmpty(idList)) {
                log.error(" find no id, no data in the db or something wrong happened ");
                return 0L;
            }
            Collections.sort(idList);
            log.info("get out of method getMaxIdOfClass ");
            return idList.get(idList.size() - 1);
        } catch (Exception e) {
            log.error("getMaxIdOfClass fail: " + e.getMessage());
            processException(e);
            return 0L;
        }
    }

    @Override
    public Object excuteSimpleSql(String sql, Class clazz) throws DaoException {
        //log.info("enter into method excuteSimpleSql, param is " + sql);
        return DBAgentHibernateImpl.getInstance().excuteSimpleSql(sql, clazz);
    }
}


class CallDSThread extends Thread {
    private String dsName;
    private List<Long> idList;
    private String sql;
    private Log log = LogFactory.getLog(CallDSThread.class);

    public CallDSThread() {
    }

    public CallDSThread(String dsName, List<Long> idList, String sql) {
        this.dsName = dsName;
        this.idList = idList;
        this.sql = sql;
    }

    @Override
    public void run() {
        ContextHolder.setDataSource(dsName);
        try {
            Object maxId = DBAgentHibernateImpl.getInstance().excuteSimpleSql(sql, null);
            if (null != maxId) {
                idList.add(Long.valueOf(maxId.toString()));
            } else {
                log.error("DBDaoImpl : getMaxIdOfClass : error muti Thread to get max Id ; get null Id from dataSource " + dsName);
                idList.add(0L);
            }
        } catch (Exception e) {
            log.error("DBDaoImpl : getMaxIdOfClass : error from muti Thread to get max Id " + e.getMessage());
            idList.add(0L);
        }
    }
}



