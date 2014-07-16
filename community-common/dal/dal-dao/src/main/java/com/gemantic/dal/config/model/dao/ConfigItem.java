package com.gemantic.dal.config.model.dao;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.gemantic.dal.config.model.method.ItemMethod;

public class ConfigItem implements ItemMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183897728181570480L;


	private String path;


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public Method[] getKeyMethod() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
