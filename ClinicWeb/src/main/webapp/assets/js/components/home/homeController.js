(function() {
  angular.module('clinic').controller('HomeController', [
    '$scope', '$timeout', function($scope, $timeout) {
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
      return $scope.getDayClass = function(date, mode) {
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
    }
  ]);

}).call(this);
