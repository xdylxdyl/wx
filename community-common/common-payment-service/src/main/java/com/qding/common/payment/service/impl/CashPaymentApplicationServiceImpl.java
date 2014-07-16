package com.qding.common.payment.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPaymentApplication;
import com.qding.common.payment.service.CashPaymentApplicationService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class CashPaymentApplicationServiceImpl extends BaseDaoServiceImpl implements CashPaymentApplicationService {

 

	private static final Log log = LogFactory.getLog(CashPaymentApplicationServiceImpl.class);



		   
		@Override
		public Long insert(CashPaymentApplication cashPaymentApplication)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + cashPaymentApplication);

		if (cashPaymentApplication == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		cashPaymentApplication.setCreateAt(currentTimeMillis);
		cashPaymentApplication.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(cashPaymentApplication);
		} catch (DaoException e) {
			log.error(" insert wrong : " + cashPaymentApplication);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<CashPaymentApplication> insertList(List<CashPaymentApplication> cashPaymentApplicationList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (cashPaymentApplicationList == null ? "null" : cashPaymentApplicationList.size()));
      
		List<CashPaymentApplication> resultList = null;

		if (CollectionUtils.isEmpty(cashPaymentApplicationList)) {
			return new ArrayList<CashPaymentApplication>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentApplication cashPaymentApplication : cashPaymentApplicationList) {
			cashPaymentApplication.setCreateAt(currentTimeMillis);
			cashPaymentApplication.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<CashPaymentApplication>) dao.batchSave(cashPaymentApplicationList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + cashPaymentApplicationList);
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
			result = dao.delete(CashPaymentApplication.class, id);
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
		public boolean update(CashPaymentApplication cashPaymentApplication)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (cashPaymentApplication == null ? "null" : cashPaymentApplication.getId()));

		boolean result = false;

		if (cashPaymentApplication == null) {
			return true;
		}

		cashPaymentApplication.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(cashPaymentApplication);
		} catch (DaoException e) {
			log.error(" update wrong : " + cashPaymentApplication);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + cashPaymentApplication);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentApplication> cashPaymentApplicationList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (cashPaymentApplicationList == null ? "null" : cashPaymentApplicationList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(cashPaymentApplicationList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (CashPaymentApplication cashPaymentApplication : cashPaymentApplicationList) {
			cashPaymentApplication.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(cashPaymentApplicationList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + cashPaymentApplicationList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + cashPaymentApplicationList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public CashPaymentApplication getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		CashPaymentApplication cashPaymentApplication = null;

		if (id == null) {
			return cashPaymentApplication;
		}

		try {
			cashPaymentApplication = (CashPaymentApplication) dao.get(CashPaymentApplication.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return cashPaymentApplication;		
		}	
		  
    	   
		@Override
		public List<CashPaymentApplication> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<CashPaymentApplication> cashPaymentApplication = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<CashPaymentApplication>();
		}

		try {
			cashPaymentApplication = (List<CashPaymentApplication>) dao.getList(CashPaymentApplication.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (cashPaymentApplication == null ? "null" : cashPaymentApplication.size()));
    
		return cashPaymentApplication;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(Long applicants,int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by applicants,type,status,start,limit  : " + applicants+" , "+type+" , "+status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByApplicantsAndTypeAndStatus", new Object[] { applicants,type,status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by applicants,type,status,start,limit)  : " + applicants+" , "+type+" , "+status+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentApplicationIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByType", new Object[] { type},start,limit, false);

   
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
	public List<Long>  getCashPaymentApplicationIdsByApplicants(Long applicants,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by applicants,start,limit  : " + applicants+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByApplicants", new Object[] { applicants},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by applicants,start,limit)  : " + applicants+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentApplicationIdsByReceiverAndStatusAndType(Long receiver,int status,int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by receiver,status,type,start,limit  : " + receiver+" , "+status+" , "+type+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByReceiverAndStatusAndType", new Object[] { receiver,status,type},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by receiver,status,type,start,limit)  : " + receiver+" , "+status+" , "+type+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentApplicationIdsByReceiver(Long receiver,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by receiver,start,limit  : " + receiver+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByReceiver", new Object[] { receiver},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by receiver,start,limit)  : " + receiver+" , "+start+" , "+limit );
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
	public List<Long>  getCashPaymentApplicationIdsByStatus(int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,start,limit  : " + status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getCashPaymentApplicationIdsByStatus", new Object[] { status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,start,limit)  : " + status+" , "+start+" , "+limit );
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
	public Integer  countCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(Long applicants,int type,int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by applicants,type,status  : " + applicants+" , "+type+" , "+status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByApplicantsAndTypeAndStatus", new Object[] { applicants,type,status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by applicants,type,status)  : " + applicants+" , "+type+" , "+status );
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
	public Integer  countCashPaymentApplicationIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by type  : " + type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByType", new Object[] { type});

   
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
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByApplicants(Long applicants)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by applicants  : " + applicants );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByApplicants", new Object[] { applicants});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by applicants)  : " + applicants );
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
	public Integer  countCashPaymentApplicationIdsByReceiverAndStatusAndType(Long receiver,int status,int type)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by receiver,status,type  : " + receiver+" , "+status+" , "+type );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByReceiverAndStatusAndType", new Object[] { receiver,status,type});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by receiver,status,type)  : " + receiver+" , "+status+" , "+type );
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
	public Integer  countCashPaymentApplicationIdsByReceiver(Long receiver)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by receiver  : " + receiver );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByReceiver", new Object[] { receiver});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by receiver)  : " + receiver );
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
	public Integer  countCashPaymentApplicationIdsByStatus(int status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status  : " + status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCashPaymentApplicationIdsByStatus", new Object[] { status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status)  : " + status );
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
	public List<Long> getCashPaymentApplicationIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCashPaymentApplicationIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCashPaymentApplicationIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCashPaymentApplicationIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCashPaymentApplicationIds " ) ;
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

