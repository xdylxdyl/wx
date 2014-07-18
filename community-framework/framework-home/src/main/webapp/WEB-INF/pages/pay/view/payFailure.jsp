<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>


<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="msg autoSize clear textCenter">
	<span class="icon">G</span>
	呃，在线支付失败…
	<div class="text">您可以：</div>
</div>
<ul class="backLink autoSize">
	<li class="clear" onClick="javascript:window.href='/p/u/pay?gorderID=${gorder.id }';"><span class="icon right">C</span>选择其他支付方式 …</li>
	<li class="clear" onClick="javascript:window.href='/p/goods"><span class="icon right">C</span>查看更多乐购货品及活动</li>
	<li class="clear blueButton textCenter oli" onClick="javascript:window.href='/p/u/gorder';">查看我的乐购订单</li>
</ul>


