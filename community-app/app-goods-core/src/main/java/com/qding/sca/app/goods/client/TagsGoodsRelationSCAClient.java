/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.TagsGoodsRelation;
import com.qding.app.goods.service.TagsGoodsRelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TagsGoodsRelationSCAClient implements TagsGoodsRelationService {

    private TagsGoodsRelationService tagsGoodsRelationService;

	public TagsGoodsRelationService getTagsGoodsRelationService() {
		return tagsGoodsRelationService;
	}
	
	
	public void setTagsGoodsRelationService(TagsGoodsRelationService tagsGoodsRelationService) {
		this.tagsGoodsRelationService =tagsGoodsRelationService;
	}
	
	
			   
		@Override
		public Long insert(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.insert(tagsGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public List<TagsGoodsRelation> insertList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.insertList(tagsGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.update(tagsGoodsRelation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.updateList(tagsGoodsRelationList);
		          
		
		}	
		  
    	   
		@Override
		public TagsGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<TagsGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.getTagsIDsByGoodsIDAndPublicsID(goodsID,publicsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.getTagsGoodsRelationIdsByGoodsID(goodsID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(tagsID,publicsID,status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.countTagsIDsByGoodsIDAndPublicsID(goodsID,publicsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTagsGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.countTagsGoodsRelationIdsByGoodsID(goodsID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status)throws ServiceException, ServiceDaoException{
		
		return tagsGoodsRelationService.countTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(tagsID,publicsID,status);
	
	
	}
	
		
	
		@Override
	public List<Long> getTagsGoodsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsGoodsRelationService.getTagsGoodsRelationIds(start, limit);
	}

	@Override
	public Integer countTagsGoodsRelationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsGoodsRelationService.countTagsGoodsRelationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsGoodsRelationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tagsGoodsRelationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   tagsGoodsRelationService.deleteList(clz, ids);
		
	}


 
}

