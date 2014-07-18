package com.qding.framework.user.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.user.model.User;

@Remotable
public interface UserService extends BaseDaoService {

	



   		   
		
		public Long insert(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> insertList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public User getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	

			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getUserIdByMobile(String mobile)throws ServiceException, ServiceDaoException;
		
	

}

