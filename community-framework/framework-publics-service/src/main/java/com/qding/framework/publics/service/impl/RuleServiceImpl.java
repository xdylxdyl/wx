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
import com.qding.framework.publics.model.Rule;
import com.qding.framework.publics.service.RuleService;

public class RuleServiceImpl extends BaseDaoServiceImpl implements RuleService {



	private static final Log log = LogFactory.getLog(RuleServiceImpl.class);



	@Override
	public Long insert(Rule rule) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + rule);
		}
		if (rule == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		rule.setCreateAt(currentTimeMillis);
		rule.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(rule);
		} catch (DaoException e) {
			log.error(" insert wrong : " + rule);
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
	public List<Rule> insertList(List<Rule> ruleList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (ruleList == null ? "null" : ruleList.size()));
		}
		List<Rule> resultList = null;

		if (CollectionUtils.isEmpty(ruleList)) {
			return new ArrayList<Rule>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Rule rule : ruleList) {
			rule.setCreateAt(currentTimeMillis);
			rule.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Rule>) dao.batchSave(ruleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + ruleList);
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
			result = dao.delete(Rule.class, id);
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
	public boolean update(Rule rule) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (rule == null ? "null" : rule.getId()));

		boolean result = false;

		if (rule == null) {
			return true;
		}

		rule.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(rule);
		} catch (DaoException e) {
			log.error(" update wrong : " + rule);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + rule);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Rule> ruleList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (ruleList == null ? "null" : ruleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(ruleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Rule rule : ruleList) {
			rule.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(ruleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + ruleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + ruleList.size());
		}
		return result;
	}

	@Override
	public Rule getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Rule rule = null;

		if (id == null) {
			return rule;
		}

		try {
			rule = (Rule) dao.get(Rule.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return rule;
	}

	@Override
	public List<Rule> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Rule> rule = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Rule>();
		}

		try {
			rule = (List<Rule>) dao.getList(Rule.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (rule == null ? "null" : rule.size()));
		}
		return rule;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getRuleIdsByPublicsID(Long publicsID, Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

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
			idList = dao.getIdList("getRuleIdsByPublicsID", new Object[] { publicsID }, start, limit, false);

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

}
