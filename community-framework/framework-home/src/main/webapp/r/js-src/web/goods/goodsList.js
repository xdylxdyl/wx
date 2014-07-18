

var goodsModule=angular.module("goodsApp",[
                                   "rest-resource"
   ]);
goodsModule.controller('goodsController', function ($scope, $http, $resource) {
  
    
    $scope.goods = {};
    $scope.content = {};
    $scope.size = 5;
    
    $scope.defName = "全部";
    
    var getGoodsByCategory = $resource('/p/a/getGoodsByCategory/:categoryID');
    var getGoodsByTag = $resource('/p/a/getGoodsByTag/:tagID');
    // init get all category
    getCategory($scope, $http);
    
    $scope.getGoodsByTag = function(tagId){
    	$scope.addMoreInfo = "点击载入更多";
    	
    	$scope.content.type = "tag";
    	$scope.content.tagId = tagId;
    	// TODO get good by tagId
    	$scope.content.page = 1;
    	getGoodsByTag.get({tagID: tagId, page: $scope.content.page, size: $scope.size}, function(data){
    		if  (data.code==0) {
    			$scope.goods = data.data;
    			console.log("tagId", tagId, $scope.goods);
    		}
    	});
    };
    
    $scope.getGoodsByCategory = function(categoryId) {
    	$scope.addMoreInfo = "点击载入更多";
    	
    	$scope.content.type = "category";
    	$scope.content.categoryId = categoryId;
    	
    	// TODO get goods by categoryId
    	$scope.content.page = 1;
    	getGoodsByCategory.get({categoryID: categoryId, page: $scope.content.page, size: $scope.size}, function(data){
    		if  (data.code==0) {
    			$scope.goods = data.data;
    			console.log("goods",$scope.goods, data);
    		}
    	});
    };
    
    $scope.addMore = function() {
    	console.log($scope.content.type);
    	switch ($scope.content.type) {
    		case "tag": // add more by tagId
    			$scope.content.page ++;
    			getGoodsByTag.get({tagID: $scope.content.tagId, page: $scope.content.page, size: $scope.size}, function(data){
    				if  (data.code==0) {
    					if (data.data.length==0) {
    						$scope.addMoreInfo = "木有更多商品啦";
    					} else {
    						$scope.goods = $scope.goods.concat(data.data);
    					}
    	    		}
    			});
    			break;
    		case "category":  // add more by categoryId
    			$scope.content.page ++;
    			getGoodsByCategory.get({categoryID: $scope.content.categoryId, page: $scope.content.page, size: $scope.size}, function(data){
    				if  (data.code==0) {
    					if (data.data.length==0) {
    						$scope.addMoreInfo = "木有更多商品啦";
    					} else {
    						$scope.goods = $scope.goods.concat(data.data);
    					}
    	    		}
    			});
    			break;
			default:
				break;
    	}
    };
    
    // category change 
    $scope.categoryChange = function(c) {
    	$scope.selectedCategoryID = c.id;
    	$scope.getGoodsByCategory($scope.selectedCategoryID);
    	$scope.defName= c.name;
    	$(".classList").fadeOut(200);
    	$(".classBg").fadeOut(200);
    	$("#tabs li:first").find("span").text("H");
    	$("#tabs li:first").removeClass("this");
    	status = 0;
    };
    
    $scope.goodsDetail = function(goodsId) {
    	location.href = '/p/goods/'+goodsId;
    };
    
    // init get all goods
    $scope.getGoodsByCategory(-1);
    
    $scope.formatPrice = function(price) {
    	var price = parseFloat(price);
    	return price.toFixed(2);
    }
    
});

// get categorys 
function getCategory($scope, $http) {
	
	$scope.category = categorys;
	
	$scope.selectedCategoryID = $scope.category[0].id;
}
//angular.bootstrap(document.getElementById("goodsApp"),['goodsApp']);



