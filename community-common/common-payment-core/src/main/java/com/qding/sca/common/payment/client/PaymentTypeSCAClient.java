/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PaymentType;
import com.qding.common.payment.service.PaymentTypeService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PaymentTypeSCAClient implements PaymentTypeService {

    private PaymentTypeService paymentTypeService;

	public PaymentTypeService getPaymentTypeService() {
		return paymentTypeService;
	}
	
	
	public void setPaymentTypeService(PaymentTypeService paymentTypeService) {
		this.paymentTypeService =paymentTypeService;
	}
	
	
			   
		@Override
		public Long insert(PaymentType paymentType)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.insert(paymentType);
		          
		
		}	
		  
    	   
		@Override
		public List<PaymentType> insertList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.insertList(paymentTypeList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PaymentType paymentType)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.update(paymentType);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PaymentType> paymentTypeList)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.updateList(paymentTypeList);
		          
		
		}	
		  
    	   
		@Override
		public PaymentType getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PaymentType> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPaymentTypeIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.getPaymentTypeIdsByType(type,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPaymentTypeIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		return paymentTypeService.countPaymentTypeIdsByType(type);
	
	
	}
	
		
	
		@Override
	public List<Long> getPaymentTypeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentTypeService.getPaymentTypeIds(start, limit);
	}

	@Override
	public Integer countPaymentTypeIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentTypeService.countPaymentTypeIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentTypeService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return paymentTypeService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   paymentTypeService.deleteList(clz, ids);
		
	}


 
}

