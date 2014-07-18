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
		<c:forEach items="${gorderGoodsRelationList}" var="gorderGoodsRelation">
			<json:object>
					
               
                    <json:property name="id" value="${gorderGoodsRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="gorderID" value="${gorderGoodsRelation.gorderID}"></json:property>
           
           
	   
        			
               
                    <json:property name="goodsID" value="${gorderGoodsRelation.goodsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="categoryID" value="${gorderGoodsRelation.categoryID}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${gorderGoodsRelation.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="publishName" value="${gorderGoodsRelation.publishName}"></json:property>
           
           
	   
        			
               
                    <json:property name="price" value="${gorderGoodsRelation.price}"></json:property>
           
           
	   
        			
               
                    <json:property name="originalPrice" value="${gorderGoodsRelation.originalPrice}"></json:property>
           
           
	   
        			
               
                    <json:property name="count" value="${gorderGoodsRelation.count}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${gorderGoodsRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${gorderGoodsRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${gorderGoodsRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${gorderGoodsRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


