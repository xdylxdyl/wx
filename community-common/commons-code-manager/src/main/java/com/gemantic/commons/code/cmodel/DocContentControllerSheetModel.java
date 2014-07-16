/**
 * 
 */
package com.gemantic.commons.code.cmodel;

import java.util.List;

public class DocContentControllerSheetModel {

	private String url;

	private String methodName;

	private String returnPath;

	private List<CField> paramList;

	private List<String> referenceTableList;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getReturnPath() {
		return returnPath;
	}

	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}

	public List<CField> getParamList() {
		return paramList;
	}

	public void setParamList(List<CField> paramList) {
		this.paramList = paramList;
	}

	public List<String> getReferenceTableList() {
		return referenceTableList;
	}

	public void setReferenceTableList(List<String> referenceTableList) {
		this.referenceTableList = referenceTableList;
	}
}
