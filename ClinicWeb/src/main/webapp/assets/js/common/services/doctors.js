(function() {
  angular.module('clinic').service('Doctors', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var addWorkingHours, create, getDoctorSpeciality, handleError, handleSuccess, index, indexBySpeciality, indexDoctorsVisits, remove, show, takenVisitsTimeFrame, update, workingTime;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/doctors/all',
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      create = function(doctor) {
        var request;
        console.log('new doctor');
        console.log(doctor);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/newDoctor',
          data: doctor,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      show = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/doctor/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      update = function(id, doctor) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/updateDoctor/' + id,
          data: doctor,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      indexBySpeciality = function(speciality) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/doctors/specialization/' + speciality,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      workingTime = function(doctorId) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'VisitScheduler/doctor/' + doctorId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      takenVisitsTimeFrame = function(doctorId, start, end) {
        var endDate, request, startDate;
        startDate = {};
        endDate = {};
        startDate.day = start.getDate() < 10 ? '0' + (start.getDate()) : start.getDate();
        startDate.month = start.getMonth() < 10 ? '0' + (start.getMonth() + 1) : start.getMonth() + 1;
        startDate.year = start.getUTCFullYear();
        endDate.day = end.getDate() < 10 ? '0' + (end.getDate()) : end.getDate();
        endDate.month = end.getMonth() < 10 ? '0' + (end.getMonth() + 1) : end.getMonth() + 1;
        endDate.year = end.getUTCFullYear();
        request = $http({
          method: 'GET',
          url: api + 'Visit/doctor/' + doctorId + "/date/" + startDate.day + "-" + startDate.month + "-" + startDate.year + "/" + endDate.day + "-" + endDate.month + "-" + endDate.year,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      indexDoctorsVisits = function(doctorId, start, end) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Visit/doctor/' + doctorId + '/date/' + start + '/' + end,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      remove = function(id) {
        var request;
        console.log(id);
        request = $http({
          method: 'DELETE',
          url: api + 'SystemUser/doctor/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      addWorkingHours = function(workingHours) {
        var request;
        console.log(workingHours);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'VisitScheduler/scheduler/add',
          data: workingHours,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      getDoctorSpeciality = function(doctorId) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Specialization/doctor/' + doctorId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      handleError = function(response) {
        if (!angular.isObject(response.data) || !response.data.message) {
          return console.log('An unknown error occurred.');
        }
      };
      handleSuccess = function(response) {
        response.data;
        return console.log('doctor added');
      };
      return {
        index: index,
        create: create,
        show: show,
        update: update,
        indexBySpeciality: indexBySpeciality,
        workingTime: workingTime,
        takenVisitsTimeFrame: takenVisitsTimeFrame,
        remove: remove,
        addWorkingHours: addWorkingHours,
        indexDoctorsVisits: indexDoctorsVisits,
        getDoctorSpeciality: getDoctorSpeciality
      };
    }
  ]);

}).call(this);
