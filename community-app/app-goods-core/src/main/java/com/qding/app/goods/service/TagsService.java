package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Tags;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface TagsService extends BaseDaoService {

	



   		   
		
		public Long insert(Tags tags)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Tags> insertList(List<Tags> tagsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Tags tags)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Tags> tagsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Tags getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Tags> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTagsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTagsIds() throws ServiceException, ServiceDaoException;
	

}

