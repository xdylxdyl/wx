<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
<%-- 
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
 --%>
 	<json:object name="data">
		<json:array name="progress">
			<c:forEach items="${decorateLogList}" var="decorateLog">
				<json:object>
						
	<%--                
	                    <json:property name="id" value="${decorateLog.id}"></json:property>
	                    <json:property name="decorateId" value="${decorateLog.decorateId}"></json:property>
	                    <json:property name="description" value="${decorateLog.description}"></json:property>
	                    <json:property name="updateAt" value="${decorateLog.updateAt}"></json:property>
	                    <json:property name="updateBy" value="${decorateLog.updateBy}"></json:property>
	                    <json:property name="createBy" value="${decorateLog.createBy}"></json:property>
	 --%>           
	               
	                    <json:property name="status" value="${decorateLog.status}"></json:property>
	                    <json:property name="time" value="${decorateLog.createAt}"></json:property>
	           
	        	</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>


