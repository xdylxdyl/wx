package com.gemantic.commons.code.cmodel;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CConstant implements Serializable{
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -244699991961235684L;

	private String type;
	private String name;
	private String value;
	private String comment="";
	
	
	
	
	public CConstant(String type, String name, String value,String comment) {
		this.type=type;
		this.name=name;
		this.value=value;
		this.comment=comment;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getValue() {
		return value;
	}





	public void setValue(String value) {
		this.value = value;
	}
	
	


	
	



	public String getComment() {
		return comment;
	}





	public void setComment(String comment) {
		this.comment = comment;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
		
	}
	
	

}
