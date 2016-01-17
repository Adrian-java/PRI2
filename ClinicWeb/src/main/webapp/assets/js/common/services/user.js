(function() {
  angular.module('clinic').service('Auth', [
    '$http', '$cookies', 'api', '$state', '$localStorage', function($http, $cookies, api, $state, $localStorage) {
      var handleError, handleLoginSuccess, handleSuccess, login, logout, register, validate;
      login = function(user) {
        var request;
        request = $http({
          method: 'POST',
          isArray: false,
          url: api + 'auth/token',
          data: $.param({
            username: user.login,
            password: user.password
          }),
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }
        });
        return request.then(handleLoginSuccess, handleError);
      };
      logout = function() {
        $localStorage.token = void 0;
        console.log('user logout success');
        return $state.go('home');
      };
      register = function(user) {
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
        return request.then(handleSuccess, handleError);
      };
      validate = function() {
        if ($localStorage.token) {
          return $localStorage.token.split(":")[0];
        } else {
          return false;
        }
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
      handleLoginSuccess = function(response) {
        $localStorage.token = response.data.token;
        return console.log($localStorage.token);
      };
      return {
        login: login,
        logout: logout,
        register: register,
        validate: validate
      };
    }
  ]);

}).call(this);
