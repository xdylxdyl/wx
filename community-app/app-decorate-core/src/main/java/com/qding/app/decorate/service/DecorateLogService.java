package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateLog;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface DecorateLogService extends BaseDaoService {

	



   		   
		
		public Long insert(DecorateLog decorateLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateLog> insertList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DecorateLog decorateLog)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DecorateLog getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDecorateLogIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDecorateLogIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDecorateLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDecorateLogIds() throws ServiceException, ServiceDaoException;
	

}

