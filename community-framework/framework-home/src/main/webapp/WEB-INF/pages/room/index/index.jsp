<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../../includes/includes.jsp"%>


<c:choose>
<c:when test="${not empty user}">欢迎，${user.nick}</c:when>
<c:otherwise>未登录，${potential.nick}</c:otherwise>
</c:choose>



消息列表

