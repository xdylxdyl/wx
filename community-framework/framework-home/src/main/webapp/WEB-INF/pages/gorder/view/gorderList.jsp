<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/shopping.css" rel="stylesheet">

<div class="webName autoSize textCenter grayButton"><span class="icon">M</span>乐购订单</div>
<div class="autoSize orderList" ng-app="orderListApp" ng-controller="orderListController" ng-cloak>
	
	<div class="textCenter noData" ng-show="orderList.length == 0"><div class="icon">M</div>暂无订单信息<br><a href="/p/goods">去购物</a></div>
	<div ng-repeat="order in orderList">
		<dl class="clear">
			<dt>订单号：</dt>
			<dd ng-bind="order.code"></dd>
			<dt>下单日期：</dt>
			<dd ng-bind="order.createAt|date:'yyyy-MM-dd HH:mm:ss'"></dd>
			<dt>状态：</dt>
			<dd ng-switch on="order.status">
				<a href="/p/u/pay?gorderID={{order.id}}" ng-show="order.status == 1" class="right">去支付</a>
				<span ng-switch-when="1" class="left red">已下单待付款</span>
				<span ng-switch-when="2">已退单</span>
				<span ng-switch-when="3">过期已取消</span>
				<span ng-switch-when="4">已付全款</span>
				<span ng-switch-when="5">已全部签收</span>
				<span ng-switch-when="6">付款中</span>
	            <span ng-switch-when="7">支付失败</span> 
			</dd>
			<dt>取货地址：</dt>
			<dd ng-bind="order.paddress.address"></dd>
			<dt>取货人：</dt>
			<dd ng-bind="order.address.name+'  '+(order.address.sex=='male'?'先生':'女士')+'  '+order.address.phone"></dd>
			<dt>总金额：</dt>
			<dd ng-bind="'￥'+order.total"></dd>
			<dt>商品信息：</dt>
			<dd><a href="javascript:void(0);" class="blueButton open" ng-click="toggle(order)" ng-bind="target == order.id?'收缩':'展开'"></a></dd>
		</dl>
		<div class="productList" ng-show="target == order.id">
			<div class="prdocut clear" ng-repeat="goods in order.goodsList">
				<div class="pic left"><img ng-src="{{goods.img}}"></div>
				<div class="info2 left">
					<div class="box clear">
						<h1 ng-bind="goods.name"></h1>
						<div class="price clear">
							<i class="left" ng-bind="'￥'+goods.price"></i>
							<i class="market left" ng-bind="'￥'+goods.originalPrice"></i>
						</div>
						<div class="status" ng-switch on="goods.status"> 
							<span ng-bind="'数量：'+goods.count"></span>
							(
							<span ng-switch-when="1" class="red">受理中</span>
							<span ng-switch-when="2" class="red">待签收</span>
							<span ng-switch-when="3" class="red">已签收</span>
							<span ng-switch-when="4" class="red">退货申请中</span>
							<span ng-switch-when="5" class="red">已退货</span>
							<span ng-switch-when="6" class="red">换货申请中</span>
							<span ng-switch-when="7" class="red">已换货</span>
							)
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="buttons" ng-show="orderList.length > 0">
		<button class="load" ng-click="addMore()" ng-bind="addMoreInfo" ng-disabled="addMoreInfo=='木有更多商品啦'"></button>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/gorder/gorderList.js"></script>
