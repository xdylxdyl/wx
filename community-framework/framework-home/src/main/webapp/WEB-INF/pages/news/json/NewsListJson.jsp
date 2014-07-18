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
		<c:forEach items="${newsList}" var="news">
			<json:object>
					
               
                    <json:property name="id" value="${news.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="publicsID" value="${news.publicsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="title" value="${news.title}"></json:property>
           
           
	   
        			
               
                    <json:property name="summary" value="${news.summary}"></json:property>
           
           
	   
        			
               
                    <json:property name="content" value="${news.content}"></json:property>
           
           
	   
        			
               
                    <json:property name="img" value="${news.img}"></json:property>
           
           
	   
        			
               
                    <json:property name="templateType" value="${news.templateType}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${news.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="author" value="${news.author}"></json:property>
           
           
	   
        			
               
                    <json:property name="releaseat" value="${news.releaseat}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${news.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${news.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


