/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.ProviderPublicsRelation;
import com.qding.app.goods.service.ProviderPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ProviderPublicsRelationSCAClient implements ProviderPublicsRelationService {

    private ProviderPublicsRelationService providerPublicsRelationService;

	public ProviderPublicsRelationService getProviderPublicsRelationService() {
		return providerPublicsRelationService;
	}
	
	
	public void setProviderPublicsRelationService(ProviderPublicsRelationService providerPublicsRelationService) {
		this.providerPublicsRelationService =providerPublicsRelationService;
	}
	
	
			   
		@Override
		public Long insert(ProviderPublicsRelation providerPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.insert(providerPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<ProviderPublicsRelation> insertList(List<ProviderPublicsRelation> providerPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.insertList(providerPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(ProviderPublicsRelation providerPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.update(providerPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<ProviderPublicsRelation> providerPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.updateList(providerPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public ProviderPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<ProviderPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderPublicsRelationIdsByProviderID(Long providerID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getProviderPublicsRelationIdsByProviderID(providerID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderPublicsRelationIdsByPublicsIDAndStatus(Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getProviderPublicsRelationIdsByPublicsIDAndStatus(publicsID,status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderIDsByPublicsIDAndStatus(Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getProviderIDsByPublicsIDAndStatus(publicsID,status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProviderIDsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.getProviderIDsByPublicsID(publicsID,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProviderPublicsRelationIdsByProviderID(Long providerID)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.countProviderPublicsRelationIdsByProviderID(providerID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProviderPublicsRelationIdsByPublicsIDAndStatus(Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.countProviderPublicsRelationIdsByPublicsIDAndStatus(publicsID,status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProviderIDsByPublicsIDAndStatus(Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.countProviderIDsByPublicsIDAndStatus(publicsID,status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProviderIDsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return providerPublicsRelationService.countProviderIDsByPublicsID(publicsID);
	
	
	}
	
		
	
		@Override
	public List<Long> getProviderPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerPublicsRelationService.getProviderPublicsRelationIds(start, limit);
	}

	@Override
	public Integer countProviderPublicsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerPublicsRelationService.countProviderPublicsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerPublicsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerPublicsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   providerPublicsRelationService.deleteList(clz, ids);
		
	}


 
}

