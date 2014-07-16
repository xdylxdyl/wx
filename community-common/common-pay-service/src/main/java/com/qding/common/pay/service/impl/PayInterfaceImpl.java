package com.qding.common.pay.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.pay.service.PayOrderService;

public class PayInterfaceImpl  implements PayOrderService{
	private static final Log log = LogFactory.getLog(PayInterfaceImpl.class);
	
	@Resource(name = "processServiceConfig")
	private Map<String, PayOrderService> processServiceConfig;

	@Override
	public String pay(String userid, String merchantOrderId,
			String merchantOrderTime, String merchantOrderName,
			String merchantOrderAmt, String merchantOrderDesc, String frontUrl,
			String backUrl,String type) throws ServiceException, ServiceDaoException {
		
		try {
			PayOrderService  payOrderService = processServiceConfig.get(type);
			return payOrderService.pay(userid, merchantOrderId, merchantOrderTime, merchantOrderName, merchantOrderAmt, merchantOrderDesc, frontUrl, backUrl, type);
		} catch (Exception e) {
			log.error("param 'type' error :" +e.getMessage());
			return null;
		}
	}

	@Override
	public String notice(String xmlString,String type) throws ServiceException,
			ServiceDaoException {

		try {
			PayOrderService  payOrderService = processServiceConfig.get(type);
			return payOrderService.notice(xmlString, type);
		} catch (Exception e) {
			log.error("param 'type' error :" +e.getMessage());
			return null;
		}
	}

	@Override
	public String check(String merchantOrderId, String merchantOrderTime,String type)
			throws ServiceException, ServiceDaoException {

		try {
			PayOrderService  payOrderService = processServiceConfig.get(type);
			return payOrderService.check(merchantOrderId,merchantOrderTime, type);
		} catch (Exception e) {
			log.error("param 'type' error :" +e.getMessage());
			return null;
		}
		
	}

	@Override
	public String getParam(String key,String type) throws ServiceException,
			ServiceDaoException {

		try {
			PayOrderService  payOrderService = processServiceConfig.get(type);
			return payOrderService.getParam(key, type);
		} catch (Exception e) {
			log.error("param 'type' error :" +e.getMessage());
			return null;
		}
	}
	
	

}
