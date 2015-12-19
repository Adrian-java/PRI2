(function() {
  angular.module('clinic').controller('HomeController', [
    '$scope', '$timeout', '$state', 'Specialities', 'Doctors', function($scope, $timeout, $state, Specialities, Doctors) {
      var afterTomorrow, tomorrow;
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
      $scope.getDayClass = function(date, mode) {
        var currentDay, dayToCheck, i;
        if (mode === 'day') {
          dayToCheck = new Date(date).setHours(0, 0, 0, 0);
          i = 0;
          while (i < $scope.events.length) {
            currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);
            if (dayToCheck === currentDay) {
              return $scope.events[i].status;
            }
            i++;
          }
        }
        return '';
      };
      Specialities.getSpecialities().then(function(res) {
        $scope.specialities = res.data;
        console.log('specialities list');
        return console.log($scope.specialities);
      });
      Doctors.index().then(function(res) {
        $scope.doctors = res.data;
        console.log('doctors');
        return console.log($scope.doctors);
      });
      $scope.updateDoctorsList = function() {
        console.log('update doctors list ' + $scope.selectedSpeciality);
        return Doctors.indexBySpeciality($scope.selectedSpeciality).then(function(res) {
          console.log('change doctors select');
          return $scope.doctors = res.data;
        });
      };
      return $scope.submit = function() {
        console.log('submit main form');
        console.log($scope.selectedDoctor);
        return $state.go('visits.new', {
          'speciality': $scope.selectedSpeciality,
          'doctor': $scope.selectedDoctor.id,
          'date': $scope.selectedDate
        });
      };
    }
  ]);

}).call(this);
