package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.PublicsProjectRelation;
import com.qding.framework.publics.service.PublicsProjectRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PublicsProjectRelationServiceImpl extends BaseDaoServiceImpl implements PublicsProjectRelationService {

 

	private static final Log log = LogFactory.getLog(PublicsProjectRelationServiceImpl.class);



		   
		@Override
		public Long insert(PublicsProjectRelation publicsProjectRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + publicsProjectRelation);
 }
		if (publicsProjectRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		publicsProjectRelation.setCreateAt(currentTimeMillis);
		publicsProjectRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(publicsProjectRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + publicsProjectRelation);
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
		public List<PublicsProjectRelation> insertList(List<PublicsProjectRelation> publicsProjectRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (publicsProjectRelationList == null ? "null" : publicsProjectRelationList.size()));
      }
		List<PublicsProjectRelation> resultList = null;

		if (CollectionUtils.isEmpty(publicsProjectRelationList)) {
			return new ArrayList<PublicsProjectRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PublicsProjectRelation publicsProjectRelation : publicsProjectRelationList) {
			publicsProjectRelation.setCreateAt(currentTimeMillis);
			publicsProjectRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PublicsProjectRelation>) dao.batchSave(publicsProjectRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + publicsProjectRelationList);
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
			result = dao.delete(PublicsProjectRelation.class, id);
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
		public boolean update(PublicsProjectRelation publicsProjectRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (publicsProjectRelation == null ? "null" : publicsProjectRelation.getId()));

		boolean result = false;

		if (publicsProjectRelation == null) {
			return true;
		}

		publicsProjectRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(publicsProjectRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + publicsProjectRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + publicsProjectRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PublicsProjectRelation> publicsProjectRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (publicsProjectRelationList == null ? "null" : publicsProjectRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(publicsProjectRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PublicsProjectRelation publicsProjectRelation : publicsProjectRelationList) {
			publicsProjectRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(publicsProjectRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + publicsProjectRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + publicsProjectRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public PublicsProjectRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		PublicsProjectRelation publicsProjectRelation = null;

		if (id == null) {
			return publicsProjectRelation;
		}

		try {
			publicsProjectRelation = (PublicsProjectRelation) dao.get(PublicsProjectRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return publicsProjectRelation;		
		}	
		  
    	   
		@Override
		public List<PublicsProjectRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<PublicsProjectRelation> publicsProjectRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PublicsProjectRelation>();
		}

		try {
			publicsProjectRelation = (List<PublicsProjectRelation>) dao.getList(PublicsProjectRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (publicsProjectRelation == null ? "null" : publicsProjectRelation.size()));
     }
		return publicsProjectRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPublicsProjectRelationIdByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by publicsID  : " + publicsID );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getPublicsProjectRelationIdByPublicsID", new Object[] {publicsID });
   } catch (DaoException e) {
			log.error(" get id wrong by publicsID  : " + publicsID );
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
	public List<Long>  getPublicsProjectRelationIdsByProjectID(Long projectID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by projectID,start,limit  : " + projectID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPublicsProjectRelationIdsByProjectID", new Object[] { projectID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by projectID,start,limit)  : " + projectID+" , "+start+" , "+limit );
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
	public Integer  countPublicsProjectRelationIdsByProjectID(Long projectID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by projectID  : " + projectID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPublicsProjectRelationIdsByProjectID", new Object[] { projectID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by projectID)  : " + projectID );
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
	public List<Long> getPublicsProjectRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPublicsProjectRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPublicsProjectRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPublicsProjectRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPublicsProjectRelationIds " ) ;
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

