angular.module 'clinic', ['ngAnimate', 'ngCookies', 'ngResource', 'ui.router', 'ui.bootstrap', 'ui.calendar', 'ngStorage']
  .constant('api', 'http://localhost:8080/rest/')
  .run(['$rootScope', 'Auth', '$state', '$location', ($rootScope, Auth, $state, $location) ->
    $rootScope.$on '$stateChangeSuccess', (e, toState, toParams, fromState, fromParams) ->
      if(Auth.validate() == false)
        console.log 'not logged'
        if(toState.name != 'register' && toState.name != 'home' && toState.name != 'visits.new')
          #e.preventDefault()
          console.log 'bad state'
          #$state.transitionTo('home')
          $location.path('home')
        #if(toState.name != 'register' || toState.name != 'home')
        #  $state.go('home')
  ])
