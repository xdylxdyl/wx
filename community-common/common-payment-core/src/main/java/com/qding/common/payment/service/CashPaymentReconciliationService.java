package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPaymentReconciliation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface CashPaymentReconciliationService extends BaseDaoService {

	



   		   
		
		public Long insert(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPaymentReconciliation> insertList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public CashPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentReconciliationIdsByStatusAndType(int status,int type)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentReconciliationIdsByType(int type)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentReconciliationIdsByStatusAndType(int status,int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getCashPaymentReconciliationIdByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentReconciliationIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCashPaymentReconciliationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCashPaymentReconciliationIds() throws ServiceException, ServiceDaoException;
	

}

