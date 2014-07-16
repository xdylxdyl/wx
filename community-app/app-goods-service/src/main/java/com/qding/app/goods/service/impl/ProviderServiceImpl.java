package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Provider;
import com.qding.app.goods.service.ProviderService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;

public class ProviderServiceImpl extends BaseDaoServiceImpl implements ProviderService {

	private static final Log log = LogFactory.getLog(ProviderServiceImpl.class);

	@Override
	public Long insert(Provider provider) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + provider);
		}
		if (provider == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		provider.setCreateAt(currentTimeMillis);
		provider.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(provider);
		} catch (DaoException e) {
			log.error(" insert wrong : " + provider);
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
	public List<Provider> insertList(List<Provider> providerList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (providerList == null ? "null" : providerList.size()));
		}
		List<Provider> resultList = null;

		if (CollectionUtils.isEmpty(providerList)) {
			return new ArrayList<Provider>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Provider provider : providerList) {
			provider.setCreateAt(currentTimeMillis);
			provider.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Provider>) dao.batchSave(providerList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + providerList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
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
			result = dao.delete(Provider.class, id);
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
	public boolean update(Provider provider) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (provider == null ? "null" : provider.getId()));

		boolean result = false;

		if (provider == null) {
			return true;
		}

		provider.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(provider);
		} catch (DaoException e) {
			log.error(" update wrong : " + provider);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + provider);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Provider> providerList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (providerList == null ? "null" : providerList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(providerList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Provider provider : providerList) {
			provider.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(providerList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + providerList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + providerList.size());
		}
		return result;
	}

	@Override
	public Provider getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Provider provider = null;

		if (id == null) {
			return provider;
		}

		try {
			provider = (Provider) dao.get(Provider.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return provider;
	}

	@Override
	public List<Provider> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Provider> provider = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Provider>();
		}

		try {
			provider = (List<Provider>) dao.getList(Provider.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (provider == null ? "null" : provider.size()));
		}
		return provider;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getProviderIdByName(String name) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get id by name  : " + name);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getProviderIdByName", new Object[] { name });
		} catch (DaoException e) {
			log.error(" get id wrong by name  : " + name);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get id success : " + id);
		}
		return id;

	}

	@Override
	public List<Long> getProviderIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getProviderIdsAll", new Object[] {}, start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countProviderIds() throws ServiceException, ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getProviderIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getProviderIds ");
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
