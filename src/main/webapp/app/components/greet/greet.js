(function() {
	'use strict';

	angular.module('app').controller('GreetingCtrl', ['GreetingService', GreetingController]);
	
	function GreetingController($greetingService) {
		// messageOfTheDay will be an object {"message":"Hello World"}
		this.messageOfTheDay = $greetingService.get();
	}
})();