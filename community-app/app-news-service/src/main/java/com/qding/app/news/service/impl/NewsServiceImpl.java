package com.qding.app.news.service.impl;

import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import com.qding.app.news.model.News;
import com.qding.app.news.service.NewsService;

public class NewsServiceImpl implements NewsService {

	private Map<String, String> mongoDbConfig;

	private Dao dao;
	
	private DBCollection collection;

	private static final Log log = LogFactory.getLog(NewsServiceImpl.class);

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Map<String, String> getMongoDbConfig() {
		return mongoDbConfig;
	}

	public void setMongoDbConfig(Map<String, String> mongoDbConfig) {
		this.mongoDbConfig = mongoDbConfig;
	}
	
	/**
	 * 连接 mongoDB
	 */
	public void connMongo(){
		if(null == collection ){
			Mongo mongo;
			try {
				mongo = new Mongo(mongoDbConfig.get("ip"), Integer.parseInt(mongoDbConfig.get("port")));
				DB db = mongo.getDB(mongoDbConfig.get("db"));
				this.collection = db.getCollection(mongoDbConfig.get("collection"));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(News news) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + news);
		}
		if (news == null) {
			return null;
		}
		
		/**
		 * 将内容存到mongodb中,mysql中不存储
		 */
		String content = news.getContent();
		news.setContent(null);

		long currentTimeMillis = System.currentTimeMillis();
		news.setCreateAt(currentTimeMillis);
		news.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(news);
			
			//开始存mongodb
			news.setContent(content);
			Gson gson = new GsonBuilder().create();
			DBObject dbObject = (DBObject) JSON.parse(gson.toJson(news));
			
			if (log.isInfoEnabled()) {
				log.info(" insert data to mongodb : " + news);
			}
			
			connMongo();
			collection.insert(dbObject);
			
		} catch (DaoException e) {
			log.error(" insert wrong : " + news);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert data success : " + result);
		}
		return result;
	}
	
	@Override
	public List<News> insertList(List<News> newsList) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (newsList == null ? "null" : newsList.size()));
		}
		List<News> resultList = null;

		if (CollectionUtils.isEmpty(newsList)) {
			return new ArrayList<News>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		
		Map<Integer,String> cntMap = new HashMap<>();
		int idx = 0;
		
		for (News news : newsList) {
			news.setCreateAt(currentTimeMillis);
			news.setUpdateAt(currentTimeMillis);
			
			/**
			 * 将内容存到mongodb中,mysql中不存储
			 */
			cntMap.put(idx++, news.getContent());
			news.setContent(null);
		}

		try {
			resultList = (List<News>) dao.batchSave(newsList);
			
			//开始存mongodb
			idx = 0;
			Gson gson = new GsonBuilder().create();
			List<DBObject> dbList = new ArrayList<>();
			for (News news2 : newsList) {
				news2.setContent(cntMap.get(idx++));
				
				dbList.add((DBObject) JSON.parse(gson.toJson(news2)));
			}
			
			if (log.isInfoEnabled()) {
				log.info(" insert data to mongodb : " + dbList);
			}
			
			connMongo();
			collection.insert(dbList);
			
		} catch (DaoException e) {
			log.error(" insert list wrong : " + newsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : "
					+ (resultList == null ? "null" : resultList.size()));
		}
		return resultList;

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" delete data : " + id);
		}
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(News.class, id);
			
			//delete mongodb
			connMongo();
			collection.remove(new BasicDBObject().append("id", id));
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" delete data success : " + id);
		}
		return result;

	}

	@Override
	public boolean update(News news) throws ServiceException,
			ServiceDaoException {

		log.info(" update data : " + (news == null ? "null" : news.getId()));

		boolean result = false;

		if (news == null) {
			return true;
		}

		news.setUpdateAt(System.currentTimeMillis());

		try {
			String content = news.getContent();
			news.setContent(null);
			result = dao.update(news);
			
			//update mongodb
			news.setContent(content);
			Gson gson = new GsonBuilder().create();
			DBObject dbObject2 = (DBObject) JSON.parse(gson.toJson(news));
			
			connMongo();
			collection.update(new BasicDBObject().append("id", news.getId()),
					dbObject2);
			
		} catch (DaoException e) {
			log.error(" update wrong : " + news);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + news);
		}
		return result;
	}

	@Override
	public boolean updateList(List<News> newsList) throws ServiceException,
			ServiceDaoException {

		log.info(" update lists : "
				+ (newsList == null ? "null" : newsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(newsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		
		Map<Integer,String> cntMap = new HashMap<>();
		int idx = 0;
		
		for (News news : newsList) {
			news.setUpdateAt(currentTimeMillis);
			
			/**
			 * 将内容存到mongodb中,mysql中不存储
			 */
			cntMap.put(idx++, news.getContent());
			news.setContent(null);
		}

		try {
			result = dao.batchUpdate(newsList);
			
			//开始 update mongodb
			connMongo();
			idx = 0;
			Gson gson = new GsonBuilder().create();
			
			for (News news2 : newsList) {
				news2.setContent(cntMap.get(idx++));
				
				DBObject dbObject2 = (DBObject) JSON.parse(gson.toJson(news2));
				collection.update(new BasicDBObject().append("id", news2.getId()),
						dbObject2);
			}
			
		} catch (DaoException e) {
			log.error(" update list wrong : " + newsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + newsList.size());
		}
		return result;
	}

	@Override
	public News getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		News news = null;

		if (id == null) {
			return news;
		}

		try {
			//news = (News) dao.get(News.class, id);
			Gson gson = new GsonBuilder().create();
			BasicDBObject query = new BasicDBObject();
			query.put("id", id);
			connMongo();
			DBCursor cursor = collection.find(query);
			if (cursor.hasNext()) {
				log.info(id+" get  success");
				DBObject dbObject = cursor.next();
				String json = JSON.serialize(dbObject);
				return gson.fromJson(json,News.class);

			} else {
				return null;
			}
			
		} catch (Exception e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		
	}

	@Override
	public List<News> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<News> news = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<News>();
		}

		try {
			news = (List<News>) dao.getList(News.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (news == null ? "null" : news.size()));
		}
		return news;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getNewsIdsByPublicsID(Long publicsID, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by publicsID,start,limit  : " + publicsID
					+ " , " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getNewsIdsByPublicsID",
					new Object[] { publicsID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,start,limit)  : "
					+ publicsID + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getNewsIdsByPublicsIDAndStatus(Long publicsID,
			String status, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by publicsID,status,start,limit  : " + publicsID
					+ " , " + status + " , " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getNewsIdsByPublicsIDAndStatus",
					new Object[] { publicsID, status }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,status,start,limit)  : "
					+ publicsID + " , " + status + " , " + start + " , "
					+ limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Integer countNewsIdsByPublicsID(Long publicsID)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" count ids by publicsID  : " + publicsID);
		}
		Integer count = null;

		try {

			count = dao.count("getNewsIdsByPublicsID",
					new Object[] { publicsID });

		} catch (DaoException e) {
			log.error(" count ids  wrong by publicsID)  : " + publicsID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  success : " + count);
		}
		return count;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Integer countNewsIdsByPublicsIDAndStatus(Long publicsID,
			String status) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" count ids by publicsID,status  : " + publicsID + " , "
					+ status);
		}
		Integer count = null;

		try {

			count = dao.count("getNewsIdsByPublicsIDAndStatus", new Object[] {
					publicsID, status });

		} catch (DaoException e) {
			log.error(" count ids  wrong by publicsID,status)  : " + publicsID
					+ " , " + status);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  success : " + count);
		}
		return count;

	}

	@Override
	public List<Long> getNewsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start
				+ " , " + limit);
		List<Long> idList = null;

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getNewsIdsAll", new Object[] {}, start,
					limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , "
					+ limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countNewsIds() throws ServiceException, ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getNewsIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getNewsIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

	@Override
	public List<Long> getNewsIdsByCondition(Map<String, Object> conditions,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		String sql = "select id from news where ";
		try {
			Set<String> fieldSet = conditions.keySet();
			for (String field : fieldSet) {
				sql += field + "='" + conditions.get(field) + "'";
				sql += " and ";
			}
			sql = sql.substring(0, sql.length() - " and ".length());

			sql += " limit " + start + "," + limit;

			log.info("sql:" + sql);
			Object o = dao.excuteSimpleSql(sql, News.class);
			if (o instanceof List) {
				return (List<Long>) o;
			} else {
				List<Long> ids = new ArrayList();
				BigInteger id = (BigInteger) o;
				ids.add(id.longValue());
				return ids;
			}

		} catch (DaoException e) {
			log.error(" count by getNewsIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
	}

}
