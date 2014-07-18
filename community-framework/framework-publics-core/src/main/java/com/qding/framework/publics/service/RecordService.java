package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.framework.publics.model.Record;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface RecordService extends BaseDaoService {

	



   		   
		
		public Long insert(Record record)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Record> insertList(List<Record> recordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Record record)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Record> recordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Record getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Record> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countRecordIdsByObjectIDAndModule(Long objectID,String module)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRecordIdsByObjectIDAndModule(Long objectID,String module,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countRecordIds() throws ServiceException, ServiceDaoException;
	

}

