<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:array name="data">
		<c:forEach items="${gorders}" var="gorder">
			<json:object>
				<c:set var="address" value="${id_address[gorder.addressID]}"></c:set>
				<c:set var="paddress" value="${id_paddress[gorder.paddressID]}"></c:set>

				<json:property name="id" value="${gorder.id}"></json:property>





				<json:property name="userID" value="${gorder.userID}"></json:property>





				<json:property name="addressID" value="${gorder.addressID}"></json:property>


				<json:property name="paddressID" value="${gorder.paddressID}"></json:property>


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

				<json:object name="address">
					<json:property name="id" value="${address.id}">
					</json:property>
					<json:property name="name" value="${address.name}">
					</json:property>
					<json:property name="phone" value="${address.phone}">
					</json:property>
					<json:property name="sex" value="${address.sex}">
					</json:property>
					<json:property name="updateAt" value="${address.updateAt}">
					</json:property>
					<json:property name="createAt" value="${address.createAt}">
					</json:property>

				</json:object>

				<json:object name="paddress">

					<json:property name="id" value="${paddress.id}"></json:property>





					<json:property name="name" value="${paddress.name}"></json:property>





					<json:property name="phone" value="${paddress.phone}"></json:property>





					<json:property name="address" value="${paddress.address}"></json:property>





					<json:property name="code" value="${paddress.code}"></json:property>





					<json:property name="createBy" value="${paddress.createBy}"></json:property>





					<json:property name="updateBy" value="${paddress.updateBy}"></json:property>





					<json:property name="updateAt" value="${paddress.updateAt}"></json:property>





					<json:property name="createAt" value="${paddress.createAt}"></json:property>


				</json:object>


			</json:object>
		</c:forEach>
	</json:array>
</json:object>


