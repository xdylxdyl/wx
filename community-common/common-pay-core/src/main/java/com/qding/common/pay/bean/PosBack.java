package com.qding.common.pay.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by magenm on 14-6-27.
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class PosBack {
    /**
     * 返回码
     */
    private String responseCode;
    /**
     * 错误描述
     */
    private String responseDes;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 交易金额
     */
    private String amt;
    /**
     * 显示字段
     */
    private String show;
    /**
     * 打印字段
     */
    private String print;

    /**
     * 扩展字段
     */
    private String ext;
    /**
     * 扩展字段1
     */
    private String ext1;
    /**
     * 扩展字段1
     */
    private String ext2;

    public PosBack() {
    }

    public PosBack(String responseDes, String responseCode) {
        this.responseDes = responseDes;
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDes() {
        return responseDes;
    }

    public void setResponseDes(String responseDes) {
        this.responseDes = responseDes;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public void setShow(String show,boolean isCDATA) {
        if(isCDATA){
            this.show = "<![CDATA[" + show+ "]]>";;
        }else{
            this.show = print;
        }
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public void setPrint(String print,boolean isCDATA) {
        if(isCDATA){
            this.print = "<![CDATA[" + print+ "]]>";;
        }else{
            this.print = print;
        }
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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

    @Override
    public String toString() {
        return "PosBack{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDes='" + responseDes + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amt='" + amt + '\'' +
                ", show='" + show + '\'' +
                ", print='" + print + '\'' +
                ", ext='" + ext + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                '}';
    }
}
