/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.UnionPaymentLog;
import com.qding.common.payment.service.UnionPaymentLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class UnionPaymentLogSCAClient implements UnionPaymentLogService {

    private UnionPaymentLogService unionPaymentLogService;

	public UnionPaymentLogService getUnionPaymentLogService() {
		return unionPaymentLogService;
	}
	
	
	public void setUnionPaymentLogService(UnionPaymentLogService unionPaymentLogService) {
		this.unionPaymentLogService =unionPaymentLogService;
	}
	
	
			   
		@Override
		public Long insert(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.insert(unionPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public List<UnionPaymentLog> insertList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.insertList(unionPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UnionPaymentLog unionPaymentLog)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.update(unionPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UnionPaymentLog> unionPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.updateList(unionPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public UnionPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UnionPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.getUnionPaymentLogIdsByUnionPaymentId(unionPaymentId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countUnionPaymentLogIdsByUnionPaymentId(Long unionPaymentId)throws ServiceException, ServiceDaoException{
		
		return unionPaymentLogService.countUnionPaymentLogIdsByUnionPaymentId(unionPaymentId);
	
	
	}
	
		
	
		@Override
	public List<Long> getUnionPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentLogService.getUnionPaymentLogIds(start, limit);
	}

	@Override
	public Integer countUnionPaymentLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentLogService.countUnionPaymentLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   unionPaymentLogService.deleteList(clz, ids);
		
	}


 
}

