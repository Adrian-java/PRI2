(function() {
  angular.module('clinic').controller('MainController', [
    '$scope', '$uibModal', function($scope, $uibModal) {
      return $scope.open = function(size) {
        var modalInstance;
        return modalInstance = $uibModal.open({
          animation: true,
          templateUrl: '/app/components/login/login_modal.html',
          controller: 'LoginModalController'
        });
      };
    }
  ]);

}).call(this);
