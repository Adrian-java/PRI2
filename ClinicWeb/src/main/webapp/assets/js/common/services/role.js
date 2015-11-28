(function() {
  angular.module('clinic').service('Role', [
    '$http', '$cookies', function($http, $cookies) {
      var check, handleError, handleSuccess;
      check = function() {
        var login, request;
        login = $cookies.token.split(":")[0];
        console.log(login);
        request = $http({
          method: 'GET',
          url: "http://localhost:8080/rest/SystemUser/role/" + login,
          headers: {
            'XToken': $cookies.get('token'),
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      handleError = function(response) {
        if (!angular.isObject(response.data) || !response.data.message) {
          return console.log('An unknown error occurred.');
        }
      };
      handleSuccess = function(response) {
        console.log(response.data);
        return response.data;
      };
      return {
        check: check
      };
    }
  ]);

}).call(this);
