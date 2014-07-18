<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-title" content="title"/>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta content="telephone=no" name="format-detection" />
<title>Order</title>
<link href="/r/html/styles/user.css" rel="stylesheet">
</head>

<body>
	<div class="user autoSize clear">
		<div class="box">
			<div class="face left"><img src="${potential.img}"></div>
			<div class="name left">
				<span>${potential.nick}</span>
			</div>
		</div>
	</div>
	<ul class="nav autoSize">
		<li class="clear" onclick="javascript:window.location.href='/p/u/user'"><span class="icon left setting">N</span><i>我的资料</i></li>
		<li class="clear" onclick="javascript:window.location.href='/p/u/gorder'"><span class="icon left setting">R</span><i>乐购订单</i></li>
	</ul>
</body>
</html>
