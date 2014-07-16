/**
 * 
 */
package com.qding.sca.common.payment.client;

import java.util.List;
import java.util.Map;

import com.qding.common.payment.model.Refund;
import com.qding.common.payment.service.RefundService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class RefundSCAClient implements RefundService {

    private RefundService refundService;

	public RefundService getRefundService() {
		return refundService;
	}
	
	
	public void setRefundService(RefundService refundService) {
		this.refundService =refundService;
	}
	
	
			   
		@Override
		public Long insert(Refund refund)throws ServiceException, ServiceDaoException{
		
		return refundService.insert(refund);
		          
		
		}	
		  
    	   
		@Override
		public List<Refund> insertList(List<Refund> refundList)throws ServiceException, ServiceDaoException{
		
		return refundService.insertList(refundList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return refundService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Refund refund)throws ServiceException, ServiceDaoException{
		
		return refundService.update(refund);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Refund> refundList)throws ServiceException, ServiceDaoException{
		
		return refundService.updateList(refundList);
		          
		
		}	
		  
    	   
		@Override
		public Refund getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return refundService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Refund> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return refundService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRefundIdsByGorderCode(String gorderCode,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return refundService.getRefundIdsByGorderCode(gorderCode,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getRefundIdByGorderCodeAndGoodsId(String gorderCode,Long goodsId)throws ServiceException, ServiceDaoException{
		
		return refundService.getRefundIdByGorderCodeAndGoodsId(gorderCode,goodsId);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countRefundIdsByGorderCode(String gorderCode)throws ServiceException, ServiceDaoException{
		
		return refundService.countRefundIdsByGorderCode(gorderCode);
	
	
	}
	
		
	
		@Override
	public List<Long> getRefundIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return refundService.getRefundIds(start, limit);
	}

	@Override
	public Integer countRefundIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return refundService.countRefundIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return refundService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return refundService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   refundService.deleteList(clz, ids);
		
	}


 
}

