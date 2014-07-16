package com.gemantic.dal.dao.cachehandler.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.dao.ListLoaderCenter;
import com.gemantic.dal.dao.cachehandler.ListHandler;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.UpdateInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;
import com.gemantic.dal.dao.cachehandler.impl.AbstractListHandler;

public class CommonListHandler extends AbstractListHandler implements ListHandler {

    private static Log log = LogFactory.getLog(CommonListHandler.class);

    public void processSave(Object account_id, Object obj, List<SectionInfo> saveInfos) throws Exception {
        boolean bRAndW = RoutingService.getInstance().isReadWrite(obj.getClass(), account_id);
        //读写分离的处理逻辑
        if (bRAndW) {
            for (SectionInfo sectionInfo : saveInfos) {
                LsCacheInfoHelper lsHelper = sectionInfo.getLsHelper();
                ListInfoHelper infoHelper = sectionInfo.getInfoHelper();
                List idList = sectionInfo.getIdList();


                CacheHelper.increaseListSize(lsHelper);
                infoHelper.addSectionInfo(sectionInfo.getSectionNo(), idList.size() + 1l);
                CacheHelper.put(lsHelper.getRegion(), lsHelper.getListVisitInfoKey(), infoHelper.getVisitedSections());

                Object objValueOfLs = ObjectUtil.getObjectValueOfList(obj, lsHelper);
                idList.add(objValueOfLs);
                CacheHelper.put(lsHelper.getRegion(), lsHelper.getIdListKey(sectionInfo.getSectionNo()), idList);
            }
        }
        //非读写分离的处理逻辑
        else {
            for (SectionInfo sectionInfo : saveInfos) {
                LsCacheInfoHelper lsHelper = sectionInfo.getLsHelper();
                ListInfoHelper infoHelper = sectionInfo.getInfoHelper();
                //处理逻辑: 将List的Size加1,将List的最新一段section从缓存中移除
                CacheHelper.increaseListSize(lsHelper, infoHelper);
            }
        }

    }

    /**
     * 核心 ： 在DAL的这个模块中，依据的理念是---以人为本，系统中的某个List一定是某个人的
     * 1 .同一个List,在同一时间只能由一个人修改， 此时如果缓存中没有这个List的ListInfo对象，则其他用户不能加载
     * 2. 在List的ListInfo没有存在在缓存中的情况下， 如果List的拥有者此时没有对这个List做任何修改，则其他用户可以从从数据库中装载该List信息，但只有一个用户可以装载成功
     * <p/>
     * <p/>
     * 本方法所实现的功能，解决如下两种场景
     * <p/>
     * 场景一  某个对象 更新前后 所分别对应的两个List的变更：
     * 相同List中的对象具有相同的Key值，
     * 即<日志列表>中的所有<日志>都有一个相同属性，那就是“这些日志都是已发布的   type=0”。
     * <草稿箱列表>中的所有<日志>也都有一个相同属性，那就是"这些日志都是未发布的 type=1".
     * 当<草稿箱>的某一篇<日志>，被用户点击发布时，需要把该日志从<草稿箱>的队列中找到, 然后删除
     * 并将<日志列表>的队列重新排列，以便将这篇<日志>安排在正确的位置
     * <p/>
     * 场景二  某个对象 更新前后 对应的是相同的List,如果List是按照对象的某个属性进行排序的，而此次变更中，对象变更了该属性，导致整个List失效：
     * <相册专辑>中的<照片>按照照片的更新时间进行排序，当其中的某张<照片>的<更新时间属性>被用户修改后，需要将该<相册专辑>
     * 中的所有照片重新排序，以便将新修改的<照片>放置到正确的位置
     * <p/>
     * 场景一 处理方案：
     * <p/>
     * 特点： 在这种场景下，涉及到两个List的变更,即<草稿箱列表>和<日志列表>
     * <p/>
     * 情况一》非读写分离：
     * <p/>
     * 解决方案： 简单粗暴的解决方案，把<草稿箱列表>和<日志列表>的List均从缓存中删除，待下次需要后再重新加载
     * <p/>
     * 本方法返回的数据： 因<对象>变更，引起的数据将发生变化的<List>的Region,及<新/旧 对象>所分别对应的<新/旧 List>在缓存中的Key值，以供更新成功后，从缓存中删除 <新/旧 List>
     * <p/>
     * 即 类 <UpdateInfo> --- 属性Map<String,LsCacheInfoHelper[]> changedLsHelpers
     * 该Map的  Key值(String)                 ------------------  List 所存放在的缓存(region：即用户在dao.xml配置的该List的name属性)
     * value值(LsCacheInfoHelper[])  ------------------  由<对象>所对应的<新/旧 List>所分别对应的LsCacheInfo对象所组成的数组
     * 即<草稿箱列表><日志列表>这两个List说分别对应的LsCacheInfo对象
     * 情况二》读写分离：
     * <p/>
     * 解决方案：因为存在主从数据库之间同步的时间延迟，所以在对象变更成功后，需要同步更新<草稿箱列表>和<日志列表>所对应的List
     * <p/>
     * 本方法返回的数据：应对象变更，导致数据将发生变化的 <新/旧对象>分别对应的<新/旧 List>，以便更新成功后
     * <p/>
     * 1）从<旧List>中删除对象  --- 即：从 <草稿箱列表> 中将对象删除
     * 2）将<新List>从缓存中删除，然后重新加载，直到加载到<新对象>所在的section
     * ---即：因为<日志> 即将发布到<日志列表>的List,但无法确认自己在该List中的位置，
     * 所以需要将<日志列表>的List从缓存中删除，然后重新加载，直到找到该<日志>
     * <p/>
     * 即 UpdateInfo ----oldObjListSections(对应 <草稿箱列表>的信息)
     * LsMap (对应 <日志列表> 的信息)
     * <p/>
     * 场景二  处理方案
     * <p/>
     * 特点： 在这种场景下，仅涉及到一个List的变更，即<相册专辑>
     * <p/>
     * 情况一》非读写分离：
     * <p/>
     * 解决方案： 简单粗暴的解决方案，把<相册专辑>的List从缓存中删除，待下次需要后再重新加载
     * <p/>
     * 本方法返回的数据：因<对象>变更，引起失效的<List>
     * <p/>
     * 即 类 <UpdateInfo> --- 属性Map<String,LsCacheInfoHelper[]> changedLsHelpers
     * 该Map的Key值(String)               ------------------  List 所对应的缓存(region)
     * value值(LsCacheInfoHelper[]) ------------------  <对象>所对应的即将失效的List所对应的LsCacheInfo信息,以便更新数据库成功后，
     * 将<相册专辑>所对应的List从缓存中删除
     * 情况二》读写分离：
     * <p/>
     * 解决方案：因为存在主从数据库之间同步的时间延迟，所以在对象变更成功后，需要同步更新<1班>的List
     * <p/>
     * 本方法返回的数据：因<对象>变更，引起失效的<List>,以便更新成功后
     * <p/>
     * 1) 将<List>从缓存中删除，然后重新加载，直到加载到<相册专辑>所在的section
     * ---即：将<相册专辑>的List,从缓存中删除，然后重新加载，直到在<对象>应该在的新位置找到该<对象>
     * <p/>
     * 即 UpdateInfo ----LsMap (对应 <相册专辑> 的信息)
     */

    public UpdateInfo getUpdateInfos(Object account_id, Object obj, Object oldObj, Map<String, LsCacheInfoHelper> newObjLsMap, Map<String, LsCacheInfoHelper> oldObjLsMap) throws Exception {
        boolean bRAndW = RoutingService.getInstance().isReadWrite(obj.getClass(), account_id);
        //读写分离的处理逻辑
        if (bRAndW) {
            // 场景一  ：<草稿箱列表>的信息   ，场景二 : 空List
            List<SectionInfo> oldSectionInfos = new ArrayList<SectionInfo>();
            //  场景一 : <日志列表>的信息    , 场景二 : <相册专辑>的信息
            Map<String, LsCacheInfoHelper> newChangedLsMsp = new HashMap<String, LsCacheInfoHelper>();

            Iterator<String> iter = oldObjLsMap.keySet().iterator();

            while (iter.hasNext()) {
                String region = iter.next();

                LsCacheInfoHelper oldLsHelper = oldObjLsMap.get(region);
                LsCacheInfoHelper newLsHelper = newObjLsMap.get(region);

                String oldKey = oldLsHelper.getKey();
                String newKey = newLsHelper.getKey();

                //Condition 1　：Object所对应的List 的Key值未发生变化，但用于排序的属性 发生了变化，此时List做失效处理
                if (oldKey.equalsIgnoreCase(newKey)) {

                    //情况一: Object 存放在List中的Id值发生了变化
                    Object oldValueOfLs = ObjectUtil.getObjectValueOfList(oldObj, oldLsHelper);
                    Object newValueOfLs = ObjectUtil.getObjectValueOfList(obj, newLsHelper);

                    if (!oldValueOfLs.equals(newValueOfLs)) {
                        newChangedLsMsp.put(region, newLsHelper);
                        continue;
                    }

                    //情况二 ：Object 针对该List的Order by属性发生了变化
                    String oldOrderByKey = oldLsHelper.getOrderByKey();
                    String newOrderByKey = newLsHelper.getOrderByKey();
                    if (null != oldOrderByKey && oldOrderByKey.length() > 0
                            && !oldOrderByKey.equalsIgnoreCase(newOrderByKey)) {
                        newChangedLsMsp.put(region, newLsHelper);
                        continue;
                    }
                }
                //Condition 2：Object所对应的List 的Key值发生变化的情况
                else {
                    Cache cache = CacheHelper.getListCache(region);
                    if (null == cache) {
                        continue;
                    }
                    //第一步 ：处理 <草稿箱列表> ,因为是从<草稿箱列表>中删除一个对象，所以正常情况下该List肯定不为空
                    ListInfoHelper oldInfoHelper = ListLoaderCenter.getInstance().getListInfo(account_id, oldLsHelper, IStrategy.STRATEGY_W, Constants.NoLock);
                    if (null != oldInfoHelper && oldInfoHelper.getSize() > 0) {
                        if (oldInfoHelper.isSectionsReBuild()) {
                            oldInfoHelper.getListInfo().setSections(null);
                        }
                        SectionInfo delSec = ListLoaderCenter.getInstance().getUpdatedSection(account_id, oldObj, oldLsHelper);
                        if (null != delSec) {
                            oldSectionInfos.add(delSec);
                        }
                    }
                    //第二步： 处理 <日志列表>
                    newChangedLsMsp.put(region, newLsHelper);
                }
            } //while
            return new UpdateInfo(null, oldSectionInfos, newChangedLsMsp);
        }
        //非读写分离下的处理逻辑
        else {
            return super.getUpdateInfos(account_id, obj, oldObj, newObjLsMap, oldObjLsMap);
        }
    }

    /**
     * 更新数据库成功后，做的更新缓存动作
     * <p/>
     * 情况一 ： 非读写分离：
     * 处理逻辑：  将因对象变更，导致List数据发生变更的，《新/旧 对象》所对应的《新/旧 List》从缓存中删除
     * 场景一: 会有两个List从缓存中删除
     * 场景二: 会有一个List
     * 情况二：读写分离
     * 处理逻辑：  1) 从《旧对象》 所对应的 《旧List》中 将 《旧对象》删除
     * 2） 将《新对象》 所对应的 《新List》从缓存中清除，并从主库中重新加载该List,直到加载出 新对象 所对应的 Section
     */
    public void processUpdate(Object account_id, Class clazz, Object oldObj, Object obj, UpdateInfo updateInfo) throws Exception {
        boolean bRW = RoutingService.getInstance().isReadWrite(clazz, account_id);
        //读写分离的处理逻辑
        if (bRW) {
            if (null != updateInfo) {
                /**
                 * 第一步： 把对象从其所对应的<旧List>中删除
                 *
                 * 场景一： 此处是指把<日志>从<草稿箱>列表中删除
                 *
                 * 场景二： 此时，updateInfo.getOldObjListSections() 为空，此处不做任何处理
                 */
                if (null != updateInfo.getOldObjListSections()) {
                    for (SectionInfo secInfo : updateInfo.getOldObjListSections()) {
                        ListLoaderCenter.getInstance().removeIdFromList(account_id, oldObj, secInfo, bRW);
                    }
                }
                /**
                 * 第二步 ：把对象放到其所对应的<新List>的正确位置
                 *
                 * 场景一，二：
                 *         1)把<List>相关信息从缓存中删除(场景一中的<日志列表>, 场景二中的<相册专辑>)
                 *         2)重新加载该List,直到加载到Id 所在的section
                 */
                if (null != updateInfo.getNewLsMap() && updateInfo.getNewLsMap().size() > 0) {
                    Iterator<String> regionIter = updateInfo.getNewLsMap().keySet().iterator();
                    while (regionIter.hasNext()) {
                        String region = regionIter.next();
                        LsCacheInfoHelper lsHelper = updateInfo.getNewLsMap().get(region);
                        CacheHelper.removeListInfo(lsHelper);
                        ListLoaderCenter.getInstance().getUpdatedSection(account_id, obj, lsHelper);
                    }
                }
            }
        }
        //非读写分离下的处理逻辑
        else {
            //简单粗暴的方式，从缓存中删除该对象所分别对应的《新/旧 List》,在这种情况下，仅需要参数 updateInfo
            super.processUpdate(null, null, null, null, updateInfo);
        }
    }
}
