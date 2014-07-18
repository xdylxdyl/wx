package com.qding.framework.publics.service.impl;

import java.rmi.Naming;

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
import com.qding.framework.publics.model.Resources;
import com.qding.framework.publics.service.ResourcesService;

@Ignore
public class ResourcesServiceTest {

	private static final Log log = LogFactory
			.getLog(ResourcesServiceTest.class);

	private ResourcesService resourcesService;

	 @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		resourcesService = (ResourcesService) context
				.getBean("resourcesService");
		
		
		System.out.println("=========");
		// local server
		resourcesService = (ResourcesService)
		 Naming.lookup("//localhost:9001/ResourcesRMIService");

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * moduleService = (ModuleService) context.getBean("moduleService");
		 **/

	}

	 @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {
		 
		 

//		// 1.增加
//		 Resources resources  = new Resources();
//		 resources.setName("resources-framework-publics-service-rmi-test");
//		 resources.setResource("framework.publics.service:9001-test");
////		 
//		 Long id = this.resourcesService.insert(resources);
//////	
//		 System.out.println("=============="+id);
////		 
//		 Resources resources_new = this.resourcesService.getObjectById(id);
//		 resources_new.setResource("rest");
//		 boolean success = 	 this.resourcesService.update(resources_new);
//		Assert.assertEquals(true, success);
//		Resources resources3= this.resourcesService.getObjectById(598L);
		
		this.resourcesService.delete(602L);

	}

	 @Test
		public void testNULL() throws ServiceException, ServiceDaoException {

		};
		
		
		@Test
		public void testGetObjectById() throws ServiceException, ServiceDaoException {
			Resources resources = resourcesService.getObjectById(549L);
			System.out.println(resources);
			
		};
	 
}
