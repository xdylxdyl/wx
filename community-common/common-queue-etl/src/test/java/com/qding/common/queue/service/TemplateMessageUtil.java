package com.qding.common.queue.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.queue.model.MsgQueue;
import com.qding.community.common.weixin.util.TemplateUtil;
import com.qding.community.common.weixin.vo.template.TemplateEntry;
import com.qding.community.common.weixin.vo.template.TemplateMessage;
import com.qding.community.common.weixin.vo.template.message.CSNotificationsChanges;

public class TemplateMessageUtil {
	private static final Log log = LogFactory.getLog(TemplateMessageUtil.class);

	// 发送模板消息
	public static String sendTemplateMessage(String title, String time, String service, String remark, String reason,
			String location, String detail, String openId, final String appid, final String secret, String templateId,
			String url, String topColor, Long publicsID) {
		TemplateMessage<CSNotificationsChanges> templateMessage = new TemplateMessage<CSNotificationsChanges>();
		CSNotificationsChanges cs = new CSNotificationsChanges();

		cs.setDetail(new TemplateEntry(detail));// 服务变动详情 detail
		cs.setLocation(new TemplateEntry(location));// 服务变动范围 location
		cs.setReason(new TemplateEntry(reason));// 服务变动原因 reason
		cs.setRemark(new TemplateEntry(remark));// remark
		cs.setService(new TemplateEntry(service));// 服务内容 service
		cs.setTime(new TemplateEntry(time));// 服务变动时间
		cs.setTitle(new TemplateEntry(title));// title

		templateMessage.setData(cs);
		if (templateId == null || templateId.equals("")) {
			templateId = "VaGYN2JOft-1TNDTg249Kmoa0KC2vyGaZHA8x2b9HC4";
		}
		templateMessage.setTemplate_id(templateId);
		if (topColor == null || topColor.equals("")) {
			topColor = "#FF0000";
		}
		if (url == null) {
			url = "";
		}
		templateMessage.setTopcolor(topColor);
		
		templateMessage.setUrl(url);
		templateMessage.setPublicsID(publicsID);

		final String result = TemplateUtil.convertCSNotificationsChanges2Jsons(templateMessage);
		log.info(result);
		return result;

	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ServiceException, ServiceDaoException {
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String content = TemplateMessageUtil.sendTemplateMessage("测试新闻资讯消息群发，打扰见谅",
				simpleDateFormat.format(new Date()), "测试新闻资讯消息群发，打扰见谅", "测试新闻资讯消息群发，打扰见谅", "测试新闻资讯消息群发，打扰见谅", null,
				"测试新闻资讯消息群发，打扰见谅 ", null, null, null, null, null, null, 165L);

		MsgQueueService msgQueueService = (MsgQueueService) Naming.lookup("//115.28.20.72:9081/MsgQueueRMIService");
		MsgQueue msgQueue=new MsgQueue();
		msgQueue.setCheckPoint(0);
		msgQueue.setContent(content);
		msgQueue.setRetryCount(3);
		msgQueue.setStatus(MsgQueue.STATUS_PROCESSING);
		msgQueue.setType(MsgQueue.TYPE_WEIXIN);
		msgQueue.setCreateBy(1L);
		msgQueue.setUpdateBy(1L);
		Long id=msgQueueService.insert(msgQueue);
		log.info("insert "+id);
		

	}
}
