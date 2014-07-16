/**
 * 
 */
package com.qding.sca.common.sms.client;

import java.util.List;

import com.qding.common.sms.model.Sms;
import com.qding.common.sms.service.SmsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class SmsSCAClient implements SmsService {

	private SmsService smsService;

	public SmsService getSmsService() {
		return smsService;
	}

	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}

	@Override
	public Long insert(Sms sms) throws ServiceException, ServiceDaoException {

		return smsService.insert(sms);

	}

	@Override
	public List<Sms> insertList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException {

		return smsService.insertList(smsList);

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		return smsService.delete(id);

	}

	@Override
	public boolean update(Sms sms) throws ServiceException, ServiceDaoException {

		return smsService.update(sms);

	}

	@Override
	public boolean updateList(List<Sms> smsList) throws ServiceException,
			ServiceDaoException {

		return smsService.updateList(smsList);

	}

	@Override
	public Sms getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		return smsService.getObjectById(id);

	}

	@Override
	public List<Sms> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		return smsService.getObjectsByIds(ids);

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

		return smsService.getSmsIdByMobileAndType(mobile, type);

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getSmsIdByMobileAndTypeAndVerifyCode(String mobile, String type ,String verifyCode)
			throws ServiceException, ServiceDaoException {

		return smsService.getSmsIdByMobileAndTypeAndVerifyCode(mobile, type,verifyCode);

	}
	

}
