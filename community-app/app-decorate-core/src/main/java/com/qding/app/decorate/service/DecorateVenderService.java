package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateVender;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface DecorateVenderService extends BaseDaoService {

	



   		   
		
		public Long insert(DecorateVender decorateVender)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateVender> insertList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DecorateVender decorateVender)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DecorateVender> decorateVenderList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DecorateVender getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateVender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDecorateVenderIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDecorateVenderIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDecorateVenderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDecorateVenderIds() throws ServiceException, ServiceDaoException;
	

}

