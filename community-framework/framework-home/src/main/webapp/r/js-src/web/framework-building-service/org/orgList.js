

var orgModule=angular.module("orgApp",[]);
orgModule.controller('orgController', function ($scope, $http) {
  
    
    $scope.org = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addOrg = function(org){
    	$scope.org = org;
    	console.log(org);
    	location.href = '/web/c/org/0';
    };
    $scope.updateOrg = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/org/'+id;
    };
    

    
    $scope.deleteOrg = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/org/' + id}).success(function( data , status ){
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


pageDirective(orgModule);
angular.bootstrap(document.getElementById("orgApp"),['orgApp']);



