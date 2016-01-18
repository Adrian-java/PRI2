angular.module 'clinic'
  .controller 'PasswordChangeController', ['$scope', 'Password', '$rootScope', '$state', ($scope, Password, $rootScope, $state) ->
    console.log 'password change controller'

    $scope.password = {}
    $scope.submit = ->
      Password.changePassword($scope.password).then((res) ->
        console.log res
        $state.go($rootScope.previousState)
      )

  ]
