(function() {
  angular.module('clinic').service('Visits', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var check, create, edit, getPatientDoneVisits, getPatientPlannedVisits, handleError, handleSuccess, indexByDate, remove, show, showDone, showPlanned;
      indexByDate = function(startDate, endDate) {
        var request;
        console.log('dates');
        console.log(startDate);
        console.log(endDate);
        request = $http({
          method: 'GET',
          url: api + 'Visit/all/date/' + startDate + '/' + endDate,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      check = function() {
        var login, request;
        login = $cookies.token.split(":")[0];
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/role/' + login,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      create = function(visit) {
        var request;
        console.log(visit);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'Visit/new/',
          data: visit,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      edit = function(visit) {
        var request;
        console.log(visit);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'Visit/edit',
          data: visit,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      show = function(visitId) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Visit/info/' + visitId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      showDone = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Visit/patient/done/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      showPlanned = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Visit/patient/plane/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      remove = function(visitId) {
        var request;
        console.log('visit id: ' + visitId);
        request = $http({
          method: 'DELETE',
          url: api + 'Visit/' + visitId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      getPatientPlannedVisits = function(patientId) {
        var request;
        if (!patientId) {
          patientId = $localStorage.token.split(":")[0];
        }
        return request = $http({
          method: 'GET',
          url: api + 'Visit/patient/plane/' + patientId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
      };
      getPatientDoneVisits = function(patientId) {
        var request;
        if (!patientId) {
          patientId = $localStorage.token.split(":")[0];
        }
        return request = $http({
          method: 'GET',
          url: api + 'Visit/patient/done/' + patientId,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
      };
      handleError = function(response) {
        if (!angular.isObject(response.data) || !response.data.message) {
          return console.log('An unknown error occurred.');
        }
      };
      handleSuccess = function(response) {
        console.log(response.data);
        return console.log('visit added');
      };
      return {
        create: create,
        remove: remove,
        show: show,
        edit: edit,
        showDone: showDone,
        showPlanned: showPlanned,
        indexByDate: indexByDate,
        getPatientPlannedVisits: getPatientPlannedVisits,
        getPatientDoneVisits: getPatientDoneVisits
      };
    }
  ]);

}).call(this);
