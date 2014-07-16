/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.CashPayment;
import com.qding.common.payment.service.CashPaymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CashPaymentSCAClient implements CashPaymentService {

    private CashPaymentService cashPaymentService;

	public CashPaymentService getCashPaymentService() {
		return cashPaymentService;
	}
	
	
	public void setCashPaymentService(CashPaymentService cashPaymentService) {
		this.cashPaymentService =cashPaymentService;
	}
	
	
			   
		@Override
		public Long insert(CashPayment cashPayment)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.insert(cashPayment);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPayment> insertList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.insertList(cashPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CashPayment cashPayment)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.update(cashPayment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPayment> cashPaymentList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.updateList(cashPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public CashPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentIdsByStatusAndReport(int status,int report,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getCashPaymentIdsByStatusAndReport(status,report,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getCashPaymentIdsByPaymentTypeId(paymentTypeId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCashPaymentIdByGorderCode(Long gorderCode)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getCashPaymentIdByGorderCode(gorderCode);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getCashPaymentIdByGorderCodeAndPaymentTypeId(Long gorderCode,Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.getCashPaymentIdByGorderCodeAndPaymentTypeId(gorderCode,paymentTypeId);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentIdsByStatusAndReport(int status,int report)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.countCashPaymentIdsByStatusAndReport(status,report);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		return cashPaymentService.countCashPaymentIdsByPaymentTypeId(paymentTypeId);
	
	
	}
	
		
	
		@Override
	public List<Long> getCashPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentService.getCashPaymentIds(start, limit);
	}

	@Override
	public Integer countCashPaymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentService.countCashPaymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cashPaymentService.deleteList(clz, ids);
		
	}


 
}

