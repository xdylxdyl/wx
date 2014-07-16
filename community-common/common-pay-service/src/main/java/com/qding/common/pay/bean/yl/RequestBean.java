package com.qding.common.pay.bean.yl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.Ostermiller.util.MD5;
import com.gemantic.common.util.MyTimeUtil;
import com.qding.common.pay.uitl.yl.DesUtil2;
import com.qding.common.pay.uitl.yl.EncDecUtil;
import com.qding.common.pay.uitl.yl.RSACoder;
import com.qding.common.util.DataUtils;

public class RequestBean {

	private static final Log log = LogFactory.getLog(RequestBean.class);

	/**
	 * 标识报文发送的唯一编号,可以循环，要求至少在一天内唯一
	 */
	private String sendSeqId;
	/**
	 * 应用名称
	 */
	private String application;
	/**
	 * 商户名称
	 */
	private String merchantName;
	/**
	 * 商户代码
	 */
	private String merchantId;
	/**
	 * 商户订单号
	 */
	private String merchantOrderId;
	/**
	 * 商户订单时间
	 */
	private String merchantOrderTime;
	/**
	 * 商户订单金额
	 */
	private String merchantOrderAmt;
	/**
	 * 订单金额币种,156:人民币
	 */
	private String merchantOrderCurrency;
	/**
	 * 可选项，商户订单描述
	 */
	private String merchantOrderDesc;
	/**
	 * 可选项，交易超时时间,渠道平台需要严格控制，对交易超时的订单，拒绝支付。
	 */
	private String transTimeout;
	/**
	 * 可选项，交易类型,01:消费 ,如不填写，默认为消费
	 */
	private String transType = "01";
	/**
	 * 01:WAP
	 */
	private String gwType;
	/**
	 * 用来接收交易结果通知并跳转返回的URL
	 */
	private String frontUrl;
	/**
	 * 用来接收交易结果通知的后台URL
	 */
	private String backUrl;
	/**
	 * 可选项，用户ID,商户处的用户名。
	 */
	private String merchantUserId;
	/**
	 * 可选项，手机号码。
	 */
	private String mobileNum;
	/**
	 * 可选项，姓名。
	 */
	private String userName;
	/**
	 * 可选项，证件类型。 默认 01身份证
	 */
	private String idType;
	/**
	 * 可选项，证件号码。默认身份证号码
	 */
	private String idNum;
	/**
	 * 可选项，卡号。
	 */
	private String cardNum;
	/**
	 * 可选项，附加信息。
	 */
	private String msgExt;
	/**
	 * 可选项，自定义保留域。
	 */
	private String misc;

	// public static void main(String[] args) {
	// RequestBean req = new RequestBean();
	// req.setMerchantId("630056832596");
	// System.out.println(RequestBean.class.getClassLoader().getResource(".").getPath());
	// //获取报文数据
	// String data = req.doc2String(req.toDocument());
	// data = data.replace("null", "");
	// System.out.println(data);
	//
	// String keyFile = "630056832596.pfx";
	// System.out.println(req.getData(data,"123456",keyFile));
	// }

	public Document toDocument() {
		Calendar c=Calendar.getInstance();
		
		Document doc = new Document();
		Element root = new Element("upbp");
		root.setAttribute("application", application);
		root.setAttribute("version", "1.0.0");
		root.setAttribute("sendTime", formatDate(c.getTime()));

		sendSeqId = MyTimeUtil.getTimeInyyyyMMdd()
				+ DataUtils.getRandomIntString(4);

		root.setAttribute("sendSeqId", sendSeqId);
		doc.setRootElement(root);

		// createElement(root, "merchantName", merchantName);
		createElement(root, "merchantId", merchantId);
		createElement(root, "merchantOrderId", merchantOrderId);
		createElement(root, "merchantOrderTime", merchantOrderTime);
		createElement(root, "merchantOrderAmt", merchantOrderAmt);
		createElement(root, "merchantOrderCurrency", merchantOrderCurrency);
		createElement(root, "merchantOrderDesc", merchantOrderDesc);
		
		int timeout = Integer.parseInt(transTimeout);
		c.add(Calendar.MINUTE, timeout);
		
		createElement(root, "transTimeout", formatDate(c.getTime()));
		createElement(root, "transType", transType);
		createElement(root, "gwType", gwType);
		createElement(root, "frontUrl", frontUrl);
		createElement(root, "backUrl", backUrl);
		createElement(root, "merchantUserId", merchantUserId);
		createElement(root, "mobileNum", mobileNum);
		createElement(root, "userName", userName);
		createElement(root, "idType", idType);
		createElement(root, "idNum", idNum);
		createElement(root, "cardNum", cardNum);
		createElement(root, "msgExt", msgExt);
		createElement(root, "misc", misc);

		return doc;
	}

	@SuppressWarnings({ "unchecked" })
	private Element createElement(Element parent, String name, String value) {
		Element elem = new Element(name);
		elem.setText(value + "#@#");
		parent.getChildren().add(elem);
		return elem;
	}

	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}

	public String doc2String(Document doc) {
		try {
			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题
			XMLOutputter xmlout = new XMLOutputter(format);
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			xmlout.output(doc, bo);
			return bo.toString().replace("#@#", "").replace("null", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getMerchantOrderTime() {
		return merchantOrderTime;
	}

	public void setMerchantOrderTime(String merchantOrderTime) {
		this.merchantOrderTime = merchantOrderTime;
	}

	public String getMerchantOrderAmt() {
		return merchantOrderAmt;
	}

	public void setMerchantOrderAmt(String merchantOrderAmt) {
		this.merchantOrderAmt = merchantOrderAmt;
	}

	public String getMerchantOrderCurrency() {
		return merchantOrderCurrency;
	}

	public void setMerchantOrderCurrency(String merchantOrderCurrency) {
		this.merchantOrderCurrency = merchantOrderCurrency;
	}

	public String getMerchantOrderDesc() {
		return merchantOrderDesc;
	}

	public void setMerchantOrderDesc(String merchantOrderDesc) {
		this.merchantOrderDesc = merchantOrderDesc;
	}

	public String getTransTimeout() {
		return transTimeout;
	}

	public void setTransTimeout(String transTimeout) {
		this.transTimeout = transTimeout;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getGwType() {
		return gwType;
	}

	public void setGwType(String gwType) {
		this.gwType = gwType;
	}

	public String getFrontUrl() {
		return frontUrl;
	}

	public void setFrontUrl(String frontUrl) {
		this.frontUrl = frontUrl;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public String getMerchantUserId() {
		return merchantUserId;
	}

	public void setMerchantUserId(String merchantUserId) {
		this.merchantUserId = merchantUserId;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getMsgExt() {
		return msgExt;
	}

	public void setMsgExt(String msgExt) {
		this.msgExt = msgExt;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public void setApplication(String application) {
		this.application = application;
	}

}
