/**
 * 
 */
package com.qding.sca.app.decorate.client;

import java.util.List;
import java.util.Map;

import com.qding.app.decorate.model.Decorate;
import com.qding.app.decorate.service.DecorateService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DecorateSCAClient implements DecorateService {

    private DecorateService decorateService;

	public DecorateService getDecorateService() {
		return decorateService;
	}
	
	
	public void setDecorateService(DecorateService decorateService) {
		this.decorateService =decorateService;
	}
	
	
			   
		@Override
		public Long insert(Decorate decorate)throws ServiceException, ServiceDaoException{
		
		return decorateService.insert(decorate);
		          
		
		}	
		  
    	   
		@Override
		public List<Decorate> insertList(List<Decorate> decorateList)throws ServiceException, ServiceDaoException{
		
		return decorateService.insertList(decorateList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Decorate decorate)throws ServiceException, ServiceDaoException{
		
		return decorateService.update(decorate);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Decorate> decorateList)throws ServiceException, ServiceDaoException{
		
		return decorateService.updateList(decorateList);
		          
		
		}	
		  
    	   
		@Override
		public Decorate getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return decorateService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Decorate> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return decorateService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByUserId(String userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateService.getDecorateIdsByUserId(userId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByVenderId(Long venderId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateService.getDecorateIdsByVenderId(venderId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByPublicsId(Long publicsId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateService.getDecorateIdsByPublicsId(publicsId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByRoomId(Long roomId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateService.getDecorateIdsByRoomId(roomId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDecorateIdsByUserMobile(String userMobile,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return decorateService.getDecorateIdsByUserMobile(userMobile,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByUserId(String userId)throws ServiceException, ServiceDaoException{
		
		return decorateService.countDecorateIdsByUserId(userId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByVenderId(Long venderId)throws ServiceException, ServiceDaoException{
		
		return decorateService.countDecorateIdsByVenderId(venderId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByPublicsId(Long publicsId)throws ServiceException, ServiceDaoException{
		
		return decorateService.countDecorateIdsByPublicsId(publicsId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByRoomId(Long roomId)throws ServiceException, ServiceDaoException{
		
		return decorateService.countDecorateIdsByRoomId(roomId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDecorateIdsByUserMobile(String userMobile)throws ServiceException, ServiceDaoException{
		
		return decorateService.countDecorateIdsByUserMobile(userMobile);
	
	
	}
	
		
	
		@Override
	public List<Long> getDecorateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateService.getDecorateIds(start, limit);
	}

	@Override
	public Integer countDecorateIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateService.countDecorateIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return decorateService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   decorateService.deleteList(clz, ids);
		
	}


 
}

