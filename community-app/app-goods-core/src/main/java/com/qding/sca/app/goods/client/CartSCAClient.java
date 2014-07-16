/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Cart;
import com.qding.app.goods.service.CartService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CartSCAClient implements CartService {

    private CartService cartService;

	public CartService getCartService() {
		return cartService;
	}
	
	
	public void setCartService(CartService cartService) {
		this.cartService =cartService;
	}
	
	
			   
		@Override
		public Long insert(Cart cart)throws ServiceException, ServiceDaoException{
		
		return cartService.insert(cart);
		          
		
		}	
		  
    	   
		@Override
		public List<Cart> insertList(List<Cart> cartList)throws ServiceException, ServiceDaoException{
		
		return cartService.insertList(cartList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cartService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Cart cart)throws ServiceException, ServiceDaoException{
		
		return cartService.update(cart);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Cart> cartList)throws ServiceException, ServiceDaoException{
		
		return cartService.updateList(cartList);
		          
		
		}	
		  
    	   
		@Override
		public Cart getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cartService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Cart> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cartService.getObjectsByIds(ids);
		          
		
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
		
		return cartService.getCartIdByUserIDAndPublicsID(userID,publicsID);
	
	
	}
	
		
	
	
    		
	
		@Override
	public List<Long> getCartIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartService.getCartIds(start, limit);
	}

	@Override
	public Integer countCartIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartService.countCartIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cartService.deleteList(clz, ids);
		
	}


 
}

