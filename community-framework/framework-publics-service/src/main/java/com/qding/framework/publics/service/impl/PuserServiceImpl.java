package com.qding.framework.publics.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;
import com.qding.framework.publics.model.Puser;
import com.qding.framework.publics.service.PuserService;

public class PuserServiceImpl extends BaseDaoServiceImpl  implements PuserService {



	private static final Log log = LogFactory.getLog(PuserServiceImpl.class);

	

	@Override
	public Long insert(Puser puser) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + puser);
		}
		if (puser == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		puser.setCreateAt(currentTimeMillis);
		puser.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(puser);
		} catch (DaoException e) {
			log.error(" insert wrong : " + puser);
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
	public List<Puser> insertList(List<Puser> puserList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (puserList == null ? "null" : puserList.size()));
		}
		List<Puser> resultList = null;

		if (CollectionUtils.isEmpty(puserList)) {
			return new ArrayList<Puser>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Puser puser : puserList) {
			puser.setCreateAt(currentTimeMillis);
			puser.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Puser>) dao.batchSave(puserList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + puserList);
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
			result = dao.delete(Puser.class, id);
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
	public boolean update(Puser puser) throws ServiceException,
			ServiceDaoException {

		log.info(" update data : " + (puser == null ? "null" : puser.getId()));

		boolean result = false;

		if (puser == null) {
			return true;
		}

		puser.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(puser);
		} catch (DaoException e) {
			log.error(" update wrong : " + puser);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + puser);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Puser> puserList) throws ServiceException,
			ServiceDaoException {

		log.info(" update lists : "
				+ (puserList == null ? "null" : puserList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(puserList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Puser puser : puserList) {
			puser.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(puserList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + puserList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + puserList.size());
		}
		return result;
	}

	@Override
	public Puser getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Puser puser = null;

		if (id == null) {
			return puser;
		}

		try {
			puser = (Puser) dao.get(Puser.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return puser;
	}

	@Override
	public List<Puser> getObjectsByIds(List<Long> ids) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Puser> puser = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Puser>();
		}

		try {
			puser = (List<Puser>) dao.getList(Puser.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (puser == null ? "null" : puser.size()));
		}
		return puser;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getPuserIdsByName(String name, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException {

	
			log.info(" get ids by name,start,limit  : " + name + " , " + start
					+ " , " + limit);
		
		List<Long> idList = new ArrayList();

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		if(name==null){
			log.info("name is null ,so return direct ");
			return idList;
		}

		try {
			idList = dao.getIdList("getPuserIdsByName", new Object[] { name },
					start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + name + " , "
					+ start + " , " + limit);
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
	public List<Long> getPuserIdsByRoleID(Long roleID, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by roleID,start,limit  : " + roleID + " , "
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
			idList = dao.getIdList("getPuserIdsByRoleID",
					new Object[] { roleID }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + roleID
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
	public List<Long> getPuserIdsByRoleIDAndStatus(Long roleID, String status,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by roleID,status,start,limit  : " + roleID
					+ " , " + status + " , " + start + " , " + limit);
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
			idList = dao.getIdList("getPuserIdsByRoleIDAndStatus",
					new Object[] { roleID, status }, start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by name,start,limit)  : " + roleID
					+ " , " + status + " , " + start + " , " + limit);
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

	@Override
	public List<Long> getPuserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

		log.info(" get ids   by start,limit  ================== " + start
				+ " , " + limit);
		List<Long> idList = null;

		// TODO 参数检查!

		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}

		// dao.excuteSimpleSql(arg0, arg1)

		try {
			idList = dao.getIdList("getPuserIdsAll", new Object[] {}, start,
					limit, false);
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
	public Integer countPuserIds() throws ServiceException, ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getPuserIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPuserIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

	@Override
	public List<Long> getPuserIdsByCondition(Map<String, Object> conditions,
			Integer start, Integer limit) throws ServiceException,
			ServiceDaoException {

		String sql = "select id from puser where ";
		try {
			Set<String> fieldSet = conditions.keySet();
			for (String field : fieldSet) {
				sql += field + "='" + conditions.get(field) + "'";
				sql += " and ";
			}
			sql = sql.substring(0, sql.length() - " and ".length());

			sql += " limit " + start + "," + limit;

			log.info("sql:" + sql);

			Object o = dao.excuteSimpleSql(sql, Puser.class);
			if (o instanceof List) {
				return (List<Long>) o;
			} else {
				List<Long> ids = new ArrayList();
				BigInteger id = (BigInteger) o;
				ids.add(id.longValue());
				return ids;
			}
		} catch (DaoException e) {
			log.error(" count by getPuserIds ");
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
	}

}
