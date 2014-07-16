package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.qding.app.goods.model.Tags;
import com.qding.app.goods.service.TagsService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsServiceTest {

	private static final Log log = LogFactory.getLog(TagsServiceTest.class);
	
	private TagsService tagsService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        tagsService = (TagsService) context.getBean("tagsService");
			//local server
			/**
			tagsService = (TagsService)  Naming.lookup("//localhost:9041/TagsRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 tagsService = (TagsService) context.getBean("tagsService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Tags tags  = new Tags();	   
	   					 
			   					                tags.setName("龙湖热购");
            
			   					                tags.setStatus(1);
            
			   					                tags.setCreateBy(1L);
            
			   					                tags.setUpdateBy(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.tagsService.insert(tags);

      tags = this.tagsService.getObjectById(id);

	  Tags tags2=this.tagsService.getObjectById(id);
	    Assert.assertNotNull(tags2);
	  
		// 2. 更改 
				 		 				 				   tags.setName("每周特价");
		    		 				 				   tags.setStatus(1);
		    		 				 				   tags.setCreateBy(13L);
		    		 				 				   tags.setUpdateBy(13L);
		    		 				 		 				 		 				boolean success=this.tagsService.update(tags);		
		Assert.assertEquals(true, success);
		 Tags tags3=this.tagsService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.tagsService.delete(id);	
		Assert.assertEquals(true, success);
		Tags tags4=this.tagsService.getObjectById(id);
		Assert.assertNull(tags4);
		
		//4.batchInsert
		 List<Tags> list=new ArrayList<Tags>();
	  	  Tags tags5  = new Tags();	   
	   					 
			   					                tags5.setName("龙湖热购");
            
			   					                tags5.setStatus(1);
            
			   					                tags5.setCreateBy(1L);
            
			   					                tags5.setUpdateBy(1L);
            
			   					 
			   					 
			   	    list.add(tags5);	   
	  	  Tags tags6  = new Tags();	   
	   					 
			   					                tags6.setName("每周特价");
            
			   					                tags6.setStatus(1);
            
			   					                tags6.setCreateBy(13L);
            
			   					                tags6.setUpdateBy(13L);
            
			   					 
			   					 
			   	   list.add(tags6);
	   List<Tags> insertResults= this.tagsService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Tags o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Tags> getResults= this.tagsService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Tags o :insertResults){
			this.tagsService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

