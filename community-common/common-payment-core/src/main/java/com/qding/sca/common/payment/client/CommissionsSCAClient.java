/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.Commissions;
import com.qding.common.payment.service.CommissionsService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CommissionsSCAClient implements CommissionsService {

    private CommissionsService commissionsService;

	public CommissionsService getCommissionsService() {
		return commissionsService;
	}
	
	
	public void setCommissionsService(CommissionsService commissionsService) {
		this.commissionsService =commissionsService;
	}
	
	
			   
		@Override
		public Long insert(Commissions commissions)throws ServiceException, ServiceDaoException{
		
		return commissionsService.insert(commissions);
		          
		
		}	
		  
    	   
		@Override
		public List<Commissions> insertList(List<Commissions> commissionsList)throws ServiceException, ServiceDaoException{
		
		return commissionsService.insertList(commissionsList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return commissionsService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Commissions commissions)throws ServiceException, ServiceDaoException{
		
		return commissionsService.update(commissions);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Commissions> commissionsList)throws ServiceException, ServiceDaoException{
		
		return commissionsService.updateList(commissionsList);
		          
		
		}	
		  
    	   
		@Override
		public Commissions getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return commissionsService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Commissions> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return commissionsService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCommissionsIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return commissionsService.getCommissionsIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCommissionsIdByGorderCodeAndType(String gorderCode,int type)throws ServiceException, ServiceDaoException{
		
		return commissionsService.getCommissionsIdByGorderCodeAndType(gorderCode,type);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCommissionsIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return commissionsService.countCommissionsIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getCommissionsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commissionsService.getCommissionsIds(start, limit);
	}

	@Override
	public Integer countCommissionsIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commissionsService.countCommissionsIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commissionsService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commissionsService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   commissionsService.deleteList(clz, ids);
		
	}


 
}

