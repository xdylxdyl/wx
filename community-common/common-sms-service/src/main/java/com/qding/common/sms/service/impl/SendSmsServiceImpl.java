package com.qding.common.sms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qding.common.sms.service.SendSmsService;
import com.qding.common.util.HttpClientUtil;

public class SendSmsServiceImpl implements SendSmsService {
	private static final Log log = LogFactory.getLog(SendSmsServiceImpl.class);

	private Map<String, String> smsConfig;

	public Map<String, String> getSmsConfig() {
		return smsConfig;
	}

	public void setSmsConfig(Map<String, String> smsConfig) {
		this.smsConfig = smsConfig;
	}

	@Override
	public boolean sendMsg(String mobile, String text) {
		try {
			log.info("send sms:mobile:" + mobile + ":text:" + mobile);

			Map<String, String> map = new HashMap<String, String>();
			map.put("apikey", smsConfig.get("key"));
			map.put("mobile", mobile);
			map.put("text", text);

			String result = HttpClientUtil.httpPost(smsConfig.get("url"), map,
					"utf-8");
			if (result.contains("OK")) {
				log.info("send sms success");
				return true;
			} else {
				log.info("send sms failure:" + result);
				return false;
			}
		} catch (Exception e) {
			log.error("send sms failure:" + e.getMessage());
			return false;
		}
	}

}
