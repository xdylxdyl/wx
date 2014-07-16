/**
 * 
 */
package com.gemantic.commons.code.manager;

import com.gemantic.commons.code.cmodel.CProject;

public interface DesignDocParser {
	public CProject parseDesignDoc(String docPath) throws Exception;
	
	
}
