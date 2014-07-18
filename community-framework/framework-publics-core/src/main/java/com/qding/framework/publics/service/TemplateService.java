package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Template;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface TemplateService extends BaseDaoService {

	



   		   
		
		public Long insert(Template template)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Template> insertList(List<Template> templateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Template template)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Template> templateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Template getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Template> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTemplateIdsByCodeAndPublicsID(String code,Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTemplateIdsByTypeAndPublicsID(String type,Long publicsID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTemplateIdsByCodeAndPublicsID(String code,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTemplateIdsByTypeAndPublicsID(String type,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTemplateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTemplateIds() throws ServiceException, ServiceDaoException;
	

}

