
$("#news").addClass("active");
$("#news").parent().parent().addClass("active");

var appnewsDetailModule=angular.module("NewsDetailApp",["ngSanitize"]);
appnewsDetailModule.controller('NewsDetailController', function ($scope, $http, $sce) {
	 $scope.news = {};
	 var mark = $("#newsId").val();
	 console.log("mark is :"+mark);
	 $scope.content = '';
	 // 编辑是获取数据
	 if(mark > 0){
		 $http({method : 'GET' , url:'/a/news/'+mark}).success(function( data , status ){
				if( status == '200'){
					console.log(data);
					console.log(data.data);
					 $scope.news = data.data;
					 window.document.title = $scope.news.title;
					 $scope.content=$sce.trustAsHtml(myHTMLDeCode($scope.news.content));
					 //console.log( $scope.content);
					 //$("#content").html(myHTMLDeCode(str));
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.transformRequest = [ function(data){
	  		    return $.param(data);
	 }];
	    
});


function myHTMLDeCode(str) {
    console.log(str);
    var s = "";
    if (str.length == 0) return "";
    s = str.replace(/&amp;/g, "&");
    s = s.replace(/&lt;/g, "<");
    s = s.replace(/&gt;/g, ">");
    s = s.replace(/&nbsp;/g, " ");
    s = s.replace(/&#39;/g, "\'");
    s = s.replace(/&quot;/g, "\"");
    s = s.replace(/<br>/g, "\n");
    s = s.replace(/&#034;/g, "\"");
    console.log(s);
    return s;
}

angular.bootstrap(document.getElementById("NewsDetailApp"),['NewsDetailApp']);