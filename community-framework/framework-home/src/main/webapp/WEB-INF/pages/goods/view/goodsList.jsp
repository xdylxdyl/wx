<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/shopping.css" rel="stylesheet" />

<div  ng-app="goodsApp" ng-controller="goodsController">		
	<div class="autoSize relative">
		<ul class="clear absNav tabName textCenter" id="tabs">
	         <li class="active left" ng-cloak>{{defName}}<span class="icon">H</span></li>
	         <li class="left" ng-click="getGoodsByTag(1)">龙湖特推</li>
	         <li class="left" ng-click="getGoodsByTag(2)">近期活动</li>
	     </ul>
	     <div class="classList absolute none">
	         <ul class="clear">
	             <li ng-repeat="c in category" ng-click="categoryChange(c)">
	             	<span ng-bind="c.name"></span>
	             </li>
	         </ul>
	     </div>
	     <div class="classBg absolute none"></div>
	 </div>
	 <div class="textCenter noData" ng-show="goods.length==0">暂无商品</div>
	<div class="order autoSize clear relative" ng-repeat="g in goods" ng-click="goodsDetail(g.id)">
		<div class="pic left"><img ng-src="{{g.img}}"></div>
		<div class="info right">
			<h1 ng-bind="g.publishName"></h1>
			<div class="price">
	           	<span ng-bind="'￥'+formatPrice(g.price)"></span>
	            <span class="market" ng-bind="'￥'+formatPrice(g.originalPrice)"></span>
	        </div>
	        <div class="more icon absolute">C</div>
		</div>
	</div>
	<div class="buttons">
		<button class="load" ng-click="addMore()" ng-bind="addMoreInfo" ng-disabled="addMoreInfo=='木有更多商品啦'"></button>
	</div>
</div>		

<script>
	var categorys = [{id: -1, name: "全部"}];
	
	var tabs = $("#tabs li"), status = 0, list = $(".classList"), bg = $(".classBg");
	tabs.bind("click",function() {
		if ($(this).index() == 0) {
			var h = $("body").height() > $(window).height() ? $("body").height() - tabs.outerHeight() : $(window).height();
			if (status == 0) {
				status = 1;
				$(this).addClass("this");
				$(this).find("span").text("B");
				bg.css({
					height: h
				}).fadeIn(200);
				list.fadeIn(200);
			}else{
				status = 0;
				$(this).removeClass("this");
				$(this).find("span").text("H");
				list.fadeOut(200);
				bg.fadeOut(200);
			}
			bg.bind("mousedown",function() {
				status = 0;
				tabs.removeClass("this");
				tabs.find("span").text("H");
				list.fadeOut(200);
				bg.fadeOut(200);
			});
		}else{
			status = 0;
			$("#tabs li:first").removeClass("this");
			$("#tabs li:first").find("span").text("H");
			list.fadeOut(200);
			bg.fadeOut(200);
		}
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
	});
</script>
<c:forEach items="${categorys}" var="c" begin="0" step="1" varStatus="status">
	<script>	
	var data = {};
	data.id = ${c.id };
	data.name = "${c.name }";
	
	categorys.push(data);
	</script>
</c:forEach>
<!-- Angular JS -->
<script src="/r/js-src/web/goods/goodsList.js"></script>
