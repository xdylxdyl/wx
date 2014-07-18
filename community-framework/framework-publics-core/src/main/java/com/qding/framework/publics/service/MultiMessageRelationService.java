package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.MultiMessageRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface MultiMessageRelationService  extends BaseDaoService {

	



   		   
		
		public Long insert(MultiMessageRelation multiMessageRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<MultiMessageRelation> insertList(List<MultiMessageRelation> multiMessageRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(MultiMessageRelation multiMessageRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<MultiMessageRelation> multiMessageRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public MultiMessageRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<MultiMessageRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	

			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getMultiMessageRelationIdsByGroupID(Long groupID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	

}

