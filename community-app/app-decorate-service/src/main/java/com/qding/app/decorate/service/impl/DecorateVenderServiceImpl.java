package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateVender;
import com.qding.app.decorate.service.DecorateVenderService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecorateVenderServiceImpl extends BaseDaoServiceImpl implements DecorateVenderService {

 

	private static final Log log = LogFactory.getLog(DecorateVenderServiceImpl.class);



		   
		@Override
		public Long insert(DecorateVender decorateVender)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decorateVender);

		if (decorateVender == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decorateVender.setCreateAt(currentTimeMillis);
		decorateVender.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decorateVender);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decorateVender);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DecorateVender> insertList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decorateVenderList == null ? "null" : decorateVenderList.size()));
      
		List<DecorateVender> resultList = null;

		if (CollectionUtils.isEmpty(decorateVenderList)) {
			return new ArrayList<DecorateVender>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateVender decorateVender : decorateVenderList) {
			decorateVender.setCreateAt(currentTimeMillis);
			decorateVender.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DecorateVender>) dao.batchSave(decorateVenderList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decorateVenderList);
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
			result = dao.delete(DecorateVender.class, id);
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
		public boolean update(DecorateVender decorateVender)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decorateVender == null ? "null" : decorateVender.getId()));

		boolean result = false;

		if (decorateVender == null) {
			return true;
		}

		decorateVender.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decorateVender);
		} catch (DaoException e) {
			log.error(" update wrong : " + decorateVender);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decorateVender);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decorateVenderList == null ? "null" : decorateVenderList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decorateVenderList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateVender decorateVender : decorateVenderList) {
			decorateVender.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decorateVenderList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decorateVenderList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decorateVenderList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DecorateVender getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DecorateVender decorateVender = null;

		if (id == null) {
			return decorateVender;
		}

		try {
			decorateVender = (DecorateVender) dao.get(DecorateVender.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decorateVender;		
		}	
		  
    	   
		@Override
		public List<DecorateVender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DecorateVender> decorateVender = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DecorateVender>();
		}

		try {
			decorateVender = (List<DecorateVender>) dao.getList(DecorateVender.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decorateVender == null ? "null" : decorateVender.size()));
    
		return decorateVender;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateVenderIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by venderId,start,limit  : " + venderId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateVenderIdsByVenderId", new Object[] { venderId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by venderId,start,limit)  : " + venderId+" , "+start+" , "+limit );
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
	public Integer  countDecorateVenderIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by venderId  : " + venderId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateVenderIdsByVenderId", new Object[] { venderId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by venderId)  : " + venderId );
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
	public List<Long> getDecorateVenderIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecorateVenderIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecorateVenderIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecorateVenderIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecorateVenderIds " ) ;
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

