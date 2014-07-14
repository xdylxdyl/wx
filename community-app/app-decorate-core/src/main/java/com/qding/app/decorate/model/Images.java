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
@Table(name = "images")
public class Images implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275491616201686016L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String originalPath;
	
  	 
    private  String bigPath;
	
  	 
    private  String middlePath;
	
  	 
    private  String smallPath;
	
  	 
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
		 	@Column(name = "original_path")
	public String getOriginalPath() {
		return originalPath;
	}
	
	
	public void setOriginalPath(String originalPath) {
		this.originalPath = originalPath;
	}
		 	@Column(name = "big_path")
	public String getBigPath() {
		return bigPath;
	}
	
	
	public void setBigPath(String bigPath) {
		this.bigPath = bigPath;
	}
		 	@Column(name = "middle_path")
	public String getMiddlePath() {
		return middlePath;
	}
	
	
	public void setMiddlePath(String middlePath) {
		this.middlePath = middlePath;
	}
		 	@Column(name = "small_path")
	public String getSmallPath() {
		return smallPath;
	}
	
	
	public void setSmallPath(String smallPath) {
		this.smallPath = smallPath;
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

