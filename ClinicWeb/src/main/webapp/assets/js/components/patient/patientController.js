(function() {
  angular.module('clinic').controller('PatientController', [
    '$scope', '$timeout', 'Patients', function($scope, $timeout, Patients) {
      console.log('patient controller');
      return Patients.show().then(function(res) {
        return $scope.patient = res.data;
      });
    }
  ]);

}).call(this);
