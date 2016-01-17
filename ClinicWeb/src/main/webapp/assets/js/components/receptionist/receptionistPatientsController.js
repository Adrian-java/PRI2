(function() {
  angular.module('clinic').controller('ReceptionistPatientsController', [
    '$scope', 'Patients', '$stateParams', '$state', function($scope, Patients, $stateParams, $state) {
      if ($stateParams.patientId) {
        Patients.show($stateParams.patientId).then(function(res) {
          return $scope.patient = res.data;
        });
      } else {
        Patients.index().then(function(res) {
          return $scope.patients = res.data;
        });
      }
      $scope.submit = function() {
        return Patients.create($scope.user).then(function(res) {
          console.log(res);
          return $state.go('receptionist-patients');
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
