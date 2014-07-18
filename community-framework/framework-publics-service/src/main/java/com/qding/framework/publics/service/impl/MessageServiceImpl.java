package com.qding.framework.publics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.Message;
import com.qding.framework.publics.service.MessageService;

public class MessageServiceImpl extends BaseDaoServiceImpl  implements MessageService {



	private static final Log log = LogFactory.getLog(MessageServiceImpl.class);



	@Override
	public Long insert(Message message) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + message);
		}
		if (message == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		message.setCreateAt(currentTimeMillis);
		message.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(message);
		} catch (DaoException e) {
			log.error(" insert wrong : " + message);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert data success : " + result);
		}
		return result;
	}

	@Override
	public List<Message> insertList(List<Message> messageList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (messageList == null ? "null" : messageList.size()));
		}
		List<Message> resultList = null;

		if (CollectionUtils.isEmpty(messageList)) {
			return new ArrayList<Message>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Message message : messageList) {
			message.setCreateAt(currentTimeMillis);
			message.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Message>) dao.batchSave(messageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + messageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
		}
		return resultList;

	}

	@Override
	public boolean delete(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" delete data : " + id);
		}
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Message.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" delete data success : " + id);
		}
		return result;

	}

	@Override
	public boolean update(Message message) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (message == null ? "null" : message.getId()));

		boolean result = false;

		if (message == null) {
			return true;
		}

		message.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(message);
		} catch (DaoException e) {
			log.error(" update wrong : " + message);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + message);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Message> messageList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (messageList == null ? "null" : messageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(messageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Message message : messageList) {
			message.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(messageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + messageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + messageList.size());
		}
		return result;
	}

	@Override
	public Message getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Message message = null;

		if (id == null) {
			return message;
		}

		try {
			message = (Message) dao.get(Message.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return message;
	}

	@Override
	public List<Message> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Message> message = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Message>();
		}

		try {
			message = (List<Message>) dao.getList(Message.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (message == null ? "null" : message.size()));
		}
		return message;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getMessageIdsByPublicsID(Long publicsID, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by publicsID,start,limit  : " + publicsID + " , " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getMessageIdsByPublicsID", new Object[] { publicsID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,start,limit)  : " + publicsID + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	@Override
	public List<Long> getDisplayMessageIdsByPublicsID(Long publicsID, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		if (log.isInfoEnabled()) {
			log.info(" get display ids by publicsID,start,limit  : " + publicsID + " , " + start + " , " + limit);
		}
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getDisplayMessageIdsByPublicsID", new Object[] { publicsID,"multi_item" }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get display ids  wrong by publicsID,start,limit)  : " + publicsID + " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countDisplayMessageIdsByPublicsID(Long publicsID)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		Integer count =  0;
		try {
			count = dao.count("getDisplayMessageIdsByPublicsID", new Object[] { publicsID,"multi_item" });
		} catch (DaoException e) {
			log.error(" count by publicsID  : " + publicsID) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}
