package com.qding.common.pay.bean.ll;

import java.io.Serializable;

/**
* 风控字段（具体字段根据和连连支付风控部门实际沟通确定）
* @author guoyx e-mail:guoyx@lianlian.com
* @date:Dec 16, 2013 9:34:16 AM
* @version :1.0
*
*/
public class RiskItem implements Serializable{
    private static final long serialVersionUID = 1L;
    private String            user_info_bind_phone;
    private String            user_info_dt_register;
    private String            risk_state;
    private String            frms_ware_category;
    public String getUser_info_bind_phone()
    {
        return user_info_bind_phone;
    }
    public void setUser_info_bind_phone(String user_info_bind_phone)
    {
        this.user_info_bind_phone = user_info_bind_phone;
    }
    public String getUser_info_dt_register()
    {
        return user_info_dt_register;
    }
    public void setUser_info_dt_register(String user_info_dt_register)
    {
        this.user_info_dt_register = user_info_dt_register;
    }
    public String getRisk_state()
    {
        return risk_state;
    }
    public void setRisk_state(String risk_state)
    {
        this.risk_state = risk_state;
    }
    public String getFrms_ware_category()
    {
        return frms_ware_category;
    }
    public void setFrms_ware_category(String frms_ware_category)
    {
        this.frms_ware_category = frms_ware_category;
    }
    

}
