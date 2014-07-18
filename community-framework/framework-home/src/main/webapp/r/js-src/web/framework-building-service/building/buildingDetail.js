

var buildingDetailModule=angular.module("buildingDetailApp",[]);
buildingDetailModule.controller('buildingDetailController', function ($scope, $http) {
	 $scope.building = {};
	 var id = $("#buildingId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/building/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.building = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateBuilding = function(building){
	 		
	 		if ($scope.buildingForm.$invalid) {
    			$scope.buildingForm.submitted = true;
	    	} else {
	 
		    	console.log(building);
		    	$scope.building  = building;
		    	$scope.building.id = $("#buildingId").val();
		    	//add
		    	if($scope.building.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/building',data:formData($scope.building)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/building";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/building/'+$scope.building.id,data:formData($scope.building)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/building";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("buildingDetailApp"),['buildingDetailApp']);



