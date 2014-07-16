package com.gemantic.dal.dao.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.cache.exception.CacheException;
import com.gemantic.dal.cache.listener.Listener;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.memcached.CacheFactoryImpl;

public  class CacheHelper {
	
	private static Log  log = LogFactory.getLog(CacheHelper.class);

    public static Cache getListCache(String regionName) {
       Cache cache = CacheFactoryImpl.getInstance().getCache(regionName, Boolean.TRUE);
       if(null == cache){
    	   LogHelper.cacheDontConfigured(log, regionName);
       }
       return cache;
    }

    public static Cache getClassCache(Class clazz) {
        if (null == clazz) {
            return null;
        }
        return getListCache(clazz.getName());
    }

    public static Cache getObjectCache(Object object){
        if(null == object){
            return null;
        }
        return getListCache(object.getClass().toString());
    }

    public static void put(String region,String key,Object value) throws CacheException{
    	Cache cache = getListCache(region);
    	if(null != cache){
    	   cache.put(key, value);
    	}
    }


    public static void save(Class objCls,Serializable id, Object obj) throws CacheException{
    	Cache cache = getClassCache(objCls);
    	if(null != cache){
    	   cache.save(id.toString(), obj);
    	}
    }

    public static Object get(String region,String key) throws CacheException{
    	Object obj = null;
    	Cache cache =getListCache(region);
    	if(null!= cache && null != key){
     		obj = cache.get(key);
    	}
    	return obj;
    }
    
    public static Object get(LsCacheInfoHelper lsHelper) throws CacheException{
    	return get(lsHelper.getRegion(),lsHelper.getKey());
    }

    public static Object[] gets(String region,List keyLs) throws CacheException{
       Cache cache = getListCache(region);
       if(null != cache && null != keyLs && keyLs.size() >0){
    	   return cache.get((String[])keyLs.toArray(new String[keyLs.size()]));
       }
       return null;
    }
    
    public static void delete(String region,String key) throws CacheException{  	
    	Cache cache = getListCache(region);
    	if(null != cache && null != key){
    		cache.delete(key);
    	}
    }

    public static void remove(String region,String key) throws CacheException{
    	Cache cache =getListCache(region);
    	if(null != cache){
    		cache.remove(key);
    	}
    }
    public static void update(String region,String key,Object value) throws CacheException{
    	Cache cache = getListCache(region);
    	if(null != cache){
    		cache.update(key, value);
    	}
    }


    public static boolean isDelete(String region,String key) throws CacheException{
    	boolean res = true;
    	Cache cache = getListCache(region);
    	if(null != cache){
    		res = cache.isDelete(key);
    	}
    	return res;
    }

    /**
     * 从缓存中清除一个ListInfo对象时，把该对象所对应的各Id List也从缓存中清除
     * @param lsHelper
     * @throws CacheException
     */
    public static void removeListInfo(LsCacheInfoHelper lsHelper) throws CacheException{
    	Cache cache = getListCache(lsHelper.getRegion());
    	if(null != cache){
            ListInfo listInfo = getListInfo(lsHelper);
            if(null != listInfo){	
            	cache.remove(lsHelper.getListCountKey());            	
        		cache.remove(lsHelper.getListVisitInfoKey());
            	
        		Map visitedSections = listInfo.getSections();
            	if(null != visitedSections && visitedSections.size() >0 ){
            	  Iterator iter = visitedSections.keySet().iterator();
                  while(iter.hasNext()){
            		cache.remove(lsHelper.getIdListKey(new Long(""+iter.next())));
            	  }
            	}
            }
    	}
    }

    public static void removeListInfos(LsCacheInfoHelper[] lsHelpers) throws CacheException{
    	if(null != lsHelpers ){
    		for(LsCacheInfoHelper lsHelper : lsHelpers){
    			removeListInfo(lsHelper);
    		}
    	} 
    }
    
    
    public static void removeListVisitedInfo(LsCacheInfoHelper lsHelper) throws CacheException{
    	Cache cache = getListCache(lsHelper.getRegion());
    	if(null != cache){
    		cache.remove(lsHelper.getListVisitInfoKey());
    	}
    }
    /**
     * 得到缓存中的ListInfo 
     * @param lsHelper
     * @return
     * @throws CacheException
     */

   public static ListInfo getListInfo(LsCacheInfoHelper lsHelper) throws CacheException{
	   Cache cache = getListCache(lsHelper.getRegion());
	   if(null != cache){
		   String key = lsHelper.getListCountKey();   
		   long count = cache.incr(key, 0); 
		   if(count >= 0){
			   ListInfo listInfo = new ListInfo(count);
			   Map< Long, Long > sections = (Map< Long, Long >)cache.get(lsHelper.getListVisitInfoKey());
			   if(null != sections){
					 listInfo.setSections(sections);
		       }
			   return listInfo; 
		   }
	   }
	   return null;
   }
   
   public static void putListInfo(LsCacheInfoHelper lsHelper,Long listCnt) throws CacheException{
	   Cache cache = getListCache(lsHelper.getRegion());
	   if(null != cache){
		   //对于count的存储，因为memcached的原因，糅合了类似c的元素  
//		   cache.put( lsHelper.getListCountKey(), new Long(0));
		   // Numbers are not stored correctly.
		   cache.put( lsHelper.getListCountKey(), String.valueOf(0));
		   cache.incr(lsHelper.getListCountKey(), listCnt);
		   cache.remove(lsHelper.getListVisitInfoKey());
	   }
   }
   public static void putListInfo(LsCacheInfoHelper lsHelper,ListInfo listInfo ) throws CacheException{
	   Cache cache = getListCache(lsHelper.getRegion());
	   if(null != cache){	
		   cache.put( lsHelper.getListCountKey(), new Long(0));
		   cache.incr(lsHelper.getListCountKey(), listInfo.getSize());
		   
		   cache.put(lsHelper.getListVisitInfoKey(),listInfo.getSections());
	   }
   }
   
   //增加List的Size,通过memcached提供的 incr,待自增的Key此时在缓存中肯定存在
   public static void increaseListSize(LsCacheInfoHelper lsHelper) throws CacheException{
	   Cache cache = getListCache(lsHelper.getRegion());
	   if(null != cache){	
		   String key = lsHelper.getListCountKey();
		   long oldCount = cache.incr(key, 0);	   
		   long count = cache.incr(lsHelper.getListCountKey(), 1);
		   if(count < 0){
			   log.warn("Failed to increment list'size with key: "+lsHelper.getKey()+" ,region :"+lsHelper.getRegion());
		   }
	   }
   }
   public static void increaseListSize(LsCacheInfoHelper lsHelper,ListInfoHelper infoHelper) throws CacheException{
	   Cache cache = getListCache(lsHelper.getRegion());
	   if(null != cache){
		   //第一步：增加List的size
		   increaseListSize(lsHelper);
		   //第二步，把VisitedMap中的最新一段去掉
		   infoHelper.addId();
		   cache.put(lsHelper.getListVisitInfoKey(),infoHelper.getVisitedSections() );
	   }
   }
     
}
