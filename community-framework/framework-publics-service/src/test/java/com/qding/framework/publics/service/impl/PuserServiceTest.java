package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.framework.publics.model.Puser;
import com.qding.framework.publics.service.PuserService;

@Ignore
public class PuserServiceTest {

	private static final Log log = LogFactory.getLog(PuserServiceTest.class);

	private PuserService puserService;

	//@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		puserService = (PuserService) context.getBean("puserService");
		// local server
		/**
		 * puserService = (PuserService)
		 * Naming.lookup("//localhost:8801/PuserRMIService");
		 **/

		//test client 
//		ApplicationContext context = new
//		  ClassPathXmlApplicationContext
//		  ("classpath:META-INF/spring/applicationContext-sca.xml"); puserService
//		  = (PuserService) context.getBean("puserService");
		 

	}

	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Puser puser = new Puser();

		puser.setName("北京听蓝软件");

		puser.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		

		Long id = this.puserService.insert(puser);

		puser = this.puserService.getObjectById(id);

		Puser puser2 = this.puserService.getObjectById(id);
		Assert.assertNotNull(puser2);

		// 2. 更改
		puser.setName("友谊路新业广场");
		puser.setPwd("231353f19c1740a99a08d4172f9ff0f3");
		
		boolean success = this.puserService.update(puser);
		Assert.assertEquals(true, success);
		Puser puser3 = this.puserService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.puserService.delete(id);
		Assert.assertEquals(true, success);
		Puser puser4 = this.puserService.getObjectById(id);
		Assert.assertNull(puser4);

		// 4.batchInsert
		List<Puser> list = new ArrayList<Puser>();
		Puser puser5 = new Puser();

		puser5.setName("北京听蓝软件");

		puser5.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		

		list.add(puser5);
		Puser puser6 = new Puser();

		puser6.setName("友谊路新业广场");

		puser6.setPwd("231353f19c1740a99a08d4172f9ff0f3");

	

		list.add(puser6);
		List<Puser> insertResults = this.puserService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Puser o : insertResults) {
			ids.add(o.getId());
		}

		List<Puser> getResults = this.puserService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Puser o : insertResults) {
			this.puserService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getPuserIdsByName() throws ServiceException, ServiceDaoException {
		List<Puser> list = new ArrayList<Puser>();
		Puser puser1 = new Puser();

		puser1.setName("北京听蓝软件");

		puser1.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		

		list.add(puser1);
		Puser puser2 = new Puser();

		puser2.setName("友谊路新业广场");

		puser2.setPwd("231353f19c1740a99a08d4172f9ff0f3");

		

		list.add(puser2);
		List<Puser> insertResults = this.puserService.insertList(list);

		List<Long> lists = puserService.getPuserIdsByName("北京听蓝软件", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Puser o : insertResults) {
			this.puserService.delete(o.getId());
		}

	};
	
	// @Test
		public void getPuserIds() throws ServiceException, ServiceDaoException {
		 
		 	Map<String,Object> map = new HashMap<>();
				map.put("role_id", 1);
				map.put("status", "stoped");
			

			//List<Long> lists = puserService.getPuserIdsByCondition(map, 0, 65535);
			// TODO 增加自己的验证逻辑
			//Assert.assertNotNull(lists);

		};

	//@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
