package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateImagesRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface DecorateImagesRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateImagesRelation> insertList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DecorateImagesRelation decorateImagesRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DecorateImagesRelation> decorateImagesRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DecorateImagesRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateImagesRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDecorateImagesRelationIdsByDecorateId(String decorateId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDecorateImagesRelationIdsByDecorateId(String decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getDecorateImagesRelationIdByImageId(String imageId)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDecorateImagesRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDecorateImagesRelationIds() throws ServiceException, ServiceDaoException;
	

}

