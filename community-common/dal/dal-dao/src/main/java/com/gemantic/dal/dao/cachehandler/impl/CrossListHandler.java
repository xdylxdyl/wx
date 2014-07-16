package com.gemantic.dal.dao.cachehandler.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.cachehandler.ListHandler;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.cachehandler.impl.AbstractListHandler;

public class CrossListHandler extends AbstractListHandler implements ListHandler {

    private static Log log = LogFactory.getLog(CrossListHandler.class);

    public void processSave(Object account_id, Object obj, List<SectionInfo> saveInfos) throws Exception {
        for (SectionInfo sectionInfo : saveInfos) {
            LsCacheInfoHelper lsHelper = sectionInfo.getLsHelper();
            List idList = sectionInfo.getIdList();

            Number orderByProperty = (Number) ObjectUtil.getObjectStrategyPropert(obj);
            if (null != orderByProperty) {
                //@todo，以下代码是可以优化的 @_@
                Object[] latestId = (Object[]) sectionInfo.getLatestId();
                if (null == latestId) {
                    CacheHelper.remove(lsHelper.getRegion(), lsHelper.getKey());
                    continue;
                }
                Number maxValue = (Number) latestId[latestId.length - 1];
                if (orderByProperty.longValue() < maxValue.longValue()) {
                    CacheHelper.remove(lsHelper.getRegion(), lsHelper.getKey());
                    //@todo,记住在这里补充日志
                    continue;
                }
            }
            ListInfoHelper infoHelper = sectionInfo.getInfoHelper();

            Number[] nums;
            if (0 == idList.size()) {
                nums = new Number[]{orderByProperty, orderByProperty};
            } else {
                nums = infoHelper.getMinMaxOfCross(sectionInfo.getSectionNo());
                nums[1] = orderByProperty;
            }
            infoHelper.addMinMaxInfo(sectionInfo.getSectionNo(), nums[0], nums[1]);
            infoHelper.addSectionInfo(sectionInfo.getSectionNo(), idList.size() + 1l);
            infoHelper.increaseSize();
//			CacheHelper.put(lsHelper.getRegion(), lsHelper.getKey(),infoHelper.getListInfo());
//			
//			Object[] realId = new Object[]{id,ObjectUtil.getObjectStrategyPropert(obj),orderByProperty};
//			idList.add(realId);
//			CacheHelper.put(lsHelper.getRegion(),lsHelper.getIdListKey(sectionInfo.getSectionNo()),idList);
        }
    }
}
