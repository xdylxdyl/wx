<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${tagsPublicsRelationList}" var="tagsPublicsRelation">
			<json:object>
					
               
                    <json:property name="id" value="${tagsPublicsRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="tagsID" value="${tagsPublicsRelation.tagsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="publicsID" value="${tagsPublicsRelation.publicsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${tagsPublicsRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${tagsPublicsRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${tagsPublicsRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${tagsPublicsRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


