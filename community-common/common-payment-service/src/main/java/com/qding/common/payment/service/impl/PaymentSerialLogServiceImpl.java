package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PaymentSerialLog;
import com.qding.common.payment.service.PaymentSerialLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PaymentSerialLogServiceImpl extends BaseDaoServiceImpl implements PaymentSerialLogService {

 

	private static final Log log = LogFactory.getLog(PaymentSerialLogServiceImpl.class);



		   
		@Override
		public Long insert(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + paymentSerialLog);

		if (paymentSerialLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		paymentSerialLog.setCreateAt(currentTimeMillis);
		paymentSerialLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(paymentSerialLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + paymentSerialLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PaymentSerialLog> insertList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (paymentSerialLogList == null ? "null" : paymentSerialLogList.size()));
      
		List<PaymentSerialLog> resultList = null;

		if (CollectionUtils.isEmpty(paymentSerialLogList)) {
			return new ArrayList<PaymentSerialLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PaymentSerialLog paymentSerialLog : paymentSerialLogList) {
			paymentSerialLog.setCreateAt(currentTimeMillis);
			paymentSerialLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PaymentSerialLog>) dao.batchSave(paymentSerialLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + paymentSerialLogList);
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
			result = dao.delete(PaymentSerialLog.class, id);
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
		public boolean update(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (paymentSerialLog == null ? "null" : paymentSerialLog.getId()));

		boolean result = false;

		if (paymentSerialLog == null) {
			return true;
		}

		paymentSerialLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(paymentSerialLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + paymentSerialLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + paymentSerialLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (paymentSerialLogList == null ? "null" : paymentSerialLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(paymentSerialLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PaymentSerialLog paymentSerialLog : paymentSerialLogList) {
			paymentSerialLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(paymentSerialLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + paymentSerialLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + paymentSerialLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PaymentSerialLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PaymentSerialLog paymentSerialLog = null;

		if (id == null) {
			return paymentSerialLog;
		}

		try {
			paymentSerialLog = (PaymentSerialLog) dao.get(PaymentSerialLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return paymentSerialLog;		
		}	
		  
    	   
		@Override
		public List<PaymentSerialLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PaymentSerialLog> paymentSerialLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PaymentSerialLog>();
		}

		try {
			paymentSerialLog = (List<PaymentSerialLog>) dao.getList(PaymentSerialLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (paymentSerialLog == null ? "null" : paymentSerialLog.size()));
    
		return paymentSerialLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by gorderCode,trantype,start,limit  : " + gorderCode+" , "+trantype+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPaymentSerialLogIdsByGorderCodeAndTrantype", new Object[] { gorderCode,trantype},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by gorderCode,trantype,start,limit)  : " + gorderCode+" , "+trantype+" , "+start+" , "+limit );
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
	public List<Long>  getPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by paymentTypeId,start,limit  : " + paymentTypeId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPaymentSerialLogIdsByPaymentTypeId", new Object[] { paymentTypeId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by paymentTypeId,start,limit)  : " + paymentTypeId+" , "+start+" , "+limit );
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
	public List<Long>  getPaymentSerialLogIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by gorderCode,start,limit  : " + gorderCode+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPaymentSerialLogIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by gorderCode,start,limit)  : " + gorderCode+" , "+start+" , "+limit );
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
	public Integer  countPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode,trantype  : " + gorderCode+" , "+trantype );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPaymentSerialLogIdsByGorderCodeAndTrantype", new Object[] { gorderCode,trantype});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by gorderCode,trantype)  : " + gorderCode+" , "+trantype );
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
	public Integer  countPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by paymentTypeId  : " + paymentTypeId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPaymentSerialLogIdsByPaymentTypeId", new Object[] { paymentTypeId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by paymentTypeId)  : " + paymentTypeId );
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
	public Integer  countPaymentSerialLogIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPaymentSerialLogIdsByGorderCode", new Object[] { gorderCode});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by gorderCode)  : " + gorderCode );
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
	public List<Long> getPaymentSerialLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPaymentSerialLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPaymentSerialLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPaymentSerialLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPaymentSerialLogIds " ) ;
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

