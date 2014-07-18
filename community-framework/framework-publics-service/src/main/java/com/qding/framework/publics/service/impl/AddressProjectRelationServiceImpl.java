package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.AddressProjectRelation;
import com.qding.framework.publics.service.AddressProjectRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class AddressProjectRelationServiceImpl extends BaseDaoServiceImpl implements AddressProjectRelationService {

 

	private static final Log log = LogFactory.getLog(AddressProjectRelationServiceImpl.class);



		   
		@Override
		public Long insert(AddressProjectRelation addressProjectRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + addressProjectRelation);
 }
		if (addressProjectRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		addressProjectRelation.setCreateAt(currentTimeMillis);
		addressProjectRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(addressProjectRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + addressProjectRelation);
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
		public List<AddressProjectRelation> insertList(List<AddressProjectRelation> addressProjectRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (addressProjectRelationList == null ? "null" : addressProjectRelationList.size()));
      }
		List<AddressProjectRelation> resultList = null;

		if (CollectionUtils.isEmpty(addressProjectRelationList)) {
			return new ArrayList<AddressProjectRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AddressProjectRelation addressProjectRelation : addressProjectRelationList) {
			addressProjectRelation.setCreateAt(currentTimeMillis);
			addressProjectRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AddressProjectRelation>) dao.batchSave(addressProjectRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + addressProjectRelationList);
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
			result = dao.delete(AddressProjectRelation.class, id);
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
		public boolean update(AddressProjectRelation addressProjectRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (addressProjectRelation == null ? "null" : addressProjectRelation.getId()));

		boolean result = false;

		if (addressProjectRelation == null) {
			return true;
		}

		addressProjectRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(addressProjectRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + addressProjectRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + addressProjectRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AddressProjectRelation> addressProjectRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (addressProjectRelationList == null ? "null" : addressProjectRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(addressProjectRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AddressProjectRelation addressProjectRelation : addressProjectRelationList) {
			addressProjectRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(addressProjectRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + addressProjectRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + addressProjectRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public AddressProjectRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		AddressProjectRelation addressProjectRelation = null;

		if (id == null) {
			return addressProjectRelation;
		}

		try {
			addressProjectRelation = (AddressProjectRelation) dao.get(AddressProjectRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return addressProjectRelation;		
		}	
		  
    	   
		@Override
		public List<AddressProjectRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<AddressProjectRelation> addressProjectRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AddressProjectRelation>();
		}

		try {
			addressProjectRelation = (List<AddressProjectRelation>) dao.getList(AddressProjectRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (addressProjectRelation == null ? "null" : addressProjectRelation.size()));
     }
		return addressProjectRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getAddressProjectRelationIdsByProjectID(Long projectID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getAddressProjectRelationIdsByProjectID", new Object[] { projectID},start,limit, false);

   
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
	public Long  getAddressProjectRelationIdByAddressID(Long addressID)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by addressID  : " + addressID );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getAddressProjectRelationIdByAddressID", new Object[] {addressID });
   } catch (DaoException e) {
			log.error(" get id wrong by addressID  : " + addressID );
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
	public Integer  countAddressProjectRelationIdsByProjectID(Long projectID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by projectID  : " + projectID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getAddressProjectRelationIdsByProjectID", new Object[] { projectID});

   
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
	public List<Long> getAddressProjectRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAddressProjectRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAddressProjectRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAddressProjectRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAddressProjectRelationIds " ) ;
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

