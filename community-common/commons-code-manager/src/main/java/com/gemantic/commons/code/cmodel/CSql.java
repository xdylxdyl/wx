package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CSql implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4719175634904060440L;	
	private String table;
	private List<String> conditions;
	private String returns;
    private List<String> orderByFields;
	private String sql;
    private String type;
    
	public static final String Sql_Type_Map = "map";
	public static final String Sql_Type_List = "list";
    
    private Map<String, List<String>> conditionKeyParamPrefixValueMap;

    public Map<String, List<String>> getConditionKeyParamPrefixValueMap() {
		return conditionKeyParamPrefixValueMap;
	}
	public void setConditionKeyParamPrefixValueMap(Map<String, List<String>> conditionKeyParamPrefixValueMap) {
		this.conditionKeyParamPrefixValueMap = conditionKeyParamPrefixValueMap;
	}

	
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	

	public List<String> getConditions() {
		return conditions;
	}
	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}
	
	
	


	
	public String getReturns() {
		return returns;
	}
	public void setReturns(String returns) {
		this.returns = returns;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> getOrderByFields() {
		return orderByFields;
	}
	public void setOrderByFields(List<String> orderByFields) {
		this.orderByFields = orderByFields;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	
	
	
	
	
	
	



}
