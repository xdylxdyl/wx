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
import com.qding.framework.publics.model.PuserPublicsRelation;
import com.qding.framework.publics.service.PuserPublicsRelationService;

public class PuserPublicsRelationServiceImpl extends BaseDaoServiceImpl  implements
		PuserPublicsRelationService {


	private static final Log log = LogFactory
			.getLog(PuserPublicsRelationServiceImpl.class);



	@Override
	public Long insert(PuserPublicsRelation puserPublicsRelation)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + puserPublicsRelation);
		}
		if (puserPublicsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		puserPublicsRelation.setCreateAt(currentTimeMillis);
		puserPublicsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(puserPublicsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + puserPublicsRelation);
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
	public List<PuserPublicsRelation> insertList(
			List<PuserPublicsRelation> puserPublicsRelationList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (puserPublicsRelationList == null ? "null"
							: puserPublicsRelationList.size()));
		}
		List<PuserPublicsRelation> resultList = null;

		if (CollectionUtils.isEmpty(puserPublicsRelationList)) {
			return new ArrayList<PuserPublicsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PuserPublicsRelation puserPublicsRelation : puserPublicsRelationList) {
			puserPublicsRelation.setCreateAt(currentTimeMillis);
			puserPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PuserPublicsRelation>) dao
					.batchSave(puserPublicsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + puserPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : "
					+ (resultList == null ? "null" : resultList.size()));
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
			result = dao.delete(PuserPublicsRelation.class, id);
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
	public boolean update(PuserPublicsRelation puserPublicsRelation)
			throws ServiceException, ServiceDaoException {

		log.info(" update data : "
				+ (puserPublicsRelation == null ? "null" : puserPublicsRelation
						.getId()));

		boolean result = false;

		if (puserPublicsRelation == null) {
			return true;
		}

		puserPublicsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(puserPublicsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + puserPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + puserPublicsRelation);
		}
		return result;
	}

	@Override
	public boolean updateList(
			List<PuserPublicsRelation> puserPublicsRelationList)
			throws ServiceException, ServiceDaoException {

		log.info(" update lists : "
				+ (puserPublicsRelationList == null ? "null"
						: puserPublicsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(puserPublicsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PuserPublicsRelation puserPublicsRelation : puserPublicsRelationList) {
			puserPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(puserPublicsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + puserPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : "
					+ puserPublicsRelationList.size());
		}
		return result;
	}

	@Override
	public PuserPublicsRelation getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		PuserPublicsRelation puserPublicsRelation = null;

		if (id == null) {
			return puserPublicsRelation;
		}

		try {
			puserPublicsRelation = (PuserPublicsRelation) dao.get(
					PuserPublicsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return puserPublicsRelation;
	}

	@Override
	public List<PuserPublicsRelation> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<PuserPublicsRelation> puserPublicsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PuserPublicsRelation>();
		}

		try {
			puserPublicsRelation = (List<PuserPublicsRelation>) dao.getList(
					PuserPublicsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (puserPublicsRelation == null ? "null"
							: puserPublicsRelation.size()));
		}
		return puserPublicsRelation;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getPuserPublicsRelationIdsByPuserID(Long puserID,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by puserID,start,limit  : " + puserID + " , "
					+ start + " , " + limit);
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
			idList = dao.getIdList("getPuserPublicsRelationIdsByPuserID",
					new Object[] { puserID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by puserID,start,limit)  : " + puserID
					+ " , " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Integer countPuserPublicsRelationIdsByPuserID(Long puserID)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" count ids by puserID  : " + puserID);
		}
		Integer count = null;

		try {

			count = dao.count("getPuserPublicsRelationIdsByPuserID",
					new Object[] { puserID });

		} catch (DaoException e) {
			log.error(" count ids  wrong by puserID)  : " + puserID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  success : " + count);
		}
		return count;

	}

	@Override
	public List<Long> getPuserPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start
				+ " , " + limit);
		List<Long> idList = null;

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		try {
			idList = dao.getIdList("getPuserPublicsRelationIdsAll",
					new Object[] {}, start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , "
					+ limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : "
					+ (idList == null ? "null" : idList.size()));
		}
		return idList;
	}

	@Override
	public Integer countPuserPublicsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getPuserPublicsRelationIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPuserPublicsRelationIds ");
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
