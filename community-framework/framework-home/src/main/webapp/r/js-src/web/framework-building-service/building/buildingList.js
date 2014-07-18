

var buildingModule=angular.module("buildingApp",[]);
buildingModule.controller('buildingController', function ($scope, $http) {
  
    
    $scope.building = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addBuilding = function(building){
    	$scope.building = building;
    	console.log(building);
    	location.href = '/web/c/building/0';
    };
    $scope.updateBuilding = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/building/'+id;
    };
    

    
    $scope.deleteBuilding = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/building/' + id}).success(function( data , status ){
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


pageDirective(buildingModule);
angular.bootstrap(document.getElementById("buildingApp"),['buildingApp']);



