package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6418540637753501686L;
	
	
	private String pvelocity="velocity/config_demo.vm";
	
	private String relativePath="";
	
	private String name="demo_config.xml";
	
	private String filePath="";
	
	private CMold mold;
	
	private List<CMethod> listMethods;
	
	private List<CMethod> mapMethods;
	
	
	
	
	


	public String getPvelocity() {
		return pvelocity;
	}


	public void setPvelocity(String pvelocity) {
		this.pvelocity = pvelocity;
	}
	
	
	
	
	
	
	
	

	public String getRelativePath() {
		return relativePath;
	}


	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
	
	


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
	
	
	
	
	




	public CMold getMold() {
		return mold;
	}


	public void setMold(CMold mold) {
		this.mold = mold;
	}


	public List<CMethod> getListMethods() {
		return listMethods;
	}


	public void setListMethods(List<CMethod> listMethods) {
		this.listMethods = listMethods;
	}


	public List<CMethod> getMapMethods() {
		return mapMethods;
	}


	public void setMapMethods(List<CMethod> mapMethods) {
		this.mapMethods = mapMethods;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
