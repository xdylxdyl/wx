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
@Table(name = "rule_keywords_relation")
public class RuleKeywordsRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6334916306221475840L;

	private Long id;

	private String keywords;

	private Long publicsID;

	private Long rid;

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

	@Column(name = "keywords")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}

	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}

	@Column(name = "rid")
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
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
