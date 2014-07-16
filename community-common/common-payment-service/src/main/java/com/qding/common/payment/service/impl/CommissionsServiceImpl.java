package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.Commissions;
import com.qding.common.payment.service.CommissionsService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CommissionsServiceImpl extends BaseDaoServiceImpl implements CommissionsService {

 

	private static final Log log = LogFactory.getLog(CommissionsServiceImpl.class);



		   
		@Override
		public Long insert(Commissions commissions)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + commissions);

		if (commissions == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		commissions.setCreateAt(currentTimeMillis);
		commissions.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(commissions);
		} catch (DaoException e) {
			log.error(" insert wrong : " + commissions);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Commissions> insertList(List<Commissions> commissionsList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (commissionsList == null ? "null" : commissionsList.size()));
      
		List<Commissions> resultList = null;

		if (CollectionUtils.isEmpty(commissionsList)) {
			return new ArrayList<Commissions>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Commissions commissions : commissionsList) {
			commissions.setCreateAt(currentTimeMillis);
			commissions.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Commissions>) dao.batchSave(commissionsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + commissionsList);
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
			result = dao.delete(Commissions.class, id);
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
		public boolean update(Commissions commissions)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (commissions == null ? "null" : commissions.getId()));

		boolean result = false;

		if (commissions == null) {
			return true;
		}

		commissions.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(commissions);
		} catch (DaoException e) {
			log.error(" update wrong : " + commissions);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + commissions);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Commissions> commissionsList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (commissionsList == null ? "null" : commissionsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(commissionsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Commissions commissions : commissionsList) {
			commissions.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(commissionsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + commissionsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + commissionsList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Commissions getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Commissions commissions = null;

		if (id == null) {
			return commissions;
		}

		try {
			commissions = (Commissions) dao.get(Commissions.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return commissions;		
		}	
		  
    	   
		@Override
		public List<Commissions> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Commissions> commissions = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Commissions>();
		}

		try {
			commissions = (List<Commissions>) dao.getList(Commissions.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (commissions == null ? "null" : commissions.size()));
    
		return commissions;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCommissionsIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCommissionsIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
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
	public Long  getCommissionsIdByGorderCodeAndType(String gorderCode,int type)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,type  : " + gorderCode+" , "+type );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCommissionsIdByGorderCodeAndType", new Object[] {gorderCode,type });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,type  : " + gorderCode+" , "+type );
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
	public Integer  countCommissionsIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCommissionsIdsByGorderCode", new Object[] { gorderCode});

   
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
	public List<Long> getCommissionsIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCommissionsIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCommissionsIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCommissionsIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCommissionsIds " ) ;
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

