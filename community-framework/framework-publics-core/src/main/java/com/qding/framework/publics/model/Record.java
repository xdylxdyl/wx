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
@Table(name = "record")
public class Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7418467796119777280L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long publicsID;
	
  	 
    private  Long objectID;
	
  	 
    private  String module;
	
  	 
    private  int type;
	
  	 
    private  String content;
	
  	 
    private  Long createBy;
	
  	 
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
		 	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}
	
	
	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}
		 	@Column(name = "object_id")
	public Long getObjectID() {
		return objectID;
	}
	
	
	public void setObjectID(Long objectID) {
		this.objectID = objectID;
	}
		 	@Column(name = "module")
	public String getModule() {
		return module;
	}
	
	
	public void setModule(String module) {
		this.module = module;
	}
		 	@Column(name = "type")
	public int getType() {
		return type;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
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

