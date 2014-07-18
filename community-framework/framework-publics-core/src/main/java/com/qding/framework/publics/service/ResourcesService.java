package com.qding.framework.publics.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Resources;

@Remotable
public interface ResourcesService extends BaseDaoService {

	public Long insert(Resources resources) throws ServiceException,
			ServiceDaoException;

	public List<Resources> insertList(List<Resources> resourcesList)
			throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Resources resources) throws ServiceException,
			ServiceDaoException;

	public boolean updateList(List<Resources> resourcesList)
			throws ServiceException, ServiceDaoException;

	public Resources getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<Resources> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public  List<Long> getResourcesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countResourcesIds() throws ServiceException,
			ServiceDaoException;

}
