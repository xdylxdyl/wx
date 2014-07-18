<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${providerPublicsRelation.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="providerID" value="${providerPublicsRelation.providerID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="publicsID" value="${providerPublicsRelation.publicsID}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${providerPublicsRelation.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${providerPublicsRelation.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${providerPublicsRelation.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${providerPublicsRelation.createBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


