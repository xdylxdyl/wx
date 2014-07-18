<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${imagesList}" var="images">
			<json:object>
					
               
                    <json:property name="id" value="${images.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${images.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="originalPath" value="${images.originalPath}"></json:property>
           
           
	   
        			
               
                    <json:property name="bigPath" value="${images.bigPath}"></json:property>
           
           
	   
        			
               
                    <json:property name="middlePath" value="${images.middlePath}"></json:property>
           
           
	   
        			
               
                    <json:property name="smallPath" value="${images.smallPath}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${images.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${images.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${images.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${images.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


