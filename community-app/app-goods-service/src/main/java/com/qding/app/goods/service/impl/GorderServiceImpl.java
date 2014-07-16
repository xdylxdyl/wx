package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Gorder;
import com.qding.app.goods.service.GorderService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class GorderServiceImpl extends BaseDaoServiceImpl implements GorderService {

 

	private static final Log log = LogFactory.getLog(GorderServiceImpl.class);



		   
		@Override
		public Long insert(Gorder gorder)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + gorder);
 }
		if (gorder == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		gorder.setCreateAt(currentTimeMillis);
		gorder.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(gorder);
		} catch (DaoException e) {
			log.error(" insert wrong : " + gorder);
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
		public List<Gorder> insertList(List<Gorder> gorderList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (gorderList == null ? "null" : gorderList.size()));
      }
		List<Gorder> resultList = null;

		if (CollectionUtils.isEmpty(gorderList)) {
			return new ArrayList<Gorder>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Gorder gorder : gorderList) {
			gorder.setCreateAt(currentTimeMillis);
			gorder.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Gorder>) dao.batchSave(gorderList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + gorderList);
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
			result = dao.delete(Gorder.class, id);
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
		public boolean update(Gorder gorder)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (gorder == null ? "null" : gorder.getId()));

		boolean result = false;

		if (gorder == null) {
			return true;
		}

		gorder.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(gorder);
		} catch (DaoException e) {
			log.error(" update wrong : " + gorder);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + gorder);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Gorder> gorderList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (gorderList == null ? "null" : gorderList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(gorderList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Gorder gorder : gorderList) {
			gorder.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(gorderList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + gorderList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + gorderList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Gorder getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Gorder gorder = null;

		if (id == null) {
			return gorder;
		}

		try {
			gorder = (Gorder) dao.get(Gorder.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return gorder;		
		}	
		  
    	   
		@Override
		public List<Gorder> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Gorder> gorder = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Gorder>();
		}

		try {
			gorder = (List<Gorder>) dao.getList(Gorder.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (gorder == null ? "null" : gorder.size()));
     }
		return gorder;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderIdsByUserID(Long userID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userID,start,limit  : " + userID+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getGorderIdsByUserID", new Object[] { userID},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userID,start,limit)  : " + userID+" , "+start+" , "+limit );
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
	public Long  getGorderIdByCode(String code)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by code  : " + code );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getGorderIdByCode", new Object[] {code });
   } catch (DaoException e) {
			log.error(" get id wrong by code  : " + code );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
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
	public List<Long>  getGorderIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getGorderIdsByPublicsID", new Object[] { publicsID},start,limit, false);

   
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
	public Integer  countGorderIdsByUserID(Long userID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userID  : " + userID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderIdsByUserID", new Object[] { userID});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userID)  : " + userID );
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
	public Integer  countGorderIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderIdsByPublicsID", new Object[] { publicsID});

   
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
	
		
	
	
	
		
	@Override
	public List<Long> getGorderIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGorderIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGorderIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGorderIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGorderIds " ) ;
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

