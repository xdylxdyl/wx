package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.Publics;
import com.qding.framework.publics.service.PublicsService;

public class PublicsServiceImpl extends BaseDaoServiceImpl implements PublicsService {

	

	private static final Log log = LogFactory.getLog(PublicsServiceImpl.class);



	@Override
	public Long insert(Publics publics) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + publics);
		}
		if (publics == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		publics.setCreateAt(currentTimeMillis);
		publics.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(publics);
		} catch (DaoException e) {
			log.error(" insert wrong : " + publics);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert data success : " + result);
		}
		return result;
	}

	@Override
	public List<Publics> insertList(List<Publics> publicsList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (publicsList == null ? "null" : publicsList.size()));
		}
		List<Publics> resultList = null;

		if (CollectionUtils.isEmpty(publicsList)) {
			return new ArrayList<Publics>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Publics publics : publicsList) {
			publics.setCreateAt(currentTimeMillis);
			publics.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Publics>) dao.batchSave(publicsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + publicsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : "
					+ (resultList == null ? "null" : resultList.size()));
		}
		return resultList;

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" delete data : " + id);
		}
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Publics.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" delete data success : " + id);
		}
		return result;

	}

	@Override
	public boolean update(Publics publics) throws ServiceException,
			ServiceDaoException {

		log.info(" update data : "
				+ (publics == null ? "null" : publics.getId()));

		boolean result = false;

		if (publics == null) {
			return true;
		}

		publics.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(publics);
		} catch (DaoException e) {
			log.error(" update wrong : " + publics);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + publics);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Publics> publicsList)
			throws ServiceException, ServiceDaoException {

		log.info(" update lists : "
				+ (publicsList == null ? "null" : publicsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(publicsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Publics publics : publicsList) {
			publics.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(publicsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + publicsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + publicsList.size());
		}
		return result;
	}

	@Override
	public Publics getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Publics publics = null;

		if (id == null) {
			return publics;
		}

		try {
			publics = (Publics) dao.get(Publics.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return publics;
	}

	@Override
	public List<Publics> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Publics> publics = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Publics>();
		}

		try {
			publics = (List<Publics>) dao.getList(Publics.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (publics == null ? "null" : publics.size()));
		}
		return publics;
	}

	
	@Override
	public List<Long> getList(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get all ids ,start,limit  :  " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			// idList = (List<Long>)
			// dao.excuteSimpleSql("select id from records where version = "+version,
			// Records.class);
			idList = dao.getIdList("getPublicsAll", new Object[] {}, start,
					limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by version,start,limit)  , " + start
					+ " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	
	@Override
	public List<Long> getPublicsIdsByAppId(String appId, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by appid,start,limit  ================== " + appId+" , " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getPublicsIdsByAppId",new Object[] {appId},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by appId,start,limit)  : " + appId + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
}
