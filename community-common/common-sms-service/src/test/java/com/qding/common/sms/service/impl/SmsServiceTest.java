package com.qding.common.sms.service.impl;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.sms.model.Sms;
import com.qding.common.sms.service.SmsService;
@Ignore
public class SmsServiceTest {

	private static final Log log = LogFactory.getLog(SmsServiceTest.class);

	private SmsService smsService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		smsService = (SmsService) context.getBean("smsService");
		// local server
		
		 smsService = (SmsService)
		  Naming.lookup("//42.96.145.106:9021/SmsRMIService");
	

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); smsService =
		 * (SmsService) context.getBean("smsService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Sms sms = new Sms();

		sms.setMessage("验证码：ABCD");

		sms.setType("REG");

		sms.setMobile("18600797582");

		Long id = this.smsService.insert(sms);

		sms = this.smsService.getObjectById(id);

		Sms sms2 = this.smsService.getObjectById(id);
		Assert.assertNotNull(sms2);

		// 2. 更改
		sms.setMessage("验证码：AB33");
		sms.setType("REG");
		sms.setMobile("18600797582");
		boolean success = this.smsService.update(sms);
		Assert.assertEquals(true, success);
		Sms sms3 = this.smsService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.smsService.delete(id);
		Assert.assertEquals(true, success);
		Sms sms4 = this.smsService.getObjectById(id);
		Assert.assertNull(sms4);

		// 4.batchInsert
		List<Sms> list = new ArrayList<Sms>();
		Sms sms5 = new Sms();

		sms5.setMessage("验证码：ABCD");

		sms5.setType("REG");

		sms5.setMobile("18600797582");

		list.add(sms5);
		Sms sms6 = new Sms();

		sms6.setMessage("验证码：AB33");

		sms6.setType("REG");

		sms6.setMobile("18600797582");

		list.add(sms6);
		List<Sms> insertResults = this.smsService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Sms o : insertResults) {
			ids.add(o.getId());
		}

		List<Sms> getResults = this.smsService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Sms o : insertResults) {
			this.smsService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getSmsIdByMobileAndType() throws ServiceException,
			ServiceDaoException {
		List<Sms> list = new ArrayList<Sms>();
		Sms sms1 = new Sms();

		sms1.setMessage("验证码：ABCD");

		sms1.setType("REG");

		sms1.setMobile("18600797582");

		list.add(sms1);
		Sms sms2 = new Sms();

		sms2.setMessage("验证码：AB33");

		sms2.setType("REG");

		sms2.setMobile("18600797582");

		list.add(sms2);
		List<Sms> insertResults = this.smsService.insertList(list);

		Long lists = smsService.getSmsIdByMobileAndType("18600797582", "REG");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Sms o : insertResults) {
			this.smsService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
