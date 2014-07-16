package com.gemantic.dmemcached.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.gemantic.dal.cache.client.CacheClient;
import com.gemantic.dal.cache.config.model.DatasourceItem;
import com.gemantic.dal.cache.config.model.KeyPatternItem;
import com.gemantic.dal.cache.config.model.RegionItem;
import com.gemantic.dmemcached.client.DMemcachedClientWrapper;
import com.gemantic.dmemcached.client.MemcachedClientWrapper;

/**
 * 
 * 
 * 
 * @author allenshen date: Dec 2, 2008 2:10:51 PM Copyright 2008 Sohu.com Inc.
 *         All Rights Reserved.
 */
public final class CacheConfig {
    private static Logger logger = Logger.getLogger(CacheConfig.class);
    public static String CONFIG_FILE = "/memcached_client.xml";
    private static CacheConfig config;

    private Map<String, DatasourceItem> memcachedItemMap = new HashMap<String, DatasourceItem>();
    private Map<String, RegionItem> regionItemMap = new HashMap<String, RegionItem>();
    private Map<String, CacheClient> cacheClientMap = new HashMap<String, CacheClient>();
    private DMemcachedClientWrapper dynamicCachedClient = new DMemcachedClientWrapper();
    private RegionItem defaultRegionItem = null;
    public RegionItem getDefaultRegionItem() {
        return defaultRegionItem;
    }

    private CacheConfig() {
        try {
            this.init(getClass().getResourceAsStream(CONFIG_FILE));
            this.initDefaultRegion(getClass().getResourceAsStream(CONFIG_FILE));
            this.initDynamicMemcachedSource();
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace(System.out);
            } else {
                logger.error("init config file " + CONFIG_FILE + " error: " + e.getMessage());
            }
        }
    }

    private void initDynamicMemcachedSource() {
        //RoutingMemcachedSource memcachedSource = (RoutingMemcachedSource) dynamicMemcachedSource;
        //memcachedSource.setResolvedMemcachedSources(memcachedSourceMap);
        dynamicCachedClient.setClients(cacheClientMap);
    }

    public static CacheConfig getInstance() {
        if (config == null) {
            synchronized (CacheConfig.class) {
                if (config == null) {
                    config = new CacheConfig();
                }
            }
        }
        return config;
    }

    private void init(InputStream groupConfigFile) {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("root", ArrayList.class);

        // 初始化MemcachedItem配置
        digester.addObjectCreate("root/cache/", ArrayList.class.getName());
        digester.addObjectCreate("root/cache/datasource", DatasourceItem.class);
        digester.addSetProperties("root/cache/datasource");
        digester.addSetNext("root/cache/datasource", "add");

        digester.addSetNext("root/cache/", "add");

        //
        digester.addObjectCreate("root/regions/", ArrayList.class.getName());
        digester.addObjectCreate("root/regions/region", RegionItem.class);
        digester.addSetProperties("root/regions/region");
        digester.addSetNext("root/regions/region", "add");

        digester.addObjectCreate("root/regions/region/keyPattern", KeyPatternItem.class);
        digester.addSetProperties("root/regions/region/keyPattern");
        digester.addSetNext("root/regions/region/keyPattern", "addKeyPatternItem");

        digester.addSetNext("root/regions/", "add");

        try {
            Object root = digester.parse(groupConfigFile);
            if (root != null && root instanceof ArrayList) {
                List<List> list = (List) root;
                if (CollectionUtils.isEmpty(list)) {
                    return;
                }
                for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                    List arrayList = (List) iterator.next();
                    if (CollectionUtils.isNotEmpty(arrayList)) {
                        for (Iterator itemIterator = arrayList.iterator(); itemIterator.hasNext();) {
                            Object item = itemIterator.next();
                            if (item != null) {
                                if (item instanceof DatasourceItem) {
                                    addDatasourceItem((DatasourceItem) item);
                                    continue;
                                }
                                if (item instanceof RegionItem) {
                                    addRegionItem((RegionItem) item);
                                }
                            }

                        }
                    }

                }

            }
        } catch (IOException e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace(System.err);
            } else {
                logger.error("init error: " + e.getMessage());
            }
        } catch (SAXException e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace(System.err);
            } else {
                logger.error("init parse fail : " + e.getMessage());
            }
        }
    }
    private void initDefaultRegion(InputStream groupConfigFile) {
        Digester digester = new Digester();
        digester.setValidating(false);
        // digester.addObjectCreate("root", ArrayList.class);
        //
        // // 初始化MemcachedItem配置
        // digester.addObjectCreate("root/cache/", ArrayList.class.getName());
        // digester.addObjectCreate("root/cache/datasource",
        // DatasourceItem.class);
        // digester.addSetProperties("root/cache/datasource");
        // digester.addSetNext("root/cache/datasource", "add");
        //
        // digester.addSetNext("root/cache/", "add");
        //
        // //
        // digester.addObjectCreate("root/regions/", ArrayList.class.getName());
        digester.addObjectCreate("root/default/region", RegionItem.class);
        digester.addSetProperties("root/default/region");

        digester.addObjectCreate("root/default/region/keyPattern", KeyPatternItem.class);
        digester.addSetProperties("root/default/region/keyPattern");
        digester.addSetNext("root/default/region/keyPattern", "addKeyPatternItem");

        // digester.addSetNext("root/regions/", "add");

        try {
            Object root = digester.parse(groupConfigFile);
                if (root instanceof RegionItem) {
                    this.defaultRegionItem = (RegionItem) root;
                }

        } catch (IOException e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace(System.err);
            } else {
                logger.error("initDefaultRegion error: " + e.getMessage());
            }
        } catch (SAXException e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace(System.err);
            } else {
                logger.error("initDefaultRegion parse fail : " + e.getMessage());
            }
        }
    }
    /**
     * 简单测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(CacheConfig.getInstance().getMemcachedItem("mem1"));
        System.out.println(CacheConfig.getInstance().getRegionItem("com.gemantic.analyse.dal.demo.model.Xueying"));
    }

    /**
     * 
     * @param achememcachedItemdItem
     */
    private void addDatasourceItem(DatasourceItem datasourceItem) {
        if (datasourceItem != null && StringUtils.isNotBlank(datasourceItem.getName())) {
            if (!memcachedItemMap.containsKey(datasourceItem.getName())) {
                memcachedItemMap.put(datasourceItem.getName(), datasourceItem);
                // init memcachedSource

                // initial pool
                SockIOPool pool = SockIOPool.getInstance(datasourceItem.getName());
                // pool.setAliveCheck(element.isAliveCheck());
                // pool.setFailover(element.isFailover());
                pool.setServers(new String[] { datasourceItem.getServer() + ":" + datasourceItem.getPort() });
                // String[] weights = StringUtils.split(element.getWeights(),
                // ",");
                // pool.setWeights((Integer[]) ConvertUtils.convert(weights,
                // Integer.class));

                pool.setInitConn(5);
                pool.setMinConn(5);
                pool.setMaxConn(datasourceItem.getMaxActive());
                
                // pool.setMaintSleep(element.getMaintSleep());
                // pool.setSocketTO(element.getSocketTO());
                // pool.setNagle(element.isNagle());
                pool.setSocketConnectTO(6*5000);
                pool.initialize();

                MemCachedClient client = new MemCachedClient(datasourceItem.getName());
                // client.setCompressEnable(element.isCompressEnable());
                // client.setCompressThreshold(element.getCompressThreshold());
                // client.setDefaultEncoding(element.getDefaultEncoding());
                // client.setPrimitiveAsString(element.isPrimitiveAsString());

                cacheClientMap.put(datasourceItem.getName(), new MemcachedClientWrapper(client));
            } else {
                logger.error("same name <" + datasourceItem.getName() + "> memcacheditem have exist!");
            }

        }
    }

    /**
     * 
     * @param achememcachedItemdItem
     */
    private void addRegionItem(RegionItem regionItem) {
        if (regionItem != null && StringUtils.isNotBlank(regionItem.getName())) {
            if (!regionItemMap.containsKey(regionItem.getName())) {
                regionItemMap.put(regionItem.getName(), regionItem);
            } else {
                logger.error("same name <" + regionItem.getName() + "> RegionItem have exist!");
            }

        }
    }

    /**
     * 
     * @param groupName
     * @return
     */
    public RegionItem getRegionItem(String regionName) {
        return this.regionItemMap.get(regionName);
    }

    /**
     * 
     * @param memcachedItemName
     * @return
     */
    public DatasourceItem getMemcachedItem(String memcachedItemName) {
        return this.memcachedItemMap.get(memcachedItemName);
    }

    public CacheClient getCacheClient(String name) {
        return cacheClientMap.get(name);
    }

    public Map<String, CacheClient> getCacheClientMap() {
        return cacheClientMap;
    }

    public CacheClient getDynamicCacheClient() {
        return dynamicCachedClient;
    }

}
