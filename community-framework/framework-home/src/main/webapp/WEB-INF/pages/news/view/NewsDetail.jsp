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

	<div id="NewsDetailApp" ng-app="NewsDetailApp"
		ng-controller="NewsDetailController"  ng-cloak>
		<input type="hidden" name="id" id="newsId" ng-model="news.id"
			value="${id}">
	<div class="newBox">
		<h1 class="title autoSize"  ng-bind="news.title"></h1>
		<div class="other"  ng-bind="news.releaseat|date:'yyyy-MM-dd'"><a href="">公众号名称</a></div>
		<div class="content">
			<div id="content" ng-bind-html="content"></div>
			</div>
	</div>
	</div>
</body>
<script src="/r/angular/angular-sanitize.js"></script>
<script src="/r/js-src/web/news/NewsDetail.js"></script>
