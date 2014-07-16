package com.qding.common.pay.service;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

/**支付订单接口
 * @author 
 *
 */
@Remotable
public interface PayOrderService {

	/**
	 * 支付
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public String pay(String userid,String merchantOrderId, String merchantOrderTime,String merchantOrderName,
			String merchantOrderAmt, String merchantOrderDesc,String frontUrl,String backUrl,String type)
			throws ServiceException, ServiceDaoException;
	/**
	 *  解析通知报文
	 * @param xmlString
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public String notice(String xmlString,String type) throws ServiceException,
	ServiceDaoException;
	
	/**支付状态查询
	 * @param merchantOrderId
	 * @param merchantOrderTime
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	String check(String merchantOrderId, String merchantOrderTime,String type)
			throws ServiceException, ServiceDaoException;

	/**
	 *  获取参数
	 * @param xmlString
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public String getParam(String key,String type) throws ServiceException,
	ServiceDaoException;
}
