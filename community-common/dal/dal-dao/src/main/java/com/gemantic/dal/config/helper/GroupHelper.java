/**
 * 
 */
package com.gemantic.dal.config.helper;


import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.apache.log4j.Logger;

import com.gemantic.dal.config.GroupConfig;
import com.gemantic.dal.config.model.group.GroupItem;
 
/**
 * @author allenshen
 * 
 * date: Nov 14, 2008 1:19:23 PM
 */
public final class GroupHelper {

    /**
     * 通过一个Datasource的名字找到Datasource
     * 
     * @param name
     * @return
     */
    public static DataSource getDataSource(String name) {
        return GroupConfig.getInstance().getDataSource(name);
    }

    /**
     * 给出Master数据库名的Datasource
     * 
     * @param groupName
     * @return
     */
    public static DataSource getMasterDataSource(String groupName) {
        return GroupConfig.getInstance().getMasterDataSource(groupName);
    }

    /**
     * 给出给出Savle的Datasource列表
     * 
     * @param groupName
     * @return
     */
    public static List< DataSource > getSavleDataSources(String groupName) {
        return GroupConfig.getInstance().getSlaveDataSources(groupName);
    }

    /**
     * 给出系统中配置的Datasource
     * 
     * @return
     */
    public static Map getDataSourceMap() {
        return GroupConfig.getInstance().getDataSourceItemMap();
    }

    /**
     * 给出一个组的配置
     * 
     * @param groupName
     * @return
     */
    public static GroupItem getGroupItem(String groupName) {
        return GroupConfig.getInstance().getGroupItem(groupName);
    }
}
