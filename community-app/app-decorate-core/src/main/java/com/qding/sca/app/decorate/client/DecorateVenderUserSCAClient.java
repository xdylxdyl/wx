/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.DecorateVenderUser;
import com.qding.app.decorate.service.DecorateVenderUserService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecorateVenderUserSCAClient implements DecorateVenderUserService {

    private DecorateVenderUserService decorateVenderUserService;

	public DecorateVenderUserService getDecorateVenderUserService() {
		return decorateVenderUserService;
	}
	
	
	public void setDecorateVenderUserService(DecorateVenderUserService decorateVenderUserService) {
		this.decorateVenderUserService =decorateVenderUserService;
	}
	
	
			   
		@Override
		public Long insert(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.insert(decorateVenderUser);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateVenderUser> insertList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.insertList(decorateVenderUserList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.update(decorateVenderUser);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.updateList(decorateVenderUserList);
		          
		
		}	
		  
    	   
		@Override
		public DecorateVenderUser getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateVenderUser> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateVenderUserIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.getDecorateVenderUserIdsByVenderId(venderId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateVenderUserIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		return decorateVenderUserService.countDecorateVenderUserIdsByVenderId(venderId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecorateVenderUserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderUserService.getDecorateVenderUserIds(start, limit);
	}

	@Override
	public Integer countDecorateVenderUserIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderUserService.countDecorateVenderUserIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderUserService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateVenderUserService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decorateVenderUserService.deleteList(clz, ids);
		
	}


 
}

