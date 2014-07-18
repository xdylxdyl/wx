package com.qding.community.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.gemantic.common.util.MyTimeUtil;
import com.qding.community.service.impl.WXProcessServiceSubscribeImpl;

public class WXProcessServiceTest {
	private static final Log log = LogFactory.getLog(WXProcessServiceTest.class);

	public void testProcess() {

		WXProcessService processService = new WXProcessServiceSubscribeImpl();
		String key = null;
		String hash = null;
		// String result= processService.processMessage(hash,key);

		// log.info(" result is "+result);

	}

	@Test
	public void testNull() {
		Long time = 1400492384139L;
		String t = MyTimeUtil.convertLong2String(time, "yyyyy-MM-dd HH:mm:ss");
		log.info(t);
	}

}
