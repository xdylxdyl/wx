package com.gemantic.commons.code.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.util.FileUtil;
import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMethod;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CSql;
import com.gemantic.commons.code.manager.impl.CodeGenerateImpl;

public class CMoldUtil {
	
	
	private static final Log log = LogFactory.getLog(CMoldUtil.class);

	public static List<CMold> parseModel(String filePath) {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	
	public static void initModelSql(CMold cm) {
		Map<String,CSql> sql_sqlModel=new HashMap();
		List<String> sqls=cm.getSqls();
		for(String sql:sqls){
			CSql cs=CSqlUtil.parseSql(sql);		
			cs.setType(cm.getSql_typ().get(sql));
			sql_sqlModel.put(sql, cs);
			
		}
		cm.setSql_sqlModel(sql_sqlModel);
	}


	public static void initMethod(CMold cm) throws Exception {
		
		CMoldUtil.initDefaultMethod(cm);
		
		
		Map<String,CMethod> sql_method=new HashMap();
		List<String> sqls=cm.getSqls();
		for(String sql:sqls){
			CSql c=cm.getSql_sqlModel().get(sql);
			CMethod cmethod=CSqlUtil.parseMethod(c,cm);
			
			sql_method.put(sql, cmethod);
			
			
		}
		cm.setSql_method(sql_method);
		
		
		
		Map<String,CMethod> count_method=new HashMap();
		
		for(String sql:sqls){
			CSql c=cm.getSql_sqlModel().get(sql);
			CMethod countMethod=CSqlUtil.parseCountMethod(c,cm);
			if(countMethod==null){
				continue;
			}
			
			count_method.put(sql, countMethod);
			
			
		}
		
		cm.setCount_method(count_method);
		
		
		
	}
	

	public static void initDefaultMethod(CMold cm) {
		// insert
		log.info(cm.getModelClass()+" generate insert ");
		CMoldUtil.initInsert(cm);
	
		
		//batch insert
		log.info(cm.getModelClass()+" generate batch insert ");
		CMoldUtil.initBatchInsert(cm);
		
		
		// delete
		log.info(cm.getModelClass()+" generate delete ");
		CMoldUtil.initDelete(cm);
		
		
		// update
		log.info(cm.getModelClass()+" generate update ");
		CMoldUtil.initUpdate(cm);
		
		
		
		//batch update
		
		log.info(cm.getModelClass()+" generate batch update ");
		CMoldUtil.initBatchUpdate(cm);
		
		
		
		// query
		log.info(cm.getModelClass()+" generate get ");
		CMoldUtil.initGet(cm);
		
		
		
		//batch get
		
		log.info(cm.getModelClass()+" generate batch get ");
		CMoldUtil.initBatchGet(cm);
		
		
		
		
		
		
		
		
	}


	public static void initBatchGet(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("getObjectsByIds");
		List<CField> params=new ArrayList();
		CField f=new CField("ids","List<Long>","","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","List<"+cm.getModelClass()+">","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/getList.vm");
		insert.setPtest("velocity/test/getList.vm");
		methods.add(insert);	
		
	}


	public static void initBatchUpdate(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("updateList");
		List<CField> params=new ArrayList();
		CField f=new CField(StringUtils.uncapitalize(cm.getModelClass())+"List","List<"+cm.getModelClass()+">","","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","boolean","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/updateList.vm");
		insert.setPtest("velocity/test/updateList.vm");
		methods.add(insert);	
		
	}


	public static void initBatchInsert(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("insertList");
		List<CField> params=new ArrayList();
		CField f=new CField(StringUtils.uncapitalize(cm.getModelClass())+"List","List<"+cm.getModelClass()+">","","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","List<"+cm.getModelClass()+">","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/insertList.vm");
		insert.setPtest("velocity/test/insertList.vm");
		methods.add(insert);		
		
	}


	public static void initGet(CMold cm) {		
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("getObjectById");
		List<CField> params=new ArrayList();
		CField f=new CField("id","Long","","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField(StringUtils.uncapitalize(cm.getModelClass()),cm.getModelClass(),"","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/get.vm");
		insert.setPtest("velocity/test/get.vm");
		methods.add(insert);	
	}


	public static void initUpdate(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("update");
		List<CField> params=new ArrayList();
		CField f=new CField(StringUtils.uncapitalize(cm.getModelClass()),cm.getModelClass(),"","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","boolean","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/update.vm");
		insert.setPtest("velocity/test/update.vm");
		methods.add(insert);	
		
	}


	public static void initDelete(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("delete");
		List<CField> params=new ArrayList();
		CField f=new CField("id","Long","","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","boolean","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/delete.vm");
		insert.setPtest("velocity/test/delete.vm");
		methods.add(insert);		
		
	}


	public static void initInsert(CMold cm) {
		List<CMethod> methods=cm.getDefaultMethods();
		CMethod insert=new CMethod();
		insert.setName("insert");
		List<CField> params=new ArrayList();
		CField f=new CField(StringUtils.uncapitalize(cm.getModelClass()),cm.getModelClass(),"","");
		params.add(f);
		insert.setParams(params);
		CField returnField=new CField("","Long","","");
		insert.setReturnField(returnField);
		insert.setPimpl("velocity/method/insert.vm");
		insert.setPtest("velocity/test/insert.vm");
		methods.add(insert);		
	}
    

	public static void initFields(CMold cm){
		
		
		
		List<CField> fields=cm.getFields();
		
		Map<String,Integer> cn_i=new HashMap();
		Map<String,Integer> dn_i=new HashMap();
		for (int i = 0; i < fields.size(); i++) {
			CField cf=fields.get(i);
			cn_i.put(cf.getCname(),i);
			dn_i.put(cf.getDname(), i);
		}
		cm.setDname_findex(dn_i);
		cm.setName_findex(cn_i);
	}





	static void initBasic(CMold cm,CProject project) {

		
		String[] tableArray=cm.getTable().split("_");
		
        StringBuffer sb=new StringBuffer();
        for(String n:tableArray){
        	sb.append(StringUtils.capitalize(n));
        }
        String name=sb.toString();
        cm.setModelClass(name);
		
		String packageHome=project.getPackageHome();
		cm.setModelPackage(packageHome+".model");
		cm.setModelPath(cm.getHome()+cm.getModelPackage().replace(".", "\\"));
		
		cm.setInterfaceClass(cm.getModelClass()+"Service");
		cm.setInterfacePackage(packageHome+".service");
		cm.setInterfacePath(cm.getHome()+cm.getInterfacePackage().replace(".", "\\"));
		
		
		cm.setImplClass(cm.getModelClass()+"ServiceImpl");
		cm.setImplPackage(packageHome+".service.impl");
		cm.setImplPath(cm.getHome()+cm.getImplPackage().replace(".", "\\"));
		
		
		cm.setTestClass(cm.getModelClass()+"ServiceTest");		
		cm.setTestPackage(packageHome+".service.impl");
		cm.setTestPath(project.getPtest()+cm.getTestPackage().replace(".", "\\"));
		
		
		cm.setClientClass(cm.getModelClass()+"SCAClient");
		String clientPackage=project.getGroupID()+".sca."+project.getKeyword();
		cm.setClientPackage(clientPackage+".client");
		cm.setClientPath(cm.getHome()+cm.getClientPackage().replace(".", "\\"));
	
		
		
		//3. set database properties
		
        cm.setSeq(StringUtils.uncapitalize(cm.getModelClass())+"_seq");
        
        cm.setService(cm.getModelClass()+"RMIService");
        cm.setRegistryName(StringUtils.uncapitalize(cm.getModelClass())+"-"+project.getArtifactID()+"-rmi");
        
      
        
        
        
        
        
        
		
		
		
	}


	public static void initControllers(CMold cm) {
		// TODO Auto-generated method stub
		
	}


	


	
}
