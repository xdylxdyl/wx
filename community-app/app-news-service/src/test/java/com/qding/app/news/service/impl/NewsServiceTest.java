package com.qding.app.news.service.impl;

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

import com.qding.app.news.model.News;
import com.qding.app.news.service.NewsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Ignore
public class NewsServiceTest {

	private static final Log log = LogFactory.getLog(NewsServiceTest.class);

	private NewsService newsService;

	@Before
	public void setUp() throws Exception {

		// dao
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("classpath:META-INF/app-news-service/applicationContext-server.xml");
		// newsService = (NewsService) context.getBean("newsService");

		// local server
		newsService = (NewsService) Naming
				.lookup("//app.news.service:9031/NewsRMIService");

		/**
		 * test client ApplicationContext context = new
		 * ClassPathXmlApplicationContext
		 * ("classpath:META-INF/spring/applicationContext-sca.xml"); newsService
		 * = (NewsService) context.getBean("newsService");
		 **/

	}

	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException {

		// 1.增加

		News news = new News();

		news.setPublicsID(-2042484612L);

		news.setTitle("资讯标题1");

		news.setSummary("摘要1");

		news.setContent("内容1");

		news.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news.setTemplateType(1L);

		news.setStatus("isreleased");

		news.setAuthor("张三");

		news.setReleaseat(1396341910232L);

		Long id = this.newsService.insert(news);

		news = this.newsService.getObjectById(id);

		News news2 = this.newsService.getObjectById(id);
		Assert.assertNotNull(news2);

		// 2. 更改
		news.setPublicsID(-287278099L);
		news.setTitle("资讯标题2");
		news.setSummary("摘要2");
		news.setContent("内容2");
		news.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");
		news.setTemplateType(2L);
		news.setStatus("noreleased");
		news.setAuthor("李四");
		news.setReleaseat(1396341910232L);
		boolean success = this.newsService.update(news);
		Assert.assertEquals(true, success);
		News news3 = this.newsService.getObjectById(id);
		// 3.删除
		boolean successDelete = this.newsService.delete(id);
		Assert.assertEquals(true, success);
		News news4 = this.newsService.getObjectById(id);
		Assert.assertNull(news4);

		// 4.batchInsert
		List<News> list = new ArrayList<News>();
		News news5 = new News();

		news5.setPublicsID(-2042484612L);

		news5.setTitle("资讯标题1");

		news5.setSummary("摘要1");

		news5.setContent("内容1");

		news5.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news5.setTemplateType(1L);

		news5.setStatus("isreleased");

		news5.setAuthor("张三");

		news5.setReleaseat(1396341910232L);

		list.add(news5);
		News news6 = new News();

		news6.setPublicsID(-287278099L);

		news6.setTitle("资讯标题2");

		news6.setSummary("摘要2");

		news6.setContent("内容2");

		news6.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news6.setTemplateType(2L);

		news6.setStatus("noreleased");

		news6.setAuthor("李四");

		news6.setReleaseat(1396341910232L);

		list.add(news6);
		List<News> insertResults = this.newsService.insertList(list);
		
		
		Assert.assertEquals(2, insertResults.size());
		// 5.batchGet
		List<Long> ids = new ArrayList<Long>();
		for (News o : insertResults) {
			ids.add(o.getId());
		}

		List<News> getResults = this.newsService.getObjectsByIds(ids);
		Assert.assertEquals(2, getResults.size());

		for (News o : insertResults) {
			//this.newsService.delete(o.getId());
		}

		// 6.batchUpdate

	}

	// @Test
	public void getNewsIdsByPublicsID() throws ServiceException,
			ServiceDaoException {
		List<News> list = new ArrayList<News>();
		News news1 = new News();

		news1.setPublicsID(-2042484612L);

		news1.setTitle("资讯标题1");

		news1.setSummary("摘要1");

		news1.setContent("内容1");

		news1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news1.setTemplateType(1L);

		news1.setStatus("isreleased");

		news1.setAuthor("张三");

		news1.setReleaseat(1396341910232L);

		list.add(news1);
		News news2 = new News();

		news2.setPublicsID(-287278099L);

		news2.setTitle("资讯标题2");

		news2.setSummary("摘要2");

		news2.setContent("内容2");

		news2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news2.setTemplateType(2L);

		news2.setStatus("noreleased");

		news2.setAuthor("李四");

		news2.setReleaseat(1396341910232L);

		list.add(news2);
		List<News> insertResults = this.newsService.insertList(list);

		List<Long> lists = newsService.getNewsIdsByPublicsID(-2042484612L, 0,
				Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (News o : insertResults) {
			this.newsService.delete(o.getId());
		}

	};

	// @Test
	public void getNewsIdsByPublicsIDAndStatus() throws ServiceException,
			ServiceDaoException {
		List<News> list = new ArrayList<News>();
		News news1 = new News();

		news1.setPublicsID(-2042484612L);

		news1.setTitle("资讯标题1");

		news1.setSummary("摘要1");

		news1.setContent("内容1");

		news1.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news1.setTemplateType(1L);

		news1.setStatus("isreleased");

		news1.setAuthor("张三");

		news1.setReleaseat(1396341910232L);

		list.add(news1);
		News news2 = new News();

		news2.setPublicsID(-287278099L);

		news2.setTitle("资讯标题2");

		news2.setSummary("摘要2");

		news2.setContent("内容2");

		news2.setImg("http://s10.sinaimg.cn/mw600/0023PgK6zy6H4XuEwR319&690");

		news2.setTemplateType(2L);

		news2.setStatus("noreleased");

		news2.setAuthor("李四");

		news2.setReleaseat(1396341910232L);

		list.add(news2);
		List<News> insertResults = this.newsService.insertList(list);

		List<Long> lists = newsService.getNewsIdsByPublicsIDAndStatus(
				-2042484612L, "isreleased", 0, Integer.MAX_VALUE);
		// TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);

		for (News o : insertResults) {
			this.newsService.delete(o.getId());
		}

	};

	@Test
	public void testNULL() throws ServiceException, ServiceDaoException {

	};
}
