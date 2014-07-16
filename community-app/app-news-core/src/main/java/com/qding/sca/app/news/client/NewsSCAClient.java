/**
 * 
 */
package com.qding.sca.app.news.client;

import java.util.List;
import java.util.Map;

import com.qding.app.news.model.News;
import com.qding.app.news.service.NewsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class NewsSCAClient implements NewsService {


    private NewsService newsService;

	public NewsService getNewsService() {
		return newsService;
	}
	
	
	public void setNewsService(NewsService newsService) {
		this.newsService =newsService;
	}
	
	
			   
		@Override
		public Long insert(News news)throws ServiceException, ServiceDaoException{
		
		return newsService.insert(news);
		          
		
		}	
		  
    	   
		@Override
		public List<News> insertList(List<News> newsList)throws ServiceException, ServiceDaoException{
		
		return newsService.insertList(newsList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return newsService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(News news)throws ServiceException, ServiceDaoException{
		
		return newsService.update(news);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<News> newsList)throws ServiceException, ServiceDaoException{
		
		return newsService.updateList(newsList);
		          
		
		}	
		  
    	   
		@Override
		public News getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return newsService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<News> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return newsService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsService.getNewsIdsByPublicsID(publicsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsIdsByPublicsIDAndStatus(Long publicsID,String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsService.getNewsIdsByPublicsIDAndStatus(publicsID,status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countNewsIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return newsService.countNewsIdsByPublicsID(publicsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countNewsIdsByPublicsIDAndStatus(Long publicsID,String status)throws ServiceException, ServiceDaoException{
		
		return newsService.countNewsIdsByPublicsIDAndStatus(publicsID,status);
	
	
	}
	
		
	
		@Override
	public List<Long> getNewsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsService.getNewsIds(start, limit);
	}

	@Override
	public Integer countNewsIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsService.countNewsIds();
	}


 

	
		@Override
		public List<Long> getNewsIdsByCondition(Map<String, Object> conditions,
				Integer start, Integer limit) throws ServiceException,
				ServiceDaoException {
			// TODO Auto-generated method stub
			return newsService.getNewsIdsByCondition(conditions,start, limit);
		}
	
	

 
}

