package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Puser;

@Remotable
public interface PuserService  extends BaseDaoService  {

	public Long insert(Puser puser) throws ServiceException,
			ServiceDaoException;

	public List<Puser> insertList(List<Puser> puserList)
			throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Puser puser) throws ServiceException,
			ServiceDaoException;

	public boolean updateList(List<Puser> puserList) throws ServiceException,
			ServiceDaoException;

	public Puser getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<Puser> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserIdsByName(String name, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException;
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserIdsByRoleID(Long roleID, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException;
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserIdsByRoleIDAndStatus(Long roleID, String status, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPuserIds() throws ServiceException, ServiceDaoException;
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserIdsByCondition(Map<String, Object> conditions,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException;

}
