package com.qding.common.pay.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.pay.bean.ll.PayResultEnum;
import com.qding.common.pay.bean.ll.PaymentInfo;
import com.qding.common.pay.bean.ll.SignTypeEnum;
import com.qding.common.pay.service.PayOrderService;
import com.qding.common.pay.uitl.ll.Md5Algorithm;
import com.qding.common.pay.uitl.ll.TraderRSAUtil;
import com.qding.common.pay.uitl.ll.YinTongUtil;

public class YintongPayServiceImpl implements PayOrderService {

	private static final Log log = LogFactory
			.getLog(YintongPayServiceImpl.class);

	private Map<String, String> llPayConfig;

	public Map<String, String> getLlPayConfig() {
		return llPayConfig;
	}

	public void setLlPayConfig(Map<String, String> llPayConfig) {
		this.llPayConfig = llPayConfig;
	}

	public YintongPayServiceImpl() {
		super();
	}

	@Override
	public String pay(String userid,String merchantOrderId, String merchantOrderTime,
			String merchantOrderName, String merchantOrderAmt,
			String merchantOrderDesc, String frontUrl, String backUrl,String type)
			throws ServiceException, ServiceDaoException {

		log.info("merchantOrderId=" + merchantOrderId + ",merchantOrderTime="
				+ merchantOrderTime + ",merchantOrderAmt=" + merchantOrderAmt
				+ ",merchantOrderDesc=" + merchantOrderDesc);

		// 构造支付请求对象
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setVersion(llPayConfig.get("VERSION"));
		paymentInfo.setOid_partner(llPayConfig.get("OID_PARTNER"));
		paymentInfo.setSign_type(llPayConfig.get("SIGN_TYPE"));
		paymentInfo.setUser_id(userid);// 商户用户系统中的唯一标示
		paymentInfo.setBusi_partner(llPayConfig.get("TRAN_TYPE"));// 虚拟商品销售
		paymentInfo.setNo_order(merchantOrderId);
		paymentInfo.setDt_order(merchantOrderTime);
		paymentInfo.setName_goods(merchantOrderName);
		paymentInfo.setInfo_order(merchantOrderDesc);
		paymentInfo.setMoney_order(merchantOrderAmt);
		paymentInfo.setNotify_url(backUrl);
		paymentInfo.setUrl_return(frontUrl);
		paymentInfo.setApp_request(llPayConfig.get("REQUEST_TYPE"));
		paymentInfo.setValid_order(llPayConfig.get("TIMEOUT"));
		/*
		 * pay_type和bank_code结合使用，可以默认选中支付方式和银行
		 */
		// paymentInfo.setBank_code("03080000");
		// paymentInfo.setPay_type("3");
		// 风控字段（具体字段根据和连连支付风控部门实际沟通确定）
		// RiskItem riskItem = new RiskItem();
		// riskItem.setUser_info_bind_phone("18367175737");
		// riskItem.setUser_info_dt_register(YinTongUtil.getCurrentDateTimeStr());
		// riskItem.setRisk_state("1");
		// riskItem.setFrms_ware_category("1009");
		// paymentInfo.setRisk_item(JSON.toJSONString(riskItem));
		// 生成JSON格式支付报文
		String req_data = genReqJsonStr(paymentInfo);
		log.info("支付请求JSON报文：" + req_data);

		return req_data;
	}

	@Override
	public String notice(String res_data,String type) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub

		if (YinTongUtil.isnull(res_data)) {
			log.info("res_data ：" +res_data);
			return null;
		}
		log.info("接收银通同步通知数据：" + res_data);
		JSONObject jsonObj = JSON.parseObject(res_data);
		// 签名验证
		if (checkSign(jsonObj)) {
			log.info("银通同步通知签名验证成功。");
		} else {
			log.info("银通同步通知签名验证未通过.");
		}
		
		log.info("支付结果："+PayResultEnum.getMsgByCode(jsonObj.getString("result_pay")));
		
		return jsonObj.getString("result_pay");
	}

	@Override
	public String check(String merchantOrderId, String merchantOrderTime,String type)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 生成本次交易签名
	 * 
	 * @param paymentInfo
	 * @return
	 */
	private String genReqJsonStr(PaymentInfo paymentInfo) {
		// 生成请求参数Map
		String req_data = JSON.toJSONString(paymentInfo);
		JSONObject jsonobj = JSON.parseObject(req_data);
		// 生成待签名串
		String sign_src = YinTongUtil.genSignData(jsonobj);
		log.info("签名原串" + sign_src);
		String sign_type = paymentInfo.getSign_type();
		String sign = null;
		if ("MD5".equals(sign_type)) {
			StringBuffer sb = new StringBuffer(sign_src);
			sb.append("&key=");
			sb.append(llPayConfig.get("MD5_KEY"));
			sign_src = sb.toString();
		}
		if ("MD5".equals(sign_type)) {
			try {
				sign = Md5Algorithm.getInstance().md5Digest(
						sign_src.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if ("RSA".equals(sign_type)) {// 商户私钥加签
			sign = TraderRSAUtil.sign(llPayConfig.get("TRADER_PRI_KEY"),
					sign_src);
		}
		jsonobj.put("sign", sign);
		return jsonobj.toJSONString();
	}

	/**
	 * 签名验证
	 * 
	 * @param res_data
	 * @return
	 */
	private boolean checkSign(JSONObject res_data) {
		// 生成请求参数Map
		// 生成待签名串
		String sign_src = YinTongUtil.genSignData(res_data);
		String sign = res_data.getString("sign");
		String sign_type = res_data.getString("sign_type");
		if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
			StringBuffer sb = new StringBuffer(sign_src);
			sb.append("&key=");
			sb.append(llPayConfig.get("MD5_KEY"));
			sign_src = sb.toString();
		}
		log.info("银通同步通知待签名原串[" + sign_src + "]");
		log.info("银通同步通知签名串[" + sign + "]");
		if (SignTypeEnum.RSA.getCode().equals(sign_type)) {
			return TraderRSAUtil.checksign(llPayConfig.get("YT_PUB_KEY"),
					sign_src, sign);

		} else if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
			return chechkSignMD5(sign_src, sign);
		}
		return false;
	}

	/**
	 * MD5签名验证
	 * 
	 * @param signSrc
	 * @param req_sign
	 * @return
	 */
	private boolean chechkSignMD5(String signSrc, String req_sign) {
		try {
			if (req_sign.equals(Md5Algorithm.getInstance().md5Digest(
					signSrc.getBytes("utf-8")))) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			log.info("商户MD5验签异常：" + e);
			return false;
		}
		log.info("MD5签名验证失败");
		return false;
	}

	@Override
	public String getParam(String key,String type) throws ServiceException,
			ServiceDaoException {
		// TODO Auto-generated method stub
		return llPayConfig.get("SERVER_URL");
	}

}
