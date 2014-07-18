

var areaDetailModule=angular.module("areaDetailApp",[]);
areaDetailModule.controller('areaDetailController', function ($scope, $http) {
	 $scope.area = {};
	 var id = $("#areaId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/area/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.area = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateArea = function(area){
	 		
	 		if ($scope.areaForm.$invalid) {
    			$scope.areaForm.submitted = true;
	    	} else {
	 
		    	console.log(area);
		    	$scope.area  = area;
		    	$scope.area.id = $("#areaId").val();
		    	//add
		    	if($scope.area.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/area',data:formData($scope.area)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/area";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/area/'+$scope.area.id,data:formData($scope.area)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/area";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("areaDetailApp"),['areaDetailApp']);



