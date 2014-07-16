package com.qding.app.goods.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.GorderGoodsRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.qding.common.dao.base.service.BaseDaoService;

@Remotable
public interface GorderGoodsRelationService extends BaseDaoService {

	



   		   
		
		public Long insert(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GorderGoodsRelation> insertList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(GorderGoodsRelation gorderGoodsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<GorderGoodsRelation> gorderGoodsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public GorderGoodsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<GorderGoodsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGorderGoodsRelationIdsByGoodsID(Long goodsID)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countGorderGoodsRelationIdsByGorderID(Long gorderID)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGorderGoodsRelationIdsByGoodsID(Long goodsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getGorderGoodsRelationIdsByGorderID(Long gorderID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getGorderGoodsRelationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countGorderGoodsRelationIds() throws ServiceException, ServiceDaoException;
	

}

