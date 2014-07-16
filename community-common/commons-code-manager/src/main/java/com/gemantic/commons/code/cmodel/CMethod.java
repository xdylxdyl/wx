package com.gemantic.commons.code.cmodel;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8304569974942035561L;

	private String name;
	private List<CField> params;
	private CField returnField;
	private String type = CSql.Sql_Type_List;
	private String sql;
	private String pimpl;
	private String imp;
	private String test;
	private String ptest;
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CField> getParams() {
		return params;
	}

	public void setParams(List<CField> params) {
		this.params = params;
	}

	public CField getReturnField() {
		return returnField;
	}

	public void setReturnField(CField returnField) {
		this.returnField = returnField;
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

	public String methodParam() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
			param.append(p.getCtype());
			param.append(" ");
			//param.append(p.getCname());
			String paramName = StringUtils.isBlank(p.getFuncParamName()) ? p.getCname() : p.getFuncParamName();
			param.append(paramName);
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	
	
	public String methodLog() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
		
			//param.append(p.getCname());
			param.append(StringUtils.isBlank(p.getFuncParamName()) ? p.getCname() : p.getFuncParamName());
			param.append("+\" , \"+");

		}

		String p=param.toString();
		int pi=p.lastIndexOf("+\" , \"+");
		
		return p.substring(0,pi);
	}
	
	public String methodNoPageSizeParam() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
		
			if("start".equals(p.getCname())||"limit".equals(p.getCname())){
				continue;
			}
			param.append(p.getCtype());
			param.append(" ");
			//param.append(p.getCname());
			String paramName = StringUtils.isBlank(p.getFuncParamName()) ? p.getCname() : p.getFuncParamName();
			param.append(paramName);
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		if(pi>0){
			return p.substring(0,pi);
		}else{
			return p;
		}
		
	}
	
	

	public String daoParam() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {			
			param.append(p.getCname());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}

	public String daoParamForListMethod() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {			
			param.append(StringUtils.isBlank(p.getFuncParamName()) ? p.getCname() : p.getFuncParamName());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	
	public String daoNoPageSizeParam() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
			if("start".equals(p.getCname())||"limit".equals(p.getCname())){
				continue;
			}
			
			param.append(p.getCname());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	public String daoNoPageSizeParamForListMethod() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
			if("start".equals(p.getCname())||"limit".equals(p.getCname())){
				continue;
			}
			
			param.append(StringUtils.isBlank(p.getFuncParamName()) ? p.getCname() : p.getFuncParamName());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	public String daoNoPageSizeDBParam() {
		StringBuffer param = new StringBuffer();		
		for (CField p :params) {
			if("start".equals(p.getCname())||"limit".equals(p.getCname())){
				continue;
			}
			
			param.append(p.getDname());
			param.append(",");

		}

		String p=param.toString();
		int pi=p.lastIndexOf(",");
		
		return p.substring(0,pi);
	}
	
	public String replaceSqlGtLt(String sql) {
		if (StringUtils.isBlank(sql)) {
			return "";
		} else {
			return sql.replaceAll(">", "&gt;").replaceAll("<", "&lt;");
		}
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getImp() {
		return imp;
	}

	public void setImp(String imp) {
		this.imp = imp;
	}

	public String getPimpl() {
		return pimpl;
	}

	public void setPimpl(String pimpl) {
		this.pimpl = pimpl;
	}
	
	

	public String getPtest() {
		return ptest;
	}

	public void setPtest(String ptest) {
		this.ptest = ptest;
	}
	
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
