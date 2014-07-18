package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.framework.publics.model.MultiMessageRelation;
import com.qding.framework.publics.service.MultiMessageRelationService;
@Ignore
public class MultiMessageRelationServiceTest {

	private static final Log log = LogFactory.getLog(MultiMessageRelationServiceTest.class);
	
	private MultiMessageRelationService multiMessageRelationService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/framework-publics-service/applicationContext-server.xml");
	        multiMessageRelationService = (MultiMessageRelationService) context.getBean("multiMessageRelationService");
			//local server
			/**
			multiMessageRelationService = (MultiMessageRelationService)  Naming.lookup("//localhost:8801/MultiMessageRelationRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 multiMessageRelationService = (MultiMessageRelationService) context.getBean("multiMessageRelationService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  MultiMessageRelation multiMessageRelation  = new MultiMessageRelation();	   
	   					 
			   					                multiMessageRelation.setGroupID(2L);
            
			   					                multiMessageRelation.setMid(2L);
            
			   					                multiMessageRelation.setLevel(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.multiMessageRelationService.insert(multiMessageRelation);

      multiMessageRelation = this.multiMessageRelationService.getObjectById(id);

	  MultiMessageRelation multiMessageRelation2=this.multiMessageRelationService.getObjectById(id);
	    Assert.assertNotNull(multiMessageRelation2);
	  
		// 2. 更改 
				 		 				 				   multiMessageRelation.setGroupID(3L);
		    		 				 				   multiMessageRelation.setMid(2L);
		    		 				 				   multiMessageRelation.setLevel(2L);
		    		 				 		 				 		 				boolean success=this.multiMessageRelationService.update(multiMessageRelation);		
		Assert.assertEquals(true, success);
		 MultiMessageRelation multiMessageRelation3=this.multiMessageRelationService.getObjectById(id);
				 		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.multiMessageRelationService.delete(id);	
		Assert.assertEquals(true, success);
		MultiMessageRelation multiMessageRelation4=this.multiMessageRelationService.getObjectById(id);
		Assert.assertNull(multiMessageRelation4);
		
		//4.batchInsert
		 List<MultiMessageRelation> list=new ArrayList<MultiMessageRelation>();
	  	  MultiMessageRelation multiMessageRelation5  = new MultiMessageRelation();	   
	   					 
			   					                multiMessageRelation5.setGroupID(2L);
            
			   					                multiMessageRelation5.setMid(2L);
            
			   					                multiMessageRelation5.setLevel(1L);
            
			   					 
			   					 
			   	    list.add(multiMessageRelation5);	   
	  	  MultiMessageRelation multiMessageRelation6  = new MultiMessageRelation();	   
	   					 
			   					                multiMessageRelation6.setGroupID(3L);
            
			   					                multiMessageRelation6.setMid(2L);
            
			   					                multiMessageRelation6.setLevel(2L);
            
			   					 
			   					 
			   	   list.add(multiMessageRelation6);
	   List<MultiMessageRelation> insertResults= this.multiMessageRelationService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(MultiMessageRelation o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<MultiMessageRelation> getResults= this.multiMessageRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(MultiMessageRelation o :insertResults){
			this.multiMessageRelationService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getMultiMessageRelationIdsByGroupID()throws ServiceException, ServiceDaoException{
	 List<MultiMessageRelation> list=new ArrayList<MultiMessageRelation>();
	  	  MultiMessageRelation multiMessageRelation1  = new MultiMessageRelation();	   
	   					 
			   					                multiMessageRelation1.setGroupID(2L);
            
			   					                multiMessageRelation1.setMid(2L);
            
			   					                multiMessageRelation1.setLevel(1L);
            
			   					 
			   					 
			   	  list.add(multiMessageRelation1);	
	  	  MultiMessageRelation multiMessageRelation2  = new MultiMessageRelation();	   
	   					 
			   					                multiMessageRelation2.setGroupID(3L);
            
			   					                multiMessageRelation2.setMid(2L);
            
			   					                multiMessageRelation2.setLevel(2L);
            
			   					 
			   					 
			   	  list.add(multiMessageRelation2);	  
	  List<MultiMessageRelation> insertResults= this.multiMessageRelationService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= multiMessageRelationService.getMultiMessageRelationIdsByGroupID(2L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(MultiMessageRelation o :insertResults){
			this.multiMessageRelationService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

