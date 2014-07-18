<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="scrollable" ng-app="paddressApp" ng-controller="paddressController">
	<div class="webName autoSize textCenter grayButton"><span class="icon">S</span>取货地址</div>

	<div class="infoList autoSize" >
	
		<div class="name">默认取货地址：</div>
		<div ng-repeat="paddress in paddressList" ng-if="$index==0">
			<ul class="info" ng-click="select(paddress)">
				<li class="clear">
					<a href="javascript:void(0);" class="left" ng-bind="paddress.name"></a>
				</li>
				<li ng-bind="'地址：'+paddress.address"></li>
				<li ng-bind="'电话：'+paddress.phone"></li>
			</ul>
		</div>
		
		<div class="name" ng-show="paddressList.length > 1">其他取货地址：</div>
		<div ng-repeat="paddress in paddressList" ng-if="$index>0">
			<ul class="info" ng-click="select(paddress)">
				<li class="clear">
					<a href="javascript:void(0);" class="left" ng-bind="paddress.name"></a>
				</li>
				<li ng-bind="'地址：'+paddress.address"></li>
				<li ng-bind="'电话：'+paddress.phone"></li>
			</ul>
		</div>
	</div>
</div>		

<!-- Angular JS -->
<script src="/r/js-src/web/paddress/paddressList.js"></script>
