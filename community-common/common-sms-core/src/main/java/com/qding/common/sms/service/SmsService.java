package com.qding.common.sms.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.sms.model.Sms;

@Remotable
public interface SmsService {

	public Long insert(Sms sms) throws ServiceException, ServiceDaoException;

	public List<Sms> insertList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Sms sms) throws ServiceException, ServiceDaoException;

	public boolean updateList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException;

	public Sms getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<Sms> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long getSmsIdByMobileAndType(String mobile, String type)
			throws ServiceException, ServiceDaoException;
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long getSmsIdByMobileAndTypeAndVerifyCode(String mobile, String type,String verifyCode)
			throws ServiceException, ServiceDaoException;



}
