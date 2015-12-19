(function() {
  angular.module('clinic').service('Patients', [
    '$http', '$cookies', 'api', function($http, $cookies, api) {
      var edit, handleError, handleSuccess, index, remove, show;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/patients/all',
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      show = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/patient/' + id,
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      edit = function(id, patient) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/updatePatient/' + id,
          data: patient,
          headers: {
            'XToken': $cookies.token,
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
          url: api + 'SystemUser/patient/' + id,
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
        show: show,
        edit: edit,
        remove: remove
      };
    }
  ]);

}).call(this);
