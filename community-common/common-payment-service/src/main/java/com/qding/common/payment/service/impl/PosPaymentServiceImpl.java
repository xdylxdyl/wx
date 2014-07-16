package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPayment;
import com.qding.common.payment.service.PosPaymentService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PosPaymentServiceImpl extends BaseDaoServiceImpl implements PosPaymentService {

 

	private static final Log log = LogFactory.getLog(PosPaymentServiceImpl.class);



		   
		@Override
		public Long insert(PosPayment posPayment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + posPayment);

		if (posPayment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		posPayment.setCreateAt(currentTimeMillis);
		posPayment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(posPayment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + posPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PosPayment> insertList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (posPaymentList == null ? "null" : posPaymentList.size()));
      
		List<PosPayment> resultList = null;

		if (CollectionUtils.isEmpty(posPaymentList)) {
			return new ArrayList<PosPayment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPayment posPayment : posPaymentList) {
			posPayment.setCreateAt(currentTimeMillis);
			posPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PosPayment>) dao.batchSave(posPaymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + posPaymentList);
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
			result = dao.delete(PosPayment.class, id);
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
		public boolean update(PosPayment posPayment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (posPayment == null ? "null" : posPayment.getId()));

		boolean result = false;

		if (posPayment == null) {
			return true;
		}

		posPayment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(posPayment);
		} catch (DaoException e) {
			log.error(" update wrong : " + posPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + posPayment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (posPaymentList == null ? "null" : posPaymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(posPaymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPayment posPayment : posPaymentList) {
			posPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(posPaymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + posPaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + posPaymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PosPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PosPayment posPayment = null;

		if (id == null) {
			return posPayment;
		}

		try {
			posPayment = (PosPayment) dao.get(PosPayment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return posPayment;		
		}	
		  
    	   
		@Override
		public List<PosPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PosPayment> posPayment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PosPayment>();
		}

		try {
			posPayment = (List<PosPayment>) dao.getList(PosPayment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (posPayment == null ? "null" : posPayment.size()));
    
		return posPayment;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getPosPaymentIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
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
	public Long  getPosPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,qdCode  : " + gorderCode+" , "+qdCode );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getPosPaymentIdByGorderCodeAndQdCode", new Object[] {gorderCode,qdCode });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,qdCode  : " + gorderCode+" , "+qdCode );
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
	public Integer  countPosPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPosPaymentIdsByGorderCode", new Object[] { gorderCode});

   
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
	public List<Long> getPosPaymentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPosPaymentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPosPaymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPosPaymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPosPaymentIds " ) ;
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

