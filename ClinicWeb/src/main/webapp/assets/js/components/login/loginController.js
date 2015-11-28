(function() {
  angular.module('clinic').controller('LoginController', [
    '$scope', '$uibModalInstance', 'Auth', function($scope, $uibModalInstance, Auth) {
      return $scope.submit = function() {
        Auth.login($scope.user);
        return $uibModalInstance.close($scope.user);
      };
    }
  ]);

}).call(this);
