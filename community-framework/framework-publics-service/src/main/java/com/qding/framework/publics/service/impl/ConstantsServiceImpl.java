package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.Constants;
import com.qding.framework.publics.service.ConstantsService;

/**
 * 常量Service Impl
 * @author TaoMingkai
 * @version 1.0
 * @since 2014/6/5 14:31
 */
public class ConstantsServiceImpl extends BaseDaoServiceImpl implements ConstantsService {

	private static final Log logger = LogFactory.getLog(ConstantsServiceImpl.class);

	@Override
	public Long insert(Constants constants) throws ServiceException, ServiceDaoException {

		if (constants == null) {
			return null;
		}

		if (logger.isInfoEnabled()) {
			logger.info(" insert data : " + constants);
		}

		long currentTimeMillis = System.currentTimeMillis();
		constants.setCreateAt(currentTimeMillis);
		constants.setUpdateAt(currentTimeMillis);

		Long result;
		try {
			result = (Long) dao.save(constants);
		} catch (DaoException e) {
			logger.error(" insert wrong : " + constants);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" insert data success : " + result);
		}

		return result;
	}

	@Override
	public List<Constants> insertList(List<Constants> constantsList) throws ServiceException, ServiceDaoException {

		if (CollectionUtils.isEmpty(constantsList)) {
			return new ArrayList<>();
		}

		if (logger.isInfoEnabled()) {
			logger.info(" insert lists : " + (constantsList == null ? "null" : constantsList.size()));
		}

		List<Constants> resultList;
		try {
			resultList = (List<Constants>) dao.batchSave(constantsList);
		} catch (DaoException e) {
			logger.error(" insert list wrong : " + constantsList);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}


		if (logger.isInfoEnabled()) {
			logger.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
		}

		return resultList;
	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		if (id == null) {
			return true;
		}

		if (logger.isInfoEnabled()) {
			logger.info(" delete data : " + id);
		}

		boolean result;
		try {
			result = dao.delete(Constants.class, id);
		} catch (DaoException e) {
			logger.error(" delete wrong : " + id);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" delete data success : " + id);
		}

		return result;
	}

	@Override
	public boolean update(Constants constants) throws ServiceException, ServiceDaoException {

		if (constants == null) {
			return true;
		}

		logger.info(" update data : " + (constants == null ? "null" : constants.getId()));

		long currentTimeMillis = System.currentTimeMillis();
		constants.setUpdateAt(currentTimeMillis);

		boolean result;
		try {
			result = dao.update(constants);
		} catch (DaoException e) {
			logger.error(" update wrong : " + constants);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" update data success : " + constants);
		}

		return result;
	}

	@Override
	public boolean updateList(List<Constants> constantsList) throws ServiceException, ServiceDaoException {

		if (CollectionUtils.isEmpty(constantsList)) {
			return true;
		}

		logger.info(" update lists : " + (constantsList == null ? "null" : constantsList.size()));

		boolean result;
		try {
			result = dao.batchUpdate(constantsList);
		} catch (DaoException e) {
			logger.error(" update list wrong : " + constantsList);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" update lists success : " + constantsList.size());
		}

		return result;
	}

	@Override
	public Constants getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (id == null) {
			return null;
		}

		if (logger.isInfoEnabled()) {
			logger.info(" get data : " + id);
		}

		Constants constants;
		try {
			constants = (Constants) dao.get(Constants.class, id);
		} catch (DaoException e) {
			logger.error(" get wrong : " + id);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" get data success : " + id);
		}

		return constants;
	}

	@Override
	public List<Constants> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<>();
		}

		if (logger.isInfoEnabled()) {
			logger.info(" get lists : " + (ids == null ? "null" : ids));
		}

		List<Constants> constantsList;
		try {
			constantsList = (List<Constants>) dao.getList(Constants.class, ids);
		} catch (DaoException e) {
			logger.error(" get wrong : " + ids);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" get data success : " + (constantsList == null ? "null" : constantsList.size()));
		}

		return constantsList;
	}

	@Override
	public List<Long> getConstantsIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		logger.info(" get ids by start, limit  ================== " + start + ", " + limit);

		List<Long> idList;
		try {
			idList = dao.getIdList("getConstantsIdsAll", new Object[] {}, start, limit, false);
		} catch (DaoException e) {
			logger.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}

		return idList;
	}

	@Override
	public Integer countConstantsIds() throws ServiceException, ServiceDaoException {

		int count;
		try {
			count = dao.count("getConstantsIdsAll", new Object[] {});
		} catch (DaoException e) {
			logger.error(" count by getConstantsIds ");
			logger.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}

		if (logger.isInfoEnabled()) {
			logger.info(" count  : " + count);
		}

		return count;
	}
}
