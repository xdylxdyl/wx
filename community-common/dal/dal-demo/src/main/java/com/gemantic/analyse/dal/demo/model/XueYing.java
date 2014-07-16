package com.gemantic.analyse.dal.demo.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="xue_ying")
public class XueYing  implements Serializable {
	private static final long serialVersionUID = -6939908111074016367L;
	private String guid;
	private String name;
	private String address;
	private String memo;
	
    @Column(name = "guid")
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
    @Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    @Column(name = "memo")
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	private Long userId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id") 
    public Long getUserId() {
        return userId;
    }

    
	
}
