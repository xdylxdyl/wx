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
import com.gemantic.common.util.MyListUtil;
import com.qding.common.constant.DaoConstant;
import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.model.RetryQueue;
import com.qding.common.queue.process.service.QueueProcessService;
import com.qding.common.queue.service.MsgQueueService;
import com.qding.common.queue.service.RetryQueueService;

public class RetryEtl {

	private static final int TASK_LEN = 100;// 一次任务检测的条数

	private static final long SLEEP_MILLISECOND = 5*1000L;// 空转任务间隔休息毫秒数

	private static final long Sleep_Error = 60 * 1000L;

	private static final Log log = LogFactory.getLog(RetryEtl.class);

	private MsgQueueService msgQueueService;

	private RetryQueueService retryQueueService;

	private Map<String, QueueProcessService> queueConfig;

	private Integer batchSize = 200;

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

	public RetryEtl() {
		super();
	}

	public void process() throws InterruptedException {

		while (true) {

			try {
				processQueue();
			} catch (Throwable t) {
				t.printStackTrace();
				Thread.sleep(Sleep_Error);
				log.error("process retry etl  bytime status error ,sleep " + t.getMessage());
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
		List<RetryQueue> queues = this.getData();
		if (CollectionUtils.isEmpty(queues)) {

			log.info("msg etl not get any data sleep " + SLEEP_MILLISECOND);
			Thread.sleep(SLEEP_MILLISECOND);
		} else {
			// 2 process data
			this.processList(queues);
		}

		// 3 update data
		// this.updateQueue(queues);

		// System.out.println(ids);

	}

	private void updateQueue(List<RetryQueue> queues) throws ServiceException, ServiceDaoException {

		try {
			List<Long> ids = MyListUtil.getList(RetryQueue.class.getDeclaredField("id"), queues);
			this.retryQueueService.deleteList(RetryQueue.class, ids);
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
		log.info("update queues success " + queues);

	}

	private void processList(List<RetryQueue> queues) {
		for (RetryQueue rq : queues) {
			log.info("process rq " + rq);
			MsgQueue mq = null;
			try {
				mq = this.msgQueueService.getObjectById(rq.getQueueID());
			} catch (Throwable t4) {
				t4.printStackTrace();
				log.error(t4.getMessage());
				log.error(rq + "  get  mq failure");

			}
			if (mq == null) {
				log.warn(rq + " not get any mq ");
				deleteData(rq);

			} else {
				String type = rq.getType();
				QueueProcessService processService = this.queueConfig.get(type);
				if (processService == null) {
					log.info(rq + " not get any processService  ");
					continue;
				} else {
					log.info(rq.getId() + " get processService is " + processService);
				}
				boolean success = false;
				try {
					success = processService.processRetryQueue(rq);
				} catch (Throwable t) {
					t.printStackTrace();
					log.error(t.getMessage());
					log.error(rq + " process " + processService + " error ,please check it ");

					saveFailureData(rq, mq);

				}
				if (success) {
					log.info(rq.getId() + " and processService is " + processService + " process over ");
					deleteData(rq);
				} else {
					saveFailureData(rq, mq);
				}

			}

		}

	}

	private void deleteData(RetryQueue rq) {
		try {
			this.retryQueueService.delete(rq.getId());
		} catch (Throwable t2) {

			t2.printStackTrace();
			log.error(t2.getMessage());
			log.error(rq + " delete failure ");
		}
	}

	private void saveFailureData(RetryQueue rq, MsgQueue mq) {
		try {
			if (rq.getRetryCount() >= mq.getRetryCount()) {
				this.retryQueueService.delete(rq.getId());
				log.warn(rq +" over failure ,so delete it ");
			} else {
				rq.setRetryCount(rq.getRetryCount() + 1);
				this.retryQueueService.update(rq);
				log.warn(rq +" send over  ,so update count ");
			}
		} catch (Throwable t3) {

			t3.printStackTrace();
			log.error(t3.getMessage());
			log.error(rq + " delete/update failure ");

		}
	}

	private List<RetryQueue> getData() throws ServiceException, ServiceDaoException {

		List<Long> ids = this.retryQueueService.getRetryQueueIds(0, this.batchSize);
		log.info(" RetryQueue size " + this.batchSize + " get queues ids is " + ids);

		List<RetryQueue> queues = this.retryQueueService.getObjectsByIds(ids);
		log.info(" RetryQueue size  " + this.batchSize + " get queues is " + queues);
		return queues;
	}

}
