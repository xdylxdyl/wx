package com.qding.common.pay.service.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qding.common.pay.service.PayOrderService;
import com.qding.common.pay.uitl.ali.UtilDate;
import com.qding.common.pay.uitl.ali.pay.AlipayCore;
import com.qding.common.pay.uitl.ali.pay.AlipayNotify;
import com.qding.common.pay.uitl.ali.pay.AlipaySubmit;
import com.qding.common.util.json.GsonUtil;

/**
 * Created by magenm on 14-6-19.
 */
public class AliPayServiceImpl implements PayOrderService{

    private static final Log log = LogFactory.getLog(AliPayServiceImpl.class);

    private Map<String, String> aliPayConfig;

    public Map<String, String> getAliPayConfig() {
        return aliPayConfig;
    }

    public void setAliPayConfig(Map<String, String> aliPayConfig) {
        this.aliPayConfig = aliPayConfig;
    }

    @Override
    public String pay(String userid, String merchantOrderId, String merchantOrderTime, String merchantOrderName, String merchantOrderAmt, String merchantOrderDesc, String frontUrl, String backUrl,String type) throws ServiceException, ServiceDaoException {
    	
    	//req_data详细信息
		
    	//服务器异步通知页面路径
		String notify_url = backUrl;
		//需http://格式的完整路径，不能加?id=123这类自定义参数
		//页面跳转同步通知页面路径
		String call_back_url = frontUrl;
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
		//操作中断返回地址
		String merchant_url = frontUrl;
		//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数

		//卖家支付宝帐户
		String seller_email = aliPayConfig.get("seller_email");
		//必填

		//商户订单号
		String out_trade_no = merchantOrderId;
		//商户网站订单系统中唯一订单号，必填

		//订单名称
		String subject = merchantOrderName;
		//必填

		//付款金额
		String total_fee = merchantOrderAmt;
		//必填
		
		//请求业务参数详细
		String req_dataToken = "<direct_trade_create_req><notify_url>" + notify_url + "</notify_url><call_back_url>" + call_back_url + "</call_back_url><seller_account_name>" + seller_email + "</seller_account_name><out_trade_no>" + out_trade_no + "</out_trade_no><subject>" + subject + "</subject><total_fee>" + total_fee + "</total_fee><merchant_url>" + merchant_url + "</merchant_url></direct_trade_create_req>";
		//必填
		
		//把请求参数打包成数组
		Map<String, String> sParaTempToken = new HashMap<String, String>();
		sParaTempToken.put("service", "alipay.wap.trade.create.direct");
		sParaTempToken.put("partner",  aliPayConfig.get("partner"));
		sParaTempToken.put("_input_charset", AlipayCore.CODING);
		sParaTempToken.put("sec_id", aliPayConfig.get("sign_type"));
		sParaTempToken.put("format", "xml"); //返回格式
		sParaTempToken.put("v", "2.0");
		sParaTempToken.put("req_id", UtilDate.getOrderNum());
		sParaTempToken.put("req_data", req_dataToken);
		
		try {
			//建立请求
			String sHtmlTextToken = AlipaySubmit.buildRequest(aliPayConfig.get("sign_type"),aliPayConfig.get("key"),aliPayConfig.get("private_key"),aliPayConfig.get("ali_gateway"),"", "",sParaTempToken);
			//URLDECODE返回的信息
			sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayCore.CODING);
			//获取token  
			String request_token = AlipaySubmit.getRequestToken(aliPayConfig.get("sign_type"),aliPayConfig.get("private_key"),sHtmlTextToken);
			////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////
						
			//业务详细
			String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
			//必填
			
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
			sParaTemp.put("partner", aliPayConfig.get("partner"));
			sParaTemp.put("_input_charset", AlipayCore.CODING);
			sParaTemp.put("sec_id", aliPayConfig.get("sign_type"));
			sParaTemp.put("format", "xml");
			sParaTemp.put("v", "2.0");
			sParaTemp.put("req_data", req_data);
			
			//建立请求
			String sHtmlText = AlipaySubmit.buildRequest(aliPayConfig.get("sign_type"),aliPayConfig.get("key"),aliPayConfig.get("private_key"),aliPayConfig.get("ali_gateway"), sParaTemp, "get", "确认");
			log.info(sHtmlText);
			
			return sHtmlText;
		} catch (Exception e) {
			log.info("create request error : " +e.getMessage());
			return null;
		}
    	
    }

    @Override
    public String notice(String xmlString,String type) throws ServiceException, ServiceDaoException {
    	
    	//获取支付宝POST过来反馈信息
//    	Map<String,String> params = new HashMap<String,String>();
//    	Map requestParams = request.getParameterMap();
//    	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//    		String name = (String) iter.next();
//    		String[] values = (String[]) requestParams.get(name);
//    		String valueStr = "";
//    		for (int i = 0; i < values.length; i++) {
//    			valueStr = (i == values.length - 1) ? valueStr + values[i]
//    					: valueStr + values[i] + ",";
//    		}
//    		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//    		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
//    		params.put(name, valueStr);
//    	}
    	log.info("alipay notice " + xmlString);
    	
    	Gson gson = new Gson();
    	Map<String,String> params = gson.fromJson(xmlString, new TypeToken<Map<String,String>>(){}.getType());
    	JSONObject json = new JSONObject();
    	try {
	    	//解密（如果是RSA签名需要解密，如果是MD5签名则下面一行清注释掉）
	    	//Map<String,String> decrypt_params = AlipayNotify.decrypt(params,aliPayConfig.get("private_key"));
	    	//XML解析notify_data数据
    		log.info("notiy_data :　" + URLDecoder.decode(params.get("notify_data")));
	    	Document doc_notify_data = DocumentHelper.parseText(URLDecoder.decode(params.get("notify_data")));
	    	//商户订单号
	    	String out_trade_no = doc_notify_data.selectSingleNode( "//notify/out_trade_no" ).getText();
	    	//支付宝交易号
	    	String trade_no = doc_notify_data.selectSingleNode( "//notify/trade_no" ).getText();
	    	//交易状态
	    	String trade_status = doc_notify_data.selectSingleNode( "//notify/trade_status" ).getText();
	
	    	json.put("orderCode", out_trade_no);
	    	json.put("tradeNo", trade_no);
    	
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
//			if(AlipayNotify.verifyNotify(aliPayConfig.get("partner"),aliPayConfig.get("verify_url"),
//					aliPayConfig.get("sign_type"),aliPayConfig.get("key"),aliPayConfig.get("private_key"),
//					aliPayConfig.get("ali_public_key"),params)){//验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				
				if(trade_status.equals("TRADE_FINISHED")){
					json.put("tradeStatus", "FINISHED");
				} else if (trade_status.equals("TRADE_SUCCESS")){
					json.put("tradeStatus", "SUCCESS");
				} else if (trade_status.equals("TRADE_CLOSED")){
					json.put("tradeStatus", "CLOSED");
				} else if (trade_status.equals("WAIT_BUYER_PAY")){
					json.put("tradeStatus", "WAIT");
				} else if (trade_status.equals("TRADE_PENDING")){
					json.put("tradeStatus", "PENDING");
				} else{
					json.put("tradeStatus", "FAILURE");
				}
				
				log.info("back info " + json);

				//////////////////////////////////////////////////////////////////////////////////////////
//			}else{//验证失败
//				json.put("tradeStatus", "FAILURE");
//			}
		} catch (Exception e) {
			log.info("notice error " + e.getMessage());
			json.put("tradeStatus", "FAILURE");
		}
    	
        return json.toString();
    }

    @Override
    public String check(String merchantOrderId, String merchantOrderTime,String type) throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public String getParam(String key,String type) throws ServiceException, ServiceDaoException {
        return aliPayConfig.get(key);
    }
}
