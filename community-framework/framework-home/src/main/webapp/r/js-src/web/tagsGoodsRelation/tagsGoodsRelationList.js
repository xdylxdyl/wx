

var tagsGoodsRelationModule=angular.module("tagsGoodsRelationApp",[]);
tagsGoodsRelationModule.controller('tagsGoodsRelationController', function ($scope, $http) {
  
    
    $scope.tagsGoodsRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addTagsGoodsRelation = function(tagsGoodsRelation){
    	$scope.tagsGoodsRelation = tagsGoodsRelation;
    	console.log(tagsGoodsRelation);
    	location.href = '/web/c/tagsGoodsRelation/0';
    };
    $scope.updateTagsGoodsRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/tagsGoodsRelation/'+id;
    };
    $scope.deleteTagsGoodsRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/tagsGoodsRelation/' + id}).success(function( data , status ){
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


pageDirective(tagsGoodsRelationModule);
angular.bootstrap(document.getElementById("tagsGoodsRelationApp"),['tagsGoodsRelationApp']);



