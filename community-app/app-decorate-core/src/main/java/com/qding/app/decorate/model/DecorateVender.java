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
@Table(name = "decorate_vender")
public class DecorateVender implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1128861955035972608L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long venderId;
	
  	 
    private  String venderName;
	
  	 
    private  int isHveLcense;
	
  	 
    private  String legalName;
	
  	 
    private  String legalIdNumber;
	
  	 
    private  String legalMobile;
	
  	 
    private  String contactName;
	
  	 
    private  String contactIdNumber;
	
  	 
    private  String contactMobile;
	
  	 
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
		 	@Column(name = "vender_id")
	public Long getVenderId() {
		return venderId;
	}
	
	
	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}
		 	@Column(name = "vender_name")
	public String getVenderName() {
		return venderName;
	}
	
	
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
		 	@Column(name = "is_have_license")
	public int getIsHveLcense() {
		return isHveLcense;
	}
	
	
	public void setIsHveLcense(int isHveLcense) {
		this.isHveLcense = isHveLcense;
	}
		 	@Column(name = "legal_name")
	public String getLegalName() {
		return legalName;
	}
	
	
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
		 	@Column(name = "legal_id_number")
	public String getLegalIdNumber() {
		return legalIdNumber;
	}
	
	
	public void setLegalIdNumber(String legalIdNumber) {
		this.legalIdNumber = legalIdNumber;
	}
		 	@Column(name = "legal_mobile")
	public String getLegalMobile() {
		return legalMobile;
	}
	
	
	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}
		 	@Column(name = "contact_name")
	public String getContactName() {
		return contactName;
	}
	
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
		 	@Column(name = "contact_id_number")
	public String getContactIdNumber() {
		return contactIdNumber;
	}
	
	
	public void setContactIdNumber(String contactIdNumber) {
		this.contactIdNumber = contactIdNumber;
	}
		 	@Column(name = "contact_mobile")
	public String getContactMobile() {
		return contactMobile;
	}
	
	
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
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

