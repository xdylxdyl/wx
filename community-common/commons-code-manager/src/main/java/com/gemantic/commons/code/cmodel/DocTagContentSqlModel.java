/**
 * 
 */
package com.gemantic.commons.code.cmodel;

public class DocTagContentSqlModel {

	private String sqlSentence;

	private String sqlResultType;

	private boolean needCountMethod = false;

	public String getSqlSentence() {
		return sqlSentence;
	}

	public void setSqlSentence(String sqlSentence) {
		this.sqlSentence = sqlSentence;
	}

	public String getSqlResultType() {
		return sqlResultType;
	}

	public void setSqlResultType(String sqlResultType) {
		this.sqlResultType = sqlResultType;
	}

	public boolean isNeedCountMethod() {
		return needCountMethod;
	}

	public void setNeedCountMethod(boolean needCountMethod) {
		this.needCountMethod = needCountMethod;
	}
}
