/**
 * 
 */
package com.gemantic.commons.code.cmodel;

import java.util.List;

public class DocContentConfigSheetModel {

	private String artifactId;

	private List<CReference> referenceList;

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public List<CReference> getReferenceList() {
		return referenceList;
	}

	public void setReferenceList(List<CReference> referenceList) {
		this.referenceList = referenceList;
	}
}
