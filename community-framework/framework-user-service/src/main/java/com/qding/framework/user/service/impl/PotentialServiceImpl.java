package com.qding.framework.user.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.user.model.Potential;
import com.qding.framework.user.service.PotentialService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;

public class PotentialServiceImpl extends BaseDaoServiceImpl implements PotentialService {

	private static final Log log = LogFactory.getLog(PotentialServiceImpl.class);

	@Override
	public Long insert(Potential potential) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + potential);
		}
		if (potential == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		potential.setCreateAt(currentTimeMillis);
		potential.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(potential);
		} catch (DaoException e) {
			log.error(" insert wrong : " + potential);
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
	public List<Potential> insertList(List<Potential> potentialList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (potentialList == null ? "null" : potentialList.size()));
		}
		List<Potential> resultList = null;

		if (CollectionUtils.isEmpty(potentialList)) {
			return new ArrayList<Potential>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Potential potential : potentialList) {
			potential.setCreateAt(currentTimeMillis);
			potential.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Potential>) dao.batchSave(potentialList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + potentialList);
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
			result = dao.delete(Potential.class, id);
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
	public boolean update(Potential potential) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (potential == null ? "null" : potential.getId()));

		boolean result = false;

		if (potential == null) {
			return true;
		}

		potential.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(potential);
		} catch (DaoException e) {
			log.error(" update wrong : " + potential);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + potential);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Potential> potentialList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (potentialList == null ? "null" : potentialList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(potentialList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Potential potential : potentialList) {
			potential.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(potentialList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + potentialList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + potentialList.size());
		}
		return result;
	}

	@Override
	public Potential getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Potential potential = null;

		if (id == null) {
			return potential;
		}

		try {
			potential = (Potential) dao.get(Potential.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return potential;
	}

	@Override
	public List<Potential> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Potential> potential = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Potential>();
		}

		try {
			potential = (List<Potential>) dao.getList(Potential.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (potential == null ? "null" : potential.size()));
		}
		return potential;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getPotentialIdsByFakeID(String fakeID, Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by fakeID,start,limit  : " + fakeID + " , " + start + " , " + limit);
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
			idList = dao.getIdList("getPotentialIdsByFakeID", new Object[] { fakeID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by fakeID,start,limit)  : " + fakeID + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getPotentialIdByOpenID(String openID) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get id by openID  : " + openID);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getPotentialIdByOpenID", new Object[] { openID });
		} catch (DaoException e) {
			log.error(" get id wrong by openID  : " + openID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get id success : " + id);
		}
		return id;

	}

}
