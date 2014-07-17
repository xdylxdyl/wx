package com.gemantic.code.generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.commons.code.cmodel.CConstant;
import com.gemantic.commons.code.cmodel.CController;
import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CReference;
import com.gemantic.commons.code.cmodel.CRequest;
import com.gemantic.commons.code.cmodel.CSql;
import com.gemantic.commons.code.util.CProjectUtil;

public class MockUtil {
	private static final Log log = LogFactory.getLog(MockUtil.class);
	

	






	public static CProject mockGetProject() throws Exception {
		
		CProject project=new CProject();
		//=========创建Project============
		project.setArtifactID("analyse-convert-service");
		
		
		
		//=========创建Model============forexample~~~~~
		List<CMold> cms=new ArrayList();
		
		//创建多个,可以使用CreateMold2();
		CMold cm=MockUtil.createMold1();		
		cms.add(cm);
		project.setMolds(cms);
		
		
		
		//=========创建Reference============forexample~~~~~
		List<CReference> references=MockUtil.createReferences();
		
		project.setReferences(references);
		
		
		
		//=============创建Controller====forexapmle~~~~~~~~~~~
		
		List<CController> controllers=MockUtil.createController(cm);
		project.setControllers(controllers);
		
		
		
		
		
		
		
		
		//====init====//
		
		CProjectUtil.init(project); 
		return project;
		
		
		
		
	}




	private static List<CController> createController(CMold cm) {
		List<CController> controllers=new ArrayList<CController>();
		CController c=new CController();	
		List<CRequest> requests=new ArrayList();
		
		
		
		List<CField> params=new ArrayList();
		//1.field
		CField cf=new CField("contractID", "String", "", "");
		params.add(cf);
		//2.request
		CRequest r=new CRequest("/prompt/list","getContract",params,"/prompt/prompt");		
		//3.mold
		r.setMold(cm);
		
		
		
		
		
		requests.add(r);		
		c.setRequests(requests);
		
		
		controllers.add(c);		
		return controllers;
	}




	private static List<CReference> createReferences() {
		List<CReference> references=new ArrayList();
		
		CReference e=new CReference("stockService","com.gemantic.analyse.convert.service.StockService","gemantic-analyse-convert-stock-service-rmi","StockRMIService");
		references.add(e);
		return references;
	}




	private static CMold createMold1() {
		List<CField> cfs = new ArrayList();
		
		CField id_cf = new CField("id", "Long", "id", "int");
		
		cfs.add(id_cf);
		Long t=System.currentTimeMillis();
		CField create_cf = new CField("createAt", "Long", "create_at", "int");
		cfs.add(create_cf);
		CField update_cf = new CField("updateAt", "Long", "update_at", "int");
		cfs.add(update_cf);
		CField group_cf = new CField("groupID", "Long", "group_id", "int");
		group_cf.addValue("1314L");
		group_cf.addValue("3344L");
		cfs.add(group_cf);		
		CField user_cf = new CField("userID", "Long", "user_id", "int");
		user_cf.addValue("7878L");
		user_cf.addValue("4848L");
		
		cfs.add(user_cf);		
		
		
		List<String> sqls = new ArrayList<String>();
	    Map<String,String> maps=new HashMap();        
		String sql="select id from relations where group_id = ? and user_id = ? ";
		maps.put(sql, CSql.Sql_Type_List);
		sqls.add(sql);
		String sql2="select group_id from relations where  user_id = ? ";
		maps.put(sql2, CSql.Sql_Type_Map);
		sqls.add(sql2);
		
		List<CConstant> constants=new ArrayList();
		CConstant c=new CConstant("int","Type_Flex","1","Flex类型");
		constants.add(c);
		
		
		CMold cm=MockUtil.createMold("group_relation","10000",cfs,constants,sqls,maps);				
		return cm;
	}
	
	
	/**
	 * 
	 * @param model  生成的类名
	 * @param port 生成Service的端口号
	 * @param cfs  字段列表
	 * @param constants 常量列表
	 * @param sqls   Sql语句
	 * @param maps   Sql和对应的类型
	 * @return
	 */
	
	public static CMold createMold(String table, String port, List<CField> cfs, List<CConstant> constants, List<String> sqls, Map<String, String> maps) {
		CMold cm = new CMold();		
		cm.setTable(table);
		cm.setPort(port);
		cm.setFields(cfs);
		cm.setSqls(sqls);
		cm.setSql_typ(maps);
		cm.setConstants(constants);
	
		return cm;
	}
	
	

}
