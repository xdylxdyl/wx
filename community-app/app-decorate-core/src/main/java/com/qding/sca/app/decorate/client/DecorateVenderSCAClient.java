/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.DecorateVender;
import com.qding.app.decorate.service.DecorateVenderService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecorateVenderSCAClient implements DecorateVenderService {

    private DecorateVenderService decorateVenderService;

	public DecorateVenderService getDecorateVenderService() {
		return decorateVenderService;
	}
	
	
	public void setDecorateVenderService(DecorateVenderService decorateVenderService) {
		this.decorateVenderService =decorateVenderService;
	}
	
	
			   
		@Override
		public Long insert(DecorateVender decorateVender)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.insert(decorateVender);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateVender> insertList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.insertList(decorateVenderList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DecorateVender decorateVender)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.update(decorateVender);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.updateList(decorateVenderList);
		          
		
		}	
		  
    	   
		@Override
		public DecorateVender getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateVender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateVenderIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.getDecorateVenderIdsByVenderId(venderId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateVenderIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		return decorateVenderService.countDecorateVenderIdsByVenderId(venderId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecorateVenderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderService.getDecorateVenderIds(start, limit);
	}

	@Override
	public Integer countDecorateVenderIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderService.countDecorateVenderIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decorateVenderService.deleteList(clz, ids);
		
	}


 
}

