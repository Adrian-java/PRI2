angular.module 'clinic'
  .controller 'MainController', ['$scope', '$uibModal', ($scope, $uibModal) ->
    $scope.open = (size) ->
      modalInstance = $uibModal.open(
        animation: true
        templateUrl: '/app/components/login/login_modal.html'
        controller: 'LoginModalController'
      )
  ]
