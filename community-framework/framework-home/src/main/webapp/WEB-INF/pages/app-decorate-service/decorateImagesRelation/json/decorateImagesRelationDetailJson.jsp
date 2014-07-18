<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${decorateImagesRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="decorateId" value="${decorateImagesRelation.decorateId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="imageId" value="${decorateImagesRelation.imageId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${decorateImagesRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${decorateImagesRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${decorateImagesRelation.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${decorateImagesRelation.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


