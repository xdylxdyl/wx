<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}">
	</json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}">
	</json:property>
	<json:property name="total" value="${total}">
	</json:property>
	<json:array name="data">
		<c:forEach items="${addressList}" var="address">
			<json:object>
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
		</c:forEach>
	</json:array>
</json:object>