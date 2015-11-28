angular.module 'clinic'
  .controller 'MainController', ['$scope', '$uibModal', 'Auth', 'Role', '$cookies', ($scope, $uibModal, Auth, Role, $cookies) ->


    $scope.open = (size) ->
      modalInstance = $uibModal.open(
        animation: true
        templateUrl: '/app/components/login/login_modal.html'
        controller: 'LoginController'
      )
      modalInstance.result.then( (user) ->
        console.log user
      )

    $scope.logout = ->
      Auth.logout()

    $scope.$watch (->
      $cookies.token
    ), (newValue) ->
      if($cookies.token)
        $scope.loggedIn = true
        Role.check()
      else
        $scope.loggedIn = false
      return
  ]
