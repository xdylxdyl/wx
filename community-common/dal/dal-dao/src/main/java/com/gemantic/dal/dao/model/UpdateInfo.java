package com.gemantic.dal.dao.model;

import java.util.List;
import java.util.Map;

import com.gemantic.dal.dao.helper.LsCacheInfoHelper;

/**
 * 相当于在Update之前，对当时的情景做了一个镜像，以便在更新数据库成功后，依照这个镜像做出相应的处理
 * 
 * 背后的原理： 随着数据库更新的成功，数据库的环境发生了变化，无法根据次数数据库的状态，做出相应的更新动作
 * @author arthurkang
 *
 */
public class UpdateInfo {
	
    //================================ 读写分离 情况下需要的数据 ====================================
    /**
     *  < 旧 List > 信息
     *  
     *  详述：在更新之前， 《旧对象》所属的《旧List》的信息，在更新成功后，在《读写分离》的情况下，需要从《旧List》中把《旧对象》 删除
     */
	private List<SectionInfo> oldObjListSections;
	
	/**
	 *  < 新 List >信息
	 * 
	 *  详述： 在更新成功之后，《新对象》所属的 《新List》的信息，在更新成功后，在《读写分离》的情况下，需要将该《新List》从缓存中输出，并重新加载，直到加载到包含该《新对象》的Section
	 *  注：虽然此处引出一个《新List》的概念，但该List可能在对象的更新之前已经存在在缓存中
	 *  
	 *  String --- List 所对应的Region
	 *  LsCacheInfoHelper --- <新List>的详细信息
	 */
	private Map<String, LsCacheInfoHelper> newLsMap;
	
	// ================================ 非读写分离 情况下需要的数据 ===================================
	
	/**
	 * <新/旧 List> 信息
	 * 
	 * 信息： 因对象变更，导致数据发生变化的List的ListInfo信息
	 * 
	 */
	private Map<String,LsCacheInfoHelper[]> changedLsHelpers;

	
	public UpdateInfo(Map<String,LsCacheInfoHelper[]> lsHelpers,List<SectionInfo> oldObjListSections,Map<String, LsCacheInfoHelper> lsMap) {
		this.oldObjListSections = oldObjListSections;
		this.changedLsHelpers = lsHelpers;
		this.newLsMap = lsMap;
	}
	
	public List<SectionInfo> getOldObjListSections() {
		return oldObjListSections;
	}
	public void setOldObjListSections(List<SectionInfo> oldObjListSections) {
		this.oldObjListSections = oldObjListSections;
	}

	public Map<String, LsCacheInfoHelper> getNewLsMap() {
		return newLsMap;
	}

	public void setNewLsMap(Map<String, LsCacheInfoHelper> newLsMap) {
		this.newLsMap = newLsMap;
	}

	public Map<String, LsCacheInfoHelper[]> getChangedLsHelpers() {
		return changedLsHelpers;
	}

	public void setChangedLsHelpers(
			Map<String, LsCacheInfoHelper[]> changedLsHelpers) {
		this.changedLsHelpers = changedLsHelpers;
	}

	
}
