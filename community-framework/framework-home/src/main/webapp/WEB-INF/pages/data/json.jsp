<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="success" value="${success}"></json:property>	
	<json:property name="code" value="${code}"></json:property>	
	<json:property name="message" >
		<spring:message code="${code}" arguments="${codeParameter}" />
	</json:property>
	<json:property name="result" value="${result}"></json:property>	
	<json:property name="url" value="${url}"></json:property>	
</json:object>