package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.GoodsPublicsRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface GoodsPublicsRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GoodsPublicsRelation> insertList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(GoodsPublicsRelation goodsPublicsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<GoodsPublicsRelation> goodsPublicsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public GoodsPublicsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GoodsPublicsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGoodsPublicsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGoodsIDsByPublicsIDAndCategoryIDAndStatus(Long publicsID,Long categoryID,int status)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGoodsPublicsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGoodsIDsByPublicsIDAndCategoryIDAndStatus(Long publicsID,Long categoryID,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getGoodsPublicsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countGoodsPublicsRelationIds() throws ServiceException, ServiceDaoException;
	

}

