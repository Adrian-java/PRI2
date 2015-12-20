(function() {
  angular.module('clinic').controller('AdminVisitsController', [
    '$scope', '$stateParams', 'Doctors', 'Patients', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', '$state', function($scope, $stateParams, Doctors, Patients, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal, $state) {
      var afterTomorrow, changeWeek, getAllDoctors, getAllVisitsByDate, getVisits, getWorkingTime, setCalendarWorkingTime, tomorrow;
      $scope.selectedView = '';
      $scope.workingTime = [];
      Specialities.getSpecialities().then(function(res) {
        return $scope.specialities = res.data;
      });
      Patients.index().then(function(res) {
        console.log(res);
        return $scope.patients = res.data;
      });
      getAllDoctors = function() {
        return Doctors.index().then(function(res) {
          return $scope.doctors = res.data;
        });
      };
      getAllDoctors();
      $scope.updateDoctorsList = function() {
        if ($scope.selectedSpeciality) {
          return Doctors.indexBySpeciality($scope.selectedSpeciality).then(function(res) {
            var doctor, j, len, ref, results;
            $scope.doctors = res.data;
            ref = $scope.doctors;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              doctor = ref[j];
              results.push((function() {
                if (doctor.id === $scope.selectedDoctorId) {
                  return $scope.selectedDoctor = doctor;
                }
              })());
            }
            return results;
          });
        } else {
          return getAllDoctors();
        }
      };
      $scope.$watch('selectedDoctor', function() {
        if ($scope.selectedDoctor) {
          $scope.selectedDoctorId = $scope.selectedDoctor.id;
          return getWorkingTime();
        }
      });
      getWorkingTime = function() {
        return Doctors.workingTime($scope.selectedDoctorId).then(function(res) {
          $scope.workingTime = res.data;
          return setCalendarWorkingTime(res.data);
        });
      };
      $scope.workingTimeEvents = [];
      setCalendarWorkingTime = function() {
        var date, j, len, ref, results;
        $scope.workingTimeEvents.length = 0;
        ref = $scope.workingTime;
        results = [];
        for (j = 0, len = ref.length; j < len; j++) {
          date = ref[j];
          results.push((function() {
            var dayOfTheWeek, eventCurrentDate, eventCurrentEndDate, eventEndDate, eventStartDate, results1, startDate;
            startDate = new Date(date.startDate * 1000);
            dayOfTheWeek = startDate.getDay();
            eventStartDate = new Date($scope.calendarStartDate.getUTCFullYear(), $scope.calendarStartDate.getMonth(), $scope.calendarStartDate.getUTCDate() + dayOfTheWeek, date.timeFrom.split(':')[0], date.timeFrom.split(':')[1]);
            eventEndDate = new Date($scope.calendarStartDate.getUTCFullYear(), $scope.calendarStartDate.getMonth(), $scope.calendarStartDate.getUTCDate() + dayOfTheWeek, date.timeTo.split(':')[0], date.timeTo.split(':')[1]);
            $scope.workingTimeEvents.push({
              start: eventStartDate,
              end: eventEndDate
            });
            eventCurrentDate = eventStartDate;
            eventCurrentEndDate = new Date(eventEndDate.getTime() + 20 * 60000);
            results1 = [];
            while (eventCurrentDate < eventEndDate) {
              $scope.workingTimeEvents.push({
                start: eventCurrentDate,
                end: new Date(eventCurrentDate.getTime() + 20 * 60000)
              });
              results1.push(eventCurrentDate = new Date(eventCurrentDate.getTime() + 20 * 60000));
            }
            return results1;
          })());
        }
        return results;
      };
      $scope.$watch('selectedDoctor', function() {
        if ($scope.selectedDoctor) {
          return getWorkingTime();
        }
      });
      changeWeek = function(element, view) {
        $scope.calendarStartDate = element.start._d;
        Doctors.takenVisitsTimeFrame($scope.selectedDoctorId, element.start._d, element.end._d).then(function(res) {
          var visitDate;
          if (res.data.length > 0) {
            return visitDate = new Date(res.data[0].dateOfVisit * 1000);
          }
        });
        return setCalendarWorkingTime();
      };
      $scope.clickEvent = function(event, jsEvent, view) {
        return $scope.selectedVisitDate = event.start._d;
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
          viewRender: changeWeek
        }

        /* event sources array */
      };
      $scope.eventSources = [$scope.workingTimeEvents];
      $scope.submit = function() {
        var visit;
        visit = {};
        visit.patientId = $scope.selectedPatient;
        visit.date = $scope.selectedVisitDate.getTime();
        visit.idDoctor = $scope.selectedDoctorId;
        visit.typeOfVisit = 'Dermatolog';
        return Visits.create(visit).then(function(res) {
          return $state.go('admin-visits');
        });
      };
      getAllVisitsByDate = function(startDate, endDate) {
        return Visits.indexByDate(startDate, endDate).then(function(res) {
          return $scope.visits = res.data;
        });
      };
      $scope.updateAllVisits = function() {
        var actual, endDate, startDate;
        actual = new Date();
        startDate = String(actual.getDate()) + '-' + String(actual.getMonth() + 1) + '-' + String(actual.getFullYear());
        endDate = String(actual.getDate() + 1) + '-' + String(actual.getMonth() + 1) + '-' + String(actual.getFullYear());
        return getAllVisitsByDate(startDate, endDate);
      };
      $scope.updateAllVisits();
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
      $scope.openStart = function($event) {
        $scope.status.openedStart = true;
      };
      $scope.openEnd = function($event) {
        $scope.status.openedEnd = true;
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
      $scope.$watch('selectedEndDate', function() {
        if ($scope.selectedEndDate && $scope.selectedStartDate) {
          return getVisits();
        }
      });
      $scope.$watch('selectedStartDate', function() {
        if ($scope.selectedEndDate && $scope.selectedStartDate) {
          return getVisits();
        }
      });
      getVisits = function() {
        var endDate, startDate;
        startDate = String($scope.selectedStartDate.getDate()) + '-' + String($scope.selectedStartDate.getMonth() + 1) + '-' + String($scope.selectedStartDate.getFullYear());
        endDate = String($scope.selectedEndDate.getDate() + 1) + '-' + String($scope.selectedEndDate.getMonth() + 1) + '-' + String($scope.selectedEndDate.getFullYear());
        return getAllVisitsByDate(startDate, endDate);
      };
      return $scope.removeVisit = function(id) {
        return Visits.remove(id).then(function(res) {
          console.log('visit removed');
          console.log(res);
          if ($scope.selectedStartDate && $scope.selectedEndDate) {
            return getVisits();
          } else {
            return $scope.updateAllVisits();
          }
        });
      };
    }
  ]);

}).call(this);
