package com.gemantic.dal.dao.util;


import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.collections.map.LRUMap;

public class DalLRUMap implements Map, Serializable {

    private static final long serialVersionUID = 1L;

    // logger
    private static final Log log = LogFactory.getLog(DalLRUMap.class);

    // lock
    private ReadWriteLock rw = new ReentrantReadWriteLock();

    private LRUMap map;

    /**
     * 默认100
     */
    public DalLRUMap() {
        map = new LRUMap();
    }

    /**
     * 构建指定大小的map
     * 
     * @param maxSize
     *            int
     */
    public DalLRUMap(int maxSize) {
        map = new LRUMap(maxSize);
    }

    /**
     * 构造函数
     * 
     * @param maxSize
     *            int
     * @param scanUntilRemovable
     *            boolean
     */
    public DalLRUMap(int maxSize, boolean scanUntilRemovable) {
        map = new LRUMap(maxSize, scanUntilRemovable);
    }

    /**
     * constructor
     * 
     * @param maxSize
     *            int
     * @param loadFactor
     *            float
     */
    public DalLRUMap(int maxSize, float loadFactor) {
        map = new LRUMap(maxSize, loadFactor);
    }

    /**
     * constructor
     * 
     * @param maxSize
     *            int
     * @param loadFactor
     *            float
     * @param scanUntilRemovable
     *            boolean
     */
    public DalLRUMap(int maxSize, float loadFactor, boolean scanUntilRemovable) {
        map = new LRUMap(maxSize, loadFactor, scanUntilRemovable);
    }

    public DalLRUMap(Map map) {
        map = new LRUMap(map);
    }

    public DalLRUMap(Map map, boolean scanUntilRemovable) {
        map = new LRUMap(map, scanUntilRemovable);
    }

    /**
     * size of the map
     * 
     * @return int
     */
    public int size() {
        int size = -1;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            size = map.size();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return size;
    }

    /**
     * 是否为空
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        boolean empty = true;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            empty = map.isEmpty();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return empty;
    }

    /**
     * 是否包含指定key
     * 
     * @param key
     *            Object
     * @return boolean
     */
    public boolean containsKey(Object key) {
        boolean contains = false;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            contains = map.containsKey(key);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return contains;
    }

    /**
     * 是否包含value
     * 
     * @param value
     *            Object
     * @return boolean
     */
    public boolean containsValue(Object value) {
        boolean contains = false;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            contains = map.containsValue(value);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return contains;
    }

    /**
     * 取得数据
     * 
     * @param key
     *            Object
     * @return Object
     */
    public Object get(Object key) {
        Lock lock = null;
        Object value = null;
        try {
            lock = rw.readLock();
            lock.lock();
            value = map.get(key);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return value;
    }

    /**
     * 存储数据
     * 
     * @param key
     *            Object
     * @param value
     *            Object
     * @return Object
     */
    public Object put(Object key, Object value) {
        Lock lock = null;
        Object object = null;
        try {
            lock = rw.writeLock();
            lock.lock();
            object = map.put(key, value);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return object;
    }

    /**
     * 删除数据
     * 
     * @param key
     *            Object
     * @return Object
     */
    public Object remove(Object key) {
        Lock lock = null;
        Object object = null;
        try {
            lock = rw.writeLock();
            lock.lock();
            object = map.remove(key);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return object;
    }

    /**
     * 整体存储t中的元素到map中
     * 
     * @param t
     *            Map
     */
    public void putAll(Map t) {
        Lock lock = null;
        try {
            lock = rw.writeLock();
            lock.lock();
            map.putAll(t);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        Lock lock = null;
        try {
            lock = rw.writeLock();
            lock.lock();
            map.clear();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }

    /**
     * 取得key集合
     * 
     * @return Set
     */
    public Set keySet() {
        Set set = null;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            set = map.keySet();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return set;
    }

    /**
     * 取得value集合
     * 
     * @return Collection
     */
    public Collection values() {
        Collection values = null;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            values = map.values();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return values;
    }

    public Set entrySet() {
        Set set = null;
        Lock lock = null;
        try {
            lock = rw.readLock();
            lock.lock();
            set = map.entrySet();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return set;
    }

    /**
     * 是否相等
     * 
     * @param o
     *            Object
     * @return boolean
     */
    public boolean equals(Object o) {
        return map.equals(o);
    }

    /**
     * hash code
     * 
     * @return int
     */
    public int hashCode() {
        return map.hashCode();
    }
}
