angular.module('clinic').service 'Role', [ '$http', '$cookies', 'api', '$localStorage', ($http, $cookies, api, $localStorage) ->

  check = ->
    login = $localStorage.token.split(":")[0]
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/role/'+login
      headers: 'XToken': $localStorage.token, 'Content-Type': 'application/json')
    return request

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    response.data

  {
    check: check
  }
]
