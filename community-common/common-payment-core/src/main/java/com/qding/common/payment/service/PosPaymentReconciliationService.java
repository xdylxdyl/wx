package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentReconciliation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PosPaymentReconciliationService extends BaseDaoService {

	



   		   
		
		public Long insert(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentReconciliation> insertList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PosPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPosPaymentReconciliationIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getPosPaymentReconciliationIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPosPaymentReconciliationIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPosPaymentReconciliationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPosPaymentReconciliationIds() throws ServiceException, ServiceDaoException;
	

}

