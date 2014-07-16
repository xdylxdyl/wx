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
@Table(name = "msg_queue")
public class MsgQueue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6286940630603223040L;	
	
		
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
    	
	/**
	 *  处理中
	 * 
	 */
	public static final String STATUS_PROCESSING = "processing";
    	
	/**
	 *  处理完成
	 * 
	 */
	public static final String STATUS_OVER = "over";

	/**
	 * 失败
	 */

	public static final String STATUS_Failure = "failure";
    	
   	 
    private  Long id;
	
  	 
    private  String type;
	
  	 
    private  String content;
	
  	 
    private  Integer checkPoint;
	
  	 
    private  String status;
	
  	 
    private  Integer retryCount;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
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
		 	@Column(name = "check_point")
	public Integer getCheckPoint() {
		return checkPoint;
	}
	
	
	public void setCheckPoint(Integer checkPoint) {
		this.checkPoint = checkPoint;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "retry_count")
	public Integer getRetryCount() {
		return retryCount;
	}
	
	
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
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

