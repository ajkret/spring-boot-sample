(function() {
	'use strict';

	angular.module('app').controller('GreetingCtrl', GreetController);
	
	GreetController.$inject = ['GreetingService','$location','$scope'];

	function GreetController($service, $location, $scope) {
		var controller = this;
		var message;
		
		function get() {
			$service.get(function(greet) {
				controller.message = greet.message; 
			});
		}
		
		function configure() {
            $location.url('config');
		}

		$scope.configure = configure;
		
		// Bootstrap
		get();
	}
})();