package com.qding.app.decorate.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.Images;
import com.qding.app.decorate.service.ImagesService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class ImagesServiceImpl extends BaseDaoServiceImpl implements ImagesService {

 

	private static final Log log = LogFactory.getLog(ImagesServiceImpl.class);



		   
		@Override
		public Long insert(Images images)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + images);

		if (images == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		images.setCreateAt(currentTimeMillis);
		images.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(images);
		} catch (DaoException e) {
			log.error(" insert wrong : " + images);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Images> insertList(List<Images> imagesList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (imagesList == null ? "null" : imagesList.size()));
      
		List<Images> resultList = null;

		if (CollectionUtils.isEmpty(imagesList)) {
			return new ArrayList<Images>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Images images : imagesList) {
			images.setCreateAt(currentTimeMillis);
			images.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Images>) dao.batchSave(imagesList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + imagesList);
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
			result = dao.delete(Images.class, id);
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
		public boolean update(Images images)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (images == null ? "null" : images.getId()));

		boolean result = false;

		if (images == null) {
			return true;
		}

		images.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(images);
		} catch (DaoException e) {
			log.error(" update wrong : " + images);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + images);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Images> imagesList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (imagesList == null ? "null" : imagesList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(imagesList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Images images : imagesList) {
			images.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(imagesList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + imagesList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + imagesList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Images getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Images images = null;

		if (id == null) {
			return images;
		}

		try {
			images = (Images) dao.get(Images.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return images;		
		}	
		  
    	   
		@Override
		public List<Images> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Images> images = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Images>();
		}

		try {
			images = (List<Images>) dao.getList(Images.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (images == null ? "null" : images.size()));
    
		return images;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getImagesIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getImagesIdsAll",new Object[] {},start, limit, false);
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
	public Integer countImagesIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getImagesIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getImagesIds " ) ;
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

