(function() {
  angular.module('clinic').directive('loading', [
    '$http', '$timeout', function($http, $timeout) {
      return {
        restrict: 'A',
        link: function(scope, element, attrs) {
          scope.isLoading = function() {
            return $http.pendingRequests.length > 0;
          };
          scope.$watch(scope.isLoading, function(value) {
            if (value) {
              element.removeClass('ng-hide');
            } else {
              element.addClass('ng-hide');
            }
          });
        }
      };
    }
  ]);

}).call(this);