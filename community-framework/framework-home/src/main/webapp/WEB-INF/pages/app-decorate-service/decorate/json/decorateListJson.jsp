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
		<json:array name="decorates">
			<c:forEach items="${decorateList}" var="decorate">
				<json:object>
						
	               
	                    <json:property name="id" value="${decorate.id}"></json:property>
	                    <json:property name="serialId" value="${decorate.serialId}"></json:property>
	                    <json:property name="userName" value="${decorate.userName}"></json:property>
	                    <json:property name="userMobile" value="${decorate.userMobile}"></json:property>
	                    <json:property name="roomName" value="${decorate.roomName}"></json:property>
	                    <json:property name="buildingName" value="${decorate.buildingName}"></json:property>
	                    <json:property name="status" value="${decorate.status}"></json:property>
	                    <json:property name="time" value="${decorate.createAt}"></json:property>
	           
	        			
	<%--                
	                    <json:property name="userId" value="${decorate.userId}"></json:property>
	                    <json:property name="userWxId" value="${decorate.userWxId}"></json:property>
	                    <json:property name="userWxName" value="${decorate.userWxName}"></json:property>
	                    <json:property name="roomId" value="${decorate.roomId}"></json:property>
	                    <json:property name="buildingId" value="${decorate.buildingId}"></json:property>
	                    <json:property name="venderId" value="${decorate.venderId}"></json:property>
	                    <json:property name="venderName" value="${decorate.venderName}"></json:property>
	                    <json:property name="chargerId" value="${decorate.chargerId}"></json:property>
	                    <json:property name="chargerName" value="${decorate.chargerName}"></json:property>
	                    <json:property name="chargerMobile" value="${decorate.chargerMobile}"></json:property>
	                    <json:property name="publicsId" value="${decorate.publicsId}"></json:property>
	                    <json:property name="publicsName" value="${decorate.publicsName}"></json:property>
	                    <json:property name="drawingCount" value="${decorate.drawingCount}"></json:property>
	                    <json:property name="expectStartDate" value="${decorate.expectStartDate}"></json:property>
	                    <json:property name="expectCheckDate" value="${decorate.expectCheckDate}"></json:property>
	                    <json:property name="updateAt" value="${decorate.updateAt}"></json:property>
	                    <json:property name="updateBy" value="${decorate.updateBy}"></json:property>
	                    <json:property name="createBy" value="${decorate.createBy}"></json:property>
	 --%>           
	               
	        			</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>


