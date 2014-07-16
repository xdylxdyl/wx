package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.TagsGoodsRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface TagsGoodsRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<TagsGoodsRelation> insertList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(TagsGoodsRelation tagsGoodsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<TagsGoodsRelation> tagsGoodsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public TagsGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<TagsGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTagsGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTagsIDsByGoodsIDAndPublicsID(Long goodsID,Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTagsGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTagsGoodsRelationIdsByTagsIDAndPublicsIDAndStatus(Long tagsID,Long publicsID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTagsGoodsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTagsGoodsRelationIds() throws ServiceException, ServiceDaoException;
	

}

