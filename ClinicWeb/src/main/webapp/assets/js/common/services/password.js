(function() {
  angular.module('clinic').service('Password', [
    '$http', 'api', '$localStorage', function($http, api, $localStorage) {
      var changePassword;
      changePassword = function(password) {
        var request;
        password.id = $localStorage.token.split(":")[0];
        console.log(password);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/pass/change',
          data: password,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      return {
        changePassword: changePassword
      };
    }
  ]);

}).call(this);
