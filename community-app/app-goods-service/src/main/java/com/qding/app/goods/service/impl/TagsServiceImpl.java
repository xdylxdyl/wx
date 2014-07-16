package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Tags;
import com.qding.app.goods.service.TagsService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class TagsServiceImpl extends BaseDaoServiceImpl implements TagsService {

 

	private static final Log log = LogFactory.getLog(TagsServiceImpl.class);



		   
		@Override
		public Long insert(Tags tags)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + tags);
 }
		if (tags == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		tags.setCreateAt(currentTimeMillis);
		tags.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(tags);
		} catch (DaoException e) {
			log.error(" insert wrong : " + tags);
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
		public List<Tags> insertList(List<Tags> tagsList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (tagsList == null ? "null" : tagsList.size()));
      }
		List<Tags> resultList = null;

		if (CollectionUtils.isEmpty(tagsList)) {
			return new ArrayList<Tags>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Tags tags : tagsList) {
			tags.setCreateAt(currentTimeMillis);
			tags.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Tags>) dao.batchSave(tagsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + tagsList);
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
			result = dao.delete(Tags.class, id);
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
		public boolean update(Tags tags)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (tags == null ? "null" : tags.getId()));

		boolean result = false;

		if (tags == null) {
			return true;
		}

		tags.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(tags);
		} catch (DaoException e) {
			log.error(" update wrong : " + tags);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + tags);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Tags> tagsList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (tagsList == null ? "null" : tagsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(tagsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Tags tags : tagsList) {
			tags.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(tagsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + tagsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + tagsList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Tags getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Tags tags = null;

		if (id == null) {
			return tags;
		}

		try {
			tags = (Tags) dao.get(Tags.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return tags;		
		}	
		  
    	   
		@Override
		public List<Tags> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Tags> tags = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Tags>();
		}

		try {
			tags = (List<Tags>) dao.getList(Tags.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (tags == null ? "null" : tags.size()));
     }
		return tags;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getTagsIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTagsIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTagsIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTagsIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTagsIds " ) ;
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

