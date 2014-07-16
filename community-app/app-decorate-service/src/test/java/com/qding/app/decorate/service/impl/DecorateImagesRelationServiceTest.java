package com.qding.app.decorate.service.impl;

import java.rmi.Naming;
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
import com.qding.app.decorate.model.DecorateImagesRelation;
import com.qding.app.decorate.service.DecorateImagesRelationService;

@Ignore
public class DecorateImagesRelationServiceTest {

	private static final Log log = LogFactory.getLog(DecorateImagesRelationServiceTest.class);

	private DecorateImagesRelationService decorateImagesRelationService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		decorateImagesRelationService = (DecorateImagesRelationService) context
				.getBean("decorateImagesRelationService");
		// local server

		decorateImagesRelationService = (DecorateImagesRelationService) Naming
				.lookup("//115.28.20.72:9101/DecorateImagesRelationRMIService");

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * decorateImagesRelationService = (DecorateImagesRelationService)
		 * context.getBean("decorateImagesRelationService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		DecorateImagesRelation decorateImagesRelation = new DecorateImagesRelation();

		decorateImagesRelation.setDecorateId("12123");

		decorateImagesRelation.setImageId("123");

		decorateImagesRelation.setUpdateBy(123L);

		decorateImagesRelation.setCreateBy(123L);

		Long id = this.decorateImagesRelationService.insert(decorateImagesRelation);

		decorateImagesRelation = this.decorateImagesRelationService.getObjectById(id);

		DecorateImagesRelation decorateImagesRelation2 = this.decorateImagesRelationService.getObjectById(id);
		Assert.assertNotNull(decorateImagesRelation2);

		// 2. 更改
		decorateImagesRelation.setDecorateId("123");
		decorateImagesRelation.setImageId("132");
		decorateImagesRelation.setUpdateBy(123L);
		decorateImagesRelation.setCreateBy(12L);
		boolean success = this.decorateImagesRelationService.update(decorateImagesRelation);
		Assert.assertEquals(true, success);
		DecorateImagesRelation decorateImagesRelation3 = this.decorateImagesRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.decorateImagesRelationService.delete(id);
		Assert.assertEquals(true, success);
		DecorateImagesRelation decorateImagesRelation4 = this.decorateImagesRelationService.getObjectById(id);
		Assert.assertNull(decorateImagesRelation4);

		// 4.batchInsert
		List<DecorateImagesRelation> list = new ArrayList<DecorateImagesRelation>();
		DecorateImagesRelation decorateImagesRelation5 = new DecorateImagesRelation();

		decorateImagesRelation5.setDecorateId("12123");

		decorateImagesRelation5.setImageId("123");

		decorateImagesRelation5.setUpdateBy(123L);

		decorateImagesRelation5.setCreateBy(123L);

		list.add(decorateImagesRelation5);
		DecorateImagesRelation decorateImagesRelation6 = new DecorateImagesRelation();

		decorateImagesRelation6.setDecorateId("123");

		decorateImagesRelation6.setImageId("132");

		decorateImagesRelation6.setUpdateBy(123L);

		decorateImagesRelation6.setCreateBy(12L);

		list.add(decorateImagesRelation6);
		List<DecorateImagesRelation> insertResults = this.decorateImagesRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (DecorateImagesRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<DecorateImagesRelation> getResults = this.decorateImagesRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (DecorateImagesRelation o : insertResults) {
			this.decorateImagesRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
