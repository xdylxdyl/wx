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
@Table(name = "decorate_vender_user")
public class DecorateVenderUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 873362375647014912L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long venderId;
	
  	 
    private  String venderName;
	
  	 
    private  String userName;
	
  	 
    private  String userIdNumber;
	
  	 
    private  String userMobile;
	
  	 
    private  String userMobile1;
	
  	 
    private  String userMobile2;
	
  	 
    private  String userEmail;
	
  	 
    private  String userQq;
	
  	 
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
		 	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
		 	@Column(name = "user_id_number")
	public String getUserIdNumber() {
		return userIdNumber;
	}
	
	
	public void setUserIdNumber(String userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
		 	@Column(name = "user_mobile")
	public String getUserMobile() {
		return userMobile;
	}
	
	
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
		 	@Column(name = "user_mobile1")
	public String getUserMobile1() {
		return userMobile1;
	}
	
	
	public void setUserMobile1(String userMobile1) {
		this.userMobile1 = userMobile1;
	}
		 	@Column(name = "user_mobile2")
	public String getUserMobile2() {
		return userMobile2;
	}
	
	
	public void setUserMobile2(String userMobile2) {
		this.userMobile2 = userMobile2;
	}
		 	@Column(name = "user_email")
	public String getUserEmail() {
		return userEmail;
	}
	
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
		 	@Column(name = "user_qq")
	public String getUserQq() {
		return userQq;
	}
	
	
	public void setUserQq(String userQq) {
		this.userQq = userQq;
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

