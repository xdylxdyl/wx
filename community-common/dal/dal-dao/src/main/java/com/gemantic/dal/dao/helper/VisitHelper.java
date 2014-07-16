package com.gemantic.dal.dao.helper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Delayed;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.ObjectUtil;

public class VisitHelper {

    public static VisitHelper helper;

    private ConcurrentHashMap< String, Long > listInfoMaps;
    private ConcurrentHashMap< String, Long > idListMaps;
    private ConcurrentHashMap< String, Long > objChangeMaps;

    private static final String saveLockKey     = "_-&save";
    private static final String deleteLockKey   = "_-&delete";
    private static final String updateLockKey   = "_-&update";
    
    //锁定数据在缓存中的最长有效期是   30 s
    private static final long maxSpan = 30000l;
    
    private static Log log = LogFactory.getLog(VisitHelper.class);

    private VisitHelper() {
    	listInfoMaps      = new ConcurrentHashMap< String, Long >();
    	idListMaps        = new ConcurrentHashMap< String, Long >();
    	objChangeMaps     = new ConcurrentHashMap< String, Long >();
    }

    public static VisitHelper getInstance() {
        if (null == helper) {
        	synchronized (VisitHelper.class) {
        		if(null == helper){
                     helper = new VisitHelper();
        		}
			}    
        }
        return helper;
    }

    public boolean endLsLoading(String region, String key,Long value) {
        String lsKey = region + "%" + key;
        boolean res  = listInfoMaps.remove(lsKey, value);
        if(!res){
           LogHelper.listInfoLockHasBeenRemoved(log, region, key);	
        }
        return res;
    }
    
    public boolean endLsLoading(LsCacheInfoHelper lsHelper,Long value){
    	return endLsLoading(lsHelper.getRegion(), lsHelper.getKey(), value);
    }

    /**
     * 
     * @param region
     * @param key
     * @return 如果加锁成功，则返回锁的值，否则返回 null
     * @throws Exception
     */
    public Long checkLsInLoading(String region, String key) throws Exception {
        boolean inLoading = isObjectBeingChanged(region, key);
        Long    lockedValue = null;
        if (!inLoading) {
        	String lsKey = region + "%" + key;
        	Long   currTime = new Long(System.currentTimeMillis());
        	Long   oldTime  = listInfoMaps.putIfAbsent(lsKey,currTime);
        	if(null == oldTime){
        		lockedValue = currTime;
        	}
        	else{
        	   if(currTime.longValue() - oldTime.longValue() >= maxSpan){
        		   if(listInfoMaps.replace(lsKey, oldTime, currTime)){
        			lockedValue = currTime;
        		   }
        	   }
        	}
        }
       return lockedValue; 
    }
    
    public Long checkLsInLoading(LsCacheInfoHelper lsHelper) throws Exception{
    	return checkLsInLoading(lsHelper.getRegion(),lsHelper.getKey());
    }


    public boolean endIdLsLoading(String region, String key,Long value) {
        String lsKey = region + "%" + key;
        boolean res  = idListMaps.remove(lsKey, value);
        if(!res){
        	LogHelper.sectionLockHasBeenRemoved(log, region, key);
        }
        return res;
    }
    
    public boolean endIdLsLoading(LsCacheInfoHelper lsHelper,Long value) {
    	return endIdLsLoading(lsHelper.getRegion(), lsHelper.getKey(), value);
    }

    /**
     * 
     * @param region
     * @param key
     * @return 如果加锁成功，则返回锁值，否则返回null
     * @throws Exception
     */
    public Long checkIdLsLoad(String region, String key) throws Exception {
        boolean inLoading = isObjectBeingChanged(region, key);
        Long   lockedValue = null;
        if(!inLoading){
            String lsKey = region + "%" + key;
            Long currTime = new Long(System.currentTimeMillis());
            Long oldTime  = idListMaps.putIfAbsent(lsKey, currTime);
            if(null == oldTime){
            	lockedValue = currTime;
            }
            else{
            	if(currTime.longValue() - oldTime.longValue() >= maxSpan){
            		if(idListMaps.replace(lsKey, oldTime, currTime)){
            			lockedValue = currTime;
            		}
            	}
            }
        }
        return lockedValue;
    }

    public Long checkIdLsLoad(LsCacheInfoHelper lsHelper) throws Exception {
    	return checkIdLsLoad(lsHelper.getRegion(), lsHelper.getKey());
    }
    /**
     * 当执行save | update | delete 动作时，需要把List的最新一页的加载进行加锁
     * 
     * @param object
     * @throws Exception
     */
    public void inLoadWithSave(Object object) throws Exception {
        inLoadWithChanging(object, saveLockKey);
    }

    public void inLoadWithDelete(Object object) throws Exception {    
    	inLoadWithChanging(object, deleteLockKey);
    }

    public void inLoadWithUpdate(Object object) throws Exception{
        inLoadWithChanging(object, updateLockKey);
    }

    private void inLoadWithChanging(Object object, String lockKey) throws Exception {
        List<LsCacheInfoHelper> list = ObjectUtil.getLsInfoList(object);
        for (LsCacheInfoHelper lsHelper : list) {
        	String lsKey = lsHelper.getRegion()+"%"+lsHelper.getKey();
        	String lsLockKey = lsKey + lockKey;
        	objChangeMaps.put(lsLockKey, System.currentTimeMillis());
            //非常重要的逻辑，当执行 Save|Update|Delete 时，把针对该List的ListInfo,List Section加载信息删除
        	listInfoMaps.remove(lsKey);
        	  idListMaps.remove(lsKey);
        	
        }
    }

    public void endLoadWithSave(Object object) throws Exception {
        endLoadWithChanging(object, saveLockKey);
    }

    public void endLoadWithDelete(Object object) throws Exception {  	
        endLoadWithChanging(object, deleteLockKey);
    }
    
    
    public void endLoadWithUpdate(Object object) throws Exception {
        endLoadWithChanging(object, updateLockKey);
    }

    private void endLoadWithChanging(Object object, String lockKey) throws Exception {
        List<LsCacheInfoHelper > list = ObjectUtil.getLsInfoList(object);
        for (LsCacheInfoHelper lsHelper : list) {
        	String lsKey = lsHelper.getRegion()+"%"+lsHelper.getKey()+lockKey;
        	objChangeMaps.remove(lsKey);
        }
    }
    
    

    private boolean isObjectSaving(String listName, String key) throws Exception {
        return isObjectChanging(listName, key, saveLockKey);
    }

    private boolean isObjectDeleting(String listName, String key) throws Exception {
        return isObjectChanging(listName, key, deleteLockKey);
    }

    private boolean isObjectUpdating(String listName, String key) throws Exception {
        return isObjectChanging(listName, key, updateLockKey);
    }

    private boolean isObjectChanging(String listName, String key, String lockKey) throws Exception {
        boolean res = true;
        if (StringUtils.isBlank(listName)) {
            return false;
        }
        String lsKey = listName + "%" + key+lockKey;
        Long   lastLockTime = objChangeMaps.get(lsKey);
        if(null == lastLockTime){
        	res = false;
        }
        else{
        	if(System.currentTimeMillis() - lastLockTime.longValue() >= maxSpan){
        	  res = ! objChangeMaps.remove(lsKey,lastLockTime);
        	}
        }
        return res;
    }
    
    private boolean isObjectBeingChanged(String listName,String key) throws Exception{
    	return isObjectSaving(listName, key) | isObjectDeleting(listName, key) | isObjectUpdating(listName, key);
    }

}
