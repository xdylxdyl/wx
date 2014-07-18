<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />
<div ng-app="orderApp" ng-controller="orderController">
	<div class="webName autoSize textCenter grayButton"><span class="icon">S</span>订购信息</div>
	
	<div class="infoList autoSize" >
	
		<div class="name">确认取货地址：</div>
		<ul class="info">
			<li class="clear">
				<a href="javascript:void(0);" class="right" ng-click="modifyPaddress(paddress)">修改</a>
				<a href="javascript:void(0);" class="left" ng-bind="paddress.name"></a>
			</li>
			<li ng-bind="'地址：'+paddress.address"></li>
			<li ng-bind="'电话：'+paddress.phone"></li>
		</ul>
		
		<div class="name">确认收货人信息：</div>
		<ul class="info">
			<li class="clear">
				<a href="javascript:void(0);" class="right" ng-click="modifyAddress(address)">修改</a>
				<a href="javascript:void(0);" class="left" ng-bind="address.name+'  '+(address.sex=='male'?'先生':'女士')"></a>
			</li>
			<li ng-bind="'手机号：'+(address.phone|phoneFilter)"></li>
		</ul>
		
		<div class="name">确认商品信息：</div>
		<div class="prdocut clear" ng-repeat="order in orderList">
			<div class="pic left"><img ng-src="{{order.img}}"></div>
			<div class="info2 left">
				<div class="box">
					<h1  ng-bind="order.name"></h1>
					<div class="price clear">
						<i class="left" ng-bind="'￥'+order.price"></i>
						<i class="market left" ng-bind="'￥'+order.originalPrice"></i>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<div class="buy textCenter absNav clear">
		<button class="redButton right" ng-click="goPay()">去支付</button>
		<span class="left" ng-bind="'总价：￥'+(orderList|totalPrice)"></span>
	</div>
</div>
<!-- Angular JS -->
<script src="/r/js-src/web/gorder/finishGorderList.js"></script>
