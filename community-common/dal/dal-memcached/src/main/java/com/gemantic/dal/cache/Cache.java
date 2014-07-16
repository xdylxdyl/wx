package com.gemantic.dal.cache;

/**
 * @author allenshen
 */
import java.util.Map;

import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.cache.listener.Listener;

public interface Cache {
    public void regListener(Listener listener);

    /**
     * Adds data to the Server
     * 
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
    public boolean put(java.lang.String key, java.lang.Object value) throws CacheException;
    
    
    /**
     * Adds data to the Server
     * 
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
    public boolean put(java.lang.String key, java.lang.Object value, Long seconds) throws CacheException;    

    /**
     * Adds data to the Server
     * 改方法主要提供给Dao调用，配合Dao的Save， 从Cache理解出发和Put一样，在Listeners中会发Save
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
    public boolean save(java.lang.String key, java.lang.Object value) throws CacheException;

    /**
     * Adds many data to the Server
     * 保存多个对象到Cache
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
    public boolean save(Map<String, Object> objectsMap) throws CacheException;    
    /**
     * Retrieve a key from the server,
     * 
     * @param key
     * @return
     * @throws CacheException
     */
    public Object get(java.lang.String key) throws CacheException;
    

    /**
     * Retrieve multiple objects from server,
     * 
     * @param key
     * @return
     * @throws CacheException
     */
    public Object[] get(java.lang.String key[]) throws CacheException;    

    /**
     * Delete 操作会在Cache中 打上删除标记 Deletes an object from cache given cache key
     * 
     * @param key
     * @return
     * @throws CacheException
     */
    public boolean delete(java.lang.String key) throws CacheException;

    /**
     * remove 操作不会在Cache中 打上删除标记 remove an object from cache given cache key
     * 
     * @param key
     * @return
     * @throws CacheException
     */
    public boolean remove(java.lang.String key) throws CacheException;

    /**
     * Updates data on the server;
     * 
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
    public boolean update(java.lang.String key, java.lang.Object value) throws CacheException;

    public String getRegion() throws CacheException;

    public boolean isDelete(java.lang.String key) throws CacheException;
    
    /**
     * 增加数据，必须保证Key存在，如果不存在发回-1;
     * @param key
     * @param inc
     * @return
     * @throws CacheException
     */
    public long incr(String key, long inc) throws CacheException;
    
    /**
     * 减少数据，必须保证Key存在，如果不存在返回-1，数据降到0为止；
     * @param key
     * @param inc
     * @return
     * @throws CacheException
     */
    public long decr(String key, long inc) throws CacheException;
}
