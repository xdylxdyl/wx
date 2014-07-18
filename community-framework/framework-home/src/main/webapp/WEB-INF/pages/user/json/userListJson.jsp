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
		<c:forEach items="${userList}" var="user">
			<json:object>
					
               
                    <json:property name="id" value="${user.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="nick" value="${user.nick}"></json:property>
           
           
	   
        			
               
                    <json:property name="mobile" value="${user.mobile}"></json:property>
           
           
	   
        			
               
                    <json:property name="pwd" value="${user.pwd}"></json:property>
           
           
	   
        			
               
                    <json:property name="sex" value="${user.sex}"></json:property>
           
           
	   
        			
               
                    <json:property name="img" value="${user.img}"></json:property>
           
           
	   
        			
               
                    <json:property name="loginAt" value="${user.loginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="lastLoginAt" value="${user.lastLoginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${user.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${user.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


