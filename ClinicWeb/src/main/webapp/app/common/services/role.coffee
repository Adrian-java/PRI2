angular.module('clinic').service 'Role', [ '$http', '$cookies', ($http, $cookies) ->

  check = ->
    login = $cookies.token.split(":")[0]
    console.log login
    request = $http(
      method: 'GET'
      url: "http://localhost:8080/rest/SystemUser/role/"+login
      headers: 'XToken': $cookies.get('token'), 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    console.log response.data
    response.data

  {
    check: check
  }
]
