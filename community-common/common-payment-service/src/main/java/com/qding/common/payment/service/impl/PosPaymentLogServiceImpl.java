package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentLog;
import com.qding.common.payment.service.PosPaymentLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PosPaymentLogServiceImpl extends BaseDaoServiceImpl implements PosPaymentLogService {

 

	private static final Log log = LogFactory.getLog(PosPaymentLogServiceImpl.class);



		   
		@Override
		public Long insert(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + posPaymentLog);

		if (posPaymentLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		posPaymentLog.setCreateAt(currentTimeMillis);
		posPaymentLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(posPaymentLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + posPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PosPaymentLog> insertList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (posPaymentLogList == null ? "null" : posPaymentLogList.size()));
      
		List<PosPaymentLog> resultList = null;

		if (CollectionUtils.isEmpty(posPaymentLogList)) {
			return new ArrayList<PosPaymentLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentLog posPaymentLog : posPaymentLogList) {
			posPaymentLog.setCreateAt(currentTimeMillis);
			posPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PosPaymentLog>) dao.batchSave(posPaymentLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + posPaymentLogList);
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
			result = dao.delete(PosPaymentLog.class, id);
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
		public boolean update(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (posPaymentLog == null ? "null" : posPaymentLog.getId()));

		boolean result = false;

		if (posPaymentLog == null) {
			return true;
		}

		posPaymentLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(posPaymentLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + posPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + posPaymentLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (posPaymentLogList == null ? "null" : posPaymentLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(posPaymentLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentLog posPaymentLog : posPaymentLogList) {
			posPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(posPaymentLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + posPaymentLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + posPaymentLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PosPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PosPaymentLog posPaymentLog = null;

		if (id == null) {
			return posPaymentLog;
		}

		try {
			posPaymentLog = (PosPaymentLog) dao.get(PosPaymentLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return posPaymentLog;		
		}	
		  
    	   
		@Override
		public List<PosPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PosPaymentLog> posPaymentLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PosPaymentLog>();
		}

		try {
			posPaymentLog = (List<PosPaymentLog>) dao.getList(PosPaymentLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (posPaymentLog == null ? "null" : posPaymentLog.size()));
    
		return posPaymentLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentLogIdsByPosPaymentId(Long posPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by posPaymentId,start,limit  : " + posPaymentId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPosPaymentLogIdsByPosPaymentId", new Object[] { posPaymentId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by posPaymentId,start,limit)  : " + posPaymentId+" , "+start+" , "+limit );
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
	public Integer  countPosPaymentLogIdsByPosPaymentId(Long posPaymentId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by posPaymentId  : " + posPaymentId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPosPaymentLogIdsByPosPaymentId", new Object[] { posPaymentId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by posPaymentId)  : " + posPaymentId );
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
	public List<Long> getPosPaymentLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPosPaymentLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPosPaymentLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPosPaymentLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPosPaymentLogIds " ) ;
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

