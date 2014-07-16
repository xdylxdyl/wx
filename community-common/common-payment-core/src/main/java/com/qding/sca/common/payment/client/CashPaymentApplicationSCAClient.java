/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.CashPaymentApplication;
import com.qding.common.payment.service.CashPaymentApplicationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class CashPaymentApplicationSCAClient implements CashPaymentApplicationService {

    private CashPaymentApplicationService cashPaymentApplicationService;

	public CashPaymentApplicationService getCashPaymentApplicationService() {
		return cashPaymentApplicationService;
	}
	
	
	public void setCashPaymentApplicationService(CashPaymentApplicationService cashPaymentApplicationService) {
		this.cashPaymentApplicationService =cashPaymentApplicationService;
	}
	
	
			   
		@Override
		public Long insert(CashPaymentApplication cashPaymentApplication)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.insert(cashPaymentApplication);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentApplication> insertList(List<CashPaymentApplication> cashPaymentApplicationList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.insertList(cashPaymentApplicationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(CashPaymentApplication cashPaymentApplication)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.update(cashPaymentApplication);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<CashPaymentApplication> cashPaymentApplicationList)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.updateList(cashPaymentApplicationList);
		          
		
		}	
		  
    	   
		@Override
		public CashPaymentApplication getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<CashPaymentApplication> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(Long applicants,int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(applicants,type,status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByType(type,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByApplicants(Long applicants,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByApplicants(applicants,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByReceiverAndStatusAndType(Long receiver,int status,int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByReceiverAndStatusAndType(receiver,status,type,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByReceiver(Long receiver,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByReceiver(receiver,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCashPaymentApplicationIdsByStatus(int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.getCashPaymentApplicationIdsByStatus(status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(Long applicants,int type,int status)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByApplicantsAndTypeAndStatus(applicants,type,status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByType(type);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByApplicants(Long applicants)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByApplicants(applicants);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByReceiverAndStatusAndType(Long receiver,int status,int type)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByReceiverAndStatusAndType(receiver,status,type);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByReceiver(Long receiver)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByReceiver(receiver);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCashPaymentApplicationIdsByStatus(int status)throws ServiceException, ServiceDaoException{
		
		return cashPaymentApplicationService.countCashPaymentApplicationIdsByStatus(status);
	
	
	}
	
		
	
		@Override
	public List<Long> getCashPaymentApplicationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentApplicationService.getCashPaymentApplicationIds(start, limit);
	}

	@Override
	public Integer countCashPaymentApplicationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentApplicationService.countCashPaymentApplicationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentApplicationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return cashPaymentApplicationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   cashPaymentApplicationService.deleteList(clz, ids);
		
	}


 
}

