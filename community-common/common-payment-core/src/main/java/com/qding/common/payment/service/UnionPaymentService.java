package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.UnionPayment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface UnionPaymentService extends BaseDaoService {

	



   		   
		
		public Long insert(UnionPayment unionPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UnionPayment> insertList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UnionPayment unionPayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UnionPayment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UnionPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countUnionPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getUnionPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getUnionPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUnionPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUnionPaymentIds() throws ServiceException, ServiceDaoException;
	

}

