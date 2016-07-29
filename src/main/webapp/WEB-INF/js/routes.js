roomExpApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/overview', {
		templateUrl : 'overview.html'
	}).when('/metrics', {
		templateUrl : 'metrics.html'
	}).otherwise({
		redirectTo : '/overview'
	});

} ]);