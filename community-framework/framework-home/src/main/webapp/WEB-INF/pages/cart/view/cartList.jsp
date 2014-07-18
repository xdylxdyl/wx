<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div ng-app="cartApp" ng-controller="cartController"  ng-cloak>
	<div class="webName autoSize textCenter grayButton"><span class="icon">R</span>购物车</div>
	<div class="order clear autoSize relative" ng-repeat="cart in cartList">
		<div class="pic left"><img ng-src="{{cart.img}}"></div>
		<div class="info left">
			<div class="box">
				<h1 ng-bind="cart.name"></h1>
				<div class="price" ng-bind="'￥'+cart.price"></div>
				<div class="number clear">
					<a ng-show="cart.buyCount <= 1" class="disabled" ng-bind="'-'"></a>
					<a ng-show="cart.buyCount > 1" href="javascript:void(0);" ng-click="minus(cart)">-</a>
					<em class="left textCenter" name="count" ng-bind="cart.buyCount" ng-model="cart.buyCount"></em>
					<a ng-show="cart.buyCount < cart.count" href="javascript:void(0);" ng-click="plus(cart)">+</a>
					<a ng-show="cart.buyCount >= cart.count" class="disabled" ng-bind="'+'"></a>
				</div>
			</div>
		</div>
		<a href="javascript:void(0);" class="delete absolute"  ng-click="del(cart)">删除</a>
	</div>
	
	<div class="textCenter noData" ng-show="cartList.length == 0">
		<div class="icon">R</div>购物车里暂时没有商品.<br>
		<a href="javascript:void(0);" ng-click="goShopping()">看看大家在买什么</a>
	</div>
	
	<div class="buy textCenter absNav clear">
		<button class="redButton right" ng-click="goShopping()" ng-show="cartList.length == 0">去购物</button>
		<button class="redButton right" ng-click="submit()" ng-disabled="isSubmit"  ng-show="cartList.length > 0">下订单</button>
		<a href="" class="save right" ng-click="save()"><span class="icon">E</span>保存</a>
		<span class="left" ng-bind="'共'+(cartList|totalNumber)+'件商品，￥'+(cartList|totalPrice)"></span>
	</div>
	
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/cart/cartList.js"></script>
</body>
</html>


