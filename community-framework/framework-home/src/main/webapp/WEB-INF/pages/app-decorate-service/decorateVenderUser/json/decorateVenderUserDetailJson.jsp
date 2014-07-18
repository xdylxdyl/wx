<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${decorateVenderUser.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderId" value="${decorateVenderUser.venderId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderName" value="${decorateVenderUser.venderName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userName" value="${decorateVenderUser.userName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userIdNumber" value="${decorateVenderUser.userIdNumber}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userMobile" value="${decorateVenderUser.userMobile}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userMobile1" value="${decorateVenderUser.userMobile1}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userMobile2" value="${decorateVenderUser.userMobile2}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userEmail" value="${decorateVenderUser.userEmail}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userQq" value="${decorateVenderUser.userQq}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${decorateVenderUser.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${decorateVenderUser.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${decorateVenderUser.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${decorateVenderUser.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


