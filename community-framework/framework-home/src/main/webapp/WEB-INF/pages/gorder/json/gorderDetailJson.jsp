<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${gorder.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userID" value="${gorder.userID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="addressID" value="${gorder.addressID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="publicsID" value="${gorder.publicsID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${gorder.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="total" value="${gorder.total}"></json:property>
           
           
	   
                    			
               
                    <json:property name="type" value="${gorder.type}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${gorder.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${gorder.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${gorder.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="gorderAt" value="${gorder.gorderAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${gorder.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${gorder.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


