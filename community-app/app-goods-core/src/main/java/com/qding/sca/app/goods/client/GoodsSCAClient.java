/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Goods;
import com.qding.app.goods.service.GoodsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GoodsSCAClient implements GoodsService {

    private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}
	
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService =goodsService;
	}
	
	
			   
		@Override
		public Long insert(Goods goods)throws ServiceException, ServiceDaoException{
		
		return goodsService.insert(goods);
		          
		
		}	
		  
    	   
		@Override
		public List<Goods> insertList(List<Goods> goodsList)throws ServiceException, ServiceDaoException{
		
		return goodsService.insertList(goodsList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return goodsService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Goods goods)throws ServiceException, ServiceDaoException{
		
		return goodsService.update(goods);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Goods> goodsList)throws ServiceException, ServiceDaoException{
		
		return goodsService.updateList(goodsList);
		          
		
		}	
		  
    	   
		@Override
		public Goods getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return goodsService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Goods> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return goodsService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getGoodsIdByName(String name)throws ServiceException, ServiceDaoException{
		
		return goodsService.getGoodsIdByName(name);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGoodsIdsByCategoryIDAndStatus(Long categoryID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return goodsService.getGoodsIdsByCategoryIDAndStatus(categoryID,status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGoodsIdsByCategoryIDAndStatus(Long categoryID,int status)throws ServiceException, ServiceDaoException{
		
		return goodsService.countGoodsIdsByCategoryIDAndStatus(categoryID,status);
	
	
	}
	
		
	
		@Override
	public List<Long> getGoodsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsService.getGoodsIds(start, limit);
	}

	@Override
	public Integer countGoodsIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsService.countGoodsIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   goodsService.deleteList(clz, ids);
		
	}


 
}

