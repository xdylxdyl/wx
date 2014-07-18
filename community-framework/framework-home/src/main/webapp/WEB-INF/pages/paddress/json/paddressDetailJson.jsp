<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${paddress.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${paddress.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${paddress.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="address" value="${paddress.address}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${paddress.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${paddress.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${paddress.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${paddress.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${paddress.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


