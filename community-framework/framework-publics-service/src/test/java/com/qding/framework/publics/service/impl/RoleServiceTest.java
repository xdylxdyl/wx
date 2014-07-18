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
import com.qding.framework.publics.model.Role;
import com.qding.framework.publics.service.RoleService;
@Ignore
public class RoleServiceTest {

	private static final Log log = LogFactory.getLog(RoleServiceTest.class);

	private RoleService roleService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		roleService = (RoleService) context.getBean("roleService");
		// local server
		/**
		 * roleService = (RoleService)
		 * Naming.lookup("//localhost:8801/RoleRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); roleService
		 * = (RoleService) context.getBean("roleService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Role role = new Role();

		role.setName("北京听蓝软件");

		role.setPermissions("[{type: \"parent\", menuId: 1, sub_menu:[{type:\"url\",menuId: 2}]},{type:\"url\", menuId: 4}]");

		role.setStatus("using");

		role.setUpdateBy(1L);

		role.setCreateBy(1L);

		Long id = this.roleService.insert(role);

		role = this.roleService.getObjectById(id);

		Role role2 = this.roleService.getObjectById(id);
		Assert.assertNotNull(role2);

		// 2. 更改
		role.setName("友谊路新业广场");
		role.setPermissions("[{type: \"parent\", menuId: 1, sub_menu:[{type:\"url\",menuId: 2}]}]");
		role.setStatus("stopped");
		role.setUpdateBy(2L);
		role.setCreateBy(2L);
		boolean success = this.roleService.update(role);
		Assert.assertEquals(true, success);
		Role role3 = this.roleService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.roleService.delete(id);
		Assert.assertEquals(true, success);
		Role role4 = this.roleService.getObjectById(id);
		Assert.assertNull(role4);

		// 4.batchInsert
		List<Role> list = new ArrayList<Role>();
		Role role5 = new Role();

		role5.setName("北京听蓝软件");

		role5.setPermissions("[{type: \"parent\", menuId: 1, sub_menu:[{type:\"url\",menuId: 2}]},{type:\"url\", menuId: 4}]");

		role5.setStatus("using");

		role5.setUpdateBy(1L);

		role5.setCreateBy(1L);

		list.add(role5);
		Role role6 = new Role();

		role6.setName("友谊路新业广场");

		role6.setPermissions("[{type: \"parent\", menuId: 1, sub_menu:[{type:\"url\",menuId: 2}]}]");

		role6.setStatus("stopped");

		role6.setUpdateBy(2L);

		role6.setCreateBy(2L);

		list.add(role6);
		List<Role> insertResults = this.roleService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Role o : insertResults) {
			ids.add(o.getId());
		}

		List<Role> getResults = this.roleService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Role o : insertResults) {
			this.roleService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
