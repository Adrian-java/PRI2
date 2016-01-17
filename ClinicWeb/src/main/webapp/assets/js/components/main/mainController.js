(function() {
  angular.module('clinic').controller('MainController', [
    '$scope', '$uibModal', 'Auth', 'Role', '$cookies', '$state', '$localStorage', function($scope, $uibModal, Auth, Role, $cookies, $state, $localStorage) {
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
        console.log($scope.role);
        return $state.go($scope.role);
      };

      /*
      $scope.$watch (->
        $cookies.token
      ), (newValue) ->
        if($cookies.token)
          console.log $cookies.token
          $scope.loggedIn = true
          Role.check().then((res) ->
            console.log res
            $scope.role = res.data.role
          , (err) ->
            console.log err
          )
        else
          $scope.loggedIn = false
        return
       */
      return $scope.$watch((function() {
        return $localStorage.token;
      }), function(newValue) {
        if ($localStorage.token) {
          console.log('token changes');
          console.log($cookies.token);
          $scope.loggedIn = true;
          Role.check().then(function(res) {
            $scope.role = res.data.role;
            return console.log($scope.role);
          }, function(err) {});
        } else {
          $scope.loggedIn = false;
        }
      });
    }
  ]);

}).call(this);
