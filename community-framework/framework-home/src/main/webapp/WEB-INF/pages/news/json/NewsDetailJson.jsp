<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<json:object  escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
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
		
</json:object>


