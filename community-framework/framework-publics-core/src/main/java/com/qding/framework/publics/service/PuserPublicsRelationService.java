package com.qding.framework.publics.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.PuserPublicsRelation;

@Remotable
public interface PuserPublicsRelationService  extends BaseDaoService {

	public Long insert(PuserPublicsRelation puserPublicsRelation)
			throws ServiceException, ServiceDaoException;

	public List<PuserPublicsRelation> insertList(
			List<PuserPublicsRelation> puserPublicsRelationList)
			throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(PuserPublicsRelation puserPublicsRelation)
			throws ServiceException, ServiceDaoException;

	public boolean updateList(
			List<PuserPublicsRelation> puserPublicsRelationList)
			throws ServiceException, ServiceDaoException;

	public PuserPublicsRelation getObjectById(Long id) throws ServiceException,
			ServiceDaoException;

	public List<PuserPublicsRelation> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPuserPublicsRelationIdsByPuserID(Long puserID)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserPublicsRelationIdsByPuserID(Long puserID,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPuserPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPuserPublicsRelationIds() throws ServiceException,
			ServiceDaoException;

}
