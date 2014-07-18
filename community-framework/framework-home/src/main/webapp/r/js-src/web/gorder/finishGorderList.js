/**
 * Created by magenm on 2014/4/30.
 */

var orderModule = angular.module('orderApp', [
    "ngRoute",
    "ngCookies",
    "rest-resource"
]);

orderModule.controller('orderController', ['$rootScope', '$scope', 'Resource','$cookieStore', function($rootScope, $scope,$resource,$cookieStore){

    $scope.orderList =[];
    $scope.address = {};
    $scope.paddress = {};
    
    var Cart = $resource('/p/u/a/cart');
	Cart.get(function(data){
		$scope.orderList = data.data;  
		console.log("Cart data",data.data);
	});
	
	
	var defaultAddressString=window.localStorage["addresstransfer"];
	var defaultAddress =null;
	if(defaultAddressString!=null){
		defaultAddress= JSON.parse(defaultAddressString);
	}
	
	if(defaultAddress){
		$scope.address = defaultAddress;
	}else{
		var Address = $resource('/p/u/a/address');
		Address.get(function(data){
			if(data.data){
				$scope.address = data.data[0];
				console.log("Address data",data.data);
			}
		});
	}
	
	var defaultPaddress = $cookieStore.get("paddress");
	console.log("defaultPaddress",defaultPaddress);
	if(defaultPaddress){
		$scope.paddress = defaultPaddress;
	}else{
		var Paddress = $resource('/p/a/paddress');
		Paddress.get(function(data){
			if(data.data){
				$scope.paddress = data.data[0];
				console.log("Paddress data",data.data);
			}
		});
	}

    $scope.modifyPaddress=function(order){
        location.href="/p/u/paddress";
    };
    
    $scope.modifyAddress=function(order){
        location.href="/p/u/addressSelectList";
    };

    $scope.goPay = function(){
    	
    	 var count = 0;
         for(var i=0;i<$scope.orderList.length;i++){
             count += parseFloat($scope.orderList[i].price) * parseInt($scope.orderList[i].buyCount);
         }
    	
    	var Pay = $resource('/p/u/gv/a/gorder');
    	Pay.create({},"type=pay&addressID="
    			+$scope.address.id+"&paddressID="+$scope.paddress.id+"&total="+count,function(data){
    		console.log(data);
    		if(data.code == 0){
    			location.href = '/p/u/pay?gorderID='+data.gorderID;
    		}else {
    			bootbox.alert(data.message);
    		}
    	});
    	
        //检查库存
        //alert("啊哦，这次的大兴西瓜已经卖完了~ 请返回 购物车 进行修改");
        //location.href="pay.html"
    }
}]);

orderModule.filter("totalPrice",function(){
    return function(cartList){
        var count = 0;
        for(var i=0;i<cartList.length;i++){
            count += parseFloat(cartList[i].price) * parseInt(cartList[i].buyCount);
        }
        return count;
    };
});
orderModule.filter("phoneFilter",function(){
    return function(phone){
    	if(phone){
    		 return phone.replace(/(\d{3})\d{4}(\d{4})/, '$1****$2');
    	}
       return phone;
    };
});
