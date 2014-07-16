package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.UnionPaymentLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface UnionPaymentLogService extends BaseDaoService {

	



   		   
		
		public Long insert(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UnionPaymentLog> insertList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UnionPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UnionPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUnionPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUnionPaymentLogIds() throws ServiceException, ServiceDaoException;
	

}

