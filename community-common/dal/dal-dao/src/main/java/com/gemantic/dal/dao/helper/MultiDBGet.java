package com.gemantic.dal.dao.helper;

import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.route.strategy.IStrategy;
import com.gemantic.dal.dao.helper.MultiCacheGet;

import java.util.logging.Logger;
import java.util.concurrent.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import org.apache.commons.lang.ArrayUtils;

/**
 * Created by IntelliJ IDEA.
 * User: arthurkang
 * Date: 2009-12-21
 * Time: 15:13:47
 * To change this template use File | Settings | File Templates.
 */
public class MultiDBGet {
    Logger logger = Logger.getLogger(MultiCacheGet.class.getName());

    private final static long TIME_OUT = 100;

    private static final ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static MultiCacheGet multiGet;

    public static List get(final Object account_id, final Class clazz, List<SqlInfo> sqlInfoLs) throws CacheException {
        ArrayList objList = new ArrayList();
        //初次设定一次最多取30
        Map<String, List> resMap = new HashMap<String, List>();
        try {
            CompletionService completionService = new ExecutorCompletionService(executors);
            int i = 0;
            int index = 0;
            // 启动线程
            while (true) {
                final SqlInfo sqlInfo = sqlInfoLs.get(index);
                if (null != sqlInfo) {
                    break;
                } else {
                    i++;
                    final Integer queueNum = new Integer(i);
                    completionService.submit(new Callable() {
                        public Object call() {
                            Map<String, List> map = new HashMap<String, List>();
                            try {
                                List entityLs = DBAgentHibernateImpl.getInstance().getEntityList(account_id, clazz, sqlInfo, IStrategy.STRATEGY_R);
                                map.put(queueNum.toString(), entityLs);
                            } catch (Exception e) {
                                e.printStackTrace(System.out);
                                e.printStackTrace(System.err);
                            }
                            return map;
                        }

                    });
                }// else
            }
            for (int j = 0; j < i; j++) {
                Future future = completionService.poll(TIME_OUT, TimeUnit.SECONDS);
                if (future != null) {
                    Map<String, List> map = (Map<String, List>) future.get();
                    resMap.putAll(map);
                } else {
                    throw new DaoException(100, "Dao GetList Exception");
                }
            }
            for (int j = 1; j <= i; j++) {
                List oList = resMap.get(j + "");
                for (Object obj : oList) {
                    objList.add(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return objList;
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
