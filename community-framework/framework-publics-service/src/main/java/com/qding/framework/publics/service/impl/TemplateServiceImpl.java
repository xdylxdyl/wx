package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Template;
import com.qding.framework.publics.service.TemplateService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class TemplateServiceImpl extends BaseDaoServiceImpl implements TemplateService {

 

	private static final Log log = LogFactory.getLog(TemplateServiceImpl.class);



		   
		@Override
		public Long insert(Template template)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + template);
 }
		if (template == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		template.setCreateAt(currentTimeMillis);
		template.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(template);
		} catch (DaoException e) {
			log.error(" insert wrong : " + template);
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
		public List<Template> insertList(List<Template> templateList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (templateList == null ? "null" : templateList.size()));
      }
		List<Template> resultList = null;

		if (CollectionUtils.isEmpty(templateList)) {
			return new ArrayList<Template>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Template template : templateList) {
			template.setCreateAt(currentTimeMillis);
			template.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Template>) dao.batchSave(templateList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + templateList);
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
			result = dao.delete(Template.class, id);
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
		public boolean update(Template template)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (template == null ? "null" : template.getId()));

		boolean result = false;

		if (template == null) {
			return true;
		}

		template.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(template);
		} catch (DaoException e) {
			log.error(" update wrong : " + template);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + template);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Template> templateList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (templateList == null ? "null" : templateList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(templateList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Template template : templateList) {
			template.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(templateList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + templateList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + templateList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Template getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Template template = null;

		if (id == null) {
			return template;
		}

		try {
			template = (Template) dao.get(Template.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return template;		
		}	
		  
    	   
		@Override
		public List<Template> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Template> template = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Template>();
		}

		try {
			template = (List<Template>) dao.getList(Template.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (template == null ? "null" : template.size()));
     }
		return template;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTemplateIdsByCodeAndPublicsID(String code,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by code,publicsID,start,limit  : " + code+" , "+publicsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTemplateIdsByCodeAndPublicsID", new Object[] { code,publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by code,publicsID,start,limit)  : " + code+" , "+publicsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
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
	public List<Long>  getTemplateIdsByTypeAndPublicsID(String type,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by type,publicsID,start,limit  : " + type+" , "+publicsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getTemplateIdsByTypeAndPublicsID", new Object[] { type,publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by type,publicsID,start,limit)  : " + type+" , "+publicsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
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
	public Integer  countTemplateIdsByCodeAndPublicsID(String code,Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by code,publicsID  : " + code+" , "+publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTemplateIdsByCodeAndPublicsID", new Object[] { code,publicsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by code,publicsID)  : " + code+" , "+publicsID );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTemplateIdsByTypeAndPublicsID(String type,Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type,publicsID  : " + type+" , "+publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTemplateIdsByTypeAndPublicsID", new Object[] { type,publicsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by type,publicsID)  : " + type+" , "+publicsID );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
		
	
	
	
		
	@Override
	public List<Long> getTemplateIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getTemplateIdsAll",new Object[] {},start, limit, false);
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
	public Integer countTemplateIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTemplateIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTemplateIds " ) ;
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

