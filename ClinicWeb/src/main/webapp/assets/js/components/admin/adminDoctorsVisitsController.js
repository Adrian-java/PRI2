(function() {
  angular.module('clinic').controller('AdminDoctorsVisitsController', [
    '$scope', 'Doctors', '$stateParams', '$state', function($scope, Doctors, $stateParams, $state) {
      var changeWeek, getVisits;
      if ($stateParams) {
        $scope.selectedDoctorId = $stateParams.doctorId;
      }
      changeWeek = function(element, view) {
        $scope.calendarStartDate = element.start._d;
        return Doctors.takenVisitsTimeFrame($scope.selectedDoctorId, element.start._d, element.end._d).then(function(res) {
          var visitDate;
          if (res.data.length > 0) {
            visitDate = new Date(res.data[0].dateOfVisit * 1000);
          }
          console.log(res);
          $scope.visitsTemp = res.data;
          return getVisits();
        });
      };
      $scope.visits = [];
      getVisits = function() {
        var i, len, ref, results, visit;
        $scope.visits.length = 0;
        ref = $scope.visitsTemp;
        results = [];
        for (i = 0, len = ref.length; i < len; i++) {
          visit = ref[i];
          results.push((function() {
            var endDate, startDate;
            startDate = new Date(visit.dateOfVisit);
            endDate = new Date(startDate.getTime() + 20 * 60000);
            return $scope.visits.push({
              start: startDate,
              end: endDate,
              id: visit.id
            });
          })());
        }
        return results;
      };
      $scope.clickEvent = function(event) {
        return $state.go('admin-visits-show', {
          visitId: event.id
        });
      };
      $scope.uiConfig = {
        calendar: {
          height: 450,
          editable: false,
          defaultView: 'agendaWeek',
          slotDuration: '00:20:00',
          header: {
            left: 'title',
            center: '',
            right: 'today prev,next'
          },
          eventClick: $scope.clickEvent,
          eventDrop: $scope.alertOnDrop,
          eventResize: $scope.alertOnResize,
          eventRender: $scope.eventRender,
          viewRender: changeWeek,
          defaultDate: $scope.selectedDate ? new Date($scope.selectedDate) : new Date()
        }
      };
      return $scope.eventSources = [$scope.visits];
    }
  ]);

}).call(this);
