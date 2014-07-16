package com.gemantic.dal.dao.helper;

import org.apache.commons.lang.ArrayUtils;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.exception.CacheException;

import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.concurrent.*;


/**
 * Created by IntelliJ IDEA.
 * User: arthurkang
 * Date: 2009-11-11
 * Time: 13:27:01
 * To change this template use File | Settings | File Templates.
 */
public class MultiCacheGet {
    Logger logger = Logger.getLogger(MultiCacheGet.class.getName());

    private final static int BATCH_GET_NUMBER = 30;

    private final static long TIME_OUT = 100;

    private static final ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static MultiCacheGet multiGet;

    public static Object[] get(final Cache cache, String[] keys) throws CacheException {
        //初次设定一次最多取30
        if (!ArrayUtils.isEmpty(keys) && keys.length > BATCH_GET_NUMBER) {
            Object[] lObjects = new Object[0];
            Map<String, Object[]> resMap = new HashMap<String, Object[]>();
            try {
                CompletionService completionService = new ExecutorCompletionService(executors);
                int i = 0;
                int index = 0;
                // 启动线程
                while (true) {
                    final String[] section_keys = (String[]) ArrayUtils.subarray(keys, index, index += BATCH_GET_NUMBER);
                    if (ArrayUtils.isEmpty(section_keys)) {
                        break;
                    } else {
                        i++;
                        final Integer queueNum = new Integer(i);
                        completionService.submit(new Callable() {
                            public Object call() {
                                Object[] fakeResult = new Object[section_keys.length];
                                Map<String, Object[]> map = new HashMap<String, Object[]>();
                                try {
                                    Object[] results = cache.get(section_keys);
                                    map.put(queueNum.toString(), results);
                                } catch (Exception e) {
                                    map.put(queueNum.toString(), fakeResult);
                                }
                                return map;
                            }

                        });
                    }// else
                }
                for (int j = 0; j < i; j++) {
                    Future future = completionService.poll(TIME_OUT, TimeUnit.SECONDS);
                    if (future != null) {
                        Map<String, Object[]> map = (Map<String, Object[]>) future.get();
                        resMap.putAll(map);
                    } else {
                        throw new CacheException("poll timeout!");
                    }
                }
                for (int j = 1; j <= i; j++) {
                    lObjects = ArrayUtils.addAll(lObjects, resMap.get(j + ""));
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return lObjects;
        } else {
            return cache.get(keys);
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
