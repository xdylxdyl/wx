package com.qding.app.goods.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.qding.app.goods.model.Address;
import com.qding.app.goods.service.AddressService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.qding.common.dao.base.service.impl.BaseDaoServiceImpl;


public class AddressServiceImpl extends BaseDaoServiceImpl implements AddressService {

 

	private static final Log log = LogFactory.getLog(AddressServiceImpl.class);



		   
		@Override
		public Long insert(Address address)throws ServiceException, ServiceDaoException{
		
	
		           if(log.isInfoEnabled()){	
    log.info(" insert data : " + address);
 }
		if (address == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		address.setCreateAt(currentTimeMillis);
		address.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(address);
		} catch (DaoException e) {
			log.error(" insert wrong : " + address);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
      if(log.isInfoEnabled()){
		log.info(" insert data success : " + result);
      }
return result;	
		}	
		  
    	   
		@Override
		public List<Address> insertList(List<Address> addressList)throws ServiceException, ServiceDaoException{
		
	
		          	 if(log.isInfoEnabled()){
        log.info(" insert lists : " + (addressList == null ? "null" : addressList.size()));
      }
		List<Address> resultList = null;

		if (CollectionUtils.isEmpty(addressList)) {
			return new ArrayList<Address>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Address address : addressList) {
			address.setCreateAt(currentTimeMillis);
			address.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Address>) dao.batchSave(addressList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + addressList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
      }
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		             if(log.isInfoEnabled()){
	    log.info(" delete data : " + id);
    }
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Address.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
   if(log.isInfoEnabled()){
		log.info(" delete data success : " + id);
    }
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Address address)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (address == null ? "null" : address.getId()));

		boolean result = false;

		if (address == null) {
			return true;
		}

		address.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(address);
		} catch (DaoException e) {
			log.error(" update wrong : " + address);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + address);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Address> addressList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (addressList == null ? "null" : addressList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(addressList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Address address : addressList) {
			address.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(addressList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + addressList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
         if(log.isInfoEnabled()){
		log.info(" update lists success : " + addressList.size());
         }
		return result;	
		}	
		  
    	   
		@Override
		public Address getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		                 if(log.isInfoEnabled()){
        log.info(" get data : " + id);
       }
		Address address = null;

		if (id == null) {
			return address;
		}

		try {
			address = (Address) dao.get(Address.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" get data success : " + id);
        }
		return address;		
		}	
		  
    	   
		@Override
		public List<Address> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  if(log.isInfoEnabled()){
	    log.info(" get lists : " + (ids == null ? "null" : ids));
      }
		List<Address> address = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Address>();
		}

		try {
			address = (List<Address>) dao.getList(Address.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     if(log.isInfoEnabled()){
		log.info(" get data success : " + (address == null ? "null" : address.size()));
     }
		return address;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAddressIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getAddressIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countAddressIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAddressIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAddressIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

