package com.qding.framework.publics.service.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.BasicBSONObject;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
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
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.ChatMessage;
import com.qding.framework.publics.service.ChatMessageService;

public class ChatMessageServiceImpl extends BaseDaoServiceImpl implements ChatMessageService {

	@Resource(name = "mongoDbConfig")
	private Map<String, String> mongoDbConfig;
	
	private DBCollection collection;

	private static final Log log = LogFactory.getLog(ChatMessageServiceImpl.class);
	
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
	public List<Object> getMessageReplys(Long publicsID, String openID) throws ServiceException, ServiceDaoException {
		DBObject dbObject = null;
		try {
			BasicDBObject query = new BasicDBObject();
			query.put("publicsID", publicsID);
			query.put("openID", openID);
			connMongo();
			DBCursor cursor = collection.find(query);
			while (cursor.hasNext()) {
				dbObject = cursor.next();
			}
			ArrayList<Object> replydbObjects = null;
			try {
				replydbObjects = (ArrayList<Object>)dbObject.get("chats");
			}catch (Exception e) {log.error(e);}
			return replydbObjects;
		} catch (Exception e) {
			log.error("getMessageReplys error : " + dbObject);
			log.error(e);
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean replyMessage(Long publicsID, String openID, String content) throws ServiceException, ServiceDaoException {
		DBObject dbObject = null;
		try {
			BasicDBObject query = new BasicDBObject();
			query.put("publicsID", publicsID);
			query.put("openID", openID);
			connMongo();
			DBCursor cursor = collection.find(query);
			while (cursor.hasNext()) {
				dbObject = cursor.next();
			}
			if (dbObject == null) {
				return false;
			} else {
				BasicDBObject replyObj = new BasicDBObject();
				replyObj.put("content", content);
				replyObj.put("send_at", System.currentTimeMillis());
				replyObj.put("type", 1);//0 : up, 1, down
				
				ArrayList<Object> chatsdbObjects = null;
				try {
					chatsdbObjects = (ArrayList<Object>)dbObject.get("chats");
				}catch (Exception e) {log.error(e);}
				if (chatsdbObjects == null) {
					List<Object> replyList = new ArrayList<Object>();
					replyList.add(replyObj);
					dbObject.put("chats", replyList);
				}  else {
					chatsdbObjects.add(replyObj);
					dbObject.put("chats", chatsdbObjects);
				}
				collection.update(new BasicDBObject().append("publicsID", publicsID).append("openID", openID), dbObject);
				return true;
			}
		} catch (Exception e) {
			log.error(" insert wrong : " + dbObject);
			log.error(e);
			e.printStackTrace();
			return false;
		}
	}
		@Override
		public Long insert(ChatMessage chatMessage)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + chatMessage);
 }
		if (chatMessage == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		chatMessage.setCreateAt(currentTimeMillis);
		chatMessage.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(chatMessage);
			// insert into mongodb
			try {
				chatMessage.setId(result);
				
				DBObject dbObject = null;
				BasicDBObject query = new BasicDBObject();
				query.put("publicsID", chatMessage.getPublicsID());
				query.put("openID", chatMessage.getOpenID());
				connMongo();
				DBCursor cursor = collection.find(query);
				while (cursor.hasNext()) {
					dbObject = cursor.next();
				}

				if (dbObject == null) {
					BasicDBObject chatObj = new BasicDBObject();
					chatObj.put("publicsID", chatMessage.getPublicsID());
					chatObj.put("openID", chatMessage.getOpenID());
					
					ArrayList<Object> chatList = new ArrayList<Object>();
					BasicDBObject replyObj = new BasicDBObject();
					replyObj.put("content", chatMessage.getContent());
					replyObj.put("send_at", System.currentTimeMillis());
					replyObj.put("type", 0);//0 : up, 1, down
					chatList.add(replyObj);

					chatObj.put("chats", chatList);

					log.info("insert data to mongodb : " + chatMessage.getPublicsID() + " " + chatMessage.getOpenID());
					connMongo();
					collection.save(chatObj);
				} else {
					ArrayList<Object> chatList = (ArrayList<Object>)dbObject.get("chats");
					BasicDBObject replyObj = new BasicDBObject();
					replyObj.put("content", chatMessage.getContent());
					replyObj.put("send_at", System.currentTimeMillis());
					replyObj.put("type", 0);//0 : up, 1, down
					chatList.add(replyObj);
					dbObject.put("chats", chatList);
					
					log.info("update data to mongodb : " + chatMessage.getPublicsID() + " " + chatMessage.getOpenID());
					connMongo();
					collection.update(new BasicDBObject().append("publicsID", chatMessage.getPublicsID()).append("openID", chatMessage.getOpenID()), dbObject);
				}
			} catch (Exception e) {
				log.error(" insert data to mongodb : " + chatMessage.getPublicsID() + " " + chatMessage.getOpenID());
				log.error(e);
				e.printStackTrace();
			}		
			
		} catch (DaoException e) {
			log.error(" insert wrong : " + chatMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
      if(log.isInfoEnabled()){
		log.info(" insert data success : " + result);
      }
return result;	
		}	
		  
    	   
		@Override
		public List<ChatMessage> insertList(List<ChatMessage> chatMessageList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (chatMessageList == null ? "null" : chatMessageList.size()));
      }
		List<ChatMessage> resultList = null;

		if (CollectionUtils.isEmpty(chatMessageList)) {
			return new ArrayList<ChatMessage>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ChatMessage chatMessage : chatMessageList) {
			chatMessage.setCreateAt(currentTimeMillis);
			chatMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ChatMessage>) dao.batchSave(chatMessageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + chatMessageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
      }
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		             if(log.isInfoEnabled()){
	    log.info(" delete data : " + id);
    }
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(ChatMessage.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
   if(log.isInfoEnabled()){
		log.info(" delete data success : " + id);
    }
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(ChatMessage chatMessage)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (chatMessage == null ? "null" : chatMessage.getId()));

		boolean result = false;

		if (chatMessage == null) {
			return true;
		}

		chatMessage.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(chatMessage);
		} catch (DaoException e) {
			log.error(" update wrong : " + chatMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + chatMessage);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ChatMessage> chatMessageList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (chatMessageList == null ? "null" : chatMessageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(chatMessageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ChatMessage chatMessage : chatMessageList) {
			chatMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(chatMessageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + chatMessageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + chatMessageList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public ChatMessage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		ChatMessage chatMessage = null;

		if (id == null) {
			return chatMessage;
		}

		try {
			chatMessage = (ChatMessage) dao.get(ChatMessage.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return chatMessage;		
		}	
		  
    	   
		@Override
		public List<ChatMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<ChatMessage> chatMessage = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ChatMessage>();
		}

		try {
			chatMessage = (List<ChatMessage>) dao.getList(ChatMessage.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (chatMessage == null ? "null" : chatMessage.size()));
     }
		return chatMessage;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getChatMessageIdsByOpenID(String openID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by openID,start,limit  : " + openID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getChatMessageIdsByOpenID", new Object[] { openID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by openID,start,limit)  : " + openID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
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
	public Integer  countChatMessageIdsByOpenID(String openID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by openID  : " + openID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getChatMessageIdsByOpenID", new Object[] { openID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by openID)  : " + openID );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
		
	
	
	
		
	@Override
	public List<Long> getChatMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getChatMessageIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countChatMessageIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getChatMessageIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getChatMessageIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

