/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.Images;
import com.qding.app.decorate.service.ImagesService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ImagesSCAClient implements ImagesService {

    private ImagesService imagesService;

	public ImagesService getImagesService() {
		return imagesService;
	}
	
	
	public void setImagesService(ImagesService imagesService) {
		this.imagesService =imagesService;
	}
	
	
			   
		@Override
		public Long insert(Images images)throws ServiceException, ServiceDaoException{
		
		return imagesService.insert(images);
		          
		
		}	
		  
    	   
		@Override
		public List<Images> insertList(List<Images> imagesList)throws ServiceException, ServiceDaoException{
		
		return imagesService.insertList(imagesList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return imagesService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Images images)throws ServiceException, ServiceDaoException{
		
		return imagesService.update(images);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Images> imagesList)throws ServiceException, ServiceDaoException{
		
		return imagesService.updateList(imagesList);
		          
		
		}	
		  
    	   
		@Override
		public Images getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return imagesService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Images> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return imagesService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getImagesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return imagesService.getImagesIds(start, limit);
	}

	@Override
	public Integer countImagesIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return imagesService.countImagesIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return imagesService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return imagesService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   imagesService.deleteList(clz, ids);
		
	}


 
}

