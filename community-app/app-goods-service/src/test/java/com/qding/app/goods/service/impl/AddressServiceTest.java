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

import com.qding.app.goods.model.Address;
import com.qding.app.goods.service.AddressService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AddressServiceTest {

	private static final Log log = LogFactory.getLog(AddressServiceTest.class);

	private AddressService addressService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		addressService = (AddressService) context.getBean("addressService");
		// local server
		/**
		 * addressService = (AddressService)
		 * Naming.lookup("//localhost:9041/AddressRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * addressService = (AddressService) context.getBean("addressService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Address address = new Address();

		address.setName("北京全聚德有限责任公司");

		address.setPhone("13466789021");

		Long id = this.addressService.insert(address);

		address = this.addressService.getObjectById(id);

		Address address2 = this.addressService.getObjectById(id);
		Assert.assertNotNull(address2);

		// 2. 更改
		address.setName("安利亚太集团");
		address.setPhone("010-7422289");
		boolean success = this.addressService.update(address);
		Assert.assertEquals(true, success);
		Address address3 = this.addressService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.addressService.delete(id);
		Assert.assertEquals(true, success);
		Address address4 = this.addressService.getObjectById(id);
		Assert.assertNull(address4);

		// 4.batchInsert
		List<Address> list = new ArrayList<Address>();
		Address address5 = new Address();

		address5.setName("北京全聚德有限责任公司");

		address5.setPhone("13466789021");

		list.add(address5);
		Address address6 = new Address();

		address6.setName("安利亚太集团");

		address6.setPhone("010-7422289");

		list.add(address6);
		List<Address> insertResults = this.addressService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Address o : insertResults) {
			ids.add(o.getId());
		}

		List<Address> getResults = this.addressService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Address o : insertResults) {
			this.addressService.delete(o.getId());
		}

		// 6.batchUpdate

	}



	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
