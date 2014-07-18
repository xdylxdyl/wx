<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${project.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${project.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${project.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${project.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${project.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${project.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${project.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


