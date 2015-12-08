angular.module 'clinic'
  .controller 'LoginController', [ '$scope', '$uibModalInstance', 'Auth', ($scope, $uibModalInstance, Auth) ->
    $scope.submit = ->
      Auth.login($scope.user)
      $uibModalInstance.close($scope.user)
  ]
