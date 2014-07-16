package com.qding.common.sms.service.impl;

import java.rmi.Naming;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.sms.service.SendSmsService;
@Ignore
public class SendSmsServiceTest {

	private static final Log log = LogFactory.getLog(SendSmsServiceTest.class);

	private SendSmsService sendsmsService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		sendsmsService = (SendSmsService) context.getBean("sendSmsService");
		// local server

		/*sendsmsService = (SendSmsService) Naming
				.lookup("//localhost:9021/SendSmsRMIService");*/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); smsService
		 * = (SmsService) context.getBean("smsService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {
		
		log.info("sendsmsService:"+sendsmsService);
		
		sendsmsService.sendMsg("13439504367", "注册验证码"+":【千丁互联】");

	}

	// @Test
	public void getSmsIdByMobileAndType() throws ServiceException,
			ServiceDaoException {
		

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
	
}
