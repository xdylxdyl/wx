/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.GorderFees;
import com.qding.common.payment.service.GorderFeesService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GorderFeesSCAClient implements GorderFeesService {

    private GorderFeesService gorderFeesService;

	public GorderFeesService getGorderFeesService() {
		return gorderFeesService;
	}
	
	
	public void setGorderFeesService(GorderFeesService gorderFeesService) {
		this.gorderFeesService =gorderFeesService;
	}
	
	
			   
		@Override
		public Long insert(GorderFees gorderFees)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.insert(gorderFees);
		          
		
		}	
		  
    	   
		@Override
		public List<GorderFees> insertList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.insertList(gorderFeesList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(GorderFees gorderFees)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.update(gorderFees);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<GorderFees> gorderFeesList)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.updateList(gorderFeesList);
		          
		
		}	
		  
    	   
		@Override
		public GorderFees getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<GorderFees> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getGorderFeesIdByGorderCodeAndType(String gorderCode,int type)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.getGorderFeesIdByGorderCodeAndType(gorderCode,type);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderFeesIdsByTypeAndStatus(int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.getGorderFeesIdsByTypeAndStatus(type,status,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.getGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(paymentTypeId,type,status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGorderFeesIdsByTypeAndStatus(int type,int status)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.countGorderFeesIdsByTypeAndStatus(type,status);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(Long paymentTypeId,int type,int status)throws ServiceException, ServiceDaoException{
		
		return gorderFeesService.countGorderFeesIdsByPaymentTypeIdAndTypeAndStatus(paymentTypeId,type,status);
	
	
	}
	
		
	
		@Override
	public List<Long> getGorderFeesIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderFeesService.getGorderFeesIds(start, limit);
	}

	@Override
	public Integer countGorderFeesIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderFeesService.countGorderFeesIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderFeesService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderFeesService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   gorderFeesService.deleteList(clz, ids);
		
	}


 
}

