package com.qding.common.queue.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.queue.model.RetryQueue;
import com.qding.common.queue.service.RetryQueueService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class RetryQueueServiceImpl extends BaseDaoServiceImpl implements RetryQueueService {

 

	private static final Log log = LogFactory.getLog(RetryQueueServiceImpl.class);



		   
		@Override
		public Long insert(RetryQueue retryQueue)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + retryQueue);
 }
		if (retryQueue == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		retryQueue.setCreateAt(currentTimeMillis);
		retryQueue.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(retryQueue);
		} catch (DaoException e) {
			log.error(" insert wrong : " + retryQueue);
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
		public List<RetryQueue> insertList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (retryQueueList == null ? "null" : retryQueueList.size()));
      }
		List<RetryQueue> resultList = null;

		if (CollectionUtils.isEmpty(retryQueueList)) {
			return new ArrayList<RetryQueue>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RetryQueue retryQueue : retryQueueList) {
			retryQueue.setCreateAt(currentTimeMillis);
			retryQueue.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<RetryQueue>) dao.batchSave(retryQueueList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + retryQueueList);
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
			result = dao.delete(RetryQueue.class, id);
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
		public boolean update(RetryQueue retryQueue)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (retryQueue == null ? "null" : retryQueue.getId()));

		boolean result = false;

		if (retryQueue == null) {
			return true;
		}

		retryQueue.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(retryQueue);
		} catch (DaoException e) {
			log.error(" update wrong : " + retryQueue);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + retryQueue);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (retryQueueList == null ? "null" : retryQueueList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(retryQueueList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RetryQueue retryQueue : retryQueueList) {
			retryQueue.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(retryQueueList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + retryQueueList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + retryQueueList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public RetryQueue getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		RetryQueue retryQueue = null;

		if (id == null) {
			return retryQueue;
		}

		try {
			retryQueue = (RetryQueue) dao.get(RetryQueue.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return retryQueue;		
		}	
		  
    	   
		@Override
		public List<RetryQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<RetryQueue> retryQueue = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<RetryQueue>();
		}

		try {
			retryQueue = (List<RetryQueue>) dao.getList(RetryQueue.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (retryQueue == null ? "null" : retryQueue.size()));
     }
		return retryQueue;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRetryQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getRetryQueueIdsByType", new Object[] { type},start,limit, false);

   
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
	public Integer  countRetryQueueIdsByType(String type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getRetryQueueIdsByType", new Object[] { type});

   
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
	public List<Long> getRetryQueueIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getRetryQueueIdsAll",new Object[] {},start, limit, false);
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
	public Integer countRetryQueueIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRetryQueueIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRetryQueueIds " ) ;
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

