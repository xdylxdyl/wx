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
		<c:forEach items="${addressProjectRelationList}" var="addressProjectRelation">
			<json:object>
					
               
                    <json:property name="id" value="${addressProjectRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="addressID" value="${addressProjectRelation.addressID}"></json:property>
           
           
	   
        			
               
                    <json:property name="userID" value="${addressProjectRelation.userID}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${addressProjectRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${addressProjectRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${addressProjectRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${addressProjectRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


