package com.gemantic.commons.code.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gemantic.commons.code.cmodel.CController;
import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;

public class CControllerUtil {

	public static void initRequest(CController c,CProject project) {
	
		//默认添加Project中的所有的Service
		List<CField> fields=c.getFields();
		for(CMold m:project.getMolds()){			
			CField cf=new CField(StringUtils.uncapitalize(m.getInterfaceClass()),m.getInterfaceClass(), "", "");
			fields.add(cf);
		}
		
		
		
	}

	public static void initBasic(CController c, CProject project) {
		
		//dbname 取自ProjectKeyword 
		c.setControllerClass(StringUtils.capitalize(project.getDbName())+"Controller");
		c.setControllerPackage(project.getPackageHome()+".controller");
		c.setControllerPath(project.getPmain()+c.getControllerPackage().replace(".", "\\"));
	
		
	
		
	
	}

}
