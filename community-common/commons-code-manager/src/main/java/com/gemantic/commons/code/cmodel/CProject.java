package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3182285254180144934L;
	
	private String component="DemoCompoent";
	
	private String dbName="demoDB";
	private String dbDNS="db.demoDB";
	private String cacheDNS="cache.demo";
	
	
	
	
	private String pmain="src\\main\\java\\";
	private String pmresource="src\\main\\resources\\";
	private String dbresource="src\\main\\resources\\dbscript\\";
	private String ptest="src\\test\\java\\";
	private String ptreousrce="src\\test\\resources\\";
	private String pmeta="META-INF\\demo-package-server\\";
	
	
	
	
	
	private String artifactID="demo-code";
	private String groupID="com.qding";
	private String version="1.0-SNAPSHOT";
	private String packageHome="com.qding";
	private String keyword="";
	
	private List<CMold> molds=new ArrayList();
	
	
	
	
	private String serverClass="Server";
	private String serverPackage="demo.server";
	private String serverPath="demo\\package\\server\\"+serverClass;
	
	private String jspPath="src\\main\\webapp\\WEB-INF\\pages\\";

	private String jsPath="src\\main\\webapp\\r\\js-src\\web\\";

	private String jsonPath="src\\main\\webapp\\WEB-INF\\pages\\";
	
	/**
	 * 是否追加在原文件尾.默认是否
	 */
	private boolean append=false;
	
	
	
	
	
	
	private List<CConfig> configs=new ArrayList<CConfig>();
	
	private List<CReference> references=new ArrayList();
	
	private List<CController> controllers=new ArrayList();
	
	
	
	
	private String controllerClass="DemoController";
	private String controllerPackage="demo.package.controller";
	private String controllerPath="demo\\package\\controller\\DemoController.java";
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getJsPath() {
		return jsPath;
	}
	public void setJsPath(String jsPath) {
		this.jsPath = jsPath;
	}
	public String getJsonPath() {
		return jsonPath;
	}
	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}
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
	public List<CController> getControllers() {
		return controllers;
	}
	public void setControllers(List<CController> controllers) {
		this.controllers = controllers;
	}
	public String getArtifactID() {
		return artifactID;
	}
	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<CMold> getMolds() {
		return molds;
	}
	public void setMolds(List<CMold> molds) {
		this.molds = molds;
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getServerClass() {
		return serverClass;
	}
	public void setServerClass(String serverClass) {
		this.serverClass = serverClass;
	}
	public String getServerPackage() {
		return serverPackage;
	}
	public void setServerPackage(String serverPackage) {
		this.serverPackage = serverPackage;
	}
	public String getServerPath() {
		return serverPath;
	}
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getPmain() {
		return pmain;
	}
	public void setPmain(String pmain) {
		this.pmain = pmain;
	}
	public String getPmresource() {
		return pmresource;
	}
	public void setPmresource(String pmresource) {
		this.pmresource = pmresource;
	}	
	public String getDbresource() {
		return dbresource;
	}
	public void setDbresource(String dbresource) {
		this.dbresource = dbresource;
	}
	public String getPtest() {
		return ptest;
	}
	public void setPtest(String ptest) {
		this.ptest = ptest;
	}
	public String getPtreousrce() {
		return ptreousrce;
	}
	public void setPtreousrce(String ptreousrce) {
		this.ptreousrce = ptreousrce;
	}
	public String getPmeta() {
		return pmeta;
	}
	public void setPmeta(String pmeta) {
		this.pmeta = pmeta;		
	}
	
	
	
	public List<CConfig> getConfigs() {
		return configs;
	}
	public void setConfigs(List<CConfig> configs) {
		this.configs = configs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbDNS() {
		return dbDNS;
	}
	public void setDbDNS(String dbDNS) {
		this.dbDNS = dbDNS;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
		
	}
	
	
	
	
	public String getCacheDNS() {
		return cacheDNS;
	}
	public void setCacheDNS(String cacheDNS) {
		this.cacheDNS = cacheDNS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getPackageHome() {
		return packageHome;
	}
	public void setPackageHome(String packageHome) {
		this.packageHome = packageHome;
	}
	
	
	
	
	
	
	
	public boolean isAppend() {
		return append;
	}
	public void setAppend(boolean append) {
		this.append = append;
	}
	public List<CReference> getReferences() {
		return references;
	}
	public void setReferences(List<CReference> references) {
		this.references = references;
	}
	
	
	
	
	public String getJspPath() {
		return jspPath;
	}
	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
