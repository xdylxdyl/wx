/**
 * 
 */
package com.qding.sca.framework.user.client;

import java.util.List;
import java.util.Map;

import com.qding.framework.user.model.UserOpenRelation;
import com.qding.framework.user.service.UserOpenRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class UserOpenRelationSCAClient implements UserOpenRelationService {

    private UserOpenRelationService userOpenRelationService;

	public UserOpenRelationService getUserOpenRelationService() {
		return userOpenRelationService;
	}
	
	
	public void setUserOpenRelationService(UserOpenRelationService userOpenRelationService) {
		this.userOpenRelationService =userOpenRelationService;
	}
	
	
			   
		@Override
		public Long insert(UserOpenRelation userOpenRelation)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.insert(userOpenRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<UserOpenRelation> insertList(List<UserOpenRelation> userOpenRelationList)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.insertList(userOpenRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserOpenRelation userOpenRelation)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.update(userOpenRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserOpenRelation> userOpenRelationList)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.updateList(userOpenRelationList);
		          
		
		}	
		  
    	   
		@Override
		public UserOpenRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserOpenRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public String  getUserOpenRelationOpenIDByUidAndPublicsID(Long uid,Long publicsID)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.getUserOpenRelationOpenIDByUidAndPublicsID(uid,publicsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getUserOpenRelationUidByOpenIDAndType(String openID,String type)throws ServiceException, ServiceDaoException{
		
		return userOpenRelationService.getUserOpenRelationUidByOpenIDAndType(openID,type);
	
	
	}
	
		
	
	
    		
	
		@Override
	public List<Long> getUserOpenRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userOpenRelationService.getUserOpenRelationIds(start, limit);
	}

	@Override
	public Integer countUserOpenRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userOpenRelationService.countUserOpenRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userOpenRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userOpenRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userOpenRelationService.deleteList(clz, ids);
		
	}


 
}

