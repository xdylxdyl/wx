package com.gemantic.dal.cache.config.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/*
 * 
 */
public class RegionItem implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2427500931734139981L;
    private static Logger logger = Logger.getLogger(RegionItem.class);
    private String name;
    private String listenerClass;
    private String strategyClass;
    private boolean hasClassInfo = true;
    
    private Map<String, KeyPatternItem> keyPatternMap = new HashMap<String, KeyPatternItem>();
    private boolean localCache;

    public boolean isLocalCache() {
        return localCache;
    }

    public void setLocalCache(boolean localCache) {
        this.localCache = localCache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListenerClass() {
        return listenerClass;
    }

    public void setListenerClass(String listenerClass) {
        this.listenerClass = listenerClass;
    }

    public Map<String, KeyPatternItem> getKeyPatternMap() {
        return keyPatternMap;
    }

    public void addKeyPatternItem(KeyPatternItem item) {
        if (item != null && StringUtils.isNotEmpty(item.getValue())) {
            if (!keyPatternMap.containsKey(item.getValue())) {
                keyPatternMap.put(item.getValue(), item);
            } else {
                logger.error("region: " + StringUtils.defaultIfEmpty(name, "") + " same patternitem <"
                        + item.getValue() + "> exist!");
            }
        } else {
            logger.error("KeyPatternItem object is null or value is null, please set in memcached_client.xml.");
        }
    }

    public String getStrategyClass() {
        return strategyClass;
    }

    public void setStrategyClass(String strategyClass) {
        this.strategyClass = strategyClass;
    }

    /**
         * 
         * @return 
         * @author 
         */
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("RegionItem[");
            buffer.append("keyPatternMap = ").append(keyPatternMap);
            buffer.append(",\n listenerClass = ").append(listenerClass);
            buffer.append(",\n localCache = ").append(localCache);
            buffer.append(",\n name = ").append(name);
            buffer.append(",\n strategyClass = ").append(strategyClass);
            buffer.append("]");
            return buffer.toString();
        }

    public boolean isHasClassInfo() {
        return hasClassInfo;
    }

    public void setHasClassInfo(boolean hasClassInfo) {
        this.hasClassInfo = hasClassInfo;
    }

}
