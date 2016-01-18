angular.module('clinic').directive 'loading', [
  '$http', '$timeout'
  ($http, $timeout) ->
    {
      restrict: 'A'
      link: (scope, element, attrs) ->

        scope.isLoading = ->
          $http.pendingRequests.length > 0

        scope.$watch scope.isLoading, (value) ->
          if value
            element.removeClass 'ng-hide'
          else
            
            element.addClass 'ng-hide'
          return
        return

    }
]
