package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.UnionPayment;
import com.qding.common.payment.service.UnionPaymentService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class UnionPaymentServiceImpl extends BaseDaoServiceImpl implements UnionPaymentService {

 

	private static final Log log = LogFactory.getLog(UnionPaymentServiceImpl.class);



		   
		@Override
		public Long insert(UnionPayment unionPayment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + unionPayment);

		if (unionPayment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		unionPayment.setCreateAt(currentTimeMillis);
		unionPayment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(unionPayment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + unionPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UnionPayment> insertList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (unionPaymentList == null ? "null" : unionPaymentList.size()));
      
		List<UnionPayment> resultList = null;

		if (CollectionUtils.isEmpty(unionPaymentList)) {
			return new ArrayList<UnionPayment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UnionPayment unionPayment : unionPaymentList) {
			unionPayment.setCreateAt(currentTimeMillis);
			unionPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UnionPayment>) dao.batchSave(unionPaymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + unionPaymentList);
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
			result = dao.delete(UnionPayment.class, id);
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
		public boolean update(UnionPayment unionPayment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (unionPayment == null ? "null" : unionPayment.getId()));

		boolean result = false;

		if (unionPayment == null) {
			return true;
		}

		unionPayment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(unionPayment);
		} catch (DaoException e) {
			log.error(" update wrong : " + unionPayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + unionPayment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (unionPaymentList == null ? "null" : unionPaymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(unionPaymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UnionPayment unionPayment : unionPaymentList) {
			unionPayment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(unionPaymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + unionPaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + unionPaymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UnionPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UnionPayment unionPayment = null;

		if (id == null) {
			return unionPayment;
		}

		try {
			unionPayment = (UnionPayment) dao.get(UnionPayment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return unionPayment;		
		}	
		  
    	   
		@Override
		public List<UnionPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UnionPayment> unionPayment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UnionPayment>();
		}

		try {
			unionPayment = (List<UnionPayment>) dao.getList(UnionPayment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (unionPayment == null ? "null" : unionPayment.size()));
    
		return unionPayment;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUnionPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by gorderCode,start,limit  : " + gorderCode+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getUnionPaymentIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by gorderCode,start,limit)  : " + gorderCode+" , "+start+" , "+limit );
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
	public Long  getUnionPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,qdCode  : " + gorderCode+" , "+qdCode );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getUnionPaymentIdByGorderCodeAndQdCode", new Object[] {gorderCode,qdCode });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,qdCode  : " + gorderCode+" , "+qdCode );
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
	public Integer  countUnionPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getUnionPaymentIdsByGorderCode", new Object[] { gorderCode});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by gorderCode)  : " + gorderCode );
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
	public List<Long> getUnionPaymentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUnionPaymentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUnionPaymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUnionPaymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUnionPaymentIds " ) ;
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

