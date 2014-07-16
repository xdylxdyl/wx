package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.GoodsPublicsRelation;
import com.qding.app.goods.service.GoodsPublicsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class GoodsPublicsRelationServiceImpl extends BaseDaoServiceImpl implements GoodsPublicsRelationService {

 

	private static final Log log = LogFactory.getLog(GoodsPublicsRelationServiceImpl.class);



		   
		@Override
		public Long insert(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + goodsPublicsRelation);
 }
		if (goodsPublicsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		goodsPublicsRelation.setCreateAt(currentTimeMillis);
		goodsPublicsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(goodsPublicsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + goodsPublicsRelation);
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
		public List<GoodsPublicsRelation> insertList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (goodsPublicsRelationList == null ? "null" : goodsPublicsRelationList.size()));
      }
		List<GoodsPublicsRelation> resultList = null;

		if (CollectionUtils.isEmpty(goodsPublicsRelationList)) {
			return new ArrayList<GoodsPublicsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GoodsPublicsRelation goodsPublicsRelation : goodsPublicsRelationList) {
			goodsPublicsRelation.setCreateAt(currentTimeMillis);
			goodsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<GoodsPublicsRelation>) dao.batchSave(goodsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + goodsPublicsRelationList);
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
			result = dao.delete(GoodsPublicsRelation.class, id);
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
		public boolean update(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (goodsPublicsRelation == null ? "null" : goodsPublicsRelation.getId()));

		boolean result = false;

		if (goodsPublicsRelation == null) {
			return true;
		}

		goodsPublicsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(goodsPublicsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + goodsPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + goodsPublicsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (goodsPublicsRelationList == null ? "null" : goodsPublicsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(goodsPublicsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GoodsPublicsRelation goodsPublicsRelation : goodsPublicsRelationList) {
			goodsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(goodsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + goodsPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + goodsPublicsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public GoodsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		GoodsPublicsRelation goodsPublicsRelation = null;

		if (id == null) {
			return goodsPublicsRelation;
		}

		try {
			goodsPublicsRelation = (GoodsPublicsRelation) dao.get(GoodsPublicsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return goodsPublicsRelation;		
		}	
		  
    	   
		@Override
		public List<GoodsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<GoodsPublicsRelation> goodsPublicsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<GoodsPublicsRelation>();
		}

		try {
			goodsPublicsRelation = (List<GoodsPublicsRelation>) dao.getList(GoodsPublicsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (goodsPublicsRelation == null ? "null" : goodsPublicsRelation.size()));
     }
		return goodsPublicsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGoodsPublicsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getGoodsPublicsRelationIdsByGoodsID", new Object[] { goodsID},start,limit, false);

   
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
	public List<Long>  getGoodsIDsByPublicsIDAndCategoryIDAndStatus(Long publicsID,Long categoryID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get goodsIDs by publicsID,categoryID,status,start,limit  : " + publicsID+" , "+categoryID+" , "+status+" , "+start+" , "+limit );
	  }
	 	List<Long> goodsIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		goodsIDList = dao.getIdList("getGoodsIDsByPublicsIDAndCategoryIDAndStatus", new Object[] { publicsID,categoryID,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get goodsIDs  wrong by publicsID,categoryID,status,start,limit)  : " + publicsID+" , "+categoryID+" , "+status+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get goodsIDs success : " + (goodsIDList == null ? "null" : goodsIDList.size()));
  }
		return goodsIDList;
		
	
	
	}
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGoodsPublicsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by goodsID  : " + goodsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGoodsPublicsRelationIdsByGoodsID", new Object[] { goodsID});

   
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
	public Integer  countGoodsIDsByPublicsIDAndCategoryIDAndStatus(Long publicsID,Long categoryID,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count goodsIDs by publicsID,categoryID,status  : " + publicsID+" , "+categoryID+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGoodsIDsByPublicsIDAndCategoryIDAndStatus", new Object[] { publicsID,categoryID,status});

   
   } catch (DaoException e) {
			log.error(" count goodsIDs  wrong by publicsID,categoryID,status)  : " + publicsID+" , "+categoryID+" , "+status );
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
	public List<Long> getGoodsPublicsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGoodsPublicsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGoodsPublicsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGoodsPublicsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGoodsPublicsRelationIds " ) ;
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

