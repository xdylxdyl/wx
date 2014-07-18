package com.qding.framework.publics.service;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Constants;

/**
 * 常量Service
 * @author TaoMingkai
 * @version 1.0
 * @since 2014/6/5 14:10
 */
@Remotable
public interface ConstantsService extends BaseDaoService {

	public Long insert(Constants constants) throws ServiceException, ServiceDaoException;

	public List<Constants> insertList(List<Constants> constantsList) throws ServiceException, ServiceDaoException;

	public boolean delete(Long id) throws ServiceException, ServiceDaoException;

	public boolean update(Constants constants) throws ServiceException, ServiceDaoException;

	public boolean updateList(List<Constants> constantsList) throws ServiceException, ServiceDaoException;

	public Constants getObjectById(Long id) throws ServiceException, ServiceDaoException;

	public List<Constants> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

	public  List<Long> getConstantsIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;

	public Integer countConstantsIds() throws ServiceException, ServiceDaoException;
}
