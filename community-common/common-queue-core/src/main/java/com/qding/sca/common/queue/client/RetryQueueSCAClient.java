/**
 * 
 */
package com.qding.sca.common.queue.client;

import java.util.List;
import java.util.Map;

import com.qding.common.queue.model.RetryQueue;
import com.qding.common.queue.service.RetryQueueService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class RetryQueueSCAClient implements RetryQueueService {

    private RetryQueueService retryQueueService;

	public RetryQueueService getRetryQueueService() {
		return retryQueueService;
	}
	
	
	public void setRetryQueueService(RetryQueueService retryQueueService) {
		this.retryQueueService =retryQueueService;
	}
	
	
			   
		@Override
		public Long insert(RetryQueue retryQueue)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.insert(retryQueue);
		          
		
		}	
		  
    	   
		@Override
		public List<RetryQueue> insertList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.insertList(retryQueueList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(RetryQueue retryQueue)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.update(retryQueue);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<RetryQueue> retryQueueList)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.updateList(retryQueueList);
		          
		
		}	
		  
    	   
		@Override
		public RetryQueue getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<RetryQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRetryQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.getRetryQueueIdsByType(type,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countRetryQueueIdsByType(String type)throws ServiceException, ServiceDaoException{
		
		return retryQueueService.countRetryQueueIdsByType(type);
	
	
	}
	
		
	
		@Override
	public List<Long> getRetryQueueIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return retryQueueService.getRetryQueueIds(start, limit);
	}

	@Override
	public Integer countRetryQueueIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return retryQueueService.countRetryQueueIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return retryQueueService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return retryQueueService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   retryQueueService.deleteList(clz, ids);
		
	}


 
}

