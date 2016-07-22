function Hello($scope, $http) {
	$http.get('http://my-room-ac.herokuapp.com/getAllExpenses').success(
			function(data) {
				$scope.expenses = data;
			});
}