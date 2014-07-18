

var ownerModule=angular.module("ownerApp",[]);
ownerModule.controller('ownerController', function ($scope, $http) {
  
    
    $scope.owner = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addOwner = function(owner){
    	$scope.owner = owner;
    	console.log(owner);
    	location.href = '/web/c/owner/0';
    };
    $scope.updateOwner = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/owner/'+id;
    };
    

    
    $scope.deleteOwner = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/owner/' + id}).success(function( data , status ){
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


pageDirective(ownerModule);
angular.bootstrap(document.getElementById("ownerApp"),['ownerApp']);



