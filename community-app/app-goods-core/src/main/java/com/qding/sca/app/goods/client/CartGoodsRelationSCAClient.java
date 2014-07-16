/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.CartGoodsRelation;
import com.qding.app.goods.service.CartGoodsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CartGoodsRelationSCAClient implements CartGoodsRelationService {

    private CartGoodsRelationService cartGoodsRelationService;

	public CartGoodsRelationService getCartGoodsRelationService() {
		return cartGoodsRelationService;
	}
	
	
	public void setCartGoodsRelationService(CartGoodsRelationService cartGoodsRelationService) {
		this.cartGoodsRelationService =cartGoodsRelationService;
	}
	
	
			   
		@Override
		public Long insert(CartGoodsRelation cartGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.insert(cartGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<CartGoodsRelation> insertList(List<CartGoodsRelation> cartGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.insertList(cartGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CartGoodsRelation cartGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.update(cartGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CartGoodsRelation> cartGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.updateList(cartGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public CartGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CartGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cartGoodsRelationService.getObjectsByIds(ids);
		          
		
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
		
		return cartGoodsRelationService.getCartGoodsRelationIdsByCartID(cartID,start,limit);
	
	
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
		
		return cartGoodsRelationService.getCartGoodsRelationIdsByGoodsID(goodsID,start,limit);
	
	
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
		
		return cartGoodsRelationService.countCartGoodsRelationIdsByCartID(cartID);
	
	
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
		
		return cartGoodsRelationService.countCartGoodsRelationIdsByGoodsID(goodsID);
	
	
	}
	
		
	
		@Override
	public List<Long> getCartGoodsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartGoodsRelationService.getCartGoodsRelationIds(start, limit);
	}

	@Override
	public Integer countCartGoodsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartGoodsRelationService.countCartGoodsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartGoodsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cartGoodsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cartGoodsRelationService.deleteList(clz, ids);
		
	}


 
}

