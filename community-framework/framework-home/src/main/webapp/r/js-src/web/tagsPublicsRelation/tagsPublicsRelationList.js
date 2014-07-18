

var tagsPublicsRelationModule=angular.module("tagsPublicsRelationApp",[]);
tagsPublicsRelationModule.controller('tagsPublicsRelationController', function ($scope, $http) {
  
    
    $scope.tagsPublicsRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addTagsPublicsRelation = function(tagsPublicsRelation){
    	$scope.tagsPublicsRelation = tagsPublicsRelation;
    	console.log(tagsPublicsRelation);
    	location.href = '/web/c/tagsPublicsRelation/0';
    };
    $scope.updateTagsPublicsRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/tagsPublicsRelation/'+id;
    };
    $scope.deleteTagsPublicsRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/tagsPublicsRelation/' + id}).success(function( data , status ){
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


pageDirective(tagsPublicsRelationModule);
angular.bootstrap(document.getElementById("tagsPublicsRelationApp"),['tagsPublicsRelationApp']);



