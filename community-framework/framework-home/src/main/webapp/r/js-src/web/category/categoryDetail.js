

var categoryDetailModule=angular.module("categoryDetailApp",[]);
categoryDetailModule.controller('categoryDetailController', function ($scope, $http) {
	 $scope.category = {};
	 var id = $("#categoryId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/category/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.category = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(category){
	 		
	 		if ($scope.categoryForm.$invalid) {
    			$scope.categoryForm.submitted = true;
	    	} else {
	 
		    	console.log(category);
		    	$scope.category  = category;
		    	$scope.category.id = $("#categoryId").val();
		    	//add
		    	if($scope.category.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/category',data:formData($scope.category)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/category";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/category/'+$scope.category.id,data:formData($scope.category)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/category";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("categoryDetailApp"),['categoryDetailApp']);



