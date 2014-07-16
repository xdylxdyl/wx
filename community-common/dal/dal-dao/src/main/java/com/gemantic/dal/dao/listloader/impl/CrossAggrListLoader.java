package com.gemantic.dal.dao.listloader.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;

import com.gemantic.dal.cache.Cache;
import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.dao.DBAgent;
import com.gemantic.dal.dao.ListLoader;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.exception.StrategyException;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LogHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.helper.VisitHelper;
import com.gemantic.dal.dao.impl.DBAgentHibernateImpl;
import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;
import com.gemantic.dal.dao.model.SqlInfo;
import com.gemantic.dal.dao.util.CacheHelper;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.dao.util.ObjectUtil;
import com.gemantic.dal.dao.util.SqlUtil;
import com.gemantic.dal.route.RoutingService;
import com.gemantic.dal.route.strategy.IStrategy;

/**
 * 实现跨库查询
 * 应用场景：按题分库，按人查询
 * @author arthurkang
 *
 */
public class CrossAggrListLoader implements ListLoader {

	private Log log = LogFactory.getLog(CrossAggrListLoader.class);

	public ListInfoHelper getListInfo(Object account_id,LsCacheInfoHelper lsHelper, int strategy,boolean needLock) throws DaoException {
		ListInfoHelper infoHelper = null;
//		boolean unlock = false;
//		DBAgent dbAgent = DBAgentHibernateImpl.getInstance();
//		try {
//			//第一步：首先从缓存中加载该List所对应的 ListInfo 对象
//			ListInfo info = (ListInfo) CacheHelper.get(lsHelper);
//			if (null == info) {
//            //第二步：确认同一时间只能有同一个人加载
//				if(VisitHelper.getInstance().checkLsInLoading(lsHelper))
//				{
//					Long perDBCnt = ObjectUtil.getCrossPerDBCount(lsHelper.getRegion());
//					SqlInfo sqlInfo = SqlUtil.getListSql(lsHelper.getRegion(), lsHelper.getParams(),false);
//					List orderedList = DBAgentHibernateImpl.getInstance().getOrderedCrossList(account_id, lsHelper.getRegion(), sqlInfo, 0l,perDBCnt , strategy,false);					
//					if (null == orderedList || orderedList.size() < 1) {
//						return null;
//					}
//					infoHelper = new ListInfoHelper(orderedList.size());
//					for (int sectionNo = 0; sectionNo <= infoHelper.getMaxSectionNo(); sectionNo++) {
//						if (sectionNo < infoHelper.getMaxSectionNo()) {
//							Number min = (Number) orderedList.get(sectionNo* Constants.SecCapacity.intValue());
//							Number max = (Number) orderedList.get((sectionNo + 1)* Constants.SecCapacity.intValue() - 1);
//							infoHelper.addMinMaxInfo(new Long(sectionNo), min, max);
//						} else {
//							Number min = (Number) orderedList.get(sectionNo* Constants.SecCapacity.intValue());
//							Number max = (Number) orderedList.get(orderedList.size() - 1);
//							infoHelper.addMinMaxInfo(new Long(sectionNo), min, max);
//						}
//					}
//					// @todo ,把读到的部分List信息，直接放到缓存里, 目前的设计是只往缓存放3个section
//					Long secNo = infoHelper.getMaxSectionNo();
//					for (long i = 0; i < 3 && secNo >= 0; i++, secNo--) {
//						long minIndex = secNo * Constants.SecCapacity;
//						
//						int maxIndex = 0;
//						if (secNo == infoHelper.getMaxSectionNo()) {
//							maxIndex = orderedList.size() - 1;
//						} else {
//							maxIndex = (secNo.intValue() + 1) * Constants.SecCapacity.intValue() - 1;
//						}
//						List idList = new ArrayList();
//						for (Long j = minIndex; j <= maxIndex; j++) {
//							idList.add(orderedList.get(j.intValue()));
//							infoHelper.addSectionInfo(secNo, new Long(idList.size()));
//						}
//						CacheHelper.put(lsHelper.getRegion(), lsHelper.getIdListKey(secNo), idList);
//					}
//					CacheHelper.put(lsHelper.getRegion(), lsHelper.getKey(),infoHelper.getListInfo());
//				}
//			}
//		} catch (Exception e) {
//			processException(e);
//		} finally {
//			if (unlock) {
//				VisitHelper.getInstance().endIdLsLoading(lsHelper.getRegion(),lsHelper.getKey(), "0");
//			}
//		}
		return infoHelper;
	}

	// 得到聚合List的某一个 SectionInfo

	public List getSectionIdList(LsCacheInfoHelper lsHelper,ListInfoHelper infoHelper, Object account_id, Long sectionNo,int strategy,boolean needLock) throws DaoException {
		List idList = new ArrayList();
//		DBAgent dbAgent = DBAgentHibernateImpl.getInstance();
//		boolean unlock = false;
//		try {
//			boolean bLoading = false;
//			if(null == infoHelper){
//				infoHelper =getListInfo(account_id, lsHelper, strategy,needLock);
//			}
//			if (null == infoHelper || sectionNo > infoHelper.getMaxSectionNo()) {
//				return idList;
//			}
//			if (infoHelper.isVisited(sectionNo)) {
//				idList = (List) CacheHelper.get(lsHelper.getRegion(), lsHelper
//						.getIdListKey(sectionNo));
//				if (null == idList || idList.size() < 1) {
//					bLoading = true;
//				}
//			} else {
//				infoHelper.addSection(sectionNo);
//				CacheHelper.put(lsHelper.getRegion(), lsHelper.getKey(),
//						infoHelper.getListInfo());
//				bLoading = true;
//			}
//			if (bLoading) {
//				if (!infoHelper.isSectionMinMaxExist(sectionNo)) {
//					return idList;
//				}
//				if (!VisitHelper.getInstance().checkIdLsLoad(lsHelper.getRegion(), lsHelper.getKey(),sectionNo.toString())) {
//					unlock = true;
//					Number[] minMax = infoHelper.getMinMaxOfCross(sectionNo);
//					SqlInfo sqlInfo = SqlUtil.getCrossDBSectionSql(lsHelper.getRegion(), lsHelper.getParams(), minMax);
//					idList = DBAgentHibernateImpl.getInstance().getOrderedCrossList(account_id, lsHelper.getRegion(), sqlInfo, 0l,infoHelper.getSectionSize(sectionNo),IStrategy.STRATEGY_W,false);
//					if (null != idList && idList.size() > 0) {
//						CacheHelper.put(lsHelper.getRegion(), lsHelper
//								.getIdListKey(sectionNo), idList);
//					} else {
//						LogHelper.failedLoadOneListSection(log, lsHelper,
//								sectionNo);
//					}
//				}
//			}
//		} catch (Exception e) {
//			processException(e);
//		} finally {
//			if (unlock) {
//				VisitHelper.getInstance().endIdLsLoading(lsHelper.getRegion(),
//						lsHelper.getKey(), sectionNo.toString());
//			}
//		}
//
//		// @todo ，所有的对象list都返回数组，写一个处理这种数据的方法
		return idList;
	}
	// =========================== 以下功能可以通过并行查询进行优化
	private static void processException(Exception e) throws DaoException {
		e.printStackTrace(System.out);
		if (e instanceof MappingException) {
			throw new DaoException(DaoException.POJO_NOTFOUND_EXCEPTION, e);
		} else if (e instanceof NullPointerException) {
			throw new DaoException(DaoException.NULLPOINTER_EXCEPTION, e);
		} else if (e instanceof SQLException) {
			throw new DaoException(DaoException.SQL_EXCEPTION, e);
		} else if (e instanceof HibernateException) {
			throw new DaoException(DaoException.Hibernate_Exception, e);
		} else if (e instanceof StrategyException) {
			throw new DaoException(DaoException.Strategy_Exception, e);
		} else if (e instanceof DaoException) {
			throw (DaoException) e;
		} else {
			throw new DaoException(e);
		}
	}

	public SectionInfo getUpdatedSection(Object account_id, Object obj,
			LsCacheInfoHelper lsHelper) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeIdFromList(Object account_id, Object obj,
			SectionInfo secInfo, boolean reload) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
