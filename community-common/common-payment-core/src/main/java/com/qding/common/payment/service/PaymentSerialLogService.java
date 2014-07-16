package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PaymentSerialLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PaymentSerialLogService extends BaseDaoService {

	



   		   
		
		public Long insert(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PaymentSerialLog> insertList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PaymentSerialLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PaymentSerialLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPaymentSerialLogIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPaymentSerialLogIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPaymentSerialLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPaymentSerialLogIds() throws ServiceException, ServiceDaoException;
	

}

