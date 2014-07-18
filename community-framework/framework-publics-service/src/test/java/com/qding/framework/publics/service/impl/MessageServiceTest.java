package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.framework.publics.model.Message;
import com.qding.framework.publics.service.MessageService;

@Ignore
public class MessageServiceTest {

	private static final Log log = LogFactory.getLog(MessageServiceTest.class);

	private MessageService messageService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/framework-publics-service/applicationContext-server.xml");
		messageService = (MessageService) context.getBean("messageService");
		// local server
		/**
		 * messageService = (MessageService)
		 * Naming.lookup("//localhost:8801/MessageRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * messageService = (MessageService) context.getBean("messageService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Message message = new Message();

		message.setName("xxxx");

		message.setTitle("xxxxxxx");

		message.setDescription("xxxxxxx");

		message.setContent("xxxxx");

		message.setUrl("http://www.douban.com");

		message.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		message.setType("text");

		message.setPublicsID(145L);

		message.setStatus("online");

		Long id = this.messageService.insert(message);

		message = this.messageService.getObjectById(id);

		Message message2 = this.messageService.getObjectById(id);
		Assert.assertNotNull(message2);

		// 2. 更改
		message.setName("yyyy");
		message.setTitle("xxxxxxxx");
		message.setDescription("xxxxxxx");
		message.setContent("yyyyyy");
		message.setUrl("http://www.baidu.com");
		message.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
		message.setType("multi_msg");
		message.setPublicsID(146L);
		message.setStatus("400");
		boolean success = this.messageService.update(message);
		Assert.assertEquals(true, success);
		Message message3 = this.messageService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.messageService.delete(id);
		Assert.assertEquals(true, success);
		Message message4 = this.messageService.getObjectById(id);
		Assert.assertNull(message4);

		// 4.batchInsert
		List<Message> list = new ArrayList<Message>();
		Message message5 = new Message();

		message5.setName("xxxx");

		message5.setTitle("xxxxxxx");

		message5.setDescription("xxxxxxx");

		message5.setContent("xxxxx");

		message5.setUrl("http://www.douban.com");

		message5.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		message5.setType("text");

		message5.setPublicsID(145L);

		message5.setStatus("online");

		list.add(message5);
		Message message6 = new Message();

		message6.setName("yyyy");

		message6.setTitle("xxxxxxxx");

		message6.setDescription("xxxxxxx");

		message6.setContent("yyyyyy");

		message6.setUrl("http://www.baidu.com");

		message6.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		message6.setType("multi_msg");

		message6.setPublicsID(146L);

		message6.setStatus("400");

		list.add(message6);
		List<Message> insertResults = this.messageService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Message o : insertResults) {
			ids.add(o.getId());
		}

		List<Message> getResults = this.messageService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Message o : insertResults) {
			this.messageService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getMessageIdsByPublicsID() throws ServiceException, ServiceDaoException {
		List<Message> list = new ArrayList<Message>();
		Message message1 = new Message();

		message1.setName("xxxx");

		message1.setTitle("xxxxxxx");

		message1.setDescription("xxxxxxx");

		message1.setContent("xxxxx");

		message1.setUrl("http://www.douban.com");

		message1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		message1.setType("text");

		message1.setPublicsID(145L);

		message1.setStatus("online");

		list.add(message1);
		Message message2 = new Message();

		message2.setName("yyyy");

		message2.setTitle("xxxxxxxx");

		message2.setDescription("xxxxxxx");

		message2.setContent("yyyyyy");

		message2.setUrl("http://www.baidu.com");

		message2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		message2.setType("multi_msg");

		message2.setPublicsID(146L);

		message2.setStatus("400");

		list.add(message2);
		List<Message> insertResults = this.messageService.insertList(list);

		List<Long> lists = messageService.getMessageIdsByPublicsID(145L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Message o : insertResults) {
			this.messageService.delete(o.getId());
		}

	};
	@Test
	public void testGetDisplayIDs() throws ServiceException, ServiceDaoException{
		List<Long> lists = messageService.getDisplayMessageIdsByPublicsID(145L, 0, Integer.MAX_VALUE);
		log.info(lists);
	} 
	
	
	

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
