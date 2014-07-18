package com.qding.framework.publics.model;

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
@Table(name = "message")
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 252994415845132288L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String title;
	
  	 
    private  String description;
	
  	 
    private  String content;
	
  	 
    private  String url;
	
  	 
    private  String img;
	
  	 
    private  String type;
	
  	 
    private  Long publicsID;
	
  	 
    private  String status;
	
  	 
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
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "decription")
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
		 	@Column(name = "img")
	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}
	
	
	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
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

