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

import com.qding.app.goods.model.AddressUserRelation;
import com.qding.app.goods.service.AddressUserRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AddressUserRelationServiceTest {

	private static final Log log = LogFactory.getLog(AddressUserRelationServiceTest.class);
	
	private AddressUserRelationService addressUserRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/app-goods-service/applicationContext-server.xml");
	        addressUserRelationService = (AddressUserRelationService) context.getBean("addressUserRelationService");
			//local server
			/**
			addressUserRelationService = (AddressUserRelationService)  Naming.lookup("//localhost:9041/AddressUserRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 addressUserRelationService = (AddressUserRelationService) context.getBean("addressUserRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  AddressUserRelation addressUserRelation  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation.setAddressID(1L);
            
			   					                addressUserRelation.setUserID(145L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.addressUserRelationService.insert(addressUserRelation);

      addressUserRelation = this.addressUserRelationService.getObjectById(id);

	  AddressUserRelation addressUserRelation2=this.addressUserRelationService.getObjectById(id);
	    Assert.assertNotNull(addressUserRelation2);
	  
		// 2. 更改 
				 		 				 				   addressUserRelation.setAddressID(2L);
		    		 				 				   addressUserRelation.setUserID(148L);
		    		 				 		 				 		 				boolean success=this.addressUserRelationService.update(addressUserRelation);		
		Assert.assertEquals(true, success);
		 AddressUserRelation addressUserRelation3=this.addressUserRelationService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.addressUserRelationService.delete(id);	
		Assert.assertEquals(true, success);
		AddressUserRelation addressUserRelation4=this.addressUserRelationService.getObjectById(id);
		Assert.assertNull(addressUserRelation4);
		
		//4.batchInsert
		 List<AddressUserRelation> list=new ArrayList<AddressUserRelation>();
	  	  AddressUserRelation addressUserRelation5  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation5.setAddressID(1L);
            
			   					                addressUserRelation5.setUserID(145L);
            
			   					 
			   					 
			   	    list.add(addressUserRelation5);	   
	  	  AddressUserRelation addressUserRelation6  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation6.setAddressID(2L);
            
			   					                addressUserRelation6.setUserID(148L);
            
			   					 
			   					 
			   	   list.add(addressUserRelation6);
	   List<AddressUserRelation> insertResults= this.addressUserRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(AddressUserRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<AddressUserRelation> getResults= this.addressUserRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(AddressUserRelation o :insertResults){
			this.addressUserRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getAddressUserRelationIdsByUserID()throws ServiceException, ServiceDaoException{
	 List<AddressUserRelation> list=new ArrayList<AddressUserRelation>();
	  	  AddressUserRelation addressUserRelation1  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation1.setAddressID(1L);
            
			   					                addressUserRelation1.setUserID(145L);
            
			   					 
			   					 
			   	  list.add(addressUserRelation1);	
	  	  AddressUserRelation addressUserRelation2  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation2.setAddressID(2L);
            
			   					                addressUserRelation2.setUserID(148L);
            
			   					 
			   					 
			   	  list.add(addressUserRelation2);	  
	  List<AddressUserRelation> insertResults= this.addressUserRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= addressUserRelationService.getAddressUserRelationIdsByUserID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(AddressUserRelation o :insertResults){
			this.addressUserRelationService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getAddressUserRelationIdByAddressID()throws ServiceException, ServiceDaoException{
	 List<AddressUserRelation> list=new ArrayList<AddressUserRelation>();
	  	  AddressUserRelation addressUserRelation1  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation1.setAddressID(1L);
            
			   					                addressUserRelation1.setUserID(145L);
            
			   					 
			   					 
			   	  list.add(addressUserRelation1);	
	  	  AddressUserRelation addressUserRelation2  = new AddressUserRelation();	   
	   					 
			   					                addressUserRelation2.setAddressID(2L);
            
			   					                addressUserRelation2.setUserID(148L);
            
			   					 
			   					 
			   	  list.add(addressUserRelation2);	  
	  List<AddressUserRelation> insertResults= this.addressUserRelationService.insertList(list);
		
	
	   
		
	
		Long  lists= addressUserRelationService.getAddressUserRelationIdByAddressID(1L);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(AddressUserRelation o :insertResults){
			this.addressUserRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

