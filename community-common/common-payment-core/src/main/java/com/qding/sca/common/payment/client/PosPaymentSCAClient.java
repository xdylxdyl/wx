/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PosPayment;
import com.qding.common.payment.service.PosPaymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PosPaymentSCAClient implements PosPaymentService {

    private PosPaymentService posPaymentService;

	public PosPaymentService getPosPaymentService() {
		return posPaymentService;
	}
	
	
	public void setPosPaymentService(PosPaymentService posPaymentService) {
		this.posPaymentService =posPaymentService;
	}
	
	
			   
		@Override
		public Long insert(PosPayment posPayment)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.insert(posPayment);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPayment> insertList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.insertList(posPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PosPayment posPayment)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.update(posPayment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPayment> posPaymentList)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.updateList(posPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public PosPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.getPosPaymentIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPosPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.getPosPaymentIdByGorderCodeAndQdCode(gorderCode,qdCode);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPosPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return posPaymentService.countPosPaymentIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getPosPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentService.getPosPaymentIds(start, limit);
	}

	@Override
	public Integer countPosPaymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentService.countPosPaymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   posPaymentService.deleteList(clz, ids);
		
	}


 
}

