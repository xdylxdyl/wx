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
import com.qding.framework.publics.model.Rule;
import com.qding.framework.publics.service.RuleService;

@Ignore
public class RuleServiceTest {

	private static final Log log = LogFactory.getLog(RuleServiceTest.class);

	private RuleService ruleService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		ruleService = (RuleService) context.getBean("ruleService");
		// local server
		/**
		 * ruleService = (RuleService)
		 * Naming.lookup("//localhost:8801/RuleRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); ruleService
		 * = (RuleService) context.getBean("ruleService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Rule rule = new Rule();

		rule.setName("汽车");

		rule.setMid(1L);

		rule.setPublicsID(145L);

		rule.setDefaultMessage("default");

		rule.setWelcomeMessage("welcome");

		rule.setType("text");
		
		rule.setCreateBy(2L);
		
		rule.setUpdateBy(2L);

		Long id = this.ruleService.insert(rule);

		rule = this.ruleService.getObjectById(id);

		Rule rule2 = this.ruleService.getObjectById(id);
		Assert.assertNotNull(rule2);

		// 2. 更改
		rule.setName("查询");
		rule.setMid(2L);
		rule.setPublicsID(148L);
		rule.setDefaultMessage("normal");
		rule.setWelcomeMessage("normal");
		rule.setType("multi_msg");
		rule.setUpdateBy(2L);
		boolean success = this.ruleService.update(rule);
		Assert.assertEquals(true, success);
		Rule rule3 = this.ruleService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.ruleService.delete(id);
		Assert.assertEquals(true, success);
		Rule rule4 = this.ruleService.getObjectById(id);
		Assert.assertNull(rule4);

		// 4.batchInsert
		List<Rule> list = new ArrayList<Rule>();
		Rule rule5 = new Rule();

		rule5.setName("汽车");

		rule5.setMid(1L);

		rule5.setPublicsID(145L);

		rule5.setDefaultMessage("default");

		rule5.setWelcomeMessage("welcome");

		rule5.setType("text");

		list.add(rule5);
		Rule rule6 = new Rule();

		rule6.setName("查询");

		rule6.setMid(2L);

		rule6.setPublicsID(148L);

		rule6.setDefaultMessage("normal");

		rule6.setWelcomeMessage("normal");

		rule6.setType("multi_msg");

		list.add(rule6);
		List<Rule> insertResults = this.ruleService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Rule o : insertResults) {
			ids.add(o.getId());
		}

		List<Rule> getResults = this.ruleService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Rule o : insertResults) {
			this.ruleService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getRuleIdsByPublicsID() throws ServiceException,
			ServiceDaoException {
		List<Rule> list = new ArrayList<Rule>();
		Rule rule1 = new Rule();

		rule1.setName("汽车");

		rule1.setMid(1L);

		rule1.setPublicsID(145L);

		rule1.setDefaultMessage("default");

		rule1.setWelcomeMessage("welcome");

		rule1.setType("text");
		
		rule1.setCreateBy(2L);
		
		rule1.setUpdateBy(2L);

		list.add(rule1);
		Rule rule2 = new Rule();

		rule2.setName("查询");

		rule2.setMid(2L);

		rule2.setPublicsID(148L);

		rule2.setDefaultMessage("normal");

		rule2.setWelcomeMessage("normal");

		rule2.setType("multi_msg");

		list.add(rule2);
		List<Rule> insertResults = this.ruleService.insertList(list);

		List<Long> lists = ruleService.getRuleIdsByPublicsID(145L,
				0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Rule o : insertResults) {
			this.ruleService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
