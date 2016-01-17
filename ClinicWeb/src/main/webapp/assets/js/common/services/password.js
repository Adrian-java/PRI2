(function() {
  angular.module('clinic').service('Password', [
    '$http', 'api', function($http, api) {
      var changePassword;
      changePassword = function(passData) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/pass/change',
          data: passData,
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
