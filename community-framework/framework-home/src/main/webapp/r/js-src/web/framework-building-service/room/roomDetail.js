

var roomDetailModule=angular.module("roomDetailApp",[]);
roomDetailModule.controller('roomDetailController', function ($scope, $http) {
	 $scope.room = {};
	 var id = $("#roomId").val();
	 // 编辑是获取数据
	 if(id > 0){
		 $http({method : 'GET' , url:'/web/a/room/'+id}).success(function( data , status ){
				if( status == '200'){
					 $scope.room = data.data;
		             $scope.numPages = Math.ceil(data.total / data.size);
				}
			});
	 }
	  
	 //处理后台收不到数据的问题
	 $http.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	 $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	
	 $scope.updateRoom = function(room){
	 		
	 		if ($scope.roomForm.$invalid) {
    			$scope.roomForm.submitted = true;
	    	} else {
	 
		    	console.log(room);
		    	$scope.room  = room;
		    	$scope.room.id = $("#roomId").val();
		    	//add
		    	if($scope.room.id == 0){
		    		console.log('add');
			    	 $http({method : 'POST' , url:'/web/a/room',data:formData($scope.room)}).success(function( data , status ){
							if( status == '200'){
								bootbox.alert(data.message,function(){
				            		if(data.code == 0){
				            			location.href = "/web/c/room";
				            		}
				            	});
							}
						});
			    //update 
		    	}else {
		    		console.log('update');
		    		$http({method : 'PUT' , url:'/web/a/room/'+$scope.room.id,data:formData($scope.room)}).success(function( data , status ){
						if( status == '200'){
							location.href = "/web/c/room";
						}
					});
		    	}
		    }
	    };
});

 function formData(data){
	  		    return $.param(data);
	 }

angular.bootstrap(document.getElementById("roomDetailApp"),['roomDetailApp']);



