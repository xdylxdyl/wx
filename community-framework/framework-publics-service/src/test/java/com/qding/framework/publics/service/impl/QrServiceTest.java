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
import com.qding.framework.publics.model.Qr;
import com.qding.framework.publics.service.QrService;
@Ignore
public class QrServiceTest {

	private static final Log log = LogFactory.getLog(QrServiceTest.class);
	
	private QrService qrService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/framework-publics-service/applicationContext-server.xml");
	        qrService = (QrService) context.getBean("qrService");
			//local server
			/**
			qrService = (QrService)  Naming.lookup("//localhost:8801/QrRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 qrService = (QrService) context.getBean("qrService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Qr qr  = new Qr();	   
	   					 
			   					                qr.setDescription("1");
            
			   					                qr.setTicket("1");
            
			   					                qr.setPublicsID(145L);
            
			   					                qr.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
            
			   					 
			   					 
			   	 
	 
	  Long id= this.qrService.insert(qr);

      qr = this.qrService.getObjectById(id);

	  Qr qr2=this.qrService.getObjectById(id);
	    Assert.assertNotNull(qr2);
	  
		// 2. 更改 
				 		 				 				   qr.setDescription("2");
		    		 				 				   qr.setTicket("2");
		    		 				 				   qr.setPublicsID(146L);
		    		 				 				   qr.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
		    		 				 		 				 		 				boolean success=this.qrService.update(qr);		
		Assert.assertEquals(true, success);
		 Qr qr3=this.qrService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.qrService.delete(id);	
		Assert.assertEquals(true, success);
		Qr qr4=this.qrService.getObjectById(id);
		Assert.assertNull(qr4);
		
		//4.batchInsert
		 List<Qr> list=new ArrayList<Qr>();
	  	  Qr qr5  = new Qr();	   
	   					 
			   					                qr5.setDescription("1");
            
			   					                qr5.setTicket("1");
            
			   					                qr5.setPublicsID(145L);
            
			   					                qr5.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
            
			   					 
			   					 
			   	    list.add(qr5);	   
	  	  Qr qr6  = new Qr();	   
	   					 
			   					                qr6.setDescription("2");
            
			   					                qr6.setTicket("2");
            
			   					                qr6.setPublicsID(146L);
            
			   					                qr6.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
            
			   					 
			   					 
			   	   list.add(qr6);
	   List<Qr> insertResults= this.qrService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Qr o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Qr> getResults= this.qrService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Qr o :insertResults){
			this.qrService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getQrIdsByPublicsID()throws ServiceException, ServiceDaoException{
	 List<Qr> list=new ArrayList<Qr>();
	  	  Qr qr1  = new Qr();	   
	   					 
			   					                qr1.setDescription("1");
            
			   					                qr1.setTicket("1");
            
			   					                qr1.setPublicsID(145L);
            
			   					                qr1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
            
			   					 
			   					 
			   	  list.add(qr1);	
	  	  Qr qr2  = new Qr();	   
	   					 
			   					                qr2.setDescription("2");
            
			   					                qr2.setTicket("2");
            
			   					                qr2.setPublicsID(146L);
            
			   					                qr2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
            
			   					 
			   					 
			   	  list.add(qr2);	  
	  List<Qr> insertResults= this.qrService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= qrService.getQrIdsByPublicsID(145L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Qr o :insertResults){
			this.qrService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

