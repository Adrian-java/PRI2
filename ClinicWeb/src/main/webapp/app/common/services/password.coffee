angular.module 'clinic'
  .service 'Password', ['$http', 'api', ($http, api) ->

    changePassword = (passData) ->
      request = $http(
        method: 'POST'
        isArray: false
        url: api + 'SystemUser/pass/change'
        data: passData
        headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
      return request

    {
      changePassword: changePassword
    }
  ]
