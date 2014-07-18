package com.qding.framework.user.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.user.model.UserOpenRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface UserOpenRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(UserOpenRelation userOpenRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserOpenRelation> insertList(List<UserOpenRelation> userOpenRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserOpenRelation userOpenRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserOpenRelation> userOpenRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserOpenRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserOpenRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public String  getUserOpenRelationOpenIDByUidAndPublicsID(Long uid,Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getUserOpenRelationUidByOpenIDAndType(String openID,String type)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserOpenRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserOpenRelationIds() throws ServiceException, ServiceDaoException;
	

}

