package com.qding.common.queue.service.impl;

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
import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.service.MsgQueueService;

@Ignore
public class MsgQueueServiceTest {

	private static final Log log = LogFactory.getLog(MsgQueueServiceTest.class);

	private MsgQueueService msgQueueService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/common-queue-service/applicationContext-server.xml");
		msgQueueService = (MsgQueueService) context.getBean("msgQueueService");
		// local server
		/**
		 * msgQueueService = (MsgQueueService)
		 * Naming.lookup("//localhost:9081/MsgQueueRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * msgQueueService = (MsgQueueService)
		 * context.getBean("msgQueueService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		MsgQueue msgQueue = new MsgQueue();

		msgQueue.setType("sms");

		msgQueue.setContent("{name:\"张三\",id:1}");

		msgQueue.setCheckPoint(200);

		msgQueue.setStatus("processing");

		msgQueue.setCreateBy(1L);

		msgQueue.setUpdateBy(1L);

		Long id = this.msgQueueService.insert(msgQueue);

		msgQueue = this.msgQueueService.getObjectById(id);

		MsgQueue msgQueue2 = this.msgQueueService.getObjectById(id);
		Assert.assertNotNull(msgQueue2);

		// 2. 更改
		msgQueue.setType("weixin");
		msgQueue.setContent("{name:\"李四\",id:2}");
		msgQueue.setCheckPoint(200);
		msgQueue.setStatus("over");
		msgQueue.setCreateBy(13L);
		msgQueue.setUpdateBy(13L);
		boolean success = this.msgQueueService.update(msgQueue);
		Assert.assertEquals(true, success);
		MsgQueue msgQueue3 = this.msgQueueService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.msgQueueService.delete(id);
		Assert.assertEquals(true, success);
		MsgQueue msgQueue4 = this.msgQueueService.getObjectById(id);
		Assert.assertNull(msgQueue4);

		// 4.batchInsert
		List<MsgQueue> list = new ArrayList<MsgQueue>();
		MsgQueue msgQueue5 = new MsgQueue();

		msgQueue5.setType("sms");

		msgQueue5.setContent("{name:\"张三\",id:1}");

		msgQueue5.setCheckPoint(200);

		msgQueue5.setStatus("processing");

		msgQueue5.setCreateBy(1L);

		msgQueue5.setUpdateBy(1L);

		list.add(msgQueue5);
		MsgQueue msgQueue6 = new MsgQueue();

		msgQueue6.setType("weixin");

		msgQueue6.setContent("{name:\"李四\",id:2}");

		msgQueue6.setCheckPoint(200);

		msgQueue6.setStatus("over");

		msgQueue6.setCreateBy(13L);

		msgQueue6.setUpdateBy(13L);

		list.add(msgQueue6);
		List<MsgQueue> insertResults = this.msgQueueService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (MsgQueue o : insertResults) {
			ids.add(o.getId());
		}

		List<MsgQueue> getResults = this.msgQueueService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (MsgQueue o : insertResults) {
			this.msgQueueService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getMsgQueueIdsByTypeAndStatus() throws ServiceException, ServiceDaoException {
		List<MsgQueue> list = new ArrayList<MsgQueue>();
		MsgQueue msgQueue1 = new MsgQueue();

		msgQueue1.setType("sms");

		msgQueue1.setContent("{name:\"张三\",id:1}");

		msgQueue1.setCheckPoint(200);

		msgQueue1.setStatus("processing");

		msgQueue1.setCreateBy(1L);

		msgQueue1.setUpdateBy(1L);

		list.add(msgQueue1);
		MsgQueue msgQueue2 = new MsgQueue();

		msgQueue2.setType("weixin");

		msgQueue2.setContent("{name:\"李四\",id:2}");

		msgQueue2.setCheckPoint(200);

		msgQueue2.setStatus("over");

		msgQueue2.setCreateBy(13L);

		msgQueue2.setUpdateBy(13L);

		list.add(msgQueue2);
		List<MsgQueue> insertResults = this.msgQueueService.insertList(list);

		List<Long> lists = msgQueueService.getMsgQueueIdsByTypeAndStatus("sms", "processing", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (MsgQueue o : insertResults) {
			this.msgQueueService.delete(o.getId());
		}

	};

	// @Test
	public void getMsgQueueIdsByType() throws ServiceException, ServiceDaoException {
		List<MsgQueue> list = new ArrayList<MsgQueue>();
		MsgQueue msgQueue1 = new MsgQueue();

		msgQueue1.setType("sms");

		msgQueue1.setContent("{name:\"张三\",id:1}");

		msgQueue1.setCheckPoint(200);

		msgQueue1.setStatus("processing");

		msgQueue1.setCreateBy(1L);

		msgQueue1.setUpdateBy(1L);

		list.add(msgQueue1);
		MsgQueue msgQueue2 = new MsgQueue();

		msgQueue2.setType("weixin");

		msgQueue2.setContent("{name:\"李四\",id:2}");

		msgQueue2.setCheckPoint(200);

		msgQueue2.setStatus("over");

		msgQueue2.setCreateBy(13L);

		msgQueue2.setUpdateBy(13L);

		list.add(msgQueue2);
		List<MsgQueue> insertResults = this.msgQueueService.insertList(list);

		List<Long> lists = msgQueueService.getMsgQueueIdsByType("sms", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (MsgQueue o : insertResults) {
			this.msgQueueService.delete(o.getId());
		}

	};

	// @Test
	public void getMsgQueueIdsByStatus() throws ServiceException, ServiceDaoException {
		List<MsgQueue> list = new ArrayList<MsgQueue>();
		MsgQueue msgQueue1 = new MsgQueue();

		msgQueue1.setType("sms");

		msgQueue1.setContent("{name:\"张三\",id:1}");

		msgQueue1.setCheckPoint(200);

		msgQueue1.setStatus("processing");

		msgQueue1.setCreateBy(1L);

		msgQueue1.setUpdateBy(1L);

		list.add(msgQueue1);
		MsgQueue msgQueue2 = new MsgQueue();

		msgQueue2.setType("weixin");

		msgQueue2.setContent("{name:\"李四\",id:2}");

		msgQueue2.setCheckPoint(200);

		msgQueue2.setStatus("over");

		msgQueue2.setCreateBy(13L);

		msgQueue2.setUpdateBy(13L);

		list.add(msgQueue2);
		List<MsgQueue> insertResults = this.msgQueueService.insertList(list);

		List<Long> lists = msgQueueService.getMsgQueueIdsByStatus("processing", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (MsgQueue o : insertResults) {
			this.msgQueueService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
	
	@Test
	public void testMockData(){
		
		
	}
}
