package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PosPaymentLogService extends BaseDaoService {

	



   		   
		
		public Long insert(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentLog> insertList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PosPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPosPaymentLogIdsByPosPaymentId(Long posPaymentId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPosPaymentLogIdsByPosPaymentId(Long posPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPosPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPosPaymentLogIds() throws ServiceException, ServiceDaoException;
	

}

