<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${cart.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userID" value="${cart.userID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${cart.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${cart.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


