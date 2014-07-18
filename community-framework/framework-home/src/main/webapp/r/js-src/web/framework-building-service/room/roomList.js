

var roomModule=angular.module("roomApp",[]);
roomModule.controller('roomController', function ($scope, $http) {
  
    
    $scope.room = {};
    
    //page
	page($scope, $http);
    
 
    $scope.addRoom = function(room){
    	$scope.room = room;
    	console.log(room);
    	location.href = '/web/c/room/0';
    };
    $scope.updateRoom = function(id){
    	
    	console.log("want edit "+id);
    	location.href = '/web/c/room/'+id;
    };
    

    
    $scope.deleteRoom = function(id){
    	    
       bootbox.confirm({title:"提示",message:"确定删除？", callback:function(confirm){
	    		if (confirm) {
			 $http({ method : 'DELETE' , url :'/web/a/room/' + id}).success(function( data , status ){
    		 if( status == '200'){
    			bootbox.alert(data.message,function(){
            		if(data.code == 0){
            			getData($http,$scope,$scope.params,$scope.getDataSuccess);
            		}
            	});
    		  }
    	    });
	    		}
    		}
    	});
    };
});


pageDirective(roomModule);
angular.bootstrap(document.getElementById("roomApp"),['roomApp']);



