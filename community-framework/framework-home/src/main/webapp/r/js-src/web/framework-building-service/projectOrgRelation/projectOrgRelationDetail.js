

var projectOrgRelationDetailModule=angular.module("projectOrgRelationDetailApp",[]);
projectOrgRelationDetailModule.controller('projectOrgRelationDetailController', function ($scope, $http) {
	 $scope.projectOrgRelation = {};
	 var id = $("#projectOrgRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/projectOrgRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.projectOrgRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateProjectOrgRelation = function(projectOrgRelation){
	 		
	 		if ($scope.projectOrgRelationForm.$invalid) {
    			$scope.projectOrgRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(projectOrgRelation);
		    	$scope.projectOrgRelation  = projectOrgRelation;
		    	$scope.projectOrgRelation.id = $("#projectOrgRelationId").val();
		    	//add
		    	if($scope.projectOrgRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/projectOrgRelation',data:formData($scope.projectOrgRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/projectOrgRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/projectOrgRelation/'+$scope.projectOrgRelation.id,data:formData($scope.projectOrgRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/projectOrgRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("projectOrgRelationDetailApp"),['projectOrgRelationDetailApp']);



