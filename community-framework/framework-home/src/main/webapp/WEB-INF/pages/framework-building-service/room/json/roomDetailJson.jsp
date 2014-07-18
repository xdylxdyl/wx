<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${room.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${room.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="code" value="${room.code}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${room.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="roomArea" value="${room.roomArea}"></json:property>
           
           
	   
                    			
               
                    <json:property name="roomUnit" value="${room.roomUnit}"></json:property>
           
           
	   
                    			
               
                    <json:property name="roomFloor" value="${room.roomFloor}"></json:property>
           
           
	   
                    			
               
                    <json:property name="roomNum" value="${room.roomNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="buildingId" value="${room.buildingId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="buildingName" value="${room.buildingName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${room.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${room.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${room.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${room.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


