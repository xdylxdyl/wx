

var cartGoodsRelationDetailModule=angular.module("cartGoodsRelationDetailApp",[]);
cartGoodsRelationDetailModule.controller('cartGoodsRelationDetailController', function ($scope, $http) {
	 $scope.cartGoodsRelation = {};
	 var id = $("#cartGoodsRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/cartGoodsRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.cartGoodsRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(cartGoodsRelation){
	 		
	 		if ($scope.cartGoodsRelationForm.$invalid) {
    			$scope.cartGoodsRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(cartGoodsRelation);
		    	$scope.cartGoodsRelation  = cartGoodsRelation;
		    	$scope.cartGoodsRelation.id = $("#cartGoodsRelationId").val();
		    	//add
		    	if($scope.cartGoodsRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/cartGoodsRelation',data:formData($scope.cartGoodsRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/cartGoodsRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/cartGoodsRelation/'+$scope.cartGoodsRelation.id,data:formData($scope.cartGoodsRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/cartGoodsRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("cartGoodsRelationDetailApp"),['cartGoodsRelationDetailApp']);



