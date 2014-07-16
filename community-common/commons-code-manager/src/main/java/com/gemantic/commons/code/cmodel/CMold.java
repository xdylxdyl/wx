package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CMold implements Serializable {
	private static final Log log = LogFactory.getLog(CMold.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 4171689387613087907L;
	
	private String home="src\\main\\java\\";
	
	private String modelClass="DemoClass";
	private String modelPackage="demo.package.model";
	private String modelPath="demo\\package\\model\\"+modelClass;
	
	private String interfaceClass="DemoInterface";
	private String interfacePackage="demo.package.service";	
	private String interfacePath="demo/package/service/"+interfaceClass;
	
	
	private String implClass="DemoImpl";
	private String implPackage="demo.package.service.impl";
	private String implPath="demo\\package\\service\\impl\\"+implClass;
	
	
	private String testClass="DemoTest";
	private String testPackage="demo.package.service.impl";
	private String testPath="demo\\package\\service\\impl\\"+implClass;
	
	
	
	
	
	
	
	
	
	private String clientClass="DemoClient";
	private String clientPackage="demo.package.client.impl";
	private String clientPath="demo\\package\\client\\impl\\"+implClass;
	
	
	

	
	
	

	private String service="DemoRMIService";
	private String port="port";
	private String registryName="analyse-demo-service-rmi";

	

	
	

	
	
	
	private Long serialID=RandomUtils.nextLong();
	private String table="demoTable";
	private String seq=this.table+"_seq";
	
	/**
	 * sqls
	 */
	private List<String> sqls=new ArrayList();
	/**
	 * sql,sqlModel
	 */
	private Map<String,CSql> sql_sqlModel=new HashMap();
	/**
	 * 
	 * sql,method
	 */
	private Map<String,CMethod> sql_method=new HashMap();
	
	/**
	 * 需要生成count方法的sql
	 */
	/**
	 * 
	 * sql,method
	 */
	private Map<String,CMethod> count_method=new HashMap();

	

	/**
	 * sql,type(map/list)
	 */
	private Map<String,String> sql_typ=new HashMap();
	
	

	private List<CMethod> defaultMethods=new ArrayList();
	
	/**
	 * fields
	 */
	private List<CField> fields=new ArrayList();
	
	
	/**
	 * name,field
	 */
	private Map<String,Integer> name_findex=new HashMap();
	
	/**
	 * database field name,class name
	 */
	private Map<String,Integer> dname_findex=new HashMap();
	
	/**
	 * 常量
	 * 
	 */
	private List<CConstant> constants=new ArrayList();
	
	
	/**
	 * 是否是自动生成ID
	 */
	private boolean autoID=true;
	
	
	
	public String getModelClass() {
		return modelClass;
	}
	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	
	
	
	
	public Long getSerialID() {
		return serialID;
	}
	public void setSerialID(Long serialID) {
		this.serialID = serialID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getInterfaceClass() {
		return interfaceClass;
	}
	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}
	public String getInterfacePackage() {
		return interfacePackage;
	}
	public void setInterfacePackage(String interfacePackage) {
		this.interfacePackage = interfacePackage;
	}
	
	
	
	
	public List<String> getSqls() {
		return sqls;
	}
	public void setSqls(List<String> sqls) {
		this.sqls = sqls;
	}
	public String capitalize(String key){
	   return 	StringUtils.capitalize(key);
	}
	
	public String uncapitalize(String key){
		return StringUtils.uncapitalize(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<CField> getFields() {
		return fields;
	}
	public void setFields(List<CField> fields) {
		this.fields = fields;
	}
	public Map<String, Integer> getName_findex() {
		return name_findex;
	}
	public void setName_findex(Map<String, Integer> nameFindex) {
		name_findex = nameFindex;
	}
	public Map<String, Integer> getDname_findex() {
		return dname_findex;
	}
	public void setDname_findex(Map<String, Integer> dnameFindex) {
		dname_findex = dnameFindex;
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	public Map<String, CSql> getSql_sqlModel() {
		return sql_sqlModel;
	}
	public void setSql_sqlModel(Map<String, CSql> sqlSqlModel) {
		sql_sqlModel = sqlSqlModel;
	}
	public Map<String, CMethod> getSql_method() {
		return sql_method;
	}
	public void setSql_method(Map<String, CMethod> sqlMethod) {
		sql_method = sqlMethod;
	}
	
	
	
	public CField getFieldByDName(String dname) throws Exception {
		
		try {
			Integer i = this.dname_findex.get(dname);
			return this.fields.get(i);
		} catch (Exception e) {
			log.error(dname+" not exist please check if you set this field ");
			throw new Exception(e);
		}
		
	}
	
	public CField getFieldByCName(String cname) {
		Integer i=this.name_findex.get(cname);
		return this.fields.get(i);
		
	}
	public String getImplClass() {
		return implClass;
	}
	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}
	
	public String getModelPath() {
		return modelPath;
	}
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	public String getInterfacePath() {
		return interfacePath;
	}
	public void setInterfacePath(String interfacePath) {
		this.interfacePath = interfacePath;
	}
	
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public Map<String, String> getSql_typ() {
		return sql_typ;
	}
	public void setSql_typ(Map<String, String> sqlTyp) {
		sql_typ = sqlTyp;
	}


	public String getImplPackage() {
		return implPackage;
	}
	public void setImplPackage(String implPackage) {
		this.implPackage = implPackage;
	}
	public String getImplPath() {
		return implPath;
	}
	public void setImplPath(String implPath) {
		this.implPath = implPath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getClientClass() {
		return clientClass;
	}
	public void setClientClass(String clientClass) {
		this.clientClass = clientClass;
	}
	public String getClientPackage() {
		return clientPackage;
	}
	public void setClientPackage(String clientPackage) {
		this.clientPackage = clientPackage;
	}
	public String getClientPath() {
		return clientPath;
	}
	public void setClientPath(String clientPath) {
		this.clientPath = clientPath;
	}

	
	
	public String getRegistryName() {
		return registryName;
	}
	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}
	
	
	
	
	
	
	
	public String getTestClass() {
		return testClass;
	}
	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}
	public String getTestPackage() {
		return testPackage;
	}
	public void setTestPackage(String testPackage) {
		this.testPackage = testPackage;
	}
	public String getTestPath() {
		return testPath;
	}
	public void setTestPath(String testPath) {
		this.testPath = testPath;
	}
	public List<CMethod> getDefaultMethods() {
		return defaultMethods;
	}
	public void setDefaultMethods(List<CMethod> defaultMethods) {
		this.defaultMethods = defaultMethods;
	}
	
	
	
	
	
	public List<CConstant> getConstants() {
		return constants;
	}
	public void setConstants(List<CConstant> constants) {
		this.constants = constants;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isAutoID() {
		return autoID;
	}
	public void setAutoID(boolean isAutoID) {
		this.autoID = isAutoID;
	}
	/**
	 * 取出给定方法的Mock值.
	 * @param method
	 * @param valueIndex 用于标记取哪一个Mock值
	 * @return
	 */
	public String mockMethodValue(CMethod method,int valueIndex){
		StringBuffer sb=new StringBuffer();
		for(CField mf:method.getParams()){
					String name=mf.getCname();
					Integer index=this.name_findex.get(name);
					if(index==null){					
						//只获取默认值
						sb.append(mf.getValues().get(valueIndex));
					}else{
						CField pfield=this.fields.get(index);	
						sb.append(pfield.getValues().get((valueIndex)));						
					}
					sb.append(",");		
					
		}
		
		String p=sb.toString();
		int pi=p.lastIndexOf(",");				
		return p.substring(0,pi);	
		
	};
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
		
	}
	
	


	public boolean needCache(String sql) {
		boolean result = true;

		if (StringUtils.isBlank(sql)) {
			return false;
		}

		sql = sql.toLowerCase();

		if (sql.indexOf(">") != -1 || sql.indexOf("<") != -1) {
			return false;
		}

		String[] strArr = sql.split("order(\\s+)by");
		if (strArr.length > 1) {
			return false;
		}

		return result;
	}
	public Map<String, CMethod> getCount_method() {
		return count_method;
	}
	public void setCount_method(Map<String, CMethod> count_method) {
		this.count_method = count_method;
	}
	
	
	

	
	
	
	
	
	
	

}
