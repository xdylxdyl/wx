/**
 * 
 */
package com.gemantic.commons.code.cmodel;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

public class DocContentDBServiceSheetModel {

	private String tableName;

	private List<DocTagContentTableFieldModel> tableFieldContents;

	private List<String> indexs;

	private List<DocTagContentSqlModel> sqls;

	private List<DocTagContentConstantModel> constants;

	private String servicePort;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<DocTagContentTableFieldModel> getTableFieldContents() {
		return tableFieldContents;
	}

	public void setTableFieldContents(List<DocTagContentTableFieldModel> tableFieldContents) {
		this.tableFieldContents = tableFieldContents;
	}

	public List<String> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<String> indexs) {
		this.indexs = indexs;
	}

	public List<DocTagContentSqlModel> getSqls() {
		return sqls;
	}

	public void setSqls(List<DocTagContentSqlModel> sqls) {
		this.sqls = sqls;
	}

	public List<DocTagContentConstantModel> getConstants() {
		return constants;
	}

	public void setConstants(List<DocTagContentConstantModel> constants) {
		this.constants = constants;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public boolean isEmpty() {
		boolean result = false;

		boolean isTableNameEmpty = StringUtils.isBlank(tableName);
		boolean isTableFieldContentsEmpty = CollectionUtils.isEmpty(tableFieldContents);
		boolean isIndexsEmpty = CollectionUtils.isEmpty(indexs);
		boolean isSqlsEmpty = CollectionUtils.isEmpty(sqls);
		boolean isConstantsEmpty = CollectionUtils.isEmpty(constants);
		boolean isServicePortEmpty = StringUtils.isBlank(servicePort);

		if (isTableNameEmpty && isTableFieldContentsEmpty && isIndexsEmpty && isSqlsEmpty && isConstantsEmpty && isServicePortEmpty) {
			result = true;
		}

		return result;
	}
}
