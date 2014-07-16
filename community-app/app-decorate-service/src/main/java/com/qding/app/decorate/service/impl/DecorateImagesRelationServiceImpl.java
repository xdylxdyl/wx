package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateImagesRelation;
import com.qding.app.decorate.service.DecorateImagesRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecorateImagesRelationServiceImpl extends BaseDaoServiceImpl implements DecorateImagesRelationService {

 

	private static final Log log = LogFactory.getLog(DecorateImagesRelationServiceImpl.class);



		   
		@Override
		public Long insert(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decorateImagesRelation);

		if (decorateImagesRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decorateImagesRelation.setCreateAt(currentTimeMillis);
		decorateImagesRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decorateImagesRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decorateImagesRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DecorateImagesRelation> insertList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decorateImagesRelationList == null ? "null" : decorateImagesRelationList.size()));
      
		List<DecorateImagesRelation> resultList = null;

		if (CollectionUtils.isEmpty(decorateImagesRelationList)) {
			return new ArrayList<DecorateImagesRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateImagesRelation decorateImagesRelation : decorateImagesRelationList) {
			decorateImagesRelation.setCreateAt(currentTimeMillis);
			decorateImagesRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DecorateImagesRelation>) dao.batchSave(decorateImagesRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decorateImagesRelationList);
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
			result = dao.delete(DecorateImagesRelation.class, id);
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
		public boolean update(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decorateImagesRelation == null ? "null" : decorateImagesRelation.getId()));

		boolean result = false;

		if (decorateImagesRelation == null) {
			return true;
		}

		decorateImagesRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decorateImagesRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + decorateImagesRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decorateImagesRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decorateImagesRelationList == null ? "null" : decorateImagesRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decorateImagesRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateImagesRelation decorateImagesRelation : decorateImagesRelationList) {
			decorateImagesRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decorateImagesRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decorateImagesRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decorateImagesRelationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DecorateImagesRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DecorateImagesRelation decorateImagesRelation = null;

		if (id == null) {
			return decorateImagesRelation;
		}

		try {
			decorateImagesRelation = (DecorateImagesRelation) dao.get(DecorateImagesRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decorateImagesRelation;		
		}	
		  
    	   
		@Override
		public List<DecorateImagesRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DecorateImagesRelation> decorateImagesRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DecorateImagesRelation>();
		}

		try {
			decorateImagesRelation = (List<DecorateImagesRelation>) dao.getList(DecorateImagesRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decorateImagesRelation == null ? "null" : decorateImagesRelation.size()));
    
		return decorateImagesRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateImagesRelationIdsByDecorateId(String decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getDecorateImagesRelationIdsByDecorateId", new Object[] { decorateId},start,limit, false);

   
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
	public Long  getDecorateImagesRelationIdByImageId(String imageId)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by imageId  : " + imageId );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getDecorateImagesRelationIdByImageId", new Object[] {imageId });
   } catch (DaoException e) {
			log.error(" get id wrong by imageId  : " + imageId );
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
	public Integer  countDecorateImagesRelationIdsByDecorateId(String decorateId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by decorateId  : " + decorateId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateImagesRelationIdsByDecorateId", new Object[] { decorateId});

   
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
	public List<Long> getDecorateImagesRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecorateImagesRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecorateImagesRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecorateImagesRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecorateImagesRelationIds " ) ;
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

