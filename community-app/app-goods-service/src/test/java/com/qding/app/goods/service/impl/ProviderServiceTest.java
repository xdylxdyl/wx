package com.qding.app.goods.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;

import java.rmi.Naming;

import com.qding.app.goods.model.Provider;
import com.qding.app.goods.model.ProviderPublicsRelation;
import com.qding.app.goods.service.ProviderService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class ProviderServiceTest {

	private static final Log log = LogFactory.getLog(ProviderServiceTest.class);

	private ProviderService providerService;

	 @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		providerService = (ProviderService) context.getBean("providerService");
		// local server
		/**
		 * providerService = (ProviderService)
		 * Naming.lookup("//localhost:9041/ProviderRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * providerService = (ProviderService)
		 * context.getBean("providerService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Provider provider = new Provider();

		provider.setName("北京全聚德有限责任公司");

		provider.setContact("马根明");

		provider.setPhone("13466789021");

		provider.setType("类型1");

		provider.setStatus(0);

		provider.setCreateBy(1L);

		provider.setUpdateBy(1L);

		Long id = this.providerService.insert(provider);

		provider = this.providerService.getObjectById(id);

		Provider provider2 = this.providerService.getObjectById(id);
		Assert.assertNotNull(provider2);

		// 2. 更改
		provider.setName("安利亚太集团");
		provider.setContact("郭靖");
		provider.setPhone("010-7422289");
		provider.setType("类型2");
		provider.setStatus(0);
		provider.setCreateBy(13L);
		provider.setUpdateBy(13L);
		boolean success = this.providerService.update(provider);
		Assert.assertEquals(true, success);
		Provider provider3 = this.providerService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.providerService.delete(id);
		Assert.assertEquals(true, success);
		Provider provider4 = this.providerService.getObjectById(id);
		Assert.assertNull(provider4);

		// 4.batchInsert
		List<Provider> list = new ArrayList<Provider>();
		Provider provider5 = new Provider();

		provider5.setName("北京全聚德有限责任公司");

		provider5.setContact("马根明");

		provider5.setPhone("13466789021");

		provider5.setType("类型1");

		provider5.setStatus(0);

		provider5.setCreateBy(1L);

		provider5.setUpdateBy(1L);

		list.add(provider5);
		Provider provider6 = new Provider();

		provider6.setName("安利亚太集团");

		provider6.setContact("郭靖");

		provider6.setPhone("010-7422289");

		provider6.setType("类型2");

		provider6.setStatus(0);

		provider6.setCreateBy(13L);

		provider6.setUpdateBy(13L);

		list.add(provider6);
		List<Provider> insertResults = this.providerService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Provider o : insertResults) {
			ids.add(o.getId());
		}

		List<Provider> getResults = this.providerService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Provider o : insertResults) {
			this.providerService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getProviderIdByName() throws ServiceException, ServiceDaoException {
		List<Provider> list = new ArrayList<Provider>();
		Provider provider1 = new Provider();

		provider1.setName("北京全聚德有限责任公司");

		provider1.setContact("马根明");

		provider1.setPhone("13466789021");

		provider1.setType("类型1");

		provider1.setStatus(0);

		provider1.setCreateBy(1L);

		provider1.setUpdateBy(1L);

		list.add(provider1);
		Provider provider2 = new Provider();

		provider2.setName("安利亚太集团");

		provider2.setContact("郭靖");

		provider2.setPhone("010-7422289");

		provider2.setType("类型2");

		provider2.setStatus(0);

		provider2.setCreateBy(13L);

		provider2.setUpdateBy(13L);

		list.add(provider2);
		List<Provider> insertResults = this.providerService.insertList(list);

		Long lists = providerService.getProviderIdByName("北京全聚德有限责任公司");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Provider o : insertResults) {
			this.providerService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
	

	//@Test
		public void mockData() throws ServiceException, ServiceDaoException{
			
			List<String> contents=Arrays.asList(new String[]{"花生","Iphone","时光碟","新电影","","电器","餐饮"} );
			Long rid=1L;
			for(String content:contents){
				// 1.增加

				Provider provider = new Provider();

				provider.setName(content);

				provider.setContact("马根明");

				provider.setPhone("13466789021");

				provider.setType("类型1");

				provider.setStatus(0);

				provider.setCreateBy(1L);

				provider.setUpdateBy(1L);

				Long id = this.providerService.insert(provider);

			}
			}
			
}
