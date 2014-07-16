package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.TagsGoodsRelation;
import com.qding.app.goods.service.TagsGoodsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class TagsGoodsRelationServiceImpl extends BaseDaoServiceImpl implements TagsGoodsRelationService {

 

	private static final Log log = LogFactory.getLog(TagsGoodsRelationServiceImpl.class);



		   
		@Override
		public Long insert(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + tagsGoodsRelation);
 }
		if (tagsGoodsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		tagsGoodsRelation.setCreateAt(currentTimeMillis);
		tagsGoodsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(tagsGoodsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + tagsGoodsRelation);
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
		public List<TagsGoodsRelation> insertList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (tagsGoodsRelationList == null ? "null" : tagsGoodsRelationList.size()));
      }
		List<TagsGoodsRelation> resultList = null;

		if (CollectionUtils.isEmpty(tagsGoodsRelationList)) {
			return new ArrayList<TagsGoodsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TagsGoodsRelation tagsGoodsRelation : tagsGoodsRelationList) {
			tagsGoodsRelation.setCreateAt(currentTimeMillis);
			tagsGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<TagsGoodsRelation>) dao.batchSave(tagsGoodsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + tagsGoodsRelationList);
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
			result = dao.delete(TagsGoodsRelation.class, id);
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
		public boolean update(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (tagsGoodsRelation == null ? "null" : tagsGoodsRelation.getId()));

		boolean result = false;

		if (tagsGoodsRelation == null) {
			return true;
		}

		tagsGoodsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(tagsGoodsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + tagsGoodsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + tagsGoodsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (tagsGoodsRelationList == null ? "null" : tagsGoodsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(tagsGoodsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TagsGoodsRelation tagsGoodsRelation : tagsGoodsRelationList) {
			tagsGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(tagsGoodsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + tagsGoodsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + tagsGoodsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public TagsGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		TagsGoodsRelation tagsGoodsRelation = null;

		if (id == null) {
			return tagsGoodsRelation;
		}

		try {
			tagsGoodsRelation = (TagsGoodsRelation) dao.get(TagsGoodsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return tagsGoodsRelation;		
		}	
		  
    	   
		@Override
		public List<TagsGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<TagsGoodsRelation> tagsGoodsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<TagsGoodsRelation>();
		}

		try {
			tagsGoodsRelation = (List<TagsGoodsRelation>) dao.getList(TagsGoodsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (tagsGoodsRelation == null ? "null" : tagsGoodsRelation.size()));
     }
		return tagsGoodsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get tagsIDs by goodsID,publicsID,start,limit  : " + goodsID+" , "+publicsID+" , "+start+" , "+limit );
	  }
	 	List<Long> tagsIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		tagsIDList = dao.getIdList("getTagsIDsByGoodsIDAndPublicsID", new Object[] { goodsID,publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get tagsIDs  wrong by goodsID,publicsID,start,limit)  : " + goodsID+" , "+publicsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get tagsIDs success : " + (tagsIDList == null ? "null" : tagsIDList.size()));
  }
		return tagsIDList;
		
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by goodsID,start,limit  : " + goodsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTagsGoodsRelationIdsByGoodsID", new Object[] { goodsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by goodsID,start,limit)  : " + goodsID+" , "+start+" , "+limit );
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
	public List<Long>  getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by tagsID,publicsID,status,start,limit  : " + tagsID+" , "+publicsID+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus", new Object[] { tagsID,publicsID,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by tagsID,publicsID,status,start,limit)  : " + tagsID+" , "+publicsID+" , "+status+" , "+start+" , "+limit );
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
	public Integer  countTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count tagsIDs by goodsID,publicsID  : " + goodsID+" , "+publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTagsIDsByGoodsIDAndPublicsID", new Object[] { goodsID,publicsID});

   
   } catch (DaoException e) {
			log.error(" count tagsIDs  wrong by goodsID,publicsID)  : " + goodsID+" , "+publicsID );
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
	public Integer  countTagsGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by goodsID  : " + goodsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTagsGoodsRelationIdsByGoodsID", new Object[] { goodsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by goodsID)  : " + goodsID );
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
	public Integer  countTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by tagsID,publicsID,status  : " + tagsID+" , "+publicsID+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus", new Object[] { tagsID,publicsID,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by tagsID,publicsID,status)  : " + tagsID+" , "+publicsID+" , "+status );
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
	public List<Long> getTagsGoodsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTagsGoodsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTagsGoodsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTagsGoodsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTagsGoodsRelationIds " ) ;
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

