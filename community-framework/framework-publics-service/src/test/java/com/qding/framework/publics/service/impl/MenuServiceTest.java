package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.framework.publics.model.Menu;
import com.qding.framework.publics.service.MenuService;
@Ignore
public class MenuServiceTest {

	private static final Log log = LogFactory.getLog(MenuServiceTest.class);

	private MenuService menuService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		menuService = (MenuService) context.getBean("menuService");
		// local server
		/**
		 * menuService = (MenuService)
		 * Naming.lookup("//localhost:8801/MenuRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); menuService
		 * = (MenuService) context.getBean("menuService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Menu menu = new Menu();

		menu.setPublicsID(145L);

		menu.setMenu("{}");

		Long id = this.menuService.insert(menu);

		menu = this.menuService.getObjectById(id);

		Menu menu2 = this.menuService.getObjectById(id);
		Assert.assertNotNull(menu2);

		// 2. 更改
		menu.setPublicsID(148L);
		menu.setMenu("{}");
		boolean success = this.menuService.update(menu);
		Assert.assertEquals(true, success);
		Menu menu3 = this.menuService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.menuService.delete(id);
		Assert.assertEquals(true, success);
		Menu menu4 = this.menuService.getObjectById(id);
		Assert.assertNull(menu4);

		// 4.batchInsert
		List<Menu> list = new ArrayList<Menu>();
		Menu menu5 = new Menu();

		menu5.setPublicsID(145L);

		menu5.setMenu("{}");

		list.add(menu5);
		Menu menu6 = new Menu();

		menu6.setPublicsID(148L);

		menu6.setMenu("{}");

		list.add(menu6);
		List<Menu> insertResults = this.menuService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Menu o : insertResults) {
			ids.add(o.getId());
		}

		List<Menu> getResults = this.menuService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Menu o : insertResults) {
			this.menuService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getMenuMenuByPublicsID() throws ServiceException, ServiceDaoException {
		List<Menu> list = new ArrayList<Menu>();
		Menu menu1 = new Menu();

		menu1.setPublicsID(145L);

		menu1.setMenu("{}");

		list.add(menu1);
		Menu menu2 = new Menu();

		menu2.setPublicsID(148L);

		menu2.setMenu("{}");

		list.add(menu2);
		List<Menu> insertResults = this.menuService.insertList(list);

		String lists = menuService.getMenuMenuByPublicsID(145L);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Menu o : insertResults) {
			this.menuService.delete(o.getId());
		}

	};

	 //@Test
	public void getMenuIdByPublicsID() throws ServiceException, ServiceDaoException {
		List<Menu> list = new ArrayList<Menu>();
		Menu menu1 = new Menu();

		menu1.setPublicsID(145L);

		menu1.setMenu("{}");

		list.add(menu1);
		Menu menu2 = new Menu();

		menu2.setPublicsID(148L);

		menu2.setMenu("{}");

		list.add(menu2);
		List<Menu> insertResults = this.menuService.insertList(list);

		Long lists = menuService.getMenuIdByPublicsID(145L);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Menu o : insertResults) {
			this.menuService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {
		log.info(System.currentTimeMillis());

	};
}
