

var areaModule=angular.module("areaApp",[]);
areaModule.controller('areaController', function ($scope, $http) {
  
    
    $scope.area = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addArea = function(area){
    	$scope.area = area;
    	console.log(area);
    	location.href = '/web/c/area/0';
    };
    $scope.updateArea = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/area/'+id;
    };
    

    
    $scope.deleteArea = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/area/' + id}).success(function( data , status ){
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


pageDirective(areaModule);
angular.bootstrap(document.getElementById("areaApp"),['areaApp']);



