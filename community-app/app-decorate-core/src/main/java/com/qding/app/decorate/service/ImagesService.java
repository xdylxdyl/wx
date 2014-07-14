package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.Images;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface ImagesService extends BaseDaoService {

	



   		   
		
		public Long insert(Images images)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Images> insertList(List<Images> imagesList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Images images)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Images> imagesList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Images getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Images> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getImagesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countImagesIds() throws ServiceException, ServiceDaoException;
	

}

