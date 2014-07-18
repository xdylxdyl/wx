package com.qding.framework.publics.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Rule;

@Remotable
public interface RuleService  extends BaseDaoService {

	public Long insert(Rule rule) throws ServiceException, ServiceDaoException;

	public List<Rule> insertList(List<Rule> ruleList) throws ServiceException,
			ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Rule rule) throws ServiceException,
			ServiceDaoException;

	public boolean updateList(List<Rule> ruleList) throws ServiceException,
			ServiceDaoException;

	public Rule getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<Rule> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRuleIdsByPublicsID(Long publicsID,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException;

}
