(function() {
  angular.module('clinic').controller('AdminSpecialitiesController', [
    '$scope', 'Specialities', '$stateParams', 'Doctors', function($scope, Specialities, $stateParams, Doctors) {
      console.log('Specialities controller');
      Specialities.getSpecialities().then(function(res) {
        $scope.specialities = res.data;
        console.log('specialities list');
        return console.log($scope.specialities);
      });
      if ($stateParams.specialitySlug) {
        console.log($stateParams.specialitySlug);
        return Doctors.indexBySpeciality($stateParams.specialitySlug).then(function(res) {
          return $scope.doctors = res.data;
        });
      }
    }
  ]);

}).call(this);
