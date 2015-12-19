(function() {
  angular.module('clinic').controller('ReceptionistSpecialitiesController', [
    '$scope', 'Specialities', function($scope, Specialities) {
      console.log('Specialities controller');
      return Specialities.getSpecialities().then(function(res) {
        $scope.specialities = res.data;
        console.log('specialities list');
        return console.log($scope.specialities);
      });
    }
  ]);

}).call(this);
