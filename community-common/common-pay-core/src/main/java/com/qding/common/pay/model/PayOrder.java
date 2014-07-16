package com.qding.common.pay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
@Entity
@Table(name = "pay_order")
public class PayOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6993032566570905600L;	
	
		
	/**
	 *  银联支付
	 * 
	 */
	public static final String Type_Unionpay = "unionpay";
    	
   	 
    private  Long id;
	
  	 
    private  String orderNumber;
	
  	 
    private  String type;
	
  	 
    private  Double money;
	
  	 
    private  Long orderTime;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "order_number")
	public String getOrderNumber() {
		return orderNumber;
	}
	
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "money")
	public Double getMoney() {
		return money;
	}
	
	
	public void setMoney(Double money) {
		this.money = money;
	}
		 	@Column(name = "order_time")
	public Long getOrderTime() {
		return orderTime;
	}
	
	
	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

