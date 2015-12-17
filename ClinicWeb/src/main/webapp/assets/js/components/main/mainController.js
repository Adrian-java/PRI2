(function() {
  angular.module('clinic').controller('MainController', [
    '$scope', '$uibModal', 'Auth', 'Role', '$cookies', '$state', function($scope, $uibModal, Auth, Role, $cookies, $state) {
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
      $scope.panel = function() {
        return $state.go($scope.role);
      };
      return $scope.$watch((function() {
        return $cookies.token;
      }), function(newValue) {
        if ($cookies.token) {
          console.log($cookies.token);
          $scope.loggedIn = true;
          Role.check().then(function(res) {
            console.log(res);
            return $scope.role = res.data.role;
          }, function(err) {
            return console.log(err);
          });
        } else {
          $scope.loggedIn = false;
        }
      });
    }
  ]);

}).call(this);
