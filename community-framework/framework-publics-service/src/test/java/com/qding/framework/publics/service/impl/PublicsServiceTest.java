package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.framework.publics.model.Publics;
import com.qding.framework.publics.service.PublicsService;
@Ignore
public class PublicsServiceTest {

	private static final Log log = LogFactory.getLog(PublicsServiceTest.class);

	private PublicsService publicsService;

	@Before
	public void setUp() throws Exception {

		// dao
		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		publicsService = (PublicsService) context.getBean("publicsService");*/
		// local server
		
		// publicsService = (PublicsService)
		// Naming.lookup("//framework.publics.service:8801/PublicsRMIService");
		 

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * publicsService = (PublicsService) context.getBean("publicsService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Publics publics = new Publics();
		publics.setName("北京听蓝软件");
		publics.setToken("ffbe2ac5f08943dbbe45e7dc8bf644b2");
		publics.setAppID("wxfc7d1fed47862585");
		publics.setAppSecret("311a6832a57965276ffe4f46566fd20a");
		publics.setAccount("info@t-lan.net");
		publics.setPwd("Fly@2013");
		publics.setUpdateBy(2L);
		publics.setCreateBy(2L);

		Long id = this.publicsService.insert(publics);

		publics = this.publicsService.getObjectById(id);

		Publics publics2 = this.publicsService.getObjectById(id);
		log.info("get object is "+publics2.toString());
		
		Assert.assertNotNull(publics2);

		// 2. 更改
		publics.setName("友谊路新业广场");
		publics.setToken("231353f19c1740a99a08d4172f9ff0f3");
		publics.setAppID("wxab81c29a8f41f2b4");
		publics.setAppSecret("919200ee54cabe3771abf3a76a03114e");
		publics.setAccount("account-test");
		publics.setPwd("pwd-test");
		publics.setUpdateBy(2L);
		
		boolean success = this.publicsService.update(publics);
		Assert.assertEquals(true, success);

		Publics publics3 = this.publicsService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.publicsService.delete(id);
		Assert.assertEquals(true, success);
		Publics publics4 = this.publicsService.getObjectById(id);
		Assert.assertNull(publics4);

		// 4.batchInsert
		List<Publics> list = new ArrayList<Publics>();
		Publics publics5 = new Publics();
		publics5.setName("北京听蓝软件");
		publics5.setToken("ffbe2ac5f08943dbbe45e7dc8bf644b2");
		publics5.setAppID("wxfc7d1fed47862585");
		publics5.setAppSecret("311a6832a57965276ffe4f46566fd20a");
		publics5.setAccount("account-test");
		publics5.setPwd("pwd-test");
		publics5.setUpdateBy(2L);
		publics5.setCreateBy(2L);
		list.add(publics5);

		Publics publics6 = new Publics();
		publics6.setName("友谊路新业广场");
		publics6.setToken("231353f19c1740a99a08d4172f9ff0f3");
		publics6.setAppID("wxab81c29a8f41f2b4");
		publics6.setAppSecret("919200ee54cabe3771abf3a76a03114e");
		publics6.setAccount("account-test");
		publics6.setPwd("pwd-test");
		publics6.setUpdateBy(2L);
		publics6.setCreateBy(2L);
		list.add(publics6);

		List<Publics> insertResults = this.publicsService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Publics o : insertResults) {
			ids.add(o.getId());
		}

		List<Publics> getResults = this.publicsService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Publics o : insertResults) {
			this.publicsService.delete(o.getId());
		}

		// 6.batchUpdate

	}


	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
