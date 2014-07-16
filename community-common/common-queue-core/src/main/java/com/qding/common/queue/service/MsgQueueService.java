package com.qding.common.queue.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.queue.model.MsgQueue;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface MsgQueueService extends BaseDaoService {

	



   		   
		
		public Long insert(MsgQueue msgQueue)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<MsgQueue> insertList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(MsgQueue msgQueue)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public MsgQueue getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<MsgQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countMsgQueueIdsByTypeAndStatus(String type,String status)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countMsgQueueIdsByStatus(String status)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countMsgQueueIdsByType(String type)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getMsgQueueIdsByTypeAndStatus(String type,String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getMsgQueueIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getMsgQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getMsgQueueIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countMsgQueueIds() throws ServiceException, ServiceDaoException;
	

}

