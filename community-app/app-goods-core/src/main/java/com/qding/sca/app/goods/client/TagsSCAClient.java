/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Tags;
import com.qding.app.goods.service.TagsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsSCAClient implements TagsService {

    private TagsService tagsService;

	public TagsService getTagsService() {
		return tagsService;
	}
	
	
	public void setTagsService(TagsService tagsService) {
		this.tagsService =tagsService;
	}
	
	
			   
		@Override
		public Long insert(Tags tags)throws ServiceException, ServiceDaoException{
		
		return tagsService.insert(tags);
		          
		
		}	
		  
    	   
		@Override
		public List<Tags> insertList(List<Tags> tagsList)throws ServiceException, ServiceDaoException{
		
		return tagsService.insertList(tagsList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Tags tags)throws ServiceException, ServiceDaoException{
		
		return tagsService.update(tags);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Tags> tagsList)throws ServiceException, ServiceDaoException{
		
		return tagsService.updateList(tagsList);
		          
		
		}	
		  
    	   
		@Override
		public Tags getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Tags> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return tagsService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getTagsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsService.getTagsIds(start, limit);
	}

	@Override
	public Integer countTagsIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsService.countTagsIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   tagsService.deleteList(clz, ids);
		
	}


 
}

