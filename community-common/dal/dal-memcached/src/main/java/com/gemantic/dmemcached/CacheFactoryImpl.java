package com.gemantic.dmemcached;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.CacheFactory;
import com.gemantic.dal.cache.client.CacheClient;
import com.gemantic.dal.cache.impl.CacheImpl;
import com.gemantic.dal.cache.listener.Listener;
import com.gemantic.dmemcached.config.helper.CacheConfigHelper;
import com.gemantic.dmemcached.route.RoutingServiceImpl;

public class CacheFactoryImpl implements CacheFactory {
    private static Logger logger = Logger.getLogger(CacheFactoryImpl.class);
    private static CacheFactory cacheFactory;
    private Map<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    private CacheClient cacheClient; // 非动态
    private CacheClient dCacheClient; // 动态
    private Lock lock = new ReentrantLock(false);

    private CacheFactoryImpl() {
        init();
    }

    private void init() {
        this.cacheClient = CacheConfigHelper.getCacheClient("default");
        this.dCacheClient = CacheConfigHelper.getDynamicCacheClient();
    }

    public static CacheFactory getInstance() {
        if (cacheFactory == null) {
            synchronized (CacheFactoryImpl.class) {
                if (cacheFactory == null) {
                    cacheFactory = new CacheFactoryImpl();
                }
            }
        }
        return cacheFactory;
    }

    public Cache getCache(String name) {
        Cache cache = null;
        if (StringUtils.isEmpty(name)) {
            logger.warn("cache name must have value");
            return null;
        } else {
            cache = caches.get(name);
            if (cache == null) {
                if (!CacheConfigHelper.isExistRegion(name)) {//这个Name（region）不需要Cache
                    return null;
                }                
                lock.lock();
                try {
                    cache = caches.get(name);
                    if (cache == null) {
                        cache = new CacheImpl(name, cacheClient, RoutingServiceImpl.getInstance());
                        if (cache != null) {
                            String listenerClass = CacheConfigHelper.getListenerClass(name);
                            Listener listener = null;
                            if (StringUtils.isNotEmpty(listenerClass)) {
                                try {
                                    listener = (Listener) Class.forName(listenerClass).newInstance();
                                } catch (Exception e) {
                                    logger.error(e.getMessage());
                                    e.printStackTrace(System.err);
                                }
                            }                        
                            cache.regListener(listener);
                            ((CacheImpl)cache).setEnableLocalCache(CacheConfigHelper.isLocalCache(name));
                            caches.put(name, cache);
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
            if (cache != null) {
                CacheClient cacheClient = ((CacheImpl) cache).getClient();
                if (cacheClient.isDynamic()) {
                    throw new RuntimeException("Cache must is  singleness module");
                }
            }

        }
        return cache;
    }

    /**
     * 
     */
    public Cache getCache(String name, boolean isDynamic) {
        Cache cache = null;
        if (StringUtils.isEmpty(name)) {
            logger.warn("cache name must have value");
            return null;
        } else {
            cache = caches.get(name);
            if (cache == null) {
                if (!CacheConfigHelper.isExistRegion(name)) {//这个Name（region）不需要Cache
                    return null;
                }                
                lock.lock();
                try {
                    cache = caches.get(name);
                    if (cache == null) {

                        String listenerClass = CacheConfigHelper.getListenerClass(name);
                        Listener listener = null;
                        if (StringUtils.isNotEmpty(listenerClass)) {
                            try {
                                listener = (Listener) Class.forName(listenerClass).newInstance();
                            } catch (Exception e) {
                                logger.error(e.getMessage());
                                e.printStackTrace(System.err);
                            }
                        }

                        if (isDynamic) {
                            cache = new CacheImpl(name, dCacheClient, RoutingServiceImpl.getInstance());
                        } else {
                            cache = new CacheImpl(name, cacheClient, RoutingServiceImpl.getInstance());
                        }
                        if (cache != null) {
                            cache.regListener(listener);
                            ((CacheImpl)cache).setEnableLocalCache(CacheConfigHelper.isLocalCache(name));
                            caches.put(name, cache);
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
            if (cache != null) {
                CacheClient cacheClient = ((CacheImpl) cache).getClient();
                if (cacheClient.isDynamic() != isDynamic) {
                    throw new RuntimeException("Cache don't match specify Dynamic module");
                }
            }

        }
        return cache;
    }

    public void removeCache(String name) {
        if (StringUtils.isNotEmpty(name))
            caches.remove(name);
    }

}
