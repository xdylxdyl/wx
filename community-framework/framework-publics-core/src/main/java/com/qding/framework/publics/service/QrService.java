package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.Qr;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface QrService  extends BaseDaoService  {

	



   		   
		
		public Long insert(Qr qr)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Qr> insertList(List<Qr> qrList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Qr qr)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Qr> qrList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Qr getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Qr> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countQrIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getQrIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getQrIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countQrIds() throws ServiceException, ServiceDaoException;
	

}

