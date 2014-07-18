<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${org.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${org.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${org.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${org.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="provinceId" value="${org.provinceId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="parentId" value="${org.parentId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${org.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${org.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${org.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${org.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


