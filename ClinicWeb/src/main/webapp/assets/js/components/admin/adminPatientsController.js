(function() {
  angular.module('clinic').controller('AdminPatientsController', [
    '$scope', 'Patients', '$stateParams', '$state', function($scope, Patients, $stateParams, $state) {
      console.log('admin patients controller');
      Patients.index().then(function(res) {
        console.log(res);
        return $scope.patients = res.data;
      });
      console.log($stateParams);
      if ($stateParams) {
        Patients.show($stateParams.patientId).then(function(res) {
          console.log(res);
          return $scope.patient = res.data;
        });
      }
      $scope.remove = function(id) {
        return Patients.remove(id).then(function(res) {
          console.log(res);
          return Patients.index().then(function(res) {
            return $scope.receptionists = res.data;
          });
        });
      };
      return $scope.edit = function() {
        $scope.editedPatient = {
          'name': $scope.patient.name,
          'surname': $scope.patient.surname,
          'phoneNr': $scope.patient.phoneNr,
          'address': {
            'city': $scope.patient.city,
            'countryCode': $scope.patient.countryCode,
            'province': $scope.patient.province,
            'country': $scope.patient.country,
            'countryCodeCity': $scope.patient.countryCode,
            'street': $scope.patient.street,
            'homeNr': $scope.patient.homeNr
          }
        };
        return Patients.edit($scope.patient.id, $scope.editedPatient).then(function(res) {
          console.log(res);
          console.log('patient update');
          return $state.go('admin-patients');
        });
      };
    }
  ]);

}).call(this);
