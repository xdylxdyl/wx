<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="ret_code" value="${ret_code}"></json:property>	
	<json:property name="ret_msg" value="${ret_msg}"></json:property>	
</json:object>