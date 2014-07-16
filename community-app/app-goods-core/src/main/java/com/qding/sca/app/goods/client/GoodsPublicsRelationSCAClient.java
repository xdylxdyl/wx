/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.GoodsPublicsRelation;
import com.qding.app.goods.service.GoodsPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GoodsPublicsRelationSCAClient implements GoodsPublicsRelationService {

    private GoodsPublicsRelationService goodsPublicsRelationService;

	public GoodsPublicsRelationService getGoodsPublicsRelationService() {
		return goodsPublicsRelationService;
	}
	
	
	public void setGoodsPublicsRelationService(GoodsPublicsRelationService goodsPublicsRelationService) {
		this.goodsPublicsRelationService =goodsPublicsRelationService;
	}
	
	
			   
		@Override
		public Long insert(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.insert(goodsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<GoodsPublicsRelation> insertList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.insertList(goodsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.update(goodsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.updateList(goodsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public GoodsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<GoodsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return goodsPublicsRelationService.getObjectsByIds(ids);
		          
		
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
		
		return goodsPublicsRelationService.getGoodsPublicsRelationIdsByGoodsID(goodsID,start,limit);
	
	
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
		
		return goodsPublicsRelationService.getGoodsIDsByPublicsIDAndCategoryIDAndStatus(publicsID,categoryID,status,start,limit);
	
	
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
		
		return goodsPublicsRelationService.countGoodsPublicsRelationIdsByGoodsID(goodsID);
	
	
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
		
		return goodsPublicsRelationService.countGoodsIDsByPublicsIDAndCategoryIDAndStatus(publicsID,categoryID,status);
	
	
	}
	
		
	
		@Override
	public List<Long> getGoodsPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsPublicsRelationService.getGoodsPublicsRelationIds(start, limit);
	}

	@Override
	public Integer countGoodsPublicsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsPublicsRelationService.countGoodsPublicsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsPublicsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return goodsPublicsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   goodsPublicsRelationService.deleteList(clz, ids);
		
	}


 
}

