/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PaymentSerialLog;
import com.qding.common.payment.service.PaymentSerialLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PaymentSerialLogSCAClient implements PaymentSerialLogService {

    private PaymentSerialLogService paymentSerialLogService;

	public PaymentSerialLogService getPaymentSerialLogService() {
		return paymentSerialLogService;
	}
	
	
	public void setPaymentSerialLogService(PaymentSerialLogService paymentSerialLogService) {
		this.paymentSerialLogService =paymentSerialLogService;
	}
	
	
			   
		@Override
		public Long insert(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.insert(paymentSerialLog);
		          
		
		}	
		  
    	   
		@Override
		public List<PaymentSerialLog> insertList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.insertList(paymentSerialLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PaymentSerialLog paymentSerialLog)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.update(paymentSerialLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PaymentSerialLog> paymentSerialLogList)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.updateList(paymentSerialLogList);
		          
		
		}	
		  
    	   
		@Override
		public PaymentSerialLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PaymentSerialLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.getPaymentSerialLogIdsByGorderCodeAndTrantype(gorderCode,trantype,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.getPaymentSerialLogIdsByPaymentTypeId(paymentTypeId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentSerialLogIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.getPaymentSerialLogIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPaymentSerialLogIdsByGorderCodeAndTrantype(String gorderCode,String trantype)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.countPaymentSerialLogIdsByGorderCodeAndTrantype(gorderCode,trantype);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPaymentSerialLogIdsByPaymentTypeId(Long paymentTypeId)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.countPaymentSerialLogIdsByPaymentTypeId(paymentTypeId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPaymentSerialLogIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return paymentSerialLogService.countPaymentSerialLogIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getPaymentSerialLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentSerialLogService.getPaymentSerialLogIds(start, limit);
	}

	@Override
	public Integer countPaymentSerialLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentSerialLogService.countPaymentSerialLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentSerialLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentSerialLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   paymentSerialLogService.deleteList(clz, ids);
		
	}


 
}

