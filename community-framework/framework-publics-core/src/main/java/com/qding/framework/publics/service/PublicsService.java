package com.qding.framework.publics.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Publics;

@Remotable
public interface PublicsService  extends BaseDaoService {

	public Long insert(Publics publics) throws ServiceException,
			ServiceDaoException;

	public List<Publics> insertList(List<Publics> publicsList)
			throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Publics publics) throws ServiceException,
			ServiceDaoException;

	public boolean updateList(List<Publics> publicsList)
			throws ServiceException, ServiceDaoException;

	public Publics getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<Publics> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException;


	public List<Long> getList(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPublicsIdsByAppId(String appid, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

}
