package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.ProviderPublicsRelation;
import com.qding.app.goods.service.ProviderPublicsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class ProviderPublicsRelationServiceImpl extends BaseDaoServiceImpl implements ProviderPublicsRelationService {

 

	private static final Log log = LogFactory.getLog(ProviderPublicsRelationServiceImpl.class);



		   
		@Override
		public Long insert(ProviderPublicsRelation providerPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + providerPublicsRelation);

		if (providerPublicsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		providerPublicsRelation.setCreateAt(currentTimeMillis);
		providerPublicsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(providerPublicsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + providerPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<ProviderPublicsRelation> insertList(List<ProviderPublicsRelation> providerPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (providerPublicsRelationList == null ? "null" : providerPublicsRelationList.size()));
      
		List<ProviderPublicsRelation> resultList = null;

		if (CollectionUtils.isEmpty(providerPublicsRelationList)) {
			return new ArrayList<ProviderPublicsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ProviderPublicsRelation providerPublicsRelation : providerPublicsRelationList) {
			providerPublicsRelation.setCreateAt(currentTimeMillis);
			providerPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<ProviderPublicsRelation>) dao.batchSave(providerPublicsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + providerPublicsRelationList);
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
			result = dao.delete(ProviderPublicsRelation.class, id);
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
		public boolean update(ProviderPublicsRelation providerPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (providerPublicsRelation == null ? "null" : providerPublicsRelation.getId()));

		boolean result = false;

		if (providerPublicsRelation == null) {
			return true;
		}

		providerPublicsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(providerPublicsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + providerPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + providerPublicsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<ProviderPublicsRelation> providerPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (providerPublicsRelationList == null ? "null" : providerPublicsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(providerPublicsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (ProviderPublicsRelation providerPublicsRelation : providerPublicsRelationList) {
			providerPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(providerPublicsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + providerPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + providerPublicsRelationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public ProviderPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		ProviderPublicsRelation providerPublicsRelation = null;

		if (id == null) {
			return providerPublicsRelation;
		}

		try {
			providerPublicsRelation = (ProviderPublicsRelation) dao.get(ProviderPublicsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return providerPublicsRelation;		
		}	
		  
    	   
		@Override
		public List<ProviderPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<ProviderPublicsRelation> providerPublicsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<ProviderPublicsRelation>();
		}

		try {
			providerPublicsRelation = (List<ProviderPublicsRelation>) dao.getList(ProviderPublicsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (providerPublicsRelation == null ? "null" : providerPublicsRelation.size()));
    
		return providerPublicsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderPublicsRelationIdsByProviderID(Long providerID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by providerID,start,limit  : " + providerID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getProviderPublicsRelationIdsByProviderID", new Object[] { providerID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by providerID,start,limit)  : " + providerID+" , "+start+" , "+limit );
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
	public List<Long>  getProviderPublicsRelationIdsByPublicsIDAndStatus(Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by publicsID,status,start,limit  : " + publicsID+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getProviderPublicsRelationIdsByPublicsIDAndStatus", new Object[] { publicsID,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,status,start,limit)  : " + publicsID+" , "+status+" , "+start+" , "+limit );
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
	public List<Long>  getProviderIDsByPublicsIDAndStatus(Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get providerIDs by publicsID,status,start,limit  : " + publicsID+" , "+status+" , "+start+" , "+limit );
	  }
	 	List<Long> providerIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		providerIDList = dao.getIdList("getProviderIDsByPublicsIDAndStatus", new Object[] { publicsID,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get providerIDs  wrong by publicsID,status,start,limit)  : " + publicsID+" , "+status+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get providerIDs success : " + (providerIDList == null ? "null" : providerIDList.size()));
  }
		return providerIDList;
		
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderIDsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get providerIDs by publicsID,start,limit  : " + publicsID+" , "+start+" , "+limit );
	  }
	 	List<Long> providerIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		providerIDList = dao.getIdList("getProviderIDsByPublicsID", new Object[] { publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get providerIDs  wrong by publicsID,start,limit)  : " + publicsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get providerIDs success : " + (providerIDList == null ? "null" : providerIDList.size()));
  }
		return providerIDList;
		
	
	
	}
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProviderPublicsRelationIdsByProviderID(Long providerID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by providerID  : " + providerID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getProviderPublicsRelationIdsByProviderID", new Object[] { providerID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by providerID)  : " + providerID );
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
	public Integer  countProviderPublicsRelationIdsByPublicsIDAndStatus(Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsID,status  : " + publicsID+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getProviderPublicsRelationIdsByPublicsIDAndStatus", new Object[] { publicsID,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by publicsID,status)  : " + publicsID+" , "+status );
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
	public Integer  countProviderIDsByPublicsIDAndStatus(Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count providerIDs by publicsID,status  : " + publicsID+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getProviderIDsByPublicsIDAndStatus", new Object[] { publicsID,status});

   
   } catch (DaoException e) {
			log.error(" count providerIDs  wrong by publicsID,status)  : " + publicsID+" , "+status );
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
	public Integer  countProviderIDsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count providerIDs by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getProviderIDsByPublicsID", new Object[] { publicsID});

   
   } catch (DaoException e) {
			log.error(" count providerIDs  wrong by publicsID)  : " + publicsID );
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
	public List<Long> getProviderPublicsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getProviderPublicsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countProviderPublicsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getProviderPublicsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getProviderPublicsRelationIds " ) ;
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

