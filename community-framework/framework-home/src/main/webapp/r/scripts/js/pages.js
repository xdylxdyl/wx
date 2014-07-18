/**
 * 简易分页js
 * 依赖包：jquery-2.0.js,bootstrap.js/bootstrap.min.js
 * 使用条件：
 *   1.页面url参数只有page，无其他参数。
 *   2.单个页面只能有一个分页控件。
 *   3.后台传回参数中有page。
 * 使用方法：引入包以后，在需要添加该控件的地方加入 <div data-role="pagination" page="${page }"></div>
 */
// 获取基础路径
function getBasepath(){
	var url=window.location.href;//如果想获取框架顶部的url可以用 top.window.location.href
	return url.split("?")[0];
}
// 跳转至i页；小于1则跳转到第一页，没有页数上限（可日后完善）。
function goPage(i) {
	var index = 1;
	if (typeof(i)=="object") {
		index = $(i).val();
	} else {
		index = i;
	}
	if (index<1) {
		index = 1;
	}
	window.location.href = getBasepath() + "?page=" + index;
}
$(document).ready(function(){
	var page = parseInt($("div[data-role=pagination]").attr("page"));
	var str = "<ul class=\"pagination\">"+
			"<li><a href=\"javascript:goPage("+(page-10)+");\">&laquo;</a></li>"+
			"<li><a href=\"javascript:goPage("+(page-1)+");\">&lsaquo;</a></li>"+
			"<li><span style=\"height:32px;padding:3px;\">第 <input type=\"text\" value=\""+page+"\" style=\"height:28px;width:40px;\" onblur=\"goPage(this);\"> 页</span></li>"+		"<li><a href=\"javascript:goPage("+(page+1)+");\">&rsaquo;</a></li>"+
			"<li><a href=\"javascript:goPage("+(page+10)+");\">&raquo;</a></li>"+
		"</ul>";
	$("div[data-role=pagination]").html(str);
});
	
