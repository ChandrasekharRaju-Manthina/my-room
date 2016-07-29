
		
		roomExpApp.controller('customersCtrl', function($scope, $http) {
			console.log('getExpenses');
			$http.get("/getExpenses").then(
					function(response) {
						$scope.expenses = response.data;
					});
		});
		
		