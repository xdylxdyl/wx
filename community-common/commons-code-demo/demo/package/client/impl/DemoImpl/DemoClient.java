/**
 * 
 */
package demo.package.client.impl;

import java.util.List;

import com.gemantic.convert.service.model.Relation;
import com.gemantic.convert.service.service.RelationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DemoClient implements Relation {

    private RelationService relationService;

	public Relation get$cm.modelClass()() {
		return relationService;
	}
	
	
	public void setRelationService(RelationService relationService) {
		this.relationService =relationService;
	}
	
	
	
   		
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long getGroupIDByUserID(Long userID)throws ServiceException, ServiceDaoException{
	
	         return relationService.getGroupIDByUserID(userID;
	
	   };
    
		

	
			
				
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRelationIdByGroupIDandUserID(Long groupID,Long userID)throws ServiceException, ServiceDaoException{
		
		return relationService.getRelationIdByGroupIDandUserID(groupID,userID;
		
		
		};
		
		
			
 		

	
		
	
	
    
	


 
}

