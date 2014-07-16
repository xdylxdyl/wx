/**
 * 
 */
package com.qding.sca.common.queue.client;

import java.util.List;
import java.util.Map;

import com.qding.common.queue.model.MsgQueue;
import com.qding.common.queue.service.MsgQueueService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class MsgQueueSCAClient implements MsgQueueService {

    private MsgQueueService msgQueueService;

	public MsgQueueService getMsgQueueService() {
		return msgQueueService;
	}
	
	
	public void setMsgQueueService(MsgQueueService msgQueueService) {
		this.msgQueueService =msgQueueService;
	}
	
	
			   
		@Override
		public Long insert(MsgQueue msgQueue)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.insert(msgQueue);
		          
		
		}	
		  
    	   
		@Override
		public List<MsgQueue> insertList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.insertList(msgQueueList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(MsgQueue msgQueue)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.update(msgQueue);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<MsgQueue> msgQueueList)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.updateList(msgQueueList);
		          
		
		}	
		  
    	   
		@Override
		public MsgQueue getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<MsgQueue> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getMsgQueueIdsByTypeAndStatus(String type,String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.getMsgQueueIdsByTypeAndStatus(type,status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getMsgQueueIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.getMsgQueueIdsByStatus(status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getMsgQueueIdsByType(String type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.getMsgQueueIdsByType(type,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countMsgQueueIdsByTypeAndStatus(String type,String status)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.countMsgQueueIdsByTypeAndStatus(type,status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countMsgQueueIdsByStatus(String status)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.countMsgQueueIdsByStatus(status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countMsgQueueIdsByType(String type)throws ServiceException, ServiceDaoException{
		
		return msgQueueService.countMsgQueueIdsByType(type);
	
	
	}
	
		
	
		@Override
	public List<Long> getMsgQueueIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return msgQueueService.getMsgQueueIds(start, limit);
	}

	@Override
	public Integer countMsgQueueIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return msgQueueService.countMsgQueueIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return msgQueueService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return msgQueueService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   msgQueueService.deleteList(clz, ids);
		
	}


 
}

