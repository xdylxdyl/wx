package com.qding.common.pay.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 订单查询请求
 *
 * Created by magenm on 14-6-27.
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PosQuery {
    /**
     * 商户号
     */
    private String mernum;
    /**
     * 终端号
     */
    private String termid;
    /**
     * 请求时间
     */
    private String reqTime;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 预留字段1
     */
    private String ext1;
    /**
     * 预留字段2
     */
    private String ext2;
    /**
     * 签名
     */
    private String sign;

    public String getMernum() {
        return mernum;
    }

    public void setMernum(String mernum) {
        this.mernum = mernum;
    }

    public String getTermid() {
        return termid;
    }

    public void setTermid(String termid) {
        this.termid = termid;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "PosQuery{" +
                "mernum='" + mernum + '\'' +
                ", termid='" + termid + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
