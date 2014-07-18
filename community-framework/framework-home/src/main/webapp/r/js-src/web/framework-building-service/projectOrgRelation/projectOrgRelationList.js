

var projectOrgRelationModule=angular.module("projectOrgRelationApp",[]);
projectOrgRelationModule.controller('projectOrgRelationController', function ($scope, $http) {
  
    
    $scope.projectOrgRelation = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addProjectOrgRelation = function(projectOrgRelation){
    	$scope.projectOrgRelation = projectOrgRelation;
    	console.log(projectOrgRelation);
    	location.href = '/web/c/projectOrgRelation/0';
    };
    $scope.updateProjectOrgRelation = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/projectOrgRelation/'+id;
    };
    

    
    $scope.deleteProjectOrgRelation = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/projectOrgRelation/' + id}).success(function( data , status ){
    		 if( status == '200'){
    			bootbox.alert(data.message,function(){
            		if(data.code == 0){
            			getData($http,$scope,$scope.params,$scope.getDataSuccess);
            		}
            	});
    		  }
    	    });
	    		}
    		}
    	});
    };
});


pageDirective(projectOrgRelationModule);
angular.bootstrap(document.getElementById("projectOrgRelationApp"),['projectOrgRelationApp']);



