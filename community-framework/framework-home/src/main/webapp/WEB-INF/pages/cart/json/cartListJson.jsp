<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${cartList}" var="cart">
			<json:object>
                    <json:property name="id" value="${cart.id}"></json:property>
                    <json:property name="name" value="${cart.name}"></json:property>
                    <json:property name="publishStart" value="${cart.startDate}"></json:property>
                    <json:property name="publishEnd" value="${cart.endDate}"></json:property>
                    <json:property name="price" value="${cart.price}"></json:property>
                    <json:property name="originalPrice" value="${cart.originalPrice}"></json:property>
                    <json:property name="count" value="${cart.count}"></json:property>
        	</json:object>
		</c:forEach>
	</json:array>
</json:object>


