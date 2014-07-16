package com.qding.app.goods.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;

import java.rmi.Naming;

import com.qding.app.goods.model.Goods;
import com.qding.app.goods.model.ProviderPublicsRelation;
import com.qding.app.goods.service.ProviderPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ProviderPublicsRelationServiceTest {

	private static final Log log = LogFactory.getLog(ProviderPublicsRelationServiceTest.class);

	private ProviderPublicsRelationService providerPublicsRelationService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		providerPublicsRelationService = (ProviderPublicsRelationService) context
				.getBean("providerPublicsRelationService");
		// local server
		/**
		 * providerPublicsRelationService = (ProviderPublicsRelationService)
		 * Naming.lookup("//localhost:9041/ProviderPublicsRelationRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * providerPublicsRelationService = (ProviderPublicsRelationService)
		 * context.getBean("providerPublicsRelationService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		ProviderPublicsRelation providerPublicsRelation = new ProviderPublicsRelation();

		providerPublicsRelation.setProviderID(1L);

		providerPublicsRelation.setPublicsID(145L);

		providerPublicsRelation.setStatus(0);

		providerPublicsRelation.setUpdateBy(1L);

		providerPublicsRelation.setCreateBy(1L);

		Long id = this.providerPublicsRelationService.insert(providerPublicsRelation);

		providerPublicsRelation = this.providerPublicsRelationService.getObjectById(id);

		ProviderPublicsRelation providerPublicsRelation2 = this.providerPublicsRelationService.getObjectById(id);
		Assert.assertNotNull(providerPublicsRelation2);

		// 2. 更改
		providerPublicsRelation.setProviderID(2L);
		providerPublicsRelation.setPublicsID(148L);
		providerPublicsRelation.setStatus(0);
		providerPublicsRelation.setUpdateBy(2L);
		providerPublicsRelation.setCreateBy(2L);
		boolean success = this.providerPublicsRelationService.update(providerPublicsRelation);
		Assert.assertEquals(true, success);
		ProviderPublicsRelation providerPublicsRelation3 = this.providerPublicsRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.providerPublicsRelationService.delete(id);
		Assert.assertEquals(true, success);
		ProviderPublicsRelation providerPublicsRelation4 = this.providerPublicsRelationService.getObjectById(id);
		Assert.assertNull(providerPublicsRelation4);

		// 4.batchInsert
		List<ProviderPublicsRelation> list = new ArrayList<ProviderPublicsRelation>();
		ProviderPublicsRelation providerPublicsRelation5 = new ProviderPublicsRelation();

		providerPublicsRelation5.setProviderID(1L);

		providerPublicsRelation5.setPublicsID(145L);

		providerPublicsRelation5.setStatus(0);

		providerPublicsRelation5.setUpdateBy(1L);

		providerPublicsRelation5.setCreateBy(1L);

		list.add(providerPublicsRelation5);
		ProviderPublicsRelation providerPublicsRelation6 = new ProviderPublicsRelation();

		providerPublicsRelation6.setProviderID(2L);

		providerPublicsRelation6.setPublicsID(148L);

		providerPublicsRelation6.setStatus(0);

		providerPublicsRelation6.setUpdateBy(2L);

		providerPublicsRelation6.setCreateBy(2L);

		list.add(providerPublicsRelation6);
		List<ProviderPublicsRelation> insertResults = this.providerPublicsRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (ProviderPublicsRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<ProviderPublicsRelation> getResults = this.providerPublicsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (ProviderPublicsRelation o : insertResults) {
			this.providerPublicsRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getProviderPublicsRelationIdsByProviderID() throws ServiceException, ServiceDaoException {
		List<ProviderPublicsRelation> list = new ArrayList<ProviderPublicsRelation>();
		ProviderPublicsRelation providerPublicsRelation1 = new ProviderPublicsRelation();

		providerPublicsRelation1.setProviderID(1L);

		providerPublicsRelation1.setPublicsID(145L);

		providerPublicsRelation1.setStatus(0);

		providerPublicsRelation1.setUpdateBy(1L);

		providerPublicsRelation1.setCreateBy(1L);

		list.add(providerPublicsRelation1);
		ProviderPublicsRelation providerPublicsRelation2 = new ProviderPublicsRelation();

		providerPublicsRelation2.setProviderID(2L);

		providerPublicsRelation2.setPublicsID(148L);

		providerPublicsRelation2.setStatus(0);

		providerPublicsRelation2.setUpdateBy(2L);

		providerPublicsRelation2.setCreateBy(2L);

		list.add(providerPublicsRelation2);
		List<ProviderPublicsRelation> insertResults = this.providerPublicsRelationService.insertList(list);

		List<Long> lists = providerPublicsRelationService.getProviderPublicsRelationIdsByProviderID(1L, 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (ProviderPublicsRelation o : insertResults) {
			this.providerPublicsRelationService.delete(o.getId());
		}

	};

	// @Test
	public void getProviderPublicsRelationIdsByPublicsID() throws ServiceException, ServiceDaoException {
		List<ProviderPublicsRelation> list = new ArrayList<ProviderPublicsRelation>();
		ProviderPublicsRelation providerPublicsRelation1 = new ProviderPublicsRelation();

		providerPublicsRelation1.setProviderID(1L);

		providerPublicsRelation1.setPublicsID(145L);

		providerPublicsRelation1.setStatus(0);

		providerPublicsRelation1.setUpdateBy(1L);

		providerPublicsRelation1.setCreateBy(1L);

		list.add(providerPublicsRelation1);
		ProviderPublicsRelation providerPublicsRelation2 = new ProviderPublicsRelation();

		providerPublicsRelation2.setProviderID(2L);

		providerPublicsRelation2.setPublicsID(148L);

		providerPublicsRelation2.setStatus(0);

		providerPublicsRelation2.setUpdateBy(2L);

		providerPublicsRelation2.setCreateBy(2L);

		list.add(providerPublicsRelation2);
		List<ProviderPublicsRelation> insertResults = this.providerPublicsRelationService.insertList(list);

		List<Long> lists = providerPublicsRelationService.getProviderPublicsRelationIdsByPublicsIDAndStatus(145L, 0, 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (ProviderPublicsRelation o : insertResults) {
			this.providerPublicsRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};

	// @Test
	public void mockData() throws ServiceException, ServiceDaoException {

		List<String> contents = Arrays.asList(new String[] { "花生", "Iphone", "时光碟", "新电影", "", "电器", "餐饮" });
		Long rid = 1L;
		for (String content : contents) {
			ProviderPublicsRelation providerPublicsRelation = new ProviderPublicsRelation();

			providerPublicsRelation.setProviderID(rid);

			providerPublicsRelation.setPublicsID(145L);

			providerPublicsRelation.setStatus(0);

			providerPublicsRelation.setUpdateBy(1L);

			providerPublicsRelation.setCreateBy(1L);

			rid = rid + 1L;
			Long id = this.providerPublicsRelationService.insert(providerPublicsRelation);
		}
	}

}
