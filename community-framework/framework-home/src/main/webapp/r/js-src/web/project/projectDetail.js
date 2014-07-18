

var projectDetailModule=angular.module("projectDetailApp",[]);
projectDetailModule.controller('projectDetailController', function ($scope, $http) {
	 $scope.project = {};
	 var id = $("#projectId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/project/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.project = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateProject = function(project){
	 		
	 		if ($scope.projectForm.$invalid) {
    			$scope.projectForm.submitted = true;
	    	} else {
	 
		    	console.log(project);
		    	$scope.project  = project;
		    	$scope.project.id = $("#projectId").val();
		    	//add
		    	if($scope.project.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/project',data:formData($scope.project)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/project";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/project/'+$scope.project.id,data:formData($scope.project)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/project";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("projectDetailApp"),['projectDetailApp']);



