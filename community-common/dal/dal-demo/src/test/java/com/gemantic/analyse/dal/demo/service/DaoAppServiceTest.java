package com.gemantic.analyse.dal.demo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.core.dbsupport.DefaultSQLHandler;
import org.unitils.core.dbsupport.SQLHandler;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.gemantic.analyse.dal.demo.model.XueYing;
import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.CacheUtil;
import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.memcached.channel.source.MemcachedSourceImpl;
import com.gemantic.memcached.client.MemCachedClientImpl;

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
@Ignore
@RunWith(UnitilsJUnit4TestClassRunner.class)   
@SpringApplicationContext({"classpath:/META-INF/dal-demo/applicationContext-server.xml", "classpath:/META-INF/dal-demo/applicationContext-dao.xml"})
public class DaoAppServiceTest extends TestCase {
    private Log log = LogFactory.getLog(DaoAppServiceTest.class);

	@SpringBeanByType
	static DaoAppService daoAppService;

    @TestDataSource()
    private DataSource dataSource;
      
    
//	@Test
	public void test_datasource(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(conn);
		
	}
	
	/******************插入数据************************/
	// 插入数据->检查缓存->清除缓存->检查缓存->检查数据库
//	@Test
	public void test_insert(){
		// 插入记录
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying, xy);
		
		xy = null;
		// 清除缓存
		try {
			cache.remove(userId.toString());
		} catch (CacheException e) {
			log.info("cache remove faild. key is " + userId);

			try {
				assertNull("cache remove faild", cache.get(userId.toString()));
			} catch (CacheException e1) {
				log.info("cache get object faild. key is " + userId);
			}
		}
		
		// 检查缓存清楚情况
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
		}

		assertNull(xy);
		
		String sql = "select guid from xue_ying where user_id = " + userId;
		log.info("sql is " + sql);
		
		// 检查数据是否插入数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		
		String guid = sqlHandler.getItemAsString(sql);
		assertEquals(xueying.getGuid(), guid);
	}

	// 批量插入数据->检查缓存->检查数据库
//	@Test
	public void test_insertList(){
		// 插入记录
		XueYing xueying1 = new XueYing();
		xueying1.setGuid(java.util.UUID.randomUUID().toString());
		xueying1.setName("test");
		xueying1.setAddress("address");
		xueying1.setMemo("memo1");

		XueYing xueying2 = new XueYing();
		xueying2.setGuid(java.util.UUID.randomUUID().toString());
		xueying2.setName("test");
		xueying2.setAddress("address");
		xueying2.setMemo("memo2");
		
		List<XueYing> list = new ArrayList<XueYing>();
		list.add(xueying1);
		list.add(xueying2);
		
		// 批量插入数据
		List<XueYing> xyList = null;
		try {
			xyList = daoAppService.insertList(list);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(xyList);
		
		xueying1.setUserId(xyList.get(0).getUserId());
		xueying2.setUserId(xyList.get(1).getUserId());
		
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(xueying1.getUserId().toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + xueying1);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying1, xy);
		

		String sql = "select guid from xue_ying where user_id = " + xueying1.getUserId();
		log.info("sql is " + sql);
		
		// 检查数据是否插入数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		
		String guid = sqlHandler.getItemAsString(sql);
		assertEquals(xueying1.getGuid(), guid);

		sql = "select guid from xue_ying where user_id = " + xueying2.getUserId();
		log.info("sql is " + sql);
		
		guid = sqlHandler.getItemAsString(sql);
		assertEquals(xueying2.getGuid(), guid);
	}

	// 批量插入数据->检查缓存->检查数据库
//	@Test
	public void test_batchSave(){
		// 插入记录
		XueYing xueying1 = new XueYing();
		xueying1.setGuid(java.util.UUID.randomUUID().toString());
		xueying1.setName("test");
		xueying1.setAddress("address");
		xueying1.setMemo("memo1");

		XueYing xueying2 = new XueYing();
		xueying2.setGuid(java.util.UUID.randomUUID().toString());
		xueying2.setName("test");
		xueying2.setAddress("address");
		xueying2.setMemo("memo2");
		
		List<XueYing> list = new ArrayList<XueYing>();
		list.add(xueying1);
		list.add(xueying2);
		
		// 批量插入数据库
		List<XueYing> xyList = new ArrayList<XueYing>();
		try {
			xyList = daoAppService.batchSave(list);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(xyList);
		
		
		if (xueying1.getGuid() == xyList.get(0).getGuid()) {
			xueying1.setUserId(xyList.get(0).getUserId());
			xueying2.setUserId(xyList.get(1).getUserId());
		} else {
			xueying1.setUserId(xyList.get(1).getUserId());
			xueying2.setUserId(xyList.get(0).getUserId());
		}
		
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(xueying1.getUserId().toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + xueying1);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying1, xy);
		

		String sql = "select guid from xue_ying where user_id = " + xueying1.getUserId();
		log.info("sql is " + sql);
		
		// 检查数据是否插入数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		
		String guid = sqlHandler.getItemAsString(sql);
		assertEquals(xueying1.getGuid(), guid);

		sql = "select guid from xue_ying where user_id = " + xueying2.getUserId();
		log.info("sql is " + sql);
		
		guid = sqlHandler.getItemAsString(sql);
		assertEquals(xueying2.getGuid(), guid);
	}

	/**************************************************/
	
	
	
	/******************更新数据************************/
	// 数据准备->检查缓存->更新数据->检查缓存->检查数据库
//	@Test
	public void test_update_byObject(){
		// 插入记录
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying, xy);
		
		// 更新数据
		xueying.setName("test2");

		boolean result = false;
		try {
			result = daoAppService.update(xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertTrue("update error", result);

		// 检查缓存数据
		xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}

		ReflectionAssert.assertReflectionEquals(xueying, xy);

		String sql = "select name from xue_ying where user_id = " + userId;
		log.info("sql is " + sql);
		
		// 检查信息是否更新到数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		
		String name = sqlHandler.getItemAsString(sql);
		assertEquals(xueying.getName(), name);
	}

	// 数据准备->检查缓存->更新数据->检查缓存->检查数据库
//	@Test
	public void test_update_byIdAndObject(){
		// 插入记录
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying, xy);
		
		// 更新数据
		xueying.setName("test2");

		boolean result = false;
		try {
			result = daoAppService.update(userId, xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertTrue("update error", result);

		// 检查缓存数据
		xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}

		ReflectionAssert.assertReflectionEquals(xueying, xy);
		


		String sql = "select name from xue_ying where user_id = " + userId;
		log.info("sql is " + sql);
		
		// 检查信息是否更新到数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		
		String name = sqlHandler.getItemAsString(sql);
		assertEquals(xueying.getName(), name);
	}

	/**************************************************/

	
	/******************查询数据************************/
	
	// 数据准备->查询数据
//	@Test
	public void test_getObjectById_inCache(){
		// 插入数据
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);

		XueYing xy = null;
		
		try {
			xy = daoAppService.getObjectById(userId);
		} catch (Exception e) {
			log.info("get object from db faild.");
			assertNotNull("db get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying, xy);
	}

	// 数据准备->清除缓存->检查缓存->查询数据->检查缓存
//	@Test
	public void test_getObjectById_notInCache(){
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);

		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);

		// 清除缓存
		try {
			cache.remove(userId.toString());
		} catch (CacheException e) {
			log.info("cache remove faild. key is " + userId);

			try {
				assertNull("cache remove faild", cache.get(userId.toString()));
			} catch (CacheException e1) {
				log.info("cache get object faild. key is " + userId);
			}
		}

		// 检查缓存数据
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		assertNull(xy);

		// 获取数据
		try {
			xy = daoAppService.getObjectById(userId);
		} catch (Exception e) {
			log.info("get object from db faild.");
			assertNotNull("db get object faild.", xy);
			
		}

		assertNotNull(xy);
		ReflectionAssert.assertReflectionEquals(xueying, xy);

		// 检查缓存数据
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
	}

	// 插入数据和指定KV存储的数据在同一个缓存中
	// 数据准备->检查缓存->查询数据->检查缓存
//	@Test
	public void test_getMapping_keys_samecache(){
		// 准备数据
		XueYing xueying = new XueYing();
		xueying.setGuid(java.util.UUID.randomUUID().toString());
		xueying.setName("map");
		xueying.setAddress("北京");
		xueying.setMemo("测试根据组合键查询");

		Long userId = null;
		try {
			userId = daoAppService.insert(xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(userId);
		
		xueying.setUserId(userId);
		
		// 第一次检查缓存数据,预计是没有

		// 检查缓存数据
		Cache cache = CacheHelper.getListCache("getGuidByNameAndUserId");
		assertNotNull(cache);

		String guid = null;
		try {
			guid = (String) cache.get(xueying.getName()+ "_" + userId);
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + xueying.getName()+ "_" + userId);
		}

		assertNull(guid);

		// 查询数据
		guid = null;
		 Object[] params = new Object[]{xueying.getName(), userId};
		
		try {
			guid = daoAppService.getMapingByObjectArray(params);
		} catch (Exception e) {
			log.info("get object from db faild.");
			assertNotNull("db get guid faild.", guid);
			
		}
		
		assertEquals(xueying.getGuid(), guid);
		

		xueying.setUserId(userId);
		
		// 检查缓存数据
		cache = CacheHelper.getListCache("getGuidByNameAndUserId");
		assertNotNull(cache);

		guid = null;
		try {
			guid = (String) cache.get(xueying.getName()+ "_" + userId);
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + xueying.getName()+ "_" + userId);
			assertNotNull("cache get guid faild.", guid);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying.getGuid(), guid);
		
	}

	// 插入数据和指定KV存储的数据在不同的缓存中
	// 数据准备->检查缓存->查询数据->检查缓存
//	@Test
	public void test_getMapping_key_differentcache(){
		// 准备数据
		XueYing xueying = new XueYing();
		xueying.setGuid(java.util.UUID.randomUUID().toString());
		xueying.setName("differentcache");
		xueying.setAddress("北京");
		xueying.setMemo("测试根据单键查询名字信息");

		Long userId = null;
		try {
			userId = daoAppService.insert(xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(userId);
		
		xueying.setUserId(userId);
		
		// 第一次检查缓存数据,预计是没有

		// 检查缓存数据
		Cache cache = CacheHelper.getListCache("getNameByUserId");
		assertNotNull(cache);

		String name = null;
		try {
			name = (String) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
		}

		assertNull(name);

		// 查询数据
		name = null;
		
		try {
			name = daoAppService.getMapingByUserId(userId);
		} catch (Exception e) {
			log.info("get object from db faild.");
			assertNotNull("db get name faild.", name);
			
		}
		
		assertEquals(xueying.getName(), name);
		

		xueying.setUserId(userId);
		
		// 检查缓存数据
		cache = CacheHelper.getListCache("getNameByUserId");
		assertNotNull(cache);

		name = null;
		try {
			name = (String) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get name faild.", name);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying.getName(), name);
	}

	// 插入数据和指定KV存储的数据在不同的缓存中,根据指定策略区分缓存服务器
	// 数据准备->检查缓存(根据REGION和真实的HOST)->查询数据->检查缓存(根据REGION和真实的HOST)
//	@Test
	public void test_getMapping_key_differentcache_byStrategy(){
		// 准备数据
		XueYing xueying = new XueYing();
		xueying.setGuid(java.util.UUID.randomUUID().toString());
		xueying.setName("Strategy");
		xueying.setAddress("地球里");
		xueying.setMemo("测试根据单键查询名字信息");

		Long userId = null;
		try {
			userId = daoAppService.insert(xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(userId);
		
		xueying.setUserId(userId);
		
		// 第一次检查缓存数据,预计是没有

		// 检查缓存数据
		Cache cache = CacheHelper.getListCache("getAddressByUserId");
		assertNotNull(cache);

		String add = null;
		try {
			add = (String) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
		}

		assertNull(add);

		// 自行访问指定的缓存服务器检查数据
		String host = StringUtils.EMPTY;
		long num = userId.longValue()%10;
		if (num > 4) {
			host = "10.0.0.105";
		} else {
			host = "10.0.0.20";
		}
		MemcachedSourceImpl cs = new MemcachedSourceImpl(host, 11211, 5000);
		MemCachedClientImpl mem = new MemCachedClientImpl(cs);

        String realKey = CacheUtil.keyEncode("getAddressByUserId", userId.toString());
        
		add = (String) mem.get(realKey);
		assertNull(add);

		// 查询数据
		add = null;
		
		try {
			add = daoAppService.getMapingAddressByUserId(userId);
		} catch (Exception e) {
			log.info("get object from db faild.");
			assertNotNull("db get address faild.", add);
			
		}
		
		assertEquals(xueying.getAddress(), add);
		

		xueying.setUserId(userId);
		
		// 检查缓存数据
		cache = CacheHelper.getListCache("getAddressByUserId");
		assertNotNull(cache);

		add = null;
		try {
			add = (String) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get address faild.", add);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying.getAddress(), add);
		
		add = null;

		// 自行访问指定的缓存服务器检查数据
		add = (String) mem.get(realKey);
		ReflectionAssert.assertReflectionEquals(xueying.getAddress(), add);
	}
	
//	@Ignore
//	@Test
	public void test_getObjectList() {
		List<Long> idList = null;
		try {
			idList = (List<Long>) daoAppService.getObjectListByUserId(389L);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("select object faild.");
		}

		assertNotNull(idList);
		assertTrue(idList.size() > 0);

		String host = "10.0.0.20";
		MemcachedSourceImpl cs = new MemcachedSourceImpl(host, 11211, 5000);
		MemCachedClientImpl mem = new MemCachedClientImpl(cs);
		
		
		System.out.println("-----" + mem.get("getIdByUserId_389#C"));
		System.out.println("-----" + mem.get("getIdByUserId_389#M"));
		
	}
	
	/**************************************************/
	

	/******************删除数据************************/
	

	// 数据准备->检查缓存->更新数据->检查缓存->检查数据库
//	@Test(expected=UnitilsException.class)
	public void test_delete_byObject(){
		// 插入记录
		XueYing xueying = new XueYing();
		Long userId = insertRecord(xueying);
		
		xueying.setUserId(userId);

		// check db
		String sql = "select name from xue_ying where user_id = " + userId;
		log.info("sql is " + sql);
		
		// 检查信息是否更新到数据库中
		SQLHandler sqlHandler = new DefaultSQLHandler(dataSource);
		String name = sqlHandler.getItemAsString(sql);
		log.info("name is " + name);
		assertNotNull(name);
		
		// 检查缓存数据
		Cache cache = CacheHelper.getListCache(XueYing.class.getName());
		assertNotNull(cache);
		
		XueYing xy = null;
		try {
			xy = (XueYing) cache.get(userId.toString());
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		ReflectionAssert.assertReflectionEquals(xueying, xy);
		
		// 删除数据
		boolean result = false;
		try {
			result = daoAppService.delete(xueying);
		} catch (Exception e) {
			log.info("delete object faild.");
		}

		assertTrue("delete error", result);

		// 检查缓存数据
		try {
			assertNull(cache.get(userId.toString()));
		} catch (CacheException e) {
			log.info("cache get object faild. key is " + userId);
			assertNotNull("cache get object faild.", xy);
			
		}
		
		// 检查信息是否更新到数据库中
		assertNotNull(sqlHandler.getItemAsString(sql));
	}
	
	
	/**************************************************/
	

	private Long insertRecord(XueYing xueying) {
		xueying.setGuid(java.util.UUID.randomUUID().toString());
		xueying.setName("test");
		xueying.setAddress("address");
		xueying.setMemo("memo");
		
		Long userId = null;
		try {
			userId = daoAppService.insert(xueying);
		} catch (Exception e) {
			log.info("insert object faild.");
		}

		assertNotNull(userId);
		return userId;
	}
	
	@Test
	public void emptyMethodForHudson(){
		log.info("go");
	}
}
