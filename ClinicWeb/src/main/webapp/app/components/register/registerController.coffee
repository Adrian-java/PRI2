angular.module 'clinic'
  .controller 'RegisterController', ['$scope', 'Auth', '$state', ($scope, Auth, $state) ->

    $scope.submit = ->
      console.log $scope.user
      Auth.register($scope.user)
      $state.go('home')
  ]
