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
@Table(name = "chat_message")
public class ChatMessage implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244413573033601024L;	
	
	//消息类型 匹配消息规则
	public static final int TYPE_MATCHRULE = 1;
	//消息类型 不匹配消息规则
	public static final int TYPE_NOT_MATCHRULE = 0;
		
	//是否星标消息 0 否
	public static final int STAR_NO = 0;
	//是否星标消息 1 是
	public static final int STAR_YES = 1;
   	 
    private  Long id;
	
  	 
    private  Long publicsID;
	
  	 
    private  String openID;
	
  	 
    private  Long messageId;
	
  	 
    private  String content;
	
  	 
    private  int type;
	
  	 
    private  int star;
	
  	 
    private  Long sendAt;
	
  	 
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
		 	@Column(name = "open_id")
	public String getOpenID() {
		return openID;
	}
	
	
	public void setOpenID(String openID) {
		this.openID = openID;
	}
		 	@Column(name = "message_id")
	public Long getMessageId() {
		return messageId;
	}
	
	
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "type")
	public int getType() {
		return type;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}
		 	@Column(name = "star")
	public int getStar() {
		return star;
	}
	
	
	public void setStar(int star) {
		this.star = star;
	}
		 	@Column(name = "send_at")
	public Long getSendAt() {
		return sendAt;
	}
	
	
	public void setSendAt(Long sendAt) {
		this.sendAt = sendAt;
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

