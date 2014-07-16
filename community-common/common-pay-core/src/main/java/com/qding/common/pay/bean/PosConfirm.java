package com.qding.common.pay.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  交易确认请求
 *
 * Created by magenm on 14-6-27.
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PosConfirm {
    /**
     * 商户号
     */
    private String mernum;
    /**
     * 终端号
     */
    private String termid;
    /**
     * 交易日期
     */
    private String trandate;
    /**
     * 交易时间
     */
    private String trantime;
    /**
     * 交易参考号
     */
    private String  referno;
    /**
     * 批次号
     */
    private String batchno;
    /**
     * 流水号
     */
    private String serialno;
    /**
     * 交易卡号 前六后四，中间*屏蔽
     */
    private String pan;
    /**
     * 交易金额 分为单位
     */
    private String amt;
    /**
     * 交易类型 01 消费，02 撤销
     */
    private String trantype;
    /**
     * 支付类型 1 刷卡
     */
    private String paytype;
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
     * 数字签名
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

    public String getTrandate() {
        return trandate;
    }

    public void setTrandate(String trandate) {
        this.trandate = trandate;
    }

    public String getTrantime() {
        return trantime;
    }

    public void setTrantime(String trantime) {
        this.trantime = trantime;
    }

    public String getReferno() {
        return referno;
    }

    public void setReferno(String referno) {
        this.referno = referno;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
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
        return "PosConfirm{" +
                "mernum='" + mernum + '\'' +
                ", termid='" + termid + '\'' +
                ", trandate='" + trandate + '\'' +
                ", trantime='" + trantime + '\'' +
                ", referno='" + referno + '\'' +
                ", batchno='" + batchno + '\'' +
                ", serialno='" + serialno + '\'' +
                ", pan='" + pan + '\'' +
                ", amt='" + amt + '\'' +
                ", trantype='" + trantype + '\'' +
                ", paytype='" + paytype + '\'' +
                ", orderId='" + orderId + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
