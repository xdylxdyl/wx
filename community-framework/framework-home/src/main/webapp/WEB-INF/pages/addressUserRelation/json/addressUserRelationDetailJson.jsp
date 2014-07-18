<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${addressUserRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="addressID" value="${addressUserRelation.addressID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userID" value="${addressUserRelation.userID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${addressUserRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${addressUserRelation.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


