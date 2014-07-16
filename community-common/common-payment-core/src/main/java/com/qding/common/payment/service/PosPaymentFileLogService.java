package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.PosPaymentFileLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface PosPaymentFileLogService extends BaseDaoService {

	



   		   
		
		public Long insert(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentFileLog> insertList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public PosPaymentFileLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<PosPaymentFileLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countPosPaymentFileLogIdsByType(int type)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getPosPaymentFileLogIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getPosPaymentFileLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countPosPaymentFileLogIds() throws ServiceException, ServiceDaoException;
	

}

