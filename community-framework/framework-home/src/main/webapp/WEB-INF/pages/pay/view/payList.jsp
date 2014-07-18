<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="infoList autoSize">
	<ul class="info">
		<li>订  单 号： ${gorder.code }</li>
		<li>订单金额：<span class="price">￥${gorder.total}</span></li>
	</ul>
	<div class="name">请选择支付方式，并尽快付全款：</div>
	<button class="bankBt" onclick="javscript:window.location.href='/p/u/llPay?gorderID=${gorder.id }';">银联支付</button>
	<button class="bankBt" onclick="javscript:window.location.href='/p/u/aliPay?gorderID=${gorder.id }';">支付宝支付</button>
	<button class="moneyBt" onclick="javscript:window.location.href='/p/u/cashPay?gorderID=${gorder.id }';">现金支付</button>
</div>

