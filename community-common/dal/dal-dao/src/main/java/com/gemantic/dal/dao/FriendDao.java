package com.gemantic.dal.dao;

import java.util.List;

import com.gemantic.dal.dao.exception.DaoException;

public interface FriendDao {

	public List getMappings(List accountIdList,String mapname,List<Object[]> paramsList) throws DaoException;

}
