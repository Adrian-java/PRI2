(function() {
  angular.module('clinic').controller('PatientPlannedVisitsController', [
    '$scope', '$timeout', 'Visits', function($scope, $timeout, Visits) {
      console.log('patient planned visits controller');
      Visits.getPatientPlannedVisits().then(function(res) {
        $scope.visits = res.data;
        return console.log(res.data);
      });
      return $scope.resign = function(visitId) {
        return Visits.remove(visitId).then(function(res) {
          return Visits.getPatientPlannedVisits().then(function(res) {
            $scope.visits = res.data;
            return console.log(res.data);
          });
        });
      };
    }
  ]);

}).call(this);
