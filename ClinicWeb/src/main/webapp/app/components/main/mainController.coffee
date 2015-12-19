angular.module 'clinic'
  .controller 'MainController', ['$scope', '$uibModal', 'Auth', 'Role', '$cookies', '$state', ($scope, $uibModal, Auth, Role,$cookies, $state) ->


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

    $scope.panel = ->
      $state.go($scope.role)

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
  ]
