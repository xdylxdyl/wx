package com.qding.common.payment.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.payment.model.Refund;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface RefundService extends BaseDaoService {

	



   		   
		
		public Long insert(Refund refund)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Refund> insertList(List<Refund> refundList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Refund refund)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Refund> refundList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Refund getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Refund> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countRefundIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRefundIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getRefundIdByGorderCodeAndGoodsId(String gorderCode,Long goodsId)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRefundIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countRefundIds() throws ServiceException, ServiceDaoException;
	

}

