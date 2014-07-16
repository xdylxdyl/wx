package com.gemantic.dmemcached.config.helper;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.client.CacheClient;
import com.gemantic.dal.cache.config.model.KeyPatternItem;
import com.gemantic.dal.cache.config.model.RegionItem;
import com.gemantic.dmemcached.config.CacheConfig;

public final class CacheConfigHelper {
    private static Logger logger = Logger.getLogger(CacheConfigHelper.class);

    /**
     * 给出Region对应的策略表达式Map
     * 
     * @param regionName
     * @return
     */
    public static Map<String, KeyPatternItem> getKeyKeyPatternItems(String regionName) {
        if (StringUtils.isNotEmpty(regionName)) {
            RegionItem regionItem = CacheConfig.getInstance().getRegionItem(regionName);
            if (regionItem == null) {
                logger.error("don't find the " + regionName + " RegionItem in " + CacheConfig.CONFIG_FILE);
                return null;
            }
            return regionItem.getKeyPatternMap();
        } else {
            logger.error("region name must have a value");

        }
        return null;
    }
    /**
     * 给出Region对应的策略表达式Map
     * 
     * @param regionName
     * @return
     */
    public static Map<String, KeyPatternItem> getDefaultKeyKeyPatternItems() {
            RegionItem regionItem = CacheConfig.getInstance().getDefaultRegionItem();
            if (regionItem == null) {
                logger.error("cannot find the default RegionItem in " + CacheConfig.CONFIG_FILE);
                return null;
            }
            return regionItem.getKeyPatternMap();
    }  
    /**
     * 通过名字给出MemcachedSource
     * 
     * @param name
     * @return
     */
    public static CacheClient getCacheClient(String name) {
        return StringUtils.isNotEmpty(name) ? CacheConfig.getInstance().getCacheClient(name) : null;
    }

    /**
     * 
     */
    /**
     * 通过名字给出MemcachedSource
     * 
     * @param name
     * @return
     */
    public static CacheClient getDynamicCacheClient() {
        return CacheConfig.getInstance().getDynamicCacheClient();
    }

    public static String getStrategyClassName(String regionName) {
        if (StringUtils.isNotEmpty(regionName)) {
            RegionItem regionItem = CacheConfig.getInstance().getRegionItem(regionName);
            if (regionItem != null) {
                return regionItem.getStrategyClass();
            } else {
                logger.error("don't find regionName config: " + regionName);
                return null;
            }
        } else {
            logger.error("regionName is null or empty");
            return null;
        }
    }

    /**
     * 
     * @param regionName
     * @return
     */
    public static String getListenerClass(String regionName) {
        if (StringUtils.isNotEmpty(regionName)) {
            RegionItem regionItem = CacheConfig.getInstance().getRegionItem(regionName);
            if (regionItem != null) {
                return regionItem.getListenerClass();
            } else {
                logger.error("don't find regionName config: " + regionName);
                return null;
            }
        } else {
            logger.error("regionName is null or empty");
            return null;
        }
    }
    /**
     * 检查一个Region是否在配置文件中存在
     * @param regionName
     * @return
     */
    public static boolean isExistRegion(String regionName) {
        if (StringUtils.isNotEmpty(regionName)) {
            RegionItem regionItem = CacheConfig.getInstance().getRegionItem(regionName);
            return regionItem == null ? false : true;
        }
        return false;
    }
    
    /**
     * 检查一个Region是否支持本地缓存
     * @param regionName
     * @return
     */
    public static boolean isLocalCache(String regionName) {
        if (StringUtils.isNotEmpty(regionName)) {
            RegionItem regionItem = CacheConfig.getInstance().getRegionItem(regionName);
            return regionItem == null ? false : regionItem.isLocalCache();
        }
        return false;
    }
}
