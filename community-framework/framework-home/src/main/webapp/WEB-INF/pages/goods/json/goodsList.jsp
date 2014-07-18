<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${goodsList}" var="goods">
			<json:object>


				<json:property name="id" value="${goods.id}"></json:property>





				<json:property name="providerID" value="${goods.providerID}"></json:property>





				<json:property name="categoryID" value="${goods.categoryID}"></json:property>





				<json:property name="name" value="${goods.name}"></json:property>





				<json:property name="publishName" value="${goods.publishName}"></json:property>





				<json:property name="price" value="${goods.price}"></json:property>





				<json:property name="originalPrice" value="${goods.originalPrice}"></json:property>





				<json:property name="count" value="${goods.count}"></json:property>





				<json:property name="img" value="${goods.img}"></json:property>





				<json:property name="detail" value="${goods.detail}"></json:property>





				<json:property name="comment" value="${goods.comment}"></json:property>





			</json:object>
		</c:forEach>
	</json:array>
</json:object>


