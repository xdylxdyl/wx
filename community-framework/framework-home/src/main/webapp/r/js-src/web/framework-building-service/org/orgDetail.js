

var orgDetailModule=angular.module("orgDetailApp",[]);
orgDetailModule.controller('orgDetailController', function ($scope, $http) {
	 $scope.org = {};
	 var id = $("#orgId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/org/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.org = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateOrg = function(org){
	 		
	 		if ($scope.orgForm.$invalid) {
    			$scope.orgForm.submitted = true;
	    	} else {
	 
		    	console.log(org);
		    	$scope.org  = org;
		    	$scope.org.id = $("#orgId").val();
		    	//add
		    	if($scope.org.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/org',data:formData($scope.org)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/org";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/org/'+$scope.org.id,data:formData($scope.org)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/org";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("orgDetailApp"),['orgDetailApp']);



