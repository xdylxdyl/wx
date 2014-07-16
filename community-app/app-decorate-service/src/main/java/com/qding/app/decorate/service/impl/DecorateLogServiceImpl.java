package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateLog;
import com.qding.app.decorate.service.DecorateLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecorateLogServiceImpl extends BaseDaoServiceImpl implements DecorateLogService {

 

	private static final Log log = LogFactory.getLog(DecorateLogServiceImpl.class);



		   
		@Override
		public Long insert(DecorateLog decorateLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decorateLog);

		if (decorateLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decorateLog.setCreateAt(currentTimeMillis);
		decorateLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decorateLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decorateLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DecorateLog> insertList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decorateLogList == null ? "null" : decorateLogList.size()));
      
		List<DecorateLog> resultList = null;

		if (CollectionUtils.isEmpty(decorateLogList)) {
			return new ArrayList<DecorateLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateLog decorateLog : decorateLogList) {
			decorateLog.setCreateAt(currentTimeMillis);
			decorateLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DecorateLog>) dao.batchSave(decorateLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decorateLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(DecorateLog.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(DecorateLog decorateLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decorateLog == null ? "null" : decorateLog.getId()));

		boolean result = false;

		if (decorateLog == null) {
			return true;
		}

		decorateLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decorateLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + decorateLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decorateLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decorateLogList == null ? "null" : decorateLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decorateLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateLog decorateLog : decorateLogList) {
			decorateLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decorateLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decorateLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decorateLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DecorateLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DecorateLog decorateLog = null;

		if (id == null) {
			return decorateLog;
		}

		try {
			decorateLog = (DecorateLog) dao.get(DecorateLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decorateLog;		
		}	
		  
    	   
		@Override
		public List<DecorateLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DecorateLog> decorateLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DecorateLog>();
		}

		try {
			decorateLog = (List<DecorateLog>) dao.getList(DecorateLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decorateLog == null ? "null" : decorateLog.size()));
    
		return decorateLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateLogIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by decorateId,start,limit  : " + decorateId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateLogIdsByDecorateId", new Object[] { decorateId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by decorateId,start,limit)  : " + decorateId+" , "+start+" , "+limit );
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
	public Integer  countDecorateLogIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by decorateId  : " + decorateId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateLogIdsByDecorateId", new Object[] { decorateId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by decorateId)  : " + decorateId );
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
	public List<Long> getDecorateLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecorateLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecorateLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecorateLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecorateLogIds " ) ;
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

