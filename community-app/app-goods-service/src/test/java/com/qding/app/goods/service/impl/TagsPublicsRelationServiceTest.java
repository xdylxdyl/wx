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

import com.qding.app.goods.model.TagsPublicsRelation;
import com.qding.app.goods.service.TagsPublicsRelationService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsPublicsRelationServiceTest {

	private static final Log log = LogFactory.getLog(TagsPublicsRelationServiceTest.class);

	private TagsPublicsRelationService tagsPublicsRelationService;

	// @Before
	public void setUp() throws Exception {

		// dao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/app-goods-service/applicationContext-server.xml");
		tagsPublicsRelationService = (TagsPublicsRelationService) context.getBean("tagsPublicsRelationService");
		// local server
		/**
		 * tagsPublicsRelationService = (TagsPublicsRelationService)
		 * Naming.lookup("//localhost:9041/TagsPublicsRelationRMIService");
		 **/

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml");
		 * tagsPublicsRelationService = (TagsPublicsRelationService)
		 * context.getBean("tagsPublicsRelationService");
		 **/

	}

	// @Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		TagsPublicsRelation tagsPublicsRelation = new TagsPublicsRelation();

		tagsPublicsRelation.setTagsID(1L);

		tagsPublicsRelation.setPublicsID(145L);

		tagsPublicsRelation.setStatus(1);

		tagsPublicsRelation.setUpdateBy(1L);

		tagsPublicsRelation.setCreateBy(1L);

		Long id = this.tagsPublicsRelationService.insert(tagsPublicsRelation);

		tagsPublicsRelation = this.tagsPublicsRelationService.getObjectById(id);

		TagsPublicsRelation tagsPublicsRelation2 = this.tagsPublicsRelationService.getObjectById(id);
		Assert.assertNotNull(tagsPublicsRelation2);

		// 2. 更改
		tagsPublicsRelation.setTagsID(2L);
		tagsPublicsRelation.setPublicsID(148L);
		tagsPublicsRelation.setStatus(1);
		tagsPublicsRelation.setUpdateBy(2L);
		tagsPublicsRelation.setCreateBy(2L);
		boolean success = this.tagsPublicsRelationService.update(tagsPublicsRelation);
		Assert.assertEquals(true, success);
		TagsPublicsRelation tagsPublicsRelation3 = this.tagsPublicsRelationService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.tagsPublicsRelationService.delete(id);
		Assert.assertEquals(true, success);
		TagsPublicsRelation tagsPublicsRelation4 = this.tagsPublicsRelationService.getObjectById(id);
		Assert.assertNull(tagsPublicsRelation4);

		// 4.batchInsert
		List<TagsPublicsRelation> list = new ArrayList<TagsPublicsRelation>();
		TagsPublicsRelation tagsPublicsRelation5 = new TagsPublicsRelation();

		tagsPublicsRelation5.setTagsID(1L);

		tagsPublicsRelation5.setPublicsID(145L);

		tagsPublicsRelation5.setStatus(1);

		tagsPublicsRelation5.setUpdateBy(1L);

		tagsPublicsRelation5.setCreateBy(1L);

		list.add(tagsPublicsRelation5);
		TagsPublicsRelation tagsPublicsRelation6 = new TagsPublicsRelation();

		tagsPublicsRelation6.setTagsID(2L);

		tagsPublicsRelation6.setPublicsID(148L);

		tagsPublicsRelation6.setStatus(1);

		tagsPublicsRelation6.setUpdateBy(2L);

		tagsPublicsRelation6.setCreateBy(2L);

		list.add(tagsPublicsRelation6);
		List<TagsPublicsRelation> insertResults = this.tagsPublicsRelationService.insertList(list);
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (TagsPublicsRelation o : insertResults) {
			ids.add(o.getId());
		}

		List<TagsPublicsRelation> getResults = this.tagsPublicsRelationService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (TagsPublicsRelation o : insertResults) {
			this.tagsPublicsRelationService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getTagsPublicsRelationIdsByTagsID() throws ServiceException, ServiceDaoException {
		List<TagsPublicsRelation> list = new ArrayList<TagsPublicsRelation>();
		TagsPublicsRelation tagsPublicsRelation1 = new TagsPublicsRelation();

		tagsPublicsRelation1.setTagsID(1L);

		tagsPublicsRelation1.setPublicsID(145L);

		tagsPublicsRelation1.setStatus(1);

		tagsPublicsRelation1.setUpdateBy(1L);

		tagsPublicsRelation1.setCreateBy(1L);

		list.add(tagsPublicsRelation1);
		TagsPublicsRelation tagsPublicsRelation2 = new TagsPublicsRelation();

		tagsPublicsRelation2.setTagsID(2L);

		tagsPublicsRelation2.setPublicsID(148L);

		tagsPublicsRelation2.setStatus(1);

		tagsPublicsRelation2.setUpdateBy(2L);

		tagsPublicsRelation2.setCreateBy(2L);

		list.add(tagsPublicsRelation2);
		List<TagsPublicsRelation> insertResults = this.tagsPublicsRelationService.insertList(list);

		List<Long> lists = tagsPublicsRelationService.getTagsPublicsRelationIdsByTagsID(1L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (TagsPublicsRelation o : insertResults) {
			this.tagsPublicsRelationService.delete(o.getId());
		}

	};

	// @Test
	public void getTagsPublicsRelationIdsByPublicsID() throws ServiceException, ServiceDaoException {
		List<TagsPublicsRelation> list = new ArrayList<TagsPublicsRelation>();
		TagsPublicsRelation tagsPublicsRelation1 = new TagsPublicsRelation();

		tagsPublicsRelation1.setTagsID(1L);

		tagsPublicsRelation1.setPublicsID(145L);

		tagsPublicsRelation1.setStatus(1);

		tagsPublicsRelation1.setUpdateBy(1L);

		tagsPublicsRelation1.setCreateBy(1L);

		list.add(tagsPublicsRelation1);
		TagsPublicsRelation tagsPublicsRelation2 = new TagsPublicsRelation();

		tagsPublicsRelation2.setTagsID(2L);

		tagsPublicsRelation2.setPublicsID(148L);

		tagsPublicsRelation2.setStatus(1);

		tagsPublicsRelation2.setUpdateBy(2L);

		tagsPublicsRelation2.setCreateBy(2L);

		list.add(tagsPublicsRelation2);
		List<TagsPublicsRelation> insertResults = this.tagsPublicsRelationService.insertList(list);

		List<Long> lists = tagsPublicsRelationService.getTagsPublicsRelationIdsByPublicsID(145L, 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (TagsPublicsRelation o : insertResults) {
			this.tagsPublicsRelationService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
