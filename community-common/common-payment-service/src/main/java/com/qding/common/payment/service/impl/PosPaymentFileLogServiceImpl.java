package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentFileLog;
import com.qding.common.payment.service.PosPaymentFileLogService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class PosPaymentFileLogServiceImpl extends BaseDaoServiceImpl implements PosPaymentFileLogService {

 

	private static final Log log = LogFactory.getLog(PosPaymentFileLogServiceImpl.class);



		   
		@Override
		public Long insert(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + posPaymentFileLog);

		if (posPaymentFileLog == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		posPaymentFileLog.setCreateAt(currentTimeMillis);
		posPaymentFileLog.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(posPaymentFileLog);
		} catch (DaoException e) {
			log.error(" insert wrong : " + posPaymentFileLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<PosPaymentFileLog> insertList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (posPaymentFileLogList == null ? "null" : posPaymentFileLogList.size()));
      
		List<PosPaymentFileLog> resultList = null;

		if (CollectionUtils.isEmpty(posPaymentFileLogList)) {
			return new ArrayList<PosPaymentFileLog>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentFileLog posPaymentFileLog : posPaymentFileLogList) {
			posPaymentFileLog.setCreateAt(currentTimeMillis);
			posPaymentFileLog.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<PosPaymentFileLog>) dao.batchSave(posPaymentFileLogList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + posPaymentFileLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(PosPaymentFileLog.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (posPaymentFileLog == null ? "null" : posPaymentFileLog.getId()));

		boolean result = false;

		if (posPaymentFileLog == null) {
			return true;
		}

		posPaymentFileLog.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(posPaymentFileLog);
		} catch (DaoException e) {
			log.error(" update wrong : " + posPaymentFileLog);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + posPaymentFileLog);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (posPaymentFileLogList == null ? "null" : posPaymentFileLogList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(posPaymentFileLogList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (PosPaymentFileLog posPaymentFileLog : posPaymentFileLogList) {
			posPaymentFileLog.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(posPaymentFileLogList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + posPaymentFileLogList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + posPaymentFileLogList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public PosPaymentFileLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		PosPaymentFileLog posPaymentFileLog = null;

		if (id == null) {
			return posPaymentFileLog;
		}

		try {
			posPaymentFileLog = (PosPaymentFileLog) dao.get(PosPaymentFileLog.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return posPaymentFileLog;		
		}	
		  
    	   
		@Override
		public List<PosPaymentFileLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<PosPaymentFileLog> posPaymentFileLog = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<PosPaymentFileLog>();
		}

		try {
			posPaymentFileLog = (List<PosPaymentFileLog>) dao.getList(PosPaymentFileLog.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (posPaymentFileLog == null ? "null" : posPaymentFileLog.size()));
    
		return posPaymentFileLog;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentFileLogIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by type,start,limit  : " + type+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getPosPaymentFileLogIdsByType", new Object[] { type},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by type,start,limit)  : " + type+" , "+start+" , "+limit );
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
	public Integer  countPosPaymentFileLogIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getPosPaymentFileLogIdsByType", new Object[] { type});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by type)  : " + type );
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
	public List<Long> getPosPaymentFileLogIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getPosPaymentFileLogIdsAll",new Object[] {},start, limit, false);
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
	public Integer countPosPaymentFileLogIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getPosPaymentFileLogIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getPosPaymentFileLogIds " ) ;
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

