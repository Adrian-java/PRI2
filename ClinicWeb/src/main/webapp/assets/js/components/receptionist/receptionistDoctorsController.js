(function() {
  angular.module('clinic').controller('ReceptionistDoctorsController', [
    '$scope', '$stateParams', 'Doctors', '$state', function($scope, $stateParams, Doctors, $state) {
      console.log('admin doctors controller');
      Doctors.index().then(function(res) {
        return $scope.doctors = res.data;
      });
      $scope.submit = function() {
        return Doctors.create($scope.doctor).then(function(res) {
          return $state.go('admin-doctors');
        });
      };
      console.log($stateParams);
      if ($stateParams) {
        if ($stateParams.doctorId) {
          Doctors.show($stateParams.doctorId).then(function(res) {
            $scope.doctor = res.data;
            return console.log(res);
          });
          return Doctors.getDoctorSpeciality($stateParams.doctorId).then(function(res) {
            return $scope.doctorSpecialities = res.data;
          });
        }
      }
    }
  ]);

}).call(this);
