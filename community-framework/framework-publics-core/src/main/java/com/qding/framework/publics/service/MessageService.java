package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Message;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface MessageService  extends BaseDaoService {

	public Long insert(Message message) throws ServiceException, ServiceDaoException;

	public List<Message> insertList(List<Message> messageList) throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Message message) throws ServiceException, ServiceDaoException;

	public boolean updateList(List<Message> messageList) throws ServiceException, ServiceDaoException;

	public Message getObjectById(Long id) throws ServiceException, ServiceDaoException;

	public List<Message> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getMessageIdsByPublicsID(Long publicsID, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	
	/**
	 * 获取非多图文消息的所有消息列表
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDisplayMessageIdsByPublicsID(Long publicsID, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;
	
	/**
	 * 统计
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDisplayMessageIdsByPublicsID(Long publicsID)
			throws ServiceException, ServiceDaoException;

}
