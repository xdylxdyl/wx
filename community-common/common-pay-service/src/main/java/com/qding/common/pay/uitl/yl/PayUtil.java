package com.qding.common.pay.uitl.yl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.Ostermiller.util.MD5;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PayUtil {
	private static final Log log = LogFactory.getLog(PayUtil.class);
	
	/**
	 * 解析通知报文
	 * 
	 * 
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String getNotice(String xmlString, String publicKey,String publicKeyFile) {
		try {
			log.info("getUrl xmlString=" + xmlString + ",publicKey=" + publicKey+",publicKeyFile="+publicKeyFile);
			BASE64Decoder decoder = new BASE64Decoder();
			String[] strArr = xmlString.split("\\|");
			String key = EncDecUtil.getPublicCertKey(publicKey,publicKeyFile);
			//对密钥进行RSA解密
			String mm=RSACoder.decryptByPublicKey(strArr[1],key);
			//报文解析
			String wxml=new String(DesUtil2.decrypt(decoder.decodeBuffer(strArr[2]),mm.getBytes()),"utf-8");
			return wxml;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("getNotice key error:" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("restriction")
	public  static String getData(String data,String merchantId, String key, String keyFile) {
		try {
			log.info("getData data=" + data + ",merchantId="+merchantId+",key=" + key + ",keyFile="
					+ keyFile);
			BASE64Encoder encoder = new BASE64Encoder();
			BASE64Decoder decoder = new BASE64Decoder();
			// 商户号
			String mercId = encoder.encodeBuffer(merchantId.getBytes());
			// 报文加密密钥生成
			String mm = MD5.getHashString(key);
			// 报文加密密钥加密
			String privateKey = EncDecUtil.getCertKey(key, keyFile);
			// 报文加密密钥
			String desKey = encoder.encodeBuffer(RSACoder.encryptByPrivateKey(
					mm.getBytes(), decoder.decodeBuffer(privateKey)));
			byte[] bodyb = DesUtil2.encrypt(data.getBytes("utf-8"),
					mm.getBytes());
			String miBody = encoder.encode(bodyb);
			// 加密报文体格式：BASE64(商户号)| BASE64(RSA(报文加密密钥))| BASE64(3DES(报文原文))
			return mercId + "|" + desKey + "|" + miBody;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("computor key error:" + e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * 处理订单查询结果
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static  String responseQueryCheck(String re, String key) {
		try {
			
			log.info("getUrl re=" + re + ",key=" + key);
			BASE64Decoder decoder = new BASE64Decoder();
			// 报文加密密钥生成
			String mm = MD5.getHashString(key);
			
			String[] strArr = re.split("\\|");
			
			if ("0".equals(strArr[0])) {
				
				byte[] de = decoder.decodeBuffer(strArr[2]);
				log.info("pay error code:" + strArr[1] + ",message:"
						+ new String(de, "utf-8"));
				
				return null;
			} else {
				
				byte[] de = decoder.decodeBuffer(strArr[1]);
				byte[] b = DesUtil2.decrypt(de, mm.getBytes());
				String content = new String(b, "utf-8");
				System.out.println(content);
				
				org.dom4j.Document document = org.dom4j.DocumentHelper
						.parseText(content);
				org.dom4j.Element upbp = document.getRootElement();
				
//				respCode:0000：表示提交查询成功；其他为提交查询失败，失败原因见应答码描述
				String respCode = upbp.elementText("respCode");
//				queryResult:
//				0：成功
//				1：失败
//				2：处理中
//				3：无此交易
//				4:查询本身失败
				String queryResult = upbp.elementText("queryResult");
				if ("0000".equals(respCode)) {
					return queryResult;
				}else {
					log.info("支付状态查询失败 code："+respCode);
					return "4";
				}
				
//				return upbp.elementText("gwInvokeCmd");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("computor key error:" + e.getMessage());
			return null;
		}
	}
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static  String getUrl(String re, String key) {
		try {

			log.info("getUrl re=" + re + ",key=" + key);
			BASE64Decoder decoder = new BASE64Decoder();
			// 报文加密密钥生成
			String mm = MD5.getHashString(key);

			String[] strArr = re.split("\\|");

			if ("0".equals(strArr[0])) {

				byte[] de = decoder.decodeBuffer(strArr[2]);
				log.info("pay error code:" + strArr[1] + ",message:"
						+ new String(de, "utf-8"));

				return null;
			} else {

				byte[] de = decoder.decodeBuffer(strArr[1]);
				byte[] b = DesUtil2.decrypt(de, mm.getBytes());
				String content = new String(b, "utf-8");
				System.out.println(content);

				org.dom4j.Document document = org.dom4j.DocumentHelper
						.parseText(content);
				org.dom4j.Element upbp = document.getRootElement();

				return upbp.elementText("gwInvokeCmd");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("computor key error:" + e.getMessage());
			return null;
		}
	}
}
