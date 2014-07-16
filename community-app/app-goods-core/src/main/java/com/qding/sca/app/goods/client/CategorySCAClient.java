/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Category;
import com.qding.app.goods.service.CategoryService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CategorySCAClient implements CategoryService {

    private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}
	
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService =categoryService;
	}
	
	
			   
		@Override
		public Long insert(Category category)throws ServiceException, ServiceDaoException{
		
		return categoryService.insert(category);
		          
		
		}	
		  
    	   
		@Override
		public List<Category> insertList(List<Category> categoryList)throws ServiceException, ServiceDaoException{
		
		return categoryService.insertList(categoryList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return categoryService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Category category)throws ServiceException, ServiceDaoException{
		
		return categoryService.update(category);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Category> categoryList)throws ServiceException, ServiceDaoException{
		
		return categoryService.updateList(categoryList);
		          
		
		}	
		  
    	   
		@Override
		public Category getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return categoryService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Category> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return categoryService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCategoryIdsByStatus(int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return categoryService.getCategoryIdsByStatus(status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCategoryIdByName(String name)throws ServiceException, ServiceDaoException{
		
		return categoryService.getCategoryIdByName(name);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCategoryIdsByStatus(int status)throws ServiceException, ServiceDaoException{
		
		return categoryService.countCategoryIdsByStatus(status);
	
	
	}
	
		
	
		@Override
	public List<Long> getCategoryIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return categoryService.getCategoryIds(start, limit);
	}

	@Override
	public Integer countCategoryIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return categoryService.countCategoryIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return categoryService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return categoryService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   categoryService.deleteList(clz, ids);
		
	}


 
}

