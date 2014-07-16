package com.qding.common.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.sms.model.Sms;
import com.qding.common.sms.service.SmsService;

public class SmsServiceImpl implements SmsService {

	private Dao dao;

	private static final Log log = LogFactory.getLog(SmsServiceImpl.class);

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public Long insert(Sms sms) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + sms);
		}
		if (sms == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		sms.setCreateAt(currentTimeMillis);
		sms.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(sms);
		} catch (DaoException e) {
			log.error(" insert wrong : " + sms);
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
	public List<Sms> insertList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (smsList == null ? "null" : smsList.size()));
		}
		List<Sms> resultList = null;

		if (CollectionUtils.isEmpty(smsList)) {
			return new ArrayList<Sms>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Sms sms : smsList) {
			sms.setCreateAt(currentTimeMillis);
			sms.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Sms>) dao.batchSave(smsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + smsList);
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
			result = dao.delete(Sms.class, id);
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
	public boolean update(Sms sms) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (sms == null ? "null" : sms.getId()));

		boolean result = false;

		if (sms == null) {
			return true;
		}

		sms.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(sms);
		} catch (DaoException e) {
			log.error(" update wrong : " + sms);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + sms);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException {

		log.info(" update lists : "
				+ (smsList == null ? "null" : smsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(smsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Sms sms : smsList) {
			sms.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(smsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + smsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + smsList.size());
		}
		return result;
	}

	@Override
	public Sms getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Sms sms = null;

		if (id == null) {
			return sms;
		}

		try {
			sms = (Sms) dao.get(Sms.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return sms;
	}

	@Override
	public List<Sms> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Sms> sms = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Sms>();
		}

		try {
			sms = (List<Sms>) dao.getList(Sms.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (sms == null ? "null" : sms.size()));
		}
		return sms;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getSmsIdByMobileAndType(String mobile, String type)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get id by mobile,type  : " + mobile + " , " + type);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getSmsIdByMobileAndType", new Object[] {
					mobile, type });
		} catch (DaoException e) {
			log.error(" get id wrong by mobile,type  : " + mobile + " , "
					+ type);
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
	public Long getSmsIdByMobileAndTypeAndVerifyCode(String mobile, String type,String verifyCode)
			throws ServiceException, ServiceDaoException
			{


		if (log.isInfoEnabled()) {
			log.info(" get id by mobile,type,verifyCode  : " + mobile + " , " + type+","+verifyCode);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getSmsIdByMobileAndTypeAndVerifyCode", new Object[] {
					mobile, type ,verifyCode });
		} catch (DaoException e) {
			log.error(" get id wrong by mobile,type,verifyCode  : " + mobile + " , " + type+","+verifyCode);
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
