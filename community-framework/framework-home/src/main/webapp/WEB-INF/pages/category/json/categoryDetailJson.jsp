<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${category.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${category.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${category.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${category.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${category.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${category.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${category.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


