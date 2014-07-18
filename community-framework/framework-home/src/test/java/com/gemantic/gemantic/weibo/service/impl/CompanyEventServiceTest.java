package com.gemantic.gemantic.weibo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Ignore
public class CompanyEventServiceTest {

	private static final Log log = LogFactory
			.getLog(CompanyEventServiceTest.class);

	//private CompanyEventService companyEventService;

	@Before
	public void setUp() throws Exception {}

		// dao
		
		/*  ApplicationContext context = new ClassPathXmlApplicationContext(
		  "classpath:applicationContext-server.xml"); companyEventService =
		  (CompanyEventService) context .getBean("companyEventService");*/
		 
		// local server

		
		/* companyEventService = (CompanyEventService)
		  Naming.lookup("//localhost:8801/CompanyEventRMIService");*/
		 

		// test client

	/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-client.xml");
		companyEventService = (CompanyEventService) context
				.getBean("companyEventService");

	}*/

/*	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		CompanyEvent companyEvent = new CompanyEvent();

		companyEvent.setCompanyUri("xxxx");

		companyEvent.setEid(4L);

		companyEvent.setSource("weibo");

		Long id = this.companyEventService.insert(companyEvent);

		companyEvent = this.companyEventService.getObjectById(id);

		CompanyEvent companyEvent2 = this.companyEventService.getObjectById(id);
		Assert.assertNotNull(companyEvent2);

		// 2. 更改
		companyEvent.setCompanyUri("yyyy");
		companyEvent.setEid(3L);
		companyEvent.setSource("qq");
		boolean success = this.companyEventService.update(companyEvent);
		Assert.assertEquals(true, success);
		CompanyEvent companyEvent3 = this.companyEventService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.companyEventService.delete(id);
		Assert.assertEquals(true, success);
		CompanyEvent companyEvent4 = this.companyEventService.getObjectById(id);
		Assert.assertNull(companyEvent4);

		// 4.batchInsert
		List<CompanyEvent> list = new ArrayList<CompanyEvent>();
		CompanyEvent companyEvent5 = new CompanyEvent();

		companyEvent5.setCompanyUri("xxxx");

		companyEvent5.setEid(4L);

		companyEvent5.setSource("中文");

		list.add(companyEvent5);
		CompanyEvent companyEvent6 = new CompanyEvent();

		companyEvent6.setCompanyUri("yyyy");

		companyEvent6.setEid(3L);

		companyEvent6.setSource("qq");

		list.add(companyEvent6);
		List<CompanyEvent> insertResults = this.companyEventService
				.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (CompanyEvent o : insertResults) {
			ids.add(o.getId());
		}

		List<CompanyEvent> getResults = this.companyEventService
				.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (CompanyEvent o : insertResults) {
			// this.companyEventService.delete(o.getId());
		}

		// 6.batchUpdate""
		
		log.info("success ");
		

	}

	@Test
	public void getEidsByCompanyUri() throws ServiceException,
			ServiceDaoException {
		List<CompanyEvent> list = new ArrayList<CompanyEvent>();
		CompanyEvent companyEvent1 = new CompanyEvent();

		companyEvent1.setCompanyUri("xxxx");

		companyEvent1.setEid(4L);

		companyEvent1.setSource("weibo");

		list.add(companyEvent1);
		CompanyEvent companyEvent2 = new CompanyEvent();

		companyEvent2.setCompanyUri("yyyy");

		companyEvent2.setEid(3L);

		companyEvent2.setSource("qq");

		list.add(companyEvent2);
		List<CompanyEvent> insertResults = this.companyEventService
				.insertList(list);

		List<Long> lists = companyEventService.getEidsByCompanyUri("xxxx", 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (CompanyEvent o : insertResults) {
			this.companyEventService.delete(o.getId());
		}

	};*/

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
