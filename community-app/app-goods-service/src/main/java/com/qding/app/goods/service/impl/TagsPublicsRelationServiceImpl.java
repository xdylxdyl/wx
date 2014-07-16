package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.TagsPublicsRelation;
import com.qding.app.goods.service.TagsPublicsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class TagsPublicsRelationServiceImpl extends BaseDaoServiceImpl implements TagsPublicsRelationService {

 

	private static final Log log = LogFactory.getLog(TagsPublicsRelationServiceImpl.class);



		   
		@Override
		public Long insert(TagsPublicsRelation tagsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + tagsPublicsRelation);
 }
		if (tagsPublicsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		tagsPublicsRelation.setCreateAt(currentTimeMillis);
		tagsPublicsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(tagsPublicsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + tagsPublicsRelation);
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
		public List<TagsPublicsRelation> insertList(List<TagsPublicsRelation> tagsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (tagsPublicsRelationList == null ? "null" : tagsPublicsRelationList.size()));
      }
		List<TagsPublicsRelation> resultList = null;

		if (CollectionUtils.isEmpty(tagsPublicsRelationList)) {
			return new ArrayList<TagsPublicsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TagsPublicsRelation tagsPublicsRelation : tagsPublicsRelationList) {
			tagsPublicsRelation.setCreateAt(currentTimeMillis);
			tagsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<TagsPublicsRelation>) dao.batchSave(tagsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + tagsPublicsRelationList);
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
			result = dao.delete(TagsPublicsRelation.class, id);
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
		public boolean update(TagsPublicsRelation tagsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (tagsPublicsRelation == null ? "null" : tagsPublicsRelation.getId()));

		boolean result = false;

		if (tagsPublicsRelation == null) {
			return true;
		}

		tagsPublicsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(tagsPublicsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + tagsPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + tagsPublicsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<TagsPublicsRelation> tagsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (tagsPublicsRelationList == null ? "null" : tagsPublicsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(tagsPublicsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TagsPublicsRelation tagsPublicsRelation : tagsPublicsRelationList) {
			tagsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(tagsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + tagsPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + tagsPublicsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public TagsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		TagsPublicsRelation tagsPublicsRelation = null;

		if (id == null) {
			return tagsPublicsRelation;
		}

		try {
			tagsPublicsRelation = (TagsPublicsRelation) dao.get(TagsPublicsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return tagsPublicsRelation;		
		}	
		  
    	   
		@Override
		public List<TagsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<TagsPublicsRelation> tagsPublicsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<TagsPublicsRelation>();
		}

		try {
			tagsPublicsRelation = (List<TagsPublicsRelation>) dao.getList(TagsPublicsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (tagsPublicsRelation == null ? "null" : tagsPublicsRelation.size()));
     }
		return tagsPublicsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsPublicsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by publicsID,start,limit  : " + publicsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTagsPublicsRelationIdsByPublicsID", new Object[] { publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,start,limit)  : " + publicsID+" , "+start+" , "+limit );
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
	public List<Long>  getTagsPublicsRelationIdsByTagsID(Long tagsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by tagsID,start,limit  : " + tagsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTagsPublicsRelationIdsByTagsID", new Object[] { tagsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by tagsID,start,limit)  : " + tagsID+" , "+start+" , "+limit );
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
	public Integer  countTagsPublicsRelationIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTagsPublicsRelationIdsByPublicsID", new Object[] { publicsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by publicsID)  : " + publicsID );
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
	public Integer  countTagsPublicsRelationIdsByTagsID(Long tagsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by tagsID  : " + tagsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTagsPublicsRelationIdsByTagsID", new Object[] { tagsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by tagsID)  : " + tagsID );
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
	public List<Long> getTagsPublicsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTagsPublicsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTagsPublicsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTagsPublicsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTagsPublicsRelationIds " ) ;
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

