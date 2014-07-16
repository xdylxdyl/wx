package com.gemantic.dal.dao.util;

import java.util.List;

import com.gemantic.dal.cache.NullObjectContent;
import com.gemantic.dal.dao.model.MapInfo;

public class NullObjectHelper {

	public static void removeNullMapsOfObject(Object object) throws Exception{
		List<MapInfo> newMaps = ObjectUtil.getMapInfoList(object);
		for (MapInfo info : newMaps) {
			NullObjectContent.remove(Constants.NullObjectPrefix+"_"+info.getRegion()+"_"+info.getKey()+"");
		}
	}
}
