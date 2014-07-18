package com.qding.framework.user.service.impl;

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
import com.qding.framework.user.model.User;
import com.qding.framework.user.service.UserService;
@Ignore
public class UserServiceTest {

	private static final Log log = LogFactory.getLog(UserServiceTest.class);

	private UserService userService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-user-service/applicationContext-server.xml");
		userService = (UserService) context.getBean("userService");
		// local server
		/**
		 * userService = (UserService)
		 * Naming.lookup("//localhost:8811/UserRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); userService
		 * = (UserService) context.getBean("userService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		User user = new User();

		user.setNick("北京听蓝软件");

		user.setMobile("-2042484612");

		user.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		user.setSex("male");

		user.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		

		user.setLoginAt(1396341910232L);

		user.setLastLoginAt(1396341910232L);

		Long id = this.userService.insert(user);

		user = this.userService.getObjectById(id);

		User user2 = this.userService.getObjectById(id);
		Assert.assertNotNull(user2);

		// 2. 更改
		user.setNick("友谊路新业广场");
		user.setMobile("-287278099");
		user.setPwd("231353f19c1740a99a08d4172f9ff0f3");
		user.setSex("female");
		user.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");
		
		user.setLoginAt(1396341910232L);
		user.setLastLoginAt(1396341910232L);
		boolean success = this.userService.update(user);
		Assert.assertEquals(true, success);
		User user3 = this.userService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.userService.delete(id);
		Assert.assertEquals(true, success);
		User user4 = this.userService.getObjectById(id);
		Assert.assertNull(user4);

		// 4.batchInsert
		List<User> list = new ArrayList<User>();
		User user5 = new User();

		user5.setNick("北京听蓝软件");

		user5.setMobile("-2042484612");

		user5.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		user5.setSex("male");

		user5.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		

		user5.setLoginAt(1396341910232L);

		user5.setLastLoginAt(1396341910232L);

		list.add(user5);
		User user6 = new User();

		user6.setNick("友谊路新业广场");

		user6.setMobile("-287278099");

		user6.setPwd("231353f19c1740a99a08d4172f9ff0f3");

		user6.setSex("female");

		user6.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");

		

		user6.setLoginAt(1396341910232L);

		user6.setLastLoginAt(1396341910232L);

		list.add(user6);
		List<User> insertResults = this.userService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (User o : insertResults) {
			ids.add(o.getId());
		}

		List<User> getResults = this.userService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (User o : insertResults) {
			this.userService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getUserIdByMobile() throws ServiceException, ServiceDaoException {
		List<User> list = new ArrayList<User>();
		User user1 = new User();

		user1.setNick("北京听蓝软件");

		user1.setMobile("-2042484612");

		user1.setPwd("ffbe2ac5f08943dbbe45e7dc8bf644b2");

		user1.setSex("male");

		user1.setImg("http://www.ptteng.com/r/user_info/435?version=1379043859439");

		

		user1.setLoginAt(1396341910232L);

		user1.setLastLoginAt(1396341910232L);

		list.add(user1);
		User user2 = new User();

		user2.setNick("友谊路新业广场");

		user2.setMobile("-287278099");

		user2.setPwd("231353f19c1740a99a08d4172f9ff0f3");

		user2.setSex("female");

		user2.setImg("http://www.ptteng.com/r/img/person/default-person-icon.jpg");

		

		user2.setLoginAt(1396341910232L);

		user2.setLastLoginAt(1396341910232L);

		list.add(user2);
		List<User> insertResults = this.userService.insertList(list);

		Long lists = userService.getUserIdByMobile("-2042484612");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (User o : insertResults) {
			this.userService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
