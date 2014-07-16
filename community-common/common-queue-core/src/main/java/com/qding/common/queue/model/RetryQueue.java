package com.qding.common.queue.model;

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
@Table(name = "retry_queue")
public class RetryQueue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3076042394895204352L;	
	
		
	/**
	 *  短信
	 * 
	 */
	public static final String TYPE_SMS = "sms";
    	
	/**
	 *  邮件
	 * 
	 */
	public static final String TYPE_EMAIL = "email";
    	
	/**
	 *  微信
	 * 
	 */
	public static final String TYPE_WEIXIN = "weixin";
    	
   	 
    private  Long id;
	
  	 
    private  String type;
	
  	 
    private  String content;
	
  	 
    private  Integer retryCount;
	
  	 
    private  String targetID;
	
  	 
    private  Long queueID;
	
  	 
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
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "retry_count")
	public Integer getRetryCount() {
		return retryCount;
	}
	
	
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
		 	@Column(name = "target_id")
	public String getTargetID() {
		return targetID;
	}
	
	
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
		 	@Column(name = "queue_id")
	public Long getQueueID() {
		return queueID;
	}
	
	
	public void setQueueID(Long queueID) {
		this.queueID = queueID;
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

