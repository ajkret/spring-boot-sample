(function() {
    'use strict';

    angular.module('app').factory('GreetingService', [ '$resource' , GreetingService]);

    function GreetingService($resource) {
        return $resource('rest/greet', {}, {
            get:    {method: 'GET', timeout: 10000, isArray: false},
            set:    {method: 'POST', timeout: 10000}
        });
    }
})();