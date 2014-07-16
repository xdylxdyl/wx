/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.PosPaymentFileLog;
import com.qding.common.payment.service.PosPaymentFileLogService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class PosPaymentFileLogSCAClient implements PosPaymentFileLogService {

    private PosPaymentFileLogService posPaymentFileLogService;

	public PosPaymentFileLogService getPosPaymentFileLogService() {
		return posPaymentFileLogService;
	}
	
	
	public void setPosPaymentFileLogService(PosPaymentFileLogService posPaymentFileLogService) {
		this.posPaymentFileLogService =posPaymentFileLogService;
	}
	
	
			   
		@Override
		public Long insert(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.insert(posPaymentFileLog);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentFileLog> insertList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.insertList(posPaymentFileLogList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(PosPaymentFileLog posPaymentFileLog)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.update(posPaymentFileLog);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<PosPaymentFileLog> posPaymentFileLogList)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.updateList(posPaymentFileLogList);
		          
		
		}	
		  
    	   
		@Override
		public PosPaymentFileLog getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<PosPaymentFileLog> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getPosPaymentFileLogIdsByType(int type,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.getPosPaymentFileLogIdsByType(type,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countPosPaymentFileLogIdsByType(int type)throws ServiceException, ServiceDaoException{
		
		return posPaymentFileLogService.countPosPaymentFileLogIdsByType(type);
	
	
	}
	
		
	
		@Override
	public List<Long> getPosPaymentFileLogIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentFileLogService.getPosPaymentFileLogIds(start, limit);
	}

	@Override
	public Integer countPosPaymentFileLogIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentFileLogService.countPosPaymentFileLogIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentFileLogService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return posPaymentFileLogService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   posPaymentFileLogService.deleteList(clz, ids);
		
	}


 
}

