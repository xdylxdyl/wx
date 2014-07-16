package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecoratePayment;
import com.qding.app.decorate.service.DecoratePaymentService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecoratePaymentServiceImpl extends BaseDaoServiceImpl implements DecoratePaymentService {

 

	private static final Log log = LogFactory.getLog(DecoratePaymentServiceImpl.class);



		   
		@Override
		public Long insert(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decoratePayment);

		if (decoratePayment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decoratePayment.setCreateAt(currentTimeMillis);
		decoratePayment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decoratePayment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decoratePayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DecoratePayment> insertList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decoratePaymentList == null ? "null" : decoratePaymentList.size()));
      
		List<DecoratePayment> resultList = null;

		if (CollectionUtils.isEmpty(decoratePaymentList)) {
			return new ArrayList<DecoratePayment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecoratePayment decoratePayment : decoratePaymentList) {
			decoratePayment.setCreateAt(currentTimeMillis);
			decoratePayment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DecoratePayment>) dao.batchSave(decoratePaymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decoratePaymentList);
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
			result = dao.delete(DecoratePayment.class, id);
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
		public boolean update(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decoratePayment == null ? "null" : decoratePayment.getId()));

		boolean result = false;

		if (decoratePayment == null) {
			return true;
		}

		decoratePayment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decoratePayment);
		} catch (DaoException e) {
			log.error(" update wrong : " + decoratePayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decoratePayment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decoratePaymentList == null ? "null" : decoratePaymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decoratePaymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecoratePayment decoratePayment : decoratePaymentList) {
			decoratePayment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decoratePaymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decoratePaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decoratePaymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DecoratePayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DecoratePayment decoratePayment = null;

		if (id == null) {
			return decoratePayment;
		}

		try {
			decoratePayment = (DecoratePayment) dao.get(DecoratePayment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decoratePayment;		
		}	
		  
    	   
		@Override
		public List<DecoratePayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DecoratePayment> decoratePayment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DecoratePayment>();
		}

		try {
			decoratePayment = (List<DecoratePayment>) dao.getList(DecoratePayment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decoratePayment == null ? "null" : decoratePayment.size()));
    
		return decoratePayment;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecoratePaymentIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getDecoratePaymentIdsByDecorateId", new Object[] { decorateId},start,limit, false);

   
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
	public Integer  countDecoratePaymentIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by decorateId  : " + decorateId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecoratePaymentIdsByDecorateId", new Object[] { decorateId});

   
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
	public List<Long> getDecoratePaymentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecoratePaymentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecoratePaymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecoratePaymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecoratePaymentIds " ) ;
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

