package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Provider;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface ProviderService extends BaseDaoService {

	



   		   
		
		public Long insert(Provider provider)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Provider> insertList(List<Provider> providerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Provider provider)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Provider> providerList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Provider getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Provider> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getProviderIdByName(String name)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getProviderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countProviderIds() throws ServiceException, ServiceDaoException;
	

}

