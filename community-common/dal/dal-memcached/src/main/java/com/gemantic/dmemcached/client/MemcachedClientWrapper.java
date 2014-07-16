package com.gemantic.dmemcached.client;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.gemantic.dal.cache.client.CacheClient;
/**
 * MemcachedClient Wrapper 
 * 
 * 
 * @author allenshen
 * date: Dec 9, 2008 4:39:52 PM
 * Copyright 2008 Sohu.com Inc. All Rights Reserved.
 */
public class MemcachedClientWrapper implements CacheClient {
    private MemCachedClient client;

    public MemcachedClientWrapper(MemCachedClient client) {
        this.client = client;
    }


    public boolean delete(String key) {
        return client.delete(key);
    }


    public boolean delete(String key, Date expiry) {
        return client.delete(key, expiry);
    }
    
    public boolean remove(String key) {
        return client.delete(key);
    }

    public boolean flushAll() {
        return client.flushAll();
    }


    public Object get(String key) {
        return client.get(key);
    }


    public boolean replace(String key, Object value) {
        return client.replace(key, value);
    }


    public boolean replace(String key, Object value, Date expiry) {
        return client.replace(key, value, expiry);
    }


    public boolean set(String key, Object value) {
        return client.set(key, value);
    }


    public boolean set(String key, Object value, Long expiry) {
        return client.set(key, value, new Date(expiry));
    }


    public boolean isDynamic() {
        return false;
    }


    public Object[] getMultiArray(String[] keys) {
        return client.getMultiArray(keys);
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
