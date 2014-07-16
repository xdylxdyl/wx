/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Provider;
import com.qding.app.goods.service.ProviderService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ProviderSCAClient implements ProviderService {

    private ProviderService providerService;

	public ProviderService getProviderService() {
		return providerService;
	}
	
	
	public void setProviderService(ProviderService providerService) {
		this.providerService =providerService;
	}
	
	
			   
		@Override
		public Long insert(Provider provider)throws ServiceException, ServiceDaoException{
		
		return providerService.insert(provider);
		          
		
		}	
		  
    	   
		@Override
		public List<Provider> insertList(List<Provider> providerList)throws ServiceException, ServiceDaoException{
		
		return providerService.insertList(providerList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return providerService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Provider provider)throws ServiceException, ServiceDaoException{
		
		return providerService.update(provider);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Provider> providerList)throws ServiceException, ServiceDaoException{
		
		return providerService.updateList(providerList);
		          
		
		}	
		  
    	   
		@Override
		public Provider getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return providerService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Provider> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return providerService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getProviderIdByName(String name)throws ServiceException, ServiceDaoException{
		
		return providerService.getProviderIdByName(name);
	
	
	}
	
		
	
	
    		
	
		@Override
	public List<Long> getProviderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerService.getProviderIds(start, limit);
	}

	@Override
	public Integer countProviderIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerService.countProviderIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return providerService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   providerService.deleteList(clz, ids);
		
	}


 
}

