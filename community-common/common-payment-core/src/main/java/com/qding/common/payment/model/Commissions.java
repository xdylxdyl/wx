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
@Table(name = "commissions")
public class Commissions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6593515616973678592L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String gorderCode;
	
  	 
    private  String feeAmount;
	
  	 
    private  String actualAmount;
	
  	 
    private  String commissionsAmount;
	
  	 
    private  int type;
	
  	 
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
		 	@Column(name = "fee_amount")
	public String getFeeAmount() {
		return feeAmount;
	}
	
	
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
		 	@Column(name = "actual_amount")
	public String getActualAmount() {
		return actualAmount;
	}
	
	
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
		 	@Column(name = "commissions_amount")
	public String getCommissionsAmount() {
		return commissionsAmount;
	}
	
	
	public void setCommissionsAmount(String commissionsAmount) {
		this.commissionsAmount = commissionsAmount;
	}
		 	@Column(name = "type")
	public int getType() {
		return type;
	}
	
	
	public void setType(int type) {
		this.type = type;
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

