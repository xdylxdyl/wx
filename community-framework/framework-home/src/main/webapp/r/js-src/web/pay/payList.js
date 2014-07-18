/**
 * Created by magenm on 2014/5/4.
 */
var app = angular.module('payApp', [
    "ngRoute",
    "rest-resource",
    "mobile-angular-ui",
    "mobile-angular-ui.touch",
    "mobile-angular-ui.scrollable"
]);

app.controller('payController', ['$rootScope', '$scope', 'Resource','$location', function($rootScope, $scope,$resource,$location){

	$scope.gorderID = $location.search().gorderID;
	console.log("gorderID",$scope.gorderID);
	
	
	var Gorder = $resource('/p/u/a/gorder/:gorderID',{gorderID:"@id"});
	Gorder.get({gorderID:$scope.gorderID},function(data){
		console.log("gorder",data);
		if(data.data){
			$scope.address = data.data[0];
			console.log("Address data",data.data);
		}
	});
	
	
    $scope.netPay = function(){
    	
    }

    $scope.moneyPay = function(){

    }

}]);