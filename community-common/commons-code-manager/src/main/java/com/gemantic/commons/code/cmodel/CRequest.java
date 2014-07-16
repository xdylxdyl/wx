package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1664332143257003842L;
	
	
	private String url;
	private List<CField> params;
	private String impl;
	private String returnPath;
	private String name;
	private CMold mold;
	
	
	
	
	
	
	
	
	public CRequest(String url, String name, List<CField> params, String returnPath) {
		this.url=url;
		this.name=name;
		this.params=params;
		this.returnPath=returnPath;		
		
	}








	public String getUrl() {
		return url;
	}








	public void setUrl(String url) {
		this.url = url;
	}








	public List<CField> getParams() {
		return params;
	}








	public void setParams(List<CField> params) {
		this.params = params;
	}








	public String getImpl() {
		return impl;
	}








	public void setImpl(String impl) {
		this.impl = impl;
	}








	public String getReturnPath() {
		return returnPath;
	}








	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}
	
	








	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}
	
	



	
















	public CMold getMold() {
		return mold;
	}








	public void setMold(CMold mold) {
		this.mold = mold;
	}








	public String methodParam() {
		if(params.size()==0){
			return "";
		}
		
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
			param.append(p.getCtype());
			param.append(" ");
			param.append(p.getCname());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	
	public String methodLog() {
		
		if(params.size()==0){
			return "";
		}
		
		
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
		
			param.append(p.getCname());
			param.append("+\" , \"+");

		}

		String p=param.toString();
		int pi=p.lastIndexOf("+\" , \"+");
		
		return p.substring(0,pi);
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
				
	}

}
