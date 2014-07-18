<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="content">
	<table class="setTable">
		<c:forEach items="${comment}" var="c" begin="0" step="1"
			varStatus="status">
		<tr>
			<td valign="top" class="set">${c.key}</td>
			<td class="info">${c.value}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="confirmBt blueButton textCenter closeBt fixed" style="bottom:0;left:0;">我知道了</div>
</div>
