package com.qding.app.goods.model;

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
@Table(name = "goods")
public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2504699799364989952L;	
	
		
	/**
	 *  显示
	 * 
	 */
	public static final Integer Comment_Status_Show = 0;
    	
	/**
	 *  隐藏
	 * 
	 */
	public static final Integer Comment_Status_Hide = 1;

	

	//受理中（自动生成：当订单状态为“已付全款”，则货品状态从“受理中”开始）
	public static final int Status_Dealling = 1;
	//已到货
	public static final int Status_Arrival = 2;
	//已签收（人工处理。触发模板消息：前端设计书<团购>20-G3-02 ）
	public static final int Status_Received= 3;
	//退货申请中（人工处理）
	public static final int Status_Req_Returning= 4;
	//已退货（人工处理）
	public static final int Status_Returned = 5;	
	//换货申请中（人工处理）
	public static final int Status_Changing = 6;
	//已换货（人工处理）
	public static final int Status_Changed = 7;	
	
    private  Long id;
	
  	 
    private  Long providerID;
	
  	 
    private  Long categoryID;
	
  	 
    private  String name;
	
  	 
    private  String publishName;
	
  	 
    private  String price;
	
  	 
    private  String originalPrice;
	
  	 
    private  Integer count;
	
  	 
    private  String img;
	
  	 
    private  String detail;
	
  	 
    private  String comment;
	
  	 
    private  int commentStatus;
	
  	 
    private  Long publishStart;
	
  	 
    private  Long publishEnd;
	
  	 
    private  int status;
	
  	 
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
		 	@Column(name = "provider_id")
	public Long getProviderID() {
		return providerID;
	}
	
	
	public void setProviderID(Long providerID) {
		this.providerID = providerID;
	}
		 	@Column(name = "category_id")
	public Long getCategoryID() {
		return categoryID;
	}
	
	
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "publish_name")
	public String getPublishName() {
		return publishName;
	}
	
	
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
		 	@Column(name = "price")
	public String getPrice() {
		return price;
	}
	
	
	public void setPrice(String price) {
		this.price = price;
	}
		 	@Column(name = "original_price")
	public String getOriginalPrice() {
		return originalPrice;
	}
	
	
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
		 	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	
	
	public void setCount(Integer count) {
		this.count = count;
	}
		 	@Column(name = "img")
	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}
		 	@Column(name = "detail")
	public String getDetail() {
		return detail;
	}
	
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
		 	@Column(name = "comment")
	public String getComment() {
		return comment;
	}
	
	
	public void setComment(String comment) {
		this.comment = comment;
	}
		 	@Column(name = "comment_status")
	public int getCommentStatus() {
		return commentStatus;
	}
	
	
	public void setCommentStatus(int commentStatus) {
		this.commentStatus = commentStatus;
	}
		 	@Column(name = "publish_start")
	public Long getPublishStart() {
		return publishStart;
	}
	
	
	public void setPublishStart(Long publishStart) {
		this.publishStart = publishStart;
	}
		 	@Column(name = "publish_end")
	public Long getPublishEnd() {
		return publishEnd;
	}
	
	
	public void setPublishEnd(Long publishEnd) {
		this.publishEnd = publishEnd;
	}
		 	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
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

