package com.qding.framework.user.service.impl;

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
import com.qding.framework.user.model.User;
import com.qding.framework.user.service.UserService;

public class UserServiceImpl extends BaseDaoServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Override
	public Long insert(User user) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + user);
		}
		if (user == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		user.setCreateAt(currentTimeMillis);
		user.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(user);
		} catch (DaoException e) {
			log.error(" insert wrong : " + user);
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
	public List<User> insertList(List<User> userList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (userList == null ? "null" : userList.size()));
		}
		List<User> resultList = null;

		if (CollectionUtils.isEmpty(userList)) {
			return new ArrayList<User>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (User user : userList) {
			user.setCreateAt(currentTimeMillis);
			user.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<User>) dao.batchSave(userList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userList);
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
			result = dao.delete(User.class, id);
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
	public boolean update(User user) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (user == null ? "null" : user.getId()));

		boolean result = false;

		if (user == null) {
			return true;
		}

		user.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(user);
		} catch (DaoException e) {
			log.error(" update wrong : " + user);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + user);
		}
		return result;
	}

	@Override
	public boolean updateList(List<User> userList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (userList == null ? "null" : userList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (User user : userList) {
			user.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + userList.size());
		}
		return result;
	}

	@Override
	public User getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		User user = null;

		if (id == null) {
			return user;
		}

		try {
			user = (User) dao.get(User.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return user;
	}

	@Override
	public List<User> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<User> user = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<User>();
		}

		try {
			user = (List<User>) dao.getList(User.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (user == null ? "null" : user.size()));
		}
		return user;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getUserIdByMobile(String mobile) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get id by mobile  : " + mobile);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getUserIdByMobile", new Object[] { mobile });
		} catch (DaoException e) {
			log.error(" get id wrong by mobile  : " + mobile);
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
