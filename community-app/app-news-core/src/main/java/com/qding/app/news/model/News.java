package com.qding.app.news.model;

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
@Table(name = "news")
public class News implements Serializable{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 8720408428916847616L;	
	
		
	/**
	 *  已发布
	 * 
	 */
	public static final String Status_Released = "isreleased";
    	
	/**
	 *  未发布
	 * 
	 */
	public static final String Status_Unreleased = "noreleased";
    	
   	 
    private  Long id;
	
  	 
    private  Long publicsID;
	
  	 
    private  String title;
	
  	 
    private  String summary;
	
  	 
    private  String content;
	
  	 
    private  String img;
	
  	 
    private  Long templateType;
	
  	 
    private  String status;
	
  	 
    private  String author;
	
  	 
    private  Long releaseat;
	
  	 
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
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "summary")
	public String getSummary() {
		return summary;
	}
	
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "img")
	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}
		 	@Column(name = "template_type")
	public Long getTemplateType() {
		return templateType;
	}
	
	
	public void setTemplateType(Long templateType) {
		this.templateType = templateType;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "author")
	public String getAuthor() {
		return author;
	}
	
	
	public void setAuthor(String author) {
		this.author = author;
	}
		 	@Column(name = "release_at")
	public Long getReleaseat() {
		return releaseat;
	}
	
	
	public void setReleaseat(Long releaseat) {
		this.releaseat = releaseat;
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

