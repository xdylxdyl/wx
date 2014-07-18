<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${addressProjectRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="addressID" value="${addressProjectRelation.addressID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userID" value="${addressProjectRelation.userID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${addressProjectRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${addressProjectRelation.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${addressProjectRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${addressProjectRelation.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


