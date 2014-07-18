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
@Table(name = "rule")
public class Rule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2298273278061551616L;

	public static final String Default_Message = "default";
	public static final String Welcome_Message = "welcome";
	public static final String Normal_Message = "normal";
	public static final String Text_Message = "text";
	public static final String Url_Message = "url";
	public static final String Single_Message = "single";
	public static final String Multi_Message_Head = "multi_head";
	public static final String Multi_Message_Item = "multi_item";

	private Long id;

	private String name;

	private Long mid;

	private Long publicsID;

	private String defaultMessage;

	private String welcomeMessage;

	private String type;

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

	@Column(name = "mid")
	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}

	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}

	@Column(name = "default_message")
	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String default_message) {
		this.defaultMessage = default_message;
	}

	@Column(name = "welcome_message")
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcome_message) {
		this.welcomeMessage = welcome_message;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
