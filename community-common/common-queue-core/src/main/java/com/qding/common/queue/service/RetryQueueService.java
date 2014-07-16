package com.qding.common.queue.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.queue.model.RetryQueue;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface RetryQueueService extends BaseDaoService {

	



   		   
		
		public Long insert(RetryQueue retryQueue)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RetryQueue> insertList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(RetryQueue retryQueue)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public RetryQueue getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RetryQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countRetryQueueIdsByType(String type)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRetryQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRetryQueueIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countRetryQueueIds() throws ServiceException, ServiceDaoException;
	

}

