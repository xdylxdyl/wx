/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.UnionPayment;
import com.qding.common.payment.service.UnionPaymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class UnionPaymentSCAClient implements UnionPaymentService {

    private UnionPaymentService unionPaymentService;

	public UnionPaymentService getUnionPaymentService() {
		return unionPaymentService;
	}
	
	
	public void setUnionPaymentService(UnionPaymentService unionPaymentService) {
		this.unionPaymentService =unionPaymentService;
	}
	
	
			   
		@Override
		public Long insert(UnionPayment unionPayment)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.insert(unionPayment);
		          
		
		}	
		  
    	   
		@Override
		public List<UnionPayment> insertList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.insertList(unionPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UnionPayment unionPayment)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.update(unionPayment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UnionPayment> unionPaymentList)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.updateList(unionPaymentList);
		          
		
		}	
		  
    	   
		@Override
		public UnionPayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UnionPayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUnionPaymentIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.getUnionPaymentIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getUnionPaymentIdByGorderCodeAndQdCode(String gorderCode,String qdCode)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.getUnionPaymentIdByGorderCodeAndQdCode(gorderCode,qdCode);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countUnionPaymentIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return unionPaymentService.countUnionPaymentIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getUnionPaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentService.getUnionPaymentIds(start, limit);
	}

	@Override
	public Integer countUnionPaymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentService.countUnionPaymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return unionPaymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   unionPaymentService.deleteList(clz, ids);
		
	}


 
}

