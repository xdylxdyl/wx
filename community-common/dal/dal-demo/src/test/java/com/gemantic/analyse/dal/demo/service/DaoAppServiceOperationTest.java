package com.gemantic.analyse.dal.demo.service;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.analyse.dal.demo.model.XueYing;

/**
 * 该测试类用于测试新的数据处理结构
 * 
 * 库:
 * HOST:10.0.0.20
 * PORT:3306
 * 
 * 缓存:
 * 1: 10.0.0.20(默认)
 * 2: 10.0.0.105
 * 
 * 主要测试点:
 * 1: 数据插入
 * 2: 数据更新
 * 3: 数据查询
 * 
 * @author cctv
 *
 */
public class DaoAppServiceOperationTest  {


    private DaoAppService daoAppService;
	
	private static final Log log = LogFactory.getLog(DaoAppServiceOperationTest.class);


	
	
	

	

    public DaoAppService getDaoAppService() {
		return daoAppService;
	}


	public void setDaoAppService(DaoAppService daoAppService) {
		this.daoAppService = daoAppService;
	}


	//@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		log.info(context);
		daoAppService = (DaoAppService) context.getBean("daoService");
	
		// local server
		/**
		 * recordService = (RecordService)
		 * Naming.lookup("//localhost:8801/RecordRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * recordService = (RecordService) context.getBean("recordService");
		 **/

	}


    public DaoAppServiceOperationTest(){}
	
	/******************插入数据************************/
	// 插入数据->检查缓存->清除缓存->检查缓存->检查数据库
	//@Test
	public void test_insert(){
		log.info("insert data ");
		// 插入记录
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);
	}


	private Long insertRecord(XueYing xueying) {
		xueying.setGuid(java.util.UUID.randomUUID().toString());
		xueying.setName("test");
		xueying.setAddress("address");
		xueying.setMemo("memo");

		Long userId = null;
		try {
			userId = daoAppService.insert(xueying);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("insert object faild.");
		}

		Assert.assertNotNull(userId);
		return userId;
	}
	
	@Test
	public void emptyMethodForHudson(){
		
		log.info("go");
	}
	
	public static void main(String[] args) {
	
		log.info("xcxcxcv");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		DaoAppService daoAppService = (DaoAppService) context.getBean("daoService");
		DaoAppServiceOperationTest test=new DaoAppServiceOperationTest();
		test.setDaoAppService(daoAppService);
		test.test_insert();
		
		log.info("over==========");
		
		
		
	}
}
