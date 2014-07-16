/**
 * 
 */
package com.qding.sca.app.news.client;

import java.util.List;
import java.util.Map;

import com.qding.app.news.model.NewsPublicsRelation;
import com.qding.app.news.service.NewsPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class NewsPublicsRelationSCAClient implements NewsPublicsRelationService {

    private NewsPublicsRelationService newsPublicsRelationService;

	public NewsPublicsRelationService getNewsPublicsRelationService() {
		return newsPublicsRelationService;
	}
	
	
	public void setNewsPublicsRelationService(NewsPublicsRelationService newsPublicsRelationService) {
		this.newsPublicsRelationService =newsPublicsRelationService;
	}
	
	
			   
		@Override
		public Long insert(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.insert(newsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<NewsPublicsRelation> insertList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.insertList(newsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(NewsPublicsRelation newsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.update(newsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<NewsPublicsRelation> newsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.updateList(newsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public NewsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<NewsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPublicsIDsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getPublicsIDsByNewsID(newsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsPublicsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getNewsPublicsRelationIdsByPublicsID(publicsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsPublicsRelationIdsByNewsID(Long newsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getNewsPublicsRelationIdsByNewsID(newsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getNewsIDsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.getNewsIDsByPublicsID(publicsID,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPublicsIDsByNewsID(Long newsID)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.countPublicsIDsByNewsID(newsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countNewsPublicsRelationIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.countNewsPublicsRelationIdsByPublicsID(publicsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countNewsPublicsRelationIdsByNewsID(Long newsID)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.countNewsPublicsRelationIdsByNewsID(newsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countNewsIDsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return newsPublicsRelationService.countNewsIDsByPublicsID(publicsID);
	
	
	}
	
		
	
		@Override
	public List<Long> getNewsPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsPublicsRelationService.getNewsPublicsRelationIds(start, limit);
	}

	@Override
	public Integer countNewsPublicsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsPublicsRelationService.countNewsPublicsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsPublicsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return newsPublicsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   newsPublicsRelationService.deleteList(clz, ids);
		
	}


 
}

