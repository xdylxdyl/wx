package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Menu;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface MenuService  extends BaseDaoService {

	



   		   
		
		public Long insert(Menu menu)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Menu> insertList(List<Menu> menuList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Menu menu)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Menu> menuList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Menu getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Menu> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	

			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public String  getMenuMenuByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getMenuIdByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
		
	

}

