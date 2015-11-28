(function() {
  angular.module('clinic').service('Specialities', function($http) {
    var getSpecialities, handleError, handleSuccess;
    getSpecialities = function() {
      var request;
      request = $http({
        method: 'get',
        url: 'http://localhost:8080/rest/Specialization/list',
        params: {
          action: 'get'
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
      getSpecialities: getSpecialities
    };
  });

}).call(this);
