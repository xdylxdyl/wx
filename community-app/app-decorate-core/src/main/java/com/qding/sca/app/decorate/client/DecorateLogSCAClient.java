/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.DecorateLog;
import com.qding.app.decorate.service.DecorateLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecorateLogSCAClient implements DecorateLogService {

    private DecorateLogService decorateLogService;

	public DecorateLogService getDecorateLogService() {
		return decorateLogService;
	}
	
	
	public void setDecorateLogService(DecorateLogService decorateLogService) {
		this.decorateLogService =decorateLogService;
	}
	
	
			   
		@Override
		public Long insert(DecorateLog decorateLog)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.insert(decorateLog);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateLog> insertList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.insertList(decorateLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DecorateLog decorateLog)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.update(decorateLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecorateLog> decorateLogList)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.updateList(decorateLogList);
		          
		
		}	
		  
    	   
		@Override
		public DecorateLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DecorateLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateLogIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.getDecorateLogIdsByDecorateId(decorateId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateLogIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException{
		
		return decorateLogService.countDecorateLogIdsByDecorateId(decorateId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecorateLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateLogService.getDecorateLogIds(start, limit);
	}

	@Override
	public Integer countDecorateLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateLogService.countDecorateLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decorateLogService.deleteList(clz, ids);
		
	}


 
}

