(function() {
  angular.module('clinic').service('Receptionists', [
    '$http', '$cookies', function($http, $cookies) {
      var create, handleError, handleSuccess, index, show;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/Receptionist/list",
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      create = function(receptionist) {
        var request;
        console.log($cookies.token);
        request = $http({
          method: 'POST',
          isArray: false,
          url: 'http://localhost:8080/rest/SystemUser/newReceptionist',
          data: receptionist,
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
          url: "http://localhost:8080/rest/SystemUser/receptionist/" + id,
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
        return console.log('receptionists added');
      };
      return {
        index: index,
        create: create,
        show: show
      };
    }
  ]);

}).call(this);
