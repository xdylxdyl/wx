package com.qding.common.queue.etl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.constant.DaoConstant;
import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.process.service.QueueProcessService;
import com.qding.common.queue.service.MsgQueueService;
import com.qding.common.queue.service.RetryQueueService;

public class MsgEtl {

	private static final int TASK_LEN = 100;// 一次任务检测的条数

	private static final long SLEEP_MILLISECOND = 5*1000L;// 空转任务间隔休息毫秒数
	private static final long Sleep_Error=60*1000L;

	private static final Log log = LogFactory.getLog(MsgEtl.class);

	
	private MsgQueueService msgQueueService;
	
	private RetryQueueService retryQueueService;

	private Map<String, QueueProcessService> queueConfig;

	private Integer batchSize = 1;

	public MsgQueueService getMsgQueueService() {
		return msgQueueService;
	}

	public void setMsgQueueService(MsgQueueService msgQueueService) {
		this.msgQueueService = msgQueueService;
	}

	public RetryQueueService getRetryQueueService() {
		return retryQueueService;
	}

	public void setRetryQueueService(RetryQueueService retryQueueService) {
		this.retryQueueService = retryQueueService;
	}

	public Integer getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
	}

	public Map<String, QueueProcessService> getQueueConfig() {
		return queueConfig;
	}

	public void setQueueConfig(Map<String, QueueProcessService> queueConfig) {
		this.queueConfig = queueConfig;
	}

	public MsgEtl() {
		super();
	}

	public void process() throws InterruptedException {

		while (true) {

			try {
				processQueue();
			} catch (Throwable t) {
				t.printStackTrace();
				Thread.sleep(Sleep_Error);
				log.error("process msg etl bytime status error ,sleep " + t.getMessage());
			}

		}

	}

	/**
	 * 检测发送队列
	 * 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 * @throws InterruptedException
	 */
	private void processQueue() throws ServiceException, ServiceDaoException, InterruptedException {

		// 1 get data
		List<MsgQueue> queues = this.getData();
		if (CollectionUtils.isEmpty(queues)) {

			log.info("msg etl not get any data sleep "+SLEEP_MILLISECOND);
			Thread.sleep(SLEEP_MILLISECOND);
			
		} else {
			// 2 process data
			this.processList(queues);

			// 3 update data
			this.updateQueue(queues);
		}
		

		

	}

	private void updateQueue(List<MsgQueue> queues) throws ServiceException, ServiceDaoException {

		this.msgQueueService.updateList(queues);
		log.info("update queues success " + queues);

	}

	private void processList(List<MsgQueue> queues) {
		for (MsgQueue mq : queues) {
			log.info("process mq " + mq);
			String type = mq.getType();
			QueueProcessService processService = this.queueConfig.get(type);
			if (processService == null) {
				log.info(mq + " not get any processService  ");
				continue;
			} else {
				log.info(mq.getId() + " get processService is " + processService);
			}

			try {
				processService.processQueue(mq);
			} catch (Throwable t) {
				t.printStackTrace();
				log.error(t.getMessage());
				log.error(mq + " process " + processService + " error ,please check it ");
				mq.setStatus(MsgQueue.STATUS_Failure);
				continue;
			}
			log.info(mq.getId() + " and processService is " + processService + " process over ");
			mq.setStatus(MsgQueue.STATUS_OVER);

		}

	}

	private List<MsgQueue> getData() throws ServiceException, ServiceDaoException {

		List<Long> ids = this.msgQueueService.getMsgQueueIdsByStatus(MsgQueue.STATUS_PROCESSING, 0, this.batchSize);
		log.info(MsgQueue.STATUS_PROCESSING + " size " + this.batchSize + " get queues ids is " + ids);

		List<MsgQueue> queues = this.msgQueueService.getObjectsByIds(ids);
		log.info(MsgQueue.STATUS_PROCESSING + " size " + this.batchSize + " get queues is " + queues);
		return queues;
	}
	
	
	
}
