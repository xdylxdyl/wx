package com.gemantic.dal.dao.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.MapInfo;
import com.gemantic.dal.dao.util.CacheHelper;

public class DisplayUtil {

	public static void showListInfo(ListInfo listInfo, Cache lsCache,String lsKey) throws Exception {
		if(null != listInfo){
		Map<Long, Long> lsMap = listInfo.getSections();
		Iterator<Long> iter = lsMap.keySet().iterator();
		while (iter.hasNext()) {
			Long pageNo = iter.next();
			System.out.println("Page No : " + pageNo + "  --- "+ lsMap.get(pageNo));
			List idLs = (List) lsCache.get(lsKey + "%%" + pageNo);
			System.out.println(" ---------------Section " + pageNo+ "----------------- ");
			if (null != idLs) {
				for (int i = 0; i < idLs.size(); i++) {
					System.out.print(idLs.get(i) + "  ");
					if (i == idLs.size() - 1) {
						System.out.println();
					}
				}
			}
		}
		}
	}

	public static void showListDetaiInfo(String region, Object[] params)
			throws Exception {
		Cache cache = CacheHelper.getListCache(region);
		if (null == cache) {
			System.out.println(" Cache for region -->" + region+ " doesn't exists \r\n");
		}
		LsCacheInfo lsInfo = new LsCacheInfo(region, params);
		LsCacheInfoHelper lsHelper = new LsCacheInfoHelper(lsInfo);
		ListInfo listInfo = CacheHelper.getListInfo(lsHelper);
		if (null == listInfo) {
			System.out.println(" List  -->" + region + " with count key "+ lsHelper.getListCountKey() + " doesn't in cache \r\n");
		}
		System.out.println(" ===================List information in cache ======================\r\n");
		System.out.println(" list name : " + region + "\r\n");
		System.out.println(" list count key  : " + lsHelper.getListCountKey() + "\r\n");
		if (null != listInfo) {
			System.out.println(" list size : " + listInfo.getSize() + "\r\n");
		}
		showListInfo(listInfo, cache, lsHelper.getKey());
	}

	public static void showMapInfo(String region,Object[] params) throws Exception{
		Cache cache = CacheHelper.getListCache(region);
		if(null == cache){
			System.out.println(" Cache for region -->" + region+ " doesn't exists \r\n");
		}
		MapInfo mapInfo = new MapInfo(region,params);
		Object obj = cache.get(mapInfo.getKey());
		if(null == obj){
			System.out.println(" Object with key :"+mapInfo.getKey()+ " doesn't in cache ");
		}
		else{
			System.out.println(" The Value of Object with key :"+mapInfo.getKey()+ " 's value -->"+obj);
		}
	}
	public static void cleanCache(String region, Object[] params)throws Exception {
		Cache cache = CacheHelper.getListCache(region);
		LsCacheInfo lsInfo = new LsCacheInfo(region,	params);
		cache.remove(lsInfo.getKey());
	}
}
