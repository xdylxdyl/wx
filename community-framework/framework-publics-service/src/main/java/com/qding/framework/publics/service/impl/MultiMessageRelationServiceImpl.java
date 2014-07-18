package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.MultiMessageRelation;
import com.qding.framework.publics.service.MultiMessageRelationService;



public class MultiMessageRelationServiceImpl extends BaseDaoServiceImpl implements MultiMessageRelationService {

  

	private static final Log log = LogFactory.getLog(MultiMessageRelationServiceImpl.class);

	


		   
		@Override
		public Long insert(MultiMessageRelation multiMessageRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + multiMessageRelation);
 }
		if (multiMessageRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		multiMessageRelation.setCreateAt(currentTimeMillis);
		multiMessageRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(multiMessageRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + multiMessageRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
      if(log.isInfoEnabled()){
		log.info(" insert data success : " + result);
      }
return result;	
		}	
		  
    	   
		@Override
		public List<MultiMessageRelation> insertList(List<MultiMessageRelation> multiMessageRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (multiMessageRelationList == null ? "null" : multiMessageRelationList.size()));
      }
		List<MultiMessageRelation> resultList = null;

		if (CollectionUtils.isEmpty(multiMessageRelationList)) {
			return new ArrayList<MultiMessageRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (MultiMessageRelation multiMessageRelation : multiMessageRelationList) {
			multiMessageRelation.setCreateAt(currentTimeMillis);
			multiMessageRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<MultiMessageRelation>) dao.batchSave(multiMessageRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + multiMessageRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
      }
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		             if(log.isInfoEnabled()){
	    log.info(" delete data : " + id);
    }
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(MultiMessageRelation.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
   if(log.isInfoEnabled()){
		log.info(" delete data success : " + id);
    }
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(MultiMessageRelation multiMessageRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (multiMessageRelation == null ? "null" : multiMessageRelation.getId()));

		boolean result = false;

		if (multiMessageRelation == null) {
			return true;
		}

		multiMessageRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(multiMessageRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + multiMessageRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + multiMessageRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<MultiMessageRelation> multiMessageRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (multiMessageRelationList == null ? "null" : multiMessageRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(multiMessageRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (MultiMessageRelation multiMessageRelation : multiMessageRelationList) {
			multiMessageRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(multiMessageRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + multiMessageRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + multiMessageRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public MultiMessageRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		MultiMessageRelation multiMessageRelation = null;

		if (id == null) {
			return multiMessageRelation;
		}

		try {
			multiMessageRelation = (MultiMessageRelation) dao.get(MultiMessageRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return multiMessageRelation;		
		}	
		  
    	   
		@Override
		public List<MultiMessageRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<MultiMessageRelation> multiMessageRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<MultiMessageRelation>();
		}

		try {
			multiMessageRelation = (List<MultiMessageRelation>) dao.getList(MultiMessageRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (multiMessageRelation == null ? "null" : multiMessageRelation.size()));
     }
		return multiMessageRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getMultiMessageRelationIdsByGroupID(Long groupID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by groupID,start,limit  : " + groupID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getMultiMessageRelationIdsByGroupID", new Object[] { groupID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by groupID,start,limit)  : " + groupID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
  }
		return idList;
		
	
	
	}
	
		
	

}

