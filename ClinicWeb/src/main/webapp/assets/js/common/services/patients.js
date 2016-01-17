(function() {
  angular.module('clinic').service('Patients', [
    '$http', '$cookies', 'api', '$localStorage', function($http, $cookies, api, $localStorage) {
      var create, edit, handleError, handleSuccess, index, remove, show;
      index = function() {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/patients/all',
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      create = function(user) {
        var request, userInfo;
        user.birthDate.monthId = Number(user.birthDate.monthId) < 10 ? '0' + user.birthDate.monthId : user.birthDate.monthId;
        user.birthDate.day = Number(user.birthDate.day) < 10 ? '0' + user.birthDate.day : user.birthDate.day;
        userInfo = {
          'password': user.password,
          'email': user.email,
          'id': user.pin,
          'patient': {
            'name': user.firstName,
            'surname': user.lastName,
            'dateOfBirth': user.birthDate.year + '-' + user.birthDate.monthId + '-' + user.birthDate.day,
            'phoneNr': user.phone,
            'address': {
              'city': user.city,
              'countryCode': user.countyCode,
              'province': user.province,
              'country': user.country,
              'countryCodeCity': user.countyCode,
              'street': user.street,
              'homeNr': user.home_nr
            }
          }
        };
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/newPatient',
          data: userInfo,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      show = function(id) {
        var request;
        request = $http({
          method: 'GET',
          url: api + 'SystemUser/patient/' + id,
          headers: {
            'XToken': $localStorage.token,
            'Content-Type': 'application/json'
          }
        });
        return request;
      };
      edit = function(id, patient) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'SystemUser/updatePatient/' + id,
          data: patient,
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
          url: api + 'SystemUser/patient/' + id,
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
        return console.log('doctor added');
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
