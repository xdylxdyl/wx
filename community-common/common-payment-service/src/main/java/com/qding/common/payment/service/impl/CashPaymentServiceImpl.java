package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPayment;
import com.qding.common.payment.service.CashPaymentService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CashPaymentServiceImpl extends BaseDaoServiceImpl implements CashPaymentService {

 

	private static final Log log = LogFactory.getLog(CashPaymentServiceImpl.class);



		   
		@Override
		public Long insert(CashPayment cashPayment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + cashPayment);

		if (cashPayment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cashPayment.setCreateAt(currentTimeMillis);
		cashPayment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cashPayment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cashPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CashPayment> insertList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (cashPaymentList == null ? "null" : cashPaymentList.size()));
      
		List<CashPayment> resultList = null;

		if (CollectionUtils.isEmpty(cashPaymentList)) {
			return new ArrayList<CashPayment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPayment cashPayment : cashPaymentList) {
			cashPayment.setCreateAt(currentTimeMillis);
			cashPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CashPayment>) dao.batchSave(cashPaymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cashPaymentList);
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
			result = dao.delete(CashPayment.class, id);
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
		public boolean update(CashPayment cashPayment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cashPayment == null ? "null" : cashPayment.getId()));

		boolean result = false;

		if (cashPayment == null) {
			return true;
		}

		cashPayment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cashPayment);
		} catch (DaoException e) {
			log.error(" update wrong : " + cashPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cashPayment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cashPaymentList == null ? "null" : cashPaymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cashPaymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPayment cashPayment : cashPaymentList) {
			cashPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cashPaymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cashPaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + cashPaymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CashPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CashPayment cashPayment = null;

		if (id == null) {
			return cashPayment;
		}

		try {
			cashPayment = (CashPayment) dao.get(CashPayment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return cashPayment;		
		}	
		  
    	   
		@Override
		public List<CashPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CashPayment> cashPayment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CashPayment>();
		}

		try {
			cashPayment = (List<CashPayment>) dao.getList(CashPayment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (cashPayment == null ? "null" : cashPayment.size()));
    
		return cashPayment;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentIdsByStatusAndReport(int status,int report,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,report,start,limit  : " + status+" , "+report+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentIdsByStatusAndReport", new Object[] { status,report},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,report,start,limit)  : " + status+" , "+report+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCashPaymentIdsByPaymentTypeId", new Object[] { paymentTypeId},start,limit, false);

   
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
	public Long  getCashPaymentIdByGorderCode(Long gorderCode)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode  : " + gorderCode );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCashPaymentIdByGorderCode", new Object[] {gorderCode });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode  : " + gorderCode );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCashPaymentIdByGorderCodeAndPaymentTypeId(Long gorderCode,Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,paymentTypeId  : " + gorderCode+" , "+paymentTypeId );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCashPaymentIdByGorderCodeAndPaymentTypeId", new Object[] {gorderCode,paymentTypeId });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,paymentTypeId  : " + gorderCode+" , "+paymentTypeId );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentIdsByStatusAndReport(int status,int report)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status,report  : " + status+" , "+report );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentIdsByStatusAndReport", new Object[] { status,report});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status,report)  : " + status+" , "+report );
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
	public Integer  countCashPaymentIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by paymentTypeId  : " + paymentTypeId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentIdsByPaymentTypeId", new Object[] { paymentTypeId});

   
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
	
		
	
	
	
		
	@Override
	public List<Long> getCashPaymentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCashPaymentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCashPaymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCashPaymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCashPaymentIds " ) ;
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

