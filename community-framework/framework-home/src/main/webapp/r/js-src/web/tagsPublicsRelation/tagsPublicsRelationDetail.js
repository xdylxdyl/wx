

var tagsPublicsRelationDetailModule=angular.module("tagsPublicsRelationDetailApp",[]);
tagsPublicsRelationDetailModule.controller('tagsPublicsRelationDetailController', function ($scope, $http) {
	 $scope.tagsPublicsRelation = {};
	 var id = $("#tagsPublicsRelationId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/tagsPublicsRelation/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.tagsPublicsRelation = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	 $scope.update${$cm.modelClass} = function(tagsPublicsRelation){
	 		
	 		if ($scope.tagsPublicsRelationForm.$invalid) {
    			$scope.tagsPublicsRelationForm.submitted = true;
	    	} else {
	 
		    	console.log(tagsPublicsRelation);
		    	$scope.tagsPublicsRelation  = tagsPublicsRelation;
		    	$scope.tagsPublicsRelation.id = $("#tagsPublicsRelationId").val();
		    	//add
		    	if($scope.tagsPublicsRelation.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/tagsPublicsRelation',data:formData($scope.tagsPublicsRelation)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/tagsPublicsRelation";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/tagsPublicsRelation/'+$scope.tagsPublicsRelation.id,data:formData($scope.tagsPublicsRelation)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/tagsPublicsRelation";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("tagsPublicsRelationDetailApp"),['tagsPublicsRelationDetailApp']);



