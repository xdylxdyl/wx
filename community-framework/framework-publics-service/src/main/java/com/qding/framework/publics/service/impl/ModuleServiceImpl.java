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
import com.qding.framework.publics.model.Module;
import com.qding.framework.publics.service.ModuleService;

public class ModuleServiceImpl extends BaseDaoServiceImpl  implements ModuleService {

	

	private static final Log log = LogFactory.getLog(ModuleServiceImpl.class);



	@Override
	public Long insert(Module module) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + module);
		}
		if (module == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		module.setCreateAt(currentTimeMillis);
		module.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(module);
		} catch (DaoException e) {
			log.error(" insert wrong : " + module);
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
	public List<Module> insertList(List<Module> moduleList)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : "
					+ (moduleList == null ? "null" : moduleList.size()));
		}
		List<Module> resultList = null;

		if (CollectionUtils.isEmpty(moduleList)) {
			return new ArrayList<Module>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Module module : moduleList) {
			module.setCreateAt(currentTimeMillis);
			module.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Module>) dao.batchSave(moduleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + moduleList);
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
			result = dao.delete(Module.class, id);
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
	public boolean update(Module module) throws ServiceException,
			ServiceDaoException {

		log.info(" update data : " + (module == null ? "null" : module.getId()));

		boolean result = false;

		if (module == null) {
			return true;
		}

		module.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(module);
		} catch (DaoException e) {
			log.error(" update wrong : " + module);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + module);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Module> moduleList) throws ServiceException,
			ServiceDaoException {

		log.info(" update lists : "
				+ (moduleList == null ? "null" : moduleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(moduleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Module module : moduleList) {
			module.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(moduleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + moduleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + moduleList.size());
		}
		return result;
	}

	@Override
	public Module getObjectById(Long id) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Module module = null;

		if (id == null) {
			return module;
		}

		try {
			module = (Module) dao.get(Module.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return module;
	}

	@Override
	public List<Module> getObjectsByIds(List<Long> ids)
			throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Module> module = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Module>();
		}

		try {
			module = (List<Module>) dao.getList(Module.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : "
					+ (module == null ? "null" : module.size()));
		}
		return module;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public List<Long> getModuleIdsByType(String type, Integer start,
			Integer limit) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by type,start,limit  : " + type + " , " + start
					+ " , " + limit);
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
			idList = dao.getIdList("getModuleIdsByType", new Object[] { type },
					start, limit, false);

		} catch (DaoException e) {
			log.error(" get ids  wrong by type,start,limit)  : " + type + " , "
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
	public Long getModuleIdByUrlAndType(String url, String type) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get ids by url,type  : " + url + " , " + type);
		}
		Long id = null;

		try {
			id = (Long) dao.getMapping("getModuleIdByUrlAndType", new Object[] { url, type });

		} catch (DaoException e) {
			log.error(" get id  wrong by url,type  : " + url + " , "
					+ type);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success : "
					+ (id == null ? "null" : id));
		}
		return id;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Integer countModuleIdsByType(String type) throws ServiceException,
			ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" count ids by type  : " + type);
		}
		Integer count = null;

		try {

			count = dao.count("getModuleIdsByType", new Object[] { type });

		} catch (DaoException e) {
			log.error(" count ids  wrong by type)  : " + type);
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
	public List<Long> getModuleIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getModuleIdsAll", new Object[] {}, start,
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
	public Integer countModuleIds() throws ServiceException,
			ServiceDaoException {
		Integer count = 0;
		try {
			count = dao.count("getModuleIdsAll", new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getModuleIds ");
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
