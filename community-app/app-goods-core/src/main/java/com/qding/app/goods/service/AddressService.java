package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Address;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface AddressService extends BaseDaoService {

	



   		   
		
		public Long insert(Address address)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Address> insertList(List<Address> addressList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Address address)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Address> addressList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Address getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Address> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAddressIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAddressIds() throws ServiceException, ServiceDaoException;
	

}

