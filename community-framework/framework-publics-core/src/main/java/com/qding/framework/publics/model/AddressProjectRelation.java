package com.qding.framework.publics.model;

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
@Table(name = "address_project_relation")
public class AddressProjectRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3336003134323573760L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long addressID;
	
  	 
    private  Long projectID;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long updateAt;
	
  	 
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
		 	@Column(name = "address_id")
	public Long getAddressID() {
		return addressID;
	}
	
	
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
		 	@Column(name = "project_id")
	public Long getProjectID() {
		return projectID;
	}
	
	
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
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
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
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

