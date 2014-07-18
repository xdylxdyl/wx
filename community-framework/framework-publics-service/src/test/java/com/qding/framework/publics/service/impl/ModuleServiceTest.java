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
import com.qding.framework.publics.model.Module;
import com.qding.framework.publics.service.ModuleService;
@Ignore
public class ModuleServiceTest {

	private static final Log log = LogFactory.getLog(ModuleServiceTest.class);
	
	private ModuleService moduleService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/framework-publics-service/applicationContext-server.xml");
	        moduleService = (ModuleService) context.getBean("moduleService");
			//local server
			/**
			moduleService = (ModuleService)  Naming.lookup("//localhost:8801/ModuleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 moduleService = (ModuleService) context.getBean("moduleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Module module  = new Module();	   
	   					 
			   					                module.setName("北京听蓝软件");
            
			   					                module.setUrl("/web/publics");
            
			   					                module.setParentID(1L);
            
			   					                module.setType("web");
            
			   					 
			   					                module.setUpdateBy(1L);
            
			   					 
			   					                module.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.moduleService.insert(module);

      module = this.moduleService.getObjectById(id);

	  Module module2=this.moduleService.getObjectById(id);
	    Assert.assertNotNull(module2);
	  
		// 2. 更改 
				 		 				 				   module.setName("友谊路新业广场");
		    		 				 				   module.setUrl("/web/publics");
		    		 				 				   module.setParentID(1L);
		    		 				 				   module.setType("weixin");
		    		 				 		 				 				   module.setUpdateBy(2L);
		    		 				 		 				 				   module.setCreateBy(2L);
		    		 				boolean success=this.moduleService.update(module);		
		Assert.assertEquals(true, success);
		 Module module3=this.moduleService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.moduleService.delete(id);	
		Assert.assertEquals(true, success);
		Module module4=this.moduleService.getObjectById(id);
		Assert.assertNull(module4);
		
		//4.batchInsert
		 List<Module> list=new ArrayList<Module>();
	  	  Module module5  = new Module();	   
	   					 
			   					                module5.setName("北京听蓝软件");
            
			   					                module5.setUrl("/web/publics");
            
			   					                module5.setParentID(1L);
            
			   					                module5.setType("web");
            
			   					 
			   					                module5.setUpdateBy(1L);
            
			   					 
			   					                module5.setCreateBy(1L);
            
			   	    list.add(module5);	   
	  	  Module module6  = new Module();	   
	   					 
			   					                module6.setName("友谊路新业广场");
            
			   					                module6.setUrl("/web/publics");
            
			   					                module6.setParentID(1L);
            
			   					                module6.setType("weixin");
            
			   					 
			   					                module6.setUpdateBy(2L);
            
			   					 
			   					                module6.setCreateBy(2L);
            
			   	   list.add(module6);
	   List<Module> insertResults= this.moduleService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Module o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Module> getResults= this.moduleService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Module o :insertResults){
			this.moduleService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

