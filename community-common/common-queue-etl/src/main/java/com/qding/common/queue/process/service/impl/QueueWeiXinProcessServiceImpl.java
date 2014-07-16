package com.qding.common.queue.process.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.model.RetryQueue;
import com.qding.common.queue.process.service.QueueProcessService;
import com.qding.common.queue.service.MsgQueueService;
import com.qding.common.queue.service.RetryQueueService;
import com.qding.common.util.json.GsonUtil;
import com.qding.community.common.weixin.service.WeiXinService;
import com.qding.community.common.weixin.util.TemplateUtil;
import com.qding.community.common.weixin.vo.template.TemplateMessage;
import com.qding.community.common.weixin.vo.template.message.CSNotificationsChanges;
import com.qding.framework.publics.model.Publics;
import com.qding.framework.publics.service.PublicsService;
import com.qding.framework.user.model.Potential;
import com.qding.framework.user.service.PotentialService;

public class QueueWeiXinProcessServiceImpl implements QueueProcessService {

	private static final Log log = LogFactory.getLog(QueueWeiXinProcessServiceImpl.class);

	private PotentialService potentialService;

	private MsgQueueService msgQueueService;

	private WeiXinService weixinService;

	private PublicsService publicsService;

	private RetryQueueService retryQueueService;

	private Integer batchSize = 200;

	public Integer getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
	}

	@Override
	public void processQueue(MsgQueue mq) throws ServiceException, ServiceDaoException {
		log.info("start process mq ");
		int lastStart = mq.getCheckPoint();

		Gson gson = new GsonBuilder().create();

		TemplateMessage templateMessage = gson.fromJson(mq.getContent(), TemplateMessage.class);

		log.info("templateMessage is " + templateMessage);
		Long publicsID = templateMessage.getPublicsID();

		Map<String, Object> params = new HashMap();
		params.put(" publics_id ", publicsID);

		params.put("@query", "id");

		params.put("@order", "potential.create_at desc");

		List<Long> ids = this.potentialService.getIdsByDynamicCondition(Potential.class, params, lastStart,
				this.batchSize);
		log.info(publicsID + "start " + lastStart + " from " + batchSize + " get Potential ids " + ids);
		List<Potential> potentials = this.potentialService.getObjectsByIds(ids);
		for (Potential potential : potentials) {
			try {
				boolean result = this.sendMessage(potential, templateMessage);
				if (result) {
					log.info(potential.getId() + "is potential   mq " + mq.getId() + " templateMessage "
							+ templateMessage + " success ");
				} else {
					log.info(potential.getId() + "is potential   mq " + mq.getId() + " templateMessage "
							+ templateMessage + " failure ");
					insertWrongQueue(potential, mq);

				}
			} catch (Throwable t) {
				t.printStackTrace();
				log.error(t.getMessage());
				log.error(mq + " potential process wrong " + potential);
				insertWrongQueue(potential, mq);
			}
			log.info(mq.getId() + " send over of " + potential.getId());
		}
		log.info(publicsID + "send over start " + lastStart + " from " + batchSize);
		mq.setCheckPoint(mq.getCheckPoint() + this.batchSize);
		this.msgQueueService.update(mq);
		log.info(publicsID + "update mq  over" + mq);

	}

	private boolean sendMessage(Potential potential, TemplateMessage templateMessage) throws ServiceException,
			ServiceDaoException {
		boolean success = false;

		Publics publics;
		publics = publicsService.getObjectById(templateMessage.getPublicsID());
		templateMessage.setTouser(potential.getOpenID());
		String msgResult = this.weixinService.sendTemplateMessage(publics.getAppID(), publics.getAppSecret(),
				TemplateUtil.convertCSNotificationsChanges2Jsons(templateMessage), false);
		String errcode = GsonUtil.get("errcode", msgResult);
		if ("0".equals(errcode)) {

			success = true;

		} else {

			success = false;

		}

		return success;
	}

	private void insertWrongQueue(Potential potential, MsgQueue mq) {
		log.info(potential + " something wrong so we inert failure " + mq);
		RetryQueue retryQueue = new RetryQueue();
		retryQueue.setContent(mq.getContent());
		retryQueue.setTargetID(potential.getId().toString());
		retryQueue.setType(mq.getType());
		retryQueue.setQueueID(mq.getId());
		retryQueue.setRetryCount(mq.getRetryCount());

		try {
			Long id = this.retryQueueService.insert(retryQueue);
			log.info(id + " insert retryQueue " + retryQueue);
		} catch (Throwable t2) {
			t2.printStackTrace();
			log.error(t2.getMessage());
			log.error(retryQueue + " insert wrong ");
		}
	}

	public PotentialService getPotentialService() {
		return potentialService;
	}

	public void setPotentialService(PotentialService potentialService) {
		this.potentialService = potentialService;
	}

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

	public WeiXinService getWeixinService() {
		return weixinService;
	}

	public void setWeixinService(WeiXinService weixinService) {
		this.weixinService = weixinService;
	}

	public PublicsService getPublicsService() {
		return publicsService;
	}

	public void setPublicsService(PublicsService publicsService) {
		this.publicsService = publicsService;
	}

	@Override
	public boolean processRetryQueue(RetryQueue rq) throws ServiceException, ServiceDaoException {
		boolean result = false;

		TemplateMessage<CSNotificationsChanges> templateMessage = TemplateUtil.convertJsons2CSNotificationsChanges(rq
				.getContent());
		log.info("templateMessage is " + templateMessage);

		try {
			Potential potential = this.potentialService.getObjectById(Long.valueOf(rq.getTargetID()));
			result = this.sendMessage(potential, templateMessage);
			log.info(rq.getId() + " send over of " + potential.getId());
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error(rq + " potential process wrong ");

		}

		return result;

	}

}
