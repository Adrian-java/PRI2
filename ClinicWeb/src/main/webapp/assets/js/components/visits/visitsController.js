(function() {
  angular.module('clinic').controller('VisitsController', [
    '$scope', '$stateParams', 'Doctors', '$compile', 'uiCalendarConfig', '$timeout', 'Specialities', 'Visits', 'Auth', '$uibModal', function($scope, $stateParams, Doctors, $compile, uiCalendarConfig, $timeout, Specialities, Visits, Auth, $uibModal) {
      var changeWeek, getAllDoctors, getStateParams, getWorkingTime, setCalendarWorkingTime;
      $scope.workingTime = [];
      Specialities.getSpecialities().then(function(res) {
        return $scope.specialities = res.data;
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
      getStateParams = function() {
        if ($stateParams.speciality) {
          $scope.selectedSpeciality = $stateParams.speciality;
          $scope.updateDoctorsList();
        }
        if ($stateParams.doctor) {
          $scope.selectedDoctorId = $stateParams.doctor;
        }
        if ($stateParams.date) {
          return $scope.selectedDate = $stateParams.date;
        }
      };
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
      getStateParams();
      $scope.$watch('selectedDoctor', function() {
        if ($scope.selectedDoctor) {
          return getWorkingTime();
        }
      });
      $scope.changeTo = 'Hungarian';

      /* alert on eventClick */
      $scope.alertOnEventClick = function(date, jsEvent, view) {
        $scope.alertMessage = date.title + ' was clicked ';
      };
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
          viewRender: changeWeek,
          defaultDate: $scope.selectedDate ? new Date($scope.selectedDate) : new Date()
        }

        /*$timeout( ->
          $scope.uiConfig.calendar.slotDuration = '00:30:00'
          #$scope.renderCalender()
        , 5000)
         */
      };
      $scope.changeLang = function() {
        if ($scope.changeTo === 'Hungarian') {
          $scope.uiConfig.calendar.dayNames = ['Vasárnap', 'Hétfő', 'Kedd', 'Szerda', 'Csütörtök', 'Péntek', 'Szombat'];
          $scope.uiConfig.calendar.dayNamesShort = ['Vas', 'Hét', 'Kedd', 'Sze', 'Csüt', 'Pén', 'Szo'];
          $scope.changeTo = 'English';
        } else {
          $scope.uiConfig.calendar.dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
          $scope.uiConfig.calendar.dayNamesShort = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
          $scope.changeTo = 'Hungarian';
        }
      };

      /* event sources array */
      $scope.eventSources = [$scope.workingTimeEvents];
      return $scope.submit = function() {
        var login, modalInstance, visit;
        login = Auth.validate();
        if (login) {
          visit = {};
          visit.patientId = login;
          visit.date = $scope.selectedVisitDate.getTime() / 1000;
          visit.idDoctor = $scope.selectedDoctorId;
          visit.typeOfVisit = 'Dermatolog';
          console.log(visit);
          return Visits.create(visit).then(function(res) {
            return console.log(res);
          });
        } else {
          modalInstance = $uibModal.open({
            animation: true,
            templateUrl: '/app/components/login/login_modal.html',
            controller: 'LoginController'
          });
          return modalInstance.result.then(function(user) {
            return console.log(user);
          });
        }
      };
    }
  ]);

}).call(this);
