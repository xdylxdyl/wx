package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.AddressUserRelation;
import com.qding.app.goods.service.AddressUserRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class AddressUserRelationServiceImpl extends BaseDaoServiceImpl implements AddressUserRelationService {

 

	private static final Log log = LogFactory.getLog(AddressUserRelationServiceImpl.class);



		   
		@Override
		public Long insert(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + addressUserRelation);
 }
		if (addressUserRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		addressUserRelation.setCreateAt(currentTimeMillis);
		addressUserRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(addressUserRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + addressUserRelation);
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
		public List<AddressUserRelation> insertList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (addressUserRelationList == null ? "null" : addressUserRelationList.size()));
      }
		List<AddressUserRelation> resultList = null;

		if (CollectionUtils.isEmpty(addressUserRelationList)) {
			return new ArrayList<AddressUserRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AddressUserRelation addressUserRelation : addressUserRelationList) {
			addressUserRelation.setCreateAt(currentTimeMillis);
			addressUserRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AddressUserRelation>) dao.batchSave(addressUserRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + addressUserRelationList);
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
			result = dao.delete(AddressUserRelation.class, id);
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
		public boolean update(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (addressUserRelation == null ? "null" : addressUserRelation.getId()));

		boolean result = false;

		if (addressUserRelation == null) {
			return true;
		}

		addressUserRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(addressUserRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + addressUserRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + addressUserRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (addressUserRelationList == null ? "null" : addressUserRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(addressUserRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AddressUserRelation addressUserRelation : addressUserRelationList) {
			addressUserRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(addressUserRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + addressUserRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + addressUserRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public AddressUserRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		AddressUserRelation addressUserRelation = null;

		if (id == null) {
			return addressUserRelation;
		}

		try {
			addressUserRelation = (AddressUserRelation) dao.get(AddressUserRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return addressUserRelation;		
		}	
		  
    	   
		@Override
		public List<AddressUserRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<AddressUserRelation> addressUserRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AddressUserRelation>();
		}

		try {
			addressUserRelation = (List<AddressUserRelation>) dao.getList(AddressUserRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (addressUserRelation == null ? "null" : addressUserRelation.size()));
     }
		return addressUserRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getAddressUserRelationIdByAddressID(Long addressID)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by addressID  : " + addressID );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getAddressUserRelationIdByAddressID", new Object[] {addressID });
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
	public List<Long>  getAddressUserRelationIdsByUserID(Long userID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userID,start,limit  : " + userID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getAddressUserRelationIdsByUserID", new Object[] { userID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userID,start,limit)  : " + userID+" , "+start+" , "+limit );
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
	public Integer  countAddressUserRelationIdsByUserID(Long userID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userID  : " + userID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getAddressUserRelationIdsByUserID", new Object[] { userID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userID)  : " + userID );
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
	public List<Long> getAddressUserRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAddressUserRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAddressUserRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAddressUserRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAddressUserRelationIds " ) ;
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

