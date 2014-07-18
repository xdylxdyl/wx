<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>News</title>
<link href="/r/html/styles/news.css" rel="stylesheet">

<body>
	<div ng-app="NewsApp" ng-controller="NewsController"  ng-cloak>
	<div class="webName autoSize textCenter grayButton"><span class="icon">A</span>社区小喇叭</div>
	
		<div ng-repeat="news in items">
			
	<div class="news autoSize clear" ng-click="chooseNews(news.id)">
		<div class="pic left"><img ng-src="{{news.img}}" ></div>
		<div class="info left">
			<div class="box">
				<h1  ng-bind="news.title"></h1>
				<div class="relative abv"><i class="time absolute" ng-bind="news.releaseat|date:'MM-dd'"></i><i ng-bind="news.summary|limitTo:20"></i></div>
			</div>
		</div>
	</div>
			
			
		</div>
		<div class="buttons">
			<button class="load" ng-click="displayMore()"
				ng-bind="btnnmae"></button>
		</div>
	</div>
</body>
<!-- Angular JS -->
<!-- Angular JS -->
<script src="/r/js-src/web/news/NewsList.js"></script>