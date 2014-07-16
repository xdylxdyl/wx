/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.CashPaymentLog;
import com.qding.common.payment.service.CashPaymentLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CashPaymentLogSCAClient implements CashPaymentLogService {

    private CashPaymentLogService cashPaymentLogService;

	public CashPaymentLogService getCashPaymentLogService() {
		return cashPaymentLogService;
	}
	
	
	public void setCashPaymentLogService(CashPaymentLogService cashPaymentLogService) {
		this.cashPaymentLogService =cashPaymentLogService;
	}
	
	
			   
		@Override
		public Long insert(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.insert(cashPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentLog> insertList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.insertList(cashPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CashPaymentLog cashPaymentLog)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.update(cashPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentLog> cashPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.updateList(cashPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public CashPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentLogIdsByCashPaymentId(Long cashPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.getCashPaymentLogIdsByCashPaymentId(cashPaymentId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentLogIdsByStatus(String status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.getCashPaymentLogIdsByStatus(status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentLogIdsByCashPaymentId(Long cashPaymentId)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.countCashPaymentLogIdsByCashPaymentId(cashPaymentId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentLogIdsByStatus(String status)throws ServiceException, ServiceDaoException{
		
		return cashPaymentLogService.countCashPaymentLogIdsByStatus(status);
	
	
	}
	
		
	
		@Override
	public List<Long> getCashPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentLogService.getCashPaymentLogIds(start, limit);
	}

	@Override
	public Integer countCashPaymentLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentLogService.countCashPaymentLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cashPaymentLogService.deleteList(clz, ids);
		
	}


 
}

