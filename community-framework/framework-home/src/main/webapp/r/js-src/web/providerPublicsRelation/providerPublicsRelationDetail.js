

var providerPublicsRelationDetailModule=angular.module("providerPublicsRelationDetailApp",[]);
providerPublicsRelationDetailModule.controller('providerPublicsRelationDetailController', function ($scope, $http) {
	 $scope.providerPublicsRelation = {};
	 var id = $("#providerPublicsRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/providerPublicsRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.providerPublicsRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(providerPublicsRelation){
	 		
	 		if ($scope.providerPublicsRelationForm.$invalid) {
    			$scope.providerPublicsRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(providerPublicsRelation);
		    	$scope.providerPublicsRelation  = providerPublicsRelation;
		    	$scope.providerPublicsRelation.id = $("#providerPublicsRelationId").val();
		    	//add
		    	if($scope.providerPublicsRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/providerPublicsRelation',data:formData($scope.providerPublicsRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/providerPublicsRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/providerPublicsRelation/'+$scope.providerPublicsRelation.id,data:formData($scope.providerPublicsRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/providerPublicsRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("providerPublicsRelationDetailApp"),['providerPublicsRelationDetailApp']);



