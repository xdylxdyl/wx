/**
 * 
 */
package com.gemantic.commons.code.cmodel;

public class DocTagPosModel {

	public static final String TAG_ARTIFACT_ID = "artifactID";

	public static final String TAG_REFERENCES = "references";

	public static final String TAG_TABLE_NAME = "tableName";

	public static final String TAG_TABLE_FIELD = "tableField";

	public static final String TAG_TABLE_INDEX = "tableIndex";

	public static final String TAG_SQL = "sql";

	public static final String TAG_CONSTANT = "constant";

	public static final String TAG_SERVICE_PORT = "servicePort";

	public static final String TAG_CONTROLLER_URL = "url";

	public static final String TAG_CONTROLLER_METHOD_NAME = "methodName";

	public static final String TAG_CONTROLLER_RETURN_PATH = "returnPath";

	public static final String TAG_CONTROLLER_PARAMS = "params";

	public static final String TAG_CONTROLLER_REFERENCE_TABLE = "referenceTable";

	String tagName = null;

	int start = 0;

	int end = 0;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
