(function() {
	'use strict';

	angular.module('app').config([ '$routeProvider', routing ]);

	function routing($routeProvider) {
		$routeProvider.when('/greet', {
			templateUrl : 'app/components/greet/greet.html',
			controller : 'GreetingCtrl',
			controllerAs : 'greet'
		}).when('/config', {
			templateUrl : 'app/components/config/config.html',
			controller : 'ConfigCtrl',
			controllerAs : 'config'
		}).otherwise({
			redirectTo : '/greet'
		});
	}

})();