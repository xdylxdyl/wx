package com.gemantic.dal.cache.impl;

import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import net.sf.ehcache.Element;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.cache.listener.Listener;

/**
 * 对EHCACHED的封装
 * 
 * 
 * @author allenshen date: Dec 16, 2008 3:32:23 PM Copyright 2008 Sohu.com Inc.
 *         All Rights Reserved.
 */
public class LocalCacheImpl implements Cache {
    private net.sf.ehcache.Cache ehCache;
    private String region;
    private Listener listener;

    public LocalCacheImpl(net.sf.ehcache.Cache ehCache, String regionName) {
        this.ehCache = ehCache;
        this.region = regionName;
    }

    public net.sf.ehcache.Cache getEhCache() {
        return ehCache;
    }

    public void setEhCache(net.sf.ehcache.Cache ehCache) {
        this.ehCache = ehCache;
    }

    public boolean delete(String key) throws CacheException {
        return this.ehCache.remove(key);
    }

    public boolean remove(String key) throws CacheException {
        return this.ehCache.remove(key);
    }

    public Object get(String key) throws CacheException {
        Element element = this.ehCache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public String getRegion() throws CacheException {
        return this.region;
    }

    public boolean put(String key, Object value) throws CacheException {
        Element element = new Element(key, value);
        this.ehCache.put(element);
        return true;
    }

    public void regListener(Listener listener) {
        this.listener = listener;

    }

    public boolean update(String key, Object value) throws CacheException {
        return this.put(key, value);
    }

    public boolean save(String key, Object value) throws CacheException {
        return this.put(key, value);
    }

    public boolean isDelete(String key) throws CacheException {
        throw new CacheException("please implements method.");
    }

    public Object[] get(String[] key) throws CacheException {
        if (ArrayUtils.isEmpty(key)) {
            return null;
        }

        Object[] lresult = new Object[key.length];
        for (int i = 0; i < key.length; i++) {
            lresult[i] = this.get(key[i]);
        }
        return lresult;

    }

    public boolean save(Map<String, Object> objectsMap) throws CacheException {
        throw new CacheException("this don't implements, Please while invoke in save single object");
    }

    @Override
    public long decr(String key, long inc) throws CacheException {
        throw new CacheException("please implements method.");
    }

    @Override
    public long incr(String key, long inc) throws CacheException {
        throw new CacheException("please implements method.");
    }

	@Override
	public boolean put(String key, Object value, Long seconds) throws CacheException {
		 throw new CacheException("please implements method.");
	}

}
