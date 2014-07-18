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
import com.qding.framework.publics.model.Role;
import com.qding.framework.publics.service.RoleService;



public class RoleServiceImpl extends BaseDaoServiceImpl implements RoleService {

   

	private static final Log log = LogFactory.getLog(RoleServiceImpl.class);




		   
		@Override
		public Long insert(Role role)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + role);
 }
		if (role == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		role.setCreateAt(currentTimeMillis);
		role.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(role);
		} catch (DaoException e) {
			log.error(" insert wrong : " + role);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
      if(log.isInfoEnabled()){
		log.info(" insert data success : " + result);
      }
return result;	
		}	
		  
    	   
		@Override
		public List<Role> insertList(List<Role> roleList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (roleList == null ? "null" : roleList.size()));
      }
		List<Role> resultList = null;

		if (CollectionUtils.isEmpty(roleList)) {
			return new ArrayList<Role>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Role role : roleList) {
			role.setCreateAt(currentTimeMillis);
			role.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Role>) dao.batchSave(roleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + roleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
      }
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		             if(log.isInfoEnabled()){
	    log.info(" delete data : " + id);
    }
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Role.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
   if(log.isInfoEnabled()){
		log.info(" delete data success : " + id);
    }
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Role role)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (role == null ? "null" : role.getId()));

		boolean result = false;

		if (role == null) {
			return true;
		}

		role.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(role);
		} catch (DaoException e) {
			log.error(" update wrong : " + role);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + role);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Role> roleList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (roleList == null ? "null" : roleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(roleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Role role : roleList) {
			role.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(roleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + roleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + roleList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Role getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Role role = null;

		if (id == null) {
			return role;
		}

		try {
			role = (Role) dao.get(Role.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return role;		
		}	
		  
    	   
		@Override
		public List<Role> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Role> role = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Role>();
		}

		try {
			role = (List<Role>) dao.getList(Role.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (role == null ? "null" : role.size()));
     }
		return role;	
		}	
		  
    	
		
	
	
		@Override
		public List<Long> getRoleIdsByName(String name, Integer start, Integer limit)
				throws ServiceException, ServiceDaoException {
			
			log.info(" get ids   by name,start,limit  ================== " + name + start + " , " + limit);
			List<Long> idList = null;
			
			
			
			if (start == null) {
				start = 0;
			}

			if (limit == null) {
				limit = Integer.MAX_VALUE;
			}
			
			try {
				idList = dao.getIdList("getRoleIdsByName",new Object[] {name},start, limit, false);
			} catch (DaoException e) {
				log.error(" get ids  wrong by name,start,limit)  : " + name + " , " + start + " , " + limit);
				log.error(e);
				e.printStackTrace();
				throw new ServiceDaoException(e);
			}
			if (log.isInfoEnabled()) {
				log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
			}
			return idList;
		}	
	
		
	
	
	
		
	@Override
	public List<Long> getRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getRoleIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countRoleIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRoleIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRoleIds " ) ;
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

