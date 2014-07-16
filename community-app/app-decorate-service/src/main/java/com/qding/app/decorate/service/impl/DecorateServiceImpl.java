package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.Decorate;
import com.qding.app.decorate.service.DecorateService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class DecorateServiceImpl extends BaseDaoServiceImpl implements DecorateService {

 

	private static final Log log = LogFactory.getLog(DecorateServiceImpl.class);



		   
		@Override
		public Long insert(Decorate decorate)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + decorate);

		if (decorate == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		decorate.setCreateAt(currentTimeMillis);
		decorate.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(decorate);
		} catch (DaoException e) {
			log.error(" insert wrong : " + decorate);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Decorate> insertList(List<Decorate> decorateList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (decorateList == null ? "null" : decorateList.size()));
      
		List<Decorate> resultList = null;

		if (CollectionUtils.isEmpty(decorateList)) {
			return new ArrayList<Decorate>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Decorate decorate : decorateList) {
			decorate.setCreateAt(currentTimeMillis);
			decorate.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Decorate>) dao.batchSave(decorateList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + decorateList);
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
			result = dao.delete(Decorate.class, id);
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
		public boolean update(Decorate decorate)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (decorate == null ? "null" : decorate.getId()));

		boolean result = false;

		if (decorate == null) {
			return true;
		}

		decorate.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(decorate);
		} catch (DaoException e) {
			log.error(" update wrong : " + decorate);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + decorate);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Decorate> decorateList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (decorateList == null ? "null" : decorateList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(decorateList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Decorate decorate : decorateList) {
			decorate.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(decorateList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + decorateList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + decorateList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Decorate getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Decorate decorate = null;

		if (id == null) {
			return decorate;
		}

		try {
			decorate = (Decorate) dao.get(Decorate.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return decorate;		
		}	
		  
    	   
		@Override
		public List<Decorate> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Decorate> decorate = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Decorate>();
		}

		try {
			decorate = (List<Decorate>) dao.getList(Decorate.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (decorate == null ? "null" : decorate.size()));
    
		return decorate;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByUserId(String userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userId,start,limit  : " + userId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateIdsByUserId", new Object[] { userId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userId,start,limit)  : " + userId+" , "+start+" , "+limit );
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
	public List<Long>  getDecorateIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getDecorateIdsByVenderId", new Object[] { venderId},start,limit, false);

   
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
	public List<Long>  getDecorateIdsByPublicsId(Long publicsId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by publicsId,start,limit  : " + publicsId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateIdsByPublicsId", new Object[] { publicsId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by publicsId,start,limit)  : " + publicsId+" , "+start+" , "+limit );
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
	public List<Long>  getDecorateIdsByRoomId(Long roomId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by roomId,start,limit  : " + roomId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateIdsByRoomId", new Object[] { roomId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by roomId,start,limit)  : " + roomId+" , "+start+" , "+limit );
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
	public List<Long>  getDecorateIdsByUserMobile(String userMobile,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userMobile,start,limit  : " + userMobile+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDecorateIdsByUserMobile", new Object[] { userMobile},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userMobile,start,limit)  : " + userMobile+" , "+start+" , "+limit );
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
	public Integer  countDecorateIdsByUserId(String userId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateIdsByUserId", new Object[] { userId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userId)  : " + userId );
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
	public Integer  countDecorateIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by venderId  : " + venderId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateIdsByVenderId", new Object[] { venderId});

   
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
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByPublicsId(Long publicsId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsId  : " + publicsId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateIdsByPublicsId", new Object[] { publicsId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by publicsId)  : " + publicsId );
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
	public Integer  countDecorateIdsByRoomId(Long roomId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by roomId  : " + roomId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateIdsByRoomId", new Object[] { roomId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by roomId)  : " + roomId );
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
	public Integer  countDecorateIdsByUserMobile(String userMobile)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userMobile  : " + userMobile );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDecorateIdsByUserMobile", new Object[] { userMobile});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userMobile)  : " + userMobile );
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
	public List<Long> getDecorateIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDecorateIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDecorateIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDecorateIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDecorateIds " ) ;
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

