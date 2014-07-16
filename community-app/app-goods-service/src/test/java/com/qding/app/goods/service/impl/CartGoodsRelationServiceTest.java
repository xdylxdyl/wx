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

import com.qding.app.goods.model.CartGoodsRelation;
import com.qding.app.goods.service.CartGoodsRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CartGoodsRelationServiceTest {

	private static final Log log = LogFactory.getLog(CartGoodsRelationServiceTest.class);
	
	private CartGoodsRelationService cartGoodsRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        cartGoodsRelationService = (CartGoodsRelationService) context.getBean("cartGoodsRelationService");
			//local server
			/**
			cartGoodsRelationService = (CartGoodsRelationService)  Naming.lookup("//localhost:9041/CartGoodsRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 cartGoodsRelationService = (CartGoodsRelationService) context.getBean("cartGoodsRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  CartGoodsRelation cartGoodsRelation  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation.setCartID(1L);
            
			   					                cartGoodsRelation.setGoodsID(145L);
            
			   					                cartGoodsRelation.setCount(1);
            
			   					 
			   					                cartGoodsRelation.setUpdateBy(1L);
            
			   					 
			   					                cartGoodsRelation.setCreateBy(1L);
            
			   	 
	 
	  Long id= this.cartGoodsRelationService.insert(cartGoodsRelation);

      cartGoodsRelation = this.cartGoodsRelationService.getObjectById(id);

	  CartGoodsRelation cartGoodsRelation2=this.cartGoodsRelationService.getObjectById(id);
	    Assert.assertNotNull(cartGoodsRelation2);
	  
		// 2. 更改 
				 		 				 				   cartGoodsRelation.setCartID(2L);
		    		 				 				   cartGoodsRelation.setGoodsID(148L);
		    		 				 				   cartGoodsRelation.setCount(1);
		    		 				 		 				 				   cartGoodsRelation.setUpdateBy(2L);
		    		 				 		 				 				   cartGoodsRelation.setCreateBy(2L);
		    		 				boolean success=this.cartGoodsRelationService.update(cartGoodsRelation);		
		Assert.assertEquals(true, success);
		 CartGoodsRelation cartGoodsRelation3=this.cartGoodsRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.cartGoodsRelationService.delete(id);	
		Assert.assertEquals(true, success);
		CartGoodsRelation cartGoodsRelation4=this.cartGoodsRelationService.getObjectById(id);
		Assert.assertNull(cartGoodsRelation4);
		
		//4.batchInsert
		 List<CartGoodsRelation> list=new ArrayList<CartGoodsRelation>();
	  	  CartGoodsRelation cartGoodsRelation5  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation5.setCartID(1L);
            
			   					                cartGoodsRelation5.setGoodsID(145L);
            
			   					                cartGoodsRelation5.setCount(1);
            
			   					 
			   					                cartGoodsRelation5.setUpdateBy(1L);
            
			   					 
			   					                cartGoodsRelation5.setCreateBy(1L);
            
			   	    list.add(cartGoodsRelation5);	   
	  	  CartGoodsRelation cartGoodsRelation6  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation6.setCartID(2L);
            
			   					                cartGoodsRelation6.setGoodsID(148L);
            
			   					                cartGoodsRelation6.setCount(1);
            
			   					 
			   					                cartGoodsRelation6.setUpdateBy(2L);
            
			   					 
			   					                cartGoodsRelation6.setCreateBy(2L);
            
			   	   list.add(cartGoodsRelation6);
	   List<CartGoodsRelation> insertResults= this.cartGoodsRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(CartGoodsRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<CartGoodsRelation> getResults= this.cartGoodsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(CartGoodsRelation o :insertResults){
			this.cartGoodsRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getCartGoodsRelationIdsByGoodsID()throws ServiceException, ServiceDaoException{
	 List<CartGoodsRelation> list=new ArrayList<CartGoodsRelation>();
	  	  CartGoodsRelation cartGoodsRelation1  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation1.setCartID(1L);
            
			   					                cartGoodsRelation1.setGoodsID(145L);
            
			   					                cartGoodsRelation1.setCount(1);
            
			   					 
			   					                cartGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                cartGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(cartGoodsRelation1);	
	  	  CartGoodsRelation cartGoodsRelation2  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation2.setCartID(2L);
            
			   					                cartGoodsRelation2.setGoodsID(148L);
            
			   					                cartGoodsRelation2.setCount(1);
            
			   					 
			   					                cartGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                cartGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(cartGoodsRelation2);	  
	  List<CartGoodsRelation> insertResults= this.cartGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= cartGoodsRelationService.getCartGoodsRelationIdsByGoodsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(CartGoodsRelation o :insertResults){
			this.cartGoodsRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getCartGoodsRelationIdsByCartID()throws ServiceException, ServiceDaoException{
	 List<CartGoodsRelation> list=new ArrayList<CartGoodsRelation>();
	  	  CartGoodsRelation cartGoodsRelation1  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation1.setCartID(1L);
            
			   					                cartGoodsRelation1.setGoodsID(145L);
            
			   					                cartGoodsRelation1.setCount(1);
            
			   					 
			   					                cartGoodsRelation1.setUpdateBy(1L);
            
			   					 
			   					                cartGoodsRelation1.setCreateBy(1L);
            
			   	  list.add(cartGoodsRelation1);	
	  	  CartGoodsRelation cartGoodsRelation2  = new CartGoodsRelation();	   
	   					 
			   					                cartGoodsRelation2.setCartID(2L);
            
			   					                cartGoodsRelation2.setGoodsID(148L);
            
			   					                cartGoodsRelation2.setCount(1);
            
			   					 
			   					                cartGoodsRelation2.setUpdateBy(2L);
            
			   					 
			   					                cartGoodsRelation2.setCreateBy(2L);
            
			   	  list.add(cartGoodsRelation2);	  
	  List<CartGoodsRelation> insertResults= this.cartGoodsRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= cartGoodsRelationService.getCartGoodsRelationIdsByCartID(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(CartGoodsRelation o :insertResults){
			this.cartGoodsRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

