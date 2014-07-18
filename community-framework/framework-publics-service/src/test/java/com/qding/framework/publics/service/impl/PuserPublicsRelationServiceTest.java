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
import com.qding.framework.publics.model.PuserPublicsRelation;
import com.qding.framework.publics.service.PuserPublicsRelationService;
@Ignore
public class PuserPublicsRelationServiceTest {

	private static final Log log = LogFactory
			.getLog(PuserPublicsRelationServiceTest.class);

	private PuserPublicsRelationService puserPublicsRelationService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		puserPublicsRelationService = (PuserPublicsRelationService) context
				.getBean("puserPublicsRelationService");
		// local server
		/**
		 * puserPublicsRelationService = (PuserPublicsRelationService)
		 * Naming.lookup("//localhost:8801/PuserPublicsRelationRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * puserPublicsRelationService = (PuserPublicsRelationService)
		 * context.getBean("puserPublicsRelationService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		PuserPublicsRelation puserPublicsRelation = new PuserPublicsRelation();

		puserPublicsRelation.setPuserID(1L);

		puserPublicsRelation.setUpdateBy(1L);

		puserPublicsRelation.setCreateBy(1L);

		Long id = this.puserPublicsRelationService.insert(puserPublicsRelation);

		puserPublicsRelation = this.puserPublicsRelationService
				.getObjectById(id);

		PuserPublicsRelation puserPublicsRelation2 = this.puserPublicsRelationService
				.getObjectById(id);
		Assert.assertNotNull(puserPublicsRelation2);

		// 2. 更改
		puserPublicsRelation.setPuserID(2L);
		puserPublicsRelation.setUpdateBy(2L);
		puserPublicsRelation.setCreateBy(2L);
		boolean success = this.puserPublicsRelationService
				.update(puserPublicsRelation);
		Assert.assertEquals(true, success);
		PuserPublicsRelation puserPublicsRelation3 = this.puserPublicsRelationService
				.getObjectById(id);
		// 3.删除
		boolean successDelete = this.puserPublicsRelationService.delete(id);
		Assert.assertEquals(true, success);
		PuserPublicsRelation puserPublicsRelation4 = this.puserPublicsRelationService
				.getObjectById(id);
		Assert.assertNull(puserPublicsRelation4);

		// 4.batchInsert
		List<PuserPublicsRelation> list = new ArrayList<PuserPublicsRelation>();
		PuserPublicsRelation puserPublicsRelation5 = new PuserPublicsRelation();

		puserPublicsRelation5.setPuserID(1L);

		puserPublicsRelation5.setUpdateBy(1L);

		puserPublicsRelation5.setCreateBy(1L);

		list.add(puserPublicsRelation5);
		PuserPublicsRelation puserPublicsRelation6 = new PuserPublicsRelation();

		puserPublicsRelation6.setPuserID(2L);

		puserPublicsRelation6.setUpdateBy(2L);

		puserPublicsRelation6.setCreateBy(2L);

		list.add(puserPublicsRelation6);
		List<PuserPublicsRelation> insertResults = this.puserPublicsRelationService
				.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (PuserPublicsRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<PuserPublicsRelation> getResults = this.puserPublicsRelationService
				.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (PuserPublicsRelation o : insertResults) {
			this.puserPublicsRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getPuserPublicsRelationIdsByPuserID() throws ServiceException,
			ServiceDaoException {
		List<PuserPublicsRelation> list = new ArrayList<PuserPublicsRelation>();
		PuserPublicsRelation puserPublicsRelation1 = new PuserPublicsRelation();

		puserPublicsRelation1.setPuserID(1L);

		puserPublicsRelation1.setUpdateBy(1L);

		puserPublicsRelation1.setCreateBy(1L);

		list.add(puserPublicsRelation1);
		PuserPublicsRelation puserPublicsRelation2 = new PuserPublicsRelation();

		puserPublicsRelation2.setPuserID(2L);

		puserPublicsRelation2.setUpdateBy(2L);

		puserPublicsRelation2.setCreateBy(2L);

		list.add(puserPublicsRelation2);
		List<PuserPublicsRelation> insertResults = this.puserPublicsRelationService
				.insertList(list);

		List<Long> lists = puserPublicsRelationService
				.getPuserPublicsRelationIdsByPuserID(1L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (PuserPublicsRelation o : insertResults) {
			this.puserPublicsRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
