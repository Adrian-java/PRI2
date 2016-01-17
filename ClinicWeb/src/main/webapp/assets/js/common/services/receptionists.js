(function() {
  angular.module('clinic').service('Receptionists', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var create, edit, handleError, handleSuccess, index, remove, show;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'Receptionist/list',
          headers: {
            'XToken': $localStorage.token,
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
          url: api + 'SystemUser/newReceptionist',
          data: receptionist,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request.then(handleSuccess, handleError);
      };
      show = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/receptionist/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      edit = function(id, receptionist) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/updateReceptionist/' + id,
          data: receptionist,
          headers: {
            'XToken': $localStorage.token,
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
          url: api + 'SystemUser/receptionist/' + id,
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
        response.data;
        return console.log('receptionists added');
      };
      return {
        index: index,
        create: create,
        show: show,
        edit: edit,
        remove: remove
      };
    }
  ]);

}).call(this);
