/**
 * 依赖jquery-2.0.js
 * 使用方法：
 * e.g.1-getJSON:	Request.getJSON("/a/logout",
						function(data) {
							location.href = data.result;
						});
 * 
 * e.g.2-post:		Request.post("/web/a/publics/add", {
						name: $("#name").val(),
						appID: $("#appID").val(),
						appSecret: $("#appSecret").val(),
						account: $("#account").val(),
						pwd: $("#pwd").val()
					}, function(result) {
				    	window.location.reload();
					});
 *
 * e.g.3-delAjax:	Request.delAjax("/web/a/publics/del/"+id,
						function(result) {
					    	window.location.reload();
					    });
 *					
 */

var Request = Request || {};
Request.getJSON = function(url, callback) {
	$.getJSON(url, {},
		function(res) {
			var result = res;
			if (typeof(res)=="string") {
				result = JSON.parse(res);
			} 
			
			if (result.code!=0) {
				bootbox.alert({
					title: "错误代码："+result.code,
					message:result.message});
			}
			//bootbox.alert({title:"错误代码："+data.code, message:data.message});
			callback(result);
		});
}

Request.post = function(url, data, callback) {
	$.post(url, data, 
		function(res) {
			var result = res;
			if (typeof(res)=="string") {
				result = JSON.parse(res);
			} 
			
			if (result.code!=0) {
				bootbox.alert({
					title: "错误代码："+result.code,
					message:result.message});
			}
			callback(result);
		});
}

Request.delAjax = function(url, callback) {
	$.ajax({
	    url: url,
	    type: 'DELETE',
	    success: function(res) {
	    	var result = res;
			if (typeof(res)=="string") {
				result = JSON.parse(res);
			}
			
	    	if (result.code!=0) {
				bootbox.alert({
					title: "错误代码："+result.code,
					message:result.message});
			}
			callback(result);
	    }
	});
}