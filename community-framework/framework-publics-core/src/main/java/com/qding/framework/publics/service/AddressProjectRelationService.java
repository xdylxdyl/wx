package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.AddressProjectRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface AddressProjectRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(AddressProjectRelation addressProjectRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AddressProjectRelation> insertList(List<AddressProjectRelation> addressProjectRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AddressProjectRelation addressProjectRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AddressProjectRelation> addressProjectRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AddressProjectRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AddressProjectRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countAddressProjectRelationIdsByProjectID(Long projectID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getAddressProjectRelationIdsByProjectID(Long projectID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getAddressProjectRelationIdByAddressID(Long addressID)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAddressProjectRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAddressProjectRelationIds() throws ServiceException, ServiceDaoException;
	

}

