angular.module('clinic').service 'Role', [ '$http', '$cookies', 'api', ($http, $cookies, api) ->

  check = ->
    login = $cookies.token.split(":")[0]
    request = $http(
      method: 'GET'
      url: api + 'SystemUser/role/'+login
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    #request.then handleSuccess, handleError
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
