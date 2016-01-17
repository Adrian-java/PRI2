(function() {
  angular.module('clinic').controller('RegisterController', [
    '$scope', 'Auth', '$state', function($scope, Auth, $state) {
      return $scope.submit = function() {
        console.log($scope.user);
        Auth.register($scope.user);
        return $state.go('home');
      };
    }
  ]);

}).call(this);
