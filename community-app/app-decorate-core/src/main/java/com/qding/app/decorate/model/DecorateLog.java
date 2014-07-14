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
@Table(name = "decorate_log")
public class DecorateLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 542132268358697984L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long decorateId;
	
    private String filed;
    
    private String beforeValue;
    
    private String afterValue;
  	
    private  String status;
	
  	 
    private  String description;
	
  	 
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
		 	@Column(name = "decorate_id")
	public Long getDecorateId() {
		return decorateId;
	}
	
	
	public void setDecorateId(Long decorateId) {
		this.decorateId = decorateId;
	}
	
	
	


 	@Column(name = "filed")
	public String getFiled() {
		return filed;
	}


	public void setFiled(String filed) {
		this.filed = filed;
	}

 	@Column(name = "before_value")
	public String getBeforeValue() {
		return beforeValue;
	}


	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}

 	@Column(name = "after_value")
	public String getAfterValue() {
		return afterValue;
	}


	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}


			@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
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

