package com.qding.framework.user.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.user.model.UserOpenRelation;
import com.qding.framework.user.service.UserOpenRelationService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;

public class UserOpenRelationServiceImpl extends BaseDaoServiceImpl implements UserOpenRelationService {

	private static final Log log = LogFactory.getLog(UserOpenRelationServiceImpl.class);

	@Override
	public Long insert(UserOpenRelation userOpenRelation) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + userOpenRelation);
		}
		if (userOpenRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		userOpenRelation.setCreateAt(currentTimeMillis);
		userOpenRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(userOpenRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userOpenRelation);
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
	public List<UserOpenRelation> insertList(List<UserOpenRelation> userOpenRelationList) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (userOpenRelationList == null ? "null" : userOpenRelationList.size()));
		}
		List<UserOpenRelation> resultList = null;

		if (CollectionUtils.isEmpty(userOpenRelationList)) {
			return new ArrayList<UserOpenRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserOpenRelation userOpenRelation : userOpenRelationList) {
			userOpenRelation.setCreateAt(currentTimeMillis);
			userOpenRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UserOpenRelation>) dao.batchSave(userOpenRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userOpenRelationList);
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
			result = dao.delete(UserOpenRelation.class, id);
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
	public boolean update(UserOpenRelation userOpenRelation) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (userOpenRelation == null ? "null" : userOpenRelation.getId()));

		boolean result = false;

		if (userOpenRelation == null) {
			return true;
		}

		userOpenRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(userOpenRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + userOpenRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + userOpenRelation);
		}
		return result;
	}

	@Override
	public boolean updateList(List<UserOpenRelation> userOpenRelationList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (userOpenRelationList == null ? "null" : userOpenRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userOpenRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserOpenRelation userOpenRelation : userOpenRelationList) {
			userOpenRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userOpenRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userOpenRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + userOpenRelationList.size());
		}
		return result;
	}

	@Override
	public UserOpenRelation getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		UserOpenRelation userOpenRelation = null;

		if (id == null) {
			return userOpenRelation;
		}

		try {
			userOpenRelation = (UserOpenRelation) dao.get(UserOpenRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return userOpenRelation;
	}

	@Override
	public List<UserOpenRelation> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<UserOpenRelation> userOpenRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserOpenRelation>();
		}

		try {
			userOpenRelation = (List<UserOpenRelation>) dao.getList(UserOpenRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (userOpenRelation == null ? "null" : userOpenRelation.size()));
		}
		return userOpenRelation;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public String getUserOpenRelationOpenIDByUidAndPublicsID(Long uid, Long publicsID) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get openID by uid,publicsID  : " + uid + " , " + publicsID);
		}
		String openID = null;

		// TODO 参数检查!

		try {

			openID = (String) dao.getMapping("getUserOpenRelationOpenIDByUidAndPublicsID", new Object[] { uid,
					publicsID });
		} catch (DaoException e) {
			log.error(" get openID wrong by uid,publicsID  : " + uid + " , " + publicsID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get openID success : " + openID);
		}
		return openID;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getUserOpenRelationUidByOpenIDAndType(String openID, String type) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get uid by openID,type  : " + openID + " , " + type);
		}
		Long uid = null;

		// TODO 参数检查!

		try {

			uid = (Long) dao.getMapping("getUserOpenRelationUidByOpenIDAndType", new Object[] { openID, type });
		} catch (DaoException e) {
			log.error(" get uid wrong by openID,type  : " + openID + " , " + type);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get uid success : " + uid);
		}
		return uid;

	}

	@Override
	public List<Long> getUserOpenRelationIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getUserOpenRelationIdsAll", new Object[] {}, start, limit, false);
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
	public Integer countUserOpenRelationIds() throws ServiceException, ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getUserOpenRelationIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserOpenRelationIds ");
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
