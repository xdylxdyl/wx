/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PosPaymentReconciliation;
import com.qding.common.payment.service.PosPaymentReconciliationService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PosPaymentReconciliationSCAClient implements PosPaymentReconciliationService {

    private PosPaymentReconciliationService posPaymentReconciliationService;

	public PosPaymentReconciliationService getPosPaymentReconciliationService() {
		return posPaymentReconciliationService;
	}
	
	
	public void setPosPaymentReconciliationService(PosPaymentReconciliationService posPaymentReconciliationService) {
		this.posPaymentReconciliationService =posPaymentReconciliationService;
	}
	
	
			   
		@Override
		public Long insert(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.insert(posPaymentReconciliation);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentReconciliation> insertList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.insertList(posPaymentReconciliationList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PosPaymentReconciliation posPaymentReconciliation)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.update(posPaymentReconciliation);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentReconciliation> posPaymentReconciliationList)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.updateList(posPaymentReconciliationList);
		          
		
		}	
		  
    	   
		@Override
		public PosPaymentReconciliation getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentReconciliation> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getPosPaymentReconciliationIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.getPosPaymentReconciliationIdByGorderCodeAndQdCode(gorderCode,qdCode);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentReconciliationIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.getPosPaymentReconciliationIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPosPaymentReconciliationIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return posPaymentReconciliationService.countPosPaymentReconciliationIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getPosPaymentReconciliationIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentReconciliationService.getPosPaymentReconciliationIds(start, limit);
	}

	@Override
	public Integer countPosPaymentReconciliationIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentReconciliationService.countPosPaymentReconciliationIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentReconciliationService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentReconciliationService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   posPaymentReconciliationService.deleteList(clz, ids);
		
	}


 
}

