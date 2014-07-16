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

import com.qding.app.goods.model.GorderGoodsRelation;
import com.qding.app.goods.service.GorderGoodsRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GorderGoodsRelationServiceTest {

	private static final Log log = LogFactory.getLog(GorderGoodsRelationServiceTest.class);
	
	private GorderGoodsRelationService gorderGoodsRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        gorderGoodsRelationService = (GorderGoodsRelationService) context.getBean("gorderGoodsRelationService");
			//local server
			/**
			gorderGoodsRelationService = (GorderGoodsRelationService)  Naming.lookup("//localhost:9041/GorderGoodsRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 gorderGoodsRelationService = (GorderGoodsRelationService) context.getBean("gorderGoodsRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  GorderGoodsRelation gorderGoodsRelation  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation.setGorderID(1L);
            
			   					                gorderGoodsRelation.setGoodsID(145L);
            
			   					 
			   					                gorderGoodsRelation.setUpdateBy(1L);
            
			   					 
			   					                gorderGoodsRelation.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.gorderGoodsRelationService.insert(gorderGoodsRelation);

      gorderGoodsRelation = this.gorderGoodsRelationService.getObjectById(id);

	  GorderGoodsRelation gorderGoodsRelation2=this.gorderGoodsRelationService.getObjectById(id);
	    Assert.assertNotNull(gorderGoodsRelation2);
	  
		// 2. 更改 
				 		 				 				   gorderGoodsRelation.setGorderID(2L);
		    		 				 				   gorderGoodsRelation.setGoodsID(148L);
		    		 				 		 				 				   gorderGoodsRelation.setUpdateBy(2L);
		    		 				 		 				 				   gorderGoodsRelation.setCreateBy(2L);
		    		 				boolean success=this.gorderGoodsRelationService.update(gorderGoodsRelation);		
		Assert.assertEquals(true, success);
		 GorderGoodsRelation gorderGoodsRelation3=this.gorderGoodsRelationService.getObjectById(id);
				 		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.gorderGoodsRelationService.delete(id);	
		Assert.assertEquals(true, success);
		GorderGoodsRelation gorderGoodsRelation4=this.gorderGoodsRelationService.getObjectById(id);
		Assert.assertNull(gorderGoodsRelation4);
		
		//4.batchInsert
		 List<GorderGoodsRelation> list=new ArrayList<GorderGoodsRelation>();
	  	  GorderGoodsRelation gorderGoodsRelation5  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation5.setGorderID(1L);
            
			   					                gorderGoodsRelation5.setGoodsID(145L);
            
			   					 
			   					                gorderGoodsRelation5.setUpdateBy(1L);
            
			   					 
			   					                gorderGoodsRelation5.setCreateBy(1L);
            
			   	    list.add(gorderGoodsRelation5);	   
	  	  GorderGoodsRelation gorderGoodsRelation6  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation6.setGorderID(2L);
            
			   					                gorderGoodsRelation6.setGoodsID(148L);
            
			   					 
			   					                gorderGoodsRelation6.setUpdateBy(2L);
            
			   					 
			   					                gorderGoodsRelation6.setCreateBy(2L);
            
			   	   list.add(gorderGoodsRelation6);
	   List<GorderGoodsRelation> insertResults= this.gorderGoodsRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(GorderGoodsRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<GorderGoodsRelation> getResults= this.gorderGoodsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(GorderGoodsRelation o :insertResults){
			this.gorderGoodsRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getGorderGoodsRelationIdsByGoodsID()throws ServiceException, ServiceDaoException{
	 List<GorderGoodsRelation> list=new ArrayList<GorderGoodsRelation>();
	  	  GorderGoodsRelation gorderGoodsRelation1  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation1.setGorderID(1L);
            
			   					                gorderGoodsRelation1.setGoodsID(145L);
            
			   					 
			   					                gorderGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                gorderGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(gorderGoodsRelation1);	
	  	  GorderGoodsRelation gorderGoodsRelation2  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation2.setGorderID(2L);
            
			   					                gorderGoodsRelation2.setGoodsID(148L);
            
			   					 
			   					                gorderGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                gorderGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(gorderGoodsRelation2);	  
	  List<GorderGoodsRelation> insertResults= this.gorderGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= gorderGoodsRelationService.getGorderGoodsRelationIdsByGoodsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(GorderGoodsRelation o :insertResults){
			this.gorderGoodsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getGorderGoodsRelationIdsByGorderID()throws ServiceException, ServiceDaoException{
	 List<GorderGoodsRelation> list=new ArrayList<GorderGoodsRelation>();
	  	  GorderGoodsRelation gorderGoodsRelation1  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation1.setGorderID(1L);
            
			   					                gorderGoodsRelation1.setGoodsID(145L);
            
			   					 
			   					                gorderGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                gorderGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(gorderGoodsRelation1);	
	  	  GorderGoodsRelation gorderGoodsRelation2  = new GorderGoodsRelation();	   
	   					 
			   					                gorderGoodsRelation2.setGorderID(2L);
            
			   					                gorderGoodsRelation2.setGoodsID(148L);
            
			   					 
			   					                gorderGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                gorderGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(gorderGoodsRelation2);	  
	  List<GorderGoodsRelation> insertResults= this.gorderGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= gorderGoodsRelationService.getGorderGoodsRelationIdsByGorderID(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(GorderGoodsRelation o :insertResults){
			this.gorderGoodsRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

