package com.qding.common.queue.process.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.model.RetryQueue;

public interface QueueProcessService {

	public void processQueue(MsgQueue mq) throws ServiceException, ServiceDaoException;
	
	
	public boolean processRetryQueue(RetryQueue rq) throws ServiceException, ServiceDaoException;
}
