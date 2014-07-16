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
@Table(name = "gorder_goods_relation")
public class GorderGoodsRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6836247439740052480L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long gorderID;
	
  	 
    private  Long goodsID;
	
  	 
    private  Long categoryID;
	
  	 
    private  String name;
	
  	 
    private  String publishName;
	
  	 
    private  String price;
	
  	 
    private  String originalPrice;
	
  	 
    private  Integer count;
	
  	 
    private  int status;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createAt;
	
  	 
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
		 	@Column(name = "gorder_id")
	public Long getGorderID() {
		return gorderID;
	}
	
	
	public void setGorderID(Long gorderID) {
		this.gorderID = gorderID;
	}
		 	@Column(name = "goods_id")
	public Long getGoodsID() {
		return goodsID;
	}
	
	
	public void setGoodsID(Long goodsID) {
		this.goodsID = goodsID;
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
	
	
	public void setPublishName(String publish_name) {
		this.publishName = publish_name;
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
		 	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
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

