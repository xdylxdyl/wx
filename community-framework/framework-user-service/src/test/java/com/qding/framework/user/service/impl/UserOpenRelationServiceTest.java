package com.qding.framework.user.service.impl;

import java.rmi.Naming;
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
import com.qding.framework.user.model.UserOpenRelation;
import com.qding.framework.user.service.UserOpenRelationService;
@Ignore
public class UserOpenRelationServiceTest {

	private static final Log log = LogFactory.getLog(UserOpenRelationServiceTest.class);

	private UserOpenRelationService userOpenRelationService;

	@Before
	public void setUp() throws Exception {

		// dao
		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "classpath:META-INF/framework-user-service/applicationContext-server.xml"
		 * ); userOpenRelationService = (UserOpenRelationService)
		 * context.getBean("userOpenRelationService");
		 */// local server

		userOpenRelationService = (UserOpenRelationService) Naming
				.lookup("//localhost:9011/UserOpenRelationRMIService");

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * userOpenRelationService = (UserOpenRelationService)
		 * context.getBean("userOpenRelationService");
		 **/

	}

	 @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		UserOpenRelation userOpenRelation = new UserOpenRelation();

		userOpenRelation.setUid(2L);

		userOpenRelation.setOpenID("13466789042");
		userOpenRelation.setPublicsID(1L);

		userOpenRelation.setType("mobile");

		Long id = this.userOpenRelationService.insert(userOpenRelation);

		userOpenRelation = this.userOpenRelationService.getObjectById(id);

		UserOpenRelation userOpenRelation2 = this.userOpenRelationService.getObjectById(id);
		Assert.assertNotNull(userOpenRelation2);

		// 2. 更改
		userOpenRelation.setUid(3L);
		userOpenRelation.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
		userOpenRelation.setType("wx_fakeID");
		boolean success = this.userOpenRelationService.update(userOpenRelation);
		Assert.assertEquals(true, success);
		UserOpenRelation userOpenRelation3 = this.userOpenRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.userOpenRelationService.delete(id);
		Assert.assertEquals(true, success);
		UserOpenRelation userOpenRelation4 = this.userOpenRelationService.getObjectById(id);
		Assert.assertNull(userOpenRelation4);

		// 4.batchInsert
		List<UserOpenRelation> list = new ArrayList<UserOpenRelation>();
		UserOpenRelation userOpenRelation5 = new UserOpenRelation();

		userOpenRelation5.setUid(2L);

		userOpenRelation5.setOpenID("13466789042");

		userOpenRelation5.setType("mobile");
		userOpenRelation5.setPublicsID(1L);

		list.add(userOpenRelation5);
		UserOpenRelation userOpenRelation6 = new UserOpenRelation();

		userOpenRelation6.setUid(3L);
		userOpenRelation6.setPublicsID(1L);
		userOpenRelation6.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		userOpenRelation6.setType("wx_fakeID");

		list.add(userOpenRelation6);
		List<UserOpenRelation> insertResults = this.userOpenRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (UserOpenRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<UserOpenRelation> getResults = this.userOpenRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (UserOpenRelation o : insertResults) {
			this.userOpenRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getUserOpenRelationUidByOpenIDAndType() throws ServiceException, ServiceDaoException {
		List<UserOpenRelation> list = new ArrayList<UserOpenRelation>();
		UserOpenRelation userOpenRelation1 = new UserOpenRelation();

		userOpenRelation1.setUid(2L);

		userOpenRelation1.setOpenID("13466789042");

		userOpenRelation1.setType("mobile");

		list.add(userOpenRelation1);
		UserOpenRelation userOpenRelation2 = new UserOpenRelation();

		userOpenRelation2.setUid(3L);

		userOpenRelation2.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");

		userOpenRelation2.setType("wx_fakeID");

		list.add(userOpenRelation2);
		List<UserOpenRelation> insertResults = this.userOpenRelationService.insertList(list);

		Long lists = userOpenRelationService.getUserOpenRelationUidByOpenIDAndType("13466789042", "mobile");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (UserOpenRelation o : insertResults) {
			this.userOpenRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
