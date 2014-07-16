package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPaymentLog;
import com.qding.common.payment.service.CashPaymentLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CashPaymentLogServiceImpl extends BaseDaoServiceImpl implements CashPaymentLogService {

 

	private static final Log log = LogFactory.getLog(CashPaymentLogServiceImpl.class);



		   
		@Override
		public Long insert(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + cashPaymentLog);

		if (cashPaymentLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cashPaymentLog.setCreateAt(currentTimeMillis);
		cashPaymentLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cashPaymentLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cashPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CashPaymentLog> insertList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (cashPaymentLogList == null ? "null" : cashPaymentLogList.size()));
      
		List<CashPaymentLog> resultList = null;

		if (CollectionUtils.isEmpty(cashPaymentLogList)) {
			return new ArrayList<CashPaymentLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentLog cashPaymentLog : cashPaymentLogList) {
			cashPaymentLog.setCreateAt(currentTimeMillis);
			cashPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CashPaymentLog>) dao.batchSave(cashPaymentLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cashPaymentLogList);
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
			result = dao.delete(CashPaymentLog.class, id);
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
		public boolean update(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cashPaymentLog == null ? "null" : cashPaymentLog.getId()));

		boolean result = false;

		if (cashPaymentLog == null) {
			return true;
		}

		cashPaymentLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cashPaymentLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + cashPaymentLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cashPaymentLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cashPaymentLogList == null ? "null" : cashPaymentLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cashPaymentLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentLog cashPaymentLog : cashPaymentLogList) {
			cashPaymentLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cashPaymentLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cashPaymentLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + cashPaymentLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CashPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CashPaymentLog cashPaymentLog = null;

		if (id == null) {
			return cashPaymentLog;
		}

		try {
			cashPaymentLog = (CashPaymentLog) dao.get(CashPaymentLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return cashPaymentLog;		
		}	
		  
    	   
		@Override
		public List<CashPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CashPaymentLog> cashPaymentLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CashPaymentLog>();
		}

		try {
			cashPaymentLog = (List<CashPaymentLog>) dao.getList(CashPaymentLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (cashPaymentLog == null ? "null" : cashPaymentLog.size()));
    
		return cashPaymentLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentLogIdsByCashPaymentId(Long cashPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by cashPaymentId,start,limit  : " + cashPaymentId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentLogIdsByCashPaymentId", new Object[] { cashPaymentId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by cashPaymentId,start,limit)  : " + cashPaymentId+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentLogIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCashPaymentLogIdsByStatus", new Object[] { status},start,limit, false);

   
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
	public Integer  countCashPaymentLogIdsByCashPaymentId(Long cashPaymentId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by cashPaymentId  : " + cashPaymentId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentLogIdsByCashPaymentId", new Object[] { cashPaymentId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by cashPaymentId)  : " + cashPaymentId );
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
	public Integer  countCashPaymentLogIdsByStatus(String status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status  : " + status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentLogIdsByStatus", new Object[] { status});

   
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
	
		
	
	
	
		
	@Override
	public List<Long> getCashPaymentLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCashPaymentLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCashPaymentLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCashPaymentLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCashPaymentLogIds " ) ;
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

