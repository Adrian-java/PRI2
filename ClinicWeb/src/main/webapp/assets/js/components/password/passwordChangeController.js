(function() {
  angular.module('clinic').controller('PasswordChangeController', [
    '$scope', 'Password', '$rootScope', '$state', function($scope, Password, $rootScope, $state) {
      console.log('password change controller');
      $scope.password = {};
      return $scope.submit = function() {
        return Password.changePassword($scope.password).then(function(res) {
          console.log(res);
          return $state.go($rootScope.previousState);
        });
      };
    }
  ]);

}).call(this);
