(function() {
  angular.module('clinic').controller('AdminVisitsController', [
    '$scope', '$stateParams', 'Doctors', 'Patients', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', '$state', function($scope, $stateParams, Doctors, Patients, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal, $state) {
      var changeWeek, getAllDoctors, getWorkingTime, setCalendarWorkingTime;
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
            var doctor, i, len, ref, results;
            $scope.doctors = res.data;
            ref = $scope.doctors;
            results = [];
            for (i = 0, len = ref.length; i < len; i++) {
              doctor = ref[i];
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
        var date, i, len, ref, results;
        $scope.workingTimeEvents.length = 0;
        ref = $scope.workingTime;
        results = [];
        for (i = 0, len = ref.length; i < len; i++) {
          date = ref[i];
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
      return $scope.submit = function() {
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
    }
  ]);

}).call(this);
