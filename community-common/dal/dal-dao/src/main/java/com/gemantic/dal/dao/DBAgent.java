package com.gemantic.dal.dao;

import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.model.SqlInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 和数据库进行操作的接口
 *
 * @author arthurkang
 */

public interface DBAgent {

    public Serializable save(Object account_id, Object object) throws DaoException;

    public Map save(Object account_id, final List obs) throws DaoException;

    public boolean delete(Object account_id, Object obj) throws DaoException;

    public boolean fakeDelete(Object account_id, Object obj) throws DaoException;

    public boolean update(Object account_id, Object object) throws DaoException;

    public Object get(Object account_id, Class clazz, Serializable id) throws DaoException;

    public List getObjectList(Object account_id, String listName, final SqlInfo sqlInfo, final Long start, final Long count, int strategy, boolean setDS, final boolean getAll) throws DaoException;

    public List getEntityList(Object account_id, final Class cls, final SqlInfo sqlInfo, int strategy) throws DaoException;

    public List<List> crossDBList(Object account_id, String listName, final SqlInfo sqlInfo, final Integer start, final Integer count, int strategy) throws DaoException;

    public List getOrderedCrossList(Object account_id, String listName, final SqlInfo sqlInfo, final Long start, final Long count, int strategy, boolean forward) throws DaoException;

    public List getMaps(Object accountId, String mapName, List<Object[]> paramsList) throws StrategyException, DaoException;

    public boolean updateObjs(Object account_id, final List obs) throws DaoException;
	
	  /**
     * 假设类仅有一个数据库的配置，根据对应的类获取类对应的数据库的信息,
     * 注意： 如果clazz为null，则会使用当前线程中的数据源，会有不确定的结果。
     * 可以使clazz为null,而在当前线程前设定当前线程的数据源。
     * @param sql
     * @return
     */
	public Object excuteSimpleSql(String sql,Class clazz) throws DaoException;
}


