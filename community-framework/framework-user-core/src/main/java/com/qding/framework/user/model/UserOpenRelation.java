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
@Table(name = "user_open_relation")
public class UserOpenRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104187295148148736L;

	/**
	 * 微信OpenID
	 * 
	 */
	public static final String Type_WX_OpenID = "wx_openID";

	/**
	 * 手机号
	 * 
	 */
	public static final String Type_Mobile = "mobile";

	/**
	 * 微信FakeID
	 * 
	 */
	public static final String Type_WX_FakeID = "wx_fakeID";

	private Long id;

	private Long uid;

	private String openID;

	private Long publicsID;

	private String type;

	private Long createBy;

	private Long updateBy;

	private Long updateAt;

	private Long createAt;

	public UserOpenRelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserOpenRelation(Long uid, String openID, Long publicsID, String type) {
		this.uid = uid;
		this.openID = openID;
		this.publicsID = publicsID;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "uid")
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	@Column(name = "open_id")
	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}

	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
