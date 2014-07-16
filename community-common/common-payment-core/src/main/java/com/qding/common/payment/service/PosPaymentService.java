package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPayment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PosPaymentService extends BaseDaoService {

	



   		   
		
		public Long insert(PosPayment posPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPayment> insertList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PosPayment posPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PosPayment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPosPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPosPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getPosPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPosPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPosPaymentIds() throws ServiceException, ServiceDaoException;
	

}

