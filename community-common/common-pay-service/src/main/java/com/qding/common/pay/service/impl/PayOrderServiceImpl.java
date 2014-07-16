package com.qding.common.pay.service.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.pay.bean.yl.QueryBean;
import com.qding.common.pay.bean.yl.RequestBean;
import com.qding.common.pay.service.PayOrderService;
import com.qding.common.pay.uitl.yl.PayUtil;
import com.qding.common.pay.uitl.yl.RemoteAccessor;

/**
 * 支付
 * 
 * @author magenm
 * 
 */

public class PayOrderServiceImpl implements PayOrderService {

	private static final Log log = LogFactory.getLog(PayOrderServiceImpl.class);

	private Map<String, String> payConfig;

	public Map<String, String> getPayConfig() {
		return payConfig;
	}

	public void setPayConfig(Map<String, String> payConfig) {
		this.payConfig = payConfig;
	}
	
	public static void main(String[] args) {
		String xmlString = "";
	}
	
	/**
	 * 支付状态监测
	 */
	@Override
	public String check(String merchantOrderId, String merchantOrderTime ,String type)
					throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		
		log.info("merchantOrderId=" + merchantOrderId + ",merchantOrderTime="
				+ merchantOrderTime);
		
		QueryBean que = new QueryBean();
		que.setTransType("01");
		que.setMerchantOrderId(merchantOrderId);
		que.setMerchantId(payConfig.get("merchantId"));
//		req.setMerchantName(payConfig.get("merchantName"));
//		que.setFrontUrl(payConfig.get("frontUrl")+"/"+merchantOrderId);
		que.setMerchantOrderTime(merchantOrderTime);
		
//		que.setMerchantOrderId(merchantOrderId);
		
		
//		req.setMerchantOrderCurrency(payConfig.get("merchantOrderCurrency"));
//		req.setGwType(payConfig.get("gwType"));
//		req.setBackUrl(payConfig.get("backUrl")+"/"+merchantOrderId);
//		
//		req.setMerchantOrderId(merchantOrderId);
//		req.setMerchantOrderAmt(merchantOrderAmt);
//		req.setMerchantOrderDesc(merchantOrderDesc);
//		
		String data = que.doc2String(que.toDocument());
		String xml = PayUtil.getData(data, que.getMerchantId(),
				payConfig.get("key"), payConfig.get("keyFile"));
		
		log.info("xml:" + xml);
		
		
		
		try {
			RemoteAccessor remoteAccessor = new RemoteAccessor();
			String re = remoteAccessor.getResponseByStream(
					payConfig.get("payUrl"), "utf-8", xml);
			log.info("query resault:"+re);
			return PayUtil.responseQueryCheck(re, payConfig.get("key"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("pay  error : " + e.getMessage());
			
			return null;
		}
	}
	/**
	 * 支付
	 */
	@Override
	public String pay(String userid,String merchantOrderId, String merchantOrderTime,String merchantOrderName,
			String merchantOrderAmt, String merchantOrderDesc,String frontUrl,String backUrl,String type)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub

		log.info("merchantOrderId=" + merchantOrderId + ",merchantOrderTime="
				+ merchantOrderTime + ",merchantOrderAmt=" + merchantOrderAmt
				+ ",merchantOrderDesc=" + merchantOrderDesc);

		RequestBean req = new RequestBean();
		req.setApplication("MGw.Req");
		req.setMerchantId(payConfig.get("merchantId"));
		req.setMerchantName(payConfig.get("merchantName"));
		req.setMerchantOrderCurrency(payConfig.get("merchantOrderCurrency"));
		req.setGwType(payConfig.get("gwType"));
		req.setTransTimeout(payConfig.get("transTimeout"));
		
		req.setFrontUrl(frontUrl+"/"+merchantOrderId);
		req.setBackUrl(backUrl+"/"+merchantOrderId);

		req.setMerchantOrderId(merchantOrderId);
		req.setMerchantOrderAmt(merchantOrderAmt);
		req.setMerchantOrderTime(merchantOrderTime);
		req.setMerchantOrderDesc(merchantOrderDesc);

		String data = req.doc2String(req.toDocument());
		String xml = PayUtil.getData(data, req.getMerchantId(),
				payConfig.get("key"), payConfig.get("keyFile"));

		log.info("xml:" + xml);
		try {
			RemoteAccessor remoteAccessor = new RemoteAccessor();
			String re = remoteAccessor.getResponseByStream(
					payConfig.get("payUrl"), "utf-8", xml);

			return PayUtil.getUrl(re, payConfig.get("key"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("pay  error : " + e.getMessage());

			return null;
		}
	}
	
	/**
	 * 解析通知报文
	 * 
	 * @param xmlString
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public String notice(String xmlString,String type) throws ServiceException,
			ServiceDaoException {
		
		return PayUtil.getNotice(xmlString, payConfig.get("publicKey"), payConfig.get("publicKeyFile"));
		
	}

	@Override
	public String getParam(String key,String type) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub
		return payConfig.get(key);
	}

}
