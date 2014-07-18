package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.ChatMessage;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface ChatMessageService extends BaseDaoService {

	



   		   
		
		public Long insert(ChatMessage chatMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ChatMessage> insertList(List<ChatMessage> chatMessageList)throws ServiceException, ServiceDaoException;
		  
    	public List<Object> getMessageReplys(Long publicsID, String openID) throws ServiceException, ServiceDaoException;
		public boolean replyMessage(Long publicsID, String openID, String content) throws ServiceException, ServiceDaoException;
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(ChatMessage chatMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<ChatMessage> chatMessageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public ChatMessage getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<ChatMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countChatMessageIdsByOpenID(String openID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getChatMessageIdsByOpenID(String openID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getChatMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countChatMessageIds() throws ServiceException, ServiceDaoException;
	

}

