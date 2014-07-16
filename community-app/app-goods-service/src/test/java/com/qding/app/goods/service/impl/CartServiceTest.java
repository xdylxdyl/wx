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

import com.qding.app.goods.model.Cart;
import com.qding.app.goods.service.CartService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CartServiceTest {

	private static final Log log = LogFactory.getLog(CartServiceTest.class);
	
	private CartService cartService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        cartService = (CartService) context.getBean("cartService");
			//local server
			/**
			cartService = (CartService)  Naming.lookup("//localhost:9041/CartRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 cartService = (CartService) context.getBean("cartService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Cart cart  = new Cart();	   
	   					 
			   					                cart.setUserID(145L);
            
			   					                cart.setPublicsID(145L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.cartService.insert(cart);

      cart = this.cartService.getObjectById(id);

	  Cart cart2=this.cartService.getObjectById(id);
	    Assert.assertNotNull(cart2);
	  
		// 2. 更改 
				 		 				 				   cart.setUserID(148L);
		    		 				 				   cart.setPublicsID(148L);
		    		 				 		 				 		 				boolean success=this.cartService.update(cart);		
		Assert.assertEquals(true, success);
		 Cart cart3=this.cartService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.cartService.delete(id);	
		Assert.assertEquals(true, success);
		Cart cart4=this.cartService.getObjectById(id);
		Assert.assertNull(cart4);
		
		//4.batchInsert
		 List<Cart> list=new ArrayList<Cart>();
	  	  Cart cart5  = new Cart();	   
	   					 
			   					                cart5.setUserID(145L);
            
			   					                cart5.setPublicsID(145L);
            
			   					 
			   					 
			   	    list.add(cart5);	   
	  	  Cart cart6  = new Cart();	   
	   					 
			   					                cart6.setUserID(148L);
            
			   					                cart6.setPublicsID(148L);
            
			   					 
			   					 
			   	   list.add(cart6);
	   List<Cart> insertResults= this.cartService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Cart o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Cart> getResults= this.cartService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Cart o :insertResults){
			this.cartService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getCartIdByUserIDAndPublicsID()throws ServiceException, ServiceDaoException{
	 List<Cart> list=new ArrayList<Cart>();
	  	  Cart cart1  = new Cart();	   
	   					 
			   					                cart1.setUserID(145L);
            
			   					                cart1.setPublicsID(145L);
            
			   					 
			   					 
			   	  list.add(cart1);	
	  	  Cart cart2  = new Cart();	   
	   					 
			   					                cart2.setUserID(148L);
            
			   					                cart2.setPublicsID(148L);
            
			   					 
			   					 
			   	  list.add(cart2);	  
	  List<Cart> insertResults= this.cartService.insertList(list);
		
	
	   
		
	
		Long  lists= cartService.getCartIdByUserIDAndPublicsID(145L,145L);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Cart o :insertResults){
			this.cartService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

