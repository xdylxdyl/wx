package com.qding.common.pay.service.impl;

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
import com.qding.common.pay.service.PayOrderService;
@Ignore
public class PayOrderServiceTest {

	private static final Log log = LogFactory.getLog(PayOrderServiceTest.class);

	private PayOrderService payOrderService;

	@Before
	public void setUp() throws Exception {

		// dao
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "classpath:META-INF/common-pay-service/applicationContext-server.xml");
		// payOrderService = (PayOrderService)
		// context.getBean("payOrderService");
		// local server

		payOrderService = (PayOrderService)
		Naming.lookup("//localhost:9051/PayOrderRMIService");

		/**
		 * test client
		 */
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:META-INF/spring/applicationContext-sca.xml");
//		payOrderService = (PayOrderService) context.getBean("payOrderService");

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		payOrderService.pay("1","1","1", "1", "1", "","","","aliPay");

	}

	@Test
	public void getPayOrderIdByOrderNumber() throws ServiceException,
	ServiceDaoException {
		
	};
	@Test
	public void checkQuery() throws ServiceException,
			ServiceDaoException {
		String merchantOrderId = "2014051915131043679465";
//		1400483591463
		String merchantOrderTime = "20140519151310";

		String rs = payOrderService.check(merchantOrderId, merchantOrderTime,"aliPay");
		System.out.println(rs);
	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
