/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.GorderGoodsRelation;
import com.qding.app.goods.service.GorderGoodsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GorderGoodsRelationSCAClient implements GorderGoodsRelationService {

    private GorderGoodsRelationService gorderGoodsRelationService;

	public GorderGoodsRelationService getGorderGoodsRelationService() {
		return gorderGoodsRelationService;
	}
	
	
	public void setGorderGoodsRelationService(GorderGoodsRelationService gorderGoodsRelationService) {
		this.gorderGoodsRelationService =gorderGoodsRelationService;
	}
	
	
			   
		@Override
		public Long insert(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.insert(gorderGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<GorderGoodsRelation> insertList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.insertList(gorderGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.update(gorderGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.updateList(gorderGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public GorderGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<GorderGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return gorderGoodsRelationService.getObjectsByIds(ids);
		          
		
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
		
		return gorderGoodsRelationService.getGorderGoodsRelationIdsByGoodsID(goodsID,start,limit);
	
	
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
		
		return gorderGoodsRelationService.getGorderGoodsRelationIdsByGorderID(gorderID,start,limit);
	
	
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
		
		return gorderGoodsRelationService.countGorderGoodsRelationIdsByGoodsID(goodsID);
	
	
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
		
		return gorderGoodsRelationService.countGorderGoodsRelationIdsByGorderID(gorderID);
	
	
	}
	
		
	
		@Override
	public List<Long> getGorderGoodsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderGoodsRelationService.getGorderGoodsRelationIds(start, limit);
	}

	@Override
	public Integer countGorderGoodsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderGoodsRelationService.countGorderGoodsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderGoodsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderGoodsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   gorderGoodsRelationService.deleteList(clz, ids);
		
	}


 
}

