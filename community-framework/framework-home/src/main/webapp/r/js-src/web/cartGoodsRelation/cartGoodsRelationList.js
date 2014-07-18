

var cartGoodsRelationModule=angular.module("cartGoodsRelationApp",[]);
cartGoodsRelationModule.controller('cartGoodsRelationController', function ($scope, $http) {
  
    
    $scope.cartGoodsRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addCartGoodsRelation = function(cartGoodsRelation){
    	$scope.cartGoodsRelation = cartGoodsRelation;
    	console.log(cartGoodsRelation);
    	location.href = '/web/c/cartGoodsRelation/0';
    };
    $scope.updateCartGoodsRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/cartGoodsRelation/'+id;
    };
    $scope.deleteCartGoodsRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/cartGoodsRelation/' + id}).success(function( data , status ){
    		if( status == '200'){
    			bootbox.alert(data.message,function(){
            		if(data.code == 0){
            			getData($http,$scope,$scope.currentPage);
            		}
            	});
    		}
    	});
    };
});


pageDirective(cartGoodsRelationModule);
angular.bootstrap(document.getElementById("cartGoodsRelationApp"),['cartGoodsRelationApp']);



