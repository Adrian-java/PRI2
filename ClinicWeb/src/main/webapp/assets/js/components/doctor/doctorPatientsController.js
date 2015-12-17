(function() {
  angular.module('clinic').controller('DoctorPatientsController', [
    '$scope', 'Patients', '$stateParams', function($scope, Patients, $stateParams) {
      Patients.index().then(function(res) {
        console.log(res);
        return $scope.patients = res.data;
      });
      console.log($stateParams);
      if ($stateParams) {
        return Patients.show($stateParams.patientId).then(function(res) {
          return $scope.patient = res.data;
        });
      }
    }
  ]);

}).call(this);
