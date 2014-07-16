package com.qding.common.pay.bean.yl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class CancelBean {
	/**
	 * 标识报文发送的唯一编号,可以循环，要求至少在一天内唯一
	 */
	private String sendSeqId;
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
	private String merchantOrderCurrency = "156";
	/**
	 * 原交易的Cups交易流水号
	 */
	private String cupsQid;
	/**
	 * 用来接收交易结果通知的后台URL
	 */
	private String backUrl;
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
		Element root = new Element("updp");
		root.setAttribute("application", "MGw.Req");
		root.setAttribute("version", "1.0.0");
		root.setAttribute("sendTime", formatDate(new Date()));
		root.setAttribute("sendSeqId", sendSeqId);
		doc.setRootElement(root);

		createElement(root, "merchantName", merchantName);
		createElement(root, "merchantId", merchantId);
		createElement(root, "merchantOrderId", merchantOrderId);
		createElement(root, "merchantOrderTime", merchantOrderTime);
		createElement(root, "merchantOrderAmt", merchantOrderAmt);
		createElement(root, "merchantOrderCurrency", merchantOrderCurrency);
		createElement(root, "cupsQid", cupsQid);
		createElement(root, "backUrl", backUrl);
		createElement(root, "msgExt", msgExt);
		createElement(root, "misc", misc);

		return doc;
	}

	@SuppressWarnings({ "unchecked" })
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
}
