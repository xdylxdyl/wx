package com.qding.common.sms.service;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface SendSmsService {

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param text
	 *            内容
	 * @return
	 */
	public boolean sendMsg(String mobile, String text) throws ServiceException,
			ServiceDaoException;

}
