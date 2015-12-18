angular.module('clinic').service 'Visits', [ '$http', '$cookies', 'api', ($http, $cookies, api) ->

  create = (visit) ->
    console.log visit
    request = $http(
      method: 'POST'
      isArray: false
      url: api + 'Visit/new/'
      data: visit
      headers: 'XToken': $cookies.token, 'Content-Type': 'application/json')
    request.then handleSuccess, handleError

  handleError = (response) ->
    if !angular.isObject(response.data) or !response.data.message
      return console.log('An unknown error occurred.')
    return

  handleSuccess = (response) ->
    console.log response.data
    console.log 'visit added'

  {
    create: create
  }
]
