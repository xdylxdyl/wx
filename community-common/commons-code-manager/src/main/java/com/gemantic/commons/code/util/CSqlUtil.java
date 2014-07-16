package com.gemantic.commons.code.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMethod;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CSql;

public class CSqlUtil {

	private static final Log log = LogFactory.getLog(CSqlUtil.class);

	public static CSql parseSql(String sql) {
		sql = sql.toLowerCase();
		String sqlRegex = "select(.*)from(.*)where(.*)";
		Pattern datePatt = Pattern.compile(sqlRegex);
		CSql csql = new CSql();
		Matcher m = datePatt.matcher(sql);
		if (m.find()) {
			log.info("match");

			String returns = m.group(1);

			csql.setReturns(returns.trim());
			String table = m.group(2);
			csql.setTable(table.trim());

			// String condition=m.group(3);
			String where = m.group(3) == null ? "" : m.group(3);
			int orderByPos = where.toLowerCase().indexOf("order by");

			String condition = "";
			String orderBy = "";
			if (orderByPos == -1) {
				condition = where;
			} else {
				condition = where.substring(0, orderByPos);
				orderBy = where.substring(orderByPos + 8, where.length());
			}

			String[] conditions = condition.trim().split("and");
			Set<String> csSet = new LinkedHashSet<String>();
			// 生成的方法所需要的参数list
			Map<String, List<String>> conditionKeyParamPrefixValueMap = new HashMap<String, List<String>>();
			for (String ct : conditions) {
				// String[] ca=ct.split("(>)?(<)?=");
				// csSet.add(ca[0].trim());

				String[] ca = ct.split("=");
				String whereCondition = ca[0].trim();

				// 如果有 > 或 < 查询,方法参数名加start 或 end
				String paramPrefix = "";
				if (whereCondition.endsWith(">")) {
					paramPrefix = "start";
					whereCondition = whereCondition.substring(0, whereCondition.length() - 1).trim();
				} else if (whereCondition.endsWith("<")) {
					paramPrefix = "end";
					whereCondition = whereCondition.substring(0, whereCondition.length() - 1).trim();
				}

				// where 条件及 作为函数参数时的前缀 map
				List<String> paramPrefixList = conditionKeyParamPrefixValueMap.get(whereCondition);
				if (paramPrefixList == null) {
					paramPrefixList = new ArrayList<String>();
				}

				paramPrefixList.add(paramPrefix);
				conditionKeyParamPrefixValueMap.put(whereCondition, paramPrefixList);

				csSet.add(whereCondition);
			}

			csql.setConditions(new ArrayList<String>(csSet));

			// order by
			String[] orderBys = orderBy.trim().split(",");
			List<String> orderByFields = new ArrayList<String>();
			if (orderBys != null) {
				for (String orderByField : orderBys) {
					if (orderByField != null && !"".equals(orderByField.trim())) {
						String str = orderByField.toLowerCase().replaceAll("asc", "").replaceAll("desc", "").trim();
						orderByFields.add(str);
					}
				}
			}
			csql.setOrderByFields(orderByFields);

			csql.setConditionKeyParamPrefixValueMap(conditionKeyParamPrefixValueMap);

		} else {
			log.info("not match ");
		}

		csql.setSql(sql);
		return csql;
	}

	public static void main(String[] args) {

		String aDate = "date: 12-15-2003";
		Pattern datePattern = Pattern.compile("date: (\\d{2})-(\\d{2})-(\\d{4})");
		Matcher dateMatcher = datePattern.matcher(aDate);
		if (dateMatcher.find()) {
			System.out.println("Month is: " + dateMatcher.group(1));
			System.out.println("Day is:   " + dateMatcher.group(2));
			System.out.println("Year is:  " + dateMatcher.group(3));
		}

		String sql = " publish_at >= ? and publish_at <= ? order by publish_at desc";
		String[] conditions = sql.split("and");
		for (String condition : conditions) {
			String[] propertys = condition.split("=");
			for (String property : propertys) {
				System.out.println(property);
			}
		}

	}

	public static CMethod parseMethod(CSql csql, CMold cm) throws Exception {
		CMethod method = new CMethod();
		StringBuffer name = new StringBuffer();
		name.append("get");

		CField rf = null;
		CField oldrf = cm.getFieldByDName(csql.getReturns());
		if (CSql.Sql_Type_List.equals(csql.getType())) {

			rf = new CField(oldrf.getCname(), "List<" + oldrf.getCtype() + ">", oldrf.getDname(), oldrf.getDtype());
			method.setPimpl("velocity/list.vm");
		} else {

			rf = oldrf;
			method.setPimpl("velocity/map.vm");
		}

		if ("id".equals(rf.getCname()) || CSql.Sql_Type_Map.equals(csql.getType())) {
			name.append(cm.getModelClass());
		} else {

		}
		name.append(StringUtils.capitalize(rf.getCname()));
		if (CSql.Sql_Type_List.equals(csql.getType())) {
			name.append("s");
		}
		name.append("By");

		List<CField> params = new ArrayList<CField>();

		Map<String, List<String>> conditionKeyParamPrefixValueMap = csql.getConditionKeyParamPrefixValueMap();
		for (String c : csql.getConditions()) {
			// where 条件作为方法参数时的名称前缀
			List<String> paramPrefixList = conditionKeyParamPrefixValueMap.get(c);

			if (CollectionUtils.isNotEmpty(paramPrefixList)) {
				for (String paramPrefix : paramPrefixList) {
					CField tempCf = cm.getFieldByDName(c);

					CField cf = tempCf.clone();
					// 方法参数的名称
					String funcParamName = paramPrefix
							+ (org.apache.commons.lang.StringUtils.isBlank(paramPrefix) ? cf.getCname() : StringUtils
									.capitalize(cf.getCname()));
					cf.setFuncParamName(funcParamName);
					params.add(cf);
				}
			}

			CField p = cm.getFieldByDName(c);
			name.append(StringUtils.capitalize(p.getCname()));

			name.append("And");

		}

		List<String> orderByList = csql.getOrderByFields();
		if (orderByList != null && orderByList.size() > 0) {

			// 去掉order by前多余的 And
			String tempName = name.toString();
			if (tempName.endsWith("And")) {
				tempName = tempName.substring(0, tempName.length() - 3);

				name = new StringBuffer(tempName);
			}

			name.append("OrderBy");

			for (String orderBy : orderByList) {
				if (orderBy == null || "".equals(orderBy.trim())) {
					continue;
				}
				CField p = cm.getFieldByDName(orderBy);

				// order by 的字段不需要是函数的parameter
				// params.add(p);

				name.append(StringUtils.capitalize(p.getCname()));

				name.append("And");
			}
		}

		String m = name.toString();
		int i = m.lastIndexOf("And");

		// 如果是List,那么需要加入Page和Size
		if (CSql.Sql_Type_List.equals(csql.getType())) {

			CField page = new CField("start", "Integer", "", "");
			page.addValue("0");
			CField size = new CField("limit", "Integer", "", "");
			size.addValue("Integer.MAX_VALUE");
			params.add(page);
			params.add(size);
		}

		method.setName(name.substring(0, i));
		method.setParams(params);
		method.setReturnField(rf);
		method.setType(csql.getType());
		method.setSql(csql.getSql());
		method.setPtest("velocity/test/sql.vm ");

		return method;
	}

	public static CMethod parseCountMethod(CSql csql, CMold cm) throws Exception {

		CMethod method = new CMethod();
		StringBuffer name = new StringBuffer();
		name.append("count");

		CField rf = null;
		CField oldrf = cm.getFieldByDName(csql.getReturns());
		if (CSql.Sql_Type_List.equals(csql.getType())) {

			rf = new CField(oldrf.getCname(), "Integer", oldrf.getDname(), oldrf.getDtype());
			method.setPimpl("velocity/count.vm");
		} else {

			return null;
		}
		
		if ("id".equals(rf.getCname())) {
			name.append(cm.getModelClass());
		} else {

		}

		name.append(StringUtils.capitalize(rf.getCname()));
		if (CSql.Sql_Type_List.equals(csql.getType())) {
			name.append("s");
		}
		name.append("By");

		List<CField> params = new ArrayList<CField>();

		Map<String, List<String>> conditionKeyParamPrefixValueMap = csql.getConditionKeyParamPrefixValueMap();
		for (String c : csql.getConditions()) {
			// where 条件作为方法参数时的名称前缀
			List<String> paramPrefixList = conditionKeyParamPrefixValueMap.get(c);

			if (CollectionUtils.isNotEmpty(paramPrefixList)) {
				for (String paramPrefix : paramPrefixList) {
					CField tempCf = cm.getFieldByDName(c);

					CField cf = tempCf.clone();
					// 方法参数的名称
					String funcParamName = paramPrefix
							+ (org.apache.commons.lang.StringUtils.isBlank(paramPrefix) ? cf.getCname() : StringUtils
									.capitalize(cf.getCname()));
					cf.setFuncParamName(funcParamName);
					params.add(cf);
				}
			}

			CField p = cm.getFieldByDName(c);
			name.append(StringUtils.capitalize(p.getCname()));

			name.append("And");

		}

		List<String> orderByList = csql.getOrderByFields();
		if (orderByList != null && orderByList.size() > 0) {

			// 去掉order by前多余的 And
			String tempName = name.toString();
			if (tempName.endsWith("And")) {
				tempName = tempName.substring(0, tempName.length() - 3);

				name = new StringBuffer(tempName);
			}

			name.append("OrderBy");

			for (String orderBy : orderByList) {
				if (orderBy == null || "".equals(orderBy.trim())) {
					continue;
				}
				CField p = cm.getFieldByDName(orderBy);

				// order by 的字段不需要是函数的parameter
				// params.add(p);

				name.append(StringUtils.capitalize(p.getCname()));

				name.append("And");
			}
		}

		String m = name.toString();
		int i = m.lastIndexOf("And");

		method.setName(name.substring(0, i));
		method.setParams(params);
		method.setReturnField(rf);
		method.setType(csql.getType());
		method.setSql(csql.getSql());
		method.setPtest("velocity/test/sql.vm ");

		return method;

	}

}
