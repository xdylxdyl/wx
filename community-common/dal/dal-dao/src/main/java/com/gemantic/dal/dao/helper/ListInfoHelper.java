package com.gemantic.dal.dao.helper;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.dao.model.ListInfo;
import com.gemantic.dal.dao.model.ListLoadInfo;
import com.gemantic.dal.dao.util.Constants;

public class ListInfoHelper {

	private ListInfo info;

	private static Log log = LogFactory.getLog(ListInfoHelper.class);

	public ListInfoHelper(ListInfo ls) {
		info = ls;
	}
 
	public ListInfoHelper(long totalCnt){
		info = new ListInfo(totalCnt);
	}
	public ListInfo getListInfo() {
		return info;
	}

	public boolean isVisited() {
		return null == info ? false : true;
	}

	public boolean isSectionsVistied() {
		boolean res = false;
		if (isVisited()) {
			if (info.getSize() > 0 && null != info.getSections()&& info.getSections().size() > 0) {
				res = true;
			}
		}
		return res;
	}

	public boolean isVisited(Long SectionNo) {
		boolean res = false;
		if (null != info) {
			if (null != info.getSections()) {
				Long SectionSize = info.getSections().get(SectionNo);
				if (null != SectionSize) {
					res = true;
				}
			}
		}
		return res;
	}

	/*
	 * 用于判断跨库聚合的数据是否可用
	 */
	public boolean isCrossAggrInfoBuild(){
		boolean res = false;
		if(null != info){
			if(null != info.getMaxMins() && info.getMaxMins().size() >0){
				res = true;
			}
		}
		return res;
		
	}
	public boolean isLatestSection(Long sectionNo) {
		boolean res = false;
		if (null != info && null != sectionNo) {
			if (info.getSize() > 0) {
				if (getMaxSectionNo() == sectionNo.intValue()) {
					res = true;
				}
			}
		}
		return res;
	}

	public boolean isLatestSecVisited() {
		boolean res = false;
		if (isSectionsVistied()) {
			res = isVisited(getMaxSectionNo());
		}
		return res;
	}

	/**
	 * 得到用户访问过的缓存分页的 数量，
	 * 
	 * @return
	 */
	public int getSectionsSize() {
		if (null == info) {
			return 0;
		} else {
			if (null == info.getSections()) {
				return 0;
			} else {
				return info.getSections().size();
			}
		}
	}

	public Long getSectionSize(Long sectionNo) {
		Long secSize = new Long(0);
		if (null != info && null != sectionNo) {
			if (isLatestSection(sectionNo)) {
				secSize = getLatestSecSize();
			} else if (isVisited(sectionNo)) {
				secSize = info.getSections().get(sectionNo);
			} else {
				secSize = Constants.SecCapacity;
			}
		}
		return secSize;
	}

	public synchronized void addSectionInfo(Long sectionNo,Long sectionCnt) {
		if (null != info) {
			if (null != sectionNo && null != sectionCnt) {
				info.getSections().put(sectionNo, sectionCnt);
			}
		} else {
			log.error("Error : Add Section Info error -- No ListInfo exists");
		}
	}

	public synchronized void addMinMaxInfo(Long sectionNo,Number min,Number max) {
		info.getMaxMins().put(sectionNo,new Number[]{min,max});
	}
	public synchronized void removeSectionInfo(Long sectionNo) {
		info.getSections().remove(sectionNo);
	}
    public boolean isSectionMinMaxExist(Long sectionNo){
    	boolean res = false;
        if(null != info && null != info.getMaxMins() && info.getMaxMins().size() >0 ){
        	Number[] nums = info.getMaxMins().get(sectionNo);
        	if(null != nums && nums.length >1){
        		res = true;
        	}
        }
    	return res;
    }
	//增加一个对象的处理逻辑,需仔细思考
	public void addId() {
		if (null != info) {
		    //当增加List的size以后，它最新一段 section的序号可能会发生变更,所以以下两步的顺序是不能颠倒的
			synchronized (info) {
				info.increaseSize();
	            info.getSections().remove(getMaxSectionNo());
			}
		} else {
			log.error("Error : Add Id error -- No ListInfo exists");
		}
	}

	public synchronized void increaseSize() {
		if (null != info) {
			info.increaseSize();
		} else {
			log.error("Error : Increase List's size error -- No ListInfo exists");
		}
	}

	public synchronized void addSection(Long sectionNo) {
		if (null != info) {
			if (isVisited(sectionNo)) {
				return;
			}
			Long sectionSize = Constants.SecCapacity;
			if (isLatestSection(sectionNo)) {
				sectionSize = getLatestSecSize();
			}
			info.getSections().put(sectionNo, sectionSize);
		}
	}

	/**
	 * 从section info中移除ID
	 * 
	 * @param sectionNo
	 */
	public synchronized void removeId(Long sectionNo) {
		if (null != info) {
			if (info.getSize() > 0) {
				long sectionSize = getSectionSize(sectionNo);
				if (1 == sectionSize) {
					info.getSections().remove(sectionNo);
				} else {
					info.getSections().put(sectionNo,new Long(sectionSize - 1));
				}
			}
			info.decreaseSize();
		}

	}

	public synchronized void decreateSize() {
		if (null != info) {
			info.decreaseSize();
		}
	}

	/**
	 * 得到List 在缓存中的最大Page No
	 * 
	 * @return
	 */
	public long getMaxSectionNo() {
		if (null != info) {
			return (info.getSize() - 1) / Constants.SecCapacity;
		} else {
			return -1;
		}
	}

	public long getNewMaxSectionNo() {
		if (null != info) {
			return (info.getSize() - 1 + 1) / Constants.SecCapacity;
		} else {
			return 0;
		}
	}

	/**
	 * 得到List，在缓存中最新一页所存放的数量,最新一页的容量可能不可能为0
	 */
	public Long getLatestSecSize() {
		long sectionSize = 0;
		if (null != info) {
			if (info.getSize() > 0) {
				if (isLatestSecVisited()) {
					sectionSize = info.getSections().get(getMaxSectionNo());
				} else {
					sectionSize = info.getSize();
					Iterator iter = info.getSections().keySet().iterator();
					while (iter.hasNext()) {
						sectionSize = sectionSize
								- info.getSections().get((Long) iter.next())
										.intValue();
					}
					sectionSize = sectionSize % Constants.SecCapacity;
					if (0 == sectionSize) {
						sectionSize = Constants.SecCapacity;
					}
				}
			}
		}
		return new Long(sectionSize);
	}

	/**
	 * 用来判断是否需要把整个List的缓存清空
	 * 
	 */
	public boolean isSectionsReBuild() {
		boolean res = false;
		if (null != info) {
			if (info.getSize() > 0) {
				// 重要逻辑：此处 totalDeleteCnt 被赋值为 1，而非 0 ,即看预减 1 的效果;
				int totalDeleteCnt = 1;
				if (null != info.getSections() && info.getSections().size() > 0) {
					try {
						Iterator iter = info.getSections().keySet().iterator();
						while (iter.hasNext()) {
							Long sectionSize = info.getSections().get((Long) iter.next());
							totalDeleteCnt += (Constants.SecCapacity - sectionSize.intValue());
							if (totalDeleteCnt >= Constants.SecCapacity) {
								res = true;
								break;
							}
						}
						// 重要逻辑：最新一页可能没有访问过，但其容量可能不是标准容量
						if (!isLatestSecVisited()) {
							totalDeleteCnt += (Constants.SecCapacity - getLatestSecSize().intValue());
							if (totalDeleteCnt >= Constants.SecCapacity) {
								res = true;
							}
						}
						if (res) {
							if (1 == getLatestSecSize()&& totalDeleteCnt == Constants.SecCapacity) {
								res = false;
							}
						}
					} 
					catch (Exception e) {
                       LogHelper.errorWhenJudgeListRebuild(log, info, e);
					}
				}
			}
		}
		return res;
	}

	/**
	 * 得到List所对应的缓存中的某一段缓存，应该从数据库中那个位置开始加载
	 * 
	 * @param sectionNo
	 * @return
	 * @throws Exception
	 */
	public Long getSectionIndex(Long sectionNo) throws Exception {
		long startIndex = -1;
		if (null != info) {
			if (getMaxSectionNo() < sectionNo.intValue()) {
				log.warn("Error: Current Max page No is :" + getMaxSectionNo()
						+ ",so section :" + sectionNo + " doesn't exist \r\n");
				return null;
			}
			startIndex = 0;
			for (int i = 0; i < sectionNo; i++) {
				Long sectionCnt = null;
				sectionCnt = info.getSections().get(new Long(i));
				if (null == sectionCnt) {
					startIndex += Constants.SecCapacity;
				} else {
					startIndex += sectionCnt.intValue();
				}
			}
		
			//为了增加Feed的性能，反向读取DB,以装载Section，所需的逻辑
			startIndex = getSize() -(startIndex + getSectionSize(sectionNo));
		}
		return new Long(startIndex);
	}

	/**
	 * 得到最新一页应该从数据库中那个位置加载的快捷方式
	 * 
	 * @return
	 * @throws Exception
	 */
	public Long getLatestSecIndex() throws Exception {
		Long no = getMaxSectionNo();
		return getSectionIndex(no);
	}

	/**
	 * 得到应该从那个缓存分段的，那个位置开始加载
	 * 这里其实有很巧妙的思想 ，需要细细品味。forward的值，即true或false,其实仅影响待加载的第一个id,在整个list的位置。
	 * 
	 * @return ListLoadInfo :记录待加载的第一个id,在整个List中的那个section,及该section的那个位置
	 * @throws Exception
	 */
	public ListLoadInfo getListLoadInfo(Long start, boolean forward)throws Exception {
		ListLoadInfo listLoadInfo = null;
		long realNo = -1;
		if (forward) {
			realNo = info.getSize() - start.intValue() - 1;
		} else {
			realNo = start.intValue();
		}
		for (long i = 0l; i <= getMaxSectionNo(); i++) {
			long sectionSize = getSectionSize(i);
			if (realNo >= sectionSize) {
				realNo = realNo - sectionSize;
			} else {
				listLoadInfo = new ListLoadInfo(i, realNo);
				break;
			}
		}
		return listLoadInfo;
	}

	/**
	 * 返回用户访问过的缓存分段信息
	 */
	public Map<Long, Long> getVisitedSections() {
		return info.getSections();
	}

	/**
	 * 返回当前List的容量
	 * 
	 * @return
	 */
	public long getSize() {
		return info.getSize();
	}
	
	
	
	/**
	 * 跨库聚合情况下，每个section 所对应的min,max值
	 */
	public Number[] getMinMaxOfCross(Long sectionNo){
		if(null == info || null == info.getMaxMins()){
			return null;
		}
		return info.getMaxMins().get(sectionNo);
	}
  
	//2009-6-23新增的方法
	public void setSize(long sizeNum){
		if(null != info){
			info.setSize(sizeNum);
		}
	}
	
	public void removeLastedVisitedSection(){
		 if(null != info){
			 info.getSections().remove(getMaxSectionNo()); 
		 }
		
	}

}
