package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.GorderGoodsRelation;
import com.qding.app.goods.service.GorderGoodsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class GorderGoodsRelationServiceImpl extends BaseDaoServiceImpl implements GorderGoodsRelationService {

 

	private static final Log log = LogFactory.getLog(GorderGoodsRelationServiceImpl.class);



		   
		@Override
		public Long insert(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + gorderGoodsRelation);
 }
		if (gorderGoodsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		gorderGoodsRelation.setCreateAt(currentTimeMillis);
		gorderGoodsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(gorderGoodsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + gorderGoodsRelation);
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
		public List<GorderGoodsRelation> insertList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (gorderGoodsRelationList == null ? "null" : gorderGoodsRelationList.size()));
      }
		List<GorderGoodsRelation> resultList = null;

		if (CollectionUtils.isEmpty(gorderGoodsRelationList)) {
			return new ArrayList<GorderGoodsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GorderGoodsRelation gorderGoodsRelation : gorderGoodsRelationList) {
			gorderGoodsRelation.setCreateAt(currentTimeMillis);
			gorderGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<GorderGoodsRelation>) dao.batchSave(gorderGoodsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + gorderGoodsRelationList);
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
			result = dao.delete(GorderGoodsRelation.class, id);
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
		public boolean update(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (gorderGoodsRelation == null ? "null" : gorderGoodsRelation.getId()));

		boolean result = false;

		if (gorderGoodsRelation == null) {
			return true;
		}

		gorderGoodsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(gorderGoodsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + gorderGoodsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + gorderGoodsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (gorderGoodsRelationList == null ? "null" : gorderGoodsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(gorderGoodsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GorderGoodsRelation gorderGoodsRelation : gorderGoodsRelationList) {
			gorderGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(gorderGoodsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + gorderGoodsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + gorderGoodsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public GorderGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		GorderGoodsRelation gorderGoodsRelation = null;

		if (id == null) {
			return gorderGoodsRelation;
		}

		try {
			gorderGoodsRelation = (GorderGoodsRelation) dao.get(GorderGoodsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return gorderGoodsRelation;		
		}	
		  
    	   
		@Override
		public List<GorderGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<GorderGoodsRelation> gorderGoodsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<GorderGoodsRelation>();
		}

		try {
			gorderGoodsRelation = (List<GorderGoodsRelation>) dao.getList(GorderGoodsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (gorderGoodsRelation == null ? "null" : gorderGoodsRelation.size()));
     }
		return gorderGoodsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getGorderGoodsRelationIdsByGoodsID", new Object[] { goodsID},start,limit, false);

   
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
	public List<Long>  getGorderGoodsRelationIdsByGorderID(Long gorderID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by gorderID,start,limit  : " + gorderID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getGorderGoodsRelationIdsByGorderID", new Object[] { gorderID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by gorderID,start,limit)  : " + gorderID+" , "+start+" , "+limit );
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
	public Integer  countGorderGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by goodsID  : " + goodsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderGoodsRelationIdsByGoodsID", new Object[] { goodsID});

   
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
	public Integer  countGorderGoodsRelationIdsByGorderID(Long gorderID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderID  : " + gorderID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderGoodsRelationIdsByGorderID", new Object[] { gorderID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by gorderID)  : " + gorderID );
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
	public List<Long> getGorderGoodsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGorderGoodsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGorderGoodsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGorderGoodsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGorderGoodsRelationIds " ) ;
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

