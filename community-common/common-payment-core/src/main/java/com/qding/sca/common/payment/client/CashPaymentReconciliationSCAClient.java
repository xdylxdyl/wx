/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.CashPaymentReconciliation;
import com.qding.common.payment.service.CashPaymentReconciliationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CashPaymentReconciliationSCAClient implements CashPaymentReconciliationService {

    private CashPaymentReconciliationService cashPaymentReconciliationService;

	public CashPaymentReconciliationService getCashPaymentReconciliationService() {
		return cashPaymentReconciliationService;
	}
	
	
	public void setCashPaymentReconciliationService(CashPaymentReconciliationService cashPaymentReconciliationService) {
		this.cashPaymentReconciliationService =cashPaymentReconciliationService;
	}
	
	
			   
		@Override
		public Long insert(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.insert(cashPaymentReconciliation);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentReconciliation> insertList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.insertList(cashPaymentReconciliationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CashPaymentReconciliation cashPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.update(cashPaymentReconciliation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentReconciliation> cashPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.updateList(cashPaymentReconciliationList);
		          
		
		}	
		  
    	   
		@Override
		public CashPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentReconciliationIdsByStatusAndType(int status,int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.getCashPaymentReconciliationIdsByStatusAndType(status,type,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCashPaymentReconciliationIdByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.getCashPaymentReconciliationIdByGorderCode(gorderCode);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentReconciliationIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.getCashPaymentReconciliationIdsByType(type,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentReconciliationIdsByStatusAndType(int status,int type)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.countCashPaymentReconciliationIdsByStatusAndType(status,type);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentReconciliationIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		return cashPaymentReconciliationService.countCashPaymentReconciliationIdsByType(type);
	
	
	}
	
		
	
		@Override
	public List<Long> getCashPaymentReconciliationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentReconciliationService.getCashPaymentReconciliationIds(start, limit);
	}

	@Override
	public Integer countCashPaymentReconciliationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentReconciliationService.countCashPaymentReconciliationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentReconciliationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentReconciliationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cashPaymentReconciliationService.deleteList(clz, ids);
		
	}


 
}

