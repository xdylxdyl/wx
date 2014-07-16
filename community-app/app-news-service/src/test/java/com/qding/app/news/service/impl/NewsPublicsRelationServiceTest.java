package com.qding.app.news.service.impl;

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

import com.qding.app.news.model.NewsPublicsRelation;
import com.qding.app.news.service.NewsPublicsRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class NewsPublicsRelationServiceTest {

	private static final Log log = LogFactory.getLog(NewsPublicsRelationServiceTest.class);
	
	private NewsPublicsRelationService newsPublicsRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-news-service/applicationContext-server.xml");
	        newsPublicsRelationService = (NewsPublicsRelationService) context.getBean("newsPublicsRelationService");
			//local server
			/**
			newsPublicsRelationService = (NewsPublicsRelationService)  Naming.lookup("//localhost:9031/NewsPublicsRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 newsPublicsRelationService = (NewsPublicsRelationService) context.getBean("newsPublicsRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  NewsPublicsRelation newsPublicsRelation  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation.setNewsID(1L);
            
			   					                newsPublicsRelation.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.newsPublicsRelationService.insert(newsPublicsRelation);

      newsPublicsRelation = this.newsPublicsRelationService.getObjectById(id);

	  NewsPublicsRelation newsPublicsRelation2=this.newsPublicsRelationService.getObjectById(id);
	    Assert.assertNotNull(newsPublicsRelation2);
	  
		// 2. 更改 
				 		 				 				   newsPublicsRelation.setNewsID(2L);
		    		 				 				   newsPublicsRelation.setPublicsID(148L);
		    		 				 					 				 		 				 				   newsPublicsRelation.setUpdateBy(2L);
		    		 				 		 				 				   newsPublicsRelation.setCreateBy(2L);
		    		 				boolean success=this.newsPublicsRelationService.update(newsPublicsRelation);		
		Assert.assertEquals(true, success);
		 NewsPublicsRelation newsPublicsRelation3=this.newsPublicsRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.newsPublicsRelationService.delete(id);	
		Assert.assertEquals(true, success);
		NewsPublicsRelation newsPublicsRelation4=this.newsPublicsRelationService.getObjectById(id);
		Assert.assertNull(newsPublicsRelation4);
		
		//4.batchInsert
		 List<NewsPublicsRelation> list=new ArrayList<NewsPublicsRelation>();
	  	  NewsPublicsRelation newsPublicsRelation5  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation5.setNewsID(1L);
            
			   					                newsPublicsRelation5.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation5.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation5.setCreateBy(1L);
            
			   	    list.add(newsPublicsRelation5);	   
	  	  NewsPublicsRelation newsPublicsRelation6  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation6.setNewsID(2L);
            
			   					                newsPublicsRelation6.setPublicsID(148L);
            
			   					
			   					 
			   					                newsPublicsRelation6.setUpdateBy(2L);
            
			   					 
			   					                newsPublicsRelation6.setCreateBy(2L);
            
			   	   list.add(newsPublicsRelation6);
	   List<NewsPublicsRelation> insertResults= this.newsPublicsRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(NewsPublicsRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<NewsPublicsRelation> getResults= this.newsPublicsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(NewsPublicsRelation o :insertResults){
			this.newsPublicsRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getPublicsIDsByNewsID()throws ServiceException, ServiceDaoException{
	 List<NewsPublicsRelation> list=new ArrayList<NewsPublicsRelation>();
	  	  NewsPublicsRelation newsPublicsRelation1  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation1.setNewsID(1L);
            
			   					                newsPublicsRelation1.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(newsPublicsRelation1);	
	  	  NewsPublicsRelation newsPublicsRelation2  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation2.setNewsID(2L);
            
			   					                newsPublicsRelation2.setPublicsID(148L);
            
			   					
			   					 
			   					                newsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                newsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(newsPublicsRelation2);	  
	  List<NewsPublicsRelation> insertResults= this.newsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= newsPublicsRelationService.getPublicsIDsByNewsID(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(NewsPublicsRelation o :insertResults){
			this.newsPublicsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getNewsPublicsRelationIdsByPublicsID()throws ServiceException, ServiceDaoException{
	 List<NewsPublicsRelation> list=new ArrayList<NewsPublicsRelation>();
	  	  NewsPublicsRelation newsPublicsRelation1  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation1.setNewsID(1L);
            
			   					                newsPublicsRelation1.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(newsPublicsRelation1);	
	  	  NewsPublicsRelation newsPublicsRelation2  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation2.setNewsID(2L);
            
			   					                newsPublicsRelation2.setPublicsID(148L);
            
			   					
			   					 
			   					                newsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                newsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(newsPublicsRelation2);	  
	  List<NewsPublicsRelation> insertResults= this.newsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= newsPublicsRelationService.getNewsPublicsRelationIdsByPublicsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(NewsPublicsRelation o :insertResults){
			this.newsPublicsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getNewsPublicsRelationIdsByNewsID()throws ServiceException, ServiceDaoException{
	 List<NewsPublicsRelation> list=new ArrayList<NewsPublicsRelation>();
	  	  NewsPublicsRelation newsPublicsRelation1  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation1.setNewsID(1L);
            
			   					                newsPublicsRelation1.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(newsPublicsRelation1);	
	  	  NewsPublicsRelation newsPublicsRelation2  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation2.setNewsID(2L);
            
			   					                newsPublicsRelation2.setPublicsID(148L);
            
			   					
			   					 
			   					                newsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                newsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(newsPublicsRelation2);	  
	  List<NewsPublicsRelation> insertResults= this.newsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= newsPublicsRelationService.getNewsPublicsRelationIdsByNewsID(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(NewsPublicsRelation o :insertResults){
			this.newsPublicsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getNewsIDsByPublicsID()throws ServiceException, ServiceDaoException{
	 List<NewsPublicsRelation> list=new ArrayList<NewsPublicsRelation>();
	  	  NewsPublicsRelation newsPublicsRelation1  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation1.setNewsID(1L);
            
			   					                newsPublicsRelation1.setPublicsID(145L);
            
			   					
			   					 
			   					                newsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                newsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(newsPublicsRelation1);	
	  	  NewsPublicsRelation newsPublicsRelation2  = new NewsPublicsRelation();	   
	   					 
			   					                newsPublicsRelation2.setNewsID(2L);
            
			   					                newsPublicsRelation2.setPublicsID(148L);
            
			   					
			   					 
			   					                newsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                newsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(newsPublicsRelation2);	  
	  List<NewsPublicsRelation> insertResults= this.newsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= newsPublicsRelationService.getNewsIDsByPublicsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(NewsPublicsRelation o :insertResults){
			this.newsPublicsRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

