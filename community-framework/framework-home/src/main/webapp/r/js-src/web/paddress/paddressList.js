

var paddressModule=angular.module("paddressApp", [
                                                  "ngRoute",
                                                  "ngCookies",
                                                  "rest-resource"
                                              ]);
paddressModule.controller('paddressController', ['$rootScope', '$scope', 'Resource', '$cookieStore',function($rootScope, $scope,$resource,$cookieStore){
	$scope.paddressList = [];
	
	var Paddress = $resource('/p/a/paddress');
	Paddress.get({},function(data){
		$scope.paddressList = data.data;  
		console.log("Paddress data",data.data);
	});


	$scope.select = function(address){
      console.log(address);
      $cookieStore.put('paddress', address);
      
      location.href="/p/u/finishGorder";
    };
    
}]);