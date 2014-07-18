package com.qding.framework.user.service.impl;

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

import com.qding.framework.user.model.Potential;
import com.qding.framework.user.service.PotentialService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PotentialServiceTest {

	private static final Log log = LogFactory.getLog(PotentialServiceTest.class);

	private PotentialService potentialService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-user-service/applicationContext-server.xml");
		potentialService = (PotentialService) context.getBean("potentialService");
		// local server
		/**
		 * potentialService = (PotentialService)
		 * Naming.lookup("//localhost:8811/PotentialRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * potentialService = (PotentialService)
		 * context.getBean("potentialService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Potential potential = new Potential();

		potential.setNick("举世无双");

		potential.setSex("male");

		potential.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		potential.setPublicsID(3L);

		potential.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential.setFakeID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential.setLoginAt(1396341910232L);

		potential.setLastLoginAt(1396341910232L);

		Long id = this.potentialService.insert(potential);

		potential = this.potentialService.getObjectById(id);

		Potential potential2 = this.potentialService.getObjectById(id);
		Assert.assertNotNull(potential2);

		// 2. 更改
		potential.setNick("骗子");
		potential.setSex("female");
		potential.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");
		potential.setPublicsID(3L);
		potential.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
		potential.setFakeID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
		potential.setLoginAt(1396341910232L);
		potential.setLastLoginAt(1396341910232L);
		boolean success = this.potentialService.update(potential);
		Assert.assertEquals(true, success);
		Potential potential3 = this.potentialService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.potentialService.delete(id);
		Assert.assertEquals(true, success);
		Potential potential4 = this.potentialService.getObjectById(id);
		Assert.assertNull(potential4);

		// 4.batchInsert
		List<Potential> list = new ArrayList<Potential>();
		Potential potential5 = new Potential();

		potential5.setNick("举世无双");

		potential5.setSex("male");

		potential5.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		potential5.setPublicsID(3L);

		potential5.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential5.setFakeID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential5.setLoginAt(1396341910232L);

		potential5.setLastLoginAt(1396341910232L);

		list.add(potential5);
		Potential potential6 = new Potential();

		potential6.setNick("骗子");

		potential6.setSex("female");

		potential6.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");

		potential6.setPublicsID(3L);

		potential6.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential6.setFakeID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential6.setLoginAt(1396341910232L);

		potential6.setLastLoginAt(1396341910232L);

		list.add(potential6);
		List<Potential> insertResults = this.potentialService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Potential o : insertResults) {
			ids.add(o.getId());
		}

		List<Potential> getResults = this.potentialService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Potential o : insertResults) {
			this.potentialService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getPotentialIdsByFakeID() throws ServiceException, ServiceDaoException {
		List<Potential> list = new ArrayList<Potential>();
		Potential potential1 = new Potential();

		potential1.setNick("举世无双");

		potential1.setSex("male");

		potential1.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		potential1.setPublicsID(3L);

		potential1.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential1.setFakeID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential1.setLoginAt(1396341910232L);

		potential1.setLastLoginAt(1396341910232L);

		list.add(potential1);
		Potential potential2 = new Potential();

		potential2.setNick("骗子");

		potential2.setSex("female");

		potential2.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");

		potential2.setPublicsID(3L);

		potential2.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential2.setFakeID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential2.setLoginAt(1396341910232L);

		potential2.setLastLoginAt(1396341910232L);

		list.add(potential2);
		List<Potential> insertResults = this.potentialService.insertList(list);

		List<Long> lists = potentialService.getPotentialIdsByFakeID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw", 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Potential o : insertResults) {
			this.potentialService.delete(o.getId());
		}

	};

	// @Test
	public void getPotentialIdByOpenID() throws ServiceException, ServiceDaoException {
		List<Potential> list = new ArrayList<Potential>();
		Potential potential1 = new Potential();

		potential1.setNick("举世无双");

		potential1.setSex("male");

		potential1.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		potential1.setPublicsID(3L);

		potential1.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential1.setFakeID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");

		potential1.setLoginAt(1396341910232L);

		potential1.setLastLoginAt(1396341910232L);

		list.add(potential1);
		Potential potential2 = new Potential();

		potential2.setNick("骗子");

		potential2.setSex("female");

		potential2.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");

		potential2.setPublicsID(3L);

		potential2.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential2.setFakeID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		potential2.setLoginAt(1396341910232L);

		potential2.setLastLoginAt(1396341910232L);

		list.add(potential2);
		List<Potential> insertResults = this.potentialService.insertList(list);

		Long lists = potentialService.getPotentialIdByOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Potential o : insertResults) {
			this.potentialService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
