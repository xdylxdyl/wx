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

<body>
<input type="hidden" value="user" id="current_nav">
<div id="userDetailApp" ng-app="userDetailApp">
    <div ng-controller="userDetailController"  ng-cloak>
        <form class="form-horizontal" role="form" name="userForm">
	<div class="webName autoSize textCenter grayButton"><span class="icon">P</span>您还没注册，请先注册</div>
            
            <ul class="nav autoSize">
                <li>
                    <input type="text" class="input8" name="name" id="name" ng-model="user.name" placeholder="请输入您的姓名*" required ng-maxlength="12">
                </li>
                <li>
                    <div class="selectModel clear relative">    <i class="right icon">C</i><i class="left" id="sex" ng-bind="user.sex=='male'?'先生':'女士'"></i>
 
                        <select class="absolute" id="sexSet" ng-model="user.sex" ng-options="c.sex as c.name for c in sexlist"></select>
                    </div>
                </li>                
                <li><input  type="tel" name="mobile" id="mobile" ng-model="user.mobile" placeholder="请输入11位手机号*" required></li>
		<li class="clear"><button  class="right code textCenter red" id="sendcode" ng-bind="buttonvalue" ng-click="sendCode()">发送验证码</button>
		<input type="tel" class="left input7" name="verifyCode" id="verifyCode" ng-model="verifyCode" placeholder="请输入获取的验证码*" value="" required ng-maxlength="11">
		</li>
                
                
                
                <li class="oli">
                    <input type="text" ng-readonly="true" name="addressname" id="username" ng-model="user.name" placeholder="收货人">
                </li>
            </ul>
            <div class="textCenter">
                <button class="redButton autoSize editBt" ng-click="updateuser(user)">提交</button>
            </div>
        </form>
    </div>
</div>
</body>

<script src="/r/js-src/web/user/userDetail.js"></script>

</html>