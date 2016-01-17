(function() {
  angular.module('clinic').controller('ReceptionistDoctorsWorkingHoursController', [
    '$scope', 'Specialities', '$stateParams', 'Doctors', function($scope, Specialities, $stateParams, Doctors) {
      var afterTomorrow, tomorrow;
      $scope.workingHours = {};
      $scope.today = function() {
        $scope.dt = new Date;
      };
      $scope.today();
      $scope.clear = function() {
        $scope.dt = null;
      };
      $scope.disabled = function(date, mode) {
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
      };
      $scope.toggleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date;
      };
      $scope.toggleMin();
      $scope.maxDate = new Date(2020, 5, 22);
      $scope.open = function($event) {
        $scope.status.opened = true;
      };
      $scope.setDate = function(year, month, day) {
        $scope.dt = new Date(year, month, day);
      };
      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
      };
      $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
      $scope.format = $scope.formats[0];
      $scope.status = {
        opened: false
      };
      tomorrow = new Date;
      tomorrow.setDate(tomorrow.getDate() + 1);
      afterTomorrow = new Date;
      afterTomorrow.setDate(tomorrow.getDate() + 2);
      $scope.events = [
        {
          date: tomorrow,
          status: 'full'
        }, {
          date: afterTomorrow,
          status: 'partially'
        }
      ];
      Doctors.getDoctorSpeciality($stateParams.doctorId).then(function(res) {
        console.log(res);
        return $scope.specialities = res.data;
      });
      return $scope.submit = function() {
        $scope.workingHours.idDoctor = $stateParams.doctorId;
        $scope.workingHours.startDate = new Date($scope.selectedDate).getTime();
        $scope.workingHours.duration = 30;
        $scope.workingHours.visitRepeat = 7;
        $scope.workingHours.description = '';
        return console.log($scope.workingHours);
      };
    }
  ]);

}).call(this);
