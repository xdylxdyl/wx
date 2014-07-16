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

import com.qding.app.decorate.model.Decorate;
import com.qding.app.decorate.service.DecorateService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DecorateServiceTest {

	private static final Log log = LogFactory.getLog(DecorateServiceTest.class);
	
	private DecorateService decorateService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-decorate-service/applicationContext-server.xml");
	        decorateService = (DecorateService) context.getBean("decorateService");
			//local server
			/**
			decorateService = (DecorateService)  Naming.lookup("//localhost:9101/DecorateRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 decorateService = (DecorateService) context.getBean("decorateService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Decorate decorate  = new Decorate();	   
	   					 
			   					                decorate.setSerialId("12123");
            
			   					                decorate.setUserId("123");
            
			   					                decorate.setUserName("123");
            
			   					                decorate.setUserMobile("13");
            
			   					                decorate.setUserWxId("13");
            
			   					                decorate.setUserWxName("123");
            
			   					                decorate.setRoomId(123L);
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.decorateService.insert(decorate);

      decorate = this.decorateService.getObjectById(id);

	  Decorate decorate2=this.decorateService.getObjectById(id);
	    Assert.assertNotNull(decorate2);
	  
		// 2. 更改 
				 		 				 				   decorate.setSerialId("123");
		    		 				 				   decorate.setUserId("132");
		    		 				 				   decorate.setUserName("123");
		    		 				 				   decorate.setUserMobile("1");
		    		 				 				   decorate.setUserWxId("123");
		    		 				 				   decorate.setUserWxName("123");
		    		 				 				   decorate.setRoomId(123L);
		    		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				 					 				 					 				boolean success=this.decorateService.update(decorate);		
		Assert.assertEquals(true, success);
		 Decorate decorate3=this.decorateService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.decorateService.delete(id);	
		Assert.assertEquals(true, success);
		Decorate decorate4=this.decorateService.getObjectById(id);
		Assert.assertNull(decorate4);
		
		//4.batchInsert
		 List<Decorate> list=new ArrayList<Decorate>();
	  	  Decorate decorate5  = new Decorate();	   
	   					 
			   					                decorate5.setSerialId("12123");
            
			   					                decorate5.setUserId("123");
            
			   					                decorate5.setUserName("123");
            
			   					                decorate5.setUserMobile("13");
            
			   					                decorate5.setUserWxId("13");
            
			   					                decorate5.setUserWxName("123");
            
			   					                decorate5.setRoomId(123L);
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(decorate5);	   
	  	  Decorate decorate6  = new Decorate();	   
	   					 
			   					                decorate6.setSerialId("123");
            
			   					                decorate6.setUserId("132");
            
			   					                decorate6.setUserName("123");
            
			   					                decorate6.setUserMobile("1");
            
			   					                decorate6.setUserWxId("123");
            
			   					                decorate6.setUserWxName("123");
            
			   					                decorate6.setRoomId(123L);
            
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(decorate6);
	   List<Decorate> insertResults= this.decorateService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Decorate o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Decorate> getResults= this.decorateService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Decorate o :insertResults){
			this.decorateService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

