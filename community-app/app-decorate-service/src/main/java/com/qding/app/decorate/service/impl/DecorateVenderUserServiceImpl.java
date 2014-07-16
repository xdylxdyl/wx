package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateVenderUser;
import com.qding.app.decorate.service.DecorateVenderUserService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecorateVenderUserServiceImpl extends BaseDaoServiceImpl implements DecorateVenderUserService {

 

	private static final Log log = LogFactory.getLog(DecorateVenderUserServiceImpl.class);



		   
		@Override
		public Long insert(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decorateVenderUser);

		if (decorateVenderUser == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decorateVenderUser.setCreateAt(currentTimeMillis);
		decorateVenderUser.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decorateVenderUser);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decorateVenderUser);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DecorateVenderUser> insertList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decorateVenderUserList == null ? "null" : decorateVenderUserList.size()));
      
		List<DecorateVenderUser> resultList = null;

		if (CollectionUtils.isEmpty(decorateVenderUserList)) {
			return new ArrayList<DecorateVenderUser>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateVenderUser decorateVenderUser : decorateVenderUserList) {
			decorateVenderUser.setCreateAt(currentTimeMillis);
			decorateVenderUser.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DecorateVenderUser>) dao.batchSave(decorateVenderUserList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decorateVenderUserList);
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
			result = dao.delete(DecorateVenderUser.class, id);
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
		public boolean update(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decorateVenderUser == null ? "null" : decorateVenderUser.getId()));

		boolean result = false;

		if (decorateVenderUser == null) {
			return true;
		}

		decorateVenderUser.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decorateVenderUser);
		} catch (DaoException e) {
			log.error(" update wrong : " + decorateVenderUser);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decorateVenderUser);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decorateVenderUserList == null ? "null" : decorateVenderUserList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decorateVenderUserList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DecorateVenderUser decorateVenderUser : decorateVenderUserList) {
			decorateVenderUser.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decorateVenderUserList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decorateVenderUserList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decorateVenderUserList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DecorateVenderUser getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DecorateVenderUser decorateVenderUser = null;

		if (id == null) {
			return decorateVenderUser;
		}

		try {
			decorateVenderUser = (DecorateVenderUser) dao.get(DecorateVenderUser.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decorateVenderUser;		
		}	
		  
    	   
		@Override
		public List<DecorateVenderUser> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DecorateVenderUser> decorateVenderUser = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DecorateVenderUser>();
		}

		try {
			decorateVenderUser = (List<DecorateVenderUser>) dao.getList(DecorateVenderUser.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decorateVenderUser == null ? "null" : decorateVenderUser.size()));
    
		return decorateVenderUser;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateVenderUserIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getDecorateVenderUserIdsByVenderId", new Object[] { venderId},start,limit, false);

   
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
	public Integer  countDecorateVenderUserIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by venderId  : " + venderId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateVenderUserIdsByVenderId", new Object[] { venderId});

   
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
	public List<Long> getDecorateVenderUserIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecorateVenderUserIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecorateVenderUserIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecorateVenderUserIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecorateVenderUserIds " ) ;
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

