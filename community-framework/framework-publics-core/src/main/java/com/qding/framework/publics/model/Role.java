package com.qding.framework.publics.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8109355439663838208L;

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

	private Long id;

	private String name;

	private Set<Long> permissionsSet;

	private String permissions;

	private String status;

	private Long updateAt;

	private Long updateBy;

	private Long createAt;

	private Long createBy;

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

	@Column(name = "permissions")
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {

		this.permissions = permissions;

		Gson gson = new GsonBuilder().create();
		permissionsSet = gson.fromJson(this.permissions, new TypeToken<Set<Long>>() {
		}.getType());
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

	@Transient
	public Set<Long> getPermissionsSet() {
		if (StringUtils.isBlank(this.permissions)) {
			return new HashSet();
		} else {
			if (this.permissionsSet == null) {
				Gson gson = new GsonBuilder().create();
				permissionsSet = gson.fromJson(this.permissions, new TypeToken<Set<Long>>() {
				}.getType());

			}
		}
		return permissionsSet;
	}

	public void setPermissionsSet(Set<Long> permissionsSet) {

		this.permissionsSet = permissionsSet;
		Gson gson = new GsonBuilder().create();
		this.permissions = gson.toJson(permissionsSet);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static void main(String[] args) {

		Role r = new Role();
		r.setPermissionsSet(new HashSet(Arrays.asList(new Long[]{3L,4L,5L})));
		System.out.println(r);
		r.setPermissions("[5,6]");
		System.out.println(r);

	}

}
