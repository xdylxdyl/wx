/**
 * 
 */
package com.qding.sca.common.sms.client;

import java.util.List;

import com.qding.common.sms.model.Sms;
import com.qding.common.sms.service.SendSmsService;
import com.qding.common.sms.service.SmsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class SendSmsSCAClient implements SendSmsService {

	private SendSmsService sendSmsService;

	public SendSmsService getSendSmsService() {
		return sendSmsService;
	}

	public void setSendSmsService(SendSmsService sendSmsService) {
		this.sendSmsService = sendSmsService;
	}

	@Override
	public boolean sendMsg(String mobile, String text) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub
		return sendSmsService.sendMsg(mobile, text);
	}

}
