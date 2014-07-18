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
@Table(name = "multi_message_relation")
public class MultiMessageRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8897924845088850944L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long groupID;
	
  	 
    private  Long mid;
	
  	 
    private  Long level;
	
  	 
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
		 	@Column(name = "group_id")
	public Long getGroupID() {
		return groupID;
	}
	
	
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}
		 	@Column(name = "mid")
	public Long getMid() {
		return mid;
	}
	
	
	public void setMid(Long mid) {
		this.mid = mid;
	}
		 	@Column(name = "level")
	public Long getLevel() {
		return level;
	}
	
	
	public void setLevel(Long level) {
		this.level = level;
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

