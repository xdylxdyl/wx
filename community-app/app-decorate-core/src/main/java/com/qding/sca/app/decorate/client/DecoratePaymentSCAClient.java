/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.DecoratePayment;
import com.qding.app.decorate.service.DecoratePaymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecoratePaymentSCAClient implements DecoratePaymentService {

    private DecoratePaymentService decoratePaymentService;

	public DecoratePaymentService getDecoratePaymentService() {
		return decoratePaymentService;
	}
	
	
	public void setDecoratePaymentService(DecoratePaymentService decoratePaymentService) {
		this.decoratePaymentService =decoratePaymentService;
	}
	
	
			   
		@Override
		public Long insert(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.insert(decoratePayment);
		          
		
		}	
		  
    	   
		@Override
		public List<DecoratePayment> insertList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.insertList(decoratePaymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DecoratePayment decoratePayment)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.update(decoratePayment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DecoratePayment> decoratePaymentList)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.updateList(decoratePaymentList);
		          
		
		}	
		  
    	   
		@Override
		public DecoratePayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DecoratePayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecoratePaymentIdsByDecorateId(Long decorateId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.getDecoratePaymentIdsByDecorateId(decorateId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecoratePaymentIdsByDecorateId(Long decorateId)throws ServiceException, ServiceDaoException{
		
		return decoratePaymentService.countDecoratePaymentIdsByDecorateId(decorateId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecoratePaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decoratePaymentService.getDecoratePaymentIds(start, limit);
	}

	@Override
	public Integer countDecoratePaymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decoratePaymentService.countDecoratePaymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decoratePaymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decoratePaymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decoratePaymentService.deleteList(clz, ids);
		
	}


 
}

