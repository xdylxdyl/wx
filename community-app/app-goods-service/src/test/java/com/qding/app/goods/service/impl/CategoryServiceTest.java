package com.qding.app.goods.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.app.goods.model.Category;
import com.qding.app.goods.service.CategoryService;
@Ignore
public class CategoryServiceTest {

	private static final Log log = LogFactory.getLog(CategoryServiceTest.class);

	private CategoryService categoryService;

	@Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-server.xml");
		categoryService = (CategoryService) context.getBean("categoryService");
		// local server
		/**
		 * categoryService = (CategoryService)
		 * Naming.lookup("//localhost:9041/CategoryRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * categoryService = (CategoryService)
		 * context.getBean("categoryService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Category category = new Category();

		category.setName("食品");

		category.setStatus(3);

		category.setCreateBy(1L);

		category.setUpdateBy(1L);

		Long id = this.categoryService.insert(category);

		category = this.categoryService.getObjectById(id);

		Category category2 = this.categoryService.getObjectById(id);
		Assert.assertNotNull(category2);

		// 2. 更改
		category.setName("安利亚太集团");
		category.setStatus(3);
		category.setCreateBy(13L);
		category.setUpdateBy(13L);
		boolean success = this.categoryService.update(category);
		Assert.assertEquals(true, success);
		Category category3 = this.categoryService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.categoryService.delete(id);
		Assert.assertEquals(true, success);
		Category category4 = this.categoryService.getObjectById(id);
		Assert.assertNull(category4);

		// 4.batchInsert
		List<Category> list = new ArrayList<Category>();
		Category category5 = new Category();

		category5.setName("北京全聚德有限责任公司");

		category5.setStatus(3);

		category5.setCreateBy(1L);

		category5.setUpdateBy(1L);

		list.add(category5);
		Category category6 = new Category();

		category6.setName("安利亚太集团");

		category6.setStatus(3);

		category6.setCreateBy(13L);

		category6.setUpdateBy(13L);

		list.add(category6);
		List<Category> insertResults = this.categoryService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Category o : insertResults) {
			ids.add(o.getId());
		}

		List<Category> getResults = this.categoryService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Category o : insertResults) {
			this.categoryService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getCategoryIdsByStatus() throws ServiceException, ServiceDaoException {
		List<Category> list = new ArrayList<Category>();
		Category category1 = new Category();

		category1.setName("北京全聚德有限责任公司");

		category1.setStatus(3);

		category1.setCreateBy(1L);

		category1.setUpdateBy(1L);

		list.add(category1);
		Category category2 = new Category();

		category2.setName("安利亚太集团");

		category2.setStatus(3);

		category2.setCreateBy(13L);

		category2.setUpdateBy(13L);

		list.add(category2);
		List<Category> insertResults = this.categoryService.insertList(list);

		List<Long> lists = categoryService.getCategoryIdsByStatus(3, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Category o : insertResults) {
			this.categoryService.delete(o.getId());
		}

	};

	// @Test
	public void getCategoryIdByName() throws ServiceException, ServiceDaoException {
		List<Category> list = new ArrayList<Category>();
		Category category1 = new Category();

		category1.setName("北京全聚德有限责任公司");

		category1.setStatus(3);

		category1.setCreateBy(1L);

		category1.setUpdateBy(1L);

		list.add(category1);
		Category category2 = new Category();

		category2.setName("安利亚太集团");

		category2.setStatus(3);

		category2.setCreateBy(13L);

		category2.setUpdateBy(13L);

		list.add(category2);
		List<Category> insertResults = this.categoryService.insertList(list);

		Long lists = categoryService.getCategoryIdByName("北京全聚德有限责任公司");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Category o : insertResults) {
			this.categoryService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
	
	//@Test
	public void mockData() throws ServiceException, ServiceDaoException{
		
		List<String> contents=Arrays.asList(new String[]{"食品","电子","音乐","电影","旅游","电器","餐饮"} );
		for(String content:contents){
			Category category = new Category();

			category.setName(content);

			category.setStatus(0);

			category.setCreateBy(1L);

			category.setUpdateBy(1L);

			Long id = this.categoryService.insert(category);
			log.info(category+" insert over ");
		}
		
		
		
		
	}
}
