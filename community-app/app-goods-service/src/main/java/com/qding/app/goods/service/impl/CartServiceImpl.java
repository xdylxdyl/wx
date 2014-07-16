package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Cart;
import com.qding.app.goods.service.CartService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CartServiceImpl extends BaseDaoServiceImpl implements CartService {

 

	private static final Log log = LogFactory.getLog(CartServiceImpl.class);



		   
		@Override
		public Long insert(Cart cart)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + cart);
 }
		if (cart == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cart.setCreateAt(currentTimeMillis);
		cart.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cart);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cart);
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
		public List<Cart> insertList(List<Cart> cartList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (cartList == null ? "null" : cartList.size()));
      }
		List<Cart> resultList = null;

		if (CollectionUtils.isEmpty(cartList)) {
			return new ArrayList<Cart>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Cart cart : cartList) {
			cart.setCreateAt(currentTimeMillis);
			cart.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Cart>) dao.batchSave(cartList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cartList);
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
			result = dao.delete(Cart.class, id);
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
		public boolean update(Cart cart)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cart == null ? "null" : cart.getId()));

		boolean result = false;

		if (cart == null) {
			return true;
		}

		cart.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cart);
		} catch (DaoException e) {
			log.error(" update wrong : " + cart);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cart);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Cart> cartList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cartList == null ? "null" : cartList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cartList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Cart cart : cartList) {
			cart.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cartList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cartList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + cartList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Cart getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Cart cart = null;

		if (id == null) {
			return cart;
		}

		try {
			cart = (Cart) dao.get(Cart.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return cart;		
		}	
		  
    	   
		@Override
		public List<Cart> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Cart> cart = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Cart>();
		}

		try {
			cart = (List<Cart>) dao.getList(Cart.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (cart == null ? "null" : cart.size()));
     }
		return cart;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCartIdByUserIDAndPublicsID(Long userID,Long publicsID)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by userID,publicsID  : " + userID+" , "+publicsID );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getCartIdByUserIDAndPublicsID", new Object[] {userID,publicsID });
   } catch (DaoException e) {
			log.error(" get id wrong by userID,publicsID  : " + userID+" , "+publicsID );
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
	public List<Long> getCartIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCartIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCartIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCartIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCartIds " ) ;
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

