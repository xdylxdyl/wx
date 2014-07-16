/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.AddressUserRelation;
import com.qding.app.goods.service.AddressUserRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AddressUserRelationSCAClient implements AddressUserRelationService {

    private AddressUserRelationService addressUserRelationService;

	public AddressUserRelationService getAddressUserRelationService() {
		return addressUserRelationService;
	}
	
	
	public void setAddressUserRelationService(AddressUserRelationService addressUserRelationService) {
		this.addressUserRelationService =addressUserRelationService;
	}
	
	
			   
		@Override
		public Long insert(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.insert(addressUserRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<AddressUserRelation> insertList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.insertList(addressUserRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.update(addressUserRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.updateList(addressUserRelationList);
		          
		
		}	
		  
    	   
		@Override
		public AddressUserRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<AddressUserRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getAddressUserRelationIdByAddressID(Long addressID)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.getAddressUserRelationIdByAddressID(addressID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getAddressUserRelationIdsByUserID(Long userID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.getAddressUserRelationIdsByUserID(userID,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countAddressUserRelationIdsByUserID(Long userID)throws ServiceException, ServiceDaoException{
		
		return addressUserRelationService.countAddressUserRelationIdsByUserID(userID);
	
	
	}
	
		
	
		@Override
	public List<Long> getAddressUserRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressUserRelationService.getAddressUserRelationIds(start, limit);
	}

	@Override
	public Integer countAddressUserRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressUserRelationService.countAddressUserRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressUserRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return addressUserRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   addressUserRelationService.deleteList(clz, ids);
		
	}


 
}

