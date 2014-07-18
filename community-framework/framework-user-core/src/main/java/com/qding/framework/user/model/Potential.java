package com.qding.framework.user.model;

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
@Table(name = "potential")
public class Potential implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8550561601525979136L;

	//关注
	public static final int STATUS_SUBSCRIBE = 0;
	//取消关注
	public static final int STATUS_UNSUBSCRIBE = 0;
	
	
	private Long id;

	private String nick;

	private String sex;

	private String type;

	private String img;

	private Long publicsID;

	private String openID;

	private String fakeID;

	private Long loginAt;

	private Long lastLoginAt;

	private Long createBy;

	private Long updateBy;

	private Long updateAt;

	private Long createAt;
	private Long unsubscribeAt;
	
	private int status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 	@Column(name = "status")
 	public int getStatus() {
 		return status;
 	}
 	public void setStatus(int status) {
 		this.status = status;
 	}
	
	@Column(name = "nick")
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	@Column(name = "fake_id")
	public String getFakeID() {
		return fakeID;
	}

	public void setFakeID(String fakeID) {
		this.fakeID = fakeID;
	}

	@Column(name = "login_at")
	public Long getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(Long loginAt) {
		this.loginAt = loginAt;
	}

	@Column(name = "last_login_at")
	public Long getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Long lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
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
	
	@Column(name = "unsubscribe_at")
	public Long getUnsubscribeAt() {
		return unsubscribeAt;
	}

	public void setUnsubscribeAt(Long unsubscribeAt) {
		this.unsubscribeAt = unsubscribeAt;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
