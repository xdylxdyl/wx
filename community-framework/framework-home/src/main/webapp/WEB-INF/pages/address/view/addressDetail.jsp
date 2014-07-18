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
<title>title</title>
<link href="/r/html/styles/user.css" rel="stylesheet">
</head>

<body><div id="addressDetailApp" ng-app="addressDetailApp">
    <div ng-controller="addressDetailController"  ng-cloak>
        <form class="form-horizontal" role="form" name="addressForm">
            <c:choose>
                <c:when test="${id > 0}">
                    <div class="webName autoSize textCenter grayButton"><span class="icon">N</span>编辑收货人</div>
                </c:when>
                <c:otherwise>
                    <div class="webName autoSize textCenter grayButton"><span class="icon">N</span>新增收货人</div>

                </c:otherwise>
            </c:choose>
            <ul class="nav autoSize">
                <input type="hidden" name="id" id="addressId" ng-model="address.id" ng-bind="address.id" value="${id}">
                <li><span class="left">姓名</span>
 
                    <input type="text" class="input8" name="name" id="name" ng-model="address.name" placeholder="请输入您的姓名*" required="" ng-maxlength="12">
                </li>
                <li><span class="left">称呼</span>
 
                    <div class="selectModel clear relative">    <i class="right icon">C</i><i class="left" id="sex" ng-bind="address.sex=='male'?'先生':'女士'"></i>
 
                        <select class="absolute" id="sexSet" ng-model="address.sex" ng-options="c.sex as c.name for c in sexlist"></select>
                    </div>
                    </li><li><span class="left">电话</span> 
                        <input type="tel" class="input8" name="phone" id="phone" ng-model="address.phone" placeholder="请输入11位手机号*" required="">
                    </li>
            </ul>
            <div class="textCenter">
                <button class="redButton autoSize editBt" ng-click="updateaddress(address)">保存</button>
               <!--  <button class="redButton autoSize editBt" ng-click="deleteAddress(address.id)">移除</button> -->
            </div>
        </form>
    </div>
</div>
</body>
<script src="/r/js-src/web/address/addressDetail.js"></script>
</html>

