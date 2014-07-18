package com.qding.framework.publics.service.impl;

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

import com.qding.framework.publics.model.ChatMessage;
import com.qding.framework.publics.service.ChatMessageService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ChatMessageServiceTest {

	private static final Log log = LogFactory.getLog(ChatMessageServiceTest.class);
	
	private ChatMessageService chatMessageService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/framework-publics-service/applicationContext-server.xml");
	        chatMessageService = (ChatMessageService) context.getBean("chatMessageService");
			//local server
			/**
			chatMessageService = (ChatMessageService)  Naming.lookup("//localhost:9001/ChatMessageRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 chatMessageService = (ChatMessageService) context.getBean("chatMessageService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  ChatMessage chatMessage  = new ChatMessage();	   
	   					 
			   					                chatMessage.setPublicsID(145L);
            
			   					                chatMessage.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");
            
			   					                chatMessage.setMessageId(1234567890123450L);
            
			   					                chatMessage.setContent("订单管理的状态从未支付变成了已成付");
            
			   					                chatMessage.setType(1);
            
			   					                chatMessage.setStar(1);
            
			   					                chatMessage.setSendAt(2L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.chatMessageService.insert(chatMessage);

      chatMessage = this.chatMessageService.getObjectById(id);

	  ChatMessage chatMessage2=this.chatMessageService.getObjectById(id);
	    Assert.assertNotNull(chatMessage2);
	  
		// 2. 更改 
				 		 				 				   chatMessage.setPublicsID(148L);
		    		 				 				   chatMessage.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
		    		 				 				   chatMessage.setMessageId(1234567890123450L);
		    		 				 				   chatMessage.setContent("订单管理的状态从未支付变成了已成付");
		    		 				 				   chatMessage.setType(1);
		    		 				 				   chatMessage.setStar(1);
		    		 				 				   chatMessage.setSendAt(2L);
		    		 				 		 				 		 				boolean success=this.chatMessageService.update(chatMessage);		
		Assert.assertEquals(true, success);
		 ChatMessage chatMessage3=this.chatMessageService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.chatMessageService.delete(id);	
		Assert.assertEquals(true, success);
		ChatMessage chatMessage4=this.chatMessageService.getObjectById(id);
		Assert.assertNull(chatMessage4);
		
		//4.batchInsert
		 List<ChatMessage> list=new ArrayList<ChatMessage>();
	  	  ChatMessage chatMessage5  = new ChatMessage();	   
	   					 
			   					                chatMessage5.setPublicsID(145L);
            
			   					                chatMessage5.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");
            
			   					                chatMessage5.setMessageId(1234567890123450L);
            
			   					                chatMessage5.setContent("订单管理的状态从未支付变成了已成付");
            
			   					                chatMessage5.setType(1);
            
			   					                chatMessage5.setStar(1);
            
			   					                chatMessage5.setSendAt(2L);
            
			   					 
			   					 
			   	    list.add(chatMessage5);	   
	  	  ChatMessage chatMessage6  = new ChatMessage();	   
	   					 
			   					                chatMessage6.setPublicsID(148L);
            
			   					                chatMessage6.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
            
			   					                chatMessage6.setMessageId(1234567890123450L);
            
			   					                chatMessage6.setContent("订单管理的状态从未支付变成了已成付");
            
			   					                chatMessage6.setType(1);
            
			   					                chatMessage6.setStar(1);
            
			   					                chatMessage6.setSendAt(2L);
            
			   					 
			   					 
			   	   list.add(chatMessage6);
	   List<ChatMessage> insertResults= this.chatMessageService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(ChatMessage o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<ChatMessage> getResults= this.chatMessageService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(ChatMessage o :insertResults){
			this.chatMessageService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getChatMessageIdsByOpenID()throws ServiceException, ServiceDaoException{
	 List<ChatMessage> list=new ArrayList<ChatMessage>();
	  	  ChatMessage chatMessage1  = new ChatMessage();	   
	   					 
			   					                chatMessage1.setPublicsID(145L);
            
			   					                chatMessage1.setOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw");
            
			   					                chatMessage1.setMessageId(1234567890123450L);
            
			   					                chatMessage1.setContent("订单管理的状态从未支付变成了已成付");
            
			   					                chatMessage1.setType(1);
            
			   					                chatMessage1.setStar(1);
            
			   					                chatMessage1.setSendAt(2L);
            
			   					 
			   					 
			   	  list.add(chatMessage1);	
	  	  ChatMessage chatMessage2  = new ChatMessage();	   
	   					 
			   					                chatMessage2.setPublicsID(148L);
            
			   					                chatMessage2.setOpenID("ovK7Ijv7PVnka8QXs4h1x1uvANOk");
            
			   					                chatMessage2.setMessageId(1234567890123450L);
            
			   					                chatMessage2.setContent("订单管理的状态从未支付变成了已成付");
            
			   					                chatMessage2.setType(1);
            
			   					                chatMessage2.setStar(1);
            
			   					                chatMessage2.setSendAt(2L);
            
			   					 
			   					 
			   	  list.add(chatMessage2);	  
	  List<ChatMessage> insertResults= this.chatMessageService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= chatMessageService.getChatMessageIdsByOpenID("ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw",0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(ChatMessage o :insertResults){
			this.chatMessageService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

