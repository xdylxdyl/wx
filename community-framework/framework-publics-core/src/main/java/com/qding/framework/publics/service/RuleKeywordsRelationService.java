package com.qding.framework.publics.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.common.dao.base.service.BaseDaoService;
import com.qding.framework.publics.model.RuleKeywordsRelation;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

@Remotable
public interface RuleKeywordsRelationService  extends BaseDaoService  {

	



   		   
		
		public Long insert(RuleKeywordsRelation ruleKeywordsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RuleKeywordsRelation> insertList(List<RuleKeywordsRelation> ruleKeywordsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(RuleKeywordsRelation ruleKeywordsRelation)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<RuleKeywordsRelation> ruleKeywordsRelationList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public RuleKeywordsRelation getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<RuleKeywordsRelation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	

			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRuleKeywordsRelationIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getRuleKeywordsRelationRidByPublicsIDAndKeywords(Long publicsID,String keywords)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRuleKeywordsRelationIdsByPublicsIDAndRid(Long publicsID,Long rid,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	

}

