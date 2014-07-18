

var imagesModule=angular.module("imagesApp",[]);
imagesModule.controller('imagesController', function ($scope, $http) {
  
    
    $scope.images = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addImages = function(images){
    	$scope.images = images;
    	console.log(images);
    	location.href = '/web/c/images/0';
    };
    $scope.updateImages = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/images/'+id;
    };
    

    
    $scope.deleteImages = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/images/' + id}).success(function( data , status ){
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


pageDirective(imagesModule);
angular.bootstrap(document.getElementById("imagesApp"),['imagesApp']);



