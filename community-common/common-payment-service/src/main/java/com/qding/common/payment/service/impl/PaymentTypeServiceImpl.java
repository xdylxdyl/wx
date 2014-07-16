package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PaymentType;
import com.qding.common.payment.service.PaymentTypeService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PaymentTypeServiceImpl extends BaseDaoServiceImpl implements PaymentTypeService {

 

	private static final Log log = LogFactory.getLog(PaymentTypeServiceImpl.class);



		   
		@Override
		public Long insert(PaymentType paymentType)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + paymentType);

		if (paymentType == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		paymentType.setCreateAt(currentTimeMillis);
		paymentType.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(paymentType);
		} catch (DaoException e) {
			log.error(" insert wrong : " + paymentType);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PaymentType> insertList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (paymentTypeList == null ? "null" : paymentTypeList.size()));
      
		List<PaymentType> resultList = null;

		if (CollectionUtils.isEmpty(paymentTypeList)) {
			return new ArrayList<PaymentType>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PaymentType paymentType : paymentTypeList) {
			paymentType.setCreateAt(currentTimeMillis);
			paymentType.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PaymentType>) dao.batchSave(paymentTypeList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + paymentTypeList);
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
			result = dao.delete(PaymentType.class, id);
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
		public boolean update(PaymentType paymentType)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (paymentType == null ? "null" : paymentType.getId()));

		boolean result = false;

		if (paymentType == null) {
			return true;
		}

		paymentType.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(paymentType);
		} catch (DaoException e) {
			log.error(" update wrong : " + paymentType);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + paymentType);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (paymentTypeList == null ? "null" : paymentTypeList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(paymentTypeList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PaymentType paymentType : paymentTypeList) {
			paymentType.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(paymentTypeList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + paymentTypeList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + paymentTypeList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PaymentType getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PaymentType paymentType = null;

		if (id == null) {
			return paymentType;
		}

		try {
			paymentType = (PaymentType) dao.get(PaymentType.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return paymentType;		
		}	
		  
    	   
		@Override
		public List<PaymentType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PaymentType> paymentType = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PaymentType>();
		}

		try {
			paymentType = (List<PaymentType>) dao.getList(PaymentType.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (paymentType == null ? "null" : paymentType.size()));
    
		return paymentType;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentTypeIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getPaymentTypeIdsByType", new Object[] { type},start,limit, false);

   
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
	public Integer  countPaymentTypeIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPaymentTypeIdsByType", new Object[] { type});

   
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
	public List<Long> getPaymentTypeIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPaymentTypeIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPaymentTypeIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPaymentTypeIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPaymentTypeIds " ) ;
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

