(function() {
  angular.module('clinic').controller('MainController', [
    '$scope', '$uibModal', 'Auth', 'Role', '$cookies', function($scope, $uibModal, Auth, Role, $cookies) {
      $scope.open = function(size) {
        var modalInstance;
        modalInstance = $uibModal.open({
          animation: true,
          templateUrl: '/app/components/login/login_modal.html',
          controller: 'LoginController'
        });
        return modalInstance.result.then(function(user) {
          return console.log(user);
        });
      };
      $scope.logout = function() {
        return Auth.logout();
      };
      return $scope.$watch((function() {
        return $cookies.token;
      }), function(newValue) {
        if ($cookies.token) {
          $scope.loggedIn = true;
          Role.check();
        } else {
          $scope.loggedIn = false;
        }
      });
    }
  ]);

}).call(this);
