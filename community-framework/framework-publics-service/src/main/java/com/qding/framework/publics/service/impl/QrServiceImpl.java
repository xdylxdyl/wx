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
import com.qding.framework.publics.model.Qr;
import com.qding.framework.publics.service.QrService;



public class QrServiceImpl extends BaseDaoServiceImpl  implements QrService {

   

	private static final Log log = LogFactory.getLog(QrServiceImpl.class);




		   
		@Override
		public Long insert(Qr qr)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + qr);
 }
		if (qr == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		qr.setCreateAt(currentTimeMillis);
		qr.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(qr);
		} catch (DaoException e) {
			log.error(" insert wrong : " + qr);
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
		public List<Qr> insertList(List<Qr> qrList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (qrList == null ? "null" : qrList.size()));
      }
		List<Qr> resultList = null;

		if (CollectionUtils.isEmpty(qrList)) {
			return new ArrayList<Qr>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Qr qr : qrList) {
			qr.setCreateAt(currentTimeMillis);
			qr.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Qr>) dao.batchSave(qrList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + qrList);
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
			result = dao.delete(Qr.class, id);
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
		public boolean update(Qr qr)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (qr == null ? "null" : qr.getId()));

		boolean result = false;

		if (qr == null) {
			return true;
		}

		qr.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(qr);
		} catch (DaoException e) {
			log.error(" update wrong : " + qr);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + qr);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Qr> qrList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (qrList == null ? "null" : qrList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(qrList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Qr qr : qrList) {
			qr.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(qrList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + qrList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + qrList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Qr getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Qr qr = null;

		if (id == null) {
			return qr;
		}

		try {
			qr = (Qr) dao.get(Qr.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return qr;		
		}	
		  
    	   
		@Override
		public List<Qr> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Qr> qr = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Qr>();
		}

		try {
			qr = (List<Qr>) dao.getList(Qr.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (qr == null ? "null" : qr.size()));
     }
		return qr;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getQrIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getQrIdsByPublicsID", new Object[] { publicsID},start,limit, false);

   
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
	public Integer  countQrIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by publicsID  : " + publicsID );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getQrIdsByPublicsID", new Object[] { publicsID});

   
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
	public List<Long> getQrIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getQrIdsAll",new Object[] {},start, limit, false);
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
	public Integer countQrIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getQrIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getQrIds " ) ;
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

