/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.DecorateImagesRelation;
import com.qding.app.decorate.service.DecorateImagesRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecorateImagesRelationSCAClient implements DecorateImagesRelationService {

    private DecorateImagesRelationService decorateImagesRelationService;

	public DecorateImagesRelationService getDecorateImagesRelationService() {
		return decorateImagesRelationService;
	}
	
	
	public void setDecorateImagesRelationService(DecorateImagesRelationService decorateImagesRelationService) {
		this.decorateImagesRelationService =decorateImagesRelationService;
	}
	
	
			   
		@Override
		public Long insert(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.insert(decorateImagesRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateImagesRelation> insertList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.insertList(decorateImagesRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.update(decorateImagesRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.updateList(decorateImagesRelationList);
		          
		
		}	
		  
    	   
		@Override
		public DecorateImagesRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateImagesRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateImagesRelationIdsByDecorateId(String decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.getDecorateImagesRelationIdsByDecorateId(decorateId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getDecorateImagesRelationIdByImageId(String imageId)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.getDecorateImagesRelationIdByImageId(imageId);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateImagesRelationIdsByDecorateId(String decorateId)throws ServiceException, ServiceDaoException{
		
		return decorateImagesRelationService.countDecorateImagesRelationIdsByDecorateId(decorateId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecorateImagesRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateImagesRelationService.getDecorateImagesRelationIds(start, limit);
	}

	@Override
	public Integer countDecorateImagesRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateImagesRelationService.countDecorateImagesRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateImagesRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateImagesRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decorateImagesRelationService.deleteList(clz, ids);
		
	}


 
}

