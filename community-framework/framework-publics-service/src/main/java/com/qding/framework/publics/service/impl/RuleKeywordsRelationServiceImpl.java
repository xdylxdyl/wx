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
import com.qding.framework.publics.model.RuleKeywordsRelation;
import com.qding.framework.publics.service.RuleKeywordsRelationService;

public class RuleKeywordsRelationServiceImpl extends BaseDaoServiceImpl  implements
		RuleKeywordsRelationService {



	private static final Log log = LogFactory
			.getLog(RuleKeywordsRelationServiceImpl.class);


	@Override
	public Long insert(RuleKeywordsRelation ruleKeywordsRelation)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + ruleKeywordsRelation);
		}
		if (ruleKeywordsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		ruleKeywordsRelation.setCreateAt(currentTimeMillis);
		ruleKeywordsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(ruleKeywordsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + ruleKeywordsRelation);
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
	public List<RuleKeywordsRelation> insertList(
			List<RuleKeywordsRelation> ruleKeywordsRelationList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (ruleKeywordsRelationList == null ? "null"
							: ruleKeywordsRelationList.size()));
		}
		List<RuleKeywordsRelation> resultList = null;

		if (CollectionUtils.isEmpty(ruleKeywordsRelationList)) {
			return new ArrayList<RuleKeywordsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RuleKeywordsRelation ruleKeywordsRelation : ruleKeywordsRelationList) {
			ruleKeywordsRelation.setCreateAt(currentTimeMillis);
			ruleKeywordsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<RuleKeywordsRelation>) dao
					.batchSave(ruleKeywordsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + ruleKeywordsRelationList);
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
			result = dao.delete(RuleKeywordsRelation.class, id);
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
	public boolean update(RuleKeywordsRelation ruleKeywordsRelation)
			throws ServiceException, ServiceDaoException {

		log.info(" update data : "
				+ (ruleKeywordsRelation == null ? "null" : ruleKeywordsRelation
						.getId()));

		boolean result = false;

		if (ruleKeywordsRelation == null) {
			return true;
		}

		ruleKeywordsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(ruleKeywordsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + ruleKeywordsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + ruleKeywordsRelation);
		}
		return result;
	}

	@Override
	public boolean updateList(
			List<RuleKeywordsRelation> ruleKeywordsRelationList)
			throws ServiceException, ServiceDaoException {

		log.info(" update lists : "
				+ (ruleKeywordsRelationList == null ? "null"
						: ruleKeywordsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(ruleKeywordsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (RuleKeywordsRelation ruleKeywordsRelation : ruleKeywordsRelationList) {
			ruleKeywordsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(ruleKeywordsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + ruleKeywordsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : "
					+ ruleKeywordsRelationList.size());
		}
		return result;
	}

	@Override
	public RuleKeywordsRelation getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		RuleKeywordsRelation ruleKeywordsRelation = null;

		if (id == null) {
			return ruleKeywordsRelation;
		}

		try {
			ruleKeywordsRelation = (RuleKeywordsRelation) dao.get(
					RuleKeywordsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return ruleKeywordsRelation;
	}

	@Override
	public List<RuleKeywordsRelation> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<RuleKeywordsRelation> ruleKeywordsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<RuleKeywordsRelation>();
		}

		try {
			ruleKeywordsRelation = (List<RuleKeywordsRelation>) dao.getList(
					RuleKeywordsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (ruleKeywordsRelation == null ? "null"
							: ruleKeywordsRelation.size()));
		}
		return ruleKeywordsRelation;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getRuleKeywordsRelationIdsByPublicsID(Long publicsID,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by publicsID,start,limit  : " + publicsID
					+ " , " + start + " , " + limit);
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
			idList = dao.getIdList("getRuleKeywordsRelationIdsByPublicsID",
					new Object[] { publicsID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,start,limit)  : "
					+ publicsID + " , " + start + " , " + limit);
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
	public Long getRuleKeywordsRelationRidByPublicsIDAndKeywords(
			Long publicsID, String keywords) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get rid by publicsID,keywords  : " + publicsID + " , "
					+ keywords);
		}
		Long rid = null;

		// TODO 参数检查!

		try {

			rid = (Long) dao.getMapping(
					"getRuleKeywordsRelationRidByPublicsIDAndKeywords",
					new Object[] { publicsID, keywords });
		} catch (DaoException e) {
			log.error(" get rid wrong by publicsID,keywords  : " + publicsID
					+ " , " + keywords);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get rid success : " + rid);
		}
		return rid;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getRuleKeywordsRelationIdsByPublicsIDAndRid(
			Long publicsID, Long rid, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by publicsID,rid,start,limit  : " + publicsID
					+ " , " + rid + " , " + start + " , " + limit);
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
			idList = dao.getIdList(
					"getRuleKeywordsRelationIdsByPublicsIDAndRid",
					new Object[] { publicsID, rid }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,rid,start,limit)  : "
					+ publicsID + " , " + rid + " , " + start + " , " + limit);
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

}
