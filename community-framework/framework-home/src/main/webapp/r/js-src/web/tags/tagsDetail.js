

var tagsDetailModule=angular.module("tagsDetailApp",[]);
tagsDetailModule.controller('tagsDetailController', function ($scope, $http) {
	 $scope.tags = {};
	 var id = $("#tagsId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/tags/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.tags = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(tags){
	 		
	 		if ($scope.tagsForm.$invalid) {
    			$scope.tagsForm.submitted = true;
	    	} else {
	 
		    	console.log(tags);
		    	$scope.tags  = tags;
		    	$scope.tags.id = $("#tagsId").val();
		    	//add
		    	if($scope.tags.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/tags',data:formData($scope.tags)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/tags";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/tags/'+$scope.tags.id,data:formData($scope.tags)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/tags";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("tagsDetailApp"),['tagsDetailApp']);



