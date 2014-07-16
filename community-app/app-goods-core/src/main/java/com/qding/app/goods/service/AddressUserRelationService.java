package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.AddressUserRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface AddressUserRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AddressUserRelation> insertList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AddressUserRelation addressUserRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AddressUserRelation> addressUserRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AddressUserRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AddressUserRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countAddressUserRelationIdsByUserID(Long userID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getAddressUserRelationIdByAddressID(Long addressID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getAddressUserRelationIdsByUserID(Long userID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAddressUserRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAddressUserRelationIds() throws ServiceException, ServiceDaoException;
	

}

