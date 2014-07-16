package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.qding.app.goods.model.Gorder;
import com.qding.app.goods.service.GorderService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GorderServiceTest {

	private static final Log log = LogFactory.getLog(GorderServiceTest.class);

	private GorderService gorderService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/app-goods-service/applicationContext-server.xml");
		gorderService = (GorderService) context.getBean("gorderService");
		// local server
		/**
		 * gorderService = (GorderService)
		 * Naming.lookup("//localhost:9041/GorderRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * gorderService = (GorderService) context.getBean("gorderService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Gorder gorder = new Gorder();

		gorder.setUserID(145L);

		gorder.setAddressID(1L);

		gorder.setPublicsID(145L);

		gorder.setCode("201404212105003");

		gorder.setTotal("3.010000");

		gorder.setType("online");

		gorder.setStatus(0);

		gorder.setCreateBy(1L);

		gorder.setUpdateBy(1L);

		Long id = this.gorderService.insert(gorder);

		gorder = this.gorderService.getObjectById(id);

		Gorder gorder2 = this.gorderService.getObjectById(id);
		Assert.assertNotNull(gorder2);

		// 2. 更改
		gorder.setUserID(148L);
		gorder.setAddressID(2L);
		gorder.setPublicsID(148L);
		gorder.setCode("201404212105003");
		gorder.setTotal("435");
		gorder.setType("offline");
		gorder.setStatus(0);
		gorder.setCreateBy(13L);
		gorder.setUpdateBy(13L);
		boolean success = this.gorderService.update(gorder);
		Assert.assertEquals(true, success);
		Gorder gorder3 = this.gorderService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.gorderService.delete(id);
		Assert.assertEquals(true, success);
		Gorder gorder4 = this.gorderService.getObjectById(id);
		Assert.assertNull(gorder4);

		// 4.batchInsert
		List<Gorder> list = new ArrayList<Gorder>();
		Gorder gorder5 = new Gorder();

		gorder5.setUserID(145L);

		gorder5.setAddressID(1L);

		gorder5.setPublicsID(145L);

		gorder5.setCode("201404212105003");

		gorder5.setTotal("3.010000");

		gorder5.setType("online");

		gorder5.setStatus(0);

		gorder5.setCreateBy(1L);

		gorder5.setUpdateBy(1L);

		list.add(gorder5);
		Gorder gorder6 = new Gorder();

		gorder6.setUserID(148L);

		gorder6.setAddressID(2L);

		gorder6.setPublicsID(148L);

		gorder6.setCode("201404212105003");

		gorder6.setTotal("435");

		gorder6.setType("offline");

		gorder6.setStatus(0);

		gorder6.setCreateBy(13L);

		gorder6.setUpdateBy(13L);

		list.add(gorder6);
		List<Gorder> insertResults = this.gorderService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Gorder o : insertResults) {
			ids.add(o.getId());
		}

		List<Gorder> getResults = this.gorderService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Gorder o : insertResults) {
			this.gorderService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getGorderIdsByUserID() throws ServiceException, ServiceDaoException {
		List<Gorder> list = new ArrayList<Gorder>();
		Gorder gorder1 = new Gorder();

		gorder1.setUserID(145L);

		gorder1.setAddressID(1L);

		gorder1.setPublicsID(145L);

		gorder1.setCode("201404212105003");

		gorder1.setTotal("3.010000");

		gorder1.setType("online");

		gorder1.setStatus(0);

		gorder1.setCreateBy(1L);

		gorder1.setUpdateBy(1L);

		list.add(gorder1);
		Gorder gorder2 = new Gorder();

		gorder2.setUserID(148L);

		gorder2.setAddressID(2L);

		gorder2.setPublicsID(148L);

		gorder2.setCode("201404212105003");

		gorder2.setTotal("435");

		gorder2.setType("offline");

		gorder2.setStatus(0);

		gorder2.setCreateBy(13L);

		gorder2.setUpdateBy(13L);

		list.add(gorder2);
		List<Gorder> insertResults = this.gorderService.insertList(list);

		List<Long> lists = gorderService.getGorderIdsByUserID(145L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Gorder o : insertResults) {
			this.gorderService.delete(o.getId());
		}

	};

	// @Test
	public void getGorderIdByCode() throws ServiceException, ServiceDaoException {
		List<Gorder> list = new ArrayList<Gorder>();
		Gorder gorder1 = new Gorder();

		gorder1.setUserID(145L);

		gorder1.setAddressID(1L);

		gorder1.setPublicsID(145L);

		gorder1.setCode("201404212105003");

		gorder1.setTotal("3.010000");

		gorder1.setType("online");

		gorder1.setStatus(0);

		gorder1.setCreateBy(1L);

		gorder1.setUpdateBy(1L);

		list.add(gorder1);
		Gorder gorder2 = new Gorder();

		gorder2.setUserID(148L);

		gorder2.setAddressID(2L);

		gorder2.setPublicsID(148L);

		gorder2.setCode("201404212105003");

		gorder2.setTotal("435");

		gorder2.setType("offline");

		gorder2.setStatus(0);

		gorder2.setCreateBy(13L);

		gorder2.setUpdateBy(13L);

		list.add(gorder2);
		List<Gorder> insertResults = this.gorderService.insertList(list);

		Long lists = gorderService.getGorderIdByCode("201404212105003");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Gorder o : insertResults) {
			this.gorderService.delete(o.getId());
		}

	};

	// @Test
	public void getGorderIdsByPublicsID() throws ServiceException, ServiceDaoException {
		List<Gorder> list = new ArrayList<Gorder>();
		Gorder gorder1 = new Gorder();

		gorder1.setUserID(145L);

		gorder1.setAddressID(1L);

		gorder1.setPublicsID(145L);

		gorder1.setCode("201404212105003");

		gorder1.setTotal("3.010000");

		gorder1.setType("online");

		gorder1.setStatus(0);

		gorder1.setCreateBy(1L);

		gorder1.setUpdateBy(1L);

		list.add(gorder1);
		Gorder gorder2 = new Gorder();

		gorder2.setUserID(148L);

		gorder2.setAddressID(2L);

		gorder2.setPublicsID(148L);

		gorder2.setCode("201404212105003");

		gorder2.setTotal("435");

		gorder2.setType("offline");

		gorder2.setStatus(0);

		gorder2.setCreateBy(13L);

		gorder2.setUpdateBy(13L);

		list.add(gorder2);
		List<Gorder> insertResults = this.gorderService.insertList(list);

		List<Long> lists = gorderService.getGorderIdsByPublicsID(145L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Gorder o : insertResults) {
			this.gorderService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
