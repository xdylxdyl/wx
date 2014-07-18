package com.qding.framework.publics.service.impl;

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
import com.qding.framework.publics.model.PublicsProjectRelation;
import com.qding.framework.publics.service.PublicsProjectRelationService;
@Ignore
public class PublicsProjectRelationServiceTest {

	private static final Log log = LogFactory.getLog(PublicsProjectRelationServiceTest.class);

	private PublicsProjectRelationService publicsProjectRelationService;

	@Before
	public void setUp() throws Exception {

		// dao

		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "classpath:META-INF/framework-publics-service/applicationContext-server.xml"
		 * ); publicsProjectRelationService = (PublicsProjectRelationService)
		 * context .getBean("publicsProjectRelationService");
		 */

		// local server

		
		  publicsProjectRelationService = (PublicsProjectRelationService)
		 Naming .lookup("//framework.publics.service:9001/PublicsProjectRelationRMIService");
		

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * publicsProjectRelationService = (PublicsProjectRelationService)
		 * context.getBean("publicsProjectRelationService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		PublicsProjectRelation publicsProjectRelation = new PublicsProjectRelation();

		publicsProjectRelation.setPublicsID(145L);

		publicsProjectRelation.setProjectID(145L);

		publicsProjectRelation.setUpdateBy(2L);

		publicsProjectRelation.setCreateBy(1L);

		Long id = this.publicsProjectRelationService.insert(publicsProjectRelation);

		publicsProjectRelation = this.publicsProjectRelationService.getObjectById(id);

		PublicsProjectRelation publicsProjectRelation2 = this.publicsProjectRelationService.getObjectById(id);
		Assert.assertNotNull(publicsProjectRelation2);

		// 2. 更改
		publicsProjectRelation.setPublicsID(148L);
		publicsProjectRelation.setProjectID(148L);
		publicsProjectRelation.setUpdateBy(2L);
		publicsProjectRelation.setCreateBy(2L);
		boolean success = this.publicsProjectRelationService.update(publicsProjectRelation);
		Assert.assertEquals(true, success);
		PublicsProjectRelation publicsProjectRelation3 = this.publicsProjectRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.publicsProjectRelationService.delete(id);
		Assert.assertEquals(true, success);
		PublicsProjectRelation publicsProjectRelation4 = this.publicsProjectRelationService.getObjectById(id);
		Assert.assertNull(publicsProjectRelation4);

		// 4.batchInsert
		List<PublicsProjectRelation> list = new ArrayList<PublicsProjectRelation>();
		PublicsProjectRelation publicsProjectRelation5 = new PublicsProjectRelation();

		publicsProjectRelation5.setPublicsID(145L);

		publicsProjectRelation5.setProjectID(145L);

		publicsProjectRelation5.setUpdateBy(2L);

		publicsProjectRelation5.setCreateBy(1L);

		list.add(publicsProjectRelation5);
		PublicsProjectRelation publicsProjectRelation6 = new PublicsProjectRelation();

		publicsProjectRelation6.setPublicsID(148L);

		publicsProjectRelation6.setProjectID(148L);

		publicsProjectRelation6.setUpdateBy(2L);

		publicsProjectRelation6.setCreateBy(2L);

		list.add(publicsProjectRelation6);
		List<PublicsProjectRelation> insertResults = this.publicsProjectRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (PublicsProjectRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<PublicsProjectRelation> getResults = this.publicsProjectRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (PublicsProjectRelation o : insertResults) {
			this.publicsProjectRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getPublicsProjectRelationIdByPublicsID() throws ServiceException, ServiceDaoException {
		List<PublicsProjectRelation> list = new ArrayList<PublicsProjectRelation>();
		PublicsProjectRelation publicsProjectRelation1 = new PublicsProjectRelation();

		publicsProjectRelation1.setPublicsID(145L);

		publicsProjectRelation1.setProjectID(145L);

		publicsProjectRelation1.setUpdateBy(2L);

		publicsProjectRelation1.setCreateBy(1L);

		list.add(publicsProjectRelation1);
		PublicsProjectRelation publicsProjectRelation2 = new PublicsProjectRelation();

		publicsProjectRelation2.setPublicsID(148L);

		publicsProjectRelation2.setProjectID(148L);

		publicsProjectRelation2.setUpdateBy(2L);

		publicsProjectRelation2.setCreateBy(2L);

		list.add(publicsProjectRelation2);
		List<PublicsProjectRelation> insertResults = this.publicsProjectRelationService.insertList(list);

		Long lists = publicsProjectRelationService.getPublicsProjectRelationIdByPublicsID(145L);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (PublicsProjectRelation o : insertResults) {
			this.publicsProjectRelationService.delete(o.getId());
		}

	};

	@Test
	public void getPublicsProjectRelationIdsByProjectID() throws ServiceException, ServiceDaoException {
		List<PublicsProjectRelation> list = new ArrayList<PublicsProjectRelation>();
		PublicsProjectRelation publicsProjectRelation1 = new PublicsProjectRelation();

		publicsProjectRelation1.setPublicsID(145L);

		publicsProjectRelation1.setProjectID(145L);

		publicsProjectRelation1.setUpdateBy(2L);

		publicsProjectRelation1.setCreateBy(1L);

		list.add(publicsProjectRelation1);
		PublicsProjectRelation publicsProjectRelation2 = new PublicsProjectRelation();

		publicsProjectRelation2.setPublicsID(148L);

		publicsProjectRelation2.setProjectID(148L);

		publicsProjectRelation2.setUpdateBy(2L);

		publicsProjectRelation2.setCreateBy(2L);

		list.add(publicsProjectRelation2);
		List<PublicsProjectRelation> insertResults = this.publicsProjectRelationService.insertList(list);

		List<Long> lists = publicsProjectRelationService.getPublicsProjectRelationIdsByProjectID(145L, 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (PublicsProjectRelation o : insertResults) {
			this.publicsProjectRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
