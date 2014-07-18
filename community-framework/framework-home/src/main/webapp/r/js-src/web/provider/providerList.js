

var providerModule=angular.module("providerApp",[]);
providerModule.controller('providerController', function ($scope, $http) {
  
    
    $scope.provider = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addProvider = function(provider){
    	$scope.provider = provider;
    	console.log(provider);
    	location.href = '/web/c/provider/0';
    };
    $scope.updateProvider = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/provider/'+id;
    };
    $scope.deleteProvider = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/provider/' + id}).success(function( data , status ){
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


pageDirective(providerModule);
angular.bootstrap(document.getElementById("providerApp"),['providerApp']);



