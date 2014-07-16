package com.qding.common.pay.bean.ll;

import java.io.Serializable;

/**
* 支付信息bean
* @author guoyx
* @date:Jun 24, 2013 3:25:29 PM
* @version :1.0
*
*/
public class PaymentInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String            version;              // 接口版本号
    private String            oid_partner;          // 商户编号
    private String            sign_type;            // 签名方式
    private String            user_id;              // 用户唯一编号
    private String            sign;                 // 签名
    private String            busi_partner;         // 商户业务类型
    private String            no_order;             // 商户唯一订单号
    private String            dt_order;             // 商户订单时间
    private String            name_goods;           // 商品名称
    private String            info_order;           // 订单描述
    private String            money_order;          // 交易金额 单位为RMB-元
    private String            notify_url;           // 服务器异步通知地址
    private String            url_return;           // 支付结束回显url
    private String            pay_type;             // 支付方式 2：快捷支付（借记卡） 3：快捷支付（信用卡）
    private String            bank_code;            // 银行编号
    private String            app_request;          // 请求应用标识 1：Android 2：ios 3：WAP
    private String            valid_order;          // 订单有效时间 分钟为单位，默认为10080分钟（7天）
    private String            risk_item;            // 风险控制参数

    public String getValid_order()
    {
        return valid_order;
    }

    public void setValid_order(String valid_order)
    {
        this.valid_order = valid_order;
    }

    public String getApp_request()
    {
        return app_request;
    }

    public void setApp_request(String app_request)
    {
        this.app_request = app_request;
    }

    public String getOid_partner()
    {
        return oid_partner;
    }

    public void setOid_partner(String oid_partner)
    {
        this.oid_partner = oid_partner;
    }

    public String getSign_type()
    {
        return sign_type;
    }

    public void setSign_type(String sign_type)
    {
        this.sign_type = sign_type;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getBusi_partner()
    {
        return busi_partner;
    }

    public void setBusi_partner(String busi_partner)
    {
        this.busi_partner = busi_partner;
    }

    public String getNo_order()
    {
        return no_order;
    }

    public void setNo_order(String no_order)
    {
        this.no_order = no_order;
    }

    public String getDt_order()
    {
        return dt_order;
    }

    public void setDt_order(String dt_order)
    {
        this.dt_order = dt_order;
    }

    public String getName_goods()
    {
        return name_goods;
    }

    public void setName_goods(String name_goods)
    {
        this.name_goods = name_goods;
    }

    public String getInfo_order()
    {
        return info_order;
    }

    public void setInfo_order(String info_order)
    {
        this.info_order = info_order;
    }

    public String getMoney_order()
    {
        return money_order;
    }

    public void setMoney_order(String money_order)
    {
        this.money_order = money_order;
    }

    public String getNotify_url()
    {
        return notify_url;
    }

    public void setNotify_url(String notify_url)
    {
        this.notify_url = notify_url;
    }

    public String getUrl_return()
    {
        return url_return;
    }

    public void setUrl_return(String url_return)
    {
        this.url_return = url_return;
    }

    public String getPay_type()
    {
        return pay_type;
    }

    public void setPay_type(String pay_type)
    {
        this.pay_type = pay_type;
    }

    public String getBank_code()
    {
        return bank_code;
    }

    public void setBank_code(String bank_code)
    {
        this.bank_code = bank_code;
    }

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getRisk_item()
    {
        return risk_item;
    }

    public void setRisk_item(String risk_item)
    {
        this.risk_item = risk_item;
    }

}
