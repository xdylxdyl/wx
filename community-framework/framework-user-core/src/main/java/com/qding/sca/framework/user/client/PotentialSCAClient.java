/**
 * 
 */
package com.qding.sca.framework.user.client;

import java.util.List;
import java.util.Map;

import com.qding.framework.user.model.Potential;
import com.qding.framework.user.service.PotentialService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PotentialSCAClient implements PotentialService {

    private PotentialService potentialService;

	public PotentialService getPotentialService() {
		return potentialService;
	}
	
	
	public void setPotentialService(PotentialService potentialService) {
		this.potentialService =potentialService;
	}
	
	
			   
		@Override
		public Long insert(Potential potential)throws ServiceException, ServiceDaoException{
		
		return potentialService.insert(potential);
		          
		
		}	
		  
    	   
		@Override
		public List<Potential> insertList(List<Potential> potentialList)throws ServiceException, ServiceDaoException{
		
		return potentialService.insertList(potentialList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return potentialService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Potential potential)throws ServiceException, ServiceDaoException{
		
		return potentialService.update(potential);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Potential> potentialList)throws ServiceException, ServiceDaoException{
		
		return potentialService.updateList(potentialList);
		          
		
		}	
		  
    	   
		@Override
		public Potential getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return potentialService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Potential> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return potentialService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPotentialIdsByFakeID(String fakeID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return potentialService.getPotentialIdsByFakeID(fakeID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPotentialIdByOpenID(String openID)throws ServiceException, ServiceDaoException{
		
		return potentialService.getPotentialIdByOpenID(openID);
	
	
	}


		@Override
		public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start,
				Integer limit) throws ServiceException, ServiceDaoException {
			// TODO Auto-generated method stub
			return this.potentialService.getIdsByDynamicCondition(clz, conditions, start, limit);
		}


		@Override
		public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
			// TODO Auto-generated method stub
			return this.potentialService.fakeDelete(clz, id);
		}


		@Override
		public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
			// TODO Auto-generated method stub
			this.potentialService.deleteList(clz, ids);
		}
	
		
	
	
    
	


 
}

