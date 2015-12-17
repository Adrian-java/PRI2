(function() {
  angular.module('clinic').service('Doctors', [
    '$http', '$cookies', function($http, $cookies) {
      var create, handleError, handleSuccess, index, indexBySpeciality, show, takenVisitsTimeFrame, workingTime;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/SystemUser/doctors/all",
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      create = function(doctor) {
        var request;
        console.log($cookies.token);
        request = $http({
          method: 'POST',
          isArray: false,
          url: 'http://localhost:8080/rest/SystemUser/newDoctor',
          data: doctor,
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      show = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/SystemUser/doctor/" + id,
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      indexBySpeciality = function(speciality) {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/SystemUser/doctors/specialization/" + speciality,
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      workingTime = function(doctorId) {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/VisitScheduler/doctor/" + doctorId,
          headers: {
            'XToken': $cookies.token,
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
          url: "http://localhost:8080/rest/Visit/doctor/" + doctorId + "/date/" + startDate.day + "-" + startDate.month + "-" + startDate.year + "/" + endDate.day + "-" + endDate.month + "-" + endDate.year,
          headers: {
            'XToken': $cookies.token,
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
        indexBySpeciality: indexBySpeciality,
        workingTime: workingTime,
        takenVisitsTimeFrame: takenVisitsTimeFrame
      };
    }
  ]);

}).call(this);
