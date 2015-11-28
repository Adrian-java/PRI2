(function() {
  angular.module('clinic').controller('RegisterController', [
    '$scope', 'Auth', function($scope, Auth) {
      return $scope.submit = function() {
        console.log($scope.user);
        return Auth.register($scope.user);
      };
    }
  ]);

}).call(this);
