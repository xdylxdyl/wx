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
import com.qding.framework.publics.model.Resources;
import com.qding.framework.publics.service.ResourcesService;

public class ResourcesServiceImpl extends BaseDaoServiceImpl implements
		ResourcesService {

	private static final Log log = LogFactory
			.getLog(ResourcesServiceImpl.class);

	@Override
	public Long insert(Resources resources) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + resources);
		}
		if (resources == null) {
			return null;
		}

		// long currentTimeMillis = System.currentTimeMillis();
		// resources.setCreateAt(currentTimeMillis);
		// resources.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(resources);
		} catch (DaoException e) {
			log.error(" insert wrong : " + resources);
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
	public List<Resources> insertList(List<Resources> resourcesList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (resourcesList == null ? "null" : resourcesList.size()));
		}
		List<Resources> resultList = null;

		if (CollectionUtils.isEmpty(resourcesList)) {
			return new ArrayList<Resources>();
		}

		try {
			resultList = (List<Resources>) dao.batchSave(resourcesList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + resourcesList);
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
			result = dao.delete(Resources.class, id);
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
	public boolean update(Resources resources) throws ServiceException,
			ServiceDaoException {
		log.info(" update data : "
				+ (resources == null ? "null" : resources.getId()));
		boolean result = false;
		if (resources == null) {
			return true;
		}
		try {
			result = dao.update(resources);
		} catch (DaoException e) {
			log.error(" update wrong : " + resources);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + resources);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Resources> resourcesList)
			throws ServiceException, ServiceDaoException {
		log.info(" update lists : "
				+ (resourcesList == null ? "null" : resourcesList.size()));
		boolean result = false;
		if (CollectionUtils.isEmpty(resourcesList)) {
			return true;
		}

		try {
			result = dao.batchUpdate(resourcesList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + resourcesList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + resourcesList.size());
		}
		return result;
	}

	@Override
	public Resources getObjectById(Long id) throws ServiceException,
			ServiceDaoException {
		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Resources resources = null;

		if (id == null) {
			return resources;
		}
		try {
			resources = (Resources) dao.get(Resources.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return resources;
	}

	@Override
	public List<Resources> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Resources> resourcesList = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Resources>();
		}

		try {
			resourcesList = (List<Resources>) dao.getList(Resources.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (resourcesList == null ? "null" : resourcesList.size()));
		}
		return resourcesList;
	}

	@Override
	public List<Long> getResourcesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		log.info(" get ids   by start,limit  ================== " + start
				+ " , " + limit);
		List<Long> idList = null;

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getResourcesIdsAll", new Object[] {},
					start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , "
					+ limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countResourcesIds() throws ServiceException,
			ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getResourcesIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getModuleIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}
