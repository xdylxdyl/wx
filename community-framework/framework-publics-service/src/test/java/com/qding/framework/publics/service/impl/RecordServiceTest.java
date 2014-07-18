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
import com.qding.framework.publics.model.Record;
import com.qding.framework.publics.service.RecordService;
@Ignore
public class RecordServiceTest {

	private static final Log log = LogFactory.getLog(RecordServiceTest.class);

	private RecordService recordService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		recordService = (RecordService) context.getBean("recordService");
		// local server
		/**
		 * recordService = (RecordService)
		 * Naming.lookup("//localhost:9001/RecordRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * recordService = (RecordService) context.getBean("recordService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Record record = new Record();

		record.setPublicsID(145L);

		record.setObjectID(145L);

		record.setModule("gorder");

		record.setType(1);

		record.setContent("订单管理的状态从未支付变成了已成付");

		record.setCreateBy(2L);

		Long id = this.recordService.insert(record);

		record = this.recordService.getObjectById(id);

		Record record2 = this.recordService.getObjectById(id);
		Assert.assertNotNull(record2);

		// 2. 更改
		record.setPublicsID(148L);
		record.setObjectID(148L);
		record.setModule("module");
		record.setType(2);
		record.setContent("订单管理的状态从未支付变成了已成付");
		record.setCreateBy(2L);
		boolean success = this.recordService.update(record);
		Assert.assertEquals(true, success);
		Record record3 = this.recordService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.recordService.delete(id);
		Assert.assertEquals(true, success);
		Record record4 = this.recordService.getObjectById(id);
		Assert.assertNull(record4);

		// 4.batchInsert
		List<Record> list = new ArrayList<Record>();
		Record record5 = new Record();

		record5.setPublicsID(145L);

		record5.setObjectID(145L);

		record5.setModule("gorder");

		record5.setType(2);

		record5.setContent("订单管理的状态从未支付变成了已成付");

		record5.setCreateBy(2L);

		list.add(record5);
		Record record6 = new Record();

		record6.setPublicsID(148L);

		record6.setObjectID(148L);

		record6.setModule("module");

		record6.setType(2);

		record6.setContent("订单管理的状态从未支付变成了已成付");

		record6.setCreateBy(2L);

		list.add(record6);
		List<Record> insertResults = this.recordService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Record o : insertResults) {
			ids.add(o.getId());
		}

		List<Record> getResults = this.recordService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Record o : insertResults) {
			this.recordService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	 @Test
	public void getRecordIdsByObjectIDAndModule() throws ServiceException, ServiceDaoException {
		List<Record> list = new ArrayList<Record>();
		Record record1 = new Record();

		record1.setPublicsID(145L);

		record1.setObjectID(145L);

		record1.setModule("gorder");

		record1.setType(2);

		record1.setContent("订单管理的状态从未支付变成了已成付");

		record1.setCreateBy(2L);

		list.add(record1);
		Record record2 = new Record();

		record2.setPublicsID(148L);

		record2.setObjectID(148L);

		record2.setModule("module");

		record2.setType(2);

		record2.setContent("订单管理的状态从未支付变成了已成付");

		record2.setCreateBy(2L);

		list.add(record2);
		List<Record> insertResults = this.recordService.insertList(list);

		List<Long> lists = recordService.getRecordIdsByObjectIDAndModule(145L, "gorder", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Record o : insertResults) {
			this.recordService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
