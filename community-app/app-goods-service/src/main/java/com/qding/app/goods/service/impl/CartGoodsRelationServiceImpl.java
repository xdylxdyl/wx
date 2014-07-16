package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.CartGoodsRelation;
import com.qding.app.goods.service.CartGoodsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CartGoodsRelationServiceImpl extends BaseDaoServiceImpl implements CartGoodsRelationService {

 

	private static final Log log = LogFactory.getLog(CartGoodsRelationServiceImpl.class);



		   
		@Override
		public Long insert(CartGoodsRelation cartGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + cartGoodsRelation);
 }
		if (cartGoodsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cartGoodsRelation.setCreateAt(currentTimeMillis);
		cartGoodsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cartGoodsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cartGoodsRelation);
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
		public List<CartGoodsRelation> insertList(List<CartGoodsRelation> cartGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (cartGoodsRelationList == null ? "null" : cartGoodsRelationList.size()));
      }
		List<CartGoodsRelation> resultList = null;

		if (CollectionUtils.isEmpty(cartGoodsRelationList)) {
			return new ArrayList<CartGoodsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CartGoodsRelation cartGoodsRelation : cartGoodsRelationList) {
			cartGoodsRelation.setCreateAt(currentTimeMillis);
			cartGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CartGoodsRelation>) dao.batchSave(cartGoodsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cartGoodsRelationList);
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
			result = dao.delete(CartGoodsRelation.class, id);
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
		public boolean update(CartGoodsRelation cartGoodsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cartGoodsRelation == null ? "null" : cartGoodsRelation.getId()));

		boolean result = false;

		if (cartGoodsRelation == null) {
			return true;
		}

		cartGoodsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cartGoodsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + cartGoodsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cartGoodsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CartGoodsRelation> cartGoodsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cartGoodsRelationList == null ? "null" : cartGoodsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cartGoodsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CartGoodsRelation cartGoodsRelation : cartGoodsRelationList) {
			cartGoodsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cartGoodsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cartGoodsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + cartGoodsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public CartGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		CartGoodsRelation cartGoodsRelation = null;

		if (id == null) {
			return cartGoodsRelation;
		}

		try {
			cartGoodsRelation = (CartGoodsRelation) dao.get(CartGoodsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return cartGoodsRelation;		
		}	
		  
    	   
		@Override
		public List<CartGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<CartGoodsRelation> cartGoodsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CartGoodsRelation>();
		}

		try {
			cartGoodsRelation = (List<CartGoodsRelation>) dao.getList(CartGoodsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (cartGoodsRelation == null ? "null" : cartGoodsRelation.size()));
     }
		return cartGoodsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCartGoodsRelationIdsByCartID(Long cartID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by cartID,start,limit  : " + cartID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCartGoodsRelationIdsByCartID", new Object[] { cartID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by cartID,start,limit)  : " + cartID+" , "+start+" , "+limit );
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
	public List<Long>  getCartGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCartGoodsRelationIdsByGoodsID", new Object[] { goodsID},start,limit, false);

   
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
	public Integer  countCartGoodsRelationIdsByCartID(Long cartID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by cartID  : " + cartID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCartGoodsRelationIdsByCartID", new Object[] { cartID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by cartID)  : " + cartID );
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
	public Integer  countCartGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by goodsID  : " + goodsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCartGoodsRelationIdsByGoodsID", new Object[] { goodsID});

   
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
	
		
	
	
	
		
	@Override
	public List<Long> getCartGoodsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCartGoodsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCartGoodsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCartGoodsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCartGoodsRelationIds " ) ;
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

