angular.module 'clinic'
  .controller 'RegisterController', ['$scope', 'Auth', ($scope, Auth) ->
    
    $scope.submit = ->
      console.log $scope.user
      Auth.register($scope.user)
  ]
