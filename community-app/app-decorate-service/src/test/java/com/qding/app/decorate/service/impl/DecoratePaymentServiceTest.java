package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;

import java.rmi.Naming;

import com.qding.app.decorate.model.DecoratePayment;
import com.qding.app.decorate.service.DecoratePaymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Ignore
public class DecoratePaymentServiceTest {

	private static final Log log = LogFactory.getLog(DecoratePaymentServiceTest.class);

	private DecoratePaymentService decoratePaymentService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/app-decorate-service/applicationContext-server.xml");
		decoratePaymentService = (DecoratePaymentService) context.getBean("decoratePaymentService");
		// local server
		/**
		 * decoratePaymentService = (DecoratePaymentService)
		 * Naming.lookup("//localhost:9101/DecoratePaymentRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * decoratePaymentService = (DecoratePaymentService)
		 * context.getBean("decoratePaymentService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		DecoratePayment decoratePayment = new DecoratePayment();

		decoratePayment.setName("A2decorate_payment-2042484612");

		decoratePayment.setAmount("123");

		decoratePayment.setStatus("123");

		decoratePayment.setType("13");

		decoratePayment.setRemark("13");

		decoratePayment.setDecorateId(123L);

		decoratePayment.setDecorateSerialId(123L);

		Long id = this.decoratePaymentService.insert(decoratePayment);

		decoratePayment = this.decoratePaymentService.getObjectById(id);

		DecoratePayment decoratePayment2 = this.decoratePaymentService.getObjectById(id);
		Assert.assertNotNull(decoratePayment2);

		// 2. 更改
		decoratePayment.setName("-287278099");
		decoratePayment.setAmount("132");
		decoratePayment.setStatus("123");
		decoratePayment.setType("1");
		decoratePayment.setRemark("123");
		decoratePayment.setDecorateId(123L);
		decoratePayment.setDecorateSerialId(123L);
		boolean success = this.decoratePaymentService.update(decoratePayment);
		Assert.assertEquals(true, success);
		DecoratePayment decoratePayment3 = this.decoratePaymentService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.decoratePaymentService.delete(id);
		Assert.assertEquals(true, success);
		DecoratePayment decoratePayment4 = this.decoratePaymentService.getObjectById(id);
		Assert.assertNull(decoratePayment4);

		// 4.batchInsert
		List<DecoratePayment> list = new ArrayList<DecoratePayment>();
		DecoratePayment decoratePayment5 = new DecoratePayment();

		decoratePayment5.setName("A2decorate_payment-2042484612");

		decoratePayment5.setAmount("123");

		decoratePayment5.setStatus("123");

		decoratePayment5.setType("13");

		decoratePayment5.setRemark("13");

		decoratePayment5.setDecorateId(123L);

		decoratePayment5.setDecorateSerialId(123L);

		list.add(decoratePayment5);
		DecoratePayment decoratePayment6 = new DecoratePayment();

		decoratePayment6.setName("-287278099");

		decoratePayment6.setAmount("132");

		decoratePayment6.setStatus("123");

		decoratePayment6.setType("1");

		decoratePayment6.setRemark("123");

		decoratePayment6.setDecorateId(123L);

		decoratePayment6.setDecorateSerialId(123L);

		list.add(decoratePayment6);
		List<DecoratePayment> insertResults = this.decoratePaymentService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (DecoratePayment o : insertResults) {
			ids.add(o.getId());
		}

		List<DecoratePayment> getResults = this.decoratePaymentService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (DecoratePayment o : insertResults) {
			this.decoratePaymentService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getDecoratePaymentIdByDecorateId() throws ServiceException, ServiceDaoException {
		List<DecoratePayment> list = new ArrayList<DecoratePayment>();
		DecoratePayment decoratePayment1 = new DecoratePayment();

		decoratePayment1.setName("A2decorate_payment-2042484612");

		decoratePayment1.setAmount("123");

		decoratePayment1.setStatus("123");

		decoratePayment1.setType("13");

		decoratePayment1.setRemark("13");

		decoratePayment1.setDecorateId(123L);

		decoratePayment1.setDecorateSerialId(123L);

		list.add(decoratePayment1);
		DecoratePayment decoratePayment2 = new DecoratePayment();

		decoratePayment2.setName("-287278099");

		decoratePayment2.setAmount("132");

		decoratePayment2.setStatus("123");

		decoratePayment2.setType("1");

		decoratePayment2.setRemark("123");

		decoratePayment2.setDecorateId(123L);

		decoratePayment2.setDecorateSerialId(123L);

		list.add(decoratePayment2);
		List<DecoratePayment> insertResults = this.decoratePaymentService.insertList(list);

		List<Long> lists = decoratePaymentService.getDecoratePaymentIdsByDecorateId(123L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (DecoratePayment o : insertResults) {
			this.decoratePaymentService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
