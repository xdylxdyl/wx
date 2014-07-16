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

import com.qding.app.decorate.model.Images;
import com.qding.app.decorate.service.ImagesService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ImagesServiceTest {

	private static final Log log = LogFactory.getLog(ImagesServiceTest.class);
	
	private ImagesService imagesService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-decorate-service/applicationContext-server.xml");
	        imagesService = (ImagesService) context.getBean("imagesService");
			//local server
			/**
			imagesService = (ImagesService)  Naming.lookup("//localhost:9101/ImagesRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 imagesService = (ImagesService) context.getBean("imagesService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Images images  = new Images();	   
	   					 
			   					                images.setName("12123");
            
			   					                images.setOriginalPath("123");
            
			   					                images.setBigPath("123");
            
			   					                images.setMiddlePath("13");
            
			   					                images.setSmallPath("13");
            
			   					 
			   					 
			   					
			   					
			   	 
	 
	  Long id= this.imagesService.insert(images);

      images = this.imagesService.getObjectById(id);

	  Images images2=this.imagesService.getObjectById(id);
	    Assert.assertNotNull(images2);
	  
		// 2. 更改 
				 		 				 				   images.setName("123");
		    		 				 				   images.setOriginalPath("132");
		    		 				 				   images.setBigPath("123");
		    		 				 				   images.setMiddlePath("1");
		    		 				 				   images.setSmallPath("123");
		    		 				 		 				 		 				 					 				 					 				boolean success=this.imagesService.update(images);		
		Assert.assertEquals(true, success);
		 Images images3=this.imagesService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.imagesService.delete(id);	
		Assert.assertEquals(true, success);
		Images images4=this.imagesService.getObjectById(id);
		Assert.assertNull(images4);
		
		//4.batchInsert
		 List<Images> list=new ArrayList<Images>();
	  	  Images images5  = new Images();	   
	   					 
			   					                images5.setName("12123");
            
			   					                images5.setOriginalPath("123");
            
			   					                images5.setBigPath("123");
            
			   					                images5.setMiddlePath("13");
            
			   					                images5.setSmallPath("13");
            
			   					 
			   					 
			   					
			   					
			   	    list.add(images5);	   
	  	  Images images6  = new Images();	   
	   					 
			   					                images6.setName("123");
            
			   					                images6.setOriginalPath("132");
            
			   					                images6.setBigPath("123");
            
			   					                images6.setMiddlePath("1");
            
			   					                images6.setSmallPath("123");
            
			   					 
			   					 
			   					
			   					
			   	   list.add(images6);
	   List<Images> insertResults= this.imagesService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Images o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Images> getResults= this.imagesService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Images o :insertResults){
			this.imagesService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

