package com.gemantic.dmemcached.route.strategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.config.model.KeyPatternItem;
import com.gemantic.dal.cache.exception.StrategyException;
import com.gemantic.dal.cache.route.strategy.IStrategy;
import com.gemantic.dmemcached.config.helper.CacheConfigHelper;

/**
 * 
 * 
 * 
 * @author allenshen
 * date: Dec 18, 2008 11:59:43 AM
 * Copyright 2008 Sohu.com Inc. All Rights Reserved.
 */
public class DefaultStrategy implements IStrategy {
    private static Logger logger = Logger.getLogger(DefaultStrategy.class);

    public Object playStrategy(String regionName, Object key) throws StrategyException {
        if (StringUtils.isEmpty(regionName)) {
            throw new StrategyException("region name must have a value");
        }

        if (key == null) {
            throw new StrategyException("key must have a value");
        }

        Map<String, KeyPatternItem> keyPatternMap = CacheConfigHelper.getKeyKeyPatternItems(regionName);

        if (MapUtils.isEmpty(keyPatternMap)) {
            logger.warn("don't find KeyPatternItems of the " + regionName + " , begin use default set!");
            keyPatternMap = CacheConfigHelper.getDefaultKeyKeyPatternItems();
        }
        if (MapUtils.isEmpty(keyPatternMap)) {
            return null;
        }
        KeyPatternItem keyPatternItem = findPatternItem(keyPatternMap, key);
        return keyPatternItem != null ? keyPatternItem.getDatasource() : null;
    }

    /**
     * 想找到想用的patternItem
     * 
     * @param patternMap
     * @param account
     * @return
     */
    private KeyPatternItem findPatternItem(Map<String, KeyPatternItem> patternMap, Object key) {
        KeyPatternItem patternItem = null;
        Collection<KeyPatternItem> patternItems = patternMap.values();
        for (Iterator iterator = patternItems.iterator(); iterator.hasNext();) {
            KeyPatternItem item = (KeyPatternItem) iterator.next();
            if (item != null) {
                String value = item.getValue();
                if (StringUtils.isNotEmpty(value)) {
                    Pattern pattern = Pattern.compile(value);
                    if (pattern.matcher(ObjectUtils.toString(key)).find()) { // 找到了就退出
                        patternItem = item;
                        break;
                    }
                }
            }
        }
        return patternItem != null ? patternItem : patternItems.iterator().next();
    }
}
