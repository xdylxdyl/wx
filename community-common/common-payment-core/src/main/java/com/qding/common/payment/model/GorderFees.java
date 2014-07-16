package com.qding.common.payment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "gorder_fees")
public class GorderFees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7006558566490384384L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String gorderCode;
	
  	 
    private  Long publicsId;
	
  	 
    private  Long paddressId;
	
  	 
    private  int type;
	
  	 
    private  String fee;
	
  	 
    private  Long paymentTypeId;
	
  	 
    private  int status;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "gorder_code")
	public String getGorderCode() {
		return gorderCode;
	}
	
	
	public void setGorderCode(String gorderCode) {
		this.gorderCode = gorderCode;
	}
		 	@Column(name = "publics_id")
	public Long getPublicsId() {
		return publicsId;
	}
	
	
	public void setPublicsId(Long publicsId) {
		this.publicsId = publicsId;
	}
		 	@Column(name = "paddress_id")
	public Long getPaddressId() {
		return paddressId;
	}
	
	
	public void setPaddressId(Long paddressId) {
		this.paddressId = paddressId;
	}
		 	@Column(name = "type")
	public int getType() {
		return type;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}
		 	@Column(name = "fee")
	public String getFee() {
		return fee;
	}
	
	
	public void setFee(String fee) {
		this.fee = fee;
	}
		 	@Column(name = "payment_type_id")
	public Long getPaymentTypeId() {
		return paymentTypeId;
	}
	
	
	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
		 	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

