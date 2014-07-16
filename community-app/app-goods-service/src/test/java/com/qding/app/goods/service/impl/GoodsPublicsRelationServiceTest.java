package com.qding.app.goods.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;

import java.rmi.Naming;

import com.qding.app.goods.model.Goods;
import com.qding.app.goods.model.GoodsPublicsRelation;
import com.qding.app.goods.service.GoodsPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class GoodsPublicsRelationServiceTest {

	private static final Log log = LogFactory.getLog(GoodsPublicsRelationServiceTest.class);
	
	private GoodsPublicsRelationService goodsPublicsRelationService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
	        goodsPublicsRelationService = (GoodsPublicsRelationService) context.getBean("goodsPublicsRelationService");
			//local server
			/**
			goodsPublicsRelationService = (GoodsPublicsRelationService)  Naming.lookup("//localhost:9041/GoodsPublicsRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 goodsPublicsRelationService = (GoodsPublicsRelationService) context.getBean("goodsPublicsRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  GoodsPublicsRelation goodsPublicsRelation  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation.setGoodsID(1L);
            
			   					                goodsPublicsRelation.setCategoryID(1L);
            
			   					                goodsPublicsRelation.setPublicsID(145L);
            
			   					                goodsPublicsRelation.setStatus(0);
			   					                
			   					                
			   					                
            
			   					 
			   					                goodsPublicsRelation.setUpdateBy(1L);
            
			   					 
			   					                goodsPublicsRelation.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.goodsPublicsRelationService.insert(goodsPublicsRelation);

      goodsPublicsRelation = this.goodsPublicsRelationService.getObjectById(id);

	  GoodsPublicsRelation goodsPublicsRelation2=this.goodsPublicsRelationService.getObjectById(id);
	    Assert.assertNotNull(goodsPublicsRelation2);
	  
		// 2. 更改 
				 		 				 				   goodsPublicsRelation.setGoodsID(2L);
		    		 				 				   goodsPublicsRelation.setCategoryID(2L);
		    		 				 				   goodsPublicsRelation.setPublicsID(148L);
		    		 				 				   goodsPublicsRelation.setStatus(0);
		    		 				 		 				 				   goodsPublicsRelation.setUpdateBy(2L);
		    		 				 		 				 				   goodsPublicsRelation.setCreateBy(2L);
		    		 				boolean success=this.goodsPublicsRelationService.update(goodsPublicsRelation);		
		Assert.assertEquals(true, success);
		 GoodsPublicsRelation goodsPublicsRelation3=this.goodsPublicsRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.goodsPublicsRelationService.delete(id);	
		Assert.assertEquals(true, success);
		GoodsPublicsRelation goodsPublicsRelation4=this.goodsPublicsRelationService.getObjectById(id);
		Assert.assertNull(goodsPublicsRelation4);
		
		//4.batchInsert
		 List<GoodsPublicsRelation> list=new ArrayList<GoodsPublicsRelation>();
	  	  GoodsPublicsRelation goodsPublicsRelation5  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation5.setGoodsID(1L);
            
			   					                goodsPublicsRelation5.setCategoryID(1L);
            
			   					                goodsPublicsRelation5.setPublicsID(145L);
            
			   					                goodsPublicsRelation5.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation5.setUpdateBy(1L);
            
			   					 
			   					                goodsPublicsRelation5.setCreateBy(1L);
            
			   	    list.add(goodsPublicsRelation5);	   
	  	  GoodsPublicsRelation goodsPublicsRelation6  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation6.setGoodsID(2L);
            
			   					                goodsPublicsRelation6.setCategoryID(2L);
            
			   					                goodsPublicsRelation6.setPublicsID(148L);
            
			   					                goodsPublicsRelation6.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation6.setUpdateBy(2L);
            
			   					 
			   					                goodsPublicsRelation6.setCreateBy(2L);
            
			   	   list.add(goodsPublicsRelation6);
	   List<GoodsPublicsRelation> insertResults= this.goodsPublicsRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(GoodsPublicsRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<GoodsPublicsRelation> getResults= this.goodsPublicsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(GoodsPublicsRelation o :insertResults){
			this.goodsPublicsRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getGoodsPublicsRelationIdsByGoodsID()throws ServiceException, ServiceDaoException{
	 List<GoodsPublicsRelation> list=new ArrayList<GoodsPublicsRelation>();
	  	  GoodsPublicsRelation goodsPublicsRelation1  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation1.setGoodsID(1L);
            
			   					                goodsPublicsRelation1.setCategoryID(1L);
            
			   					                goodsPublicsRelation1.setPublicsID(145L);
            
			   					                goodsPublicsRelation1.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                goodsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(goodsPublicsRelation1);	
	  	  GoodsPublicsRelation goodsPublicsRelation2  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation2.setGoodsID(2L);
            
			   					                goodsPublicsRelation2.setCategoryID(2L);
            
			   					                goodsPublicsRelation2.setPublicsID(148L);
            
			   					                goodsPublicsRelation2.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                goodsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(goodsPublicsRelation2);	  
	  List<GoodsPublicsRelation> insertResults= this.goodsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= goodsPublicsRelationService.getGoodsPublicsRelationIdsByGoodsID(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(GoodsPublicsRelation o :insertResults){
			this.goodsPublicsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getGoodsIDsByPublicsIDAndCategoryIDAndStatus()throws ServiceException, ServiceDaoException{
	 List<GoodsPublicsRelation> list=new ArrayList<GoodsPublicsRelation>();
	  	  GoodsPublicsRelation goodsPublicsRelation1  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation1.setGoodsID(1L);
            
			   					                goodsPublicsRelation1.setCategoryID(1L);
            
			   					                goodsPublicsRelation1.setPublicsID(145L);
            
			   					                goodsPublicsRelation1.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation1.setUpdateBy(1L);
            
			   					 
			   					                goodsPublicsRelation1.setCreateBy(1L);
            
			   	  list.add(goodsPublicsRelation1);	
	  	  GoodsPublicsRelation goodsPublicsRelation2  = new GoodsPublicsRelation();	   
	   					 
			   					                goodsPublicsRelation2.setGoodsID(2L);
            
			   					                goodsPublicsRelation2.setCategoryID(2L);
            
			   					                goodsPublicsRelation2.setPublicsID(148L);
            
			   					                goodsPublicsRelation2.setStatus(0);
            
			   					 
			   					                goodsPublicsRelation2.setUpdateBy(2L);
            
			   					 
			   					                goodsPublicsRelation2.setCreateBy(2L);
            
			   	  list.add(goodsPublicsRelation2);	  
	  List<GoodsPublicsRelation> insertResults= this.goodsPublicsRelationService.insertList(list);
		
	
	   
		
	
		List<Long> lists = goodsPublicsRelationService.getGoodsIDsByPublicsIDAndCategoryIDAndStatus(145L, 1L, 0,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(GoodsPublicsRelation o :insertResults){
			this.goodsPublicsRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
		
		
		//@Test
		public void mockData() throws ServiceException, ServiceDaoException{
			
			List<String> contents=Arrays.asList(new String[]{"花生","Iphone","时光碟","新电影","","电器","餐饮"} );
			for(String content:contents){
				 GoodsPublicsRelation goodsPublicsRelation  = new GoodsPublicsRelation();	   
					 
	                goodsPublicsRelation.setGoodsID(1L);

	                goodsPublicsRelation.setCategoryID(1L);

	                goodsPublicsRelation.setPublicsID(145L);

	                goodsPublicsRelation.setStatus(0);
	                
	                
	                

	 
	                goodsPublicsRelation.setUpdateBy(1L);

	 
	                goodsPublicsRelation.setCreateBy(1L);



Long id= this.goodsPublicsRelationService.insert(goodsPublicsRelation);
				log.info(id+" insert over ");
			}
			}
}

