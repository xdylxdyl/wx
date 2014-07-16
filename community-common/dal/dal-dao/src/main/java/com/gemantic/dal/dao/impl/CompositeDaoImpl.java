package com.gemantic.dal.dao.impl;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.MaxIdHolder;
import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ObjectItem;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.ListHandlerCenter;
import com.gemantic.dal.dao.ListLoaderCenter;
import com.gemantic.dal.dao.cachehandler.impl.MapCacheHelper;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.helper.MultiCacheGet;
import com.gemantic.dal.dao.helper.MultiDBGet;
import com.gemantic.dal.dao.helper.VisitHelper;
import com.gemantic.dal.dao.model.ListLoadInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.MapInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.DalAssert;
import com.gemantic.dal.dao.util.NullObjectHelper;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.datasource.ContextHolder;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;
import com.gemantic.dal.dao.helper.*;
import com.gemantic.dal.dao.model.*;
import com.gemantic.dal.dao.util.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;


public class CompositeDaoImpl implements Dao {

    private static final int singleUsedTime = 15;
    private static final int lotsUsedTime = 50;

    private Log log = LogFactory.getLog(CompositeDaoImpl.class);

    private Log permLog = LogFactory.getLog("DalPerformance");

    public CompositeDaoImpl() {
    }

    public Serializable save(Object account_id, Object object) throws DaoException {
        DalAssert.assertObjectNotNull(object);
        DalAssert.assertObjectIllegal(account_id, object);

        long t1 = System.currentTimeMillis();

        Serializable id = null;
        try {
            //更新缓存的信息，先更新对应具体对象的缓存，删除响应的缓存
            VisitHelper.getInstance().inLoadWithSave(object);
            Map<Integer, List<SectionInfo>> saveInfos = ListHandlerCenter.getInstance().getSavedInfos(account_id, object);
            // 重要逻辑一：更新数据库
            id = DBAgentHibernateImpl.getInstance().save(account_id, object);
            if (null == id) {
                LogHelper.savedError(log, object);
                return id;
            }
            // 重要逻辑二：更新List缓存
            ListHandlerCenter.getInstance().processSave(account_id, object, saveInfos);
            // 重要逻辑三：更新该对象所对应的缓存
            CacheHelper.save(object.getClass(), id, object);
            // 重要逻辑四: 读写分离时更新Map 缓存
            if (RoutingService.getInstance().isReadWrite(object.getClass(), account_id)) {
                MapCacheHelper.updateToCache(object);
            }
            // 重要逻辑五：将对象所对应的Map从NullObject中移除
//            NullObjectHelper.removeNullMapsOfObject(object);
            // 重要逻辑六：将对象从NullObject中移除
//            NullObjectContent.remove(Constants.NullObjectPrefix + object.getClass().getName() + id);
            // 重要逻辑七：设置最大ID
//            MaxIdHolder.setMaxId(Constants.MaxIdPrefix + object.getClass().getName(), Long.parseLong(id + ""));

        } catch (Exception e) {
            processException(e);
        } finally {
            try {
                VisitHelper.getInstance().endLoadWithSave(object);
            } catch (Exception e) {
                processException(e);
            }
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: save region: " + object.getClass().getName() + " params: " + id + " time: " + usedTime);
            }
        }
        return id;
    }

    public Serializable save(Object object) throws DaoException {
        return save(null, object);
    }

    public List save(Object account_id, List objects) throws DaoException {
        DalAssert.assertObjectNotNull(objects);
        DalAssert.assertListIllegal(account_id, objects);
        List objList = new ArrayList();
        for (Object obj : objects) {
            if (obj != null) {
                save(account_id, obj);
                objList.add(obj);
            }
        }
        return objList;
    }

    public List save(List objects) throws DaoException {
        return save(null, objects);
    }

    /**
     * 设计理念:该方法适用的场景: 非读写分离
     * 采取的策略：对所有对象所对应的在缓存中的List，发现即删除
     * 保存过程中不对对象进行加锁[因为对对象所对应的List,采取的是删除的策略，所以无需加锁]
     */
    public List batchSave(Object account_id, List objList) throws DaoException {
        DalAssert.assertObjectNotNull(objList);

        long t1 = System.currentTimeMillis();
        Map resMap = null;
        List resList = new ArrayList();
        try {
            //重要逻辑一：更新数据库
            resMap = DBAgentHibernateImpl.getInstance().save(account_id, objList);
            Long maxObjectId = 0l;
            /**
             * 重要逻辑二 : 将对象保存在缓存中
             * 重要逻辑三 ：将对象从NullObject中移除
             */
            Iterator iter = resMap.keySet().iterator();
            while (iter.hasNext()) {
                Serializable id = (Serializable) iter.next();
                Object obj = resMap.get(id);
                resList.add(obj);
                //重要逻辑二 : 将对象保存在缓存中
                CacheHelper.save(obj.getClass(), id, obj);
                //重要逻辑三 ：将对象所对应的所有Map，从Map的NullObject中移除
//                NullObjectHelper.removeNullMapsOfObject(obj);
                //重要逻辑四: 将对象从 Object 所对应的 NullObject中移除
//                NullObjectContent.remove(Constants.NullObjectPrefix + obj.getClass().getName() + id);
                if (new Long("" + id).longValue() > maxObjectId.longValue()) {
                    maxObjectId = new Long("" + id);
                }

            }
            //重要逻辑五：设置最大ID
            if (maxObjectId > 0) {
                MaxIdHolder.setMaxId(Constants.MaxIdPrefix + objList.get(0).getClass().getName(), maxObjectId);
            }
            //重要逻辑六: 得到所有对象在缓存中的所有ListInfo的信息,并删除
            ListHandlerCenter.getInstance().processBatchSavedInfos(account_id, resList);

            long usedTime = System.currentTimeMillis() - t1;
            if (usedTime >= lotsUsedTime) {
                if (permLog.isWarnEnabled()) {
                    Object obj = objList.get(0);
                    if (null != obj && null != obj.getClass()) {
                        permLog.warn("method: batchSave region: " + obj.getClass().getName() + " size: " + objList.size() + " time: " + usedTime);
                    }
                }
            }

        } catch (Exception e) {
            resList = new ArrayList();
            processException(e);
        }
        return resList;
    }

    public List batchSave(List objList) throws DaoException {
        return batchSave(null, objList);
    }

    public boolean updateObjs(List objList) throws DaoException {
        long t1 = System.currentTimeMillis();
        boolean bUpdated = true;
        boolean bLock = false;
        Map oldObjMap = new HashMap();
        Map newObjMap = new HashMap();
        Map updateInfoMap = new HashMap();

        try {

            List<Serializable> objIdList = new ArrayList<Serializable>();
            for (Object obj : objList) {
                Serializable objectId = ObjectUtil.getObjectId(obj);
                if (null == objectId) {
                    LogHelper.failedGetObjectId(log, obj);
                    return bUpdated;
                }
                Object oldObject = get(obj.getClass(), objectId);
                if (null == oldObject) {
                    LogHelper.failedGetObjectById(log, null, obj.getClass(), objectId);
                    return bUpdated;
                }
                VisitHelper.getInstance().inLoadWithUpdate(obj);
                VisitHelper.getInstance().inLoadWithUpdate(oldObject);
                Map<Integer, UpdateInfo> updateInfos = ListHandlerCenter.getInstance().getUpdateInfos(null, obj, oldObject);
                oldObjMap.put(objectId, oldObject);
                newObjMap.put(objectId, obj);
                updateInfoMap.put(objectId, updateInfos);
            }
            bLock = true;
            // 重要逻辑一：更新数据库
            bUpdated = DBAgentHibernateImpl.getInstance().updateObjs(null, objList);
            if (!bUpdated) {
                return bUpdated;
            }
            Iterator<Serializable> idIter = newObjMap.keySet().iterator();
            while (idIter.hasNext()) {
                Serializable id = idIter.next();
                Object newObj = newObjMap.get(id);
                Object oldObj = oldObjMap.get(id);
                Map updateMap = (Map) updateInfoMap.get(id);
                // 重要逻辑二：更新List缓存
                ListHandlerCenter.getInstance().processUpdate(null, newObj.getClass(), oldObj, newObj, updateMap);
                // 重要逻辑三：更新该对象所对应的缓存
                CacheHelper.update(newObj.getClass().getName(), id + "", newObj);
                // 重要逻辑四: 删除旧对象所对应的Map
                MapCacheHelper.removeFromCache(oldObj);
                // 重要逻辑五：更新新对象所对应的Map
                MapCacheHelper.updateToCache(newObj);
                //重要逻辑六 : 将对象所对应的Map从NullObject中移除
//                NullObjectHelper.removeNullMapsOfObject(newObj);
            }

        } catch (Exception e) {
            processException(e);
        } finally {
            try {
                if (bLock) {
                    Iterator<Serializable> idIter = newObjMap.keySet().iterator();
                    while (idIter.hasNext()) {
                        Serializable id = idIter.next();
                        Object newObj = newObjMap.get(id);
                        Object oldObj = oldObjMap.get(id);
                        VisitHelper.getInstance().endLoadWithUpdate(newObj);
                        VisitHelper.getInstance().endLoadWithUpdate(oldObj);
                    }
                }
            } catch (Exception e) {
                processException(e);
            }
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: updateObjects region: " + +usedTime);
            }
        }
        return bUpdated;
    }

    public boolean update(Object object) throws DaoException {
        return update(null, object);
    }

    public boolean update(Object account_id, Object object) throws DaoException {
        DalAssert.assertObjectNotNull(object);
        DalAssert.assertObjectIllegal(account_id, object);

        long t1 = System.currentTimeMillis();
        boolean bUpdated = true;
        boolean bLock = false;
        Object oldObject = null;
        Serializable objectId = null;

        try {
            objectId = ObjectUtil.getObjectId(object);
            if (null == objectId) {
                LogHelper.failedGetObjectId(log, object);
                return bUpdated;
            }
            oldObject = get(account_id, object.getClass(), objectId);
            if (null == oldObject) {
                LogHelper.failedGetObjectById(log, account_id, object.getClass(), objectId);
                return bUpdated;
            }
            bLock = true;
            VisitHelper.getInstance().inLoadWithUpdate(object);
            VisitHelper.getInstance().inLoadWithUpdate(oldObject);
            Map<Integer, UpdateInfo> updateInfos = ListHandlerCenter.getInstance().getUpdateInfos(account_id, object, oldObject);
            // 重要逻辑一：更新数据库
            bUpdated = DBAgentHibernateImpl.getInstance().update(account_id, object);
            if (!bUpdated) {
                LogHelper.updateError(log, object);
                return bUpdated;
            }
            // 重要逻辑二：更新List缓存
            ListHandlerCenter.getInstance().processUpdate(account_id, object.getClass(), oldObject, object, updateInfos);
            // 重要逻辑三：更新该对象所对应的缓存
            CacheHelper.update(object.getClass().getName(), objectId + "", object);
            // 重要逻辑四: 删除旧对象所对应的Map
            MapCacheHelper.removeFromCache(oldObject);
            // 重要逻辑五：更新新对象所对应的Map
            MapCacheHelper.updateToCache(object);
            //重要逻辑六 : 将对象所对应的Map从NullObject中移除
//            NullObjectHelper.removeNullMapsOfObject(object);

        } catch (Exception e) {
            processException(e);
        } finally {
            try {
                if (bLock) {
                    VisitHelper.getInstance().endLoadWithUpdate(object);
                    VisitHelper.getInstance().endLoadWithUpdate(oldObject);
                }
            } catch (Exception e) {
                processException(e);
            }
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: update region: " + object.getClass().getName() + " params: " + objectId + " time: " + usedTime);
            }
        }
        return bUpdated;
    }

    /**
     * 更新对象列表
     *
     * @param account_id:用户的id,用于决定数据库操作时，路由的策略
     *
     * @param objects:待更新的对象列表
     */
    public boolean batchUpdate(Object account_id, List objects) throws DaoException {
        DalAssert.assertObjectNotNull(objects);
        DalAssert.assertListIllegal(account_id, objects);
        boolean bUpdated = true;
        try {
            for (Object obj : objects) {
                update(account_id, obj);
            }
        } catch (Exception e) {
            processException(e);
        }
        return bUpdated;
    }

    public boolean batchUpdate(List objects) throws DaoException {
        return batchUpdate(null, objects);
    }

    public boolean delete(Object account_id, Class clazz, Serializable id) throws DaoException {
        return realDelete(account_id, clazz, id, true);
    }

    public boolean delete(Class clazz, Serializable id) throws DaoException {
        return delete(null, clazz, id);
    }

    public boolean fakeDelete(Object account_id, Class clazz, Serializable id) throws DaoException {
        return realDelete(account_id, clazz, id, false);
    }

    public boolean fakeDelete(Class clazz, Serializable id) throws DaoException {
        return fakeDelete(null, clazz, id);
    }

    /**
     * 删除逻辑：1. 先判断待删除数据是否存在，存在才删除，否则认为删除成功 2. 先删除数据库中记录，再更新缓存
     * 根据对象的class类型和id来删除对象
     *
     * @param account_id          :
     *                            执行数据库删除动作需要的策略id
     * @param clazz:待删除对象的Class类型
     * @param id                  :
     *                            待删除对象的id
     */
    private boolean realDelete(Object account_id, Class clazz, Serializable id, boolean delFlag) throws DaoException {
        DalAssert.assertObjectNotNull(clazz);
        DalAssert.assertObjectNotNull(id);

        long t1 = System.currentTimeMillis();

        boolean bDeleted = true;
        Object obj = null;

        //有效解决Blog删除失效的问题
        Object oldObj = null;
        boolean bLock = false;
        try {
            obj = get(account_id, clazz, id);
            if (null == obj) {
                LogHelper.failedGetObjectById(log, account_id, clazz, id);
                return bDeleted;
            } else {
                if (!delFlag) {
                    oldObj = get(account_id, clazz, id);
                }
            }
            bLock = true;
            VisitHelper.getInstance().inLoadWithDelete(obj);
//            Map<Integer, List<SectionInfo>> delInfos = ListHandlerCenter.getInstance().getDeleteInfos(account_id, obj);
            //重要逻辑一：更新数据库
            if (delFlag) {
                bDeleted = DBAgentHibernateImpl.getInstance().delete(account_id, obj);
            } else {
                bDeleted = DBAgentHibernateImpl.getInstance().fakeDelete(account_id, obj);
            }
            if (!bDeleted) {
                LogHelper.deleteError(log, clazz, account_id, id, delFlag);
                return delFlag;
            }
            List<LsCacheInfoHelper> lsCacheInfos = ObjectUtil.getLsInfoList(obj);
            if (CollectionUtils.isNotEmpty(lsCacheInfos)) {
                for (LsCacheInfoHelper lsHelper : lsCacheInfos) {
                    Cache cache = CacheHelper.getListCache(lsHelper.getRegion());
                    if (null != cache) {
                        cache.remove(lsHelper.getListCountKey());
                        cache.remove(lsHelper.getListVisitInfoKey());
                    }
                }
            }
//			// 重要逻辑二：删除List
//			ListHandlerCenter.getInstance().processDelete(account_id, clazz, obj, delInfos);
            // 重要逻辑三：更新该对象所对应的缓存
            CacheHelper.delete(clazz.getName(), id + "");
            // 重要逻辑四: 删除对象所对应的Map
            MapCacheHelper.removeFromCache(obj);

        } catch (Exception e) {
            processException(e);
        } finally {
            try {
                if (bLock) {
                    VisitHelper.getInstance().endLoadWithDelete(obj);
                    if (!delFlag) {
                        VisitHelper.getInstance().endLoadWithDelete(oldObj);
                    }
                }
            } catch (Exception e) {
                processException(e);
            }
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: realDelete region: " + clazz.getName() + " params: " + id + " time: " + usedTime);
            }
        }
        return bDeleted;

    }

    /**
     * @param clazz: 待删除对象的class类型
     * @param ids    :
     *               待删除对象的id列表
     * @todo :deleteList的逻辑需要进一步确认，以避免脏数据 删除逻辑：1.先删除数据库中记录，再更新缓存 2.逐个更新缓存中的对象
     */

    private boolean realDeleteList(Object account_id, Class clazz, List ids, boolean delFlag) throws DaoException {
        DalAssert.assertObjectNotNull(clazz);
        DalAssert.assertObjectNotNull(ids);
        boolean bDeleted = true;
        try {
            for (Object id : ids) {
                realDelete(account_id, clazz, (Serializable) id, delFlag);
            }
        } catch (Exception e) {
            bDeleted = false;
            processException(e);
        }
        return bDeleted;
    }

    public boolean deleteList(Object account_id, Class clazz, List ids) throws DaoException {
        return realDeleteList(account_id, clazz, ids, true);
    }

    public boolean deleteList(Class clazz, List ids) throws DaoException {
        return deleteList(null, clazz, ids);
    }

    public boolean fakeDeleteList(Object account_id, Class clazz, List ids)
            throws DaoException {
        return realDeleteList(account_id, clazz, ids, false);
    }

    public boolean fakeDeleteList(Class clazz, List ids) throws DaoException {
        return fakeDeleteList(null, clazz, ids);
    }

    /**
     * @param account_id:
     * @param list_name   :
     * @param params      :
     */
    public boolean deleteList(Object account_id, String list_name, Object[] params) throws DaoException {
        DalAssert.assertObjectNotNull(list_name);
        DalAssert.assertObjectNotNull(params);
        boolean res = true;
        try {
            List idList = getIdList(account_id, list_name, params, true);
            if (null != idList && idList.size() > 0) {
                String clsName = DaoHelper.getObjectNameByListName(list_name);
                if (StringUtils.isBlank(clsName)) {
                    LogHelper.failedGetClassNameByListName(log, list_name);
                    return true;
                }
                res = deleteList(account_id, Class.forName(clsName), idList);
            }
        } catch (Exception e) {
            processException(e);
        }
        return res;
    }


    public boolean deleteList(String list_name, Object[] params) throws DaoException {
        return deleteList(null, list_name, params);
    }


    public boolean deleteList(Object account_id, String list_name, Object param) throws DaoException {
        if (null == param) {
            return deleteList(account_id, list_name, new Object[]{});
        } else {
            return deleteList(account_id, list_name, new Object[]{param});
        }
    }


    public boolean deleteList(String list_name, Object param) throws DaoException {
        return deleteList(null, list_name, param);
    }

    public boolean fakeDeleteList(Object account_id, String list_name, Object[] params) throws DaoException {
        DalAssert.assertObjectNotNull(list_name);
        DalAssert.assertObjectNotNull(params);
        boolean res = true;
        try {
            List idList = getIdList(account_id, list_name, params, true);
            if (null != idList && idList.size() > 0) {
                String clsName = DaoHelper.getObjectNameByListName(list_name);
                if (StringUtils.isBlank(clsName)) {
                    LogHelper.failedGetClassNameByListName(log, list_name);
                    return true;
                }
                res = realDeleteList(account_id, Class.forName(clsName), idList, false);
            }
        } catch (Exception e) {
            processException(e);
        }
        return res;
    }

    public boolean fakeDeleteList(String list_name, Object[] params) throws DaoException {
        return fakeDeleteList(null, list_name, params);
    }

    public boolean fakeDeleteList(Object account_id, String list_name, Object param) throws DaoException {
        if (null == param) {
            return fakeDeleteList(account_id, list_name, new Object[]{});
        } else {
            return fakeDeleteList(account_id, list_name, new Object[]{param});
        }
    }

    public boolean fakeDeleteList(String list_name, Object param) throws DaoException {
        return fakeDeleteList(null, list_name, param);
    }


    /**
     * 缓存 --》最大值 --》不存在的值 --》数据库 读取逻辑： 先读取缓存中的数据，不存在的则从数据库加载，并更新缓存
     */
    public Object get(Object account_id, Class clazz, Serializable id) throws DaoException {
        DalAssert.assertClassTypeNotNull(clazz);
        DalAssert.assertObjectNotNull(id);

        long t1 = System.currentTimeMillis();
        Object obj = null;
        try {
            Cache cache = CacheHelper.getClassCache(clazz);
            if (null == cache) {
                obj = DBAgentHibernateImpl.getInstance().get(account_id, clazz, id);
            } else {
                if (CacheHelper.isDelete(clazz.getName(), id + "")) {
                    LogHelper.objectHasBeenDeleted(log, clazz, id);
                    return null;
                }
                obj = CacheHelper.get(clazz.getName(), id + "");
                if (null == obj) {
//                    Long maxId = MaxIdHolder.getMaxId(Constants.MaxIdPrefix + clazz.getName());
//                    Long newId = new Long(id + "");
//                    if ((newId.longValue() <= maxId.longValue() || maxId.longValue() < 0l)) {
//                        if (!NullObjectContent.isNull(Constants.NullObjectPrefix + clazz.getName() + newId + "")) {
                    obj = DBAgentHibernateImpl.getInstance().get(account_id, clazz, id);
                    if (null != obj) {
                        CacheHelper.put(clazz.getName(), id + "", obj);
                    }
//                            else {
//                                NullObjectContent.setNull(Constants.NullObjectPrefix + clazz.getName() + newId + "");
//                            }
//                        }
//                    }
                }// if
            }//else
            //数据的合法性 验证 ，Just For More safety ^_^
            DalAssert.assertObjectIllegal(account_id, obj);
        } catch (Exception e) {
            processException(e);
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: get region: " + clazz.getName() + " params: " + id + " time: " + usedTime);
            }
        }

        return obj;
    }


    public Object get(Class clazz, Serializable id) throws DaoException {
        return get(null, clazz, id);
    }

    /**
     * @param account_id
     * @param mappingName
     * @param params
     * @param bExtend     : 用于决定是否是扩展类型的Map，既返回值是一个数组
     * @return
     * @throws DaoException
     */
    public Object getRealMapping(Object account_id, String mappingName, Object[] params, boolean bExtend) throws DaoException {
        DalAssert.assertObjectNotNull(mappingName);
        DalAssert.assertObjectNotNull(params);

        long t1 = System.currentTimeMillis();
        Object obj = null;
        try {
            Cache cache = CacheHelper.getListCache(mappingName);
            SqlInfo sqlInfo = SqlUtil.getMappingSqlInfo(mappingName, params, bExtend);
            if (null == cache) {
                LogHelper.usingMappingWithDB(log);
                RoutingService.getInstance().setRoutingStrategyForMap(mappingName, account_id, IStrategy.STRATEGY_R);
                List objList = DBAgentHibernateImpl.getInstance().getObjectList(account_id, mappingName, sqlInfo, 0l, 0l, IStrategy.STRATEGY_R, false, false);
                if (null == objList || objList.size() < 1) {
                    LogHelper.failedExecuteQueryFromDB(log, sqlInfo);
                    return null;
                }
                return objList.get(0);
            } else {
                MapInfo info = new MapInfo(mappingName, params);
                obj = CacheHelper.get(info.getRegion(), info.getKey());
                if (null == obj) {
//                    if (!NullObjectContent.isNull(Constants.NullObjectPrefix + "_" + info.getRegion() + "_" + info.getKey() + "")) {
                    RoutingService.getInstance().setRoutingStrategyForMap(mappingName, account_id, IStrategy.STRATEGY_R);
                    String dbName = ContextHolder.getDataSource();
                    List objList = DBAgentHibernateImpl.getInstance().getObjectList(account_id, mappingName, sqlInfo, 0l, 0l, IStrategy.STRATEGY_R, false, false);
                    if (null != objList && objList.size() > 0 && null != objList.get(0)) {
                        obj = objList.get(0);
                        CacheHelper.put(info.getRegion(), info.getKey(), objList.get(0));
                    }

//                        else {
//                            NullObjectContent.setNull(Constants.NullObjectPrefix + "_" + info.getRegion() + "_" + info.getKey() + "");
//                        }
//                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            processException(e);
        }

        long usedTime = System.currentTimeMillis() - t1;
        if (usedTime >= singleUsedTime) {
            if (permLog.isWarnEnabled()) {
                permLog.warn("method: getRealMapping region: " + mappingName + " size: " + params.length + " time: " + usedTime);
            }
        }

        return obj;
    }

    /**
     * 读取逻辑： 读取逻辑同get(....)方法相同
     *
     * @param account_id:
     * @param mappingName:
     */
    public Object getMapping(Object account_id, String mappingName, Object[] params) throws DaoException {
        return this.getRealMapping(account_id, mappingName, params, false);
    }

    public Object getMapping(String mappingName, Object[] keys)
            throws DaoException {
        return getMapping(null, mappingName, keys);
    }

    public Object getMapping(Object account_id, String mappingName, Object key) throws DaoException {
        if (null == key) {
            return getMapping(account_id, mappingName, new Object[]{});
        } else {
            return getMapping(account_id, mappingName, new Object[]{key});
        }
    }

    public Object getMapping(String mappingName, Object key) throws DaoException {
        return getMapping(null, mappingName, key);
    }


    /**
     * 读取逻辑： 先读缓存中的信息，如果没有再从数据库加载
     *
     * @param account_id :
     *                   策略id,仅用于数据库相关操作
     * @param list_name  :
     *                   对应于缓存中的region name
     * @param params     :
     *                   查询list，所需的参数
     */
    public int count(Object account_id, String list_name, Object[] params) throws DaoException {
        DalAssert.assertObjectNotNull(list_name);
        DalAssert.assertObjectNotNull(params);

        long t1 = System.currentTimeMillis();

        Long count = 0l;
        try {
            Cache cache = CacheHelper.getListCache(list_name);
            //没有缓存情况下的处理逻辑
            if (null == cache) {
                SqlInfo sqlInfo = SqlUtil.getListCountSql(list_name, params);
                int lsType = ObjectUtil.getListType(list_name);
                //跨库查询的情况，是把每个List的总数，加起来
                if (lsType == Constants.CROSSDB_TYPE) {
                    List<List> list = DBAgentHibernateImpl.getInstance().crossDBList(account_id, list_name, sqlInfo, 0, 1, IStrategy.STRATEGY_R);
                    if (null != list) {
                        for (List ls : list) {
                            count += ((Number) ls.get(0)).intValue();
                        }
                    }
                    return count.intValue();
                } else {
                    List list = DBAgentHibernateImpl.getInstance().getObjectList(account_id, list_name, sqlInfo, 0l, 1l, IStrategy.STRATEGY_R, true, true);
                    return ((Number) list.get(0)).intValue();
                }
            }
            // 设置缓存情况下的处理逻辑
            else {
                LsCacheInfo lsInfo = new LsCacheInfo(list_name, params);
                ListInfoHelper infoHelper =
                        ListLoaderCenter.getInstance().getListInfo(account_id, new LsCacheInfoHelper(lsInfo), IStrategy.STRATEGY_R, Constants.UsingLock);
                if (null != infoHelper) {
                    count = infoHelper.getSize();
                }
                long usedTime = System.currentTimeMillis() - t1;
                if (usedTime >= singleUsedTime) {
                    if (permLog.isWarnEnabled()) {
                        permLog.warn("method: count region: " + list_name + " params: " + lsInfo.getKey() + " time: " + usedTime);
                    }
                }
            }
        } catch (Exception e) {

            processException(e);
        }


        return count.intValue();
    }

    /*
           * (non-Javadoc)
           *
           * @see com.sohu.sns.dal.dao.Dao#count(java.lang.String, java.lang.Object[])
           */

    public int count(String list_name, Object[] params) throws DaoException {
        return count(null, list_name, params);
    }

    /*
           * (non-Javadoc)
           *
           * @see com.sohu.sns.dal.dao.Dao#count(java.lang.Long, java.lang.String,
           *      java.lang.Object)
           */

    public int count(Object account_id, String list_name, Object param)
            throws DaoException {
        if (null == param) {
            return count(account_id, list_name, new Object[]{});
        } else {
            return count(account_id, list_name, new Object[]{param});
        }
    }

    /*
           * (non-Javadoc)
           *
           * @see com.sohu.sns.dal.dao.Dao#count(java.lang.String, java.lang.Object)
           */

    public int count(String list_name, Object param) throws DaoException {
        return count(null, list_name, param);
    }

    /**
     * @param account_id :策略id, 仅用于从数据库中加载数据时
     * @param list_name  :
     * @param start      :
     *                   start从 0 开始计数
     * @param count      :
     * @param forward    :
     */
    public List getIdList(Object account_id, String list_name, Object[] params, Integer start, Integer count, boolean forward) throws DaoException {
        long t1 = System.currentTimeMillis();

        DalAssert.assertObjectNotNull(list_name);
        DalAssert.assertObjectNotNull(params);
        DalAssert.assertObjectNotNull(start);
        DalAssert.assertObjectNotNull(count);

        List idList = new ArrayList();
        ListInfoHelper infoHelper = null;
        Cache cache = null;
        LsCacheInfoHelper lsHelper = new LsCacheInfoHelper(list_name, params);

        try {
            cache = CacheHelper.getListCache(list_name);
            //未配置缓存情况下的处理逻辑
            if (null == cache) {
                SqlInfo sqlInfo = SqlUtil.getListSql(list_name, params, forward);
                long lsType = ObjectUtil.getListType(list_name);
                if (lsType == Constants.CROSSDB_TYPE) {
                    return DBAgentHibernateImpl.getInstance().getOrderedCrossList(account_id, list_name, sqlInfo, new Long(start.intValue()), new Long(count.intValue()), IStrategy.STRATEGY_R, forward);
                } else {
                    return DBAgentHibernateImpl.getInstance().getObjectList(account_id, list_name, sqlInfo, new Long(start.intValue()), new Long(count.intValue()), IStrategy.STRATEGY_R, true, false);
                }
            }
            //配置缓存情况下的处理逻辑
            //第一步：从缓存中取该List的ListInfo 对象
            infoHelper = ListLoaderCenter.getInstance().getListInfo(account_id, lsHelper, IStrategy.STRATEGY_R, Constants.UsingLock);
            if (null == infoHelper || infoHelper.getSize() < 1 || start.intValue() >= infoHelper.getSize()) {
                return idList;
            }
            ListLoadInfo listLoadInfo = infoHelper.getListLoadInfo(new Long(start.intValue()), forward);
            if (null == listLoadInfo) {
                System.out.println("\r\n ListLoadInfo of List " + lsHelper.getRegion() + " key: " + lsHelper.getKey() + " is null,when list's size is " + infoHelper.getSize() + "\r\n");
                if (infoHelper.getSize() > 0) {
                    CacheHelper.removeListInfo(lsHelper);
                    infoHelper = ListLoaderCenter.getInstance().getListInfo(account_id, lsHelper, IStrategy.STRATEGY_R, Constants.NoLock);
                    if (null == infoHelper || infoHelper.getSize() < 1 || start.intValue() >= infoHelper.getSize()) {
                        System.out.println("\r\n Again : ListLoadInfo of List " + lsHelper.getRegion() + " key: " + lsHelper.getKey() + " is null,when list's size is " + infoHelper.getSize() + "\r\n");
                        return idList;
                    }
                    listLoadInfo = infoHelper.getListLoadInfo(new Long(start.intValue()), forward);
                    if (null == listLoadInfo) {
                        System.out.println("\r\n ListLoadInfo of List " + lsHelper.getRegion() + " key: " + lsHelper.getKey() + " is null,when list's size is " + infoHelper.getSize() + "\r\n");
                        return idList;
                    }
                } else {
                    return idList;
                }
            }
            if (forward) {
                for (long j = count.intValue(), i = listLoadInfo.sectionNo; i >= 0 && j > 0; i--) {
                    int startIndex = 0;
                    List idCacheList = ListLoaderCenter.getInstance().getSectionIdList(lsHelper, infoHelper, account_id, i, IStrategy.STRATEGY_R, Constants.UsingLock);
                    if (null == idCacheList || idCacheList.size() < 1) {
                        break;
                    }
                    if (i == listLoadInfo.sectionNo) {
                        startIndex = listLoadInfo.indexInSection.intValue();
                        //新加的，为了增强了容错能力
                        if (startIndex >= idCacheList.size()) {
                            LogHelper.listInfoNotMatchSectionInCache(log, lsHelper, listLoadInfo, idCacheList);
                            startIndex = idCacheList.size() - 1;
                        }
                    } else {
                        startIndex = idCacheList.size() - 1;
                    }
                    for (int m = startIndex; m >= 0 && j > 0; m--) {
                        idList.add(idCacheList.get(m));
                        j--;
                    }
                }
            } else {
                for (long j = count.intValue(), i = listLoadInfo.sectionNo; i <= infoHelper.getMaxSectionNo() && j > 0; i++) {
                    int startIndex = 0;
                    List idCacheList = ListLoaderCenter.getInstance().getSectionIdList(lsHelper, infoHelper, account_id, i, IStrategy.STRATEGY_R, Constants.UsingLock);
                    if (null == idCacheList || idCacheList.size() < 0) {
                        break;
                    }
                    if (i == listLoadInfo.sectionNo) {
                        startIndex = listLoadInfo.indexInSection.intValue();
                        //新加的，为了增强了容错能力
                        if (startIndex >= idCacheList.size()) {
                            LogHelper.listInfoNotMatchSectionInCache(log, lsHelper, listLoadInfo, idCacheList);
                            startIndex = idCacheList.size() - 1;
                        }
                    } else {
                        startIndex = 0;
                    }
                    for (int m = startIndex; m < idCacheList.size() && j > 0; m++) {
                        idList.add(idCacheList.get(m));
                        j--;
                    }
                }
            }
            long usedTime = System.currentTimeMillis() - t1;
            if (usedTime >= singleUsedTime) {
                if (permLog.isWarnEnabled()) {
                    if (null != lsHelper) {
                        permLog.warn("method: getIdList region: " + list_name + " params: " + lsHelper.getKey() + "&" + start + "&" + count + " time: " + usedTime);
                    }
                }
            }

        } catch (Exception e) {
            processException(e);
        }


        return idList;
    }

    public List getIdList(Object account_id, String list_name, Object[] params, boolean forward) throws DaoException {
        int totalCount = count(account_id, list_name, params);
        if (totalCount <= 0) {
            return new ArrayList();
        }
        return getIdList(account_id, list_name, params, 0, totalCount, forward);
    }


    public List getIdList(String list_name, Object[] params, boolean forward) throws DaoException {
        return getIdList(null, list_name, params, forward);
    }


    public List getIdList(Object account_id, String list_name, Object param, boolean forward) throws DaoException {
        if (null == param) {
            return getIdList(account_id, list_name, new Object[]{}, forward);
        } else {
            return getIdList(account_id, list_name, new Object[]{param},
                    forward);
        }
    }


    public List getIdList(String list_name, Object param, boolean forward) throws DaoException {
        return getIdList(null, list_name, param, forward);
    }

    public List getIdList(String list_name, Object[] params, Integer start, Integer count, boolean forward) throws DaoException {
        return getIdList(null, list_name, params, start, count, forward);
    }


    public List getIdList(Object account_id, String list_name, Object param, Integer start, Integer count, boolean forward) throws DaoException {
        if (null == param) {
            return getIdList(account_id, list_name, new Object[]{}, start, count, forward);
        } else {
            return getIdList(account_id, list_name, new Object[]{param}, start, count, forward);
        }
    }

    public List getIdList(String list_name, Object param, Integer start, Integer count, boolean forward) throws DaoException {
        return getIdList(null, list_name, param, start, count, forward);
    }


    /**
     * @param account_id:
     * @param clazz:
     * @param ids:
     */
    public List getList(Object account_id, Class clazz, List ids) throws DaoException {
        List objList = getListWithNULLOBJ(account_id, clazz, ids);
        List resList = new ArrayList();
        if (CollectionUtils.isNotEmpty(objList)) {
            for (Object obj : objList) {
                if (null != obj) {
                    resList.add(obj);
                }
            }
        }
        return resList;
    }

    public List getList(Class clazz, List ids) throws DaoException {
        return getList(null, clazz, ids);
    }

    @Override
    public List getListWithNULLOBJ(Object account_id, Class clazz, List ids) throws DaoException {
        DalAssert.assertClassTypeNotNull(clazz);
        DalAssert.assertObjectNotNull(ids);

        long t1 = System.currentTimeMillis();
        List objList = new ArrayList();
        if (null == ids || ids.size() < 1) {
            log.warn(" id list is empty");
            return objList;
        }
        try {
            Cache cache = CacheHelper.getClassCache(clazz);
            if (null == cache) {
                objList = getObjectList(account_id, clazz, ids);
            }
            // 二.用户配置了缓存的情况
            else {
                List unExistIdList = new ArrayList();
                List<String> idStrList = new ArrayList<String>();
                List<Integer> indexLs = new ArrayList<Integer>();
                Map<String, Integer> indexIdMap = new HashMap<String, Integer>();
                for (Object id : ids) {
                    if (null != id) {
                        idStrList.add("" + id);
                    } else {
                        idStrList.add(null);
                    }
                }
                //用多线程的方式，读取数据
                Object[] obs = MultiCacheGet.get(cache, (String[]) idStrList.toArray(new String[idStrList.size()]));
                if (null == obs || 1 == obs.length) {
                    for (int j = 0; j < ids.size(); j++) {
                        indexLs.add(j);
                        unExistIdList.add(ids.get(j));
                        indexIdMap.put("" + ids.get(j), j);
                    }
                    unExistIdList = ids;
                } else {
                    for (int i = 0; i < obs.length; i++) {
                        Object object = obs[i];
                        if (null == object) {
                            indexLs.add(i);
                            unExistIdList.add(ids.get(i));
                            indexIdMap.put("" + ids.get(i), i);
                        }
                    }
                }
                // 为存在缓存中的id的列表
                // 遍历查找未存储在缓存中的数据

                // 从数据库重新加载未在缓存中的对象
                if (unExistIdList.size() > 0) {
                    List newObjLs = getObjectList(account_id, clazz, unExistIdList);
                    if (newObjLs.size() > 0) {
                        Cache objCache = CacheHelper.getClassCache(clazz);
                        // 正常情况，缓存中未存在的对象，在数据库中都找到了
                        if (newObjLs.size() == unExistIdList.size()) {
                            for (int j = 0; j < newObjLs.size(); j++) {
                                Object object = newObjLs.get(j);
                                if (null != object) {
                                    objCache.put(unExistIdList.get(j) + "", object);
                                    obs[indexLs.get(j)] = object;
                                }
                            }
                        } else if (newObjLs.size() != unExistIdList.size()) {
                            for (Object obj : newObjLs) {
                                Object id = ObjectUtil.getObjectId(obj);
                                Integer index = indexIdMap.get(id + "");
                                objCache.put(id + "", obj);
                                obs[index] = obj;
                            }

                        }
                        // Attention :如果未从数据库中加载到全部的Object,则不做任何处理
                        else {
                            LogHelper.failedLoadObjectLsByIdLs(log, clazz);
                        }
                    }
                }
                if (null != obs && obs.length > 0) {
                    for (Object obj : obs) {
//                        if (null != obj) {
                        objList.add(obj);
//                        }
                    }

                } else {

                }

            }// else

            long usedTime = System.currentTimeMillis() - t1;
            if (usedTime >= singleUsedTime) {
                if (permLog.isWarnEnabled()) {
                    permLog.warn("method: getList region: " + clazz.getName()
                            + " size: " + ids.size() + " time: " + usedTime);
                }
            }
        } catch (Exception e) {
            processException(e);
        }
        return objList;

    }

    @Override
    public List getListWithNULLOBJ(Class clazz, List ids) throws DaoException {
        return getListWithNULLOBJ(null, clazz, ids);
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

    public List getMappings(Object accountId, String mapName, List<Object[]> paramsList) throws DaoException {
        DalAssert.assertObjectNotNull(accountId);
        DalAssert.assertObjectNotNull(mapName);
        DalAssert.assertObjectNotNull(paramsList);

        long t1 = System.currentTimeMillis();
        try {
            Cache cache = CacheHelper.getListCache(mapName);
            // 缓存不存在情况下处理逻辑
            if (null == cache) {
                return DBAgentHibernateImpl.getInstance().getMaps(accountId, mapName, paramsList);
            }
            // 用户配置了缓存情况下的处理逻辑
            else {
                List<Object[]> unExistList = new ArrayList<Object[]>();
                //批量查询的map，在缓存中Key值得数组
                List<String> mapKeyList = new ArrayList<String>();
                List<Integer> indexLs = new ArrayList<Integer>();
                for (Object[] obs : paramsList) {
                    MapInfo mapInfo = new MapInfo(mapName, obs);
                    mapKeyList.add(mapInfo.getKey());
                }
                //从缓存中批量取出，目前存放在缓存中的 ,Map
                Object[] obs = cache.get((String[]) mapKeyList.toArray(new String[mapKeyList.size()]));
                //情况一 ：缓存中一个也没有
                if (null == obs || 1 == obs.length) {
                    for (int j = 0; j < paramsList.size(); j++) {
                        indexLs.add(j);
                        unExistList.add(paramsList.get(j));
                    }
                } else {
                    for (int i = 0; i < obs.length; i++) {
                        Object object = obs[i];
                        if (null == object) {
                            indexLs.add(i);
                            unExistList.add(paramsList.get(i));
                        }
                    }
                }
                //为存在缓存中的id的列表
                //遍历查找未存储在缓存中的数据
                //从数据库重新加载未在缓存中的对象
                if (unExistList.size() > 0) {
                    List newObjLs = DBAgentHibernateImpl.getInstance().getMaps(accountId, mapName, unExistList);
                    if (newObjLs.size() > 0) {
                        if (newObjLs.size() == unExistList.size()) {
                            for (int j = 0; j < newObjLs.size(); j++) {
                                Object object = newObjLs.get(j);
                                if (null != object) {
                                    Object[] params = unExistList.get(j);
                                    MapInfo mapInfo = new MapInfo(mapName, params);
                                    cache.put(mapInfo.getKey(), object);
                                    obs[indexLs.get(j)] = object;
                                }
                            }
                        }
                        //Attention :如果未从数据库中加载到全部的Object,则不做任何处理
                        else {
                            LogHelper.failedLoadMapsLsByParams(log, mapName, paramsList);
                        }
                    }
                }
                //从数组转化到List,如果直接用Array.toList()会有问题
                List objList = new ArrayList();
                if (null != obs && obs.length > 0) {
                    for (Object obj : obs) {
                        objList.add(obj);
                    }
                }

                long usedTime = System.currentTimeMillis() - t1;
                if (usedTime >= singleUsedTime) {
                    if (permLog.isWarnEnabled()) {
                        permLog.warn("method: getMappings region: " + mapName + " size: " + paramsList.size() + " time: " + usedTime);
                    }
                }

                return objList;
            }//else
        }//try
        catch (Exception e) {
            processException(e);
            return null;
        }
    }

    @Override
    public Map getMappingsMap(Object accountId, String mapName, List<Object[]> paramsList) throws DaoException {
        Map resultMap = new HashMap();
        List resultList = getMappings(accountId,mapName,paramsList);
        if(CollectionUtils.isNotEmpty(paramsList) && CollectionUtils.isNotEmpty(resultList)){
            int size = paramsList.size();
            for(int i=0;i<size;i++){
                Object[]  objects = paramsList.get(i);
                Object obj = resultList.get(i);
                resultMap.put(objects,obj);
            }
        }
        return resultMap;
    }


    /**
     * 应用场景，得到好友在某个游戏中的排行榜
     *
     * @param :keys --- >查询参数的列表
     * @todo ---需要和永华确认，如果该object只配置了一个数据源，但整个数据库配置了多个数据源，遍历数据源时是否只遍历一个数据源
     */
    public List getMapList(List accountIdList, String mapname, List<Object[]> paramsList) throws DaoException {
        DalAssert.assertObjectNotNull(accountIdList);
        DalAssert.assertObjectNotNull(mapname);
        DalAssert.assertObjectNotNull(paramsList);
        List resList = new ArrayList();
        try {
            Cache cache = CacheHelper.getListCache(mapname);
            // 缓存不存在情况下处理逻辑
            if (null == cache) {
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
            } else {
                List<Object[]> unExistList = new ArrayList<Object[]>();
                //批量查询的map，在缓存中Key值得数组
                List<String> mapKeyList = new ArrayList<String>();
                List<Integer> indexLs = new ArrayList<Integer>();
                for (Object[] obs : paramsList) {
                    MapInfo mapInfo = new MapInfo(mapname, obs);
                    mapKeyList.add(mapInfo.getKey());
                }
                //从缓存中批量取出，目前存放在缓存中的 ,Map
                Object[] obs = cache.get((String[]) mapKeyList.toArray(new String[mapKeyList.size()]));
                //情况一 ：缓存中一个也没有
                if (null == obs || 1 == obs.length) {
                    for (int j = 0; j < paramsList.size(); j++) {
                        indexLs.add(j);
                        unExistList.add(paramsList.get(j));
                    }
                } else {
                    for (int i = 0; i < obs.length; i++) {
                        Object object = obs[i];
                        if (null == object) {
                            indexLs.add(i);
                            unExistList.add(paramsList.get(i));
                        }
                    }
                }
                //为存在缓存中的id的列表
                //遍历查找未存储在缓存中的数据
                //从数据库重新加载未在缓存中的对象
                if (unExistList.size() > 0) {
                    for (int i = 0; i < unExistList.size(); i++) {
                        int oldIndex = indexLs.get(i);
                        Object obj = getRealMapping(accountIdList.get(oldIndex), mapname, unExistList.get(i), true);
                        if (null != obj) {
                            obs[oldIndex] = obj;
                        }
                    }
                }
                //从数组转化到List,如果直接用Array.toList()会有问题
                List objList = new ArrayList();
                if (null != obs && obs.length > 0) {
                    for (Object obj : obs) {
                        objList.add(obj);
                    }
                }
                return objList;
            }
        } catch (Exception e) {
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
//	else{
//	   Cache cache = CacheHelper.getListCache("");
//	   
//    if (this.hasRoute) {
//        try {
//     	   
//    		RoutingService.getInstance().setRoutingStrategyForObject(clazz,account_id, IStrategy.STRATEGY_R);
//    		ContextHolder.getDataSource();
//            routingService.setRoutingStrategy(this.regionName, key);
//        } catch (Exception e) {
//            throw new CacheException(e);
//        }
//    }
//	   
//	   cache.get(key)
//}

    @Override
    public Long getMaxIdOfClass(Class clazz) throws DaoException {
        return null;
    }


    @Override
    public Object excuteSimpleSql(String sql, Class clazz) throws DaoException {
        //log.info("enter into method excuteSimpleSql, param is " + sql);
        return DBAgentHibernateImpl.getInstance().excuteSimpleSql(sql, clazz);
    }
}
