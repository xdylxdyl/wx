<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${decoratePaymentList}" var="decoratePayment">
			<json:object>
					
               
                    <json:property name="id" value="${decoratePayment.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${decoratePayment.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="amount" value="${decoratePayment.amount}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${decoratePayment.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${decoratePayment.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="remark" value="${decoratePayment.remark}"></json:property>
           
           
	   
        			
               
                    <json:property name="decorateId" value="${decoratePayment.decorateId}"></json:property>
           
           
	   
        			
               
                    <json:property name="decorateSerialId" value="${decoratePayment.decorateSerialId}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${decoratePayment.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${decoratePayment.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${decoratePayment.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${decoratePayment.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


