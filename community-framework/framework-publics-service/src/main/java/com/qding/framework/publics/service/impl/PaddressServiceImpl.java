package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Paddress;
import com.qding.framework.publics.service.PaddressService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PaddressServiceImpl extends BaseDaoServiceImpl implements PaddressService {

   

	private static final Log log = LogFactory.getLog(PaddressServiceImpl.class);

	


		   
		@Override
		public Long insert(Paddress paddress)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + paddress);
 }
		if (paddress == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		paddress.setCreateAt(currentTimeMillis);
		paddress.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(paddress);
		} catch (DaoException e) {
			log.error(" insert wrong : " + paddress);
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
		public List<Paddress> insertList(List<Paddress> paddressList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (paddressList == null ? "null" : paddressList.size()));
      }
		List<Paddress> resultList = null;

		if (CollectionUtils.isEmpty(paddressList)) {
			return new ArrayList<Paddress>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Paddress paddress : paddressList) {
			paddress.setCreateAt(currentTimeMillis);
			paddress.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Paddress>) dao.batchSave(paddressList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + paddressList);
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
			result = dao.delete(Paddress.class, id);
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
		public boolean update(Paddress paddress)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (paddress == null ? "null" : paddress.getId()));

		boolean result = false;

		if (paddress == null) {
			return true;
		}

		paddress.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(paddress);
		} catch (DaoException e) {
			log.error(" update wrong : " + paddress);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + paddress);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Paddress> paddressList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (paddressList == null ? "null" : paddressList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(paddressList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Paddress paddress : paddressList) {
			paddress.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(paddressList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + paddressList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + paddressList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Paddress getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Paddress paddress = null;

		if (id == null) {
			return paddress;
		}

		try {
			paddress = (Paddress) dao.get(Paddress.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return paddress;		
		}	
		  
    	   
		@Override
		public List<Paddress> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Paddress> paddress = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Paddress>();
		}

		try {
			paddress = (List<Paddress>) dao.getList(Paddress.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (paddress == null ? "null" : paddress.size()));
     }
		return paddress;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPaddressIdByName(String name)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by name  : " + name );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getPaddressIdByName", new Object[] {name });
   } catch (DaoException e) {
			log.error(" get id wrong by name  : " + name );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getPaddressIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPaddressIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPaddressIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPaddressIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPaddressIds " ) ;
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

