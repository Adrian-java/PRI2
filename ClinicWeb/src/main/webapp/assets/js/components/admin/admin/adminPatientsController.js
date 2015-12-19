(function() {
  angular.module('clinic').controller('AdminPatientsController', [
    '$scope', 'Patients', '$stateParams', function($scope, Patients, $stateParams) {
      console.log('admin patients controller');
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
