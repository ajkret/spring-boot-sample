(function() {
	'use strict';

	angular.module('app').controller('GreetingCtrl', GreetController);
	
	GreetController.$inject = ['GreetingService'];

	function GreetController($service) {
		var controller = this;
		var message;
		
		function get() {
			$service.get(function(greet) {
				controller.message = greet.message; 
			});
		}
		
		
		// Bootstrap
		get();
	}
})();