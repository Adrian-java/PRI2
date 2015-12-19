(function() {
  angular.module('clinic').controller('AdminPatientsVisitsController', [
    '$scope', 'Patients', '$stateParams', function($scope, Patients, $stateParams) {
      return console.log('admin patients visits controller');
    }
  ]);

}).call(this);
