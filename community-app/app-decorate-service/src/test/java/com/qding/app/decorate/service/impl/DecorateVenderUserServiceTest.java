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

import com.qding.app.decorate.model.DecorateVenderUser;
import com.qding.app.decorate.service.DecorateVenderUserService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DecorateVenderUserServiceTest {

	private static final Log log = LogFactory.getLog(DecorateVenderUserServiceTest.class);
	
	private DecorateVenderUserService decorateVenderUserService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-decorate-service/applicationContext-server.xml");
	        decorateVenderUserService = (DecorateVenderUserService) context.getBean("decorateVenderUserService");
			//local server
			/**
			decorateVenderUserService = (DecorateVenderUserService)  Naming.lookup("//localhost:9101/DecorateVenderUserRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 decorateVenderUserService = (DecorateVenderUserService) context.getBean("decorateVenderUserService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  DecorateVenderUser decorateVenderUser  = new DecorateVenderUser();	   
	   					 
			   					                decorateVenderUser.setVenderId(12123L);
            
			   					                decorateVenderUser.setVenderName("123");
            
			   					                decorateVenderUser.setUserName("123");
            
			   					                decorateVenderUser.setUserIdNumber("13");
            
			   					                decorateVenderUser.setUserMobile("13");
            
			   					
			   					                decorateVenderUser.setUserMobile2("123");
            
			   					                decorateVenderUser.setUserEmail("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.decorateVenderUserService.insert(decorateVenderUser);

      decorateVenderUser = this.decorateVenderUserService.getObjectById(id);

	  DecorateVenderUser decorateVenderUser2=this.decorateVenderUserService.getObjectById(id);
	    Assert.assertNotNull(decorateVenderUser2);
	  
		// 2. 更改 
				 		 				 				   decorateVenderUser.setVenderId(123L);
		    		 				 				   decorateVenderUser.setVenderName("132");
		    		 				 				   decorateVenderUser.setUserName("123");
		    		 				 				   decorateVenderUser.setUserIdNumber("1");
		    		 				 				   decorateVenderUser.setUserMobile("123");
		    		 				 					 				 				   decorateVenderUser.setUserMobile2("123");
		    		 				 				   decorateVenderUser.setUserEmail("123");
		    		 				 					 				 		 				 		 				 					 				 					 				boolean success=this.decorateVenderUserService.update(decorateVenderUser);		
		Assert.assertEquals(true, success);
		 DecorateVenderUser decorateVenderUser3=this.decorateVenderUserService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.decorateVenderUserService.delete(id);	
		Assert.assertEquals(true, success);
		DecorateVenderUser decorateVenderUser4=this.decorateVenderUserService.getObjectById(id);
		Assert.assertNull(decorateVenderUser4);
		
		//4.batchInsert
		 List<DecorateVenderUser> list=new ArrayList<DecorateVenderUser>();
	  	  DecorateVenderUser decorateVenderUser5  = new DecorateVenderUser();	   
	   					 
			   					                decorateVenderUser5.setVenderId(12123L);
            
			   					                decorateVenderUser5.setVenderName("123");
            
			   					                decorateVenderUser5.setUserName("123");
            
			   					                decorateVenderUser5.setUserIdNumber("13");
            
			   					                decorateVenderUser5.setUserMobile("13");
            
			   					
			   					                decorateVenderUser5.setUserMobile2("123");
            
			   					                decorateVenderUser5.setUserEmail("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	    list.add(decorateVenderUser5);	   
	  	  DecorateVenderUser decorateVenderUser6  = new DecorateVenderUser();	   
	   					 
			   					                decorateVenderUser6.setVenderId(123L);
            
			   					                decorateVenderUser6.setVenderName("132");
            
			   					                decorateVenderUser6.setUserName("123");
            
			   					                decorateVenderUser6.setUserIdNumber("1");
            
			   					                decorateVenderUser6.setUserMobile("123");
            
			   					
			   					                decorateVenderUser6.setUserMobile2("123");
            
			   					                decorateVenderUser6.setUserEmail("123");
            
			   					
			   					 
			   					 
			   					
			   					
			   	   list.add(decorateVenderUser6);
	   List<DecorateVenderUser> insertResults= this.decorateVenderUserService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(DecorateVenderUser o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<DecorateVenderUser> getResults= this.decorateVenderUserService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(DecorateVenderUser o :insertResults){
			this.decorateVenderUserService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

