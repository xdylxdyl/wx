package com.qding.app.news.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.news.model.News;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface NewsService {


	



	   
	
	public Long insert(News news)throws ServiceException, ServiceDaoException;
	  
	   
	
	public List<News> insertList(List<News> newsList)throws ServiceException, ServiceDaoException;
	  
	   
	
	public boolean delete(Long id)throws ServiceException, ServiceDaoException;
	  
	   
	
	public boolean update(News news)throws ServiceException, ServiceDaoException;
	  
	   
	
	public boolean updateList(List<News> newsList)throws ServiceException, ServiceDaoException;
	  
	   
	
	public News getObjectById(Long id)throws ServiceException, ServiceDaoException;
	  
	   
	
	public List<News> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
	  
	



		
		
/**
 * 
 * @param 
 * @return 
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public Integer  countNewsIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException;
		
		
/**
 * 
 * @param 
 * @return 
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public Integer  countNewsIdsByPublicsIDAndStatus(Long publicsID,String status)throws ServiceException, ServiceDaoException;
				
		
/**
 * 
 * @param 
 * @return 
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public List<Long>  getNewsIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
		
/**
 * 
 * @param 
 * @return 
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public List<Long>  getNewsIdsByPublicsIDAndStatus(Long publicsID,String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
	



/**
 * 
 * @param
 * @return
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public List<Long> getNewsIds(Integer start, Integer limit)
		throws ServiceException, ServiceDaoException;

/**
 * 
 * @param
 * @return
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public Integer countNewsIds() throws ServiceException, ServiceDaoException;



	
/**
 * 
 * @param
 * @return
 * @throws ServiceException
 * @throws ServiceDaoException
 */
public List<Long> getNewsIdsByCondition(Map<String, Object> conditions,
		Integer start, Integer limit) throws ServiceException,
		ServiceDaoException;




}

