package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.UnionPaymentLog;
import com.qding.common.payment.service.UnionPaymentLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class UnionPaymentLogServiceImpl extends BaseDaoServiceImpl implements UnionPaymentLogService {

 

	private static final Log log = LogFactory.getLog(UnionPaymentLogServiceImpl.class);



		   
		@Override
		public Long insert(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + unionPaymentLog);

		if (unionPaymentLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		unionPaymentLog.setCreateAt(currentTimeMillis);
		unionPaymentLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(unionPaymentLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + unionPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UnionPaymentLog> insertList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (unionPaymentLogList == null ? "null" : unionPaymentLogList.size()));
      
		List<UnionPaymentLog> resultList = null;

		if (CollectionUtils.isEmpty(unionPaymentLogList)) {
			return new ArrayList<UnionPaymentLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UnionPaymentLog unionPaymentLog : unionPaymentLogList) {
			unionPaymentLog.setCreateAt(currentTimeMillis);
			unionPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UnionPaymentLog>) dao.batchSave(unionPaymentLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + unionPaymentLogList);
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
			result = dao.delete(UnionPaymentLog.class, id);
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
		public boolean update(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (unionPaymentLog == null ? "null" : unionPaymentLog.getId()));

		boolean result = false;

		if (unionPaymentLog == null) {
			return true;
		}

		unionPaymentLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(unionPaymentLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + unionPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + unionPaymentLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (unionPaymentLogList == null ? "null" : unionPaymentLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(unionPaymentLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UnionPaymentLog unionPaymentLog : unionPaymentLogList) {
			unionPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(unionPaymentLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + unionPaymentLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + unionPaymentLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UnionPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UnionPaymentLog unionPaymentLog = null;

		if (id == null) {
			return unionPaymentLog;
		}

		try {
			unionPaymentLog = (UnionPaymentLog) dao.get(UnionPaymentLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return unionPaymentLog;		
		}	
		  
    	   
		@Override
		public List<UnionPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UnionPaymentLog> unionPaymentLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UnionPaymentLog>();
		}

		try {
			unionPaymentLog = (List<UnionPaymentLog>) dao.getList(UnionPaymentLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (unionPaymentLog == null ? "null" : unionPaymentLog.size()));
    
		return unionPaymentLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by unionPaymentId,start,limit  : " + unionPaymentId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getUnionPaymentLogIdsByUnionPaymentId", new Object[] { unionPaymentId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by unionPaymentId,start,limit)  : " + unionPaymentId+" , "+start+" , "+limit );
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
	public Integer  countUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by unionPaymentId  : " + unionPaymentId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getUnionPaymentLogIdsByUnionPaymentId", new Object[] { unionPaymentId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by unionPaymentId)  : " + unionPaymentId );
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
	public List<Long> getUnionPaymentLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUnionPaymentLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUnionPaymentLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUnionPaymentLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUnionPaymentLogIds " ) ;
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

