

var gorderGoodsRelationModule=angular.module("gorderGoodsRelationApp",[]);
gorderGoodsRelationModule.controller('gorderGoodsRelationController', function ($scope, $http) {
  
    
    $scope.gorderGoodsRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addGorderGoodsRelation = function(gorderGoodsRelation){
    	$scope.gorderGoodsRelation = gorderGoodsRelation;
    	console.log(gorderGoodsRelation);
    	location.href = '/web/c/gorderGoodsRelation/0';
    };
    $scope.updateGorderGoodsRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/gorderGoodsRelation/'+id;
    };
    $scope.deleteGorderGoodsRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/gorderGoodsRelation/' + id}).success(function( data , status ){
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


pageDirective(gorderGoodsRelationModule);
angular.bootstrap(document.getElementById("gorderGoodsRelationApp"),['gorderGoodsRelationApp']);



