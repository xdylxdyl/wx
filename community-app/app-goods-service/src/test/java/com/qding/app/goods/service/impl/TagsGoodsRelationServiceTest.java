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

import com.qding.app.goods.model.TagsGoodsRelation;
import com.qding.app.goods.service.TagsGoodsRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsGoodsRelationServiceTest {

	private static final Log log = LogFactory.getLog(TagsGoodsRelationServiceTest.class);
	
	private TagsGoodsRelationService tagsGoodsRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        tagsGoodsRelationService = (TagsGoodsRelationService) context.getBean("tagsGoodsRelationService");
			//local server
			/**
			tagsGoodsRelationService = (TagsGoodsRelationService)  Naming.lookup("//localhost:9041/TagsGoodsRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 tagsGoodsRelationService = (TagsGoodsRelationService) context.getBean("tagsGoodsRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  TagsGoodsRelation tagsGoodsRelation  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation.setTagsID(1L);
            
			   					                tagsGoodsRelation.setGoodsID(145L);
            
			   					                tagsGoodsRelation.setPublicsID(145L);
            
			   					                tagsGoodsRelation.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation.setUpdateBy(1L);
            
			   					 
			   					                tagsGoodsRelation.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.tagsGoodsRelationService.insert(tagsGoodsRelation);

      tagsGoodsRelation = this.tagsGoodsRelationService.getObjectById(id);

	  TagsGoodsRelation tagsGoodsRelation2=this.tagsGoodsRelationService.getObjectById(id);
	    Assert.assertNotNull(tagsGoodsRelation2);
	  
		// 2. 更改 
				 		 				 				   tagsGoodsRelation.setTagsID(2L);
		    		 				 				   tagsGoodsRelation.setGoodsID(148L);
		    		 				 				   tagsGoodsRelation.setPublicsID(148L);
		    		 				 				   tagsGoodsRelation.setStatus(0);
		    		 				 		 				 				   tagsGoodsRelation.setUpdateBy(2L);
		    		 				 		 				 				   tagsGoodsRelation.setCreateBy(2L);
		    		 				boolean success=this.tagsGoodsRelationService.update(tagsGoodsRelation);		
		Assert.assertEquals(true, success);
		 TagsGoodsRelation tagsGoodsRelation3=this.tagsGoodsRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.tagsGoodsRelationService.delete(id);	
		Assert.assertEquals(true, success);
		TagsGoodsRelation tagsGoodsRelation4=this.tagsGoodsRelationService.getObjectById(id);
		Assert.assertNull(tagsGoodsRelation4);
		
		//4.batchInsert
		 List<TagsGoodsRelation> list=new ArrayList<TagsGoodsRelation>();
	  	  TagsGoodsRelation tagsGoodsRelation5  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation5.setTagsID(1L);
            
			   					                tagsGoodsRelation5.setGoodsID(145L);
            
			   					                tagsGoodsRelation5.setPublicsID(145L);
            
			   					                tagsGoodsRelation5.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation5.setUpdateBy(1L);
            
			   					 
			   					                tagsGoodsRelation5.setCreateBy(1L);
            
			   	    list.add(tagsGoodsRelation5);	   
	  	  TagsGoodsRelation tagsGoodsRelation6  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation6.setTagsID(2L);
            
			   					                tagsGoodsRelation6.setGoodsID(148L);
            
			   					                tagsGoodsRelation6.setPublicsID(148L);
            
			   					                tagsGoodsRelation6.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation6.setUpdateBy(2L);
            
			   					 
			   					                tagsGoodsRelation6.setCreateBy(2L);
            
			   	   list.add(tagsGoodsRelation6);
	   List<TagsGoodsRelation> insertResults= this.tagsGoodsRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(TagsGoodsRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<TagsGoodsRelation> getResults= this.tagsGoodsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(TagsGoodsRelation o :insertResults){
			this.tagsGoodsRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getTagsGoodsRelationIdsByGoodsID()throws ServiceException, ServiceDaoException{
	 List<TagsGoodsRelation> list=new ArrayList<TagsGoodsRelation>();
	  	  TagsGoodsRelation tagsGoodsRelation1  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation1.setTagsID(1L);
            
			   					                tagsGoodsRelation1.setGoodsID(145L);
            
			   					                tagsGoodsRelation1.setPublicsID(145L);
            
			   					                tagsGoodsRelation1.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                tagsGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(tagsGoodsRelation1);	
	  	  TagsGoodsRelation tagsGoodsRelation2  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation2.setTagsID(2L);
            
			   					                tagsGoodsRelation2.setGoodsID(148L);
            
			   					                tagsGoodsRelation2.setPublicsID(148L);
            
			   					                tagsGoodsRelation2.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                tagsGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(tagsGoodsRelation2);	  
	  List<TagsGoodsRelation> insertResults= this.tagsGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= tagsGoodsRelationService.getTagsGoodsRelationIdsByGoodsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(TagsGoodsRelation o :insertResults){
			this.tagsGoodsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus()throws ServiceException, ServiceDaoException{
	 List<TagsGoodsRelation> list=new ArrayList<TagsGoodsRelation>();
	  	  TagsGoodsRelation tagsGoodsRelation1  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation1.setTagsID(1L);
            
			   					                tagsGoodsRelation1.setGoodsID(145L);
            
			   					                tagsGoodsRelation1.setPublicsID(145L);
            
			   					                tagsGoodsRelation1.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                tagsGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(tagsGoodsRelation1);	
	  	  TagsGoodsRelation tagsGoodsRelation2  = new TagsGoodsRelation();	   
	   					 
			   					                tagsGoodsRelation2.setTagsID(2L);
            
			   					                tagsGoodsRelation2.setGoodsID(148L);
            
			   					                tagsGoodsRelation2.setPublicsID(148L);
            
			   					                tagsGoodsRelation2.setStatus(0);
            
			   					 
			   					                tagsGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                tagsGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(tagsGoodsRelation2);	  
	  List<TagsGoodsRelation> insertResults= this.tagsGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= tagsGoodsRelationService.getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(1L,145L,0,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(TagsGoodsRelation o :insertResults){
			this.tagsGoodsRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

