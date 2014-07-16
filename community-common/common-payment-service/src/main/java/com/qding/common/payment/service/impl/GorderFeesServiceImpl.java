package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.GorderFees;
import com.qding.common.payment.service.GorderFeesService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class GorderFeesServiceImpl extends BaseDaoServiceImpl implements GorderFeesService {

 

	private static final Log log = LogFactory.getLog(GorderFeesServiceImpl.class);



		   
		@Override
		public Long insert(GorderFees gorderFees)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + gorderFees);

		if (gorderFees == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		gorderFees.setCreateAt(currentTimeMillis);
		gorderFees.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(gorderFees);
		} catch (DaoException e) {
			log.error(" insert wrong : " + gorderFees);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<GorderFees> insertList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (gorderFeesList == null ? "null" : gorderFeesList.size()));
      
		List<GorderFees> resultList = null;

		if (CollectionUtils.isEmpty(gorderFeesList)) {
			return new ArrayList<GorderFees>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GorderFees gorderFees : gorderFeesList) {
			gorderFees.setCreateAt(currentTimeMillis);
			gorderFees.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<GorderFees>) dao.batchSave(gorderFeesList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + gorderFeesList);
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
			result = dao.delete(GorderFees.class, id);
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
		public boolean update(GorderFees gorderFees)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (gorderFees == null ? "null" : gorderFees.getId()));

		boolean result = false;

		if (gorderFees == null) {
			return true;
		}

		gorderFees.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(gorderFees);
		} catch (DaoException e) {
			log.error(" update wrong : " + gorderFees);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + gorderFees);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (gorderFeesList == null ? "null" : gorderFeesList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(gorderFeesList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (GorderFees gorderFees : gorderFeesList) {
			gorderFees.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(gorderFeesList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + gorderFeesList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + gorderFeesList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public GorderFees getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		GorderFees gorderFees = null;

		if (id == null) {
			return gorderFees;
		}

		try {
			gorderFees = (GorderFees) dao.get(GorderFees.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return gorderFees;		
		}	
		  
    	   
		@Override
		public List<GorderFees> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<GorderFees> gorderFees = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<GorderFees>();
		}

		try {
			gorderFees = (List<GorderFees>) dao.getList(GorderFees.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (gorderFees == null ? "null" : gorderFees.size()));
    
		return gorderFees;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getGorderFeesIdByGorderCodeAndType(String gorderCode,int type)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,type  : " + gorderCode+" , "+type );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getGorderFeesIdByGorderCodeAndType", new Object[] {gorderCode,type });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,type  : " + gorderCode+" , "+type );
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
	public List<Long>  getGorderFeesIdsByTypeAndStatus(int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by type,status,start,limit  : " + type+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getGorderFeesIdsByTypeAndStatus", new Object[] { type,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by type,status,start,limit)  : " + type+" , "+status+" , "+start+" , "+limit );
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
	public List<Long>  getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by paymentTypeId,type,status,start,limit  : " + paymentTypeId+" , "+type+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus", new Object[] { paymentTypeId,type,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by paymentTypeId,type,status,start,limit)  : " + paymentTypeId+" , "+type+" , "+status+" , "+start+" , "+limit );
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
	public Integer  countGorderFeesIdsByTypeAndStatus(int type,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type,status  : " + type+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderFeesIdsByTypeAndStatus", new Object[] { type,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by type,status)  : " + type+" , "+status );
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
	public Integer  countGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by paymentTypeId,type,status  : " + paymentTypeId+" , "+type+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus", new Object[] { paymentTypeId,type,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by paymentTypeId,type,status)  : " + paymentTypeId+" , "+type+" , "+status );
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
	public List<Long> getGorderFeesIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getGorderFeesIdsAll",new Object[] {},start, limit, false);
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
	public Integer countGorderFeesIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getGorderFeesIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getGorderFeesIds " ) ;
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

