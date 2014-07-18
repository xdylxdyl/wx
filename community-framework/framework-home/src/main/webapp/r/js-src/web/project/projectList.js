

var projectModule=angular.module("projectApp",[]);
projectModule.controller('projectController', function ($scope, $http) {
  
    
    $scope.project = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addProject = function(project){
    	$scope.project = project;
    	console.log(project);
    	location.href = '/web/c/project/0';
    };
    $scope.updateProject = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/project/'+id;
    };
    $scope.deleteProject = function(id){
    	$http({ method : 'DELETE' , url :'/web/a/project/' + id}).success(function( data , status ){
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


pageDirective(projectModule);
angular.bootstrap(document.getElementById("projectApp"),['projectApp']);



