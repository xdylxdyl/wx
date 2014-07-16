package com.qding.community.weixin.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qding.commnunity.common.weixin.service.impl.WeiXinServiceImpl;
import com.qding.common.util.FileUtil;
import com.qding.community.common.weixin.service.WeiXinService;
import com.qding.community.common.weixin.util.TemplateUtil;
import com.qding.community.common.weixin.util.WeiXinPropertiesUtil;
import com.qding.community.common.weixin.vo.OpenIDList;
import com.qding.community.common.weixin.vo.template.TemplateEntry;
import com.qding.community.common.weixin.vo.template.TemplateMessage;
import com.qding.community.common.weixin.vo.template.message.CSNotificationsChanges;

public class ParseJsonUtilTest {
	private static final Log log = LogFactory.getLog(ParseJsonUtilTest.class);

	@Test
	public void testParseJson() throws IOException {

		/*
		 * String secret = "311a6832a57965276ffe4f46566fd20a"; String menu =
		 * FileUtil.readFileAsString("d:/data/wx-menu.txt"); log.info("menu " +
		 * menu); // String appid = "wxfc7d1fed47862585"; boolean r =
		 * WeiXinUtil.publishMenu(appid, secret, menu);
		 * log.info(" create menu result is " + r);
		 */

	}

	@Test
	public  void testTemplateMessage() throws InterruptedException {

		TemplateMessage<CSNotificationsChanges> templateMessage = new TemplateMessage<CSNotificationsChanges>();
		CSNotificationsChanges cs = new CSNotificationsChanges();

		cs.setDetail(new TemplateEntry("康杨"));

		cs.setLocation(new TemplateEntry("北京"));
		cs.setReason(new TemplateEntry("请我吃饭测试"));
		cs.setRemark(new TemplateEntry("高端大气上档次测试"));
		cs.setService(new TemplateEntry("test"));
		cs.setTime(new TemplateEntry("今天晚上"));
		cs.setTitle(new TemplateEntry("你是不是该请我吃饭了"));

		templateMessage.setData(cs);
		//templateMessage.setTemplate_id("0SNrqK4TEdVmkE-N3gSA9IMsUr8WGgCc5uuxkvzLGK8");
		
		templateMessage.setTemplate_id("VaGYN2JOft-1TNDTg249Kmoa0KC2vyGaZHA8x2b9HC4");

		templateMessage.setTopcolor("#FF0000");
		//templateMessage.setTouser("ovK7Ijo7AbAZHeDoNnchvokTRNdw");
		
		templateMessage.setTouser("oFOtTuLaS3zZEJsWT_LWwpy0D05A");
		templateMessage.setUrl("http://www.ptteng.com");
		templateMessage.setPublicsID(165L);

		String result = TemplateUtil.convertCSNotificationsChanges2Jsons(templateMessage);
		log.info(result);
		
		Gson gson = new GsonBuilder().create();
		
		
		TemplateMessage<CSNotificationsChanges> t=gson.fromJson(result,new TypeToken<TemplateMessage<CSNotificationsChanges>>(){}.getType() );
		log.info("t is "+t);;
		//String appid = "wxfc7d1fed47862585";
		String appid ="wxd36fc72b2910b516";
 		//String secret = "311a6832a57965276ffe4f46566fd20a";
 		String secret = "ee0671a9806692cf66b8a483bdfce33c";
	/*	WeiXinService wxService = new WeiXinServiceImpl();
		String response = wxService.sendTemplateMessage(appid, secret, result, true);
		Thread.sleep(5000L);
		log.info(response);*/
		
	}

	@Test
	public void testNUll() {

	}

	public static void main(String[] args) throws Exception {
		log.info("start");
		String menu = "";
		menu = FileUtil.readFileAsString("d:/data/wx-media.txt");
		//160  听蓝
		String appid = "wxd0fc95b69c624721";
		String secret = "57f743006408ba918e4e460b2a101304";

		// ParseJsonUtilTest.testTemplateMessage();
		WeiXinService wxService = new WeiXinServiceImpl();
		
		
		String wx_media_img = "";
		wx_media_img = FileUtil.readFileAsString("d:/data/wx-media-img.txt");
		List<String> openIDS=new ArrayList();
		openIDS.add("ol1Xfjr-ZK38oTUsJtJHwdUcE3MU"); // xdyl
		String mediaID="HmpbHFDo_6DkX1ojjYZdIs4OYm4icg7i4HmFMftzpBjrRE8pJ7-StPqbZs3PCw-4";
		
		String data=wxService.generateMassMPNewsMessage(mediaID, openIDS);
		wxService.massSendNewsMessageByOpenID(appid, secret, data);
		
		/*String news = wxService.createCodeRequestUrl(appid, secret, "http://wxapi.qdingnet.com/p/news?pid=161");
		log.info(news);
		menu = menu.replace("{redirect_uri_news}", news);
		String goods = wxService.createCodeRequestUrl(appid, secret, "http://wxapi.qdingnet.com/p/goods?pid=161");
		log.info(goods);
		menu = menu.replace("{redirect_uri_goods}", goods);

		String my = wxService.createCodeRequestUrl(appid, secret, "http://wxapi.qdingnet.com/p/potential?pid=161");
		log.info(my);
		menu = menu.replace("{redirect_uri_my}", my);

		log.info(menu);*/
		// String result=HttpClientUtil.getInstance().postXML("localhost", 9090,
		// "/post/test", "application/json" ,menu);

		// log.info("result "+ result);

		// String imgUrl = WeiXinUtil.createLimitQRCode(appid, secret, 3L);
		// log.info(" create imgUrl result is " + imgUrl);

		/*
		 * String
		 * url="http%3A%2F%2Fdev.quanjiali.com%2Fp%2Ftest%3Fhash%3D-2042484612";
		 * String requestUrl=wxService.createCodeRequestUrl(appid, secret, url);
		 * String img=wxService.createLimitQRCode(appid, secret, 3L);
		 */

		//wxService.publishMenu(appid, secret, menu);
		log.info("publish menu over");

		// https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc7d1fed47862585&redirect_uri=http%3A%2F%2Fdev.quanjiali.com%2Fp%2Fnews%3Fpid%3D145&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"},{"name":"乐购","type":"view","url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc7d1fed47862585&redirect_uri=http%3A%2F%2Fdev.quanjiali.com%2Fp%2Fgoods%3Fpid%3D145&response_type=code&scope=snsapi_base&state=STATE#wechat_
		// wxService.removeMenu(appid, secret);

	}

	private static String generateMassImg() {
		List<String> openIDS=new ArrayList();
		openIDS.add("ol1Xfjr-ZK38oTUsJtJHwdUcE3MU"); // xdyl
		
		//String mediaID=wxService.uploadNews(appid, secret, menu);
		Gson gson = new GsonBuilder().create();
		String openIDSString = gson.toJson(openIDS);
		
		String upload_media = WeiXinPropertiesUtil.getProperty("mass_post");
		upload_media = upload_media.replace("{openIDS}", openIDSString);
		
		upload_media = upload_media.replace("{mediaID}", "HmpbHFDo_6DkX1ojjYZdIs4OYm4icg7i4HmFMftzpBjrRE8pJ7-StPqbZs3PCw-4");
		return upload_media;
	}
	
	@Test
	public void testGetOpenIDList(){
		String appid = "wxd0fc95b69c624721";
		String secret = "57f743006408ba918e4e460b2a101304";

		// ParseJsonUtilTest.testTemplateMessage();
		// ParseJsonUtilTest.testTemplateMessage();
		WeiXinService wxService = new WeiXinServiceImpl();
		OpenIDList xxx=wxService.getOpenIDList(appid, secret, "");
		log.info(xxx);
	};
	
	
	
	

}
