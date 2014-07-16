package com.gemantic.analyse.dal.demo.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.gemantic.analyse.dal.demo.model.XueYing;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;

public class DaoAppService {

	private Dao dao;
	
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Long insert(XueYing xueying) throws Exception {
		try {
			return (Long) dao.save(xueying);
		} catch (DaoException e) {
			throw new Exception("insert error.", e);
		}
	}

	public List<XueYing> insertList(List<XueYing> list) throws Exception {
		try {
			return dao.save(list);
		} catch (DaoException e) {
			throw new Exception("insert error.", e);
		}
	}
    


	public List<XueYing> batchSave(List<XueYing> list) throws Exception {
		try {
			return (List<XueYing>) dao.batchSave(list);
		} catch (DaoException e) {
			throw new Exception("batch save error.", e);
		}
	}

	public boolean update(XueYing xueying) throws Exception {
		try {
			return dao.update(xueying);
		} catch (DaoException e) {
			throw new Exception("update error. key is " + xueying.getUserId(), e);
		}
	}


	public boolean update(Long userId, XueYing xueying) throws Exception {
		try {
			return dao.update(userId, xueying);
		} catch (DaoException e) {
			throw new Exception("update error. key is " + xueying.getUserId(), e);
		}
	}
	
	public boolean delete(Long userId) throws Exception {
		try {
			return dao.delete(XueYing.class, userId);
		} catch (DaoException e) {
			throw new Exception("delete error. key is " + userId, e);
		}
	}


	public XueYing getObjectById(Long userId) throws Exception {
		try {
			return (XueYing) dao.get(XueYing.class, userId);
		} catch (DaoException e) {
			throw new Exception("get error.", e);
		}
		
	}
	
	public String getMapingByObjectArray(Object[] params) throws Exception {
		try {
			return (String) dao.getMapping("getGuidByNameAndUserId", params);
		} catch (DaoException e) {
			throw new Exception("get error.", e);
		}
		
	}
	
	public String getMapingByUserId(long userId) throws Exception {
		try {
			return (String) dao.getMapping("getNameByUserId", userId);
		} catch (DaoException e) {
			throw new Exception("get error.", e);
		}
		
	}
	
	public String getMapingAddressByUserId(long userId) throws Exception {
		try {
			return (String) dao.getMapping("getAddressByUserId", userId);
		} catch (DaoException e) {
			throw new Exception("get error.", e);
		}
		
	}
	
	public List<Long> getObjectListByUserId(long userId) throws Exception {
		try {
			return (List<Long>) dao.getIdList("getIdByUserId", new Object[]{userId}, false);
		} catch (DaoException e) {
			throw new Exception("get error.", e);
		}
		
	}
	

	public boolean delete(XueYing xueying) throws Exception {
		try {
			return dao.delete(xueying.getClass(), xueying.getUserId());
//			return dao.realDelete(xueying);
		} catch (DaoException e) {
			throw new Exception("delet error. key is " + xueying.getUserId(), e);
		}
	}


	public boolean fakeDelete(XueYing xueying) throws Exception {
		try {
			return dao.fakeDelete(xueying.getClass(), xueying.getUserId());
		} catch (DaoException e) {
			throw new Exception("delet error. key is " + xueying.getUserId(), e);
		}
	}
	
}
