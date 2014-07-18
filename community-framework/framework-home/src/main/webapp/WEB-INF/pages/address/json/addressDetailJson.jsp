<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}">
	</json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:property name="id" value="${address.id}">
		</json:property>
		<json:property name="name" value="${address.name}">
		</json:property>
		<json:property name="phone" value="${address.phone}">
		</json:property>
		<json:property name="sex" value="${address.sex}">
		</json:property>
		<json:property name="updateAt" value="${address.updateAt}">
		</json:property>
		<json:property name="createAt" value="${address.createAt}">
		</json:property>
	</json:object>
</json:object>