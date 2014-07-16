package com.gemantic.dal.dao.helper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ListItem;
import com.gemantic.dal.dao.model.LsCacheInfo;
import com.gemantic.dal.dao.util.Constants;

public class LsCacheInfoHelper {

	private LsCacheInfo lsInfo;
	
	private static Log log = LogFactory.getLog(LsCacheInfoHelper.class);
	
	public LsCacheInfoHelper(LsCacheInfo info){
		lsInfo = info;
	}
	public LsCacheInfoHelper(String region,Object[] params){
		lsInfo = new LsCacheInfo(region,params);
	}
	
	public String getRegion(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getRegion();
	}
	
	public Object[] getParams(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getParams();
	}
	
	public String getKey(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getKey();
	}
	
	public String getListCountKey(){
		 if(null == lsInfo){
			 return null;
		 }
		 return lsInfo.getListCntKey();
	}
	
	public String getListVisitInfoKey(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getListVisitInfoKey();
	}
	
	public Object[] getOrderByParams(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getOrderByParams();
	}
	
	public String getOrderByKey(){
		if(null == lsInfo){
			return null;
		}
		return lsInfo.getOrderByKey();
	}
	

    public String getIdListKey(Long sectionNo) {
        String listKey = null;
        if (!StringUtils.isBlank(lsInfo.getKey())) {
            listKey = lsInfo.getKey() +"%%"+ sectionNo.toString();
        }
        return listKey;
    }

    
   public Integer getType(){
	   return lsInfo.getType();
   }    
   
   public boolean isInvalidOnSave() {
	    if(null != lsInfo){
	    	return lsInfo.isInvalidOnSave();
	    }
	    else{
	    	return false;
	    }
	}
}
