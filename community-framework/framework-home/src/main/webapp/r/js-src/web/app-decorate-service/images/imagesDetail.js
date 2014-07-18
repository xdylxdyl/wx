

var imagesDetailModule=angular.module("imagesDetailApp",[]);
imagesDetailModule.controller('imagesDetailController', function ($scope, $http) {
	 $scope.images = {};
	 var id = $("#imagesId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/images/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.images = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateImages = function(images){
	 		
	 		if ($scope.imagesForm.$invalid) {
    			$scope.imagesForm.submitted = true;
	    	} else {
	 
		    	console.log(images);
		    	$scope.images  = images;
		    	$scope.images.id = $("#imagesId").val();
		    	//add
		    	if($scope.images.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/images',data:formData($scope.images)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/images";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/images/'+$scope.images.id,data:formData($scope.images)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/images";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("imagesDetailApp"),['imagesDetailApp']);



