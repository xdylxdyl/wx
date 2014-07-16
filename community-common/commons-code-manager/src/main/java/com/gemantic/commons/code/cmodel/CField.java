package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CField implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -595833576442650449L;
	
	/**
	 * className
	 */
	private String cname;
	/**
	 * class type
	 */
	private String ctype;
	/**
	 * database field name
	 */
	private String dname;
	
	/**
	 * database field type
	 */
	private String dtype;
	
	/**
	 * value ,used for junit
	 */
	private List<String> values=new ArrayList<String>();

	/**
	 * 作为方法参数时的别名.
	 * 如startXXX, endXXX
	 */
	private String funcParamName;
	
	private String columnNull;		
	
	private String comment;
	
	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CField(String cname, String ctype, String dname, String dtype) {
		super();
		this.cname = cname;
		this.dname = dname;
		this.ctype = ctype;
		this.dtype = dtype;
	}
	
	public CField(String cname, String ctype, String dname, String dtype, String columnNull) {
		this(cname, ctype, dname, dtype);
		this.columnNull= columnNull;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
	public String getFuncParamName() {
		return funcParamName;
	}
	public void setFuncParamName(String funcParamName) {
		this.funcParamName = funcParamName;
	}	
	public String getColumnNull() {
		return columnNull;
	}
	public void setColumnNull(String columnNull) {
		this.columnNull = columnNull;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	public void addValue(String value) {
		this.values.add(value);
		
		
	}
	

	public CField clone() throws CloneNotSupportedException {
		CField returnObj = (CField) super.clone();
		returnObj.values = (List<String>)((ArrayList<String>)this.values).clone();
		return returnObj;
	}
}
