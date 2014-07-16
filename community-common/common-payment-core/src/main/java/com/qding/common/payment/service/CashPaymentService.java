package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.CashPayment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface CashPaymentService extends BaseDaoService {

	



   		   
		
		public Long insert(CashPayment cashPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPayment> insertList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(CashPayment cashPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public CashPayment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<CashPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentIdsByStatusAndReport(int status,int report)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countCashPaymentIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentIdsByStatusAndReport(int status,int report,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getCashPaymentIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getCashPaymentIdByGorderCode(Long gorderCode)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getCashPaymentIdByGorderCodeAndPaymentTypeId(Long gorderCode,Long paymentTypeId)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCashPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCashPaymentIds() throws ServiceException, ServiceDaoException;
	

}

