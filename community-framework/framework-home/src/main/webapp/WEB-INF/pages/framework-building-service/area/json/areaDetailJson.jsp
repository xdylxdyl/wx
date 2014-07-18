<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${area.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${area.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${area.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="parentId" value="${area.parentId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${area.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${area.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${area.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${area.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


