package com.qding.common.pay.bean.yl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.gemantic.common.util.MyTimeUtil;
import com.qding.common.util.DataUtils;

public class QueryBean {

	/**
	 * 标识报文发送的唯一编号,可以循环，要求至少在一天内唯一
	 */
	private String sendSeqId;
	/**
	 * 可选项，交易类型,01:消费 04:退货,如不填写，默认为消费
	 */
	private String transType;
	/**
	 * 商户代码
	 */
	private String merchantId;
	/**
	 * 商户订单号
	 */
	private String merchantOrderId;
	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	/**
	 * 商户订单时间
	 */
	private String merchantOrderTime;
	public String getMerchantOrderTime() {
		return merchantOrderTime;
	}

	public void setMerchantOrderTime(String merchantOrderTime) {
		this.merchantOrderTime = merchantOrderTime;
	}

	/**
	 * 可选项，附加信息。
	 */
	private String msgExt;
	/**
	 * 可选项，自定义保留域。
	 */
	private String misc;
	
	public static void main(String[] args) {
		QueryBean req = new QueryBean();
		System.out.println(req.doc2String(req.toDocument()));
	}

	public Document toDocument() {
		Document doc = new Document();
		Element root = new Element("upbp");
		root.setAttribute("application", "MTransInfo.Req");
		root.setAttribute("version", "1.0.0");
		root.setAttribute("sendTime", formatDate(new Date()));
		sendSeqId = MyTimeUtil.getTimeInyyyyMMdd()
				+ DataUtils.getRandomIntString(4);
		root.setAttribute("sendSeqId", sendSeqId);
		
		
		createElement(root, "transType", transType);
		createElement(root, "merchantId", merchantId);
		createElement(root, "merchantOrderId", merchantOrderId);
		createElement(root, "merchantOrderTime", merchantOrderTime);
		
		
		doc.setRootElement(root);

//		createElement(root, "msgExt",msgExt);
//		createElement(root, "misc",misc);

		return doc;
	}
	
	@SuppressWarnings({ "unchecked"})
	private Element createElement(Element parent, String name, String value) {
		Element elem = new Element(name);
		elem.setText(value);
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
			return bo.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
}
