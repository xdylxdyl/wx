/**
 * Created by magenm on 2014/4/30.
 */

var app = angular.module('orderListApp', [
    "ngRoute",
    "rest-resource"
]);

app.controller('orderListController', ['$rootScope', '$scope', 'Resource', function($rootScope, $scope,$resource){

    $scope.target == -1;
    $scope.orderList = [];
    $scope.page = 1;
    $scope.size = 6;
    $scope.addMoreInfo = "点击载入更多";
    
    var Order = $resource('/p/u/a/gorder');
	Order.get({page:$scope.page,size:$scope.size},function(data){
		$scope.orderList = data.data;
		console.log("data",data.data);
	});
    
    $scope.toggle = function(order){
    	var target = order.id;
        console.log(target);
        if(target ==  $scope.target){
            $scope.target  = -1;
        }else{
            $scope.target =  target;
            
            var OrderList = $resource('/p/u/a/gorder/:OrderID',{OrderID:"@id"});
            OrderList.get({OrderID:target},function(data){
            	console.log("goodsList",data.data);
            	order.goodsList = data.data;
            });
            
        }
    };
    
    $scope.addMore = function() {

		$scope.page ++;
		Order.get({page:$scope.page,size:$scope.size},function(data){
			if (data.data.length==0) {
				$scope.addMoreInfo = "木有更多订单啦";
			} else {
				$scope.orderList = $scope.orderList.concat(data.data);
			}
		});
    		
    };


}]);
