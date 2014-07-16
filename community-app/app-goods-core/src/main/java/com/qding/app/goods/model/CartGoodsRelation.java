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
@Table(name = "cart_goods_relation")
public class CartGoodsRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2760701697804931072L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long cartID;
	
  	 
    private  Long goodsID;
	
  	 
    private  Integer count;
	
  	 
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
		 	@Column(name = "cart_id")
	public Long getCartID() {
		return cartID;
	}
	
	
	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}
		 	@Column(name = "goods_id")
	public Long getGoodsID() {
		return goodsID;
	}
	
	
	public void setGoodsID(Long goodsID) {
		this.goodsID = goodsID;
	}
		 	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	
	
	public void setCount(Integer count) {
		this.count = count;
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

