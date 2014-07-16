package com.gemantic.dal.route.strategy;

import java.util.List;

import com.gemantic.dal.dao.exception.StrategyException;
/**
 * 
 * 
 * @author allenshen date: Nov 28, 2008 4:21:24 PM Copyright 2008 Sohu.com Inc.
 *         All Rights Reserved.
 */
public interface IStrategy {
   public static int STRATEGY_R = 1;
    public static int STRATEGY_W = 2;
  
    public Object ObjectShardingStrategy(Class clazz, Object account, int rw) throws StrategyException;

    public Object ListShardingStrategy(String listName, Object account, int rw) throws StrategyException;

    public Object MapShardingStrategy(String listName, Object account, int rw) throws StrategyException;

    public boolean isReadWrite(Class clazz, Object account) throws StrategyException;
        
    public Object NextListShardingStrategy(String listName,int rw) throws StrategyException;
    /**
     * 按照对象的策略里面的配置的数据库集群：
     * 根据读写策略来获取没给集群里面的一个数据库
     * @return   挑选出来的数据库名称的集合
     * @param clazz 对象的类名称
     * @param rw 读库还是写库
     */
	public List<String> getOneDSFromEachGroupOfObject(Class clazz, int rw) throws StrategyException;
}
