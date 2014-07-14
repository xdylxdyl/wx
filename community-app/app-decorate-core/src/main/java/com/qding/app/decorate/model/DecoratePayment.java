package com.qding.app.decorate.model;

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
@Table(name = "decorate_payment")
public class DecoratePayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7216130985974618112L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String amount;
	
  	 
    private  String status;
	
  	 
    private  String type;
	
  	 
    private  String remark;
	
  	 
    private  Long decorateId;
	
  	 
    private  Long decorateSerialId;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createBy;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}
	
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
		 	@Column(name = "decorate_id")
	public Long getDecorateId() {
		return decorateId;
	}
	
	
	public void setDecorateId(Long decorateId) {
		this.decorateId = decorateId;
	}
		 	@Column(name = "decorate_serial_id")
	public Long getDecorateSerialId() {
		return decorateSerialId;
	}
	
	
	public void setDecorateSerialId(Long decorateSerialId) {
		this.decorateSerialId = decorateSerialId;
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
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

