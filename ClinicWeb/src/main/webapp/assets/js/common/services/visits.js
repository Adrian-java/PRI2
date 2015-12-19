(function() {
  angular.module('clinic').service('Visits', [
    '$http', '$cookies', 'api', function($http, $cookies, api) {
      var create, destroy, handleError, handleSuccess;
      create = function(visit) {
        var request;
        console.log(visit);
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'Visit/new/',
          data: visit,
          headers: {
            'XToken': $cookies.token,
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      destroy = function(visitId) {
        var request;
        console.log('visit id: ' + visitId);
        request = $http({
          method: 'DELETE',
          url: api + 'Visit/' + visitId,
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
        console.log(response.data);
        return console.log('visit added');
      };
      return {
        create: create,
        destroy: destroy
      };
    }
  ]);

}).call(this);
