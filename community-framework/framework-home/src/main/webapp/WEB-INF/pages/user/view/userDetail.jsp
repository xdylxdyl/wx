<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-title" content="title" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta content="telephone=no" name="format-detection" />
<title>Order</title>
<link href="/r/html/styles/user.css" rel="stylesheet">
</head>
<body>
	<div id="userDetailApp" ng-app="userDetailApp">
		<div ng-controller="userDetailController"  ng-cloak>
			<form  role="form" name="userForm" ng-show="showform">			
<div class="form-group" ng-show="false" style="display:none;">
    <label  for="id" class="col-sm-2 control-label">id</label>
    <input disabled="disabled" type="text" class="input8" name="id" id="id" ng-model="user.id" value="${user.id}" placeholder="请输入id">
</div>
					
<!-- <div ng-show="showcommit" class="webName autoSize textCenter grayButton">
								<span class="icon">O</span>编辑
							</div> -->
							
<div  class="user autoSize clear">
<div  class="box">
								<div class="face left">
									<img src="${potential.img}">
								</div>
								<div class="name left">
									<span>${potential.nick}<br>
									</span>
								</div>
							</div>
				</div>

<ul class="nav autoSize">
    <li  class="clear"><span class="left">姓名</span>
 
        <input ng-readonly="!showinputname" type="text" class="input8" name="name" id="name" ng-model="user.name" placeholder="请输入您的姓名*" required ng-maxlength="12">
    </li>
    <li  class="clear"><span class="left">称呼</span>
 
        <div class="selectModel clear relative">    <i class="right icon" ng-show="showcommit">C</i><i class="left" id="sex" ng-bind="user.sex=='male'?'先生':'女士'"></i>
 
            <select ng-show="showcommit" class="absolute" id="sexSet" ng-model="user.sex" ng-options="c.sex as c.name for c in sexlist"></select>
        </div>
    </li>
    <li  class="clear"><span class="left">电话</span> 
        <input ng-readonly="!showinputmobile" type="text" class="input8" name="mobile" id="mobile" ng-model="user.mobile" placeholder="请输入11位手机号*" required>
    </li>
    
    <li class="clear oli"><span class="left">收货人</span>
    <div class="selectModel clear relative" onclick="location.href='/p/u/addresslist'"><i class="right icon">C</i>
    <i class="left" id="sex" ng-bind="user.name">
    <!-- <select class="absolute" ng-model="address.id" ng-options="c.id as c.name+(c.sex=='male'?'   先生':'   女士') for c in addresslist"></select> -->
    </i>
    </div></li>
    
    
<!--     <li class="oli"><span class="left">收货人</span>
 
        <div ng-show="showcommit" onclick="location.href='/p/u/addresslist'" class="selectModel clear relative"><i class="right icon">C</i>
        	<i class="left" id="sex" ng-bind="user.name"></i> 
        </div>
        <div ng-show="!showcommit" class="selectModel clear relative"><i class="right icon" onclick="location.href='/p/u/addresslist'">C</i><i class="right relative topZindex"></i>
		    <i class="left" id="sex" ng-bind="user.name"></i> 
		            <select class="absolute" ng-model="address.id" ng-options="c.id as c.name for c in addresslist"></select>
        </div>
    </li> -->
</ul>

<div class="textCenter">
    <button ng-show="showcommit" class="redButton autoSize editBt" ng-click="updateuser(user)">提交</button>
    <button ng-show="!showcommit" class="newButton autoSize editBt icon" ng-click="editUser()">O 编辑</button>
</div>
			
			
			
			</form>
		</div>
	</div>
</body>
<script src="/r/js-src/web/user/userDetail.js"></script>
</html>
