package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Project;
import com.qding.framework.publics.service.ProjectService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class ProjectServiceImpl extends BaseDaoServiceImpl implements ProjectService {

    
	private static final Log log = LogFactory.getLog(ProjectServiceImpl.class);



		   
		@Override
		public Long insert(Project project)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + project);
 }
		if (project == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		project.setCreateAt(currentTimeMillis);
		project.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(project);
		} catch (DaoException e) {
			log.error(" insert wrong : " + project);
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
		public List<Project> insertList(List<Project> projectList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (projectList == null ? "null" : projectList.size()));
      }
		List<Project> resultList = null;

		if (CollectionUtils.isEmpty(projectList)) {
			return new ArrayList<Project>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Project project : projectList) {
			project.setCreateAt(currentTimeMillis);
			project.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Project>) dao.batchSave(projectList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + projectList);
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
			result = dao.delete(Project.class, id);
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
		public boolean update(Project project)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (project == null ? "null" : project.getId()));

		boolean result = false;

		if (project == null) {
			return true;
		}

		project.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(project);
		} catch (DaoException e) {
			log.error(" update wrong : " + project);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + project);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Project> projectList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (projectList == null ? "null" : projectList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(projectList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Project project : projectList) {
			project.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(projectList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + projectList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + projectList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Project getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Project project = null;

		if (id == null) {
			return project;
		}

		try {
			project = (Project) dao.get(Project.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return project;		
		}	
		  
    	   
		@Override
		public List<Project> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Project> project = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Project>();
		}

		try {
			project = (List<Project>) dao.getList(Project.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (project == null ? "null" : project.size()));
     }
		return project;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getProjectIdByName(String name)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by name  : " + name );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getProjectIdByName", new Object[] {name });
   } catch (DaoException e) {
			log.error(" get id wrong by name  : " + name );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getProjectIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getProjectIdsAll",new Object[] {},start, limit, false);
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
	public Integer countProjectIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getProjectIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getProjectIds " ) ;
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

