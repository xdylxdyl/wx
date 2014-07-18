package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Paddress;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PaddressService extends BaseDaoService {

	



   		   
		
		public Long insert(Paddress paddress)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Paddress> insertList(List<Paddress> paddressList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Paddress paddress)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Paddress> paddressList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Paddress getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Paddress> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getPaddressIdByName(String name)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPaddressIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPaddressIds() throws ServiceException, ServiceDaoException;
	

}

