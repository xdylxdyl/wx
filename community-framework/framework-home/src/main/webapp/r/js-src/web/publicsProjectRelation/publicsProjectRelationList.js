

var publicsProjectRelationModule=angular.module("publicsProjectRelationApp",[]);
publicsProjectRelationModule.controller('publicsProjectRelationController', function ($scope, $http) {
  
    
    $scope.publicsProjectRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addPublicsProjectRelation = function(publicsProjectRelation){
    	$scope.publicsProjectRelation = publicsProjectRelation;
    	console.log(publicsProjectRelation);
    	location.href = '/web/c/publicsProjectRelation/0';
    };
    $scope.updatePublicsProjectRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/publicsProjectRelation/'+id;
    };
    $scope.deletePublicsProjectRelation = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/publicsProjectRelation/' + id}).success(function( data , status ){
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


pageDirective(publicsProjectRelationModule);
angular.bootstrap(document.getElementById("publicsProjectRelationApp"),['publicsProjectRelationApp']);



