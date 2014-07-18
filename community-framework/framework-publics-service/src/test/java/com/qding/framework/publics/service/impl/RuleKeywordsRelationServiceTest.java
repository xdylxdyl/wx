package com.qding.framework.publics.service.impl;

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
import com.qding.framework.publics.model.RuleKeywordsRelation;
import com.qding.framework.publics.service.RuleKeywordsRelationService;
@Ignore
public class RuleKeywordsRelationServiceTest {

	private static final Log log = LogFactory.getLog(RuleKeywordsRelationServiceTest.class);

	private RuleKeywordsRelationService ruleKeywordsRelationService;

	 @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		ruleKeywordsRelationService = (RuleKeywordsRelationService) context.getBean("ruleKeywordsRelationService");
		// local server
		
		/*  ruleKeywordsRelationService = (RuleKeywordsRelationService)
		  Naming.lookup("//42.96.145.106:8801/RuleKeywordsRelationRMIService");
	*/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * ruleKeywordsRelationService = (RuleKeywordsRelationService)
		 * context.getBean("ruleKeywordsRelationService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		RuleKeywordsRelation ruleKeywordsRelation = new RuleKeywordsRelation();

		ruleKeywordsRelation.setKeywords("1");

		ruleKeywordsRelation.setPublicsID(145L);

		ruleKeywordsRelation.setRid(2L);
		
		ruleKeywordsRelation.setCreateBy(2L);
		
		ruleKeywordsRelation.setUpdateBy(2L);

		Long id = this.ruleKeywordsRelationService.insert(ruleKeywordsRelation);

		ruleKeywordsRelation = this.ruleKeywordsRelationService.getObjectById(id);

		RuleKeywordsRelation ruleKeywordsRelation2 = this.ruleKeywordsRelationService.getObjectById(id);
		Assert.assertNotNull(ruleKeywordsRelation2);

		// 2. 更改
		ruleKeywordsRelation.setKeywords("2");
		ruleKeywordsRelation.setPublicsID(148L);
		ruleKeywordsRelation.setRid(3L);
		ruleKeywordsRelation.setUpdateAt(2L);
		boolean success = this.ruleKeywordsRelationService.update(ruleKeywordsRelation);
		Assert.assertEquals(true, success);
		RuleKeywordsRelation ruleKeywordsRelation3 = this.ruleKeywordsRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.ruleKeywordsRelationService.delete(id);
		Assert.assertEquals(true, success);
		RuleKeywordsRelation ruleKeywordsRelation4 = this.ruleKeywordsRelationService.getObjectById(id);
		Assert.assertNull(ruleKeywordsRelation4);

		// 4.batchInsert
		List<RuleKeywordsRelation> list = new ArrayList<RuleKeywordsRelation>();
		RuleKeywordsRelation ruleKeywordsRelation5 = new RuleKeywordsRelation();

		ruleKeywordsRelation5.setKeywords("1");

		ruleKeywordsRelation5.setPublicsID(145L);

		ruleKeywordsRelation5.setRid(2L);
		
		ruleKeywordsRelation5.setCreateBy(2L);
		
		ruleKeywordsRelation5.setUpdateBy(2L);

		list.add(ruleKeywordsRelation5);
		RuleKeywordsRelation ruleKeywordsRelation6 = new RuleKeywordsRelation();

		ruleKeywordsRelation6.setKeywords("2");

		ruleKeywordsRelation6.setPublicsID(148L);

		ruleKeywordsRelation6.setRid(3L);
		
		ruleKeywordsRelation6.setCreateBy(2L);
		
		ruleKeywordsRelation6.setUpdateBy(2L);

		list.add(ruleKeywordsRelation6);
		List<RuleKeywordsRelation> insertResults = this.ruleKeywordsRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (RuleKeywordsRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<RuleKeywordsRelation> getResults = this.ruleKeywordsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (RuleKeywordsRelation o : insertResults) {
			this.ruleKeywordsRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getRuleKeywordsRelationIdsByPublicsID() throws ServiceException, ServiceDaoException {
		List<RuleKeywordsRelation> list = new ArrayList<RuleKeywordsRelation>();
		RuleKeywordsRelation ruleKeywordsRelation1 = new RuleKeywordsRelation();

		ruleKeywordsRelation1.setKeywords("1");

		ruleKeywordsRelation1.setPublicsID(145L);

		ruleKeywordsRelation1.setRid(2L);
		
		ruleKeywordsRelation1.setCreateBy(2L);
		
		ruleKeywordsRelation1.setUpdateBy(2L);

		list.add(ruleKeywordsRelation1);
		RuleKeywordsRelation ruleKeywordsRelation2 = new RuleKeywordsRelation();

		ruleKeywordsRelation2.setKeywords("2");

		ruleKeywordsRelation2.setPublicsID(148L);

		ruleKeywordsRelation2.setRid(3L);

		ruleKeywordsRelation2.setCreateBy(2L);
		
		ruleKeywordsRelation2.setUpdateBy(2L);
		
		list.add(ruleKeywordsRelation2);
		List<RuleKeywordsRelation> insertResults = this.ruleKeywordsRelationService.insertList(list);

		List<Long> lists = ruleKeywordsRelationService.getRuleKeywordsRelationIdsByPublicsID(145L, 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (RuleKeywordsRelation o : insertResults) {
			this.ruleKeywordsRelationService.delete(o.getId());
		}

	};

	// @Test
	public void getRuleKeywordsRelationRidByPublicsIDAndKeywords() throws ServiceException, ServiceDaoException {
		List<RuleKeywordsRelation> list = new ArrayList<RuleKeywordsRelation>();
		RuleKeywordsRelation ruleKeywordsRelation1 = new RuleKeywordsRelation();

		ruleKeywordsRelation1.setKeywords("1");

		ruleKeywordsRelation1.setPublicsID(145L);

		ruleKeywordsRelation1.setRid(2L);

		ruleKeywordsRelation1.setCreateBy(2L);
		
		ruleKeywordsRelation1.setUpdateBy(2L);

		list.add(ruleKeywordsRelation1);
		RuleKeywordsRelation ruleKeywordsRelation2 = new RuleKeywordsRelation();

		ruleKeywordsRelation2.setKeywords("2");

		ruleKeywordsRelation2.setPublicsID(148L);

		ruleKeywordsRelation2.setRid(3L);

		ruleKeywordsRelation2.setCreateBy(2L);
		
		ruleKeywordsRelation2.setUpdateBy(2L);

		list.add(ruleKeywordsRelation2);
		List<RuleKeywordsRelation> insertResults = this.ruleKeywordsRelationService.insertList(list);

		Long lists = ruleKeywordsRelationService.getRuleKeywordsRelationRidByPublicsIDAndKeywords(145L, "1");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (RuleKeywordsRelation o : insertResults) {
			this.ruleKeywordsRelationService.delete(o.getId());
		}

	};

	 @Test
	public void getRuleKeywordsRelationIdsByPublicsIDAndRid() throws ServiceException, ServiceDaoException {
		List<RuleKeywordsRelation> list = new ArrayList<RuleKeywordsRelation>();
		RuleKeywordsRelation ruleKeywordsRelation1 = new RuleKeywordsRelation();

		ruleKeywordsRelation1.setKeywords("1");

		ruleKeywordsRelation1.setPublicsID(145L);

		ruleKeywordsRelation1.setRid(2L);
		
		ruleKeywordsRelation1.setCreateBy(2L);
		
		ruleKeywordsRelation1.setUpdateBy(2L);

		list.add(ruleKeywordsRelation1);
		RuleKeywordsRelation ruleKeywordsRelation2 = new RuleKeywordsRelation();

		ruleKeywordsRelation2.setKeywords("2");

		ruleKeywordsRelation2.setPublicsID(148L);

		ruleKeywordsRelation2.setRid(3L);

		ruleKeywordsRelation2.setCreateBy(2L);
		
		ruleKeywordsRelation2.setUpdateBy(2L);

		list.add(ruleKeywordsRelation2);
		List<RuleKeywordsRelation> insertResults = this.ruleKeywordsRelationService.insertList(list);

		List<Long> lists = ruleKeywordsRelationService.getRuleKeywordsRelationIdsByPublicsIDAndRid(145L, 2L,
				0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (RuleKeywordsRelation o : insertResults) {
			this.ruleKeywordsRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
