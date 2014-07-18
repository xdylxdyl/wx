<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${building.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${building.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${building.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${building.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="projectId" value="${building.projectId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="projectName" value="${building.projectName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="isVirtual" value="${building.isVirtual}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${building.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${building.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${building.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${building.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


