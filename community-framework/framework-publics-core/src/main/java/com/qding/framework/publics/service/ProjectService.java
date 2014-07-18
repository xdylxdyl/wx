package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Project;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface ProjectService extends BaseDaoService {

	



   		   
		
		public Long insert(Project project)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Project> insertList(List<Project> projectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Project project)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Project> projectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Project getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Project> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getProjectIdByName(String name)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getProjectIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countProjectIds() throws ServiceException, ServiceDaoException;
	

}

