package com.qding.framework.user.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.user.model.Potential;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface PotentialService  extends BaseDaoService  {

	public Long insert(Potential potential) throws ServiceException, ServiceDaoException;

	public List<Potential> insertList(List<Potential> potentialList) throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Potential potential) throws ServiceException, ServiceDaoException;

	public boolean updateList(List<Potential> potentialList) throws ServiceException, ServiceDaoException;

	public Potential getObjectById(Long id) throws ServiceException, ServiceDaoException;

	public List<Potential> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPotentialIdsByFakeID(String fakeID, Integer start, Integer limit) throws ServiceException,
			ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long getPotentialIdByOpenID(String openID) throws ServiceException, ServiceDaoException;

}
