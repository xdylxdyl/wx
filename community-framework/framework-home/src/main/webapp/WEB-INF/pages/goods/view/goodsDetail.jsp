<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<link href="/r/html/styles/order.css" rel="stylesheet" />

<div class="review">
	<h1>${goods.publishName }</h1>
	<div class="pic"><img src="${goods.img }"></div>
	<ul class="ment clear">
		<li class="break"><span>乐购价：</span><i class="price" id="price">￥${goods.price }</i></li>
		<li class="break"><span>市场价：</span><i class="market" id="oPrice">￥${goods.originalPrice }</i></li>
		<li><span>乐购期：</span><date:date pattern="yyyy-MM-dd" value="${goods.publishStart}" ></date:date>至<date:date pattern="yyyy-MM-dd" value="${goods.publishEnd}"></date:date> </li>
		<li class="clear"><span>供应商：</span>${provider.name}<i class="right data" style="${goods.count < 0 ?'display:none' : ''}">库存${goods.count}件</i></li>
		<li class="clear">
			<a href="javascript:void(0)" class="right dialogs" id="commentStatus">查看购买须知 &gt;&gt;</a>
			<span class="left">数　量：</span>
			<div class="number left" style="display:${goods.count == 0 ?'none' : 'block'}">
				<a href="javascript:void(0)" id="decNum" onclick="decNum();" >-</a>
				<em class="left textCenter" id="num">${goods.count==0?0:1}</em>
				<a href="javascript:void(0)" id="addNum" onclick="addNum();" >+</a>
			</div>
			<div class="left" style="display:${goods.count == 0 ?'block' : 'none'};color:#c30013">
				售罄
			</div>
		</li>
		<li class="info">
			${goods.detail }
		</li>
	</ul>
</div>

<div class="buy textCenter absNav clear">
	<button class="redButton right ${goods.count == 0? 'disabled' : ''}" onclick="buyNow();" ${goods.count==0?'disabled':''}>立即购买</button>
	<span class="left">总价：￥<i id="allPrice">${goods.count == 0?0:goods.price}</i></span>
</div>
<script>
	var num = 1,
		price = ${goods.price },
		oPrice = ${goods.originalPrice},
		commentStatus = ${goods.commentStatus},
		count = ${goods.count },
		goodsId = ${goods.id};
	if (commentStatus==1) {
		$("#commentStatus").hide();
	}
	function renderAddAndDec() {
		if (num==1) {
			$("#decNum").addClass("disabled");
		} else {
			$("#decNum").removeClass("disabled");
		}
		if (num==count) {
			$("#addNum").addClass("disabled");
		} else {
			$("#addNum").removeClass("disabled");
		}
	}
	renderAddAndDec();
	
	function formatPrice(price) {
		var price = parseFloat(price);
		return price.toFixed(2);
	}
	
	console.log(count, price, formatPrice(price));
	if (count>0) {
		$("#allPrice").html(formatPrice(price));	
	}
	$("#price").html("￥"+formatPrice(price));
	$("#oPrice").html("￥"+formatPrice(oPrice));
	
</script>
	<script>
		$(".dialogs").bind("click",function() {
			$("body").dialogs({
				url : "/p/goods/${goods.id}/comment",
				width : "100%",
				height : "100%",
				title : "查看购买须知",
				className : "info"
			});
		});
	</script>
<script src="/r/js-src/web/goods/goodsDetail.js"></script>