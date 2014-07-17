package com.qding.common.queue.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.service.MsgQueueService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class MsgQueueServiceImpl extends BaseDaoServiceImpl implements MsgQueueService {

 

	private static final Log log = LogFactory.getLog(MsgQueueServiceImpl.class);



		   
		@Override
		public Long insert(MsgQueue msgQueue)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + msgQueue);
 }
		if (msgQueue == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		msgQueue.setCreateAt(currentTimeMillis);
		msgQueue.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(msgQueue);
		} catch (DaoException e) {
			log.error(" insert wrong : " + msgQueue);
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
		public List<MsgQueue> insertList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (msgQueueList == null ? "null" : msgQueueList.size()));
      }
		List<MsgQueue> resultList = null;

		if (CollectionUtils.isEmpty(msgQueueList)) {
			return new ArrayList<MsgQueue>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (MsgQueue msgQueue : msgQueueList) {
			msgQueue.setCreateAt(currentTimeMillis);
			msgQueue.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<MsgQueue>) dao.batchSave(msgQueueList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + msgQueueList);
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
			result = dao.delete(MsgQueue.class, id);
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
		public boolean update(MsgQueue msgQueue)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (msgQueue == null ? "null" : msgQueue.getId()));

		boolean result = false;

		if (msgQueue == null) {
			return true;
		}

		msgQueue.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(msgQueue);
		} catch (DaoException e) {
			log.error(" update wrong : " + msgQueue);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + msgQueue);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (msgQueueList == null ? "null" : msgQueueList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(msgQueueList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (MsgQueue msgQueue : msgQueueList) {
			msgQueue.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(msgQueueList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + msgQueueList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + msgQueueList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public MsgQueue getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		MsgQueue msgQueue = null;

		if (id == null) {
			return msgQueue;
		}

		try {
			msgQueue = (MsgQueue) dao.get(MsgQueue.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return msgQueue;		
		}	
		  
    	   
		@Override
		public List<MsgQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<MsgQueue> msgQueue = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<MsgQueue>();
		}

		try {
			msgQueue = (List<MsgQueue>) dao.getList(MsgQueue.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (msgQueue == null ? "null" : msgQueue.size()));
     }
		return msgQueue;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getMsgQueueIdsByTypeAndStatus(String type,String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by type,status,start,limit  : " + type+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getMsgQueueIdsByTypeAndStatus", new Object[] { type,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by type,status,start,limit)  : " + type+" , "+status+" , "+start+" , "+limit );
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
	public List<Long>  getMsgQueueIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,start,limit  : " + status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getMsgQueueIdsByStatus", new Object[] { status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,start,limit)  : " + status+" , "+start+" , "+limit );
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
	public List<Long>  getMsgQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by type,start,limit  : " + type+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getMsgQueueIdsByType", new Object[] { type},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by type,start,limit)  : " + type+" , "+start+" , "+limit );
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
	public Integer  countMsgQueueIdsByTypeAndStatus(String type,String status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type,status  : " + type+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getMsgQueueIdsByTypeAndStatus", new Object[] { type,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by type,status)  : " + type+" , "+status );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
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
	public Integer  countMsgQueueIdsByStatus(String status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status  : " + status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getMsgQueueIdsByStatus", new Object[] { status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status)  : " + status );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
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
	public Integer  countMsgQueueIdsByType(String type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getMsgQueueIdsByType", new Object[] { type});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by type)  : " + type );
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
	public List<Long> getMsgQueueIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getMsgQueueIdsAll",new Object[] {},start, limit, false);
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
	public Integer countMsgQueueIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getMsgQueueIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getMsgQueueIds " ) ;
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

