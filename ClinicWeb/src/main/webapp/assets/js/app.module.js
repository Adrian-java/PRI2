(function() {
  angular.module('clinic', ['ngAnimate', 'ngCookies', 'ngResource', 'ui.router', 'ui.bootstrap', 'ui.calendar', 'ngStorage']).constant('api', 'http://localhost:8080/rest/').run([
    '$rootScope', 'Auth', '$state', '$location', function($rootScope, Auth, $state, $location) {
      return $rootScope.$on('$stateChangeSuccess', function(e, toState, toParams, fromState, fromParams) {
        if (Auth.validate() === false) {
          console.log('not logged');
          if (toState.name !== 'register' && toState.name !== 'home' && toState.name !== 'visits.new') {
            $rootScope.previousState = fromState.name;
            $rootScope.currentState = toState.name;
            console.log('bad state');
            return $location.path('home');
          }
        }
      });
    }
  ]);

}).call(this);
