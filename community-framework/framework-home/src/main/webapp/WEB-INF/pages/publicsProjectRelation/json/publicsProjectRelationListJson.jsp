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
		<c:forEach items="${publicsProjectRelationList}" var="publicsProjectRelation">
			<json:object>
					
               
                    <json:property name="id" value="${publicsProjectRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="publicsID" value="${publicsProjectRelation.publicsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="projectID" value="${publicsProjectRelation.projectID}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${publicsProjectRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${publicsProjectRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${publicsProjectRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${publicsProjectRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


