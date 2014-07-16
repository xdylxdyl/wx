/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Address;
import com.qding.app.goods.service.AddressService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AddressSCAClient implements AddressService {

    private AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}
	
	
	public void setAddressService(AddressService addressService) {
		this.addressService =addressService;
	}
	
	
			   
		@Override
		public Long insert(Address address)throws ServiceException, ServiceDaoException{
		
		return addressService.insert(address);
		          
		
		}	
		  
    	   
		@Override
		public List<Address> insertList(List<Address> addressList)throws ServiceException, ServiceDaoException{
		
		return addressService.insertList(addressList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return addressService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Address address)throws ServiceException, ServiceDaoException{
		
		return addressService.update(address);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Address> addressList)throws ServiceException, ServiceDaoException{
		
		return addressService.updateList(addressList);
		          
		
		}	
		  
    	   
		@Override
		public Address getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return addressService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Address> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return addressService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAddressIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressService.getAddressIds(start, limit);
	}

	@Override
	public Integer countAddressIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressService.countAddressIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   addressService.deleteList(clz, ids);
		
	}


 
}

