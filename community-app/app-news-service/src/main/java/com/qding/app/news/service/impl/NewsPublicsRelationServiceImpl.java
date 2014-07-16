package com.qding.app.news.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.news.model.NewsPublicsRelation;
import com.qding.app.news.service.NewsPublicsRelationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class NewsPublicsRelationServiceImpl extends BaseDaoServiceImpl implements NewsPublicsRelationService {

 

	private static final Log log = LogFactory.getLog(NewsPublicsRelationServiceImpl.class);



		   
		@Override
		public Long insert(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + newsPublicsRelation);
 }
		if (newsPublicsRelation == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		newsPublicsRelation.setCreateAt(currentTimeMillis);
		newsPublicsRelation.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(newsPublicsRelation);
		} catch (DaoException e) {
			log.error(" insert wrong : " + newsPublicsRelation);
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
		public List<NewsPublicsRelation> insertList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (newsPublicsRelationList == null ? "null" : newsPublicsRelationList.size()));
      }
		List<NewsPublicsRelation> resultList = null;

		if (CollectionUtils.isEmpty(newsPublicsRelationList)) {
			return new ArrayList<NewsPublicsRelation>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (NewsPublicsRelation newsPublicsRelation : newsPublicsRelationList) {
			newsPublicsRelation.setCreateAt(currentTimeMillis);
			newsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<NewsPublicsRelation>) dao.batchSave(newsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + newsPublicsRelationList);
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
			result = dao.delete(NewsPublicsRelation.class, id);
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
		public boolean update(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (newsPublicsRelation == null ? "null" : newsPublicsRelation.getId()));

		boolean result = false;

		if (newsPublicsRelation == null) {
			return true;
		}

		newsPublicsRelation.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(newsPublicsRelation);
		} catch (DaoException e) {
			log.error(" update wrong : " + newsPublicsRelation);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + newsPublicsRelation);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (newsPublicsRelationList == null ? "null" : newsPublicsRelationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(newsPublicsRelationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (NewsPublicsRelation newsPublicsRelation : newsPublicsRelationList) {
			newsPublicsRelation.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(newsPublicsRelationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + newsPublicsRelationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + newsPublicsRelationList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public NewsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		NewsPublicsRelation newsPublicsRelation = null;

		if (id == null) {
			return newsPublicsRelation;
		}

		try {
			newsPublicsRelation = (NewsPublicsRelation) dao.get(NewsPublicsRelation.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return newsPublicsRelation;		
		}	
		  
    	   
		@Override
		public List<NewsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<NewsPublicsRelation> newsPublicsRelation = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<NewsPublicsRelation>();
		}

		try {
			newsPublicsRelation = (List<NewsPublicsRelation>) dao.getList(NewsPublicsRelation.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (newsPublicsRelation == null ? "null" : newsPublicsRelation.size()));
     }
		return newsPublicsRelation;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPublicsIDsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get publicsIDs by newsID,start,limit  : " + newsID+" , "+start+" , "+limit );
	  }
	 	List<Long> publicsIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		publicsIDList = dao.getIdList("getPublicsIDsByNewsID", new Object[] { newsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get publicsIDs  wrong by newsID,start,limit)  : " + newsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get publicsIDs success : " + (publicsIDList == null ? "null" : publicsIDList.size()));
  }
		return publicsIDList;
		
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsPublicsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by publicsID,start,limit  : " + publicsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getNewsPublicsRelationIdsByPublicsID", new Object[] { publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by publicsID,start,limit)  : " + publicsID+" , "+start+" , "+limit );
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
	public List<Long>  getNewsPublicsRelationIdsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by newsID,start,limit  : " + newsID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getNewsPublicsRelationIdsByNewsID", new Object[] { newsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by newsID,start,limit)  : " + newsID+" , "+start+" , "+limit );
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
	public List<Long>  getNewsIDsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get newsIDs by publicsID,start,limit  : " + publicsID+" , "+start+" , "+limit );
	  }
	 	List<Long> newsIDList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		newsIDList = dao.getIdList("getNewsIDsByPublicsID", new Object[] { publicsID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get newsIDs  wrong by publicsID,start,limit)  : " + publicsID+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get newsIDs success : " + (newsIDList == null ? "null" : newsIDList.size()));
  }
		return newsIDList;
		
	
	
	}
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPublicsIDsByNewsID(Long newsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count publicsIDs by newsID  : " + newsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPublicsIDsByNewsID", new Object[] { newsID});

   
   } catch (DaoException e) {
			log.error(" count publicsIDs  wrong by newsID)  : " + newsID );
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
	public Integer  countNewsPublicsRelationIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getNewsPublicsRelationIdsByPublicsID", new Object[] { publicsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by publicsID)  : " + publicsID );
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
	public Integer  countNewsPublicsRelationIdsByNewsID(Long newsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by newsID  : " + newsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getNewsPublicsRelationIdsByNewsID", new Object[] { newsID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by newsID)  : " + newsID );
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
	public Integer  countNewsIDsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count newsIDs by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getNewsIDsByPublicsID", new Object[] { publicsID});

   
   } catch (DaoException e) {
			log.error(" count newsIDs  wrong by publicsID)  : " + publicsID );
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
	public List<Long> getNewsPublicsRelationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getNewsPublicsRelationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countNewsPublicsRelationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getNewsPublicsRelationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getNewsPublicsRelationIds " ) ;
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

