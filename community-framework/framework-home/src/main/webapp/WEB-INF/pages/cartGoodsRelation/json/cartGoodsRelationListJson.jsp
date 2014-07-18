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
		<c:forEach items="${cartGoodsRelationList}" var="cartGoodsRelation">
			<json:object>
					
               
                    <json:property name="id" value="${cartGoodsRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="cartID" value="${cartGoodsRelation.cartID}"></json:property>
           
           
	   
        			
               
                    <json:property name="goodsID" value="${cartGoodsRelation.goodsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="count" value="${cartGoodsRelation.count}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${cartGoodsRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${cartGoodsRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${cartGoodsRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${cartGoodsRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


