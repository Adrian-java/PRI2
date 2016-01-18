(function() {
  angular.module('clinic').controller('AdminDoctorsController', [
    '$scope', '$stateParams', 'Doctors', '$state', function($scope, $stateParams, Doctors, $state) {
      console.log('admin doctors controller');
      Doctors.index().then(function(res) {
        return $scope.doctors = res.data;
      });
      $scope.submit = function() {
        var i, len, specialities, specialitiesArray, speciality;
        specialities = $scope.specialities.split(',');
        specialitiesArray = [];
        for (i = 0, len = specialities.length; i < len; i++) {
          speciality = specialities[i];
          specialitiesArray.push({
            'name': speciality
          });
        }
        $scope.doctor.doctor.specializations = specialitiesArray;
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
          Doctors.getDoctorSpeciality($stateParams.doctorId).then(function(res) {
            return $scope.doctorSpecialities = res.data;
          });
        }
      }
      $scope.remove = function(id) {
        return Doctors.remove(id).then(function(res) {
          console.log(res);
          return Doctors.index().then(function(res) {
            return $scope.doctors = res.data;
          });
        });
      };
      return $scope.update = function() {
        var doctor;
        doctor = {
          'name': $scope.doctor.name,
          'surname': $scope.doctor.surname
        };
        return Doctors.update($stateParams.doctorId, doctor).then(function(res) {
          console.log('doctor updated');
          return $state.go('admin-doctors');
        });
      };
    }
  ]);

}).call(this);
