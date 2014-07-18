/**
 * Created by magenm on 2014/4/30.
 */

var cartModule = angular.module('cartApp', [
    "ngRoute",
    "rest-resource"
]);

cartModule.controller('cartController', 
		['$rootScope', '$scope', 'Resource','$location', 
		 function($rootScope, $scope,$resource,$location){
    
	$scope.isSubmit = false;
			
	var Cart = $resource('/p/u/a/cart');
	Cart.get(function(data){
		$scope.cartList = data.data;
		console.log(!$scope.cartList,$scope.cartList.length == 0);
		if(!$scope.cartList || $scope.cartList.length == 0){
			//location.href = '/p/goods';
		}
		
		$scope.cartID = data.cartID;
		console.log("data",data.data);
	});
    
	$scope.minus = function(cart){
		//购买数量最小为1
        if(cart.buyCount > 1){
        	cart.buyCount = parseInt(cart.buyCount) - 1;
        }
    };

    $scope.plus = function(cart){
    	//库存量
        var num = parseInt(cart.count); 
        if(cart.buyCount < num){
        	cart.buyCount = 1+parseInt(cart.buyCount);
        }
    };

    $scope.del = function(cart){
    	$scope.cartList.splice($scope.cartList.indexOf(cart),1);
    	if($scope.cartList.length == 0){
			//location.href = '/p/goods';
		}
    };
    
    var Cart = $resource('/p/u/gv/a/cartGoodsRelation');
    $scope.save = function(){
    	
    	filterData($scope);
    	
        Cart.create({},"cartGoodsRelation="+JSON.stringify($scope.list),function(data){
        	 if(data.code == 0){
             	$("body").dialogs({
        			html : "<div class=\"msg\">保存成功</div>",
        			width : "80%",
        			title : "提示信息",
        			outTime  : 3000
        		});
             }else{
             	$("body").dialogs({
        			html : "<div class=\"msg\">"+data.message+"</div>",
        			width : "80%",
        			title : "提示信息",
        			outTime  : 3000
        		});
             }
        });
        
    };
    
    $scope.submit = function(){
    	$scope.isSubmit = true;
    	filterData($scope);
    	
    	Cart.create({},"cartGoodsRelation="+JSON.stringify($scope.list),function(data){
    		console.log("data",data);
    		if(data.code == 0){
        		location.href = '/p/u/finishGorder';
    		}else{
    			$scope.isSubmit = false;
             	$("body").dialogs({
        			html : "<div class=\"msg\">"+data.message+"</div>",
        			width : "80%",
        			title : "提示信息"
        		});
            }
    	});
    };
    
    $scope.goShopping = function(){
    	
    	filterData($scope);
    	
        Cart.create({},"cartGoodsRelation="+JSON.stringify($scope.list),function(data){
        	location.href = '/p/goods';
        });
    };
}]);

function filterData($scope){
	$scope.list = [];
	angular.forEach($scope.cartList,function(value,key){
		var tmp = {};
		tmp.goodsID=value.id;
		tmp.cartID=$scope.cartID;
		tmp.count = value.buyCount;
		tmp.createBy = -1;
		tmp.updateBy = -1;
		$scope.list.push(tmp);
	});
}

cartModule.filter("totalPrice",function(){
    return function(cartList){
        var count = 0;
        if(cartList){
	        for(var i=0;i<cartList.length;i++){
	           count += parseFloat(cartList[i].price) * parseInt(cartList[i].buyCount);
	        }
        }
        return count;
    };
});

cartModule.filter("totalNumber",function(){
    return function(cartList){
        var count = 0;
        if(cartList){
	        for(var i=0;i<cartList.length;i++){
	           count += parseInt(cartList[i].buyCount);
	        }
        }
        return count;
    };
});




