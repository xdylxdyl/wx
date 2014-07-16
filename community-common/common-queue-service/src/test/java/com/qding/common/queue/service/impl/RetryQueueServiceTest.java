package com.qding.common.queue.service.impl;

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

import com.qding.common.queue.model.RetryQueue;
import com.qding.common.queue.service.RetryQueueService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class RetryQueueServiceTest {

	private static final Log log = LogFactory.getLog(RetryQueueServiceTest.class);
	
	private RetryQueueService retryQueueService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/common-queue-service/applicationContext-server.xml");
	        retryQueueService = (RetryQueueService) context.getBean("retryQueueService");
			//local server
			/**
			retryQueueService = (RetryQueueService)  Naming.lookup("//localhost:9081/RetryQueueRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 retryQueueService = (RetryQueueService) context.getBean("retryQueueService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  RetryQueue retryQueue  = new RetryQueue();	   
	   					 
			   					                retryQueue.setType("sms");
            
			   					                retryQueue.setContent("{name:\"张三\",id:1}");
            
			   					                retryQueue.setRetryCount(0);
            
			   					                retryQueue.setTargetID("xdylxdyl@163.com");
            
			   					                retryQueue.setQueueID(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.retryQueueService.insert(retryQueue);

      retryQueue = this.retryQueueService.getObjectById(id);

	  RetryQueue retryQueue2=this.retryQueueService.getObjectById(id);
	    Assert.assertNotNull(retryQueue2);
	  
		// 2. 更改 
				 		 				 				   retryQueue.setType("weixin");
		    		 				 				   retryQueue.setContent("{name:\"李四\",id:2}");
		    		 				 				   retryQueue.setRetryCount(0);
		    		 				 				   retryQueue.setTargetID("1");
		    		 				 				   retryQueue.setQueueID(2L);
		    		 				 		 				 		 				boolean success=this.retryQueueService.update(retryQueue);		
		Assert.assertEquals(true, success);
		 RetryQueue retryQueue3=this.retryQueueService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.retryQueueService.delete(id);	
		Assert.assertEquals(true, success);
		RetryQueue retryQueue4=this.retryQueueService.getObjectById(id);
		Assert.assertNull(retryQueue4);
		
		//4.batchInsert
		 List<RetryQueue> list=new ArrayList<RetryQueue>();
	  	  RetryQueue retryQueue5  = new RetryQueue();	   
	   					 
			   					                retryQueue5.setType("sms");
            
			   					                retryQueue5.setContent("{name:\"张三\",id:1}");
            
			   					                retryQueue5.setRetryCount(0);
            
			   					                retryQueue5.setTargetID("xdylxdyl@163.com");
            
			   					                retryQueue5.setQueueID(1L);
            
			   					 
			   					 
			   	    list.add(retryQueue5);	   
	  	  RetryQueue retryQueue6  = new RetryQueue();	   
	   					 
			   					                retryQueue6.setType("weixin");
            
			   					                retryQueue6.setContent("{name:\"李四\",id:2}");
            
			   					                retryQueue6.setRetryCount(0);
            
			   					                retryQueue6.setTargetID("1");
            
			   					                retryQueue6.setQueueID(2L);
            
			   					 
			   					 
			   	   list.add(retryQueue6);
	   List<RetryQueue> insertResults= this.retryQueueService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(RetryQueue o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<RetryQueue> getResults= this.retryQueueService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(RetryQueue o :insertResults){
			this.retryQueueService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getRetryQueueIdsByType()throws ServiceException, ServiceDaoException{
	 List<RetryQueue> list=new ArrayList<RetryQueue>();
	  	  RetryQueue retryQueue1  = new RetryQueue();	   
	   					 
			   					                retryQueue1.setType("sms");
            
			   					                retryQueue1.setContent("{name:\"张三\",id:1}");
            
			   					                retryQueue1.setRetryCount(0);
            
			   					                retryQueue1.setTargetID("xdylxdyl@163.com");
            
			   					                retryQueue1.setQueueID(1L);
            
			   					 
			   					 
			   	  list.add(retryQueue1);	
	  	  RetryQueue retryQueue2  = new RetryQueue();	   
	   					 
			   					                retryQueue2.setType("weixin");
            
			   					                retryQueue2.setContent("{name:\"李四\",id:2}");
            
			   					                retryQueue2.setRetryCount(0);
            
			   					                retryQueue2.setTargetID("1");
            
			   					                retryQueue2.setQueueID(2L);
            
			   					 
			   					 
			   	  list.add(retryQueue2);	  
	  List<RetryQueue> insertResults= this.retryQueueService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= retryQueueService.getRetryQueueIdsByType("sms",0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(RetryQueue o :insertResults){
			this.retryQueueService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

