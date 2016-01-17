(function() {
  angular.module('clinic').controller('PatientDoneVisitsController', [
    '$scope', '$timeout', 'Visits', function($scope, $timeout, Visits) {
      console.log('patient done visits controller');
      return Visits.getPatientDoneVisits().then(function(res) {
        return $scope.visits = res.data;
      });
    }
  ]);

}).call(this);
