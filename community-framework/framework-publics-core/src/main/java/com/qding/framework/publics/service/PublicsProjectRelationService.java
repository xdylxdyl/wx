package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.PublicsProjectRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PublicsProjectRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(PublicsProjectRelation publicsProjectRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PublicsProjectRelation> insertList(List<PublicsProjectRelation> publicsProjectRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PublicsProjectRelation publicsProjectRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PublicsProjectRelation> publicsProjectRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PublicsProjectRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PublicsProjectRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPublicsProjectRelationIdsByProjectID(Long projectID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getPublicsProjectRelationIdByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPublicsProjectRelationIdsByProjectID(Long projectID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPublicsProjectRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPublicsProjectRelationIds() throws ServiceException, ServiceDaoException;
	

}

