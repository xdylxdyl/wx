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
		<c:forEach items="${tagsList}" var="tags">
			<json:object>
					
               
                    <json:property name="id" value="${tags.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${tags.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${tags.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${tags.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${tags.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${tags.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${tags.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


