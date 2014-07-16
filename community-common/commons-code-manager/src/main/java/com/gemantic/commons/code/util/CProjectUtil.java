package com.gemantic.commons.code.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.commons.code.cmodel.CController;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;

public class CProjectUtil {
	
	private static final Log log = LogFactory.getLog(CProjectUtil.class);

	public static void init(CProject project) throws Exception {
		CProjectUtil.initBasic(project);
		
		List<CMold> cms=project.getMolds();
		for(CMold cm:cms){
			CMoldUtil.initBasic(cm,project);		 
			CMoldUtil.initFields(cm);
			CMoldUtil.initModelSql(cm);
			CMoldUtil.initMethod(cm);
			
			
		}
		
		/*List<CController>  controllers=project.getControllers();
		for(CController c:controllers){
			
			CControllerUtil.initBasic(c,project);
			CControllerUtil.initRequest(c,project);
		}*/
		
		
		
		
		
		
		log.info(" you will create project =================== ");
		log.info(project);
		log.info(" this project right ? ========================");
		
	}

	public static void initBasic(CProject project) {
		
		
		
		
		
		
		String[] s=project.getArtifactID().split("-");
		
		String keyWord=s[0]+"."+s[1];
		project.setKeyword(keyWord);
	    String packageHome=project.getGroupID()+"."+keyWord;
	    project.setPackageHome(packageHome);
	    
	    
		
		
		project.setServerPackage(packageHome+".server");
		project.setServerPath(project.getPmain()+project.getServerPackage().replace(".", "\\"));
		
		String projectTag=s[0]+StringUtils.capitalize(s[1]);
		
        project.setComponent(StringUtils.capitalize(projectTag)+"Component");  
        
        
        
        project.setDbDNS("db."+keyWord);
        project.setDbName(s[0]+"_"+s[1]);
        project.setCacheDNS("cache."+keyWord);
        
        project.setControllerPath(project.getPmain()+(packageHome+".controller").replace(".", "\\"));
    
       
		
        
        
		
		
	}

}
