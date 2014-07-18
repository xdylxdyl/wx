

var cartDetailModule=angular.module("cartDetailApp",[]);
cartDetailModule.controller('cartDetailController', function ($scope, $http) {
	 $scope.cart = {};
	 var id = $("#cartId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/cart/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.cart = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(cart){
	 		
	 		if ($scope.cartForm.$invalid) {
    			$scope.cartForm.submitted = true;
	    	} else {
	 
		    	console.log(cart);
		    	$scope.cart  = cart;
		    	$scope.cart.id = $("#cartId").val();
		    	//add
		    	if($scope.cart.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/cart',data:formData($scope.cart)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/cart";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/cart/'+$scope.cart.id,data:formData($scope.cart)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/cart";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("cartDetailApp"),['cartDetailApp']);



