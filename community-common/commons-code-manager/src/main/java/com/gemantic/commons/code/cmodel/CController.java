package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141882548254074000L;
	
	
	
	
	private List<CField> fields=new ArrayList();
	private List<CRequest> requests=new ArrayList();	
	
	
	private String controllerClass="DemoController";
	private String controllerPackage="demo.package.controller";
	private String controllerPath="demo\\package\\controller\\DemoController.java";
	
	
	
	
	
	

	public String getControllerClass() {
		return controllerClass;
	}









	public void setControllerClass(String controllerClass) {
		this.controllerClass = controllerClass;
	}









	public String getControllerPackage() {
		return controllerPackage;
	}









	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}









	public String getControllerPath() {
		return controllerPath;
	}









	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
	}

















	public List<CField> getFields() {
		return fields;
	}









	public void setFields(List<CField> fields) {
		this.fields = fields;
	}









	public List<CRequest> getRequests() {
		return requests;
	}









	public void setRequests(List<CRequest> requests) {
		this.requests = requests;
	}









	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	

}
