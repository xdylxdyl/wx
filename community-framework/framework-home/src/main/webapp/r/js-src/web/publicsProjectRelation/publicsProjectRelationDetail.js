

var publicsProjectRelationDetailModule=angular.module("publicsProjectRelationDetailApp",[]);
publicsProjectRelationDetailModule.controller('publicsProjectRelationDetailController', function ($scope, $http) {
	 $scope.publicsProjectRelation = {};
	 var id = $("#publicsProjectRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/publicsProjectRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.publicsProjectRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updatePublicsProjectRelation = function(publicsProjectRelation){
	 		
	 		if ($scope.publicsProjectRelationForm.$invalid) {
    			$scope.publicsProjectRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(publicsProjectRelation);
		    	$scope.publicsProjectRelation  = publicsProjectRelation;
		    	$scope.publicsProjectRelation.id = $("#publicsProjectRelationId").val();
		    	//add
		    	if($scope.publicsProjectRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/publicsProjectRelation',data:formData($scope.publicsProjectRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/publicsProjectRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/publicsProjectRelation/'+$scope.publicsProjectRelation.id,data:formData($scope.publicsProjectRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/publicsProjectRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("publicsProjectRelationDetailApp"),['publicsProjectRelationDetailApp']);



