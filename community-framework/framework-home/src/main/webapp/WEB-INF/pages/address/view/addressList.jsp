<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-title" content="title" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta content="telephone=no" name="format-detection" />
<title>收货人列表</title>
<link href="/r/html/styles/user.css" rel="stylesheet">
</head>

<body>
<div id="addressApp" ng-app="addressApp">
    <div ng-controller="addressController"  ng-cloak>
        <input type="hidden" name="from" id="from" value="${from}">
        
	<div class="webName autoSize textCenter grayButton"><span class="icon">N</span>收货人列表</div>
        
        <div class="titleName">默认收货人</div>
        <ul class="info" ng-repeat="address in addressList" ng-if="$first">
            <li class="last" ng-click="chooseaddress(address)">
            <span  ng-bind="address.name"></span>
            <span  ng-bind="address.sex=='male'?'先生':'女士'"></span>
            <span  ng-bind="address.phone"></span>
            </li>
        </ul>
        <div class="titleName">其他收货人</div>
        <div  class="info">
        <ul ng-repeat="address in addressList" ng-if="!$first">
            <li ng-class="!$last?'clear ':'clear  last'" ng-click="chooseaddress(address)">   
            <span  ng-bind="address.name"></span>
            <span  ng-bind="address.sex=='male'?'先生':'女士'"></span>
            <span  ng-bind="address.phone"></span>
    <a href="#" class="right" ng-show="showbutton" ng-click="updateAddress(address.id)">编辑</a>
 
            </li>
        </ul>
        </div>
    
        	<div class="textCenter new">
		<button class="blueButton"  ng-click="addAddress(address)">+ 新增收货人</button>
		<div class="textRight goback">
			<a href="/p/u/user">返回我的资料页</a>
		</div>
	</div>
        
    </div>
</div>
</body>


<script src="/r/js-src/web/address/addressList.js"></script>

</html>
