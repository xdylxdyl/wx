package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentReconciliation;
import com.qding.common.payment.service.PosPaymentReconciliationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PosPaymentReconciliationServiceImpl extends BaseDaoServiceImpl implements PosPaymentReconciliationService {

 

	private static final Log log = LogFactory.getLog(PosPaymentReconciliationServiceImpl.class);



		   
		@Override
		public Long insert(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + posPaymentReconciliation);

		if (posPaymentReconciliation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		posPaymentReconciliation.setCreateAt(currentTimeMillis);
		posPaymentReconciliation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(posPaymentReconciliation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + posPaymentReconciliation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PosPaymentReconciliation> insertList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (posPaymentReconciliationList == null ? "null" : posPaymentReconciliationList.size()));
      
		List<PosPaymentReconciliation> resultList = null;

		if (CollectionUtils.isEmpty(posPaymentReconciliationList)) {
			return new ArrayList<PosPaymentReconciliation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentReconciliation posPaymentReconciliation : posPaymentReconciliationList) {
			posPaymentReconciliation.setCreateAt(currentTimeMillis);
			posPaymentReconciliation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PosPaymentReconciliation>) dao.batchSave(posPaymentReconciliationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + posPaymentReconciliationList);
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
			result = dao.delete(PosPaymentReconciliation.class, id);
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
		public boolean update(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (posPaymentReconciliation == null ? "null" : posPaymentReconciliation.getId()));

		boolean result = false;

		if (posPaymentReconciliation == null) {
			return true;
		}

		posPaymentReconciliation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(posPaymentReconciliation);
		} catch (DaoException e) {
			log.error(" update wrong : " + posPaymentReconciliation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + posPaymentReconciliation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (posPaymentReconciliationList == null ? "null" : posPaymentReconciliationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(posPaymentReconciliationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentReconciliation posPaymentReconciliation : posPaymentReconciliationList) {
			posPaymentReconciliation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(posPaymentReconciliationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + posPaymentReconciliationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + posPaymentReconciliationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PosPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PosPaymentReconciliation posPaymentReconciliation = null;

		if (id == null) {
			return posPaymentReconciliation;
		}

		try {
			posPaymentReconciliation = (PosPaymentReconciliation) dao.get(PosPaymentReconciliation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return posPaymentReconciliation;		
		}	
		  
    	   
		@Override
		public List<PosPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PosPaymentReconciliation> posPaymentReconciliation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PosPaymentReconciliation>();
		}

		try {
			posPaymentReconciliation = (List<PosPaymentReconciliation>) dao.getList(PosPaymentReconciliation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (posPaymentReconciliation == null ? "null" : posPaymentReconciliation.size()));
    
		return posPaymentReconciliation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPosPaymentReconciliationIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,qdCode  : " + gorderCode+" , "+qdCode );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getPosPaymentReconciliationIdByGorderCodeAndQdCode", new Object[] {gorderCode,qdCode });
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
	public List<Long>  getPosPaymentReconciliationIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getPosPaymentReconciliationIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
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
	public Integer  countPosPaymentReconciliationIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPosPaymentReconciliationIdsByGorderCode", new Object[] { gorderCode});

   
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
	public List<Long> getPosPaymentReconciliationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPosPaymentReconciliationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPosPaymentReconciliationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPosPaymentReconciliationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPosPaymentReconciliationIds " ) ;
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

