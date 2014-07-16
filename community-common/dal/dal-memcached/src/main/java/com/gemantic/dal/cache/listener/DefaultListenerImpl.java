package com.gemantic.dal.cache.listener;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.exception.CacheException;
/**
 * Cache操作的监听器
 * 
 * 
 * @author allenshen
 * date: Dec 16, 2008 3:32:50 PM
 * Copyright 2008 Sohu.com Inc. All Rights Reserved.
 */

public class DefaultListenerImpl implements Listener {
    private static Logger logger = Logger.getLogger(DefaultListenerImpl.class);

    public void afterListener(Cache cache, Object key, Object value, String operateMethod) {
//        try {
//            logger.info((new StringBuilder()).append("afterListener cache : ").append(cache.getRegion()).append(
//                    " key : ").append(ObjectUtils.toString(key, "")).append(
//                    " value : ").append(ObjectUtils.toString(value, "")).append(" method: ").append(operateMethod)
//                    .toString());
//        } catch (CacheException e) {
//            e.printStackTrace();
//        }
    }

    public void beforeListener(Cache cache, Object key, Object value, String operateMethod) {
//        try {
//            logger.info((new StringBuilder()).append("beforeListener cache : ").append(cache.getRegion()).append(
//            " key : ").append(ObjectUtils.toString(key, "")).append(
//            " value : ").append(ObjectUtils.toString(value, "")).append(" method: ").append(operateMethod)
//            .toString());
//        } catch (CacheException e) {
//            e.printStackTrace();
//        }
    }

    public void afterListener(Cache cache, Object[] key, Object[] value, String operateMethod) {
        // TODO Auto-generated method stub
        
    }

    public void beforeListener(Cache cache, Object[] key, Object[] value, String operateMethod) {
        // TODO Auto-generated method stub
        
    }
}
