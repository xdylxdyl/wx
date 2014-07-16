package com.gemantic.commons.code.cmodel;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CReference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761373279663261967L;


	private String name;
	private String interfaceName;
    private String registryName;
    private String serviceName;
    
    
    
    
	public CReference(String name, String interfaceName, String registryName, String serviceName) {
		this.name=name;
		this.interfaceName=interfaceName;
		this.registryName=registryName;		
		this.serviceName=serviceName;
	}
	
	
	
	
	

    
    
	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getInterfaceName() {
		return interfaceName;
	}








	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}








	public String getRegistryName() {
		return registryName;
	}








	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}








	public String getServiceName() {
		return serviceName;
	}








	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}








	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
		
	}
    
	
	

}
