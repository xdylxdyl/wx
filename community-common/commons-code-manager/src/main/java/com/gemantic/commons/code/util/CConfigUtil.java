package com.gemantic.commons.code.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gemantic.commons.code.cmodel.CConfig;
import com.gemantic.commons.code.cmodel.CMethod;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CSql;

public class CConfigUtil {

	public static void generateConfigs(CProject project) {
		
		  // log4j		
		mockGetLog4j(project);
		// spring
		mockGetSpring(project);
		
		// reference spring application
		mockReferenceGetSpring(project);
		
		
		
		//spring-home
		mockGetSpringHome(project);
		
		// server composite
		mockGetServerComposite(project);
		
		
		// reference server composite
		//mockGetReferenceServerComposite(project);
		
		
		
		// client composite
		mockGetClientComposite(project);
		
		//group.xml
		mockGetGroup(project);
		
		//daoConfig
		mockGetDaoConfig(project);
		
		//daoModel
		mockGetModelConfig(project);
		
		//memcacheClient
		mockGetMemcacheClient(project);
		
		//tiles
		mockGetTiles(project);
		
		
		//module sql
		mockGetModuleSql(project);
		
		
		
		
		
		
	}


	private static void mockGetModuleSql(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("modules.sql");
		config.setPvelocity("velocity/db/module.vm");
	
		config.setFilePath("src\\main\\resources\\dbscript\\");
		configs.add(config);
	}


	public static void mockGetTiles(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("tiles.xml");
		config.setPvelocity("velocity/tiles/tiles.vm");
	
		config.setFilePath("src\\main\\webapp\\WEB-INF\\");
		configs.add(config);
		
	}


	public static void mockReferenceGetSpring(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("applicationContext-reference.xml");
		config.setPvelocity("velocity/config/spring_reference.vm");
		config.setRelativePath("META-INF\\"+project.getArtifactID()+"\\");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}


	public static void mockGetReferenceServerComposite(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("reference.composite");
		config.setPvelocity("velocity/config/reference_composite.vm");
		config.setRelativePath("META-INF\\"+project.getArtifactID()+"\\");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}


	public static void mockGetSpringHome(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("applicationContext-client.xml");
		config.setPvelocity("velocity/config/spring_home.vm");
		config.setRelativePath("META-INF\\"+project.getArtifactID()+"\\");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
		
		
	}


	public static void mockGetMemcacheClient(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("memcached_client.xml");
		config.setPvelocity("velocity/config/memcache.vm");
		config.setRelativePath("");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}




	public static void mockGetModelConfig(CProject project) {
		List<CConfig> configs=project.getConfigs();	
		for(CMold mold:project.getMolds()){
			CConfig config=new CConfig();
			config.setName(StringUtils.uncapitalize(mold.getModelClass())+"_dao.xml");
			config.setPvelocity("velocity/config/modelConfig.vm");
			config.setRelativePath("");
			config.setFilePath(project.getPmresource()+config.getRelativePath());			
			config.setMold(mold);
			List<CMethod> lists=new ArrayList();
			List<CMethod> maps= new ArrayList();
			
			for(String sql:mold.getSql_method().keySet()){
				CMethod cm=mold.getSql_method().get(sql);
				if(CSql.Sql_Type_List.equals(cm.getType())){
					lists.add(cm);
				}else{
					maps.add(cm);
				}
			}

           config.setListMethods(lists);
           config.setMapMethods(maps);
			
			configs.add(config);
		}
		
		
		
	}




	public static void mockGetDaoConfig(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("daoConfig.xml");
		config.setPvelocity("velocity/config/daoConfig.vm");
		config.setRelativePath("");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}




	public static void mockGetGroup(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("group.xml");
		config.setPvelocity("velocity/config/group.vm");
		config.setRelativePath("");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}




	public static void mockGetServerComposite(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("server.composite");
		config.setPvelocity("velocity/config/server_composite.vm");
		config.setRelativePath("META-INF\\"+project.getArtifactID()+"\\");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}
	public static void mockGetClientComposite(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("client.composite");
		config.setPvelocity("velocity/config/client_composite.vm");
		config.setRelativePath("");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}
	
	

	public static void mockGetSpring(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("applicationContext-server.xml");
		config.setPvelocity("velocity/config/spring.vm");
		config.setRelativePath("META-INF\\"+project.getArtifactID()+"\\");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}

	public static void mockGetLog4j(CProject project) {
		List<CConfig> configs=project.getConfigs();		
		CConfig config=new CConfig();
		
		config.setName("log4j.properties");
		config.setPvelocity("velocity/config/log4j.vm");
		config.setRelativePath("");
		config.setFilePath(project.getPmresource()+config.getRelativePath());
		configs.add(config);
		
	}

	

}
