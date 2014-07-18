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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "puser")
public class Puser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849269478454347776L;

	/**
	 * 启用
	 * 
	 */
	public static final String STATUS_USING = "using";

	/**
	 * 停用
	 * 
	 */
	public static final String STATUS_STOPPED = "stopped";

	/**
	 * 重置
	 * 
	 */
	public static final String RESET = "reset";

	private Long id;

	private String name;

	private String nick;

	private String pwd;

	private Long roleID;

	private String status;

	private Long updateAt;

	private Long updateBy;

	private Long createAt;

	private Long createBy;

	private String relationIds;

	private Integer publicsNumber;

	@Transient
	public String getRelationIds() {
		return relationIds;
	}

	public void setRelationIds(String relationIds) {
		this.relationIds = relationIds;
	}

	@Transient
	public Integer getPublicsNumber() {
		return publicsNumber;
	}

	public void setPublicsNumber(Integer publicsNumber) {
		this.publicsNumber = publicsNumber;
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nick")
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "role_id")
	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
