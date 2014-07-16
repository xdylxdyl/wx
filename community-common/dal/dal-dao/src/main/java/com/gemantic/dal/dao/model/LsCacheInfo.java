package com.gemantic.dal.dao.model;

import org.apache.commons.lang.StringUtils;

import com.gemantic.dal.config.helper.DaoHelper;
import com.gemantic.dal.config.model.dao.ListItem;
import com.gemantic.dal.dao.util.DalAssert;


public class LsCacheInfo {

    private String region;
    private Object[] params;
    private String key;
    
    //从dal-1.0.6开始，缓存中不再存储ListInfo对象，而是分开存储Count和visiteInfoKey
    private String countKey;
    private String visitInfoKey; 
    
    private Object[] orderByParams;       
    private String orderByKey;
    
    //@todo 下次重构后，该方法可以取消 -----List的类型，
    private Integer type;
    
    public boolean isInvalidOnSave() {
		return invalidOnSave;
	}

	public void setInvalidOnSave(boolean invalidOnSave) {
		this.invalidOnSave = invalidOnSave;
	}

	private boolean invalidOnSave = false;
    

    public LsCacheInfo(String reg,Object[] parameters) {
        region = reg;
        params = parameters;
        key = getKeyByParams();
    }
    
    public LsCacheInfo(String reg,Object[] parameters,Integer lsType) {
        region = reg;
        params = parameters;
        key = getKeyByParams();
        type = lsType;
    }
    public LsCacheInfo(String reg,Object[] parameters,Object[] orderParams) {
        region = reg;
        params = parameters;
        key = getKeyByParams();
        orderByParams = orderParams;
        orderByKey = getOrderByKeyByOrderByParams();
    }
    
    public LsCacheInfo(String reg,Object[] parameters,Object[] orderParams,Integer lsType,boolean whetherInvalid) {
        region = reg;
        params = parameters;
        key = getKeyByParams();
        orderByParams = orderParams;
        orderByKey = getOrderByKeyByOrderByParams();
        type = lsType;
        invalidOnSave = whetherInvalid;
    }
    
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getKey() {
    	if(null == key){
    		key = getKeyByParams();
    	}
        return key;
    }

    public String getListCntKey(){
    	return getKey()+"#C";
    }
    public String getListVisitInfoKey(){
    	return getKey()+"#M";
    }
    
    private String getKeyByParams() {
        if (null == params || params.length < 1) {
            return "";
        }
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < params.length; i++) {
            strBuf.append(params[i]);
            if (i != params.length - 1) {
                strBuf.append("_");
            }
        }
        return strBuf.toString();
    }
    
    private String getOrderByKeyByOrderByParams() {
        if (null == orderByParams || orderByParams.length < 1) {
            return "";
        }
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < orderByParams.length; i++) {
            strBuf.append(orderByParams[i]);
            if (i != orderByParams.length - 1) {
                strBuf.append("_");
            }
        }
        return strBuf.toString();
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Object[] getOrderByParams() {
		return orderByParams;
	}

	public void setOrderByParams(Object[] orderByParams) {
		this.orderByParams = orderByParams;
	}

	public String getOrderByKey() {
		if(null == orderByKey){
			orderByKey = getOrderByKeyByOrderByParams();
		}
		return orderByKey;
	}

	public void setOrderByKey(String orderByKey) {
		this.orderByKey = orderByKey;
	}


}
