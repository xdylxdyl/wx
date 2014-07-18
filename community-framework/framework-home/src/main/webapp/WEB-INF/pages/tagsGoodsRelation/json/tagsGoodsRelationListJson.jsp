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
		<c:forEach items="${tagsGoodsRelationList}" var="tagsGoodsRelation">
			<json:object>
					
               
                    <json:property name="id" value="${tagsGoodsRelation.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="tagsID" value="${tagsGoodsRelation.tagsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="goodsID" value="${tagsGoodsRelation.goodsID}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${tagsGoodsRelation.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${tagsGoodsRelation.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${tagsGoodsRelation.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${tagsGoodsRelation.createBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


