package com.qding.app.goods.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.app.goods.etl.GoodsEtl;
@Ignore
public class GoodsEtlTest {

	private static final Log log = LogFactory.getLog(GoodsEtlTest.class);

	private GoodsEtl goodsEtl;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
		goodsEtl = (GoodsEtl) context.getBean("goodsEtl");
		// local server
		/**
		 * goodsService = (GoodsService)
		 * Naming.lookup("//localhost:9041/GoodsRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * goodsService = (GoodsService) context.getBean("goodsService");
		 **/

	}

 
	 @Test
	public void processGoods() throws ServiceException, ServiceDaoException {
//		 goodsEtl.setGoodsService(goodsService);
		 try {
			goodsEtl.process1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

 

}
