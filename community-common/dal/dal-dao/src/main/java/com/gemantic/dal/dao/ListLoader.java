package com.gemantic.dal.dao;

import java.util.List;

import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.model.SectionInfo;

/**
 * 将List的信息装载到缓存中
 * @author arthurkang
 *
 */
public interface ListLoader {
	
    /**
     * 
     * @param account_id
     * @param lsInfo
     * @param strategy
     * @param needLock
     * @return
     * @throws DaoException
     */
	public ListInfoHelper getListInfo(Object account_id,LsCacheInfoHelper lsInfo, int strategy,boolean needLock) throws DaoException;
	
	/**
	 * 
	 * @param lsInfo
	 * @param infoHelper
	 * @param account_id
	 * @param sectionNo
	 * @param strategy
	 * @param needLock  :当多个用户都需要加载一个List时，此时仅有一个用户可以加载成功，所以此时需要锁机制
	 *                   但是当对List进行 save/update/delete 操作时，不需要这种锁机制，因为他本身会锁定其他用户的加载动作
	 * @return
	 * @throws DaoException
	 */
	public List getSectionIdList(LsCacheInfoHelper lsInfo,ListInfoHelper infoHelper,Object account_id, Long sectionNo,int strategy,boolean needLock) throws DaoException; 
	
	public SectionInfo getUpdatedSection( Object account_id, Object obj,LsCacheInfoHelper lsHelper) throws Exception;
	
	public void removeIdFromList(Object account_id, Object obj,SectionInfo secInfo, boolean bReload) throws Exception;

}
