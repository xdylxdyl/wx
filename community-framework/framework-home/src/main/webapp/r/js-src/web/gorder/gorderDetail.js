

var gorderDetailModule=angular.module("gorderDetailApp",[]);
gorderDetailModule.controller('gorderDetailController', function ($scope, $http) {
	 $scope.gorder = {};
	 var id = $("#gorderId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/gorder/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.gorder = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(gorder){
	 		
	 		if ($scope.gorderForm.$invalid) {
    			$scope.gorderForm.submitted = true;
	    	} else {
	 
		    	console.log(gorder);
		    	$scope.gorder  = gorder;
		    	$scope.gorder.id = $("#gorderId").val();
		    	//add
		    	if($scope.gorder.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/gorder',data:formData($scope.gorder)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/gorder";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/gorder/'+$scope.gorder.id,data:formData($scope.gorder)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/gorder";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("gorderDetailApp"),['gorderDetailApp']);



