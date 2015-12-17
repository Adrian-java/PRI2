angular.module('clinic').service 'Visits', [ '$http', '$cookies', ($http, $cookies) ->

  create = (visit) ->
    console.log visit
    request = $http(
      method: 'POST'
      isArray: false
      url: 'http://localhost:8080/rest/Visit/new/'
      data: visit
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    response.data
    console.log 'doctor added'

  {
    create: create
  }
]
