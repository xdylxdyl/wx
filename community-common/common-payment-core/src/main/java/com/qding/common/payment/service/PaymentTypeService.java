package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PaymentType;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PaymentTypeService extends BaseDaoService {

	



   		   
		
		public Long insert(PaymentType paymentType)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PaymentType> insertList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PaymentType paymentType)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PaymentType getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PaymentType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPaymentTypeIdsByType(int type)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPaymentTypeIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPaymentTypeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPaymentTypeIds() throws ServiceException, ServiceDaoException;
	

}

