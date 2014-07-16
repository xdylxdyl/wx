package com.gemantic.dal.id.util;

/**
 * @author arthurkang
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.gemantic.dal.config.helper.GroupHelper;
import com.gemantic.dal.dao.exception.DaoException;
import com.gemantic.dal.dao.util.Constants;
import com.gemantic.dal.id.dao.SequenceDao;
import com.gemantic.dal.id.util.SerializeUtil;
import com.gemantic.dal.dao.util.*;

public class SequenceService {

    private Log log = LogFactory.getLog(SequenceService.class);

    protected SequenceDao dao;;
    private static SequenceService service;
    protected Map< String, ConcurrentLinkedQueue< Long >> queueMap;
    protected ConcurrentHashMap< String, Integer> spanMap; 

    /**
     * 根据应用初始化Dao
     */
    private SequenceService() {
        dao = new SequenceDao(GroupHelper.getDataSource(IdCenterHelper.getIDCenterDataSourceName()));
        queueMap = new HashMap< String, ConcurrentLinkedQueue< Long >>();
        spanMap  = new ConcurrentHashMap<String, Integer>();
    }

    /**
     * @return 单例模式创建一个SequenceService
     */
    public static SequenceService getInstance() {
        if (null == service) {
            synchronized (SequenceService.class) {
                if (null == service) {
                    service = new SequenceService();
                }
            }
        }
        return service;
    }

    /**
     * 暴露给外面使用的接口，用于得到某个Sequence当前可用的id
     *
     * @return
     */
    public synchronized Long nextValue(String seqName) {
        if (null == seqName || StringUtils.isBlank(seqName)) {
            log.info("Attention: Sequence's name is null\r\n");
            return null;
        }
        ConcurrentLinkedQueue< Long > queue = getQueue(seqName);
          if (queue.isEmpty() ){
            Map< String, Long > ids = dao.getSeqIds(seqName);
            if (null != ids && ids.size() > 0) {
                Long minId = ids.get(Constants.MinId);
                Long maxId = ids.get(Constants.MaxId);
                if (log.isInfoEnabled()) {
                    log.info("MinId :" + minId);
                    log.info("MaxId :" + maxId);
                }
                if(minId.longValue() > maxId.longValue()){
                	log.error("config a illegal cache_count for the seq "+seqName);
                	return null;
                }
                if(minId.longValue() == maxId.longValue()){
                	queue.add(minId.longValue());
                }else{
	                for (long i = minId.longValue();;) {
	                	if(i > maxId.longValue()){
	                		break;
	                	}
	                    queue.add(new Long(i));
	                    i++;
	                }
                }
            } else {
                log.error("Error: Cant' get sequence : "+seqName+" from DB \r\n");
            }
        }
        Long returnId = null;
        returnId = queue.poll();
        if(null == returnId){
            log.error("Error : Failed to get sequence :"+seqName+" from queue \r\n");
        }
        return returnId;
    }

    /**
     * 得到和某个sequence对应的 queue
     * 
     * @param sequence
     * @return
     */
    public ConcurrentLinkedQueue<Long> getQueue(String seqName) {
        ConcurrentLinkedQueue< Long > queue = queueMap.get(seqName);
        if (null == queue) {
                queue = new ConcurrentLinkedQueue< Long >();
                queueMap.put(seqName, queue);
        }
        return queue;
    }

}
