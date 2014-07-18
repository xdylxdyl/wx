

var paddressDetailModule=angular.module("paddressDetailApp",[]);
paddressDetailModule.controller('paddressDetailController', function ($scope, $http) {
	 $scope.paddress = {};
	 var id = $("#paddressId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/paddress/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.paddress = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updatePaddress = function(paddress){
	 		
	 		if ($scope.paddressForm.$invalid) {
    			$scope.paddressForm.submitted = true;
	    	} else {
	 
		    	console.log(paddress);
		    	$scope.paddress  = paddress;
		    	$scope.paddress.id = $("#paddressId").val();
		    	//add
		    	if($scope.paddress.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/paddress',data:formData($scope.paddress)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/paddress";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/paddress/'+$scope.paddress.id,data:formData($scope.paddress)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/paddress";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("paddressDetailApp"),['paddressDetailApp']);



