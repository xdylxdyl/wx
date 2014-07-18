

var tagsModule=angular.module("tagsApp",[]);
tagsModule.controller('tagsController', function ($scope, $http) {
  
    
    $scope.tags = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addTags = function(tags){
    	$scope.tags = tags;
    	console.log(tags);
    	location.href = '/web/c/tags/0';
    };
    $scope.updateTags = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/tags/'+id;
    };
    $scope.deleteTags = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/tags/' + id}).success(function( data , status ){
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


pageDirective(tagsModule);
angular.bootstrap(document.getElementById("tagsApp"),['tagsApp']);



