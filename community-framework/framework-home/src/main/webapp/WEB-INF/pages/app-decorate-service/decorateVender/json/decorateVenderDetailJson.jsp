<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${decorateVender.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderId" value="${decorateVender.venderId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderName" value="${decorateVender.venderName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="isHveLcense" value="${decorateVender.isHveLcense}"></json:property>
           
           
	   
                    			
               
                    <json:property name="legalName" value="${decorateVender.legalName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="legalIdNumber" value="${decorateVender.legalIdNumber}"></json:property>
           
           
	   
                    			
               
                    <json:property name="legalMobile" value="${decorateVender.legalMobile}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactName" value="${decorateVender.contactName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactIdNumber" value="${decorateVender.contactIdNumber}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactMobile" value="${decorateVender.contactMobile}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${decorateVender.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${decorateVender.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${decorateVender.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${decorateVender.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


