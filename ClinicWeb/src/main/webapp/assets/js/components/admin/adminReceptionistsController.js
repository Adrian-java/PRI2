(function() {
  angular.module('clinic').controller('AdminReceptionistsController', [
    '$scope', 'Receptionists', '$stateParams', '$state', function($scope, Receptionists, $stateParams, $state) {
      console.log('admin receptionists controller');
      Receptionists.index().then(function(res) {
        return $scope.receptionists = res.data;
      });
      $scope.submit = function() {
        console.log($scope.receptionist);
        return Receptionists.create($scope.receptionist).then(function(res) {
          return $state.go('admin-receptionists');
        });
      };
      if ($stateParams) {
        Receptionists.show($stateParams.receptionistId).then(function(res) {
          return $scope.receptionist = res.data;
        });
      }
      return $scope.remove = function(id) {
        return Receptionists.remove(id).then(function(res) {
          console.log(res);
          return Receptionists.index().then(function(res) {
            return $scope.receptionists = res.data;
          });
        });
      };
    }
  ]);

}).call(this);
