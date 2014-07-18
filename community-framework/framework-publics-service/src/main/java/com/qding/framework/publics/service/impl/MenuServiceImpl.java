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
import com.qding.framework.publics.model.Menu;
import com.qding.framework.publics.service.MenuService;

public class MenuServiceImpl extends BaseDaoServiceImpl  implements MenuService {


	private static final Log log = LogFactory.getLog(MenuServiceImpl.class);



	@Override
	public Long insert(Menu menu) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert data : " + menu);
		}
		if (menu == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		menu.setCreateAt(currentTimeMillis);
		menu.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(menu);
		} catch (DaoException e) {
			log.error(" insert wrong : " + menu);
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
	public List<Menu> insertList(List<Menu> menuList) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" insert lists : " + (menuList == null ? "null" : menuList.size()));
		}
		List<Menu> resultList = null;

		if (CollectionUtils.isEmpty(menuList)) {
			return new ArrayList<Menu>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Menu menu : menuList) {
			menu.setCreateAt(currentTimeMillis);
			menu.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Menu>) dao.batchSave(menuList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + menuList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
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
			result = dao.delete(Menu.class, id);
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
	public boolean update(Menu menu) throws ServiceException, ServiceDaoException {

		log.info(" update data : " + (menu == null ? "null" : menu.getId()));

		boolean result = false;

		if (menu == null) {
			return true;
		}

		menu.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(menu);
		} catch (DaoException e) {
			log.error(" update wrong : " + menu);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update data success : " + menu);
		}
		return result;
	}

	@Override
	public boolean updateList(List<Menu> menuList) throws ServiceException, ServiceDaoException {

		log.info(" update lists : " + (menuList == null ? "null" : menuList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(menuList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Menu menu : menuList) {
			menu.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(menuList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + menuList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" update lists success : " + menuList.size());
		}
		return result;
	}

	@Override
	public Menu getObjectById(Long id) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get data : " + id);
		}
		Menu menu = null;

		if (id == null) {
			return menu;
		}

		try {
			menu = (Menu) dao.get(Menu.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + id);
		}
		return menu;
	}

	@Override
	public List<Menu> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get lists : " + (ids == null ? "null" : ids));
		}
		List<Menu> menu = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Menu>();
		}

		try {
			menu = (List<Menu>) dao.getList(Menu.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get data success : " + (menu == null ? "null" : menu.size()));
		}
		return menu;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public String getMenuMenuByPublicsID(Long publicsID) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get menu by publicsID  : " + publicsID);
		}
		String menu = null;

		// TODO 参数检查!

		try {

			menu = (String) dao.getMapping("getMenuMenuByPublicsID", new Object[] { publicsID });
		} catch (DaoException e) {
			log.error(" get menu wrong by publicsID  : " + publicsID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get menu success : " + menu);
		}
		return menu;

	}

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	@Override
	public Long getMenuIdByPublicsID(Long publicsID) throws ServiceException, ServiceDaoException {

		if (log.isInfoEnabled()) {
			log.info(" get id by publicsID  : " + publicsID);
		}
		Long id = null;

		// TODO 参数检查!

		try {

			id = (Long) dao.getMapping("getMenuIdByPublicsID", new Object[] { publicsID });
		} catch (DaoException e) {
			log.error(" get id wrong by publicsID  : " + publicsID);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get id success : " + id);
		}
		return id;

	}

}
