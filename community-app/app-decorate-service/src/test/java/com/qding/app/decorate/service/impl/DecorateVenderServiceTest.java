package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.qding.app.decorate.model.DecorateVender;
import com.qding.app.decorate.service.DecorateVenderService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DecorateVenderServiceTest {

	private static final Log log = LogFactory.getLog(DecorateVenderServiceTest.class);
	
	private DecorateVenderService decorateVenderService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-decorate-service/applicationContext-server.xml");
	        decorateVenderService = (DecorateVenderService) context.getBean("decorateVenderService");
			//local server
			/**
			decorateVenderService = (DecorateVenderService)  Naming.lookup("//localhost:9101/DecorateVenderRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 decorateVenderService = (DecorateVenderService) context.getBean("decorateVenderService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  DecorateVender decorateVender  = new DecorateVender();	   
	   					 
			   					                decorateVender.setVenderId(12123L);
            
			   					                decorateVender.setVenderName("123");
            
			   					                decorateVender.setIsHveLcense(123);
            
			   					                decorateVender.setLegalName("13");
            
			   					                decorateVender.setLegalIdNumber("13");
            
			   					
			   					                decorateVender.setContactName("123");
            
			   					                decorateVender.setContactIdNumber("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.decorateVenderService.insert(decorateVender);

      decorateVender = this.decorateVenderService.getObjectById(id);

	  DecorateVender decorateVender2=this.decorateVenderService.getObjectById(id);
	    Assert.assertNotNull(decorateVender2);
	  
		// 2. 更改 
				 		 				 				   decorateVender.setVenderId(123L);
		    		 				 				   decorateVender.setVenderName("132");
		    		 				 				   decorateVender.setIsHveLcense(123);
		    		 				 				   decorateVender.setLegalName("1");
		    		 				 				   decorateVender.setLegalIdNumber("123");
		    		 				 					 				 				   decorateVender.setContactName("123");
		    		 				 				   decorateVender.setContactIdNumber("123");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.decorateVenderService.update(decorateVender);		
		Assert.assertEquals(true, success);
		 DecorateVender decorateVender3=this.decorateVenderService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.decorateVenderService.delete(id);	
		Assert.assertEquals(true, success);
		DecorateVender decorateVender4=this.decorateVenderService.getObjectById(id);
		Assert.assertNull(decorateVender4);
		
		//4.batchInsert
		 List<DecorateVender> list=new ArrayList<DecorateVender>();
	  	  DecorateVender decorateVender5  = new DecorateVender();	   
	   					 
			   					                decorateVender5.setVenderId(12123L);
            
			   					                decorateVender5.setVenderName("123");
            
			   					                decorateVender5.setIsHveLcense(123);
            
			   					                decorateVender5.setLegalName("13");
            
			   					                decorateVender5.setLegalIdNumber("13");
            
			   					
			   					                decorateVender5.setContactName("123");
            
			   					                decorateVender5.setContactIdNumber("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(decorateVender5);	   
	  	  DecorateVender decorateVender6  = new DecorateVender();	   
	   					 
			   					                decorateVender6.setVenderId(123L);
            
			   					                decorateVender6.setVenderName("132");
            
			   					                decorateVender6.setIsHveLcense(123);
            
			   					                decorateVender6.setLegalName("1");
            
			   					                decorateVender6.setLegalIdNumber("123");
            
			   					
			   					                decorateVender6.setContactName("123");
            
			   					                decorateVender6.setContactIdNumber("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(decorateVender6);
	   List<DecorateVender> insertResults= this.decorateVenderService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(DecorateVender o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<DecorateVender> getResults= this.decorateVenderService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(DecorateVender o :insertResults){
			this.decorateVenderService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

