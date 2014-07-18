

var tagsGoodsRelationDetailModule=angular.module("tagsGoodsRelationDetailApp",[]);
tagsGoodsRelationDetailModule.controller('tagsGoodsRelationDetailController', function ($scope, $http) {
	 $scope.tagsGoodsRelation = {};
	 var id = $("#tagsGoodsRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/tagsGoodsRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.tagsGoodsRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(tagsGoodsRelation){
	 		
	 		if ($scope.tagsGoodsRelationForm.$invalid) {
    			$scope.tagsGoodsRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(tagsGoodsRelation);
		    	$scope.tagsGoodsRelation  = tagsGoodsRelation;
		    	$scope.tagsGoodsRelation.id = $("#tagsGoodsRelationId").val();
		    	//add
		    	if($scope.tagsGoodsRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/tagsGoodsRelation',data:formData($scope.tagsGoodsRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/tagsGoodsRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/tagsGoodsRelation/'+$scope.tagsGoodsRelation.id,data:formData($scope.tagsGoodsRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/tagsGoodsRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("tagsGoodsRelationDetailApp"),['tagsGoodsRelationDetailApp']);



