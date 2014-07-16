package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.GorderFees;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface GorderFeesService extends BaseDaoService {

	



   		   
		
		public Long insert(GorderFees gorderFees)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GorderFees> insertList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(GorderFees gorderFees)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public GorderFees getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GorderFees> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGorderFeesIdsByTypeAndStatus(int type,int status)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getGorderFeesIdByGorderCodeAndType(String gorderCode,int type)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGorderFeesIdsByTypeAndStatus(int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getGorderFeesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countGorderFeesIds() throws ServiceException, ServiceDaoException;
	

}

