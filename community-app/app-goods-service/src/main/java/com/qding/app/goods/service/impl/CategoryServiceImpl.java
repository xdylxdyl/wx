package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Category;
import com.qding.app.goods.service.CategoryService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CategoryServiceImpl extends BaseDaoServiceImpl implements CategoryService {

 

	private static final Log log = LogFactory.getLog(CategoryServiceImpl.class);



		   
		@Override
		public Long insert(Category category)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + category);
 }
		if (category == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		category.setCreateAt(currentTimeMillis);
		category.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(category);
		} catch (DaoException e) {
			log.error(" insert wrong : " + category);
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
		public List<Category> insertList(List<Category> categoryList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (categoryList == null ? "null" : categoryList.size()));
      }
		List<Category> resultList = null;

		if (CollectionUtils.isEmpty(categoryList)) {
			return new ArrayList<Category>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Category category : categoryList) {
			category.setCreateAt(currentTimeMillis);
			category.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Category>) dao.batchSave(categoryList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + categoryList);
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
			result = dao.delete(Category.class, id);
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
		public boolean update(Category category)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (category == null ? "null" : category.getId()));

		boolean result = false;

		if (category == null) {
			return true;
		}

		category.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(category);
		} catch (DaoException e) {
			log.error(" update wrong : " + category);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + category);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Category> categoryList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (categoryList == null ? "null" : categoryList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(categoryList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Category category : categoryList) {
			category.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(categoryList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + categoryList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + categoryList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Category getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Category category = null;

		if (id == null) {
			return category;
		}

		try {
			category = (Category) dao.get(Category.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return category;		
		}	
		  
    	   
		@Override
		public List<Category> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Category> category = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Category>();
		}

		try {
			category = (List<Category>) dao.getList(Category.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (category == null ? "null" : category.size()));
     }
		return category;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCategoryIdsByStatus(int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,start,limit  : " + status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCategoryIdsByStatus", new Object[] { status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,start,limit)  : " + status+" , "+start+" , "+limit );
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
	public Long  getCategoryIdByName(String name)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by name  : " + name );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCategoryIdByName", new Object[] {name });
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
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCategoryIdsByStatus(int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status  : " + status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCategoryIdsByStatus", new Object[] { status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status)  : " + status );
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
	public List<Long> getCategoryIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCategoryIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCategoryIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCategoryIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCategoryIds " ) ;
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

