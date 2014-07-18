

var categoryModule=angular.module("categoryApp",[]);
categoryModule.controller('categoryController', function ($scope, $http) {
  
    
    $scope.category = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addCategory = function(category){
    	$scope.category = category;
    	console.log(category);
    	location.href = '/web/c/category/0';
    };
    $scope.updateCategory = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/category/'+id;
    };
    $scope.deleteCategory = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/category/' + id}).success(function( data , status ){
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


pageDirective(categoryModule);
angular.bootstrap(document.getElementById("categoryApp"),['categoryApp']);



