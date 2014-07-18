var appnewsModule = angular.module("NewsApp", []);
appnewsModule.controller('NewsController', function($scope, $http) {

	$scope.chooseNews = function(newsid) {
		location.href = '/news/' + newsid;
	};

	//display more S
	$scope.items = [];
	$scope.busy = false;
	$scope.btnnmae = "点击加载更多";
	$scope.after = 1;
	$scope.pageSize = 10; //

	$scope.displayMore = function() {
		if ($scope.busy)
			return;
		$scope.busy = true;
		$scope.btnnmae = "加载中...";

		$http({
			method : 'GET',
			url : '/p/a/news',
			params : {
				'pageNo' : $scope.after,
				'pageSize' : $scope.pageSize
			}
		}).success(function(data, status) {
			if (status == '200') {
				console.log(data.data);
				for ( var i in data.data) {
					$scope.items.push(data.data[i]);
				}
			}

			if (data.total == $scope.items.length) {
				$scope.btnnmae = "木有新的资讯啦";
			} else {
				$scope.btnnmae = "点击加载更多";
				$scope.after = $scope.after + 1;
				$scope.busy = false;
			}
		});
	};
	$scope.displayMore(); //display init

	//display more E
});
appnewsModule.filter("limit", function() {
	return function(input) {
		if (input.length > 3) {
			return input.substring(1, 3) + "...";

		}

	};

});
/*angular.bootstrap(document.getElementById("NewsApp"),['NewsApp']);*/