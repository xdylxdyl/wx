package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.qding.app.goods.model.Goods;
import com.qding.app.goods.service.GoodsService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GoodsServiceTest {

	private static final Log log = LogFactory.getLog(GoodsServiceTest.class);

	private GoodsService goodsService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/app-goods-service/applicationContext-server.xml");
		goodsService = (GoodsService) context.getBean("goodsService");
		// local server
		/**
		 * goodsService = (GoodsService)
		 * Naming.lookup("//localhost:9041/GoodsRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); goodsService
		 * = (GoodsService) context.getBean("goodsService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		Goods goods = new Goods();

		goods.setProviderID(1L);

		goods.setCategoryID(1L);

		goods.setName("三根老烟枪牌台灯Can05");

		goods.setPublishName("三根老烟枪牌台灯Can05");

		goods.setPrice("3.010000");

		goods.setOriginalPrice(".000000");

		goods.setCount(1);

		goods.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods.setDetail("Hello~~~");

		goods.setStatus(1);

		goods.setCreateBy(1L);

		goods.setUpdateBy(1L);

		Long id = this.goodsService.insert(goods);

		goods = this.goodsService.getObjectById(id);

		Goods goods2 = this.goodsService.getObjectById(id);
		Assert.assertNotNull(goods2);

		// 2. 更改
		goods.setProviderID(2L);
		goods.setCategoryID(2L);
		goods.setName("蒙牛酸酸乳");
		goods.setPublishName("蒙牛酸酸乳");
		goods.setPrice("435");
		goods.setOriginalPrice(".000000");
		goods.setCount(1);
		goods.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
		goods.setDetail("Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~");
		goods.setStatus(1);
		goods.setCreateBy(13L);
		goods.setUpdateBy(13L);
		boolean success = this.goodsService.update(goods);
		Assert.assertEquals(true, success);
		Goods goods3 = this.goodsService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.goodsService.delete(id);
		Assert.assertEquals(true, success);
		Goods goods4 = this.goodsService.getObjectById(id);
		Assert.assertNull(goods4);

		// 4.batchInsert
		List<Goods> list = new ArrayList<Goods>();
		Goods goods5 = new Goods();

		goods5.setProviderID(1L);

		goods5.setCategoryID(1L);

		goods5.setName("三根老烟枪牌台灯Can05");

		goods5.setPublishName("三根老烟枪牌台灯Can05");

		goods5.setPrice("3.010000");

		goods5.setOriginalPrice(".000000");

		goods5.setCount(1);

		goods5.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods5.setDetail("Hello~~~");

		goods5.setStatus(1);

		goods5.setCreateBy(1L);

		goods5.setUpdateBy(1L);

		list.add(goods5);
		Goods goods6 = new Goods();

		goods6.setProviderID(2L);

		goods6.setCategoryID(2L);

		goods6.setName("蒙牛酸酸乳");

		goods6.setPublishName("蒙牛酸酸乳");

		goods6.setPrice("435");

		goods6.setOriginalPrice(".000000");

		goods6.setCount(1);

		goods6.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods6.setDetail("Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~");

		goods6.setStatus(1);

		goods6.setCreateBy(13L);

		goods6.setUpdateBy(13L);

		list.add(goods6);
		List<Goods> insertResults = this.goodsService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (Goods o : insertResults) {
			ids.add(o.getId());
		}

		List<Goods> getResults = this.goodsService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (Goods o : insertResults) {
			this.goodsService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getGoodsIdByName() throws ServiceException, ServiceDaoException {
		List<Goods> list = new ArrayList<Goods>();
		Goods goods1 = new Goods();

		goods1.setProviderID(1L);

		goods1.setCategoryID(1L);

		goods1.setName("三根老烟枪牌台灯Can05");

		goods1.setPublishName("三根老烟枪牌台灯Can05");

		goods1.setPrice("3.010000");

		goods1.setOriginalPrice(".000000");

		goods1.setCount(1);

		goods1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods1.setDetail("Hello~~~");

		goods1.setStatus(1);

		goods1.setCreateBy(1L);

		goods1.setUpdateBy(1L);

		list.add(goods1);
		Goods goods2 = new Goods();

		goods2.setProviderID(2L);

		goods2.setCategoryID(2L);

		goods2.setName("蒙牛酸酸乳");

		goods2.setPublishName("蒙牛酸酸乳");

		goods2.setPrice("435");

		goods2.setOriginalPrice(".000000");

		goods2.setCount(1);

		goods2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods2.setDetail("Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~");

		goods2.setStatus(1);

		goods2.setCreateBy(13L);

		goods2.setUpdateBy(13L);

		list.add(goods2);
		List<Goods> insertResults = this.goodsService.insertList(list);

		Long lists = goodsService.getGoodsIdByName("三根老烟枪牌台灯Can05");
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Goods o : insertResults) {
			this.goodsService.delete(o.getId());
		}

	};

	// @Test
	public void getGoodsIdsByCategoryIDAndStatus() throws ServiceException, ServiceDaoException {
		List<Goods> list = new ArrayList<Goods>();
		Goods goods1 = new Goods();

		goods1.setProviderID(1L);

		goods1.setCategoryID(1L);

		goods1.setName("三根老烟枪牌台灯Can05");

		goods1.setPublishName("三根老烟枪牌台灯Can05");

		goods1.setPrice("3.010000");

		goods1.setOriginalPrice(".000000");

		goods1.setCount(1);

		goods1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods1.setDetail("Hello~~~");

		goods1.setStatus(1);

		goods1.setCreateBy(1L);

		goods1.setUpdateBy(1L);

		list.add(goods1);
		Goods goods2 = new Goods();

		goods2.setProviderID(2L);

		goods2.setCategoryID(2L);

		goods2.setName("蒙牛酸酸乳");

		goods2.setPublishName("蒙牛酸酸乳");

		goods2.setPrice("435");

		goods2.setOriginalPrice(".000000");

		goods2.setCount(1);

		goods2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		goods2.setDetail("Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~Hello~~~");

		goods2.setStatus(1);

		goods2.setCreateBy(13L);

		goods2.setUpdateBy(13L);

		list.add(goods2);
		List<Goods> insertResults = this.goodsService.insertList(list);

		List<Long> lists = goodsService.getGoodsIdsByCategoryIDAndStatus(1L, 1, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (Goods o : insertResults) {
			this.goodsService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
