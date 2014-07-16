/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PosPaymentLog;
import com.qding.common.payment.service.PosPaymentLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PosPaymentLogSCAClient implements PosPaymentLogService {

    private PosPaymentLogService posPaymentLogService;

	public PosPaymentLogService getPosPaymentLogService() {
		return posPaymentLogService;
	}
	
	
	public void setPosPaymentLogService(PosPaymentLogService posPaymentLogService) {
		this.posPaymentLogService =posPaymentLogService;
	}
	
	
			   
		@Override
		public Long insert(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.insert(posPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentLog> insertList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.insertList(posPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PosPaymentLog posPaymentLog)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.update(posPaymentLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentLog> posPaymentLogList)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.updateList(posPaymentLogList);
		          
		
		}	
		  
    	   
		@Override
		public PosPaymentLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentLogIdsByPosPaymentId(Long posPaymentId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.getPosPaymentLogIdsByPosPaymentId(posPaymentId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPosPaymentLogIdsByPosPaymentId(Long posPaymentId)throws ServiceException, ServiceDaoException{
		
		return posPaymentLogService.countPosPaymentLogIdsByPosPaymentId(posPaymentId);
	
	
	}
	
		
	
		@Override
	public List<Long> getPosPaymentLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentLogService.getPosPaymentLogIds(start, limit);
	}

	@Override
	public Integer countPosPaymentLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentLogService.countPosPaymentLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   posPaymentLogService.deleteList(clz, ids);
		
	}


 
}

