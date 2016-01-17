(function() {
  angular.module('clinic').service('Role', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var check, handleError, handleSuccess;
      check = function() {
        var login, request;
        login = $localStorage.token.split(":")[0];
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
      handleError = function(response) {
        if (!angular.isObject(response.data) || !response.data.message) {
          return console.log('An unknown error occurred.');
        }
      };
      handleSuccess = function(response) {
        return response.data;
      };
      return {
        check: check
      };
    }
  ]);

}).call(this);
