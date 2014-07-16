package com.gemantic.dal.dao.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListInfo implements Serializable {

    private static Log log = LogFactory.getLog(ListInfo.class);
    
    private Map< Long, Long > sections;
    
    //跨库聚合时使用该功能
    private Map< Long,Number[]>  minMaxs;

    private Long size;

    public ListInfo() {
        sections = new HashMap<  Long, Long  >();
        minMaxs = new HashMap<Long,Number[]>();
        size = 0l;
    }

    public ListInfo(Long totalCnt) {
        sections = new HashMap< Long, Long  >();
        minMaxs = new HashMap<Long,Number[]>();
        size = totalCnt;
    }

    public ListInfo(Long totalCnt,Map<Long,Long> secs){
    	size = totalCnt;
    	sections = secs;
    	minMaxs = new HashMap<Long,Number[]>();
    }
    public Map< Long, Long > getSections() {
        if (null == sections) {
            sections = new HashMap< Long, Long >();
        }
        return sections;
    }

    public Map< Long,Number[]> getMaxMins(){
    	if(null == minMaxs){
    		minMaxs = new HashMap<Long, Number[]>();
    	}
    	return minMaxs;
    }
    public void setSections(Map<  Long, Long  > secs) {
        sections = secs;
    }

    public long getSize() {
        if (null == size) {
            return 0;
        } else {
            return size.longValue();
        }
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void decreaseSize() {
        if (null != size) {
            size = new Long(size.longValue() - 1);
//            if(log.isDebugEnabled()){
//                log.debug(Messages.getString("ListInfo.0")+size+Messages.getString("ListInfo.1")); //$NON-NLS-1$ //$NON-NLS-2$
//            }
        }
        else{
           log.error("\r\n List 's size is null \r\n");
        }
    }

    public void increaseSize() {
        if (null != size) {
            size = new Long(size.longValue() + 1);
        } else {
//            log.warn(Messages.getString("ListInfo.3")); //$NON-NLS-1$
            size = 1l;
        }
    }
}
