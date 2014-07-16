/**
 * 
 */
package com.qding.sca.common.pay.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.pay.service.PayOrderService;

public class PayOrderSCAClient implements PayOrderService {

	private PayOrderService payOrderService;

	public PayOrderService getPayOrderService() {
		return payOrderService;
	}

	public void setPayOrderService(PayOrderService payOrderService) {
		this.payOrderService = payOrderService;
	}

	@Override
	public String pay(String userid,String merchantOrderId, String merchantOrderTime,String merchantOrderName,
			String merchantOrderAmt, String merchantOrderDesc,String frontUrl,String backUrl,String type)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return payOrderService.pay(userid,merchantOrderId,merchantOrderTime,merchantOrderName,merchantOrderAmt,merchantOrderDesc,frontUrl,backUrl,type);
	}

	@Override
	public String notice(String xmlString,String type) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub
		return payOrderService.notice(xmlString,type);
	}

	@Override
	public String check(String merchantOrderId, String merchantOrderTime,String type)
			throws ServiceException, ServiceDaoException {
		return payOrderService.check(merchantOrderId, merchantOrderTime,type);
	}

	@Override
	public String getParam(String key,String type) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub
		return payOrderService.getParam(key,type);
	}

}
