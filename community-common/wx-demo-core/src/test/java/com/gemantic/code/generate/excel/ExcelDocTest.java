/**
 * 
 */
package com.gemantic.code.generate.excel;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.manager.CodeGenerate;
import com.gemantic.commons.code.manager.DesignDocParser;

public class ExcelDocTest {

	private static final Log log = LogFactory.getLog(ExcelDocTest.class);

	@Test
	public void testNull() {}

	//@Test
	public void testParseExcelDoc() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/commons-code-mananger/applicationContext.xml");
		CodeGenerate codeGenerate = (CodeGenerate) context.getBean("codeGenerate");
		DesignDocParser excelDesignDocParser = (DesignDocParser) context.getBean("excelDesignDocParser");

		log.info("parse excel");
		CProject cProject = excelDesignDocParser.parseDesignDoc("document/qding.xls");
		//CProject cProject = excelDesignDocParser.parseDesignDoc("document/test1.xls");
		Assert.assertNotNull(cProject);
		log.info("parse excel success ");
		
		log.info("generate core project");
		boolean bc = codeGenerate.generateCoreProject(cProject);
		Assert.assertTrue(bc);
		log.info("generate core project result : " + bc);
		
/*		log.info("generate service project");
		boolean bs = codeGenerate.generateServiceProject(cProject);
		Assert.assertTrue(bs);
		log.info("generate service project result : " + bs);*/
		
		log.info("generate client project");
		boolean bclient = codeGenerate.generateClientProject(cProject);
		Assert.assertTrue(bclient);
		log.info("generate client project result : " + bclient);
		
		/*log.info("generate client project");
		boolean bcontroller = codeGenerate.generateControllerProject(cProject);
		Assert.assertTrue(bcontroller);
		log.info("generate client project result : " + bcontroller);*/
		
	/*	log.info("generate db script project");
		boolean bdb = codeGenerate.generateDataBaseScript(cProject);
		Assert.assertTrue(bdb);
		log.info("generate db script result : " + bdb);
		
		log.info("generate resources sql script project");
		boolean rbd = codeGenerate.generateResourcesSqlScript(cProject);
		Assert.assertTrue(rbd);
		log.info("generate resources sql script result : " + rbd);*/
	}
	
	public static void main(String[] args) throws Exception {
		ExcelDocTest test = new ExcelDocTest();
		test.testParseExcelDoc();
	};
}
