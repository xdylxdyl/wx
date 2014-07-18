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
@Table(name = "menu")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2731271367737057280L;

	private Long id;

	private Long publicsID;

	private String menu;

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

	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}

	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}

	@Column(name = "menu")
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
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
