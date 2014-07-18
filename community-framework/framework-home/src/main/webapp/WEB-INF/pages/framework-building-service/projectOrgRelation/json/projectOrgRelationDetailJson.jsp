<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${projectOrgRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="projectId" value="${projectOrgRelation.projectId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="orgId" value="${projectOrgRelation.orgId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${projectOrgRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${projectOrgRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${projectOrgRelation.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${projectOrgRelation.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


