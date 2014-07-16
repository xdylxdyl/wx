package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.Refund;
import com.qding.common.payment.service.RefundService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class RefundServiceImpl extends BaseDaoServiceImpl implements RefundService {

 

	private static final Log log = LogFactory.getLog(RefundServiceImpl.class);



		   
		@Override
		public Long insert(Refund refund)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + refund);

		if (refund == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		refund.setCreateAt(currentTimeMillis);
		refund.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(refund);
		} catch (DaoException e) {
			log.error(" insert wrong : " + refund);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Refund> insertList(List<Refund> refundList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (refundList == null ? "null" : refundList.size()));
      
		List<Refund> resultList = null;

		if (CollectionUtils.isEmpty(refundList)) {
			return new ArrayList<Refund>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Refund refund : refundList) {
			refund.setCreateAt(currentTimeMillis);
			refund.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Refund>) dao.batchSave(refundList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + refundList);
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
			result = dao.delete(Refund.class, id);
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
		public boolean update(Refund refund)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (refund == null ? "null" : refund.getId()));

		boolean result = false;

		if (refund == null) {
			return true;
		}

		refund.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(refund);
		} catch (DaoException e) {
			log.error(" update wrong : " + refund);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + refund);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Refund> refundList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (refundList == null ? "null" : refundList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(refundList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Refund refund : refundList) {
			refund.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(refundList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + refundList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + refundList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Refund getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Refund refund = null;

		if (id == null) {
			return refund;
		}

		try {
			refund = (Refund) dao.get(Refund.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return refund;		
		}	
		  
    	   
		@Override
		public List<Refund> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Refund> refund = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Refund>();
		}

		try {
			refund = (List<Refund>) dao.getList(Refund.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (refund == null ? "null" : refund.size()));
    
		return refund;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRefundIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getRefundIdsByGorderCode", new Object[] { gorderCode},start,limit, false);

   
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
	public Long  getRefundIdByGorderCodeAndGoodsId(String gorderCode,Long goodsId)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by gorderCode,goodsId  : " + gorderCode+" , "+goodsId );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getRefundIdByGorderCodeAndGoodsId", new Object[] {gorderCode,goodsId });
   } catch (DaoException e) {
			log.error(" get id wrong by gorderCode,goodsId  : " + gorderCode+" , "+goodsId );
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
	public Integer  countRefundIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by gorderCode  : " + gorderCode );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getRefundIdsByGorderCode", new Object[] { gorderCode});

   
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
	public List<Long> getRefundIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getRefundIdsAll",new Object[] {},start, limit, false);
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
	public Integer countRefundIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRefundIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRefundIds " ) ;
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

