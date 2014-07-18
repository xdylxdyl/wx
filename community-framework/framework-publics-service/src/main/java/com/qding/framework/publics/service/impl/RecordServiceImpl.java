package com.qding.framework.publics.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Record;
import com.qding.framework.publics.service.RecordService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class RecordServiceImpl extends BaseDaoServiceImpl implements RecordService {

 

	private static final Log log = LogFactory.getLog(RecordServiceImpl.class);



		   
		@Override
		public Long insert(Record record)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + record);
 }
		if (record == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		record.setCreateAt(currentTimeMillis);
		record.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(record);
		} catch (DaoException e) {
			log.error(" insert wrong : " + record);
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
		public List<Record> insertList(List<Record> recordList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (recordList == null ? "null" : recordList.size()));
      }
		List<Record> resultList = null;

		if (CollectionUtils.isEmpty(recordList)) {
			return new ArrayList<Record>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Record record : recordList) {
			record.setCreateAt(currentTimeMillis);
			record.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Record>) dao.batchSave(recordList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + recordList);
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
			result = dao.delete(Record.class, id);
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
		public boolean update(Record record)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (record == null ? "null" : record.getId()));

		boolean result = false;

		if (record == null) {
			return true;
		}

		record.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(record);
		} catch (DaoException e) {
			log.error(" update wrong : " + record);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + record);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Record> recordList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (recordList == null ? "null" : recordList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(recordList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Record record : recordList) {
			record.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(recordList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + recordList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + recordList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Record getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Record record = null;

		if (id == null) {
			return record;
		}

		try {
			record = (Record) dao.get(Record.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return record;		
		}	
		  
    	   
		@Override
		public List<Record> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Record> record = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Record>();
		}

		try {
			record = (List<Record>) dao.getList(Record.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (record == null ? "null" : record.size()));
     }
		return record;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRecordIdsByObjectIDAndModule(Long objectID,String module,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by objectID,module,start,limit  : " + objectID+" , "+module+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getRecordIdsByObjectIDAndModule", new Object[] { objectID,module},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by objectID,module,start,limit)  : " + objectID+" , "+module+" , "+start+" , "+limit );
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
	public Integer countRecordIdsByObjectIDAndModule(Long objectID,String module)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by objectID,module  : " + objectID+" , "+module );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getRecordIdsByObjectIDAndModule", new Object[] { objectID,module});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by objectID,module)  : " + objectID+" , "+module );
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
	public List<Long> getRecordIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getRecordIdsAll",new Object[] {},start, limit, false);
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
	public Integer countRecordIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRecordIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRecordIds " ) ;
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

