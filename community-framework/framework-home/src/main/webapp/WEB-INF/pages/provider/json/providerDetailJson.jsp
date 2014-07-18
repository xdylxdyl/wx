<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${provider.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${provider.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contact" value="${provider.contact}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${provider.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="type" value="${provider.type}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${provider.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${provider.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${provider.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${provider.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${provider.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


