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
		<c:forEach items="${potentialList}" var="potential">
			<json:object>
					
               
                    <json:property name="id" value="${potential.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="nick" value="${potential.nick}"></json:property>
           
           
	   
        			
               
                    <json:property name="sex" value="${potential.sex}"></json:property>
           
           
	   
        			
               
                    <json:property name="img" value="${potential.img}"></json:property>
           
           
	   
        			
               
                    <json:property name="publicsID" value="${potential.publicsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="openID" value="${potential.openID}"></json:property>
           
           
	   
        			
               
                    <json:property name="fakeID" value="${potential.fakeID}"></json:property>
           
           
	   
        			
               
                    <json:property name="loginAt" value="${potential.loginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="lastLoginAt" value="${potential.lastLoginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${potential.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${potential.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


