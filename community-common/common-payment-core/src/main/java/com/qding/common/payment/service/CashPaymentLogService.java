package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPaymentLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface CashPaymentLogService extends BaseDaoService {

	



   		   
		
		public Long insert(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPaymentLog> insertList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public CashPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentLogIdsByCashPaymentId(Long cashPaymentId)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentLogIdsByStatus(String status)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentLogIdsByCashPaymentId(Long cashPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentLogIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCashPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCashPaymentLogIds() throws ServiceException, ServiceDaoException;
	

}

