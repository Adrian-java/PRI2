angular.module 'clinic'
  .service 'Password', ['$http', 'api', '$localStorage', ($http, api, $localStorage) ->

    changePassword = (password) ->
      password.id = $localStorage.token.split(":")[0]
      console.log password
      request = $http(
        method: 'POST'
        isArray: false
        url: api + 'SystemUser/pass/change'
        data: password
        headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
      return request

    {
      changePassword: changePassword
    }
  ]
