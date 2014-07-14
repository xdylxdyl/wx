package com.qding.app.decorate.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.decorate.model.DecorateVenderUser;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface DecorateVenderUserService extends BaseDaoService {

	



   		   
		
		public Long insert(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateVenderUser> insertList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DecorateVenderUser decorateVenderUser)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DecorateVenderUser> decorateVenderUserList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DecorateVenderUser getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DecorateVenderUser> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDecorateVenderUserIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDecorateVenderUserIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDecorateVenderUserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDecorateVenderUserIds() throws ServiceException, ServiceDaoException;
	

}

