<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="infoList autoSize">
		<ul class="info">
			<li>订  单 号： ${gorder.code }</li>
			<li>订单金额：<span class="price">￥${gorder.total}</span></li>
		</ul>
		<div class="name">您选择了现金结算方式。请至以下地址：</div>
		<div class="info clear">
			${paddress.name }<br>
			地址：${paddress.address }<br>
			电话：<a href="tel:${paddress.phone }">${paddress.phone }</a><br>
			<br>
			出示订单号，支付货款全款。<br>
			<div class="textRight"><a href="/p/u/pay?gorderID=${gorder.id }">选择其他结算方式</a></div>
			<br>
			<div class="textRight"><a href="/p/goods">查看更多乐购货品及活动</a></div>
		</div>
	</div>


