package com.gemantic.dmemcached.client;

import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.client.CacheClient;
import com.gemantic.dal.cache.route.ContextHolder;

/**
 * Dynamic MemcachedClient Wrapper
 * 
 * 
 * @author allenshen date: Dec 9, 2008 4:39:09 PM Copyright 2008 Sohu.com Inc.
 *         All Rights Reserved.
 */
public class DMemcachedClientWrapper implements CacheClient {
    private Map<String, CacheClient> clients = null;
    private static Logger logger = Logger.getLogger(DMemcachedClientWrapper.class);

    public void setClients(Map<String, CacheClient> clients) {
        this.clients = clients;
    }

    public DMemcachedClientWrapper() {

    }

    public boolean delete(String key) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.delete(key);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }
    
    public boolean remove(String key) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.delete(key);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }
    public boolean delete(String key, Date expiry) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.delete(key, expiry);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    public boolean flushAll() {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.flushAll();
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    public Object get(String key) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.get(key);
        } else {
            logger.error("MemCachedClient is null");
            return null;
        }

    }

    public boolean replace(String key, Object value) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.replace(key, value);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    public boolean replace(String key, Object value, Date expiry) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.replace(key, value, expiry);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    public boolean set(String key, Object value) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.set(key, value);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    public boolean set(String key, Object value, Long expiry) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.set(key, value, expiry);
        } else {
            logger.error("MemCachedClient is null");
            return false;
        }
    }

    /**
     * 给出真正的CacheClient
     * 
     * @return
     */
    private CacheClient getCacheClient() {
        CacheClient client = null;
        if (MapUtils.isNotEmpty(this.clients)) {
            Object o = ContextHolder.getMemcachedName();
            client = o == null ? null : this.clients.get(o);
            if (client == null) {
                client = clients.values().iterator().next();
            }
        } else {
            logger.error("Please set CacheClient Map");
        }
        return client;
    }

    public boolean isDynamic() {
        // TODO Auto-generated method stub
        return true;
    }

    public Object[] getMultiArray(String[] keys) {
        CacheClient client = getCacheClient();
        if (client != null) {
            return client.getMultiArray(keys);
        } else {
            logger.error("MemCachedClient is null");
            return null;
        }
    }

    @Override
    public long decr(String key, long inc) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long incr(String key, long inc) {
        // TODO Auto-generated method stub
        return 0;
    }




}
