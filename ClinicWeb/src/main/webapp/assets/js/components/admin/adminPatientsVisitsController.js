(function() {
  angular.module('clinic').controller('AdminPatientsVisitsController', [
    '$scope', 'Visits', '$stateParams', function($scope, Visits, $stateParams) {
      if ($stateParams.patientId) {
        Visits.showDone($stateParams.patientId).then(function(res) {
          console.log(res);
          return $scope.doneVisits = res.data;
        });
        Visits.showPlanned($stateParams.patientId).then(function(res) {
          console.log(res);
          return $scope.plannedVisits = res.data;
        });
      }
      return $scope.remove = function(visitId) {
        return Visits.remove(visitId).then(function(res) {
          return Visits.showPlanned($stateParams.patientId).then(function(res) {
            console.log(res);
            return $scope.plannedVisits = res.data;
          });
        });
      };
    }
  ]);

}).call(this);
