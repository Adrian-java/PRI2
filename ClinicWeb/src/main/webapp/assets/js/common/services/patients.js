(function() {
  angular.module('clinic').service('Patients', [
    '$http', '$cookies', function($http, $cookies) {
      var handleError, handleSuccess, index, show;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/SystemUser/patients/all",
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
          url: "http://localhost:8080/rest/SystemUser/patient/" + id,
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
        show: show
      };
    }
  ]);

}).call(this);
