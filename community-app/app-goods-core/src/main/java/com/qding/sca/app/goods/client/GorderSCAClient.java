/**
 * 
 */
package com.qding.sca.app.goods.client;

import java.util.List;
import java.util.Map;

import com.qding.app.goods.model.Gorder;
import com.qding.app.goods.service.GorderService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GorderSCAClient implements GorderService {

    private GorderService gorderService;

	public GorderService getGorderService() {
		return gorderService;
	}
	
	
	public void setGorderService(GorderService gorderService) {
		this.gorderService =gorderService;
	}
	
	
			   
		@Override
		public Long insert(Gorder gorder)throws ServiceException, ServiceDaoException{
		
		return gorderService.insert(gorder);
		          
		
		}	
		  
    	   
		@Override
		public List<Gorder> insertList(List<Gorder> gorderList)throws ServiceException, ServiceDaoException{
		
		return gorderService.insertList(gorderList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Gorder gorder)throws ServiceException, ServiceDaoException{
		
		return gorderService.update(gorder);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Gorder> gorderList)throws ServiceException, ServiceDaoException{
		
		return gorderService.updateList(gorderList);
		          
		
		}	
		  
    	   
		@Override
		public Gorder getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return gorderService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Gorder> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return gorderService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderIdsByUserID(Long userID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return gorderService.getGorderIdsByUserID(userID,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getGorderIdByCode(String code)throws ServiceException, ServiceDaoException{
		
		return gorderService.getGorderIdByCode(code);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getGorderIdsByPublicsID(Long publicsID,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return gorderService.getGorderIdsByPublicsID(publicsID,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGorderIdsByUserID(Long userID)throws ServiceException, ServiceDaoException{
		
		return gorderService.countGorderIdsByUserID(userID);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countGorderIdsByPublicsID(Long publicsID)throws ServiceException, ServiceDaoException{
		
		return gorderService.countGorderIdsByPublicsID(publicsID);
	
	
	}
	
		
	
		@Override
	public List<Long> getGorderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderService.getGorderIds(start, limit);
	}

	@Override
	public Integer countGorderIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderService.countGorderIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return gorderService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   gorderService.deleteList(clz, ids);
		
	}


 
}

