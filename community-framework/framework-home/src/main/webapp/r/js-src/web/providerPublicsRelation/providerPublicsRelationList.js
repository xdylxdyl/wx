

var providerPublicsRelationModule=angular.module("providerPublicsRelationApp",[]);
providerPublicsRelationModule.controller('providerPublicsRelationController', function ($scope, $http) {
  
    
    $scope.providerPublicsRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addProviderPublicsRelation = function(providerPublicsRelation){
    	$scope.providerPublicsRelation = providerPublicsRelation;
    	console.log(providerPublicsRelation);
    	location.href = '/web/c/providerPublicsRelation/0';
    };
    $scope.updateProviderPublicsRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/providerPublicsRelation/'+id;
    };
    $scope.deleteProviderPublicsRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/providerPublicsRelation/' + id}).success(function( data , status ){
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


pageDirective(providerPublicsRelationModule);
angular.bootstrap(document.getElementById("providerPublicsRelationApp"),['providerPublicsRelationApp']);



