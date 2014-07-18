<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%-- <%@ include file="../../includes/include-css.jsp"%> --%>
<%--<%@ include file="../../includes/include-js.jsp"%>--%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>News - Review</title>
<link href="/r/html/styles/news.css" rel="stylesheet">
</head>
<body>
<div id="MessageDetailApp" class="newBox" >
	<h1 class="title autoSize">${message.title}</h1>
	<div class="other">${dates}&nbsp;&nbsp;&nbsp;${publics.name}</div>
	<div class="content">
	<p style="text-align:center;"><c:if test="${message.img != null}"><img src="${message.img}"></c:if></p>
	<p>${message.content}</p>
	</div>
</div>
</body>
</html>