function decNum() {
	if (num > 1) {
		num--;
	}
	renderAddAndDec();
	allPrice = num * price;
	$("#num").html(num);
	$("#allPrice").html(allPrice.toFixed(2));
}

function addNum() {
	if (num < count || count < 0) {
		num++;
	}
	renderAddAndDec();
	allPrice = num * price;
	$("#num").html(num);
	$("#allPrice").html(allPrice.toFixed(2));
}


function buyNow() {
	// post num goodsId to cart
	$.ajax({
		url : "/p/u/a/addCart",
		data : {
			goodsID : goodsId,
			count : num,
		},
		type : "POST",
		success : function(data) {
			console.log(data);
			var data2 = JSON.parse(data);			
			switch (data2.code) {
			case 0:
				location.href = "/p/u/cart";
				break;
			case -2001:
				location.href = data2.url;
				break;
			default:
				$("body").dialogs({
	    			html : "<div class=\"msg\">"+data2.message+"</div>",
	    			width : "80%",
	    			title : "温馨提示"
	    		});
			}

		}
	});
}