/**
 * Created by magenm on 2014/5/4.
 */
var app = angular.module('cashPayApp', [
    "ngRoute",
    "ngCookies",
    "rest-resource",
    "mobile-angular-ui",
    "mobile-angular-ui.touch",
    "mobile-angular-ui.scrollable"
]);

app.controller('cashPayController', ['$scope', 'Resource','$location','$cookieStore', function($scope,$resource,$location,$cookieStore){

	$scope.gorderID = $location.search().gorderID;
	console.log("gorderID",$scope.gorderID);
	$scope.order = {};
	$scope.paddress = {};
	
	var paddress = $cookieStore.get("paddress");
	if(paddress){
		$scope.paddress = paddress;
	}
	
    $scope.netPay = function(){
    	
    }

    $scope.moneyPay = function(){

    }

}]);