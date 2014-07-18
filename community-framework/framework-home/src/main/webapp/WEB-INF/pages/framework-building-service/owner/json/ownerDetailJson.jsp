<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${owner.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${owner.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${owner.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="mobile" value="${owner.mobile}"></json:property>
           
           
	   
                    			
               
                    <json:property name="birthday" value="${owner.birthday}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sex" value="${owner.sex}"></json:property>
           
           
	   
                    			
               
                    <json:property name="email" value="${owner.email}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${owner.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${owner.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${owner.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${owner.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


