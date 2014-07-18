

var ownerDetailModule=angular.module("ownerDetailApp",[]);
ownerDetailModule.controller('ownerDetailController', function ($scope, $http) {
	 $scope.owner = {};
	 var id = $("#ownerId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/owner/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.owner = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateOwner = function(owner){
	 		
	 		if ($scope.ownerForm.$invalid) {
    			$scope.ownerForm.submitted = true;
	    	} else {
	 
		    	console.log(owner);
		    	$scope.owner  = owner;
		    	$scope.owner.id = $("#ownerId").val();
		    	//add
		    	if($scope.owner.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/owner',data:formData($scope.owner)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/owner";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/owner/'+$scope.owner.id,data:formData($scope.owner)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/owner";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("ownerDetailApp"),['ownerDetailApp']);



