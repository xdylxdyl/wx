package com.gemantic.dal.dao.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ListItem;
import com.gemantic.dal.config.model.dao.MapItem;
import com.gemantic.dal.config.model.method.ItemMethod;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.MapInfo;
import com.gemantic.dal.dao.util.Constants;

/**
 * @author arthurkang
 */
public class ObjectUtil {

    private static final Log log = LogFactory.getLog(ObjectUtil.class);

    private static Object[] getParams(ItemMethod item, Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method[] methods = item.getKeyMethod();
        if (null == methods || methods.length < 1 || null == object) {
//            log.info("Warn---List/Map: The Class:"+object.getClass()+" 's  key property related methods is null or empty");
            return null;
        }
        Object[] params = new Object[methods.length];
        StringBuffer keyBuffer = new StringBuffer();
        for (int i = 0; i < methods.length; i++) {// for1
            if (null != methods[i]) {
                Object propValue = methods[i].invoke(object);
                if (null == propValue) {
//                    log.error("Error--List/Map: Can't get property value of Class: "+object.getClass()+" by invoke Method:"+methods[i].getName());
                    return null;
                }
                params[i] = propValue;
            } else {
//                log.error("Error--List/Map: The Class :"+object.getClass()+"'s one method for property  getting or setting is null or empty");
                return null;
            }
        }
        return params;
    }

    public static Object[] getOrderByParams(ListItem item, Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method[] methods = item.getOrderByMethod();
        if (null == methods || methods.length < 1 || null == object) {
//            log.info("Warn---List/Map: The Class:"+object.getClass()+" 's orderBy property related methods is null or empty");
            return null;
        }
        Object[] params = new Object[methods.length];
        StringBuffer keyBuffer = new StringBuffer();
        for (int i = 0; i < methods.length; i++) {// for1
            if (null != methods[i]) {
                Object propValue = methods[i].invoke(object);
                if (null == propValue) {
//                    log.error("Error--List/Map: Can't get property value of Class: "+object.getClass()+" by invoke orderByMethod:"+methods[i].getName());
                    return null;
                }
                params[i] = propValue;
            } else {
//                log.error("Error--List/Map: The Class :"+object.getClass()+"'s one OrderBy method for property  getting or setting is null or empty");
                return null;
            }
        }
        return params;
    }

    public static Object getObjectValueOfList(Object obj, LsCacheInfoHelper lsHelper) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        ListItem listItem = DaoHelper.getListItemByListName(lsHelper.getRegion());
        Method method = listItem.getValueMethod();
        if (null == method) {
//            log.info("Warn---List"+lsHelper.getRegion()+": The Class:"+obj.getClass()+" 's  value property related method is null or empty");
            return null;
        }
        Object valueOfObj = method.invoke(obj);
        return valueOfObj;
    }


    public static Serializable getObjectId(Object object) throws Exception {
        Method method = DaoHelper.getIdMethod(object.getClass());
        if (null == method) {
//                log.error("Error: The Class :"+object.getClass().getName()+"'s getId() method is null \r\n");
            return null;
        }
        return (Serializable) method.invoke(object);
    }

    public static List<MapInfo> getMapInfoList(Object object) throws Exception {
        List<MapInfo> list = new ArrayList<MapInfo>();
        List<MapItem> mapList = DaoHelper.getMapItemsByObjectName(object.getClass().getName());
        // 重要逻辑： 只有在对象中有相应Map元素的时候才进行处理。
        if (null != mapList && mapList.size() > 0) {
            for (MapItem item : mapList) {
                if (null == item) {
                    continue;
                }
                String region = item.getName();
                Object[] params = getParams(item, object);
                if (null == params || params.length < 1) {
//                    log.info("Attention: The params[keyProperty in dao.xml] for Region:"+region+" is null \r\n");
                    continue;
                }
                Method method = item.getValueMethod();
                if (null == method) {
                    log.info("Attention: Value Method in MapItem is null \r\n");
                    continue;
                }
                Object value = method.invoke(object);
                if (null == value) {
//                    log.info("Warn: The value of object's "+method.getName()+" for Region:"+region+" is null or empty \r\n");
                    continue;
                }
                list.add(new MapInfo(region, params, value));
            }
        }
        return list;

    }

    public static List<LsCacheInfoHelper> getLsInfoList(Object object) throws Exception {
        List<LsCacheInfoHelper> list = new ArrayList<LsCacheInfoHelper>();
        List<ListItem> listItemList = DaoHelper.getListItemsByObjectName(object.getClass().getName());
        if (null != listItemList && listItemList.size() > 0) {
            for (ListItem item : listItemList) {
                if (null == item) {
//                    log.info("Attention : The ListItem of class "+object.getClass()+" is null \r\n");
                    continue;
                }
                // 得到List 所存放的Region 名字
                String region = item.getName();
                if (StringUtils.isBlank(region)) {
//                    log.info("Attention: List name of class "+object.getClass()+"is empty ,check it on dao.xml \r\n");
                    continue;
                }
                // 如果得到<List>中由keyProperty 组成的在缓存中存放的key值不为空，则尝试更新缓存中的值
                Object[] params = getParams(item, object);
                if (null == params || params.length < 1) {
//                    log.info("Warn: The params for Region: "+region+" is null or empty \r\n");
                    continue;
                }
                // 如果得到<List>中由orderByProperty 组成的在缓存中存放的key值不为空，则尝试更新缓存中的值
                Object[] orderByParams = getOrderByParams(item, object);
                if (null == orderByParams || orderByParams.length < 1) {
//                    log.info("Warn: The orderByParams for Region: "+region+" is null or empty \r\n");
                }
                LsCacheInfo info = new LsCacheInfo(region, params, orderByParams, item.getType(), item.isInvalidOnSave());
                list.add(new LsCacheInfoHelper(info));
            }
        }
        return list;
    }

    // 通过List的名字，确定该List的种类，目前系统支持的list包括，普通list,支持跨库的list
    public static Integer getListType(String listName) {
        ListItem listItem = DaoHelper.getListItemByListName(listName);
        Integer type = listItem.getType();
        if (null == type) {
            type = new Integer(Constants.COMMON_TYPE);
        }
        return type;
    }

    public static Object getObjectStrategyPropert(Object obj) throws Exception {
        Method method = DaoHelper.getStrategyPropertyMethod(obj.getClass().getName());
        if (null == method) {
            return null;
        }
        return method.invoke(obj);
    }

    //得到在跨库查询的情况下，应该从每个库取出的id数量
    public static Long getCrossPerDBCount(String listName) throws Exception {
        Integer listTotalCnt = 0;
        long perDbCnt = 0;
        ListItem listItem = DaoHelper.getListItemByListName(listName);
        if (null != listItem.getType() && Constants.CROSSDB_TYPE == listItem.getType()) {
            listTotalCnt = listItem.getCrossMaxCnt();
            if (null == listTotalCnt || listTotalCnt < 1) {
                listTotalCnt = Constants.Cross_MaxDB_Count;
            }
            int DBCnt = DaoHelper.getCountDaoGroupByListName(listName);
            if (0 == DBCnt) {
                DBCnt = 2;
            }
            perDbCnt = listTotalCnt / DBCnt;
        }
        return perDbCnt;
    }


}
