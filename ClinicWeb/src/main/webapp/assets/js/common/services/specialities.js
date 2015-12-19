(function() {
  angular.module('clinic').service('Specialities', [
    '$http', 'api', function($http, api) {
      var getSpecialities, handleError, handleSuccess;
      getSpecialities = function() {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Specialization/list'
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
        return response.data;
      };
      return {
        getSpecialities: getSpecialities
      };
    }
  ]);

}).call(this);
