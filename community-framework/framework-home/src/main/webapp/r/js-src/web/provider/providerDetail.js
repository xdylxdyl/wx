

var providerDetailModule=angular.module("providerDetailApp",[]);
providerDetailModule.controller('providerDetailController', function ($scope, $http) {
	 $scope.provider = {};
	 var id = $("#providerId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/provider/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.provider = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(provider){
	 		
	 		if ($scope.providerForm.$invalid) {
    			$scope.providerForm.submitted = true;
	    	} else {
	 
		    	console.log(provider);
		    	$scope.provider  = provider;
		    	$scope.provider.id = $("#providerId").val();
		    	//add
		    	if($scope.provider.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/provider',data:formData($scope.provider)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/provider";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/provider/'+$scope.provider.id,data:formData($scope.provider)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/provider";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("providerDetailApp"),['providerDetailApp']);



