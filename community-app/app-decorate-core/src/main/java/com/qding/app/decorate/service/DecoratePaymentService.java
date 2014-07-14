package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecoratePayment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface DecoratePaymentService extends BaseDaoService {

	



   		   
		
		public Long insert(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecoratePayment> insertList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DecoratePayment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecoratePayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDecoratePaymentIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDecoratePaymentIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDecoratePaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDecoratePaymentIds() throws ServiceException, ServiceDaoException;
	

}

