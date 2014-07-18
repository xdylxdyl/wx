package com.qding.framework.publics.model;

import javax.persistence.*;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 常量
 * @author TaoMingkai
 * @version 1.0
 * @since 2014/6/5 13:53
 */
@Entity
@Table(name = "constants")
public class Constants implements Serializable {

	private static final long serialVersionUID = 1440124095815436288L;

	private long id;

	private String name;

	private String code;

	private String type;

	private long createBy;

	private long createAt;

	private long updateBy;

	private long updateAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "create_by")
	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_at")
	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}

	@Column(name = "update_by")
	public long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "update_at")
	public long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(long updateAt) {
		this.updateAt = updateAt;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
