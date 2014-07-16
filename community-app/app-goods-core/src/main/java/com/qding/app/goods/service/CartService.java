package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Cart;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface CartService extends BaseDaoService {

	



   		   
		
		public Long insert(Cart cart)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Cart> insertList(List<Cart> cartList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Cart cart)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Cart> cartList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Cart getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Cart> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getCartIdByUserIDAndPublicsID(Long userID,Long publicsID)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCartIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCartIds() throws ServiceException, ServiceDaoException;
	

}

