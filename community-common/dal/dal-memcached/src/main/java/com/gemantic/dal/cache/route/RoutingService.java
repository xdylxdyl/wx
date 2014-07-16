package com.gemantic.dal.cache.route;

import com.gemantic.dal.cache.exception.StrategyException;

public interface RoutingService {
    public abstract boolean setRoutingStrategy(String regionName, Object key) throws StrategyException;
}