

var gorderGoodsRelationDetailModule=angular.module("gorderGoodsRelationDetailApp",[]);
gorderGoodsRelationDetailModule.controller('gorderGoodsRelationDetailController', function ($scope, $http) {
	 $scope.gorderGoodsRelation = {};
	 var id = $("#gorderGoodsRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/gorderGoodsRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.gorderGoodsRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(gorderGoodsRelation){
	 		
	 		if ($scope.gorderGoodsRelationForm.$invalid) {
    			$scope.gorderGoodsRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(gorderGoodsRelation);
		    	$scope.gorderGoodsRelation  = gorderGoodsRelation;
		    	$scope.gorderGoodsRelation.id = $("#gorderGoodsRelationId").val();
		    	//add
		    	if($scope.gorderGoodsRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/gorderGoodsRelation',data:formData($scope.gorderGoodsRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/gorderGoodsRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/gorderGoodsRelation/'+$scope.gorderGoodsRelation.id,data:formData($scope.gorderGoodsRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/gorderGoodsRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("gorderGoodsRelationDetailApp"),['gorderGoodsRelationDetailApp']);



