/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.TagsPublicsRelation;
import com.qding.app.goods.service.TagsPublicsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsPublicsRelationSCAClient implements TagsPublicsRelationService {

    private TagsPublicsRelationService tagsPublicsRelationService;

	public TagsPublicsRelationService getTagsPublicsRelationService() {
		return tagsPublicsRelationService;
	}
	
	
	public void setTagsPublicsRelationService(TagsPublicsRelationService tagsPublicsRelationService) {
		this.tagsPublicsRelationService =tagsPublicsRelationService;
	}
	
	
			   
		@Override
		public Long insert(TagsPublicsRelation tagsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.insert(tagsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<TagsPublicsRelation> insertList(List<TagsPublicsRelation> tagsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.insertList(tagsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(TagsPublicsRelation tagsPublicsRelation)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.update(tagsPublicsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<TagsPublicsRelation> tagsPublicsRelationList)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.updateList(tagsPublicsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public TagsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<TagsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsPublicsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.getTagsPublicsRelationIdsByPublicsID(publicsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsPublicsRelationIdsByTagsID(Long tagsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.getTagsPublicsRelationIdsByTagsID(tagsID,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTagsPublicsRelationIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.countTagsPublicsRelationIdsByPublicsID(publicsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTagsPublicsRelationIdsByTagsID(Long tagsID)throws ServiceException, ServiceDaoException{
		
		return tagsPublicsRelationService.countTagsPublicsRelationIdsByTagsID(tagsID);
	
	
	}
	
		
	
		@Override
	public List<Long> getTagsPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsPublicsRelationService.getTagsPublicsRelationIds(start, limit);
	}

	@Override
	public Integer countTagsPublicsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsPublicsRelationService.countTagsPublicsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsPublicsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsPublicsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   tagsPublicsRelationService.deleteList(clz, ids);
		
	}


 
}

