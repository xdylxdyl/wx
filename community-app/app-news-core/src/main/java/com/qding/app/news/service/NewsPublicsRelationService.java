package com.qding.app.news.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.app.news.model.NewsPublicsRelation;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface NewsPublicsRelationService  extends BaseDaoService {

	



   		   
		
		public Long insert(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<NewsPublicsRelation> insertList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public NewsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<NewsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPublicsIDsByNewsID(Long newsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countNewsPublicsRelationIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countNewsPublicsRelationIdsByNewsID(Long newsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countNewsIDsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPublicsIDsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getNewsPublicsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getNewsPublicsRelationIdsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getNewsIDsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getNewsPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countNewsPublicsRelationIds() throws ServiceException, ServiceDaoException;
	

}

