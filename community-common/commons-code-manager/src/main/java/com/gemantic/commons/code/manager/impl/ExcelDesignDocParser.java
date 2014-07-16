/**
 * 
 */
package com.gemantic.commons.code.manager.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.gemantic.common.exception.ServiceException;
import com.gemantic.commons.code.cmodel.CConstant;
import com.gemantic.commons.code.cmodel.CController;
import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CReference;
import com.gemantic.commons.code.cmodel.CRequest;
import com.gemantic.commons.code.cmodel.DocContentConfigSheetModel;
import com.gemantic.commons.code.cmodel.DocContentControllerSheetModel;
import com.gemantic.commons.code.cmodel.DocContentDBServiceSheetModel;
import com.gemantic.commons.code.cmodel.DocTagContentConstantModel;
import com.gemantic.commons.code.cmodel.DocTagContentSqlModel;
import com.gemantic.commons.code.cmodel.DocTagContentTableFieldModel;
import com.gemantic.commons.code.cmodel.DocTagPosConfigSheetModel;
import com.gemantic.commons.code.cmodel.DocTagPosControllerSheetModel;
import com.gemantic.commons.code.cmodel.DocTagPosDBServiceSheetModel;
import com.gemantic.commons.code.cmodel.DocTagPosModel;
import com.gemantic.commons.code.manager.DesignDocParser;
import com.gemantic.commons.code.util.CProjectUtil;

@Component("excelDesignDocParser")
public class ExcelDesignDocParser implements DesignDocParser {

	private static final Log log = LogFactory
			.getLog(ExcelDesignDocParser.class);

	
	public CProject parseDesignDoc(String docPath) throws Exception {
		CProject cProject = new CProject();

		// excel book
		Workbook wb = initExcelWorkbook(docPath);

		if (wb == null) {
			return null;
		}

		int sheetNum = wb.getNumberOfSheets();
		if (sheetNum < 1) {
			return null;
		}

		// 取得config sheet中的内容
		Sheet configSheet = wb.getSheetAt(0);
		DocContentConfigSheetModel configSheetContent = parseConfigSheet(configSheet);

		// config sheet中 ArtifactID
		String artifactID = configSheetContent.getArtifactId();
		cProject.setArtifactID(artifactID);

		// config sheet中 references
		List<CReference> referenceList = configSheetContent.getReferenceList();
		cProject.setReferences(referenceList);

		// 代码生成工具需要的CMold List (多个表对应多个model,所以是list)
		List<CMold> cMoldList = new ArrayList<CMold>();

		// 代码生成工具需要的List<CController>
		List<CController> cControllerList = new ArrayList<CController>();

		// 如果有多个数据表,需要写多个数据表的设计sheet(同时可能有多个controller的sheet)
		// controller or DBService sheets
		for (int sheetCounter = 1; sheetCounter < sheetNum; sheetCounter++) {
			// excel sheet
			Sheet sheet = wb.getSheetAt(sheetCounter);
			// sheet name
			String sheetName = sheet.getSheetName();
			if (StringUtils.isBlank(sheetName)) {
				continue;
			}

			if (sheetName.startsWith("tbl_")) {
				// 取得DB service sheet 中的内容
				DocContentDBServiceSheetModel dbServiceSheetContent = parseDBServiceSheet(sheet);

				// 不是DB service sheet则跳过
				if (dbServiceSheetContent.isEmpty()) {
					continue;
				}

				// 转换为代码生成工具需要的CMold
				CMold cMold = convertDocContentDBServiceSheetModelToCMold(dbServiceSheetContent);
				if (cMold != null) {
					cMoldList.add(cMold);
				}

			} else if (sheetName.startsWith("ctr_")) {

				// 取得controller sheet中的内容
				DocContentControllerSheetModel controllerSheetContent = parseControllerSheet(sheet);

				Map<String, CMold> cMoldMap = convertCmoldList2Map(cMoldList);

				// 转换为代码生成工具需要的List<CController>
				List<CController> cControllers = convertDocContentControllerSheetModelToCControllerList(
						controllerSheetContent, cMoldMap);
				if (CollectionUtils.isNotEmpty(cControllers)) {
					for (CController cController : cControllers) {
						if (cController == null) {
							continue;
						}

						cControllerList.add(cController);
					}
				}
			}

		}

		cProject.setMolds(cMoldList);
		cProject.setControllers(cControllerList);

		// should be here?
		CProjectUtil.init(cProject);

		return cProject;
	}

	/**
	 * 把excel中 db service sheet中的内容转换为代码生成工具需要的CMold
	 * 
	 * @param dbServiceSheetContent
	 * @return
	 */
	private CMold convertDocContentDBServiceSheetModelToCMold(
			DocContentDBServiceSheetModel dbServiceSheetContent) {

		// 表名
		String tableName = dbServiceSheetContent.getTableName();
		// 端口号
		String servicePort = dbServiceSheetContent.getServicePort();

		List<DocTagContentTableFieldModel> tableFieldContents = dbServiceSheetContent
				.getTableFieldContents();
		List<DocTagContentSqlModel> sqls = dbServiceSheetContent.getSqls();
		List<DocTagContentConstantModel> constants = dbServiceSheetContent
				.getConstants();

		// 配置java对应的数据库表的model (CField List)
		List<CField> cFieldList = new ArrayList<CField>();
		if (CollectionUtils.isNotEmpty(tableFieldContents)) {
			for (DocTagContentTableFieldModel docTagContentTableField : tableFieldContents) {
				CField cField = convertDocTagContentTableFieldModelToCField(docTagContentTableField);
				if (cField != null) {
					cFieldList.add(cField);
				}
			}
		}

		// 配置SQL文
		List<String> sqlList = new ArrayList<String>();
		Map<String, String> sqlKeyDalTypeValueMap = new HashMap<String, String>();
		
		if (CollectionUtils.isNotEmpty(sqls)) {
			for (DocTagContentSqlModel sqlContent : sqls) {
				// sql文
				String sqlSentence = sqlContent.getSqlSentence();
				// dal 返回值type (map or list)
				String sqlResultType = sqlContent.getSqlResultType();
				// 是否需要创建count方法
				boolean needCountMethod = sqlContent.isNeedCountMethod();
				log.info(sqlSentence +" create count method is "+needCountMethod);

				if (StringUtils.isNotBlank(sqlSentence)
						&& StringUtils.isNotBlank(sqlResultType)) {
					sqlList.add(sqlSentence);
					sqlKeyDalTypeValueMap.put(sqlSentence, sqlResultType);
				}

			
			}
		}

		// 配置常量
		List<CConstant> constantList = new ArrayList<CConstant>();
		if (CollectionUtils.isNotEmpty(constants)) {
			for (DocTagContentConstantModel constantContent : constants) {
				CConstant cConstant = convertDocTagContentConstantModelToCConstant(constantContent);
				if (cConstant != null) {
					constantList.add(cConstant);
				}
			}
		}

		// 构造并返回代码生成工具的CMold
		CMold cMold = new CMold();

		cMold.setTable(tableName);
		cMold.setPort(servicePort);
		cMold.setFields(cFieldList);
		cMold.setSqls(sqlList);
		cMold.setSql_typ(sqlKeyDalTypeValueMap);
		cMold.setConstants(constantList);
		

		return cMold;
	}

	/**
	 * 把excel中 db service sheet中的常量配置项中的内容转换为代码生成工具的CConstant
	 * 
	 * @param constantContent
	 * @return
	 */
	private CConstant convertDocTagContentConstantModelToCConstant(
			DocTagContentConstantModel constantContent) {
		if (constantContent == null) {
			return null;
		}

		String constantName = constantContent.getConstantName();
		String constantValue = constantContent.getConstantValue();
		String constantType = constantContent.getConstantType();
		String constantComment = constantContent.getConstantComment();

		CConstant cConstant = null;
		if (StringUtils.isNotBlank(constantName)
				&& StringUtils.isNotBlank(constantValue)
				&& StringUtils.isNotBlank(constantType)) {
			cConstant = new CConstant(constantType, constantName,
					constantValue, constantComment);
		}

		return cConstant;
	}

	/**
	 * 把excel中 db service sheet中的表字段配置项中的内容转换为代码生成工具的CField
	 * 
	 * @param docTagContentTableField
	 * @return
	 */
	private CField convertDocTagContentTableFieldModelToCField(
			DocTagContentTableFieldModel docTagContentTableField) {
		if (docTagContentTableField == null) {
			return null;
		}

		String columnName = docTagContentTableField.getColumnName();
		String columnType = docTagContentTableField.getColumnType();
		String columnJavaField = docTagContentTableField.getColumnJavaField();
		String columnJavaFieldType = docTagContentTableField
				.getColumnJavaFieldType();
		String mockValue1 = docTagContentTableField.getMockValue1();
		String mockValue2 = docTagContentTableField.getMockValue2();

		String columnNull = docTagContentTableField.getColumnNull();

		// 不配置JavaField, 则认为不需要在表对应的model里生成该列对应的字段
		if (StringUtils.isBlank(columnJavaField)
				|| StringUtils.isBlank(columnJavaFieldType)) {
			return null;
		}

		CField cField = new CField(columnJavaField, columnJavaFieldType,
				columnName, columnType, columnNull);
		cField.setComment(docTagContentTableField.getColumnComment());

		if (StringUtils.isNotBlank(mockValue1)
				&& StringUtils.isNotBlank(mockValue2)) {
			// 用于生成的单元测试中使用的mock值
			cField.addValue(mockValue1);
			cField.addValue(mockValue2);
		}

		return cField;
	}

	/**
	 * 取得指定路径和名称的excel文件
	 * 
	 * @param docPath
	 * @return
	 * @throws ServiceException
	 */
	private Workbook initExcelWorkbook(String docPath) throws ServiceException {
		if (StringUtils.isBlank(docPath)) {
			return null;
		}

		Workbook wb = null;
		POIFSFileSystem fs = null;
		InputStream inp = null;

		String fileName = ExcelDesignDocParser.class.getClassLoader()
				.getResource(docPath).getFile();
		try {
			if (isExcel2007(docPath)) {
				// 2007
				wb = new XSSFWorkbook(fileName);
			} else {
				// 2003
				File file = new File(fileName);

				inp = new FileInputStream(file);
				fs = new POIFSFileSystem(inp);

				wb = new HSSFWorkbook(fs);

				// 关闭流
				inp.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} finally {
			inp = null;
		}

		return wb;
	}

	/**
	 * 判断excel文件是2003版还是2007版
	 * 
	 * @param docPath
	 * @return
	 */
	private boolean isExcel2007(String docPath) {
		return docPath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 解析excel文档中的配置sheet
	 * 
	 * @param configSheet
	 * @return
	 */
	private DocContentConfigSheetModel parseConfigSheet(Sheet configSheet) {
		if (configSheet == null) {
			return null;
		}

		DocTagPosConfigSheetModel docTagPosConfigSheetModel = parseConfigSheetTagPos(configSheet);

		// artifactID tag start,end position
		DocTagPosModel artifactIDTagPos = null;
		// referenceTagPos tag start,end position
		DocTagPosModel referenceTagPos = null;
		if (docTagPosConfigSheetModel != null) {
			artifactIDTagPos = docTagPosConfigSheetModel.getArtifactIDTagPos();
			referenceTagPos = docTagPosConfigSheetModel.getReferenceTagPos();
		}

		// 取 ArtifactId 标签中的内容
		String artifactID = getSingleLineTagContent(configSheet,
				artifactIDTagPos);
		// 取 Reference 标签中的内容
		List<CReference> cReferenceList = getReferenceTagContent(configSheet,
				referenceTagPos);

		// 返回结果
		DocContentConfigSheetModel configSheetModel = new DocContentConfigSheetModel();
		configSheetModel.setArtifactId(artifactID);
		configSheetModel.setReferenceList(cReferenceList);

		return configSheetModel;
	}

	/**
	 * TODO 解析excel文档中的controller sheet
	 * 
	 * @param controllerSheet
	 * @return
	 */
	private DocContentControllerSheetModel parseControllerSheet(
			Sheet controllerSheet) {
		if (controllerSheet == null) {
			return null;
		}

		DocTagPosControllerSheetModel docTagPosControllerSheetModel = parseControllerSheetTagPos(controllerSheet);

		// url tag start,end position
		DocTagPosModel urlTagPos = null;
		// methodName tag start,end position
		DocTagPosModel methodNameTagPos = null;
		// returnPath start,end position
		DocTagPosModel returnPathTagPos = null;
		// params start,end position
		DocTagPosModel paramsTagPos = null;
		// referenceTable start,end position
		DocTagPosModel referenceTableTagPos = null;

		if (docTagPosControllerSheetModel != null) {
			urlTagPos = docTagPosControllerSheetModel.getUrlTagPos();
			methodNameTagPos = docTagPosControllerSheetModel
					.getMethodNameTagPos();
			returnPathTagPos = docTagPosControllerSheetModel
					.getReturnPathTagPos();
			paramsTagPos = docTagPosControllerSheetModel.getParamsTagPos();
			referenceTableTagPos = docTagPosControllerSheetModel
					.getReferenceTableTagPos();
		}

		// 取 url 标签中的内容
		String url = getSingleLineTagContent(controllerSheet, urlTagPos);
		// 取 methodName 标签中的内容
		String methodName = getSingleLineTagContent(controllerSheet,
				methodNameTagPos);
		// 取 returnPath 标签中的内容
		String returnPath = getSingleLineTagContent(controllerSheet,
				returnPathTagPos);
		// 取 params 标签中的内容
		List<CField> paramList = getParamsTagContent(controllerSheet,
				paramsTagPos);
		// 取 referenceTable 标签中的内容
		List<String> referenceTableList = getMultiLineTagContent(
				controllerSheet, referenceTableTagPos);

		// 返回结果
		DocContentControllerSheetModel controllerSheetModel = new DocContentControllerSheetModel();
		controllerSheetModel.setUrl(url);
		controllerSheetModel.setMethodName(methodName);
		controllerSheetModel.setReturnPath(returnPath);
		controllerSheetModel.setParamList(paramList);
		controllerSheetModel.setReferenceTableList(referenceTableList);

		return controllerSheetModel;
	}

	/**
	 * 解析excel文档中的DB service sheet
	 * 
	 * @param configSheet
	 * @return
	 */
	private DocContentDBServiceSheetModel parseDBServiceSheet(Sheet configSheet) {
		if (configSheet == null) {
			return null;
		}

		DocTagPosDBServiceSheetModel docTagPosDBServiceSheetModel = parseDBServiceSheetTagPos(configSheet);

		// tableName tag start,end position
		DocTagPosModel tableNameTagPos = null;
		// tableField tag start,end position
		DocTagPosModel tableFieldTagPos = null;
		// tableIndex tag start,end position
		DocTagPosModel tableIndexTagPos = null;
		// sql tag start,end position
		DocTagPosModel sqlTagPos = null;
		// constant tag start,end position
		DocTagPosModel constantTagPos = null;
		// servicePort tag start,end position
		DocTagPosModel servicePortTagPos = null;
		if (docTagPosDBServiceSheetModel != null) {
			tableNameTagPos = docTagPosDBServiceSheetModel.getTableNameTagPos();
			tableFieldTagPos = docTagPosDBServiceSheetModel
					.getTableFieldTagPos();
			tableIndexTagPos = docTagPosDBServiceSheetModel
					.getTableIndexTagPos();
			sqlTagPos = docTagPosDBServiceSheetModel.getSqlTagPos();
			constantTagPos = docTagPosDBServiceSheetModel.getConstantTagPos();
			servicePortTagPos = docTagPosDBServiceSheetModel
					.getServicePortTagPos();
		}

		// 取 tableName 标签中的内容
		String tableName = getSingleLineTagContent(configSheet, tableNameTagPos);
		// 取 tableField 标签中的内容
		List<DocTagContentTableFieldModel> tableFieldContents = getTableFieldTagContent(
				configSheet, tableFieldTagPos);
		// 取 tableIndex 标签中的内容
		List<String> indexs = getMultiLineTagContent(configSheet,
				tableIndexTagPos);
		// 取 sql 标签中的内容
		List<DocTagContentSqlModel> sqls = getSqlTagContent(configSheet,
				sqlTagPos);
		// 取 constant 标签中的内容
		List<DocTagContentConstantModel> constants = getConstantTagContent(
				configSheet, constantTagPos);
		// 取 servicePort 标签中的内容
		String servicePort = getSingleLineTagContent(configSheet,
				servicePortTagPos);

		DocContentDBServiceSheetModel docContentDBServiceSheetModel = new DocContentDBServiceSheetModel();
		docContentDBServiceSheetModel.setTableName(tableName);
		docContentDBServiceSheetModel.setTableFieldContents(tableFieldContents);
		docContentDBServiceSheetModel.setIndexs(indexs);
		docContentDBServiceSheetModel.setSqls(sqls);
		docContentDBServiceSheetModel.setConstants(constants);
		docContentDBServiceSheetModel.setServicePort(servicePort);

		return docContentDBServiceSheetModel;
	}

	/**
	 * 取得excel文档中的配置sheet中各配置项的起始,结束位置
	 * 
	 * @param configSheet
	 * @return
	 */
	private DocTagPosConfigSheetModel parseConfigSheetTagPos(Sheet configSheet) {
		if (configSheet == null) {
			return null;
		}

		DocTagPosModel artifactIDTagPos = new DocTagPosModel();
		DocTagPosModel referenceTagPos = new DocTagPosModel();

		DocTagPosConfigSheetModel configSheetTagPosModel = new DocTagPosConfigSheetModel();
		configSheetTagPosModel.setArtifactIDTagPos(artifactIDTagPos);
		configSheetTagPosModel.setReferenceTagPos(referenceTagPos);

		// 取得所有有效列
		int rowNum = configSheet.getLastRowNum();

		// 先取得不同配置标签的起始,结束行
		for (int i = 0; i <= rowNum; i++) {
			// excel row
			Row row = configSheet.getRow(i);
			// 取第一列
			// excel cell
			if (row == null || row.getLastCellNum() < 1) {
				continue;
			}
			Cell cell = row.getCell(0);
			String cellValue = getCellValue(cell);

			if ("ArtifactID(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				artifactIDTagPos.setTagName(DocTagPosModel.TAG_ARTIFACT_ID);
				// start position
				artifactIDTagPos.setStart(i);

			} else if ("ArtifactID(end)".equalsIgnoreCase(cellValue)) {
				artifactIDTagPos.setEnd(i);

			} else if ("references(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				referenceTagPos.setTagName(DocTagPosModel.TAG_REFERENCES);
				// start position
				referenceTagPos.setStart(i);

			} else if ("references(end)".equalsIgnoreCase(cellValue)) {
				referenceTagPos.setEnd(i);

			}
		}

		return configSheetTagPosModel;
	}

	/**
	 * 取得excel文档中的controller sheet中各配置项的起始,结束位置
	 * 
	 * @param controllerSheet
	 * @return
	 */
	private DocTagPosControllerSheetModel parseControllerSheetTagPos(
			Sheet controllerSheet) {
		if (controllerSheet == null) {
			return null;
		}

		DocTagPosModel urlTagPos = new DocTagPosModel();
		DocTagPosModel methodNameTagPos = new DocTagPosModel();
		DocTagPosModel returnPathTagPos = new DocTagPosModel();
		DocTagPosModel paramsTagPos = new DocTagPosModel();
		DocTagPosModel referenceTableTagPos = new DocTagPosModel();

		DocTagPosControllerSheetModel controllerSheetTagPosModel = new DocTagPosControllerSheetModel();
		controllerSheetTagPosModel.setUrlTagPos(urlTagPos);
		controllerSheetTagPosModel.setMethodNameTagPos(methodNameTagPos);
		controllerSheetTagPosModel.setReturnPathTagPos(returnPathTagPos);
		controllerSheetTagPosModel.setParamsTagPos(paramsTagPos);
		controllerSheetTagPosModel
				.setReferenceTableTagPos(referenceTableTagPos);

		// 取得所有有效列
		int rowNum = controllerSheet.getLastRowNum();

		// 先取得不同配置标签的起始,结束行
		for (int i = 0; i <= rowNum; i++) {
			// excel row
			Row row = controllerSheet.getRow(i);
			// 取第一列
			// excel cell
			if (row == null || row.getLastCellNum() < 1) {
				continue;
			}
			Cell cell = row.getCell(0);
			String cellValue = getCellValue(cell);

			if ("url(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				urlTagPos.setTagName(DocTagPosModel.TAG_CONTROLLER_URL);
				// start position
				urlTagPos.setStart(i);

			} else if ("url(end)".equalsIgnoreCase(cellValue)) {
				urlTagPos.setEnd(i);

			} else if ("methodName(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				methodNameTagPos
						.setTagName(DocTagPosModel.TAG_CONTROLLER_METHOD_NAME);
				// start position
				methodNameTagPos.setStart(i);

			} else if ("methodName(end)".equalsIgnoreCase(cellValue)) {
				methodNameTagPos.setEnd(i);

			} else if ("returnPath(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				returnPathTagPos
						.setTagName(DocTagPosModel.TAG_CONTROLLER_RETURN_PATH);
				// start position
				returnPathTagPos.setStart(i);

			} else if ("returnPath(end)".equalsIgnoreCase(cellValue)) {
				returnPathTagPos.setEnd(i);

			} else if ("params(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				paramsTagPos.setTagName(DocTagPosModel.TAG_CONTROLLER_PARAMS);
				// start position
				paramsTagPos.setStart(i);

			} else if ("params(end)".equalsIgnoreCase(cellValue)) {
				paramsTagPos.setEnd(i);

			} else if ("referenceTable(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				referenceTableTagPos
						.setTagName(DocTagPosModel.TAG_CONTROLLER_REFERENCE_TABLE);
				// start position
				referenceTableTagPos.setStart(i);

			} else if ("referenceTable(end)".equalsIgnoreCase(cellValue)) {
				referenceTableTagPos.setEnd(i);

			}
		}

		return controllerSheetTagPosModel;
	}

	/**
	 * 取得excel文档中的DBService sheet中各配置项的起始,结束位置
	 * 
	 * @param dbServiceSheet
	 * @return
	 */
	private DocTagPosDBServiceSheetModel parseDBServiceSheetTagPos(
			Sheet dbServiceSheet) {

		if (dbServiceSheet == null) {
			return null;
		}

		DocTagPosModel tableNameTagPos = new DocTagPosModel();
		DocTagPosModel tableFieldTagPos = new DocTagPosModel();
		DocTagPosModel tableIndexTagPos = new DocTagPosModel();
		DocTagPosModel sqlTagPos = new DocTagPosModel();
		DocTagPosModel constantTagPos = new DocTagPosModel();
		DocTagPosModel servicePortTagPos = new DocTagPosModel();

		DocTagPosDBServiceSheetModel dBServiceSheetTagPosModel = new DocTagPosDBServiceSheetModel();
		dBServiceSheetTagPosModel.setTableNameTagPos(tableNameTagPos);
		dBServiceSheetTagPosModel.setTableFieldTagPos(tableFieldTagPos);
		dBServiceSheetTagPosModel.setTableIndexTagPos(tableIndexTagPos);
		dBServiceSheetTagPosModel.setSqlTagPos(sqlTagPos);
		dBServiceSheetTagPosModel.setConstantTagPos(constantTagPos);
		dBServiceSheetTagPosModel.setServicePortTagPos(servicePortTagPos);

		// 取得所有有效列
		int rowNum = dbServiceSheet.getLastRowNum();

		// 先取得不同配置标签的起始,结束行
		for (int i = 0; i <= rowNum; i++) {
			// excel row
			Row row = dbServiceSheet.getRow(i);
			// 取第一列
			// excel cell
			if (row == null || row.getLastCellNum() < 1) {
				continue;
			}
			Cell cell = row.getCell(0);
			String cellValue = getCellValue(cell);

			if ("表名(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				tableNameTagPos.setTagName(DocTagPosModel.TAG_TABLE_NAME);
				// start position
				tableNameTagPos.setStart(i);

			} else if ("表名(end)".equalsIgnoreCase(cellValue)) {
				tableNameTagPos.setEnd(i);

			} else if ("表字段(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				tableFieldTagPos.setTagName(DocTagPosModel.TAG_TABLE_FIELD);
				// start position
				tableFieldTagPos.setStart(i);

			} else if ("表字段(end)".equalsIgnoreCase(cellValue)) {
				tableFieldTagPos.setEnd(i);

			} else if ("索引(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				tableIndexTagPos.setTagName(DocTagPosModel.TAG_TABLE_INDEX);
				// start position
				tableIndexTagPos.setStart(i);

			} else if ("索引(end)".equalsIgnoreCase(cellValue)) {
				tableIndexTagPos.setEnd(i);

			} else if ("SQL文(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				sqlTagPos.setTagName(DocTagPosModel.TAG_SQL);
				// start position
				sqlTagPos.setStart(i);

			} else if ("SQL文(end)".equalsIgnoreCase(cellValue)) {
				sqlTagPos.setEnd(i);

			} else if ("常量(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				constantTagPos.setTagName(DocTagPosModel.TAG_CONSTANT);
				// start position
				constantTagPos.setStart(i);

			} else if ("常量(end)".equalsIgnoreCase(cellValue)) {
				constantTagPos.setEnd(i);

			} else if ("service端口(begin)".equalsIgnoreCase(cellValue)) {
				// excel doc tag name
				servicePortTagPos.setTagName(DocTagPosModel.TAG_SERVICE_PORT);
				// start position
				servicePortTagPos.setStart(i);

			} else if ("service端口(end)".equalsIgnoreCase(cellValue)) {
				servicePortTagPos.setEnd(i);
			}
		}

		return dBServiceSheetTagPosModel;
	}

	// /**
	// * 获取ArtifactId标签中的内容
	// *
	// * @param configSheet
	// * @param artifactIDTagPos
	// * @return
	// */
	// private String getArtifactIdTagContent(Sheet configSheet, DocTagPosModel
	// artifactIDTagPos) {
	//
	// String artifactId = null;
	//
	// int start = artifactIDTagPos.getStart();
	// int end = artifactIDTagPos.getEnd();
	//
	// // tag差一行,所以差2行以上才有数据
	// if ((end - start) < 2) {
	// return "";
	// }
	//
	// out:
	// for (int i = start + 1; i < end; i++) {
	// // excel cell
	// Row row = configSheet.getRow(i);
	//
	// if (row == null) {
	// continue;
	// }
	//
	// int cellNum = row.getLastCellNum();
	// // 取到artifactId则停止,否则遍历artifactId tag段所有的row和cell
	// for (int cellCounter = 0; cellCounter < cellNum; cellCounter++) {
	// // excel cell
	// Cell cell = row.getCell(cellCounter);
	// // artifactId
	// artifactId = getCellValue(cell);
	//
	// if (StringUtils.isNotBlank(artifactId)) {
	// break out;
	// }
	// }
	// }
	//
	// return artifactId;
	// }

	/**
	 * 获取Reference标签中的内容
	 * 
	 * @param configSheet
	 * @param referenceTagPos
	 * @return
	 */
	private List<CReference> getReferenceTagContent(Sheet configSheet,
			DocTagPosModel referenceTagPos) {

		List<CReference> referenceList = new ArrayList<CReference>();

		int start = referenceTagPos.getStart();
		int end = referenceTagPos.getEnd();

		// tag差一行,title占一行,所以差3行以上才有数据
		if ((end - start) < 3) {
			return referenceList;
		}

		for (int i = start + 2; i < end; i++) {
			// excel cell
			Row row = configSheet.getRow(i);

			if (row == null) {
				continue;
			}

			// SERVICE NAME
			String serviceName = getCellValue(row.getCell(0));
			// SERVICE PACKAGE
			String servicePackage = getCellValue(row.getCell(1));
			// RMI RESOURCE NAME
			String rmiResourceName = getCellValue(row.getCell(2));
			// RMI SERVICE NAME
			String rmiServiceName = getCellValue(row.getCell(3));

			boolean isServiceNameBlank = StringUtils.isBlank(serviceName);
			boolean isServicePackageBlank = StringUtils.isBlank(servicePackage);
			boolean isRmiResourceNameBlank = StringUtils
					.isBlank(rmiResourceName);
			boolean isRmiServiceNameBlank = StringUtils.isBlank(rmiServiceName);

			if (isServiceNameBlank || isServicePackageBlank
					|| isRmiResourceNameBlank || isRmiServiceNameBlank) {
				continue;
			}

			CReference reference = new CReference(serviceName, servicePackage,
					rmiResourceName, rmiServiceName);
			referenceList.add(reference);
		}

		return referenceList;
	}

	/**
	 * 获取单行标签中的内容
	 * 
	 * @param sheet
	 * @param tagPos
	 * @return
	 */
	private String getSingleLineTagContent(Sheet sheet, DocTagPosModel tagPos) {

		String result = null;

		int start = tagPos.getStart();
		int end = tagPos.getEnd();

		// tag差一行,所以差2行以上才有数据
		if ((end - start) < 2) {
			return "";
		}

		out: for (int i = start + 1; i < end; i++) {
			// excel cell
			Row row = sheet.getRow(i);

			if (row == null) {
				continue;
			}

			int cellNum = row.getLastCellNum();
			// 取到内容则停止,否则遍历tag段所有的row和cell
			for (int cellCounter = 0; cellCounter < cellNum; cellCounter++) {
				// excel cell
				Cell cell = row.getCell(cellCounter);
				result = getCellValue(cell);

				if (StringUtils.isNotBlank(result)) {
					break out;
				}
			}
		}

		return result;
	}

	/**
	 * 获取params标签中的内容
	 * 
	 * @param controllerSheet
	 * @param paramsTagPos
	 * @return
	 */
	private List<CField> getParamsTagContent(Sheet controllerSheet,
			DocTagPosModel paramsTagPos) {

		List<CField> paramsList = new ArrayList<CField>();

		int start = paramsTagPos.getStart();
		int end = paramsTagPos.getEnd();

		// tag差一行,title占一行,所以差3行以上才有数据
		if ((end - start) < 3) {
			return paramsList;
		}

		for (int i = start + 2; i < end; i++) {
			// excel cell
			Row row = controllerSheet.getRow(i);

			if (row == null) {
				continue;
			}

			// PARAM NAME
			String paramName = getCellValue(row.getCell(0));
			// PARAM TYPE
			String paramType = getCellValue(row.getCell(1));

			boolean isParamNameBlank = StringUtils.isBlank(paramName);
			boolean isParamTypeBlank = StringUtils.isBlank(paramType);

			if (isParamNameBlank || isParamTypeBlank) {
				continue;
			}

			CField cField = new CField(paramName, paramType, "", "");
			paramsList.add(cField);
		}

		return paramsList;
	}

	// /**
	// * 获取table name标签中的内容
	// *
	// * @param dbServiceSheet
	// * @param tableNameTagPosition
	// * @return
	// */
	// private String getTableNameTagContent(Sheet dbServiceSheet,
	// DocTagPosModel tableNameTagPos) {
	// String tableName = null;
	//
	// int start = tableNameTagPos.getStart();
	// int end = tableNameTagPos.getEnd();
	//
	// // tag差一行,所以差2行以上才有数据
	// if ((end - start) < 2) {
	// return "";
	// }
	//
	// out:
	// for (int i = start + 1; i < end; i++) {
	// // excel cell
	// Row row = dbServiceSheet.getRow(i);
	//
	// if (row == null) {
	// continue;
	// }
	//
	// int cellNum = row.getLastCellNum();
	// // 取到tableName则停止,否则遍历tableName tag段所有的row和cell
	// for (int cellCounter = 0; cellCounter < cellNum; cellCounter++) {
	// // excel cell
	// Cell cell = row.getCell(cellCounter);
	// // artifactId
	// tableName = getCellValue(cell);
	//
	// if (StringUtils.isNotBlank(tableName)) {
	// break out;
	// }
	// }
	// }
	//
	// return tableName;
	// }

	/**
	 * 获取table field标签中的内容
	 * 
	 * @param dbServiceSheet
	 * @param tableFieldTagPos
	 * @return
	 */
	private List<DocTagContentTableFieldModel> getTableFieldTagContent(
			Sheet dbServiceSheet, DocTagPosModel tableFieldTagPos) {
		List<DocTagContentTableFieldModel> docTableFieldModelList = new ArrayList<DocTagContentTableFieldModel>();

		int start = tableFieldTagPos.getStart();
		int end = tableFieldTagPos.getEnd();

		// tag差一行,title占一行,所以差3行以上才有数据
		if ((end - start) < 3) {
			return docTableFieldModelList;
		}

		for (int i = start + 2; i < end; i++) {
			// excel cell
			Row row = dbServiceSheet.getRow(i);

			if (row == null) {
				continue;
			}

			// COLUMN
			String columnName = getCellValue(row.getCell(0));
			// JAVA FIELD
			String columnJavaField = getCellValue(row.getCell(1));
			// TYPE
			String columnType = getCellValue(row.getCell(2));
			// JAVA FIELD TYPE
			String columnJavaFieldType = getCellValue(row.getCell(3));
			// NOT NULL
			String columnNull = getCellValue(row.getCell(4));
			// DEFAULT
			String columnDefaultValue = getCellValue(row.getCell(5));
			// PRIMARY KEY
			String columnPrimaryKey = getCellValue(row.getCell(6));
			// COMMENT
			String columnComment = getCellValue(row.getCell(7));
			// MOCK VALUE1
			String mockValue1 = simpleFormatMockValue(
					getCellValue(row.getCell(8)), columnJavaFieldType);
			// MOCK VALUE2
			String mockValue2 = simpleFormatMockValue(
					getCellValue(row.getCell(9)), columnJavaFieldType);

			// 可以单生成数据库列,java对应的model不要相应的字段;
			// 也可以单生成java model中的字段,该字段不对应任何数据库列
			// 但如果同时为空,则认为是无效行
			if (StringUtils.isBlank(columnName)
					&& StringUtils.isBlank(columnJavaField)) {
				continue;
			}

			DocTagContentTableFieldModel docTableFieldModel = new DocTagContentTableFieldModel();
			docTableFieldModel.setColumnName(columnName);
			docTableFieldModel.setColumnJavaField(columnJavaField);
			docTableFieldModel.setColumnType(columnType);
			docTableFieldModel.setColumnJavaFieldType(columnJavaFieldType);
			docTableFieldModel.setColumnNull(columnNull);
			docTableFieldModel.setColumnDefaultValue(columnDefaultValue);
			docTableFieldModel.setColumnPrimaryKey(columnPrimaryKey);
			docTableFieldModel.setColumnComment(columnComment);
			docTableFieldModel.setMockValue1(mockValue1);
			docTableFieldModel.setMockValue2(mockValue2);

			docTableFieldModelList.add(docTableFieldModel);
		}

		return docTableFieldModelList;
	}

	// /**
	// * 获取table index标签中的内容
	// *
	// * @param dbServiceSheet
	// * @param tableIndexTagPos
	// * @return
	// */
	// private List<String> getTableIndexTagContent(Sheet dbServiceSheet,
	// DocTagPosModel tableIndexTagPos) {
	// List<String> indexList = new ArrayList<String>();
	//
	// int start = tableIndexTagPos.getStart();
	// int end = tableIndexTagPos.getEnd();
	//
	// // tag差一行,所以差2行以上才有数据
	// if ((end - start) < 2) {
	// return indexList;
	// }
	//
	// for (int i = start + 1; i < end; i++) {
	// // excel cell
	// Row row = dbServiceSheet.getRow(i);
	//
	// if (row == null) {
	// continue;
	// }
	//
	// String index = getCellValue(row.getCell(0));
	// if (StringUtils.isNotBlank(index)) {
	// indexList.add(index);
	// }
	// }
	//
	// return indexList;
	// }

	/**
	 * 获取多行单列标签中的内容
	 * 
	 * @param sheet
	 * @param tagPos
	 * @return
	 */
	private List<String> getMultiLineTagContent(Sheet sheet,
			DocTagPosModel tagPos) {
		List<String> resultList = new ArrayList<String>();

		int start = tagPos.getStart();
		int end = tagPos.getEnd();

		// tag差一行,所以差2行以上才有数据
		if ((end - start) < 2) {
			return resultList;
		}

		for (int i = start + 1; i < end; i++) {
			// excel cell
			Row row = sheet.getRow(i);

			if (row == null) {
				continue;
			}

			String result = getCellValue(row.getCell(0));
			if (StringUtils.isNotBlank(result)) {
				resultList.add(result);
			}
		}

		return resultList;
	}

	/**
	 * 获取sql标签中的内容
	 * 
	 * @param dbServiceSheet
	 * @param sqlTagPos
	 * @return
	 */
	private List<DocTagContentSqlModel> getSqlTagContent(Sheet dbServiceSheet,
			DocTagPosModel sqlTagPos) {
		List<DocTagContentSqlModel> sqlList = new ArrayList<DocTagContentSqlModel>();

		int start = sqlTagPos.getStart();
		int end = sqlTagPos.getEnd();

		// tag差一行,title占一行,所以差3行以上才有数据
		if ((end - start) < 3) {
			return sqlList;
		}

		for (int i = start + 2; i < end; i++) {
			// excel cell
			Row row = dbServiceSheet.getRow(i);

			if (row == null) {
				continue;
			}

			String sqlSentence = getCellValue(row.getCell(0));
			String sqlResultType = getCellValue(row.getCell(1));
			// 是否创建count方法
			String creatCount = getCellValue(row.getCell(2));

			// sql文为空,代表非法配置
			if (StringUtils.isBlank(sqlSentence)) {
				continue;
			}

			DocTagContentSqlModel docTagContentSqlModel = new DocTagContentSqlModel();
			docTagContentSqlModel.setSqlSentence(sqlSentence);
			docTagContentSqlModel.setSqlResultType(sqlResultType);

			// 需要创建count方法
			if ("yes".equalsIgnoreCase(creatCount)) {
				docTagContentSqlModel.setNeedCountMethod(true);
			}

			sqlList.add(docTagContentSqlModel);
		}

		return sqlList;
	}

	/**
	 * 获取constant标签中的内容
	 * 
	 * @param dbServiceSheet
	 * @param constantTagPos
	 * @return
	 */
	private List<DocTagContentConstantModel> getConstantTagContent(
			Sheet dbServiceSheet, DocTagPosModel constantTagPos) {
		List<DocTagContentConstantModel> constantList = new ArrayList<DocTagContentConstantModel>();

		int start = constantTagPos.getStart();
		int end = constantTagPos.getEnd();

		// tag差一行,title占一行,所以差3行以上才有数据
		if ((end - start) < 3) {
			return constantList;
		}

		for (int i = start + 2; i < end; i++) {
			// excel cell
			Row row = dbServiceSheet.getRow(i);

			if (row == null) {
				continue;
			}

			String constantName = getCellValue(row.getCell(0));
			String constantValue = getCellValue(row.getCell(1));
			String constantType = getCellValue(row.getCell(2));
			String constantComment = getCellValue(row.getCell(3));

			if ("long".equalsIgnoreCase(constantType)) {
				constantValue = constantValue + "L";
			} else if ("String".equalsIgnoreCase(constantType)) {
				constantValue = "\"" + constantValue + "\"";
			}

			boolean isConstantNameBlank = StringUtils.isBlank(constantName);
			boolean isConstantValueBlank = StringUtils.isBlank(constantValue);
			boolean isConstantTypeBlank = StringUtils.isBlank(constantType);

			if (isConstantNameBlank || isConstantValueBlank
					|| isConstantTypeBlank) {
				continue;
			}

			DocTagContentConstantModel docTagContentConstantModel = new DocTagContentConstantModel();
			docTagContentConstantModel.setConstantName(constantName);
			docTagContentConstantModel.setConstantValue(constantValue);
			docTagContentConstantModel.setConstantType(constantType);
			docTagContentConstantModel.setConstantComment(constantComment);

			constantList.add(docTagContentConstantModel);
		}

		return constantList;
	}

	// /**
	// * 获取service Port标签中的内容
	// *
	// * @param dbServiceSheet
	// * @param servicePortTagPos
	// * @return
	// */
	// private String getServicePortTagContent(Sheet dbServiceSheet,
	// DocTagPosModel servicePortTagPos) {
	// String servicePort = null;
	//
	// int start = servicePortTagPos.getStart();
	// int end = servicePortTagPos.getEnd();
	//
	// // tag差一行,所以差2行以上才有数据
	// if ((end - start) < 2) {
	// return "";
	// }
	//
	// out:
	// for (int i = start + 1; i < end; i++) {
	// // excel cell
	// Row row = dbServiceSheet.getRow(i);
	//
	// if (row == null) {
	// continue;
	// }
	//
	// int cellNum = row.getLastCellNum();
	// // 取到tableName则停止,否则遍历tableName tag段所有的row和cell
	// for (int cellCounter = 0; cellCounter < cellNum; cellCounter++) {
	// // excel cell
	// Cell cell = row.getCell(cellCounter);
	// // artifactId
	// servicePort = getCellValue(cell);
	//
	// if (StringUtils.isNotBlank(servicePort)) {
	// break out;
	// }
	// }
	// }
	//
	// return servicePort;
	// }

	/**
	 * 根据cell值的类型读取cell值
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellValue(Cell cell) {

		try {
			String cellValue = "";

			if (cell == null) {
				return cellValue;
			}

			int cellType = cell.getCellType();

			switch (cellType) {
			// 读数字或日期值
			case Cell.CELL_TYPE_NUMERIC:
				// 在excel里,日期也是数字,在此要进行判断
				if (DateUtil.isCellDateFormatted(cell)) {
					// 读取日期格式
					cellValue = cell.getDateCellValue() + "";
				} else {
					// 读取数字
					cellValue = getNumericStr(cell.getNumericCellValue() + "");
				}
				break;

			// 读取字符串
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;

			// 读取布尔值
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = cell.getBooleanCellValue() + "";
				break;

			// 其它的,非以上几种数据类型
			default:
				cellValue = cell.toString() + "";
				break;
			}

			log.info(StringUtils.trim(cellValue));
			return StringUtils.trim(cellValue);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			log.error("parse wrong");
			log.error(cell.getRowIndex()+","+cell.getColumnIndex()+","+cell.getRow().getSheet().getSheetName());
		}
		return "";
	}

	/**
	 * 取数字值
	 * 
	 * @param num
	 * @return
	 */
	private String getNumericStr(String num) {
		DecimalFormat decimalFormat = new DecimalFormat("#0");
		String resultStr = decimalFormat.format(Double.valueOf(num));

		if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
			resultStr = resultStr.substring(0, resultStr.indexOf("."));
		}

		return resultStr;
	}

	/**
	 * 简单根据配置的字段类型,处理mock value 只支持String,Long,Integer,Float,Double型.
	 * 
	 * @param mockValue
	 * @param columnJavaFieldType
	 * @return
	 */
	private String simpleFormatMockValue(String mockValue,
			String columnJavaFieldType) {

		String result = "";

		if (StringUtils.isBlank(mockValue)) {
			return result;
		}

		if ("String".equalsIgnoreCase(columnJavaFieldType)) {
			result = "\"" + mockValue + "\"";
		} else if ("Long".equalsIgnoreCase(columnJavaFieldType)) {
			result = mockValue + "L";
		} else if ("Float".equalsIgnoreCase(columnJavaFieldType)) {
			result = mockValue + "F";
		} else {
			result = mockValue;
		}

		return result;
	}

	private Map<String, CMold> convertCmoldList2Map(List<CMold> cMoldList) {
		Map<String, CMold> cMoldMap = new HashMap<String, CMold>();

		if (CollectionUtils.isEmpty(cMoldList)) {
			return cMoldMap;
		}

		for (CMold cMold : cMoldList) {
			if (cMold == null) {
				continue;
			}

			String tableName = cMold.getTable();
			if (StringUtils.isBlank(tableName)) {
				continue;
			}

			cMoldMap.put(tableName, cMold);
		}

		return cMoldMap;
	}

	private List<CController> convertDocContentControllerSheetModelToCControllerList(
			DocContentControllerSheetModel controllerSheetContent,
			Map<String, CMold> cMoldMap) {
		List<CController> cControllerList = new ArrayList<CController>();

		if (controllerSheetContent == null) {
			return cControllerList;
		}

		String url = controllerSheetContent.getUrl();
		String methodName = controllerSheetContent.getMethodName();
		String returnPath = controllerSheetContent.getReturnPath();
		List<CField> paramList = controllerSheetContent.getParamList();
		List<String> referenceTableList = controllerSheetContent
				.getReferenceTableList();

		CRequest cRequest = new CRequest(url, methodName, paramList, returnPath);

		if (CollectionUtils.isNotEmpty(referenceTableList)) {
			String referenceTable = referenceTableList.get(0);

			CMold cMold = cMoldMap.get(referenceTable);
			cRequest.setMold(cMold);
		}

		List<CRequest> cRequestList = new ArrayList<CRequest>();
		cRequestList.add(cRequest);

		CController cController = new CController();
		cController.setRequests(cRequestList);

		cControllerList.add(cController);

		return cControllerList;
	}
}
