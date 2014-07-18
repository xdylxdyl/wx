<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${userOpenRelationList}" var="userOpenRelation">
			<json:object>
					
               
                    <json:property name="id" value="${userOpenRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="uid" value="${userOpenRelation.uid}"></json:property>
           
           
	   
        			
               
                    <json:property name="openID" value="${userOpenRelation.openID}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${userOpenRelation.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${userOpenRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${userOpenRelation.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


