(function() {
  angular.module('clinic').controller('AdminDoctorsController', [
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
        return Doctors.show($stateParams.doctorId).then(function(res) {
          return $scope.doctor = res.data;
        });
      }
    }
  ]);

}).call(this);
