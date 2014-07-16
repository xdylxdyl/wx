package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPaymentReconciliation;
import com.qding.common.payment.service.CashPaymentReconciliationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CashPaymentReconciliationServiceImpl extends BaseDaoServiceImpl implements CashPaymentReconciliationService {

 

	private static final Log log = LogFactory.getLog(CashPaymentReconciliationServiceImpl.class);



		   
		@Override
		public Long insert(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + cashPaymentReconciliation);

		if (cashPaymentReconciliation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cashPaymentReconciliation.setCreateAt(currentTimeMillis);
		cashPaymentReconciliation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cashPaymentReconciliation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cashPaymentReconciliation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CashPaymentReconciliation> insertList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (cashPaymentReconciliationList == null ? "null" : cashPaymentReconciliationList.size()));
      
		List<CashPaymentReconciliation> resultList = null;

		if (CollectionUtils.isEmpty(cashPaymentReconciliationList)) {
			return new ArrayList<CashPaymentReconciliation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentReconciliation cashPaymentReconciliation : cashPaymentReconciliationList) {
			cashPaymentReconciliation.setCreateAt(currentTimeMillis);
			cashPaymentReconciliation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CashPaymentReconciliation>) dao.batchSave(cashPaymentReconciliationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cashPaymentReconciliationList);
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
			result = dao.delete(CashPaymentReconciliation.class, id);
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
		public boolean update(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cashPaymentReconciliation == null ? "null" : cashPaymentReconciliation.getId()));

		boolean result = false;

		if (cashPaymentReconciliation == null) {
			return true;
		}

		cashPaymentReconciliation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cashPaymentReconciliation);
		} catch (DaoException e) {
			log.error(" update wrong : " + cashPaymentReconciliation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cashPaymentReconciliation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cashPaymentReconciliationList == null ? "null" : cashPaymentReconciliationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cashPaymentReconciliationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentReconciliation cashPaymentReconciliation : cashPaymentReconciliationList) {
			cashPaymentReconciliation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cashPaymentReconciliationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cashPaymentReconciliationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + cashPaymentReconciliationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CashPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CashPaymentReconciliation cashPaymentReconciliation = null;

		if (id == null) {
			return cashPaymentReconciliation;
		}

		try {
			cashPaymentReconciliation = (CashPaymentReconciliation) dao.get(CashPaymentReconciliation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return cashPaymentReconciliation;		
		}	
		  
    	   
		@Override
		public List<CashPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CashPaymentReconciliation> cashPaymentReconciliation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CashPaymentReconciliation>();
		}

		try {
			cashPaymentReconciliation = (List<CashPaymentReconciliation>) dao.getList(CashPaymentReconciliation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (cashPaymentReconciliation == null ? "null" : cashPaymentReconciliation.size()));
    
		return cashPaymentReconciliation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentReconciliationIdsByStatusAndType(int status,int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,type,start,limit  : " + status+" , "+type+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentReconciliationIdsByStatusAndType", new Object[] { status,type},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,type,start,limit)  : " + status+" , "+type+" , "+start+" , "+limit );
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
	public Long  getCashPaymentReconciliationIdByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode  : " + gorderCode );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCashPaymentReconciliationIdByGorderCode", new Object[] {gorderCode });
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
	public List<Long>  getCashPaymentReconciliationIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCashPaymentReconciliationIdsByType", new Object[] { type},start,limit, false);

   
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
	public Integer  countCashPaymentReconciliationIdsByStatusAndType(int status,int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status,type  : " + status+" , "+type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentReconciliationIdsByStatusAndType", new Object[] { status,type});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status,type)  : " + status+" , "+type );
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
	public Integer  countCashPaymentReconciliationIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentReconciliationIdsByType", new Object[] { type});

   
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
	public List<Long> getCashPaymentReconciliationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCashPaymentReconciliationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCashPaymentReconciliationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCashPaymentReconciliationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCashPaymentReconciliationIds " ) ;
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

